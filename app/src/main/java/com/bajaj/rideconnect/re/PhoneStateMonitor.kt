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

    val signalBars: Int = DUMMY_SIGNAL_BARS

    private var isRunning = false
    private var stateReceiverRegistered = false
    private var volumeObserver: ContentObserver? = null

    private val stateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent ?: return
            if (intent.action == Intent.ACTION_BATTERY_CHANGED) {
                val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                val parsed = parseBatteryPercent(level, scale)
                if (parsed >= 0) batteryPercent = parsed
                triggerImmediateUpdate()
            }
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

    private fun dispatchTelemetry(volumeLevel: Int = mediaStateListener.activeVolumeLevel) {
        if (!bleManager.connectionState.value.isConnected) return
        val currentBattery = if (batteryPercent >= 0) batteryPercent else readDirectBatteryPercent()
        val isHeadset = isHeadsetConnected()

        bleManager.sendTelemetry(
            batteryPercent = currentBattery,
            signalBars = DUMMY_SIGNAL_BARS,
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

    @Synchronized
    private fun initStateReceiver() {
        if (!stateReceiverRegistered) {
            val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
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
        }
    }

    private fun registerVolumeObserver() {
        if (volumeObserver == null) {
            val observer = object : ContentObserver(handler) {
                override fun onChange(selfChange: Boolean) {
                    super.onChange(selfChange)
                    mediaStateListener.onSystemVolumeChanged()
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
            triggerImmediateUpdate()
            Log.i(
                TAG,
                "PhoneStateMonitor started (battery=$batteryPercent%, dummySignal=$DUMMY_SIGNAL_BARS)"
            )
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
        const val DUMMY_SIGNAL_BARS = 4

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