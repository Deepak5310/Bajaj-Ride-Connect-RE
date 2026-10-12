package com.bajaj.rideconnect.re

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.os.IBinder
import android.provider.Settings
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.bajaj.rideconnect.re.ui.cockpit.CockpitHud
import com.bajaj.rideconnect.re.ui.theme.MyPulsarTheme

class FloatingHudService : Service(), LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {

    override val lifecycle = LifecycleRegistry(this)
    override val viewModelStore = ViewModelStore()
    private val savedStateRegistryController = SavedStateRegistryController.create(this)

    override val savedStateRegistry: SavedStateRegistry
        get() = savedStateRegistryController.savedStateRegistry

    private var windowManager: WindowManager? = null
    private var composeView: ComposeView? = null
    private var layoutParams: WindowManager.LayoutParams? = null
    private var isExpanded: Boolean = true
    private lateinit var mediaStateListener: MediaStateListener
    private lateinit var bleManager: PulsarBleManager
    private lateinit var phoneStateMonitor: PhoneStateMonitor

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        savedStateRegistryController.performAttach()
        savedStateRegistryController.performRestore(null)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        startInForeground()
        mediaStateListener = MediaStateListener(this)
        bleManager = PulsarBleManager(this)
        phoneStateMonitor = PhoneStateMonitor(this, bleManager, mediaStateListener)

        bleManager.handlebarListener = { ev ->
            mediaStateListener.handleHandlebarEvent(ev)
        }

        bleManager.onConnectedListener = {
            mediaStateListener.syncPhoneVolume()
            phoneStateMonitor.triggerImmediateUpdate()
        }

        mediaStateListener.bleMediaSender =
            BleMediaSender { title, artist, album, pos, dur, state ->
                bleManager.sendMedia(title, artist, album, pos, dur, state)
            }

        mediaStateListener.onVolumeChangedExternally = { requestedNibble ->
            phoneStateMonitor.sendImmediateVolumeTelemetry(requestedNibble)
        }

        phoneStateMonitor.start()
        bleManager.startScanOrConnect()

        initOverlay()

        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_STOP_SERVICE) {
            Toast.makeText(
                this, getString(R.string.toast_service_stopped), Toast.LENGTH_SHORT
            ).show()
            stopSelf()
            return START_NOT_STICKY
        }
        if (::mediaStateListener.isInitialized) {
            mediaStateListener.refreshMediaSessions()
        }
        if (::bleManager.isInitialized && !bleManager.connectionState.value.isConnected) {
            bleManager.startScanOrConnect()
        }
        return START_STICKY
    }

    private fun startInForeground() {
        val channelId = "pulsar_cockpit_channel"
        val nm = getSystemService(NotificationManager::class.java)

        val channel = NotificationChannel(
            channelId,
            getString(R.string.notification_channel_name),
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = getString(R.string.notification_channel_desc)
            setShowBadge(false)
        }
        nm.createNotificationChannel(channel)

        val launchIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            this, 0, launchIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val stopIntent = Intent(this, FloatingHudService::class.java).apply {
            action = ACTION_STOP_SERVICE
        }
        val stopPendingIntent = PendingIntent.getService(
            this, 1, stopIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(getString(R.string.notification_cockpit_title))
            .setContentText(getString(R.string.notification_cockpit_desc))
            .setSmallIcon(R.drawable.ic_stat_pulsar).setContentIntent(pendingIntent)
            .addAction(0, getString(R.string.action_exit), stopPendingIntent).setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW).build()

        ServiceCompat.startForeground(
            this,
            NOTIFICATION_ID,
            notification,
            ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE
        )
    }

    private fun initOverlay() {
        if (!Settings.canDrawOverlays(this)) return
        val wm = getSystemService(WindowManager::class.java) ?: return
        this.windowManager = wm

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
        ).apply {
            layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            x = 0
            y = 0
        }
        applyOverlayDimensions(params, expanded = isExpanded)
        this.layoutParams = params

        val view = ComposeView(this).apply {
            setViewTreeLifecycleOwner(this@FloatingHudService)
            setViewTreeViewModelStoreOwner(this@FloatingHudService)
            setViewTreeSavedStateRegistryOwner(this@FloatingHudService)
            setContent {
                MyPulsarTheme {
                    val mediaInfo by mediaStateListener.mediaTrackInfo.collectAsState()
                    val bleState by bleManager.connectionState.collectAsState()

                    val bikeNameText = if (bleState.isConnected) {
                        bleState.deviceName.ifEmpty { stringResource(R.string.bike_name) }
                    } else {
                        stringResource(R.string.no_bike_connected)
                    }

                    val bikeStatusText = when {
                        bleState.isConnected -> stringResource(R.string.status_linked)
                        bleState.isConnecting -> stringResource(R.string.status_connecting)
                        else -> stringResource(R.string.status_standby)
                    }

                    CockpitHud(
                        bikeName = bikeNameText,
                        bikeStatus = bikeStatusText,
                        isBleConnected = bleState.isConnected,
                        mediaInfo = mediaInfo,
                        onExpandedChanged = { expanded ->
                            isExpanded = expanded
                            updateOverlayDimensions(expanded)
                            if (expanded && !mediaStateListener.mediaTrackInfo.value.hasPermission) {
                                mediaStateListener.refreshMediaSessions()
                            }
                        },
                        onPlayPauseToggle = { mediaStateListener.togglePlayPause() },
                        onSkipNext = { mediaStateListener.skipNext() },
                        onSkipPrevious = { mediaStateListener.skipPrevious() },
                        onSeek = { fraction -> mediaStateListener.seekToRatio(fraction) },
                        onRequestNotificationPermission = { openNotificationListenerSettings() },
                        onBikeClick = {
                            if (bleState.isConnected) {
                                Toast.makeText(
                                    this@FloatingHudService,
                                    getString(R.string.toast_connected, bikeNameText),
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (!bleManager.isBluetoothEnabled()) {
                                bleManager.requestEnableBluetooth(this@FloatingHudService)
                            } else {
                                Toast.makeText(
                                    this@FloatingHudService,
                                    getString(R.string.toast_connecting),
                                    Toast.LENGTH_SHORT
                                ).show()
                                bleManager.startScanOrConnect()
                            }
                        },
                        onExitApp = {
                            Toast.makeText(
                                this@FloatingHudService,
                                getString(R.string.toast_service_stopped),
                                Toast.LENGTH_SHORT
                            ).show()
                            stopSelf()
                        })
                }
            }
        }
        this.composeView = view

        try {
            wm.addView(view, params)
        } catch (e: Exception) {
            android.util.Log.e(
                "FloatingHudService", "Failed to add overlay view to WindowManager: ${e.message}"
            )
        }
    }

    private fun applyOverlayDimensions(params: WindowManager.LayoutParams, expanded: Boolean) {
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        if (isLandscape && expanded) {
            val metrics = resources.displayMetrics
            val screenWidth = maxOf(metrics.widthPixels, metrics.heightPixels)
            val panelWidthPx = (screenWidth * 0.30f).toInt()
            params.width = panelWidthPx
            params.height = WindowManager.LayoutParams.MATCH_PARENT
            params.gravity = Gravity.START or Gravity.TOP
        } else {
            params.width = WindowManager.LayoutParams.WRAP_CONTENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            params.gravity = Gravity.START or Gravity.CENTER_VERTICAL
        }
    }

    private fun updateOverlayDimensions(expanded: Boolean) {
        val wm = windowManager ?: return
        val params = layoutParams ?: return
        val view = composeView ?: return
        applyOverlayDimensions(params, expanded)
        try {
            wm.updateViewLayout(view, params)
        } catch (_: Exception) {
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        composeView?.dispatchConfigurationChanged(newConfig)
        updateOverlayDimensions(isExpanded)
    }

    private fun openNotificationListenerSettings() {
        if (PulsarNotificationService.isNotificationListenerGranted(this)) {
            mediaStateListener.refreshMediaSessions()
            return
        }
        try {
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        } catch (_: Exception) {
            Toast.makeText(
                this, getString(R.string.notification_settings_not_found), Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        viewModelStore.clear()

        if (::phoneStateMonitor.isInitialized) {
            phoneStateMonitor.stop()
        }

        if (::bleManager.isInitialized) {
            bleManager.destroy()
        }

        if (::mediaStateListener.isInitialized) {
            mediaStateListener.destroy()
        }

        composeView?.let { view ->
            try {
                view.disposeComposition()
                windowManager?.removeView(view)
            } catch (_: Exception) {
            }
        }
        composeView = null
        windowManager = null

        super.onDestroy()
    }

    companion object {
        private const val NOTIFICATION_ID = 4001
        private const val ACTION_STOP_SERVICE = "com.bajaj.rideconnect.re.ACTION_STOP_SERVICE"

        fun start(context: Context) {
            val intent = Intent(context, FloatingHudService::class.java)
            ContextCompat.startForegroundService(context, intent)
        }
    }
}