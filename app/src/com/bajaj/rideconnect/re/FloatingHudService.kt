package com.bajaj.rideconnect.re

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.GradientDrawable
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.media.session.PlaybackState
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.abs
import kotlin.math.roundToInt

class FloatingHudService : Service(), PulsarBleManager.BleListener, LocationListener, MediaStateListener.MediaObserver {

    private var windowManager: WindowManager? = null
    private var hudRootView: View? = null
    private var hudParams: WindowManager.LayoutParams? = null

    private var pillContainer: View? = null
    private var dockContainer: View? = null

    private var ivPillBleStatusDot: View? = null
    private var tvPillSpeed: TextView? = null
    private var ivPillPlayPause: ImageView? = null

    private var ivDockBleStatusDot: View? = null
    private var tvDockBikeName: TextView? = null
    private var tvDockBleStatus: TextView? = null
    private var tvDockSpeed: TextView? = null
    private var btnDockBleAction: TextView? = null
    private var tvDockSongTitle: TextView? = null
    private var tvDockArtist: TextView? = null
    private var btnDockPlayPause: ImageView? = null

    private var bleManager: PulsarBleManager? = null
    private var locationManager: LocationManager? = null

    private var initialY = 0
    private var initialTouchY = 0f
    private var isDragging = false

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        isRunning = true

        startServiceForeground()
        initBle()
        initGps()
        initOverlayWindow()
        MediaStateListener.instance?.registerObserver(this)
    }

    private fun startServiceForeground() {
        val channelId = "pulsar_hud_channel"
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && nm != null) {
            val channel = NotificationChannel(
                channelId,
                "Pulsar Co-Pilot HUD",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Active floating HUD over Google Maps"
                setShowBadge(false)
            }
            nm.createNotificationChannel(channel)
        }

        val launchIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            launchIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = Notification.Builder(this, channelId)
            .setContentTitle("Pulsar Co-Pilot Active")
            .setContentText("HUD docked over Google Maps")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE)
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    private fun initBle() {
        val ble = PulsarBleManager.getInstance(this)
        this.bleManager = ble
        ble.addListener(this)
    }

    private fun initGps() {
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
            try {
                val lm = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
                this.locationManager = lm
                lm?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f, this)
            } catch (e: Exception) {
                Log.w(TAG, "Failed to register GPS updates: ${e.message}")
            }
        }
    }

    private fun initOverlayWindow() {
        val wm = getSystemService(Context.WINDOW_SERVICE) as? WindowManager ?: return
        this.windowManager = wm

        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.layout_floating_hud, null)
        this.hudRootView = view

        val layoutType = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            layoutType,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.START or Gravity.CENTER_VERTICAL
            x = 0
            y = 0
        }
        this.hudParams = params

        bindViews(view)
        setupInteractions(view, params)
        refreshBleUi()
        refreshMediaUi()

        wm.addView(view, params)
    }

    private fun bindViews(root: View) {
        pillContainer = root.findViewById(R.id.hudPillContainer)
        dockContainer = root.findViewById(R.id.hudDockContainer)

        ivPillBleStatusDot = root.findViewById(R.id.ivPillBleStatusDot)
        tvPillSpeed = root.findViewById(R.id.tvPillSpeed)
        ivPillPlayPause = root.findViewById(R.id.ivPillPlayPause)

        ivDockBleStatusDot = root.findViewById(R.id.ivDockBleStatusDot)
        tvDockBikeName = root.findViewById(R.id.tvDockBikeName)
        tvDockBleStatus = root.findViewById(R.id.tvDockBleStatus)
        tvDockSpeed = root.findViewById(R.id.tvDockSpeed)
        btnDockBleAction = root.findViewById(R.id.btnDockBleAction)
        tvDockSongTitle = root.findViewById(R.id.tvDockSongTitle)
        tvDockArtist = root.findViewById(R.id.tvDockArtist)
        btnDockPlayPause = root.findViewById(R.id.btnDockPlayPause)
    }

    private fun setupInteractions(root: View, params: WindowManager.LayoutParams) {
        val pill = pillContainer ?: return

        pill.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialY = params.y
                    initialTouchY = event.rawY
                    isDragging = false
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaY = (event.rawY - initialTouchY).toInt()
                    if (abs(deltaY) > 8) {
                        isDragging = true
                        params.y = initialY + deltaY
                        windowManager?.updateViewLayout(root, params)
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    if (!isDragging) {
                        expandDock()
                    }
                    true
                }
                else -> false
            }
        }

        root.findViewById<View>(R.id.btnDockCollapse)?.setOnClickListener {
            collapseDock()
        }

        ivPillPlayPause?.setOnClickListener {
            togglePlayPause()
        }

        btnDockPlayPause?.setOnClickListener {
            togglePlayPause()
        }

        root.findViewById<View>(R.id.btnDockPrev)?.setOnClickListener {
            skipPrevious()
        }

        root.findViewById<View>(R.id.btnDockNext)?.setOnClickListener {
            skipNext()
        }

        btnDockBleAction?.setOnClickListener {
            val ble = bleManager ?: return@setOnClickListener
            if (ble.isConnected) {
                ble.setAutoReconnect(false)
                ble.disconnect()
            } else {
                ble.setAutoReconnect(true)
                ble.startScanOrConnect()
            }
        }

        root.findViewById<View>(R.id.btnDockMaps)?.setOnClickListener {
            launchGoogleMaps()
        }

        root.findViewById<View>(R.id.btnDockDismiss)?.setOnClickListener {
            stopSelf()
        }
    }

    private fun expandDock() {
        pillContainer?.visibility = View.GONE
        dockContainer?.visibility = View.VISIBLE
        hudRootView?.let { windowManager?.updateViewLayout(it, hudParams) }
    }

    private fun collapseDock() {
        dockContainer?.visibility = View.GONE
        pillContainer?.visibility = View.VISIBLE
        hudRootView?.let { windowManager?.updateViewLayout(it, hudParams) }
    }

    private fun togglePlayPause() {
        MediaStateListener.instance?.togglePlayPause()
        refreshMediaUi()
    }

    private fun skipNext() {
        MediaStateListener.instance?.skipNext()
        refreshMediaUi()
    }

    private fun skipPrevious() {
        MediaStateListener.instance?.skipPrevious()
        refreshMediaUi()
    }

    private fun launchGoogleMaps() {
        try {
            val mapsIntent = packageManager.getLaunchIntentForPackage("com.google.android.apps.maps")
            if (mapsIntent != null) {
                mapsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(mapsIntent)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed to launch Google Maps: ${e.message}")
        }
    }

    fun updateMediaInfo(title: String, artist: String, isPlaying: Boolean) {
        tvDockSongTitle?.text = if (title.isBlank()) getString(R.string.media_no_music) else title
        tvDockArtist?.text = if (artist.isBlank()) getString(R.string.media_launch_hint) else artist

        val iconRes = if (isPlaying) R.drawable.ic_media_pause else R.drawable.ic_media_play
        ivPillPlayPause?.setImageResource(iconRes)
        btnDockPlayPause?.setImageResource(iconRes)
    }

    private fun refreshMediaUi() {
        val media = MediaStateListener.instance
        if (media != null) {
            updateMediaInfo(media.currentTitle, media.currentArtist, media.isPlaying)
        }
    }

    override fun onMediaUpdated(
        title: String,
        artist: String,
        album: String,
        source: String,
        playbackState: Int,
        posSec: Int,
        durSec: Int,
        artwork: Bitmap?
    ) {
        hudRootView?.post {
            val isPlaying = (playbackState == PlaybackState.STATE_PLAYING || playbackState == 2)
            updateMediaInfo(title, artist, isPlaying)
        }
    }

    private fun refreshBleUi() {
        val ble = bleManager ?: return

        val (colorRes, statusText, actionText) = when {
            ble.isConnected -> Triple(
                R.color.pulsar_green,
                if (ble.connectedDeviceName.isNotBlank()) ble.connectedDeviceName else getString(R.string.status_connected),
                getString(R.string.action_disconnect)
            )
            ble.isConnecting -> Triple(
                R.color.pulsar_amber,
                getString(R.string.status_scanning),
                getString(R.string.action_disconnect)
            )
            else -> Triple(
                R.color.pulsar_red,
                getString(R.string.status_disconnected),
                getString(R.string.action_connect)
            )
        }

        val color = getColor(colorRes)
        (ivPillBleStatusDot?.background as? GradientDrawable)?.setColor(color)
        (ivDockBleStatusDot?.background as? GradientDrawable)?.setColor(color)

        tvDockBleStatus?.text = statusText
        tvDockBleStatus?.setTextColor(color)
        btnDockBleAction?.text = actionText
    }

    override fun onConnectionStateChanged(connected: Boolean, deviceName: String, deviceAddress: String) {
        hudRootView?.post {
            refreshBleUi()
        }
    }

    override fun onPacketSent(charUuid: String, frame: ByteArray?, success: Boolean) {}

    override fun onHandlebarEvent(event: PulsarProtocol.HandlebarEvent) {
        hudRootView?.post {
            refreshMediaUi()
        }
    }

    override fun onLocationChanged(location: Location) {
        val speedKmh = if (location.hasSpeed()) {
            (location.speed * 3.6f).roundToInt().coerceAtLeast(0)
        } else {
            0
        }
        hudRootView?.post {
            tvPillSpeed?.text = speedKmh.toString()
            tvDockSpeed?.text = speedKmh.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        instance = null

        MediaStateListener.instance?.unregisterObserver(this)
        bleManager?.removeListener(this)
        locationManager?.removeUpdates(this)

        hudRootView?.let { view ->
            windowManager?.removeView(view)
        }
        hudRootView = null
    }

    companion object {
        private const val TAG = "FloatingHudService"
        private const val NOTIFICATION_ID = 2026

        var isRunning: Boolean = false
            private set
        var instance: FloatingHudService? = null
            private set

        fun start(context: Context) {
            val intent = Intent(context, FloatingHudService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }

        fun stop(context: Context) {
            context.stopService(Intent(context, FloatingHudService::class.java))
        }
    }
}
