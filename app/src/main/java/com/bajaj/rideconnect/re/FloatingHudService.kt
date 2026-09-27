package com.bajaj.rideconnect.re

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
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

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        savedStateRegistryController.performAttach()
        savedStateRegistryController.performRestore(null)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        startInForeground()
        initOverlay()

        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    private fun startInForeground() {
        val channelId = "pulsar_cockpit_channel"
        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val channel = NotificationChannel(
            channelId, "Pulsar Cockpit HUD", NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Pulsar HUD overlay active over Google Maps"
            setShowBadge(false)
        }
        nm.createNotificationChannel(channel)

        val launchIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            this, 0, launchIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification =
            NotificationCompat.Builder(this, channelId).setContentTitle("Pulsar Cockpit")
                .setContentText("HUD Active").setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_LOW).build()

        ServiceCompat.startForeground(
            this,
            NOTIFICATION_ID,
            notification,
            ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE
        )
    }

    private fun initOverlay() {
        val wm = getSystemService(WINDOW_SERVICE) as? WindowManager ?: return
        this.windowManager = wm

        val metrics = resources.displayMetrics
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        val screenWidth = maxOf(metrics.widthPixels, metrics.heightPixels)

        val initialWidth = if (isLandscape) {
            (screenWidth * 0.30f).toInt().coerceAtLeast(300)
        } else {
            WindowManager.LayoutParams.WRAP_CONTENT
        }
        val initialHeight = if (isLandscape) {
            WindowManager.LayoutParams.MATCH_PARENT
        } else {
            WindowManager.LayoutParams.WRAP_CONTENT
        }
        val initialGravity = if (isLandscape) {
            Gravity.START or Gravity.TOP
        } else {
            Gravity.START or Gravity.CENTER_VERTICAL
        }

        val params = WindowManager.LayoutParams(
            initialWidth,
            initialHeight,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = initialGravity
            layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            x = 0
            y = 0
        }
        this.layoutParams = params

        val view = ComposeView(this).apply {
            setViewTreeLifecycleOwner(this@FloatingHudService)
            setViewTreeViewModelStoreOwner(this@FloatingHudService)
            setViewTreeSavedStateRegistryOwner(this@FloatingHudService)
            setContent {
                MyPulsarTheme {
                    CockpitHud(
                        onLaunchMaps = { launchGoogleMaps() },
                        onExpandedChanged = { expanded -> updateOverlayDimensions(expanded) })
                }
            }
        }
        this.composeView = view

        wm.addView(view, params)
    }

    private fun updateOverlayDimensions(isExpanded: Boolean) {
        val wm = windowManager ?: return
        val params = layoutParams ?: return
        val view = composeView ?: return
        val metrics = resources.displayMetrics
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        if (isLandscape && isExpanded) {
            val screenWidth = maxOf(metrics.widthPixels, metrics.heightPixels)
            params.width = (screenWidth * 0.30f).toInt().coerceAtLeast(300)
            params.height = WindowManager.LayoutParams.MATCH_PARENT
            params.gravity = Gravity.START or Gravity.TOP
            params.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        } else {
            params.width = WindowManager.LayoutParams.WRAP_CONTENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            params.gravity = Gravity.START or Gravity.CENTER_VERTICAL
            params.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }

        try {
            wm.updateViewLayout(view, params)
        } catch (_: Exception) {
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        composeView?.dispatchConfigurationChanged(newConfig)
        val isLandscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        updateOverlayDimensions(isLandscape)
    }

    private fun launchGoogleMaps() {
        try {
            val intent = Intent(Intent.ACTION_VIEW, "google.navigation:q=".toUri()).apply {
                setPackage("com.google.android.apps.maps")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.maps_not_installed), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        viewModelStore.clear()

        composeView?.let { view ->
            windowManager?.removeView(view)
        }
        composeView = null
        windowManager = null

        super.onDestroy()
    }

    companion object {
        private const val NOTIFICATION_ID = 4001

        fun start(context: Context) {
            val intent = Intent(context, FloatingHudService::class.java)
            ContextCompat.startForegroundService(context, intent)
        }
    }
}