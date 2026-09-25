package com.bajaj.rideconnect.re

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import android.util.Log

class PulsarForegroundService : Service(), PulsarBleManager.BleListener {

    private var bleManager: PulsarBleManager? = null
    var mediaListener: MediaStateListener? = null
        private set
    private var callHandler: TelephonyCallHandler? = null
    private var phoneMonitor: PhoneStateMonitor? = null

    private var isConnected = false
    private var activeManeuver = "Navigation Idle"
    private var activeStreet = "--"

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.i(TAG, "PulsarForegroundService onCreate()")

        createNotificationChannel()
        startForegroundWithNotification("Initializing Pulsar Connect...", "Connecting to NS400Z Cluster...")

        val ble = PulsarBleManager.getInstance(this)
        this.bleManager = ble
        ble.addListener(this)

        val media = MediaStateListener(this, ble)
        this.mediaListener = media
        val call = TelephonyCallHandler(this, ble)
        this.callHandler = call
        val monitor = PhoneStateMonitor(this, ble, call)
        this.phoneMonitor = monitor
        monitor.start()

        ble.startScanOrConnect()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        if (action != null) {
            when (action) {
                ACTION_STOP -> {
                    bleManager?.apply {
                        setAutoReconnect(false)
                        stopScan()
                        disconnect()
                    }
                    phoneMonitor?.stop()
                    val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
                    nm?.apply {
                        cancel(NOTIFICATION_ID)
                        cancelAll()
                    }
                    stopForeground(STOP_FOREGROUND_REMOVE)
                    stopSelf()
                    return START_NOT_STICKY
                }
                ACTION_CONNECT -> {
                    bleManager?.startScanOrConnect()
                }
            }
        }
        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Pulsar NS400Z Live Service",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Background Bluetooth Link and Real-time Navigation Stream"
                setShowBadge(false)
            }
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            nm?.createNotificationChannel(channel)
        }
    }

    private fun startForegroundWithNotification(title: String, content: String) {
        val notification = buildNotification(title, content)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            startForeground(NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE)
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    private fun buildNotification(title: String, content: String): Notification {
        val launchIntent = Intent(this, MainActivity::class.java)
        val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        val pi = PendingIntent.getActivity(this, 0, launchIntent, flags)

        val builder = Notification.Builder(this, CHANNEL_ID)

        builder.setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(android.R.drawable.ic_dialog_map)
            .setContentIntent(pi)
            .setOngoing(true)

        return builder.build()
    }

    private fun updateNotification() {
        val title = if (isConnected) "Pulsar NS400Z: Connected" else "Pulsar NS400Z: Disconnected"
        var content = "Nav: $activeManeuver ($activeStreet)"
        if (mediaListener?.isPlaying == true) {
            content += " | ♫ ${mediaListener?.currentTitle}"
        }

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        nm?.notify(NOTIFICATION_ID, buildNotification(title, content))
    }

    fun updateNavStatus(maneuver: String, street: String) {
        this.activeManeuver = maneuver
        this.activeStreet = street
        updateNotification()
    }

    override fun onConnectionStateChanged(connected: Boolean, deviceName: String, deviceAddress: String) {
        this.isConnected = connected
        updateNotification()

        if (connected) {
            mediaListener?.syncMetadata()
        }
    }

    override fun onPacketSent(charUuid: String, frame: ByteArray?, success: Boolean) {
        // Telemetry/TBT dispatched
    }

    override fun onHandlebarEvent(event: PulsarProtocol.HandlebarEvent) {
        Log.i(TAG, "Handlebar switch event received from cluster!")
        mediaListener?.handleHandlebarMedia(event)
        callHandler?.handleHandlebarCallAction(event)
    }

    fun refreshMediaSessions() {
        mediaListener?.initMediaSessions()
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
        Log.i(TAG, "PulsarForegroundService onDestroy()")
        phoneMonitor?.stop()
        bleManager?.apply {
            removeListener(this@PulsarForegroundService)
            setAutoReconnect(false)
            stopScan()
            disconnect()
        }
        try {
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            nm?.cancel(NOTIFICATION_ID)
            nm?.cancelAll()
        } catch (ignored: Exception) {}
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        private const val TAG = "PulsarForegroundService"
        const val CHANNEL_ID: String = "pulsar_connect_live_channel"
        const val NOTIFICATION_ID: Int = 4001

        const val ACTION_START: String = "com.bajaj.rideconnect.re.START_SERVICE"
        const val ACTION_STOP: String = "com.bajaj.rideconnect.re.STOP_SERVICE"
        const val ACTION_CONNECT: String = "com.bajaj.rideconnect.re.CONNECT_BLE"

        @Volatile
        @JvmStatic
        var instance: PulsarForegroundService? = null
            private set

        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, PulsarForegroundService::class.java).apply {
                action = ACTION_START
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
    }
}
