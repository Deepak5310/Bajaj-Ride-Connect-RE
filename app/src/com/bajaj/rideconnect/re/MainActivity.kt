package com.bajaj.rideconnect.re

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.GradientDrawable
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : Activity(), PulsarBleManager.BleListener, MediaStateListener.MediaObserver {

    private lateinit var bleManager: PulsarBleManager
    private var mediaListener: MediaStateListener? = null
    private var locationManager: LocationManager? = null
    private val mainHandler = Handler(Looper.getMainLooper())

    private var ivBleStatusDot: View? = null
    private var tvBikeName: TextView? = null
    private var tvBleStatus: TextView? = null
    private var pbBleConnecting: ProgressBar? = null
    private var btnBleConnect: FrameLayout? = null
    private var ivBleActionIcon: ImageView? = null
    private var tvBleActionText: TextView? = null
    private var tvHandlebarStatus: TextView? = null
    private var tvBatterySync: TextView? = null

    private var tvGpsSpeed: TextView? = null
    private var btnLaunchFloatingHud: FrameLayout? = null
    private var btnOpenGoogleMaps: FrameLayout? = null

    private var ivAlbumArt: RoundedImageView? = null
    private var tvTrackTitle: TextView? = null
    private var tvTrackArtist: TextView? = null
    private var tvPlayerSource: TextView? = null
    private var wavySeekBar: WavySeekBar? = null
    private var tvMediaElapsed: TextView? = null
    private var tvMediaDuration: TextView? = null
    private var btnMediaPrev: ImageView? = null
    private var btnMediaPlayPause: ImageView? = null
    private var btnMediaNext: ImageView? = null

    private var isGpsActive = false

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            val speedKmh = if (location.hasSpeed()) {
                (location.speed * 3.6f).roundToInt()
            } else {
                0
            }
            tvGpsSpeed?.text = speedKmh.coerceAtLeast(0).toString()
        }

        @Deprecated("Deprecated in Java")
        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {
            tvGpsSpeed?.text = "0"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyImmersiveFullscreen()
        setContentView(R.layout.activity_main)

        bleManager = PulsarBleManager.getInstance(this)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as? LocationManager

        bindViews()
        setupListeners()
        requestPermissionsIfNeeded()
        ensureForegroundServiceRunning()
    }

    override fun onResume() {
        super.onResume()
        applyImmersiveFullscreen()

        bleManager.addListener(this)
        mediaListener = MediaStateListener.instance ?: MediaStateListener(this, bleManager)
        mediaListener?.registerObserver(this)

        updateBleUi(bleManager.isConnected, bleManager.connectedDeviceName)
        startGpsUpdates()
    }

    override fun onPause() {
        super.onPause()
        stopGpsUpdates()
        bleManager.removeListener(this)
        mediaListener?.unregisterObserver(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyImmersiveFullscreen()
        }
    }

    private fun applyImmersiveFullscreen() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
                val controller = window.decorView.windowInsetsController
                controller?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            } else {
                window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
            }
        } catch (ignored: Exception) {}
    }

    private fun bindViews() {
        ivBleStatusDot = findViewById(R.id.ivBleStatusDot)
        tvBikeName = findViewById(R.id.tvBikeName)
        tvBleStatus = findViewById(R.id.tvBleStatus)
        pbBleConnecting = findViewById(R.id.pbBleConnecting)
        btnBleConnect = findViewById(R.id.btnBleConnect)
        ivBleActionIcon = findViewById(R.id.ivBleActionIcon)
        tvBleActionText = findViewById(R.id.tvBleActionText)
        tvHandlebarStatus = findViewById(R.id.tvHandlebarStatus)
        tvBatterySync = findViewById(R.id.tvBatterySync)

        tvGpsSpeed = findViewById(R.id.tvGpsSpeed)
        btnLaunchFloatingHud = findViewById(R.id.btnLaunchFloatingHud)
        btnOpenGoogleMaps = findViewById(R.id.btnOpenGoogleMaps)

        ivAlbumArt = findViewById(R.id.ivAlbumArt)
        tvTrackTitle = findViewById(R.id.tvTrackTitle)
        tvTrackArtist = findViewById(R.id.tvTrackArtist)
        tvPlayerSource = findViewById(R.id.tvPlayerSource)
        wavySeekBar = findViewById(R.id.wavySeekBar)
        tvMediaElapsed = findViewById(R.id.tvMediaElapsed)
        tvMediaDuration = findViewById(R.id.tvMediaDuration)
        btnMediaPrev = findViewById(R.id.btnMediaPrev)
        btnMediaPlayPause = findViewById(R.id.btnMediaPlayPause)
        btnMediaNext = findViewById(R.id.btnMediaNext)

        tvTrackTitle?.isSelected = true
    }

    private fun setupListeners() {
        btnBleConnect?.setOnClickListener {
            if (bleManager.isConnected) {
                bleManager.setAutoReconnect(false)
                bleManager.disconnect()
                updateBleUi(false, null)
            } else {
                bleManager.setAutoReconnect(true)
                bleManager.startScanOrConnect()
                pbBleConnecting?.visibility = View.VISIBLE
                tvBleStatus?.text = "Scanning for Pulsar..."
                tvBleStatus?.setTextColor(0xFF38BDF8.toInt())
            }
        }

        btnLaunchFloatingHud?.setOnClickListener {
            launchFloatingHud()
        }

        btnOpenGoogleMaps?.setOnClickListener {
            launchGoogleMaps()
        }

        btnMediaPlayPause?.setOnClickListener {
            mediaListener?.togglePlayPause()
        }

        btnMediaPrev?.setOnClickListener {
            mediaListener?.skipPrevious()
        }

        btnMediaNext?.setOnClickListener {
            mediaListener?.skipNext()
        }

        wavySeekBar?.setOnSeekBarChangeListener(object : android.widget.SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: android.widget.SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    tvMediaElapsed?.text = formatTime(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {
                seekBar?.let {
                    mediaListener?.seekTo(it.progress * 1000L)
                }
            }
        })
    }

    private fun launchFloatingHud() {
        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:$packageName")
            )
            startActivity(intent)
            return
        }

        // Floating HUD Service will be started here in Phase 2
        launchGoogleMaps()
    }

    private fun launchGoogleMaps() {
        try {
            val mapsIntent = packageManager.getLaunchIntentForPackage("com.google.android.apps.maps")
            if (mapsIntent != null) {
                mapsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(mapsIntent)
            } else {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=home"))
                startActivity(webIntent)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Cannot launch Google Maps: ${e.message}")
        }
    }

    private fun updateBleUi(connected: Boolean, deviceName: String?) {
        pbBleConnecting?.visibility = View.GONE
        val density = resources.displayMetrics.density

        if (connected) {
            val name = if (!deviceName.isNullOrBlank()) deviceName else "Bajaj Pulsar NS400Z"
            tvBikeName?.text = name
            tvBleStatus?.text = "Connected & Synced"
            tvBleStatus?.setTextColor(0xFF10B981.toInt())

            ivBleStatusDot?.background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(0xFF10B981.toInt())
            }

            tvBleActionText?.text = "Disconnect"
            tvBleActionText?.setTextColor(0xFFEF4444.toInt())
            ivBleActionIcon?.setImageResource(R.drawable.ic_disconnect)
            ivBleActionIcon?.setColorFilter(0xFFEF4444.toInt())

            btnBleConnect?.background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 10 * density
                setColor(0x22EF4444)
                setStroke((1.2f * density).toInt(), 0xFFEF4444.toInt())
            }
        } else {
            tvBikeName?.text = "Bajaj Pulsar NS400Z"
            tvBleStatus?.text = "Disconnected"
            tvBleStatus?.setTextColor(0xFFEF4444.toInt())

            ivBleStatusDot?.background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(0xFFEF4444.toInt())
            }

            tvBleActionText?.text = "Connect to Bike"
            tvBleActionText?.setTextColor(0xFF38BDF8.toInt())
            ivBleActionIcon?.setImageResource(R.drawable.ic_bluetooth)
            ivBleActionIcon?.setColorFilter(0xFF38BDF8.toInt())

            btnBleConnect?.background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 10 * density
                setColor(0x1F38BDF8)
                setStroke((1.2f * density).toInt(), 0xFF38BDF8.toInt())
            }
        }
    }

    override fun onConnectionStateChanged(connected: Boolean, deviceName: String, deviceAddress: String) {
        mainHandler.post {
            updateBleUi(connected, deviceName)
        }
    }

    override fun onPacketSent(charUuid: String, frame: ByteArray?, success: Boolean) {}

    override fun onHandlebarEvent(event: PulsarProtocol.HandlebarEvent) {
        mainHandler.post {
            tvHandlebarStatus?.text = "Handlebar Action Received"
            mainHandler.postDelayed({
                tvHandlebarStatus?.text = "Handlebar Controls: Active"
            }, 1800)
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
        mainHandler.post {
            tvTrackTitle?.text = if (title.isNotBlank()) title else "No Music Playing"
            tvTrackArtist?.text = if (artist.isNotBlank()) artist else "Launch Spotify / YT Music"
            tvPlayerSource?.text = if (source.isNotBlank()) "$source • Synced" else "Handlebar Sync Ready"

            if (artwork != null) {
                ivAlbumArt?.setImageBitmap(artwork)
            } else {
                ivAlbumArt?.setImageResource(R.drawable.ic_album_art_placeholder)
            }

            val isPlaying = (playbackState == 2)
            btnMediaPlayPause?.setImageResource(
                if (isPlaying) R.drawable.ic_media_pause else R.drawable.ic_media_play
            )

            wavySeekBar?.max = durSec.coerceAtLeast(1)
            wavySeekBar?.progress = posSec.coerceIn(0, durSec.coerceAtLeast(1))

            tvMediaElapsed?.text = formatTime(posSec)
            tvMediaDuration?.text = formatTime(durSec)
        }
    }

    private fun formatTime(seconds: Int): String {
        val m = seconds / 60
        val s = seconds % 60
        return String.format(java.util.Locale.US, "%d:%02d", m, s)
    }

    private fun startGpsUpdates() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        val lm = locationManager ?: return
        try {
            if (!isGpsActive) {
                if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f, locationListener)
                    isGpsActive = true
                } else if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000L, 1.0f, locationListener)
                    isGpsActive = true
                }
            }
        } catch (e: SecurityException) {
            Log.w(TAG, "GPS permission denied: ${e.message}")
        }
    }

    private fun stopGpsUpdates() {
        if (isGpsActive) {
            locationManager?.removeUpdates(locationListener)
            isGpsActive = false
        }
    }

    private fun ensureForegroundServiceRunning() {
        val intent = Intent(this, PulsarForegroundService::class.java).apply {
            action = PulsarForegroundService.ACTION_CONNECT
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        } else {
            startService(intent)
        }
    }

    private fun requestPermissionsIfNeeded() {
        val perms = mutableListOf<String>()

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            perms.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                perms.add(Manifest.permission.BLUETOOTH_CONNECT)
            }
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                perms.add(Manifest.permission.BLUETOOTH_SCAN)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                perms.add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }

        if (perms.isNotEmpty()) {
            requestPermissions(perms.toTypedArray(), 1001)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001) {
            startGpsUpdates()
            bleManager.startScanOrConnect()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
