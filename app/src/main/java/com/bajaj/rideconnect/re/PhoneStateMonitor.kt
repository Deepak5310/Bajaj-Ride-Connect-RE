package com.bajaj.rideconnect.re

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.ContentObserver
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.BatteryManager
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.content.ContextCompat

class PhoneStateMonitor(
    context: Context,
    private val bleManager: PulsarBleManager,
    private val mediaStateListener: MediaStateListener
) {

    private val context: Context = context.applicationContext
    private val handler = Handler(Looper.getMainLooper())

    var batteryPercent: Int = -1
        private set
    var signalBars: Int = 0
        private set

    private var isRunning = false
    private var stateReceiverRegistered = false
    private var volumeObserver: ContentObserver? = null

    private val stateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent ?: return
            when (intent.action) {
                Intent.ACTION_BATTERY_CHANGED -> {
                    val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    val parsed = parseBatteryPercent(level, scale)
                    if (parsed >= 0) batteryPercent = parsed
                }

                Intent.ACTION_AIRPLANE_MODE_CHANGED, ACTION_SIM_STATE_CHANGED -> {
                    signalBars = readCurrentSignalBars()
                }
            }
            triggerImmediateUpdate()
        }
    }

    private fun parseBatteryPercent(level: Int, scale: Int): Int = if (level >= 0 && scale > 0) {
        ((level / scale.toFloat()) * 100).toInt().coerceIn(0, 100)
    } else {
        -1
    }

    private fun readDirectBatteryPercent(): Int {
        try {
            val bm = context.getSystemService(Context.BATTERY_SERVICE) as? BatteryManager
            val capacity = bm?.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY) ?: -1
            if (capacity in 0..100) return capacity
        } catch (_: Exception) {
        }
        return 85
    }

    private fun readCurrentSignalBars(): Int {
        try {
            val isAirplaneMode = Settings.Global.getInt(
                context.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0
            ) != 0
            if (isAirplaneMode) return 0

            val tm =
                context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager ?: return 0
            val state = tm.simState
            if (state != TelephonyManager.SIM_STATE_READY) {
                return 0
            }

            try {
                val signalStrength = tm.signalStrength
                if (signalStrength != null) {
                    val level = signalStrength.level
                    if (level in 0..4) return level
                }
            } catch (_: Exception) {
            }

            return 3
        } catch (_: Exception) {
            return 0
        }
    }

    private fun isHeadsetConnected(): Boolean {
        try {
            val am =
                context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return false
            val devices = am.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
            return devices.any { it.type in HEADSET_TYPES }
        } catch (_: Exception) {
            return false
        }
    }

    private fun dispatchTelemetry(volumeLevel: Int = mediaStateListener.getCurrentVolumeTenths()) {
        if (!bleManager.connectionState.value.isConnected) return
        val currentBattery = if (batteryPercent >= 0) batteryPercent else readDirectBatteryPercent()
        signalBars = readCurrentSignalBars()
        val isHeadset = isHeadsetConnected()

        bleManager.sendTelemetry(
            batteryPercent = currentBattery,
            signalBars = signalBars,
            callState = 0,
            callerNameOrNumber = null,
            missedCalls = 0,
            unreadSms = 0,
            volumeLevel = volumeLevel.coerceIn(0, 10),
            isHeadset = isHeadset
        )
    }

    private val heartbeatRunnable: Runnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                dispatchTelemetry()
                handler.postDelayed(this, 4000L)
            }
        }
    }

    fun triggerImmediateUpdate() {
        handler.removeCallbacks(heartbeatRunnable)
        handler.post(heartbeatRunnable)
    }

    fun sendImmediateVolumeTelemetry(volLevel: Int) {
        dispatchTelemetry(volLevel)
    }

    init {
        initStateReceiver()
        registerVolumeObserver()
    }

    @Synchronized
    private fun initStateReceiver() {
        if (!stateReceiverRegistered) {
            val filter = IntentFilter().apply {
                addAction(Intent.ACTION_BATTERY_CHANGED)
                addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
                addAction(ACTION_SIM_STATE_CHANGED)
            }
            val sticky = ContextCompat.registerReceiver(
                context, stateReceiver, filter, ContextCompat.RECEIVER_EXPORTED
            )
            stateReceiverRegistered = true
            if (sticky != null) {
                val level = sticky.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = sticky.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                val parsed = parseBatteryPercent(level, scale)
                if (parsed >= 0) batteryPercent = parsed
            }
            if (batteryPercent < 0) {
                batteryPercent = readDirectBatteryPercent()
            }
            signalBars = readCurrentSignalBars()
        }
    }

    private fun registerVolumeObserver() {
        if (volumeObserver == null) {
            val observer = object : ContentObserver(handler) {
                override fun onChange(selfChange: Boolean) {
                    super.onChange(selfChange)
                    mediaStateListener.syncPhoneVolume()
                    triggerImmediateUpdate()
                }
            }
            volumeObserver = observer
            try {
                context.contentResolver.registerContentObserver(
                    Settings.System.CONTENT_URI, true, observer
                )
            } catch (e: Exception) {
                Log.w(TAG, "Could not register volume ContentObserver: ${e.message}")
            }
        }
    }

    @Synchronized
    fun start() {
        if (!isRunning) {
            isRunning = true
            initStateReceiver()
            registerVolumeObserver()
            signalBars = readCurrentSignalBars()
            triggerImmediateUpdate()
            Log.i(TAG, "PhoneStateMonitor started (battery=$batteryPercent%, signal=$signalBars)")
        }
    }

    @Synchronized
    fun stop() {
        isRunning = false
        handler.removeCallbacks(heartbeatRunnable)
        if (stateReceiverRegistered) {
            try {
                context.unregisterReceiver(stateReceiver)
            } catch (_: Exception) {
            }
            stateReceiverRegistered = false
        }
        volumeObserver?.let {
            try {
                context.contentResolver.unregisterContentObserver(it)
            } catch (_: Exception) {
            }
            volumeObserver = null
        }
        Log.i(TAG, "PhoneStateMonitor stopped.")
    }

    companion object {
        private const val TAG = "PhoneStateMonitor"
        private const val ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED"
        private const val TYPE_BLE_HEADSET = 26
        private const val TYPE_BLE_SPEAKER = 27

        private val HEADSET_TYPES = setOf(
            AudioDeviceInfo.TYPE_WIRED_HEADSET,
            AudioDeviceInfo.TYPE_WIRED_HEADPHONES,
            AudioDeviceInfo.TYPE_BLUETOOTH_A2DP,
            AudioDeviceInfo.TYPE_BLUETOOTH_SCO,
            AudioDeviceInfo.TYPE_USB_HEADSET,
            TYPE_BLE_HEADSET,
            TYPE_BLE_SPEAKER
        )
    }
}