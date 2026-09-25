package com.bajaj.rideconnect.re

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.BatteryManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.telephony.PhoneStateListener
import android.telephony.SignalStrength
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import android.annotation.TargetApi

class PhoneStateMonitor(
    context: Context,
    private val bleManager: PulsarBleManager,
    private val callHandler: TelephonyCallHandler?
) {

    private val context: Context = context.applicationContext
    private val handler = Handler(Looper.getMainLooper())

    var batteryPercent: Int = -1
        private set
    var signalBars: Int = -1
        private set

    private var isRunning = false
    private var batteryReceiverRegistered = false

    private val batteryReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent ?: return
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            if (level >= 0 && scale > 0) {
                batteryPercent = ((level / scale.toFloat()) * 100).toInt()
                broadcastTelemetry()
            }
        }
    }

    private fun broadcastTelemetry() {
        val intent = Intent(ACTION_TELEMETRY_UPDATE).apply {
            `package` = context.packageName
            putExtra("battery", batteryPercent)
            putExtra("signal", signalBars)
        }
        context.sendBroadcast(intent)
    }

    private fun isHeadsetConnected(): Boolean {
        try {
            val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager ?: return false
            val devices = am.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
            for (dev in devices) {
                when (dev.type) {
                    AudioDeviceInfo.TYPE_WIRED_HEADSET,
                    AudioDeviceInfo.TYPE_WIRED_HEADPHONES,
                    AudioDeviceInfo.TYPE_BLUETOOTH_A2DP,
                    AudioDeviceInfo.TYPE_BLUETOOTH_SCO,
                    AudioDeviceInfo.TYPE_BLE_HEADSET,
                    AudioDeviceInfo.TYPE_BLE_SPEAKER -> return true
                }
            }
        } catch (ignored: Exception) {}
        return false
    }

    private val heartbeatRunnable: Runnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                broadcastTelemetry()
                if (bleManager.isConnected) {
                    val rawState = callHandler?.currentCallState ?: 0
                    val callState = when (rawState) {
                        TelephonyManager.CALL_STATE_RINGING -> 1
                        TelephonyManager.CALL_STATE_OFFHOOK -> 3
                        else -> 0
                    }
                    val caller = callHandler?.activeCaller.orEmpty()
                    val unreadMessages = PulsarNotificationService.getUnreadMessageCount()

                    val media = MediaStateListener.instance
                    val vol = media?.getCurrentVolumeTenths() ?: 5
                    val isHeadset = isHeadsetConnected()

                    bleManager.sendTelemetry(
                        if (batteryPercent >= 0) batteryPercent else 85,
                        if (signalBars >= 0) signalBars else 4,
                        callState,
                        caller,
                        0,
                        unreadMessages,
                        vol,
                        isHeadset
                    )
                }
                handler.postDelayed(this, 4000)
            }
        }
    }

    fun triggerImmediateUpdate() {
        handler.removeCallbacks(heartbeatRunnable)
        handler.post(heartbeatRunnable)
    }

    init {
        instance = this
        initBatteryListener()
        initSignalListener()
    }

    @Synchronized
    private fun initBatteryListener() {
        if (!batteryReceiverRegistered) {
            val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            val sticky = context.registerReceiver(batteryReceiver, filter)
            batteryReceiverRegistered = true
            if (sticky != null) {
                val level = sticky.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = sticky.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                if (level >= 0 && scale > 0) {
                    batteryPercent = ((level / scale.toFloat()) * 100).toInt()
                    broadcastTelemetry()
                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.S)
    private class SignalStrengthCallback(
        private val monitor: PhoneStateMonitor
    ) : TelephonyCallback(), TelephonyCallback.SignalStrengthsListener {
        override fun onSignalStrengthsChanged(signalStrength: SignalStrength) {
            monitor.signalBars = signalStrength.level
            monitor.broadcastTelemetry()
        }
    }

    private fun initSignalListener() {
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager ?: return
        if (context.checkSelfPermission(android.Manifest.permission.READ_PHONE_STATE) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            return
        }

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                tm.registerTelephonyCallback(context.mainExecutor, SignalStrengthCallback(this))
            } else {
                tm.listen(object : PhoneStateListener() {
                    @Deprecated("Deprecated in Java")
                    override fun onSignalStrengthsChanged(signalStrength: SignalStrength?) {
                        signalStrength?.let {
                            signalBars = it.level
                            broadcastTelemetry()
                        }
                    }
                }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
            }
        } catch (ignored: SecurityException) {}
    }

    @Synchronized
    fun start() {
        if (!isRunning) {
            isRunning = true
            initBatteryListener()
            handler.post(heartbeatRunnable)
            Log.i(TAG, "Phone State Telemetry Monitor Started.")
        }
    }

    @Synchronized
    fun stop() {
        isRunning = false
        handler.removeCallbacks(heartbeatRunnable)
        if (batteryReceiverRegistered) {
            try {
                context.unregisterReceiver(batteryReceiver)
            } catch (ignored: Exception) {}
            batteryReceiverRegistered = false
        }
        Log.i(TAG, "Phone State Telemetry Monitor Stopped.")
    }

    companion object {
        private const val TAG = "PhoneStateMonitor"
        const val ACTION_TELEMETRY_UPDATE: String = "com.bajaj.rideconnect.re.TELEMETRY_UPDATE"

        @Volatile
        @JvmStatic
        var instance: PhoneStateMonitor? = null
            private set


    }
}
