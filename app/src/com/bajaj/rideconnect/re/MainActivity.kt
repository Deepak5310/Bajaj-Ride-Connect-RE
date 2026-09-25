package com.bajaj.rideconnect.re

import android.Manifest
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.app.AlertDialog
import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Rect
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.media.AudioManager
import android.net.Uri
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.SystemClock
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.speech.tts.TextToSpeech
import android.telephony.PhoneStateListener
import android.telephony.SignalStrength
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.HapticFeedbackConstants
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import android.annotation.TargetApi
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Collections
import java.util.Date
import java.util.Locale
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.system.exitProcess

class MainActivity : Activity(), PulsarBleManager.BleListener {

    private var btnOpenDrawer: ImageView? = null

    private var layoutLeftPanel: LinearLayout? = null
    private var viewSplitDivider: View? = null
    private var layoutSplitHandle: View? = null
    private var ivSplitHandleChevron: ImageView? = null
    private var layoutMapContainer: View? = null
    private var layoutMapStartHudContainer: FrameLayout? = null
    private var isMapFullscreen: Boolean = false

    private var viewTabMedia: View? = null
    private var ivAlbumArt: ImageView? = null
    private var tvMediaTrack: TextView? = null
    private var tvMediaArtist: TextView? = null
    private var tvMediaSource: TextView? = null
    private var pbMediaTrack: SeekBar? = null
    private var isUserScrubbingMedia: Boolean = false
    private var currentMediaDurSec: Int = 0
    private var tvMediaElapsed: TextView? = null
    private var tvMediaDuration: TextView? = null
    private var btnMediaPrev: ImageView? = null
    private var btnMediaPlayPause: ImageView? = null
    private var btnMediaNext: ImageView? = null

    private var layoutFullscreenMusicPill: View? = null
    private var ivPillAlbumArt: ImageView? = null
    private var tvPillTrack: TextView? = null
    private var tvPillArtist: TextView? = null
    private var btnPillPlayPause: ImageView? = null
    private var btnPillNext: ImageView? = null

    private var cardTurnInstruction: View? = null
    private var ivTurnArrow: ImageView? = null
    private var tvTurnDist: TextView? = null
    private var tvTurnDesc: TextView? = null
    private var layoutNextStepPreview: View? = null
    private var tvNextStepDesc: TextView? = null
    private var cardSpeedHud: View? = null
    private var tvCurrentSpeed: TextView? = null
    private var tvSpeedLimit: TextView? = null
    private var tvSpeedUnit: TextView? = null
    private var lastSpeedLocation: Location? = null
    private var lastSpeedTimeMs: Long = 0
    private var currentSpeedKmh: Int = 0
    private var btnCompass: ImageView? = null
    private var btnVoiceNav: ImageView? = null
    private var btnLayers: ImageView? = null
    private var cardBottomNav: View? = null
    private var tvNavEta: TextView? = null
    private var tvNavSub: TextView? = null
    private var btnNavEnd: Button? = null

    private var cardRoutePreview: View? = null
    private var tvPreviewDestName: TextView? = null
    private var tvPreviewDestAddress: TextView? = null
    private var btnCancelRoutePreview: ImageView? = null
    private var tvPreviewDuration: TextView? = null
    private var tvPreviewDistance: TextView? = null
    private var tvPreviewSub: TextView? = null
    private var btnStartNavNow: Button? = null
    private var pendingPreviewRoute: MapplsApiClient.RouteResult? = null
    private var pendingDestName: String = ""

    private var mapplsMapView: MapplsMapView? = null
    private var layoutRecenterPill: View? = null
    private var btnMapSearch: ImageView? = null
    private var btnCurrentLocation: ImageView? = null
    private var locationManager: LocationManager? = null
    private var gpsSwitchReceiver: BroadcastReceiver? = null
    private var currentRiderLat: Double = 0.0
    private var currentRiderLng: Double = 0.0
    private var currentRiderBearing: Float = 0f
    private var currentActiveRoute: MapplsApiClient.RouteResult? = null
    private var currentRouteStepIndex: Int = 0
    private var tts: TextToSpeech? = null
    private var isTtsReady: Boolean = false

    private var layoutSearchOverlay: View? = null
    private var cardSearchBox: View? = null
    private var etSearchQuery: EditText? = null
    private var btnSearchClear: ImageView? = null
    private var btnSearchImeToggle: ImageView? = null
    private var pbSearchProgress: ProgressBar? = null
    private var lvSearchResults: ListView? = null
    private var btnSearchCancel: TextView? = null
    private var cockpitKeyboard: CockpitKeyboard? = null
    private val searchPlaceList = mutableListOf<MapplsApiClient.PlaceResult>()
    private var searchAdapter: ArrayAdapter<MapplsApiClient.PlaceResult>? = null
    private val searchDebounceHandler = Handler(Looper.getMainLooper())

    private var drawerBackdrop: View? = null
    private var drawerPanel: View? = null
    private var scrollDrawer: ScrollView? = null
    private var btnDrawerClose: ImageView? = null
    private var cardBikeStage: View? = null
    private var ivDrawerBikeImage: ImageView? = null
    private var tvDrawerBikeName: TextView? = null
    private var tvDrawerClock: TextView? = null
    private var cardBikeConnection: LinearLayout? = null
    private var viewDrawerBtStatusDot: View? = null
    private var tvDrawerBtStatus: TextView? = null
    private var pbBleConnecting: ProgressBar? = null
    private var tvBleDetailMsg: TextView? = null
    private var btnDrawerBleConnect: LinearLayout? = null
    private var ivDrawerBleActionIcon: ImageView? = null
    private var tvDrawerBleActionText: TextView? = null

    private var isBleConnecting = false
    private val bleTimeoutHandler = Handler(Looper.getMainLooper())
    private val bleTimeoutRunnable = Runnable {
        if (isBleConnecting) {
            isBleConnecting = false
            bleManager?.stopScan()
            bleManager?.disconnect()
            updateBleUiState(BleUiState.FAILED, null)
            Toast.makeText(this@MainActivity, "Bike connection timed out (30s). Tap Retry.", Toast.LENGTH_SHORT).show()
        }
    }

    private enum class BleUiState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        FAILED
    }

    private var itemSavedPlaces: View? = null
    private var btnDrawerExit: View? = null
    private var tvDrawerTitle: TextView? = null
    private var btnFooterGithub: View? = null

    private var bleManager: PulsarBleManager? = null
    private var pulseAnimator: ObjectAnimator? = null
    private val clockHandler = Handler(Looper.getMainLooper())
    private val clockFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    private var currentBattery = -1
    private var isCharging = false
    private var currentSignalBars = -1
    private var isVoiceMuted = false

    private val clockRunnable = object : Runnable {
        override fun run() {
            tvDrawerClock?.text = clockFormat.format(Date())
            clockHandler.postDelayed(this, 10000)
        }
    }

    private val systemUpdatesReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent ?: return
            val action = intent.action ?: return

            when (action) {
                MediaStateListener.ACTION_MEDIA_UPDATE -> {
                    val title = intent.getStringExtra("title")
                    val artist = intent.getStringExtra("artist")
                    val source = intent.getStringExtra("source")
                    val state = intent.getIntExtra("playback_state", 0)
                    val posSec = intent.getIntExtra("position_sec", 0)
                    val durSec = intent.getIntExtra("duration_sec", 0)
                    val art = MediaStateListener.instance?.currentAlbumArt
                    updateCockpitMedia(title, artist, source, state, posSec, durSec, art)
                }
                PhoneStateMonitor.ACTION_TELEMETRY_UPDATE -> {
                    val bat = intent.getIntExtra("battery", -1)
                    val sig = intent.getIntExtra("signal", -1)
                    if (bat >= 0) {
                        currentBattery = bat
                        updateBatteryDisplay(currentBattery, isCharging)
                    }
                    if (sig >= 0) {
                        currentSignalBars = sig
                        updateSignalDisplay(currentSignalBars)
                    }
                }
                Intent.ACTION_BATTERY_CHANGED -> {
                    val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
                    isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                        status == BatteryManager.BATTERY_STATUS_FULL
                    if (level >= 0 && scale > 0) {
                        currentBattery = ((level / scale.toFloat()) * 100).toInt()
                        updateBatteryDisplay(currentBattery, isCharging)
                    }
                }
            }
        }
    }

    private val mediaObserver = MediaStateListener.MediaObserver { title, artist, _, source, state, posSec, durSec, art ->
        runOnUiThread { updateCockpitMedia(title, artist, source, state, posSec, durSec, art) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(
                OnBackInvokedDispatcher.PRIORITY_DEFAULT
            ) { handleBackPress() }
        }

        try {
            val prefs = getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
            val sLat = prefs.getFloat("saved_rider_lat", 0.0f)
            val sLng = prefs.getFloat("saved_rider_lng", 0.0f)
            if (sLat != 0.0f && sLng != 0.0f) {
                currentRiderLat = sLat.toDouble()
                currentRiderLng = sLng.toDouble()
            }
        } catch (ignored: Exception) {}

        try {
            tts = TextToSpeech(this) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    tts?.language = Locale.US
                    isTtsReady = true
                }
            }
        } catch (ignored: Exception) {}

        initViews()
        initCockpitTheme()
        setupListeners()
        setupMicroAnimations()
        initLiveSystemSensors()

        val switchReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (LocationManager.PROVIDERS_CHANGED_ACTION == intent?.action) {
                    if (isDeviceLocationEnabled()) {
                        initGpsTracking()
                        if (currentRiderLat != 0.0 && currentRiderLng != 0.0) {
                            mapplsMapView?.centerOnCurrentLocation()
                        }
                    }
                }
            }
        }
        gpsSwitchReceiver = switchReceiver
        try {
            registerReceiver(switchReceiver, IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION))
        } catch (ignored: Exception) {}

        val ble = PulsarBleManager.getInstance(this)
        this.bleManager = ble
        ble.addListener(this)

        PulsarForegroundService.start(this)
        requestAppPermissions()
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent ?: return
        if (intent.getBooleanExtra("open_search", false)) {
            layoutSearchOverlay?.postDelayed({ showDestinationSearch() }, 300)
        }
        if (intent.hasExtra("map_fullscreen") && !intent.hasExtra("cmd")) {
            val fs = intent.getBooleanExtra("map_fullscreen", false)
            layoutMapContainer?.postDelayed({ setMapFullscreen(fs) }, 300)
        }
        if (intent.hasExtra("query")) {
            val q = intent.getStringExtra("query")
            if (etSearchQuery != null && q != null) {
                showDestinationSearch()
                etSearchQuery?.postDelayed({
                    etSearchQuery?.setText(q)
                    etSearchQuery?.setSelection(q.length)
                }, 300)
            }
        }
        val cmd = intent.getStringExtra("cmd") ?: return
        when {
            "search".equals(cmd, ignoreCase = true) -> {
                val query = intent.getStringExtra("query")
                showDestinationSearch()
                if (query != null && etSearchQuery != null) {
                    etSearchQuery?.setText(query)
                    etSearchQuery?.setSelection(query.length)
                }
            }
            "select_first".equals(cmd, ignoreCase = true) -> {
                if (searchPlaceList.isNotEmpty()) {
                    val selected = searchPlaceList[0]
                    hideDestinationSearch()
                    previewRoute(selected)
                }
            }
            "start_nav".equals(cmd, ignoreCase = true) -> {
                if (pendingPreviewRoute == null) {
                    val steps = mutableListOf<MapplsApiClient.RouteStep>().apply {
                        add(MapplsApiClient.RouteStep("In 200m, turn left toward Service Road", "Station Road", 250.0, 45.0, 1, 28.128, 75.399))
                        add(MapplsApiClient.RouteStep("Continue straight on National Highway", "NH 52", 4800.0, 360.0, 0, 28.135, 75.405))
                    }
                    pendingPreviewRoute = MapplsApiClient.RouteResult(5050.0, 405.0, "", steps)
                    pendingDestName = "Bajaj Service Station"
                }
                startActiveNavigation()
            }
            "end_nav".equals(cmd, ignoreCase = true) -> endActiveNavigation()
            "recenter".equals(cmd, ignoreCase = true) -> {
                if (layoutRecenterPill != null) {
                    layoutRecenterPill?.performClick()
                } else {
                    centerMapOnCurrentLocation()
                }
            }
            "drag_map".equals(cmd, ignoreCase = true) -> mapplsMapView?.simulateDrag()
            "open_saved_places".equals(cmd, ignoreCase = true) -> showSavedPlacesDialog()
            "open_drawer".equals(cmd, ignoreCase = true) -> openDrawer()
            "scroll_drawer".equals(cmd, ignoreCase = true) -> {
                val y = intent.getIntExtra("y", 400)
                scrollDrawer?.post { scrollDrawer?.smoothScrollTo(0, y) }
            }
            "close_drawer".equals(cmd, ignoreCase = true) -> closeDrawer()
            "toggle_orientation".equals(cmd, ignoreCase = true) -> btnCompass?.performClick()
            "toggle_split".equals(cmd, ignoreCase = true) -> setMapFullscreen(!isMapFullscreen)
            "expand_media".equals(cmd, ignoreCase = true) -> setMapFullscreen(false)
            "seek_media".equals(cmd, ignoreCase = true) -> {
                val progress = intent.getIntExtra("progress", 500)
                pbMediaTrack?.progress = progress
                if (currentMediaDurSec > 0) {
                    val targetMs = ((progress.toFloat() / 1000f) * currentMediaDurSec * 1000L).toLong()
                    seekMediaTo(targetMs)
                }
            }
            "tap_turn_card".equals(cmd, ignoreCase = true) -> cardTurnInstruction?.performClick()
            "close_search".equals(cmd, ignoreCase = true) -> hideDestinationSearch()
            "connect_bike".equals(cmd, ignoreCase = true) -> startBikeBleConnection()
            "toggle_theme".equals(cmd, ignoreCase = true) -> btnLayers?.performClick()
            "test_ble_state".equals(cmd, ignoreCase = true) -> {
                val s = intent.getStringExtra("state")
                val name = intent.getStringExtra("name")
                when {
                    "connecting".equals(s, ignoreCase = true) -> updateBleUiState(BleUiState.CONNECTING, null)
                    "connected".equals(s, ignoreCase = true) -> updateBleUiState(BleUiState.CONNECTED, name ?: "Bajaj Pulsar NS400Z")
                    "failed".equals(s, ignoreCase = true) -> updateBleUiState(BleUiState.FAILED, null)
                    else -> updateBleUiState(BleUiState.DISCONNECTED, null)
                }
            }
        }
    }

    private fun setupEdgeToEdge() {
        val window = window ?: return
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val lp = window.attributes
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            window.attributes = lp
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            setTurnScreenOn(true)
        }

        applyImmersiveFullscreen()
    }

    private fun applyImmersiveFullscreen() {
        try {
            val window = window ?: return
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val lp = window.attributes
                lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
                window.attributes = lp
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
            }
            val decor = window.decorView
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val controller = decor.windowInsetsController
                controller?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            } else {
                decor.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
            }
        } catch (ignored: Exception) {}
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyImmersiveFullscreen()
        }
    }

    private fun initViews() {
        btnOpenDrawer = findViewById(R.id.btnOpenDrawer)

        layoutLeftPanel = findViewById(R.id.layoutLeftPanel)
        viewSplitDivider = findViewById(R.id.viewSplitDivider)
        layoutSplitHandle = findViewById(R.id.layoutSplitHandle)
        ivSplitHandleChevron = findViewById(R.id.ivSplitHandleChevron)
        layoutMapContainer = findViewById(R.id.layoutMapContainer)
        layoutMapStartHudContainer = findViewById(R.id.layoutMapStartHudContainer)

        val density = resources.displayMetrics.density
        val panelWidth = 250f * density
        viewSplitDivider?.translationX = panelWidth
        layoutMapStartHudContainer?.translationX = panelWidth

        viewTabMedia = findViewById(R.id.viewTabMedia)

        ivAlbumArt = findViewById(R.id.ivAlbumArt)
        tvMediaTrack = findViewById(R.id.tvMediaTrack)
        tvMediaArtist = findViewById(R.id.tvMediaArtist)
        tvMediaSource = findViewById(R.id.tvMediaSource)
        pbMediaTrack = findViewById(R.id.pbMediaTrack)
        tvMediaElapsed = findViewById(R.id.tvMediaElapsed)
        tvMediaDuration = findViewById(R.id.tvMediaDuration)
        btnMediaPrev = findViewById(R.id.btnMediaPrev)
        btnMediaPlayPause = findViewById(R.id.btnMediaPlayPause)
        btnMediaNext = findViewById(R.id.btnMediaNext)

        layoutFullscreenMusicPill = findViewById(R.id.layoutFullscreenMusicPill)
        ivPillAlbumArt = findViewById(R.id.ivPillAlbumArt)
        tvPillTrack = findViewById(R.id.tvPillTrack)
        tvPillArtist = findViewById(R.id.tvPillArtist)
        btnPillPlayPause = findViewById(R.id.btnPillPlayPause)
        btnPillNext = findViewById(R.id.btnPillNext)

        cardTurnInstruction = findViewById(R.id.cardTurnInstruction)
        ivTurnArrow = findViewById(R.id.ivTurnArrow)
        tvTurnDist = findViewById(R.id.tvTurnDist)
        tvTurnDesc = findViewById(R.id.tvTurnDesc)
        layoutNextStepPreview = findViewById(R.id.layoutNextStepPreview)
        tvNextStepDesc = findViewById(R.id.tvNextStepDesc)
        cardSpeedHud = findViewById(R.id.cardSpeedHud)
        cardSpeedHud?.visibility = View.GONE
        tvCurrentSpeed = findViewById(R.id.tvCurrentSpeed)
        tvSpeedLimit = findViewById(R.id.tvSpeedLimit)
        tvSpeedUnit = findViewById(R.id.tvSpeedUnit)
        btnCompass = findViewById(R.id.btnCompass)
        btnVoiceNav = findViewById(R.id.btnVoiceNav)
        btnLayers = findViewById(R.id.btnLayers)
        cardBottomNav = findViewById(R.id.cardBottomNav)
        tvNavEta = findViewById(R.id.tvNavEta)
        tvNavSub = findViewById(R.id.tvNavSub)
        btnNavEnd = findViewById(R.id.btnNavEnd)

        cardRoutePreview = findViewById(R.id.cardRoutePreview)
        tvPreviewDestName = findViewById(R.id.tvPreviewDestName)
        tvPreviewDestAddress = findViewById(R.id.tvPreviewDestAddress)
        btnCancelRoutePreview = findViewById(R.id.btnCancelRoutePreview)
        tvPreviewDuration = findViewById(R.id.tvPreviewDuration)
        tvPreviewDistance = findViewById(R.id.tvPreviewDistance)
        tvPreviewSub = findViewById(R.id.tvPreviewSub)
        btnStartNavNow = findViewById(R.id.btnStartNavNow)

        mapplsMapView = findViewById(R.id.mapplsMapView)
        layoutRecenterPill = findViewById(R.id.layoutRecenterPill)
        btnMapSearch = findViewById(R.id.btnMapSearch)
        btnCurrentLocation = findViewById(R.id.btnCurrentLocation)

        layoutSearchOverlay = findViewById(R.id.layoutSearchOverlay)
        cardSearchBox = findViewById(R.id.cardSearchBox)
        etSearchQuery = findViewById(R.id.etSearchQuery)
        btnSearchClear = findViewById(R.id.btnSearchClear)
        btnSearchImeToggle = findViewById(R.id.btnSearchImeToggle)
        pbSearchProgress = findViewById(R.id.pbSearchProgress)
        lvSearchResults = findViewById(R.id.lvSearchResults)
        btnSearchCancel = findViewById(R.id.btnSearchCancel)

        drawerBackdrop = findViewById(R.id.drawerBackdrop)
        drawerPanel = findViewById(R.id.drawerPanel)
        scrollDrawer = findViewById(R.id.scrollDrawer)
        btnDrawerClose = findViewById(R.id.btnDrawerClose)
        cardBikeStage = findViewById(R.id.cardBikeStage)
        ivDrawerBikeImage = findViewById(R.id.ivDrawerBikeImage)
        tvDrawerBikeName = findViewById(R.id.tvDrawerBikeName)
        viewDrawerBtStatusDot = findViewById(R.id.viewDrawerBtStatusDot)
        tvDrawerBtStatus = findViewById(R.id.tvDrawerBtStatus)
        tvDrawerClock = findViewById(R.id.tvDrawerClock)
        cardBikeConnection = findViewById(R.id.cardBikeConnection)
        pbBleConnecting = findViewById(R.id.pbBleConnecting)
        tvBleDetailMsg = findViewById(R.id.tvBleDetailMsg)
        btnDrawerBleConnect = findViewById(R.id.btnDrawerBleConnect)
        ivDrawerBleActionIcon = findViewById(R.id.ivDrawerBleActionIcon)
        tvDrawerBleActionText = findViewById(R.id.tvDrawerBleActionText)
        itemSavedPlaces = findViewById(R.id.itemSavedPlaces)
        btnDrawerExit = findViewById(R.id.btnDrawerExit)
        tvDrawerTitle = findViewById(R.id.tvDrawerTitle)
        btnFooterGithub = findViewById(R.id.btnFooterGithub)
    }

    private fun setupListeners() {
        btnMediaPlayPause?.setOnClickListener { toggleMediaPlayback() }
        btnMediaPrev?.setOnClickListener { skipMediaPrevious() }
        btnMediaNext?.setOnClickListener { skipMediaNext() }

        pbMediaTrack?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser && currentMediaDurSec > 0 && seekBar != null) {
                    val scrubSec = ((progress.toFloat() / seekBar.max) * currentMediaDurSec).toInt()
                    tvMediaElapsed?.text = formatTime(scrubSec)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                isUserScrubbingMedia = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                isUserScrubbingMedia = false
                if (currentMediaDurSec > 0 && seekBar != null) {
                    val targetMs = ((seekBar.progress.toFloat() / seekBar.max) * currentMediaDurSec * 1000L).toLong()
                    seekMediaTo(targetMs)
                }
            }
        })

        cardTurnInstruction?.setOnClickListener {
            val route = currentActiveRoute
            if (route != null && currentRouteStepIndex < route.steps.size) {
                val step = route.steps[currentRouteStepIndex]
                val text = if (!step.instruction.isNullOrEmpty()) step.instruction else step.street
                if (!text.isNullOrEmpty()) {
                    speakVoiceGuidance(text)
                }
            }
            mapplsMapView?.centerOnCurrentLocation()
        }

        btnPillPlayPause?.setOnClickListener { toggleMediaPlayback() }
        btnPillNext?.setOnClickListener { skipMediaNext() }
        val expandMediaListener = View.OnClickListener { setMapFullscreen(false) }
        layoutFullscreenMusicPill?.setOnClickListener(expandMediaListener)
        ivPillAlbumArt?.setOnClickListener(expandMediaListener)
        tvPillTrack?.setOnClickListener(expandMediaListener)
        tvPillArtist?.setOnClickListener(expandMediaListener)

        val toggleSplitListener = View.OnClickListener { setMapFullscreen(!isMapFullscreen) }
        viewSplitDivider?.let { divider ->
            divider.setOnClickListener(toggleSplitListener)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                divider.post {
                    val rects = Collections.singletonList(
                        Rect(0, 0, divider.width, divider.height)
                    )
                    divider.systemGestureExclusionRects = rects
                }
            }
        }

        btnOpenDrawer?.setOnClickListener { openDrawer() }
        drawerBackdrop?.setOnClickListener { closeDrawer() }
        btnDrawerClose?.setOnClickListener { closeDrawer() }

        itemSavedPlaces?.setOnClickListener {
            closeDrawer()
            showSavedPlacesDialog()
        }
        btnFooterGithub?.setOnClickListener { openGithubProfile() }
        btnDrawerExit?.setOnClickListener { terminateAppSession() }
        btnDrawerBleConnect?.setOnClickListener { startBikeBleConnection() }

        btnCurrentLocation?.setOnClickListener {
            Log.i("PulsarGPS", "btnCurrentLocation clicked!")
            centerMapOnCurrentLocation()
            hideRecenterButton()
        }

        layoutRecenterPill?.setOnClickListener {
            Log.i("PulsarGPS", "layoutRecenterPill clicked!")
            centerMapOnCurrentLocation()
            hideRecenterButton()
        }

        btnCompass?.setOnClickListener {
            if (mapplsMapView != null) {
                mapplsMapView?.toggleOrientation()
            } else {
                btnCompass?.animate()?.rotation(0f)?.setDuration(350)?.start()
            }
        }

        mapplsMapView?.setOnMapInteractionListener(object : MapplsMapView.OnMapInteractionListener {
            override fun onMapDragged() {
                if (currentActiveRoute != null) {
                    showRecenterButton()
                }
            }

            override fun onMapRecentered() {
                hideRecenterButton()
            }

            override fun onMapBearingChanged(bearing: Double) {
                btnCompass?.rotation = (-bearing).toFloat()
            }

            override fun onOrientationModeChanged(is3D: Boolean, bearing: Double) {
                btnCompass?.let { btn ->
                    if (is3D) {
                        btn.setBackgroundResource(R.drawable.bg_circle_action_active)
                        btn.animate().rotation((-bearing).toFloat()).setDuration(350).start()
                    } else {
                        btn.setBackgroundResource(R.drawable.bg_circle_action)
                        btn.animate().rotation(0f).setDuration(350).start()
                    }
                }
            }
        })

        btnMapSearch?.setOnClickListener { showDestinationSearch() }
        setupSearchOverlay()

        btnVoiceNav?.setOnClickListener {
            isVoiceMuted = !isVoiceMuted
            btnVoiceNav?.setImageResource(if (isVoiceMuted) R.drawable.ic_volume_off else R.drawable.ic_volume_up)
            btnVoiceNav?.alpha = if (isVoiceMuted) 0.6f else 1.0f
            val msg = if (isVoiceMuted) "Voice Guidance Muted" else "Voice Guidance Active"
            speakVoiceGuidance(msg)
        }

        btnStartNavNow?.setOnClickListener { startActiveNavigation() }
        btnCancelRoutePreview?.setOnClickListener { cancelRoutePreview() }
        btnLayers?.setOnClickListener { mapplsMapView?.toggleMapTheme() }
        btnNavEnd?.setOnClickListener { endActiveNavigation() }

        viewDrawerBtStatusDot?.setOnClickListener { toggleBleConnection() }
        tvDrawerBtStatus?.setOnClickListener { toggleBleConnection() }
    }

    private fun speakVoiceGuidance(message: String?) {
        if (isVoiceMuted || !isTtsReady || tts == null || message.isNullOrBlank()) {
            return
        }
        try {
            tts?.speak(message, TextToSpeech.QUEUE_FLUSH, null, "BAJAJ_NAV_TTS")
        } catch (ignored: Exception) {}
    }

    private fun showSavedPlacesDialog() {
        val placeNames = arrayOf(
            "🏠 Home (Saved)",
            "🏢 Office / Work",
            "⛽ Fuel Station (Nearby)",
            "📍 Jaipur Pink City (Hawa Mahal)",
            "📍 Delhi Aerocity (IGI Airport)"
        )
        val refLat = if (currentRiderLat != 0.0) currentRiderLat else 28.6139
        val refLng = if (currentRiderLng != 0.0) currentRiderLng else 77.2090
        val places = arrayOf(
            MapplsApiClient.PlaceResult("Home", "Saved Primary Location", "", refLat + 0.015, refLng + 0.012, 0.0, "HOME"),
            MapplsApiClient.PlaceResult("Office / Work", "Business District Area", "", refLat - 0.020, refLng - 0.015, 0.0, "WORK"),
            MapplsApiClient.PlaceResult("Fuel Station", "Highway Fuel & Service Hub", "", refLat + 0.035, refLng - 0.008, 0.0, "FUEL"),
            MapplsApiClient.PlaceResult("Jaipur (Pink City)", "Hawa Mahal Rd, Jaipur, Rajasthan", "3T7XV6", 26.9239, 75.8267, 0.0, "CITY"),
            MapplsApiClient.PlaceResult("Delhi Aerocity", "IGI Airport, New Delhi", "", 28.5562, 77.1000, 0.0, "AIRPORT")
        )

        val builder = AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert)
        builder.setTitle("★ Saved Places & Favorites")
        builder.setItems(placeNames) { dialog, which ->
            dialog.dismiss()
            if (which in places.indices) {
                previewRoute(places[which])
            }
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        styleCockpitDialog(dialog)
        dialog.show()
    }

    private fun styleCockpitDialog(dialog: AlertDialog?) {
        dialog ?: return
        dialog.setOnShowListener {
            val accent = COLOR_PULSAR_CYAN
            val border = COLOR_PULSAR_BORDER
            val density = resources.displayMetrics.density.toInt()

            dialog.window?.let { win ->
                val winBg = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = (22 * density).toFloat()
                    setColor(0xF80A0B0E.toInt())
                    setStroke((1.2f * density).toInt(), border)
                }
                win.setBackgroundDrawable(winBg)
            }

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)?.let { pos ->
                pos.setTextColor(accent)
                pos.isAllCaps = false
                pos.setTypeface(null, Typeface.BOLD)
            }
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE)?.let { neg ->
                neg.setTextColor(0xFF94A3B8.toInt())
                neg.isAllCaps = false
            }
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL)?.let { neu ->
                neu.setTextColor(0xFF94A3B8.toInt())
                neu.isAllCaps = false
            }

            dialog.findViewById<TextView>(android.R.id.message)?.let { msg ->
                msg.setTextColor(0xFFE2E8F0.toInt())
                msg.setLineSpacing(0f, 1.25f)
            }
        }
    }

    private fun openGithubProfile() {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Deepak5310")))
        } catch (ignored: Exception) {}
    }

    private fun toggleBleConnection() {
        startBikeBleConnection()
    }

    private fun toggleMediaPlayback() {
        if (!MediaStateListener.isNotificationListenerEnabled(this)) {
            Toast.makeText(this, "Enable Notification Access to control music", Toast.LENGTH_LONG).show()
            try {
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            } catch (ignored: Exception) {}
            return
        }

        val msl = MediaStateListener.instance
        if (msl != null) {
            msl.togglePlayPause()
        } else {
            val svc = PulsarForegroundService.instance
            if (svc?.mediaListener != null) {
                svc.mediaListener?.togglePlayPause()
            } else {
                sendDirectMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
            }
        }
    }

    private fun skipMediaNext() {
        if (!MediaStateListener.isNotificationListenerEnabled(this)) {
            Toast.makeText(this, "Enable Notification Access to control music", Toast.LENGTH_LONG).show()
            try {
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            } catch (ignored: Exception) {}
            return
        }

        val msl = MediaStateListener.instance
        if (msl != null) {
            msl.skipNext()
        } else {
            val svc = PulsarForegroundService.instance
            if (svc?.mediaListener != null) {
                svc.mediaListener?.skipNext()
            } else {
                sendDirectMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT)
            }
        }
    }

    private fun skipMediaPrevious() {
        if (!MediaStateListener.isNotificationListenerEnabled(this)) {
            Toast.makeText(this, "Enable Notification Access to control music", Toast.LENGTH_LONG).show()
            try {
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            } catch (ignored: Exception) {}
            return
        }

        val msl = MediaStateListener.instance
        if (msl != null) {
            msl.skipPrevious()
        } else {
            val svc = PulsarForegroundService.instance
            if (svc?.mediaListener != null) {
                svc.mediaListener?.skipPrevious()
            } else {
                sendDirectMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS)
            }
        }
    }

    private fun seekMediaTo(targetMs: Long) {
        val msl = MediaStateListener.instance
        if (msl != null) {
            msl.seekTo(targetMs)
        } else {
            val svc = PulsarForegroundService.instance
            svc?.mediaListener?.seekTo(targetMs)
        }
    }

    private fun sendDirectMediaKey(keyCode: Int) {
        val am = getSystemService(Context.AUDIO_SERVICE) as? AudioManager
        if (am != null) {
            val now = SystemClock.uptimeMillis()
            am.dispatchMediaKeyEvent(KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0))
            am.dispatchMediaKeyEvent(KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0))
        }
    }

    fun setMapFullscreen(fullscreen: Boolean) {
        isMapFullscreen = fullscreen
        val density = resources.displayMetrics.density
        val panelWidth = 250f * density
        if (fullscreen) {
            layoutLeftPanel?.animate()
                ?.translationX(-panelWidth)
                ?.setDuration(280)
                ?.setInterpolator(DecelerateInterpolator(2.0f))
                ?.withEndAction {
                    if (isMapFullscreen) {
                        layoutLeftPanel?.visibility = View.GONE
                    }
                }
                ?.start()

            viewSplitDivider?.animate()
                ?.translationX(0f)
                ?.setDuration(280)
                ?.setInterpolator(DecelerateInterpolator(2.0f))
                ?.start()

            ivSplitHandleChevron?.animate()?.rotation(180f)?.setDuration(280)?.start()

            layoutMapStartHudContainer?.animate()
                ?.translationX(0f)
                ?.setDuration(280)
                ?.setInterpolator(DecelerateInterpolator(2.0f))
                ?.start()

            layoutFullscreenMusicPill?.let { pill ->
                pill.visibility = View.VISIBLE
                pill.alpha = 0f
                pill.translationY = 40f
                pill.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(280)
                    .setInterpolator(DecelerateInterpolator(1.8f))
                    .start()
            }
        } else {
            layoutLeftPanel?.visibility = View.VISIBLE
            layoutLeftPanel?.animate()
                ?.translationX(0f)
                ?.setDuration(280)
                ?.setInterpolator(DecelerateInterpolator(2.0f))
                ?.start()

            viewSplitDivider?.animate()
                ?.translationX(panelWidth)
                ?.setDuration(280)
                ?.setInterpolator(DecelerateInterpolator(2.0f))
                ?.start()

            ivSplitHandleChevron?.animate()?.rotation(0f)?.setDuration(280)?.start()

            layoutMapStartHudContainer?.animate()
                ?.translationX(panelWidth)
                ?.setDuration(280)
                ?.setInterpolator(DecelerateInterpolator(2.0f))
                ?.start()

            layoutFullscreenMusicPill?.animate()
                ?.alpha(0f)
                ?.translationY(40f)
                ?.setDuration(200)
                ?.setInterpolator(AccelerateInterpolator(1.8f))
                ?.withEndAction { layoutFullscreenMusicPill?.visibility = View.GONE }
                ?.start()
        }
    }

    private fun openDrawer() {
        drawerBackdrop?.let { backdrop ->
            backdrop.visibility = View.VISIBLE
            backdrop.alpha = 0f
            backdrop.animate()
                .alpha(1f)
                .setDuration(260)
                .setInterpolator(DecelerateInterpolator(2.0f))
                .start()
        }

        drawerPanel?.let { panel ->
            panel.visibility = View.VISIBLE
            val width = if (panel.width > 0) panel.width else 800
            panel.translationX = width.toFloat()
            panel.animate()
                .translationX(0f)
                .setDuration(300)
                .setInterpolator(DecelerateInterpolator(2.2f))
                .start()
        }

        val drawerItems = arrayOf(
            cardBikeStage,
            cardBikeConnection,
            itemSavedPlaces,
            btnDrawerExit,
            btnFooterGithub
        )

        for (i in drawerItems.indices) {
            val item = drawerItems[i]
            if (item != null) {
                item.alpha = 0f
                item.translationX = 50f
                item.animate()
                    .alpha(1f)
                    .translationX(0f)
                    .setDuration(250)
                    .setStartDelay((50 + (i * 25)).toLong())
                    .setInterpolator(OvershootInterpolator(1.2f))
                    .start()
            }
        }
    }

    private fun closeDrawer() {
        drawerBackdrop?.animate()
            ?.alpha(0f)
            ?.setDuration(200)
            ?.setInterpolator(AccelerateInterpolator(1.8f))
            ?.withEndAction { drawerBackdrop?.visibility = View.GONE }
            ?.start()

        val width = if ((drawerPanel?.width ?: 0) > 0) drawerPanel!!.width else 800
        drawerPanel?.animate()
            ?.translationX(width.toFloat())
            ?.setDuration(240)
            ?.setInterpolator(AccelerateInterpolator(2.0f))
            ?.withEndAction { drawerPanel?.visibility = View.GONE }
            ?.start()
    }

    private fun initLiveSystemSensors() {
        try {
            val bm = getSystemService(Context.BATTERY_SERVICE) as? BatteryManager
            if (bm != null) {
                val cap = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
                val status = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS)
                isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL
                if (cap >= 0) {
                    currentBattery = cap
                    updateBatteryDisplay(currentBattery, isCharging)
                }
            }
        } catch (ignored: Exception) {}

        try {
            val tm = getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            if (tm != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    tm.registerTelephonyCallback(mainExecutor, MainSignalCallback(this))
                } else {
                    tm.listen(object : PhoneStateListener() {
                        @Deprecated("Deprecated in Java")
                        override fun onSignalStrengthsChanged(signalStrength: SignalStrength?) {
                            signalStrength?.let {
                                currentSignalBars = it.level
                                runOnUiThread { updateSignalDisplay(currentSignalBars) }
                            }
                        }
                    }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
                }
            }
        } catch (ignored: SecurityException) {}

        initGpsTracking()
    }

    @TargetApi(Build.VERSION_CODES.S)
    private class MainSignalCallback(
        private val activity: MainActivity
    ) : TelephonyCallback(), TelephonyCallback.SignalStrengthsListener {
        override fun onSignalStrengthsChanged(signalStrength: SignalStrength) {
            activity.currentSignalBars = signalStrength.level
            activity.runOnUiThread { activity.updateSignalDisplay(activity.currentSignalBars) }
        }
    }

    private fun updateBatteryDisplay(percent: Int, charging: Boolean) {
        // Telemetry display hook
    }

    private fun updateSignalDisplay(bars: Int) {
        // Telemetry display hook
    }

    private fun setupMicroAnimations() {
        if (viewDrawerBtStatusDot != null) {
            pulseAnimator = ObjectAnimator.ofFloat(viewDrawerBtStatusDot, "alpha", 0.3f, 1.0f).apply {
                duration = 900
                repeatMode = ValueAnimator.REVERSE
                repeatCount = ValueAnimator.INFINITE
                start()
            }
        }

        val tactileTouch = View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.92f).scaleY(0.92f).setDuration(90).setInterpolator(DecelerateInterpolator()).start()
                    try {
                        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                    } catch (ignored: Exception) {}
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(220).setInterpolator(OvershootInterpolator(2.2f)).start()
                }
            }
            false
        }

        val tactileViews = arrayOf(
            btnMediaPlayPause, btnMediaPrev, btnMediaNext, btnPillPlayPause, btnPillNext,
            btnOpenDrawer, btnDrawerClose, btnNavEnd, btnCompass, btnCurrentLocation, btnVoiceNav, btnLayers,
            btnDrawerExit, btnDrawerBleConnect, btnMapSearch, btnStartNavNow, btnCancelRoutePreview,
            layoutRecenterPill, btnSearchCancel, btnSearchClear, btnSearchImeToggle, viewSplitDivider,
            itemSavedPlaces, btnFooterGithub
        )
        for (view in tactileViews) {
            view?.setOnTouchListener(tactileTouch)
        }
    }

    private fun updateCockpitMedia(
        title: String?,
        artist: String?,
        source: String?,
        state: Int,
        posSec: Int,
        durSec: Int,
        art: Bitmap?
    ) {
        runOnUiThread {
            if (title.isNullOrBlank() || (state == 0 && (title.isEmpty() || title == "No Media"))) {
                tvMediaTrack?.text = "No Media Playing"
                tvMediaArtist?.text = "Start playback on phone"
                tvMediaSource?.text = "Standby"
                tvPillTrack?.text = "No Media"
                tvPillArtist?.text = "Standby"
                btnMediaPlayPause?.setImageResource(R.drawable.ic_media_play)
                btnPillPlayPause?.setImageResource(R.drawable.ic_media_play)
                btnMediaPlayPause?.setColorFilter(COLOR_PULSAR_CYAN)
                btnPillPlayPause?.setColorFilter(COLOR_PULSAR_CYAN)
                findViewById<View>(R.id.viewMediaPulseDot)?.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(0xFF64748B.toInt())
                currentMediaDurSec = 0
                pbMediaTrack?.progress = 0
                (pbMediaTrack as? WavySeekBar)?.setPlaying(false)
                tvMediaElapsed?.text = "0:00"
                tvMediaDuration?.text = "0:00"
                ivAlbumArt?.scaleType = ImageView.ScaleType.CENTER_INSIDE
                ivAlbumArt?.setImageResource(R.drawable.ic_album_art_placeholder)
                ivPillAlbumArt?.setImageResource(R.drawable.ic_pulsar_logo)
            } else {
                tvMediaTrack?.text = title
                tvPillTrack?.text = title

                val artistStr = if (!artist.isNullOrBlank()) artist else "Unknown Artist"
                tvMediaArtist?.text = artistStr
                tvPillArtist?.text = artistStr

                if (!source.isNullOrEmpty()) {
                    tvMediaSource?.text = source
                }

                val isPlaying = state == 2
                val accent = COLOR_PULSAR_CYAN
                findViewById<View>(R.id.viewMediaPulseDot)?.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(if (isPlaying) accent else 0xFF64748B.toInt())

                if (isPlaying) {
                    btnMediaPlayPause?.setImageResource(R.drawable.ic_media_pause)
                    btnPillPlayPause?.setImageResource(R.drawable.ic_media_pause)
                } else {
                    btnMediaPlayPause?.setImageResource(R.drawable.ic_media_play)
                    btnPillPlayPause?.setImageResource(R.drawable.ic_media_play)
                }
                btnMediaPlayPause?.setColorFilter(accent)
                btnPillPlayPause?.setColorFilter(accent)
                (pbMediaTrack as? WavySeekBar)?.setPlaying(isPlaying)

                currentMediaDurSec = durSec
                if (!isUserScrubbingMedia && pbMediaTrack != null) {
                    val track = pbMediaTrack!!
                    if (durSec > 0) {
                        val progress = ((posSec.toFloat() / durSec) * track.max).toInt()
                        track.progress = min(track.max, max(0, progress))
                        tvMediaElapsed?.text = formatTime(posSec)
                        tvMediaDuration?.text = formatTime(durSec)
                    } else if (posSec > 0) {
                        tvMediaElapsed?.text = formatTime(posSec)
                    }
                }

                if (art != null) {
                    ivAlbumArt?.scaleType = ImageView.ScaleType.CENTER_CROP
                    ivAlbumArt?.setImageBitmap(art)
                    ivPillAlbumArt?.scaleType = ImageView.ScaleType.CENTER_CROP
                    ivPillAlbumArt?.setImageBitmap(art)
                } else {
                    ivAlbumArt?.scaleType = ImageView.ScaleType.CENTER_INSIDE
                    ivAlbumArt?.setImageResource(R.drawable.ic_album_art_placeholder)
                    ivPillAlbumArt?.setImageResource(R.drawable.ic_pulsar_logo)
                }
            }
        }
    }

    private fun formatTime(totalSeconds: Int): String {
        val m = totalSeconds / 60
        val s = totalSeconds % 60
        return String.format(Locale.getDefault(), "%d:%02d", m, s)
    }

    private fun startBikeBleConnection() {
        if (bleManager?.isConnected == true) {
            bleManager?.setAutoReconnect(false)
            bleManager?.disconnect()
            updateBleUiState(BleUiState.DISCONNECTED, null)
            return
        }

        if (isBleConnecting) {
            isBleConnecting = false
            bleTimeoutHandler.removeCallbacks(bleTimeoutRunnable)
            bleManager?.stopScan()
            bleManager?.disconnect()
            updateBleUiState(BleUiState.DISCONNECTED, null)
            return
        }

        val bm = getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        val adapter = bm?.adapter
        if (adapter == null) {
            Toast.makeText(this, "Bluetooth not supported on this device", Toast.LENGTH_SHORT).show()
            return
        }

        if (!adapter.isEnabled) {
            try {
                startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQUEST_ENABLE_BT)
            } catch (e: Exception) {
                Toast.makeText(this, "Please enable Bluetooth in settings", Toast.LENGTH_SHORT).show()
            }
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ),
                    1003
                )
                return
            }
        }

        isBleConnecting = true
        updateBleUiState(BleUiState.CONNECTING, null)
        bleTimeoutHandler.removeCallbacks(bleTimeoutRunnable)
        bleTimeoutHandler.postDelayed(bleTimeoutRunnable, 30000)

        bleManager?.setAutoReconnect(true)
        bleManager?.startScanOrConnect()
    }

    private fun setStatusDotColor(color: Int, alphaVal: Float) {
        viewDrawerBtStatusDot?.let { dot ->
            val bg = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(color)
            }
            dot.background = bg
            dot.alpha = alphaVal
        }
    }

    private fun updateBleUiState(state: BleUiState, bikeName: String?) {
        tvDrawerBtStatus ?: return
        val accent = COLOR_PULSAR_CYAN
        val density = resources.displayMetrics.density

        when (state) {
            BleUiState.DISCONNECTED -> {
                isBleConnecting = false
                setStatusDotColor(0xFF64748B.toInt(), 0.4f)
                tvDrawerBtStatus?.text = "Disconnected"
                tvDrawerBtStatus?.setTextColor(0xFF94A3B8.toInt())
                pbBleConnecting?.visibility = View.GONE
                tvBleDetailMsg?.text = "Tap connect to pair bike"
                tvBleDetailMsg?.setTextColor(0xFF64748B.toInt())
                ivDrawerBleActionIcon?.setImageResource(R.drawable.ic_bluetooth)
                ivDrawerBleActionIcon?.setColorFilter(0xFF000000.toInt())
                tvDrawerBleActionText?.text = "Connect to Bike"
                tvDrawerBleActionText?.setTextColor(0xFF000000.toInt())
                btnDrawerBleConnect?.let { btn ->
                    val bg = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 10 * density
                        setColor(accent)
                    }
                    btn.background = bg
                }
                tvDrawerBikeName?.text = "Pulsar NS400Z"
            }
            BleUiState.CONNECTING -> {
                setStatusDotColor(0xFFF59E0B.toInt(), 1.0f)
                tvDrawerBtStatus?.text = "Connecting..."
                tvDrawerBtStatus?.setTextColor(0xFFF59E0B.toInt())
                pbBleConnecting?.visibility = View.VISIBLE
                tvBleDetailMsg?.text = "Scanning for bike BLE beacon (30s)..."
                tvBleDetailMsg?.setTextColor(0xFFF59E0B.toInt())
                ivDrawerBleActionIcon?.setImageResource(R.drawable.ic_close)
                ivDrawerBleActionIcon?.setColorFilter(0xFFEF4444.toInt())
                tvDrawerBleActionText?.text = "Cancel"
                tvDrawerBleActionText?.setTextColor(0xFFEF4444.toInt())
                btnDrawerBleConnect?.let { btn ->
                    val bg = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 10 * density
                        setColor(0x22EF4444.toInt())
                        setStroke((1.2f * density).toInt(), 0xFFEF4444.toInt())
                    }
                    btn.background = bg
                }
                tvDrawerBikeName?.text = "Searching Bike..."
            }
            BleUiState.CONNECTED -> {
                isBleConnecting = false
                val displayName = if (!bikeName.isNullOrBlank()) bikeName else "Bajaj Pulsar NS400Z"
                setStatusDotColor(0xFF10B981.toInt(), 1.0f)
                tvDrawerBtStatus?.text = "Connected: $displayName"
                tvDrawerBtStatus?.setTextColor(0xFF10B981.toInt())
                pbBleConnecting?.visibility = View.GONE
                tvBleDetailMsg?.text = "BLE Live Telemetry & Nav Sync Active"
                tvBleDetailMsg?.setTextColor(0xFF10B981.toInt())
                ivDrawerBleActionIcon?.setImageResource(R.drawable.ic_bluetooth)
                ivDrawerBleActionIcon?.setColorFilter(0xFFEF4444.toInt())
                tvDrawerBleActionText?.text = "Disconnect"
                tvDrawerBleActionText?.setTextColor(0xFFEF4444.toInt())
                btnDrawerBleConnect?.let { btn ->
                    val bg = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 10 * density
                        setColor(0x22EF4444.toInt())
                        setStroke((1.2f * density).toInt(), 0xFFEF4444.toInt())
                    }
                    btn.background = bg
                }
                tvDrawerBikeName?.text = displayName
            }
            BleUiState.FAILED -> {
                isBleConnecting = false
                setStatusDotColor(0xFFEF4444.toInt(), 1.0f)
                tvDrawerBtStatus?.text = "Connection Failed"
                tvDrawerBtStatus?.setTextColor(0xFFEF4444.toInt())
                pbBleConnecting?.visibility = View.GONE
                tvBleDetailMsg?.text = "Bike cluster not found within 30s"
                tvBleDetailMsg?.setTextColor(0xFFEF4444.toInt())
                ivDrawerBleActionIcon?.setImageResource(R.drawable.ic_refresh)
                ivDrawerBleActionIcon?.setColorFilter(0xFF000000.toInt())
                tvDrawerBleActionText?.text = "Retry Connection"
                tvDrawerBleActionText?.setTextColor(0xFF000000.toInt())
                btnDrawerBleConnect?.let { btn ->
                    val bg = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 10 * density
                        setColor(accent)
                    }
                    btn.background = bg
                }
                tvDrawerBikeName?.text = "Pulsar NS400Z"
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BT) {
            val bm = getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
            val adapter = bm?.adapter
            if (adapter != null && adapter.isEnabled) {
                startBikeBleConnection()
            } else {
                Toast.makeText(this, "Bluetooth is required to connect to bike", Toast.LENGTH_LONG).show()
                updateBleUiState(BleUiState.DISCONNECTED, null)
            }
        }
    }

    override fun onConnectionStateChanged(connected: Boolean, deviceName: String, deviceAddress: String) {
        bleTimeoutHandler.removeCallbacks(bleTimeoutRunnable)
        isBleConnecting = false
        runOnUiThread {
            if (connected) {
                updateBleUiState(BleUiState.CONNECTED, deviceName)
            } else {
                updateBleUiState(BleUiState.DISCONNECTED, null)
            }
        }
    }

    private fun terminateAppSession() {
        bleManager?.apply {
            setAutoReconnect(false)
            stopScan()
            disconnect()
        }

        try {
            val stopIntent = Intent(this, PulsarForegroundService::class.java).apply {
                action = PulsarForegroundService.ACTION_STOP
            }
            startService(stopIntent)
        } catch (ignored: Exception) {}

        try {
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            nm?.cancelAll()
        } catch (ignored: Exception) {}

        finishAffinity()

        Handler(Looper.getMainLooper()).postDelayed({
            Process.killProcess(Process.myPid())
            exitProcess(0)
        }, 150)
    }

    override fun onPacketSent(charUuid: String, frame: ByteArray?, success: Boolean) {}

    override fun onHandlebarEvent(event: PulsarProtocol.HandlebarEvent) {}

    private fun requestAppPermissions() {
        val perms = mutableListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.ANSWER_PHONE_CALLS
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            perms.add(Manifest.permission.BLUETOOTH_SCAN)
            perms.add(Manifest.permission.BLUETOOTH_CONNECT)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            perms.add(Manifest.permission.POST_NOTIFICATIONS)
        }

        val needed = perms.filter { checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED }
        if (needed.isNotEmpty()) {
            Log.i("PulsarGPS", "Requesting missing permissions: $needed")
            requestPermissions(needed.toTypedArray(), PERMISSION_REQ_CODE)
        } else {
            Log.i("PulsarGPS", "All permissions already granted")
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQ_CODE) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.i("PulsarGPS", "onRequestPermissionsResult: Location permission granted! Initializing GPS...")
                initGpsTracking()
                mapplsMapView?.centerOnCurrentLocation()
            } else {
                Log.w("PulsarGPS", "onRequestPermissionsResult: Location permission was DENIED")
                Toast.makeText(this, "Location permission is required for live GPS", Toast.LENGTH_LONG).show()
            }
        }
    }

    private val gpsLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            currentRiderLat = location.latitude
            currentRiderLng = location.longitude
            try {
                getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .putFloat("saved_rider_lat", currentRiderLat.toFloat())
                    .putFloat("saved_rider_lng", currentRiderLng.toFloat())
                    .apply()
            } catch (ignored: Exception) {}
            if (location.hasBearing()) {
                currentRiderBearing = location.bearing
            }

            if (location.hasSpeed() && location.speed >= 0) {
                currentSpeedKmh = (location.speed * 3.6f).roundToInt()
            } else if (lastSpeedLocation != null && lastSpeedTimeMs > 0) {
                var dtMs = location.time - lastSpeedTimeMs
                if (dtMs <= 0) {
                    dtMs = System.currentTimeMillis() - lastSpeedTimeMs
                }
                if (dtMs in 401..9999) {
                    val dist = lastSpeedLocation!!.distanceTo(location)
                    val speedMps = dist / (dtMs / 1000.0f)
                    currentSpeedKmh = (speedMps * 3.6f).roundToInt()
                } else if (dtMs >= 10000) {
                    currentSpeedKmh = 0
                }
            } else {
                currentSpeedKmh = 0
            }
            lastSpeedLocation = location
            lastSpeedTimeMs = if (location.time > 0) location.time else System.currentTimeMillis()

            if (currentSpeedKmh < 0) currentSpeedKmh = 0
            if (currentSpeedKmh > 299) currentSpeedKmh = 299

            tvCurrentSpeed?.let { tv ->
                var prevSpeed = 0
                try {
                    prevSpeed = tv.text.toString().toInt()
                } catch (ignored: Exception) {}
                tv.text = currentSpeedKmh.toString()
                if (currentSpeedKmh > 80) {
                    tv.setTextColor(Color.parseColor("#EF4444"))
                    tv.animate().scaleX(1.08f).scaleY(1.08f).setDuration(120).withEndAction {
                        tv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(120).start()
                    }.start()
                } else {
                    tv.setTextColor(Color.parseColor("#FFFFFF"))
                    if (kotlin.math.abs(currentSpeedKmh - prevSpeed) >= 4) {
                        tv.animate().scaleX(1.05f).scaleY(1.05f).setDuration(100).withEndAction {
                            tv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start()
                        }.start()
                    }
                }
            }

            mapplsMapView?.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing)
            checkRouteProgress(location)
        }
    }

    private fun isDeviceLocationEnabled(): Boolean {
        if (locationManager == null) {
            locationManager = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
        }
        val lm = locationManager ?: return false
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            lm.isLocationEnabled
        } else {
            lm.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        }
    }

    private fun initGpsTracking() {
        try {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.w("PulsarGPS", "initGpsTracking: Location permission not granted")
                return
            }
            if (!isDeviceLocationEnabled()) {
                Log.w("PulsarGPS", "initGpsTracking: Device location is disabled")
                return
            }
            if (locationManager == null) {
                locationManager = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
            }
            val lm = locationManager
            if (lm != null) {
                var last = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (last == null) {
                    last = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                }
                if (last == null) {
                    last = lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
                }
                if (last != null) {
                    currentRiderLat = last.latitude
                    currentRiderLng = last.longitude
                    Log.i("PulsarGPS", "initGpsTracking: Found last location=$currentRiderLat,$currentRiderLng")
                    try {
                        getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                            .edit()
                            .putFloat("saved_rider_lat", currentRiderLat.toFloat())
                            .putFloat("saved_rider_lng", currentRiderLng.toFloat())
                            .apply()
                    } catch (ignored: Exception) {}
                    mapplsMapView?.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing)
                }

                try {
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f, gpsLocationListener, Looper.getMainLooper())
                } catch (e: Exception) {
                    Log.w("PulsarGPS", "GPS_PROVIDER request error: ${e.message}")
                }
                try {
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000L, 1.0f, gpsLocationListener, Looper.getMainLooper())
                } catch (e: Exception) {
                    Log.w("PulsarGPS", "NETWORK_PROVIDER request error: ${e.message}")
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    try {
                        lm.getCurrentLocation(LocationManager.GPS_PROVIDER, null, mainExecutor) { loc ->
                            if (loc != null) gpsLocationListener.onLocationChanged(loc)
                        }
                        lm.getCurrentLocation(LocationManager.NETWORK_PROVIDER, null, mainExecutor) { loc ->
                            if (loc != null) gpsLocationListener.onLocationChanged(loc)
                        }
                    } catch (ignored: Exception) {}
                }
            }
        } catch (e: Exception) {
            Log.e("PulsarGPS", "initGpsTracking error: ${e.message}")
        }
    }

    private fun centerMapOnCurrentLocation() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.w("PulsarGPS", "centerMapOnCurrentLocation: Permission not granted, requesting...")
            Toast.makeText(this, "Location permission is required for live GPS", Toast.LENGTH_SHORT).show()
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                PERMISSION_REQ_CODE
            )
            return
        }

        if (!isDeviceLocationEnabled()) {
            Log.w("PulsarGPS", "centerMapOnCurrentLocation: Device location is disabled")
            Toast.makeText(this, "Location / GPS is disabled. Please turn it ON in Settings.", Toast.LENGTH_LONG).show()
            try {
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            } catch (ignored: Exception) {}
            return
        }

        initGpsTracking()

        try {
            val lm = locationManager
            if (lm != null) {
                var loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (loc == null) {
                    loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                }
                if (loc == null) {
                    loc = lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
                }
                if (loc != null) {
                    currentRiderLat = loc.latitude
                    currentRiderLng = loc.longitude
                    if (loc.hasBearing()) {
                        currentRiderBearing = loc.bearing
                    }
                    Log.i("PulsarGPS", "centerMapOnCurrentLocation: got location=$currentRiderLat,$currentRiderLng")
                    try {
                        getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                            .edit()
                            .putFloat("saved_rider_lat", currentRiderLat.toFloat())
                            .putFloat("saved_rider_lng", currentRiderLng.toFloat())
                            .apply()
                    } catch (ignored: Exception) {}
                }
            }
        } catch (e: Exception) {
            Log.e("PulsarGPS", "centerMapOnCurrentLocation error: ${e.message}")
        }

        if (currentRiderLat == 0.0) {
            try {
                val prefs = getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                val savedLat = prefs.getFloat("saved_rider_lat", 0f)
                val savedLng = prefs.getFloat("saved_rider_lng", 0f)
                if (savedLat != 0f && savedLng != 0f) {
                    currentRiderLat = savedLat.toDouble()
                    currentRiderLng = savedLng.toDouble()
                    Log.i("PulsarGPS", "centerMapOnCurrentLocation: restored from prefs=$currentRiderLat,$currentRiderLng")
                }
            } catch (ignored: Exception) {}
        }

        if (mapplsMapView != null) {
            if (currentRiderLat != 0.0 && currentRiderLng != 0.0) {
                mapplsMapView?.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing)
                mapplsMapView?.centerOnCurrentLocation()
                Log.i("PulsarGPS", "centerMapOnCurrentLocation: centered successfully on $currentRiderLat,$currentRiderLng")
            } else {
                Log.w("PulsarGPS", "centerMapOnCurrentLocation: rider location still 0.0, acquiring fix...")
                Toast.makeText(this, "Acquiring live GPS fix...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showRecenterButton() {
        if (currentActiveRoute == null) return
        layoutRecenterPill?.let { pill ->
            if (pill.visibility != View.VISIBLE) {
                pill.visibility = View.VISIBLE
                pill.alpha = 0f
                pill.translationY = -35f
                pill.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(280)
                    .setInterpolator(OvershootInterpolator(1.8f))
                    .start()
            }
        }
        btnCurrentLocation?.setColorFilter(Color.parseColor("#F59E0B"))
    }

    private fun hideRecenterButton() {
        layoutRecenterPill?.let { pill ->
            if (pill.visibility == View.VISIBLE) {
                pill.animate()
                    .alpha(0f)
                    .translationY(-35f)
                    .setDuration(200)
                    .setInterpolator(AccelerateInterpolator(1.8f))
                    .withEndAction { pill.visibility = View.GONE }
                    .start()
            }
        }
        btnCurrentLocation?.setColorFilter(COLOR_PULSAR_CYAN)
    }

    private fun checkRouteProgress(riderLocation: Location) {
        val route = currentActiveRoute ?: return
        if (route.steps.isEmpty()) return

        if (currentRouteStepIndex >= route.steps.size) {
            endActiveNavigation()
            return
        }

        var step = route.steps[currentRouteStepIndex]
        while (step.lat == 0.0 && step.lng == 0.0 && currentRouteStepIndex < route.steps.size - 1) {
            currentRouteStepIndex++
            step = route.steps[currentRouteStepIndex]
        }

        val results = FloatArray(1)
        var distToStep: Float = if (step.lat != 0.0 || step.lng != 0.0) {
            Location.distanceBetween(riderLocation.latitude, riderLocation.longitude, step.lat, step.lng, results)
            results[0]
        } else {
            step.distanceMeters.toFloat()
        }

        if (distToStep < 30f) {
            if (currentRouteStepIndex < route.steps.size - 1) {
                currentRouteStepIndex++
                step = route.steps[currentRouteStepIndex]
                distToStep = if (step.lat != 0.0 || step.lng != 0.0) {
                    Location.distanceBetween(riderLocation.latitude, riderLocation.longitude, step.lat, step.lng, results)
                    results[0]
                } else {
                    step.distanceMeters.toFloat()
                }
                val instr = if (!step.instruction.isNullOrEmpty()) step.instruction else step.street
                if (!instr.isNullOrEmpty()) {
                    speakVoiceGuidance(instr)
                }
            } else {
                speakVoiceGuidance("You have arrived at your destination")
                Toast.makeText(this, "Destination Reached", Toast.LENGTH_LONG).show()
                endActiveNavigation()
                return
            }
        }

        var remDist = distToStep.toDouble()
        var remDur = step.durationSeconds
        for (i in currentRouteStepIndex + 1 until route.steps.size) {
            remDist += route.steps[i].distanceMeters
            remDur += route.steps[i].durationSeconds
        }

        updateRouteStepDisplay(step, distToStep.toDouble(), remDist, remDur)
    }

    private fun setupSearchOverlay() {
        layoutSearchOverlay ?: return

        layoutSearchOverlay?.setOnClickListener { hideDestinationSearch() }
        cardSearchBox?.setOnClickListener {}
        btnSearchCancel?.setOnClickListener { hideDestinationSearch() }
        btnSearchClear?.setOnClickListener { etSearchQuery?.setText("") }

        val adapter = object : ArrayAdapter<MapplsApiClient.PlaceResult>(
            this, R.layout.item_search_place, searchPlaceList
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val row = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_search_place, parent, false)
                val item = getItem(position)
                if (item != null) {
                    val tvName = row.findViewById<TextView>(R.id.tvPlaceName)
                    val tvAddr = row.findViewById<TextView>(R.id.tvPlaceAddress)
                    val tvPin = row.findViewById<TextView>(R.id.tvPlacePin)
                    val tvDist = row.findViewById<TextView>(R.id.tvPlaceDistance)

                    tvName.text = item.name
                    tvAddr.text = item.address
                    val distStr = item.getFormattedDistance()
                    if (distStr.isNotEmpty()) {
                        tvDist.text = distStr
                        tvDist.visibility = View.VISIBLE
                    } else {
                        tvDist.visibility = View.GONE
                    }
                    if (item.mapplsPin.isNotEmpty()) {
                        tvPin.text = item.mapplsPin
                        tvPin.visibility = View.VISIBLE
                    } else {
                        tvPin.visibility = View.GONE
                    }
                }
                return row
            }
        }
        searchAdapter = adapter
        lvSearchResults?.adapter = adapter
        lvSearchResults?.setOnItemClickListener { _, _, position, _ ->
            val selected = searchPlaceList[position]
            hideDestinationSearch()
            previewRoute(selected)
        }

        val searchRunnable = Runnable {
            val query = etSearchQuery?.text?.toString()?.trim().orEmpty()
            if (query.length < 2) return@Runnable
            pbSearchProgress?.visibility = View.VISIBLE
            MapplsApiClient.getInstance().searchPlaces(
                query,
                currentRiderLat,
                currentRiderLng,
                object : MapplsApiClient.PlacesCallback {
                    override fun onSuccess(results: List<MapplsApiClient.PlaceResult>) {
                        pbSearchProgress?.visibility = View.INVISIBLE
                        searchPlaceList.clear()
                        searchPlaceList.addAll(results)
                        searchAdapter?.notifyDataSetChanged()
                    }

                    override fun onError(error: String) {
                        pbSearchProgress?.visibility = View.INVISIBLE
                        Toast.makeText(this@MainActivity, "Search: $error", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

        etSearchQuery?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                btnSearchClear?.visibility = if (!s.isNullOrEmpty()) View.VISIBLE else View.GONE
                searchDebounceHandler.removeCallbacks(searchRunnable)
                if ((s?.length ?: 0) >= 2) {
                    searchDebounceHandler.postDelayed(searchRunnable, 350)
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        etSearchQuery?.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER)
            ) {
                searchDebounceHandler.removeCallbacks(searchRunnable)
                searchRunnable.run()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(etSearchQuery?.windowToken, 0)
                return@setOnEditorActionListener true
            }
            false
        }

        val keyboardContainer = findViewById<View>(R.id.layoutInAppKeyboard)
        if (keyboardContainer != null && etSearchQuery != null) {
            cockpitKeyboard = CockpitKeyboard(keyboardContainer, etSearchQuery) {
                searchDebounceHandler.removeCallbacks(searchRunnable)
                searchRunnable.run()
            }
        }

        btnSearchImeToggle?.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            if (imm != null && etSearchQuery != null) {
                if (cockpitKeyboard?.isVisible == true) {
                    cockpitKeyboard?.hide()
                    etSearchQuery?.showSoftInputOnFocus = true
                    imm.showSoftInput(etSearchQuery, 0)
                } else {
                    imm.hideSoftInputFromWindow(etSearchQuery?.windowToken, 0)
                    etSearchQuery?.showSoftInputOnFocus = false
                    cockpitKeyboard?.show()
                }
            }
        }
    }

    private fun showDestinationSearch() {
        val overlay = layoutSearchOverlay ?: return
        overlay.visibility = View.VISIBLE
        overlay.alpha = 0f
        overlay.animate()
            .alpha(1f)
            .setDuration(220)
            .setInterpolator(DecelerateInterpolator(1.8f))
            .start()

        cardSearchBox?.let { box ->
            box.translationY = -30f
            box.animate()
                .translationY(0f)
                .setDuration(260)
                .setInterpolator(DecelerateInterpolator(2.0f))
                .start()
        }

        cockpitKeyboard?.show()
        etSearchQuery?.let { et ->
            et.showSoftInputOnFocus = false
            et.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(et.windowToken, 0)
        }
    }

    private fun hideDestinationSearch() {
        val overlay = layoutSearchOverlay ?: return
        cardSearchBox?.animate()
            ?.translationY(-30f)
            ?.setDuration(180)
            ?.setInterpolator(AccelerateInterpolator(1.8f))
            ?.start()

        overlay.animate()
            .alpha(0f)
            .setDuration(200)
            .setInterpolator(AccelerateInterpolator(1.8f))
            .withEndAction {
                overlay.visibility = View.GONE
                cardSearchBox?.translationY = 0f
            }
            .start()

        cockpitKeyboard?.hide()
        etSearchQuery?.let { et ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(et.windowToken, 0)
        }
    }

    private fun handleBackPress() {
        if (layoutSearchOverlay?.visibility == View.VISIBLE) {
            hideDestinationSearch()
            return
        }
        if (cardRoutePreview?.visibility == View.VISIBLE) {
            cancelRoutePreview()
            return
        }
        if (currentActiveRoute != null) {
            endActiveNavigation()
            return
        }
        if (drawerBackdrop?.visibility == View.VISIBLE) {
            closeDrawer()
            return
        }
        finish()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            handleBackPress()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun previewRoute(selected: MapplsApiClient.PlaceResult?) {
        selected ?: return
        MapplsApiClient.getInstance().getDirections(
            currentRiderLat,
            currentRiderLng,
            selected.lat,
            selected.lng,
            selected.mapplsPin,
            object : MapplsApiClient.RouteCallback {
                override fun onSuccess(route: MapplsApiClient.RouteResult) {
                    pendingPreviewRoute = route
                    pendingDestName = selected.name

                    val points = decodePolyline(route.geometryPolyline, true).toMutableList()
                    if (points.isEmpty()) {
                        for (step in route.steps) {
                            points.add(doubleArrayOf(step.lng, step.lat))
                        }
                    }
                    mapplsMapView?.plotRoute(points)
                    mapplsMapView?.fitRouteBounds(points)

                    tvPreviewDestName?.text = selected.name
                    tvPreviewDestAddress?.text = selected.address

                    val totalMin = (route.totalDurationSeconds / 60.0).roundToInt()
                    val durStr = if (totalMin >= 60) {
                        val hrs = totalMin / 60
                        val mins = totalMin % 60
                        "$hrs hr $mins min"
                    } else {
                        "$totalMin min"
                    }
                    tvPreviewDuration?.text = durStr

                    val distStr = if (route.totalDistanceMeters >= 1000) {
                        String.format(Locale.getDefault(), " • %.0f km", route.totalDistanceMeters / 1000.0)
                    } else {
                        " • ${route.totalDistanceMeters.toInt()} m"
                    }
                    tvPreviewDistance?.text = distStr

                    val cal = Calendar.getInstance()
                    cal.add(Calendar.SECOND, route.totalDurationSeconds.toInt())
                    val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
                    tvPreviewSub?.text = String.format(Locale.getDefault(), "Fastest route • ETA %s", sdf.format(cal.time))

                    cardRoutePreview?.let { card ->
                        card.visibility = View.VISIBLE
                        card.alpha = 0f
                        card.translationY = 40f
                        card.animate()
                            .alpha(1f)
                            .translationY(0f)
                            .setDuration(280)
                            .setInterpolator(OvershootInterpolator(1.3f))
                            .start()
                    }
                    cardTurnInstruction?.visibility = View.GONE
                    cardBottomNav?.visibility = View.GONE
                    cardSpeedHud?.visibility = View.GONE
                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, "Route error: $error", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private fun startActiveNavigation() {
        val route = pendingPreviewRoute ?: return
        currentActiveRoute = route
        currentRouteStepIndex = 0

        cardRoutePreview?.animate()
            ?.alpha(0f)
            ?.translationY(30f)
            ?.setDuration(180)
            ?.withEndAction { cardRoutePreview?.visibility = View.GONE }
            ?.start()

        cardTurnInstruction?.let { card ->
            card.visibility = View.VISIBLE
            card.alpha = 0f
            card.translationY = -30f
            card.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(280)
                .setInterpolator(DecelerateInterpolator(2.0f))
                .start()
        }

        cardBottomNav?.let { card ->
            card.visibility = View.VISIBLE
            card.alpha = 0f
            card.translationY = 30f
            card.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(280)
                .setInterpolator(DecelerateInterpolator(2.0f))
                .start()
        }

        cardSpeedHud?.let { hud ->
            hud.visibility = View.VISIBLE
            hud.alpha = 0f
            hud.translationX = -35f
            hud.animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(300)
                .setInterpolator(OvershootInterpolator(1.4f))
                .start()
        }

        currentSpeedKmh = 0
        tvCurrentSpeed?.text = "0"
        tvCurrentSpeed?.setTextColor(Color.parseColor("#FFFFFF"))

        if (mapplsMapView != null) {
            mapplsMapView?.setNavigating(true)
            mapplsMapView?.centerOnCurrentLocation()
        } else {
            centerMapOnCurrentLocation()
        }

        if (route.steps.isNotEmpty()) {
            var firstStep = route.steps[0]
            var initialManeuverDist = firstStep.distanceMeters
            if (initialManeuverDist <= 15 && route.steps.size > 1) {
                currentRouteStepIndex = 1
                firstStep = route.steps[1]
                initialManeuverDist = firstStep.distanceMeters
            }
            updateRouteStepDisplay(firstStep, initialManeuverDist, route.totalDistanceMeters, route.totalDurationSeconds)
            val firstInstr = if (!firstStep.instruction.isNullOrEmpty()) firstStep.instruction else firstStep.street
            speakVoiceGuidance("Starting route to $pendingDestName. $firstInstr")
        } else {
            speakVoiceGuidance("Starting route to $pendingDestName")
        }
    }

    private fun cancelRoutePreview() {
        pendingPreviewRoute = null
        cardRoutePreview?.animate()
            ?.alpha(0f)
            ?.translationY(30f)
            ?.setDuration(190)
            ?.withEndAction { cardRoutePreview?.visibility = View.GONE }
            ?.start()

        cardSpeedHud?.visibility = View.GONE
        if (mapplsMapView != null) {
            mapplsMapView?.clearRoute()
            mapplsMapView?.centerOnCurrentLocation()
        } else {
            centerMapOnCurrentLocation()
        }
    }

    private fun updateRouteStepDisplay(
        step: MapplsApiClient.RouteStep,
        maneuverDistMeters: Double,
        remDistMeters: Double,
        remDurSec: Double
    ) {
        runOnUiThread {
            cardTurnInstruction?.let { card ->
                if (card.visibility != View.VISIBLE) {
                    card.visibility = View.VISIBLE
                    card.alpha = 0f
                    card.translationY = -30f
                    card.animate().alpha(1f).translationY(0f).setDuration(260).setInterpolator(DecelerateInterpolator(2.0f)).start()
                }
            }
            cardBottomNav?.let { card ->
                if (card.visibility != View.VISIBLE) {
                    card.visibility = View.VISIBLE
                    card.alpha = 0f
                    card.translationY = 30f
                    card.animate().alpha(1f).translationY(0f).setDuration(260).setInterpolator(DecelerateInterpolator(2.0f)).start()
                }
            }
            cardSpeedHud?.let { hud ->
                if (hud.visibility != View.VISIBLE) {
                    hud.visibility = View.VISIBLE
                    hud.alpha = 0f
                    hud.translationX = -35f
                    hud.animate().alpha(1f).translationX(0f).setDuration(280).setInterpolator(OvershootInterpolator(1.4f)).start()
                }
            }

            var desc = if (!step.instruction.isNullOrEmpty()) step.instruction else step.street
            if (desc.isNullOrEmpty()) {
                desc = "Continue straight"
            }
            tvTurnDesc?.text = desc
            tvTurnDist?.let { tv ->
                if (maneuverDistMeters < 1000) {
                    tv.text = "${max(10, maneuverDistMeters.roundToInt())} m"
                } else {
                    tv.text = String.format(Locale.getDefault(), "%.1f km", maneuverDistMeters / 1000.0)
                }
            }

            ivTurnArrow?.let { iv ->
                var iconRes = R.drawable.ic_straight_nav
                val lower = desc.lowercase(Locale.ROOT)
                if (step.maneuverID == 8 || lower.contains("arrive") || lower.contains("destination")) {
                    iconRes = R.drawable.ic_nav_puck
                } else if (lower.contains("u-turn") || lower.contains("uturn") || step.maneuverID == 4) {
                    iconRes = R.drawable.ic_uturn_nav
                } else if (lower.contains("left") || step.maneuverID == 19 || step.maneuverID == 20 || step.maneuverID == 15) {
                    iconRes = R.drawable.ic_turn_left_nav
                } else if (lower.contains("right") || step.maneuverID == 2 || step.maneuverID == 3 || step.maneuverID == 1) {
                    iconRes = R.drawable.ic_turn_right_nav
                } else if (lower.contains("straight") || lower.contains("continue") || step.maneuverID == 0 || step.maneuverID == 7) {
                    iconRes = R.drawable.ic_straight_nav
                }
                iv.setImageResource(iconRes)
                iv.setColorFilter(COLOR_PULSAR_CYAN)
                iv.rotationY = 90f
                iv.animate().rotationY(0f).setDuration(280).setInterpolator(OvershootInterpolator(1.4f)).start()
            }

            if (layoutNextStepPreview != null && tvNextStepDesc != null) {
                val route = currentActiveRoute
                if (route != null && currentRouteStepIndex + 1 < route.steps.size) {
                    val nextStep = route.steps[currentRouteStepIndex + 1]
                    val nextDist = if (nextStep.distanceMeters < 1000) {
                        "${nextStep.distanceMeters.roundToInt()} m"
                    } else {
                        String.format(Locale.getDefault(), "%.1f km", nextStep.distanceMeters / 1000.0)
                    }
                    val nextDesc = if (!nextStep.instruction.isNullOrEmpty()) nextStep.instruction else nextStep.street
                    val arrowGlyph = when (nextStep.maneuverID) {
                        19, 20, 15 -> "↰"
                        0, 7 -> "↑"
                        8 -> "◉"
                        else -> "↱"
                    }
                    tvNextStepDesc?.text = "Then $nextDist $arrowGlyph • $nextDesc"
                    layoutNextStepPreview?.visibility = View.VISIBLE
                } else {
                    layoutNextStepPreview?.visibility = View.GONE
                }
            }

            tvNavEta?.let { tv ->
                val totalMin = (remDurSec / 60.0).roundToInt()
                if (totalMin >= 60) {
                    val hrs = totalMin / 60
                    val mins = totalMin % 60
                    tv.text = "$hrs hr $mins min"
                } else {
                    tv.text = "$totalMin min"
                }
            }

            tvNavSub?.let { tv ->
                val km = remDistMeters / 1000.0
                val cal = Calendar.getInstance()
                cal.add(Calendar.SECOND, remDurSec.toInt())
                val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
                tv.text = String.format(Locale.getDefault(), "%.1f km • %s", km, sdf.format(cal.time))
            }
        }
    }

    private fun endActiveNavigation() {
        currentActiveRoute = null
        pendingPreviewRoute = null
        currentRouteStepIndex = 0
        currentSpeedKmh = 0

        cardTurnInstruction?.animate()
            ?.alpha(0f)
            ?.translationY(-30f)
            ?.setDuration(200)
            ?.withEndAction { cardTurnInstruction?.visibility = View.GONE }
            ?.start()

        cardBottomNav?.animate()
            ?.alpha(0f)
            ?.translationY(30f)
            ?.setDuration(200)
            ?.withEndAction { cardBottomNav?.visibility = View.GONE }
            ?.start()

        cardRoutePreview?.visibility = View.GONE
        cardSpeedHud?.animate()
            ?.alpha(0f)
            ?.translationX(-35f)
            ?.setDuration(200)
            ?.withEndAction { cardSpeedHud?.visibility = View.GONE }
            ?.start()

        tvCurrentSpeed?.text = "0"
        tvCurrentSpeed?.setTextColor(Color.parseColor("#FFFFFF"))

        if (mapplsMapView != null) {
            mapplsMapView?.setNavigating(false)
            mapplsMapView?.clearRoute()
            mapplsMapView?.centerOnCurrentLocation()
        } else {
            centerMapOnCurrentLocation()
        }
        speakVoiceGuidance("Navigation ended")
    }

    private fun decodePolyline(encoded: String?, isPolyline6: Boolean): List<DoubleArray> {
        val poly = mutableListOf<DoubleArray>()
        if (encoded.isNullOrEmpty()) return poly
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0
        val precision = if (isPolyline6) 1e6 else 1e5

        try {
            while (index < len) {
                var b: Int
                var shift = 0
                var result = 0
                do {
                    b = encoded[index++].code - 63
                    result = result or ((b and 0x1f) shl shift)
                    shift += 5
                } while (b >= 0x20)
                val dlat = if ((result and 1) != 0) (result shr 1).inv() else (result shr 1)
                lat += dlat

                shift = 0
                result = 0
                do {
                    b = encoded[index++].code - 63
                    result = result or ((b and 0x1f) shl shift)
                    shift += 5
                } while (b >= 0x20)
                val dlng = if ((result and 1) != 0) (result shr 1).inv() else (result shr 1)
                lng += dlng

                poly.add(doubleArrayOf(lng / precision, lat / precision))
            }
        } catch (ignored: Exception) {}
        return poly
    }

    override fun onResume() {
        super.onResume()
        applyImmersiveFullscreen()
        initGpsTracking()
        clockHandler.post(clockRunnable)

        try {
            NotificationListenerService.requestRebind(ComponentName(this, PulsarNotificationService::class.java))
        } catch (ignored: Exception) {}

        val msl = MediaStateListener.instance
        if (msl != null) {
            msl.registerObserver(mediaObserver)
            msl.syncMetadata()
        } else {
            val svc = PulsarForegroundService.instance
            svc?.mediaListener?.let {
                it.registerObserver(mediaObserver)
                it.syncMetadata()
            }
        }

        val filter = IntentFilter().apply {
            addAction(MediaStateListener.ACTION_MEDIA_UPDATE)
            addAction(PhoneStateMonitor.ACTION_TELEMETRY_UPDATE)
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(systemUpdatesReceiver, filter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            registerReceiver(systemUpdatesReceiver, filter)
        }

        if (bleManager?.isConnected != true) {
            bleManager?.startScanOrConnect()
        }
        mapplsMapView?.onResume()
        handleIntent(intent)
    }

    override fun onPause() {
        super.onPause()
        mapplsMapView?.onPause()
        MediaStateListener.instance?.unregisterObserver(mediaObserver)
        clockHandler.removeCallbacks(clockRunnable)
        try {
            unregisterReceiver(systemUpdatesReceiver)
        } catch (ignored: Exception) {}
        locationManager?.let { lm ->
            try {
                lm.removeUpdates(gpsLocationListener)
            } catch (ignored: Exception) {}
        }
    }

    private fun initCockpitTheme() {
        val accentPrimary = 0xFF38BDF8.toInt()
        val accentBorder = 0xFF1E293B.toInt()
        val density = resources.displayMetrics.density.toInt()

        (pbMediaTrack as? WavySeekBar)?.setAccentColor(accentPrimary)

        btnMediaPlayPause?.let { btn ->
            val playBg = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(0xFF0F1522.toInt())
                setStroke((2.0f * density).toInt(), accentPrimary)
            }
            btn.background = playBg
            btn.setColorFilter(accentPrimary)
        }
        btnPillPlayPause?.setColorFilter(accentPrimary)
        btnMediaNext?.setColorFilter(accentPrimary)
        btnMediaPrev?.setColorFilter(accentPrimary)
        btnPillNext?.setColorFilter(accentPrimary)
        tvMediaSource?.setTextColor(accentPrimary)

        layoutLeftPanel?.setBackgroundResource(R.drawable.bg_media_panel)
        findViewById<View>(R.id.cardMediaArtStage)?.let { stage ->
            val stageBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (14 * density).toFloat()
                setColor(0xF5080B12.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            stage.background = stageBg
        }
        findViewById<View>(R.id.layoutSplitHandle)?.let { handle ->
            val handleBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (12 * density).toFloat()
                setColor(0xF50B0F18.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            handle.background = handleBg
        }
        findViewById<ImageView>(R.id.ivSplitHandleChevron)?.setColorFilter(accentPrimary)
        findViewById<View>(R.id.viewMediaPulseDot)?.backgroundTintList =
            android.content.res.ColorStateList.valueOf(accentPrimary)

        layoutMapContainer?.let { container ->
            container.setBackgroundColor(0xFF07080B.toInt())
            container.outlineProvider = null
            container.clipToOutline = false
        }
        mapplsMapView?.let { map ->
            map.setCornerRadius(0f)
            map.setThemeAccent(accentPrimary)
        }

        cardTurnInstruction?.let { card ->
            val turnBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (18 * density).toFloat()
                setColor(0xF207080B.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            card.background = turnBg
        }
        ivTurnArrow?.setColorFilter(accentPrimary)
        tvNextStepDesc?.setTextColor(accentPrimary)

        cardSpeedHud?.let { hud ->
            val speedBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (18 * density).toFloat()
                setColor(0xF207080B.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            hud.background = speedBg
        }
        tvSpeedUnit?.setTextColor(accentPrimary)

        cardBottomNav?.let { card ->
            val botBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (18 * density).toFloat()
                setColor(0xF207080B.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            card.background = botBg
        }
        tvNavEta?.setTextColor(accentPrimary)

        cardRoutePreview?.let { card ->
            val prevBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (20 * density).toFloat()
                setColor(0xF507080B.toInt())
                setStroke((1.4f * density).toInt(), accentBorder)
            }
            card.background = prevBg
        }
        btnStartNavNow?.let { btn ->
            val startBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (16 * density).toFloat()
                setColor(accentPrimary)
            }
            btn.background = startBg
            btn.setTextColor(0xFF000000.toInt())
        }
        tvPreviewDuration?.setTextColor(accentPrimary)
        findViewById<ImageView>(R.id.ivPreviewSearchIcon)?.setColorFilter(accentPrimary)

        layoutFullscreenMusicPill?.let { pill ->
            val pillBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (22 * density).toFloat()
                setColor(0xF50A0B0E.toInt())
                setStroke((1.4f * density).toInt(), accentBorder)
            }
            pill.background = pillBg
        }
        tvPillArtist?.setTextColor(accentPrimary)

        btnCurrentLocation?.setColorFilter(accentPrimary)
        btnMapSearch?.setColorFilter(accentPrimary)
        btnVoiceNav?.setColorFilter(accentPrimary)
        btnOpenDrawer?.setColorFilter(accentPrimary)
        btnSearchCancel?.setTextColor(accentPrimary)

        layoutRecenterPill?.let { pill ->
            val pillBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (19 * density).toFloat()
                setColor(0xF208090C.toInt())
                setStroke((1.5f * density).toInt(), accentPrimary)
            }
            pill.background = pillBg
        }
        findViewById<TextView>(R.id.tvRecenterMap)?.setTextColor(accentPrimary)
        findViewById<ImageView>(R.id.ivRecenterIcon)?.setColorFilter(accentPrimary)

        drawerPanel?.let { panel ->
            val drawerBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadii = floatArrayOf(
                    24f * density, 24f * density,
                    0f, 0f,
                    0f, 0f,
                    24f * density, 24f * density
                )
                setColor(0xF8050608.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            panel.background = drawerBg
        }
        btnDrawerClose?.setColorFilter(accentPrimary)

        cardBikeStage?.let { stage ->
            val stageBg = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xFF0F172A.toInt(), 0xFF0B1120.toInt(), 0xFF060A13.toInt())
            ).apply {
                cornerRadius = (18 * density).toFloat()
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            stage.background = stageBg
        }

        cardBikeConnection?.let { card ->
            val cardBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (14 * density).toFloat()
                setColor(0xEE0B0E14.toInt())
                setStroke((1.2f * density).toInt(), accentBorder)
            }
            card.background = cardBg
        }

        btnDrawerBleConnect?.let { btn ->
            if (!isBleConnecting && bleManager?.isConnected != true) {
                val btnBg = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = (10 * density).toFloat()
                    setColor(accentPrimary)
                }
                btn.background = btnBg
            }
        }

        cardSearchBox?.let { box ->
            val searchCardBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (20 * density).toFloat()
                setColor(0xF8050608.toInt())
                setStroke((1.4f * density).toInt(), accentBorder)
            }
            box.background = searchCardBg
        }

        findViewById<View>(R.id.layoutSearchInputBar)?.let { bar ->
            val inputBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = (12 * density).toFloat()
                setColor(0xFF0F1117.toInt())
                setStroke((1.2f * density).toInt(), accentPrimary)
            }
            bar.background = inputBg
        }
        findViewById<ImageView>(R.id.ivSearchInputIcon)?.setColorFilter(accentPrimary)
    }

    override fun onDestroy() {
        super.onDestroy()
        bleTimeoutHandler.removeCallbacksAndMessages(null)
        searchDebounceHandler.removeCallbacksAndMessages(null)
        clockHandler.removeCallbacksAndMessages(null)
        pulseAnimator?.cancel()
        bleManager?.removeListener(this)
        locationManager?.let { lm ->
            try {
                lm.removeUpdates(gpsLocationListener)
            } catch (ignored: Exception) {}
        }
        tts?.let {
            try {
                it.stop()
                it.shutdown()
            } catch (ignored: Exception) {}
        }
        gpsSwitchReceiver?.let {
            try {
                unregisterReceiver(it)
            } catch (ignored: Exception) {}
        }
        mapplsMapView?.onDestroy()
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val PERMISSION_REQ_CODE = 101
        private const val REQUEST_ENABLE_BT = 1002
        private const val COLOR_PULSAR_CYAN = 0xFF38BDF8.toInt()
        private const val COLOR_PULSAR_BORDER = 0xFF1E293B.toInt()
    }
}
