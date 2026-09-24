package com.bajaj.rideconnect.re;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewOutlineProvider;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.service.notification.NotificationListenerService;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.speech.tts.TextToSpeech;
import android.telecom.TelecomManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.window.OnBackInvokedDispatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Typeface;
import android.view.HapticFeedbackConstants;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Modern Landscape Automotive Cockpit Dashboard for "My Pulsar" (Bajaj Ride Connect RE).
 * Implements a riding-first UI/UX architecture:
 * - 25% Left Panel (Media / Calls / SMS / Bike Quick Tabs)
 * - 75% Right Map Workspace with high-contrast Navigation HUD
 * - Drag/tap divider to toggle Fullscreen Map with floating compact Music Pill
 * - Slide-in Right Automotive Drawer with telemetry & quick actions
 * - Direct bidirectional binding to Android MediaSession & Pulsar BLE
 */
public class MainActivity extends Activity implements PulsarBleManager.BleListener {

    private static final String TAG = "MainActivity";
    private static final int PERMISSION_REQ_CODE = 101;

    // Top Drawer Button
    private ImageView btnOpenDrawer;

    // Main Split Layout
    private LinearLayout layoutLeftPanel;
    private LinearLayout viewSplitDivider;
    private View layoutMapContainer;
    private boolean isMapFullscreen = false;

    // Media Controls & Info (Left Panel)
    private View viewTabMedia;
    private ImageView ivAlbumArt;
    private TextView tvMediaTrack;
    private TextView tvMediaArtist;
    private TextView tvMediaSource;
    private SeekBar pbMediaTrack;
    private boolean isUserScrubbingMedia = false;
    private int currentMediaDurSec = 0;
    private TextView tvMediaElapsed;
    private TextView tvMediaDuration;
    private ImageView btnMediaPrev;
    private ImageView btnMediaPlayPause;
    private ImageView btnMediaNext;

    // Floating Music Pill (Fullscreen Map Mode)
    private View layoutFullscreenMusicPill;
    private ImageView ivPillAlbumArt;
    private TextView tvPillTrack;
    private TextView tvPillArtist;
    private ImageView btnPillPlayPause;
    private ImageView btnPillNext;

    // Navigation Map & HUD
    private View cardTurnInstruction;
    private ImageView ivTurnArrow;
    private TextView tvTurnDist;
    private TextView tvTurnDesc;
    private View layoutNextStepPreview;
    private TextView tvNextStepDesc;
    private View cardSpeedHud;
    private TextView tvCurrentSpeed;
    private TextView tvSpeedLimit;
    private TextView tvSpeedUnit;
    private MaterialYouTheme.Palette currentThemePalette;
    private Location lastSpeedLocation = null;
    private long lastSpeedTimeMs = 0;
    private int currentSpeedKmh = 0;
    private ImageView btnCompass;
    private ImageView btnVoiceNav;
    private ImageView btnLayers;
    private ImageView btnZoomIn;
    private ImageView btnZoomOut;
    private View cardBottomNav;
    private TextView tvNavEta;
    private TextView tvNavSub;
    private Button btnNavEnd;

    // Route Preview HUD
    private View cardRoutePreview;
    private TextView tvPreviewDestName;
    private TextView tvPreviewDestAddress;
    private ImageView btnCancelRoutePreview;
    private TextView tvPreviewDuration;
    private TextView tvPreviewDistance;
    private TextView tvPreviewSub;
    private Button btnStartNavNow;
    private MapplsApiClient.RouteResult pendingPreviewRoute = null;
    private String pendingDestName = "";

    // Mappls Engine & Cockpit Controls
    private MapplsMapView mapplsMapView;
    private View layoutRecenterPill;
    private ImageView btnMapSearch;
    private ImageView btnCurrentLocation;
    private LocationManager locationManager;
    private double currentRiderLat = 0.0;
    private double currentRiderLng = 0.0;
    private float currentRiderBearing = 0f;
    private boolean shouldRecenterOnNextFix = false;
    private boolean shouldAutoCenterOnLocationEnabled = false;
    private boolean shouldCenterAfterPermission = false;
    private boolean hasLiveGpsFix = false;
    private MapplsApiClient.RouteResult currentActiveRoute = null;
    private int currentRouteStepIndex = 0;
    private TextToSpeech tts;
    private boolean isTtsReady = false;

    // Search Destination Overlay Views
    private View layoutSearchOverlay;
    private View cardSearchBox;
    private EditText etSearchQuery;
    private ImageView btnSearchClear;
    private ImageView btnSearchImeToggle;
    private ProgressBar pbSearchProgress;
    private ListView lvSearchResults;
    private TextView btnSearchCancel;
    private CockpitKeyboard cockpitKeyboard;
    private final List<MapplsApiClient.PlaceResult> searchPlaceList = new ArrayList<>();
    private ArrayAdapter<MapplsApiClient.PlaceResult> searchAdapter;
    private final Handler searchDebounceHandler = new Handler(Looper.getMainLooper());

    // Right Slide-out Drawer & Bike Controls
    private View drawerBackdrop;
    private View drawerPanel;
    private ScrollView scrollDrawer;
    private ImageView btnDrawerClose;
    private View cardBikeStage;
    private ImageView ivDrawerBikeImage;
    private TextView tvDrawerBikeName;
    private TextView tvDrawerClock;
    private LinearLayout cardBikeConnection;
    private View viewDrawerBtStatusDot;
    private TextView tvDrawerBtStatus;
    private ProgressBar pbBleConnecting;
    private TextView tvBleDetailMsg;
    private LinearLayout btnDrawerBleConnect;
    private ImageView ivDrawerBleActionIcon;
    private TextView tvDrawerBleActionText;

    private static final int REQUEST_ENABLE_BT = 1002;
    private boolean isBleConnecting = false;
    private final Handler bleTimeoutHandler = new Handler(Looper.getMainLooper());
    private final Runnable bleTimeoutRunnable = new Runnable() {
        @Override
        public void run() {
            if (isBleConnecting) {
                isBleConnecting = false;
                if (bleManager != null) {
                    bleManager.stopScan();
                    bleManager.disconnect();
                }
                updateBleUiState(BleUiState.FAILED, null);
                Toast.makeText(MainActivity.this, "Bike connection timed out (30s). Tap Retry.", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private enum BleUiState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        FAILED
    }
    private View itemSavedPlaces;
    private View itemAbout;
    private View btnDrawerExit;
    private TextView tvDrawerTitle;
    private ScrollView layoutDrawerAbout;
    private View btnAboutBack;
    private View btnAboutGithub;

    // Hardware & State
    private PulsarBleManager bleManager;
    private ObjectAnimator pulseAnimator;
    private final Handler clockHandler = new Handler(Looper.getMainLooper());
    private final SimpleDateFormat clockFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
    private int currentBattery = -1;
    private boolean isCharging = false;
    private int currentSignalBars = -1;
    private boolean isVoiceMuted = false;
    private boolean isSatelliteLayer = true;

    private final Runnable clockRunnable = new Runnable() {
        @Override
        public void run() {
            if (tvDrawerClock != null) {
                tvDrawerClock.setText(clockFormat.format(new Date()));
            }
            clockHandler.postDelayed(this, 10000);
        }
    };

    private final BroadcastReceiver systemUpdatesReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null) return;
            String action = intent.getAction();

            if (MediaStateListener.ACTION_MEDIA_UPDATE.equals(action)) {
                String title = intent.getStringExtra("title");
                String artist = intent.getStringExtra("artist");
                String source = intent.getStringExtra("source");
                int state = intent.getIntExtra("playback_state", 0);
                int posSec = intent.getIntExtra("position_sec", 0);
                int durSec = intent.getIntExtra("duration_sec", 0);

                Bitmap art = (MediaStateListener.getInstance() != null)
                        ? MediaStateListener.getInstance().getCurrentAlbumArt() : null;
                updateCockpitMedia(title, artist, source, state, posSec, durSec, art);
            } else if (PhoneStateMonitor.ACTION_TELEMETRY_UPDATE.equals(action)) {
                int bat = intent.getIntExtra("battery", -1);
                int sig = intent.getIntExtra("signal", -1);
                if (bat >= 0) {
                    currentBattery = bat;
                    updateBatteryDisplay(currentBattery, isCharging);
                }
                if (sig >= 0) {
                    currentSignalBars = sig;
                    updateSignalDisplay(currentSignalBars);
                }
            } else if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING
                        || status == BatteryManager.BATTERY_STATUS_FULL);
                if (level >= 0 && scale > 0) {
                    currentBattery = (int) ((level / (float) scale) * 100);
                    updateBatteryDisplay(currentBattery, isCharging);
                }
            }
        }
    };

    private final MediaStateListener.MediaObserver mediaObserver = (title, artist, album, source, state, posSec, durSec, art) -> {
        runOnUiThread(() -> updateCockpitMedia(title, artist, source, state, posSec, durSec, art));
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupEdgeToEdge();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(
                    OnBackInvokedDispatcher.PRIORITY_DEFAULT,
                    this::handleBackPress
            );
        }

        try {
            SharedPreferences prefs = getSharedPreferences("bajaj_ride_prefs", MODE_PRIVATE);
            float sLat = prefs.getFloat("saved_rider_lat", 0.0f);
            float sLng = prefs.getFloat("saved_rider_lng", 0.0f);
            if (sLat != 0.0f && sLng != 0.0f) {
                currentRiderLat = sLat;
                currentRiderLng = sLng;
            }
        } catch (Exception ignored) {}

        try {
            tts = new TextToSpeech(this, status -> {
                if (status == TextToSpeech.SUCCESS && tts != null) {
                    tts.setLanguage(Locale.US);
                    isTtsReady = true;
                }
            });
        } catch (Exception ignored) {}

        initViews();
        initMaterialYouTheme();
        setupListeners();
        setupMicroAnimations();
        initLiveSystemSensors();

        bleManager = PulsarBleManager.getInstance(this);
        bleManager.addListener(this);

        PulsarForegroundService.start(this);

        requestAppPermissions();
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent == null) return;
        if (intent.getBooleanExtra("open_search", false)) {
            layoutSearchOverlay.postDelayed(this::showDestinationSearch, 300);
        }
        if (intent.hasExtra("map_fullscreen") && !intent.hasExtra("cmd")) {
            boolean fs = intent.getBooleanExtra("map_fullscreen", false);
            layoutMapContainer.postDelayed(() -> setMapFullscreen(fs), 300);
        }
        if (intent.hasExtra("query")) {
            String q = intent.getStringExtra("query");
            if (etSearchQuery != null && q != null) {
                showDestinationSearch();
                etSearchQuery.postDelayed(() -> {
                    etSearchQuery.setText(q);
                    etSearchQuery.setSelection(q.length());
                }, 300);
            }
        }
        String cmd = intent.getStringExtra("cmd");
        if (cmd != null) {
            if ("search".equalsIgnoreCase(cmd)) {
                String query = intent.getStringExtra("query");
                showDestinationSearch();
                if (query != null && etSearchQuery != null) {
                    etSearchQuery.setText(query);
                    etSearchQuery.setSelection(query.length());
                }
            } else if ("select_first".equalsIgnoreCase(cmd)) {
                if (!searchPlaceList.isEmpty()) {
                    MapplsApiClient.PlaceResult selected = searchPlaceList.get(0);
                    hideDestinationSearch();
                    previewRoute(selected);
                }
            } else if ("start_nav".equalsIgnoreCase(cmd)) {
                if (pendingPreviewRoute == null) {
                    java.util.List<MapplsApiClient.RouteStep> steps = new java.util.ArrayList<>();
                    steps.add(new MapplsApiClient.RouteStep("In 200m, turn left toward Service Road", "Station Road", 250, 45, 1, 28.128, 75.399));
                    steps.add(new MapplsApiClient.RouteStep("Continue straight on National Highway", "NH 52", 4800, 360, 0, 28.135, 75.405));
                    pendingPreviewRoute = new MapplsApiClient.RouteResult(5050, 405, "", steps);
                    pendingDestName = "Bajaj Service Station";
                }
                startActiveNavigation();
            } else if ("end_nav".equalsIgnoreCase(cmd)) {
                endActiveNavigation();
            } else if ("recenter".equalsIgnoreCase(cmd)) {
                if (layoutRecenterPill != null) {
                    layoutRecenterPill.performClick();
                } else {
                    centerMapOnCurrentLocation();
                }
            } else if ("drag_map".equalsIgnoreCase(cmd)) {
                if (mapplsMapView != null) {
                    mapplsMapView.simulateDrag();
                }
            } else if ("open_saved_places".equalsIgnoreCase(cmd)) {
                showSavedPlacesDialog();
            } else if ("open_stats".equalsIgnoreCase(cmd)) {
                showRideStatsDialog();
            } else if ("open_service".equalsIgnoreCase(cmd)) {
                showServiceDialog();
            } else if ("open_bike_info".equalsIgnoreCase(cmd)) {
                showBikeInfoDialog();
            } else if ("open_about".equalsIgnoreCase(cmd)) {
                openDrawer();
                showDrawerAboutView();
            } else if ("open_drawer".equalsIgnoreCase(cmd)) {
                openDrawer();
            } else if ("scroll_drawer".equalsIgnoreCase(cmd)) {
                int y = intent.getIntExtra("y", 400);
                if (layoutDrawerAbout != null && layoutDrawerAbout.getVisibility() == View.VISIBLE) {
                    layoutDrawerAbout.post(() -> layoutDrawerAbout.smoothScrollTo(0, y));
                } else if (scrollDrawer != null) {
                    scrollDrawer.post(() -> scrollDrawer.smoothScrollTo(0, y));
                }
            } else if ("close_drawer".equalsIgnoreCase(cmd)) {
                closeDrawer();
            } else if ("toggle_orientation".equalsIgnoreCase(cmd)) {
                if (btnCompass != null) {
                    btnCompass.performClick();
                }
            } else if ("toggle_split".equalsIgnoreCase(cmd)) {
                setMapFullscreen(!isMapFullscreen);
            } else if ("expand_media".equalsIgnoreCase(cmd)) {
                setMapFullscreen(false);
            } else if ("seek_media".equalsIgnoreCase(cmd)) {
                int progress = intent.getIntExtra("progress", 500);
                if (pbMediaTrack != null) {
                    pbMediaTrack.setProgress(progress);
                }
                if (currentMediaDurSec > 0) {
                    long targetMs = (long) (((float) progress / 1000.0f) * currentMediaDurSec * 1000L);
                    seekMediaTo(targetMs);
                }
            } else if ("tap_turn_card".equalsIgnoreCase(cmd)) {
                if (cardTurnInstruction != null) {
                    cardTurnInstruction.performClick();
                }
            } else if ("close_search".equalsIgnoreCase(cmd)) {
                hideDestinationSearch();
            } else if ("connect_bike".equalsIgnoreCase(cmd)) {
                startBikeBleConnection();
            } else if ("toggle_theme".equalsIgnoreCase(cmd)) {
                if (btnLayers != null) btnLayers.performClick();
            } else if ("test_ble_state".equalsIgnoreCase(cmd)) {
                String s = intent.getStringExtra("state");
                String name = intent.getStringExtra("name");
                if ("connecting".equalsIgnoreCase(s)) {
                    updateBleUiState(BleUiState.CONNECTING, null);
                } else if ("connected".equalsIgnoreCase(s)) {
                    updateBleUiState(BleUiState.CONNECTED, name != null ? name : "Bajaj Pulsar NS400Z");
                } else if ("failed".equalsIgnoreCase(s)) {
                    updateBleUiState(BleUiState.FAILED, null);
                } else {
                    updateBleUiState(BleUiState.DISCONNECTED, null);
                }
            }
        }
    }

    private void setupEdgeToEdge() {
        Window window = getWindow();
        if (window == null) return;
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        }

        applyImmersiveFullscreen();
    }

    private void applyImmersiveFullscreen() {
        try {
            Window window = getWindow();
            if (window == null) return;
            View decor = window.getDecorView();
            if (decor != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowInsetsController controller = decor.getWindowInsetsController();
                if (controller != null) {
                    controller.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                    controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                }
            }
        } catch (Exception ignored) {}
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            applyImmersiveFullscreen();
        }
    }

    private void initViews() {
        // Drawer Menu Button (Action Stack)
        btnOpenDrawer = findViewById(R.id.btnOpenDrawer);

        // Layout Containers
        layoutLeftPanel = findViewById(R.id.layoutLeftPanel);
        viewSplitDivider = findViewById(R.id.viewSplitDivider);
        layoutMapContainer = findViewById(R.id.layoutMapContainer);
        if (layoutMapContainer != null) {
            float density = getResources().getDisplayMetrics().density;
            layoutMapContainer.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 22 * density);
                }
            });
            layoutMapContainer.setClipToOutline(true);
        }

        // Media View
        viewTabMedia = findViewById(R.id.viewTabMedia);

        // Media Controls
        ivAlbumArt = findViewById(R.id.ivAlbumArt);
        tvMediaTrack = findViewById(R.id.tvMediaTrack);
        tvMediaArtist = findViewById(R.id.tvMediaArtist);
        tvMediaSource = findViewById(R.id.tvMediaSource);
        pbMediaTrack = findViewById(R.id.pbMediaTrack);
        tvMediaElapsed = findViewById(R.id.tvMediaElapsed);
        tvMediaDuration = findViewById(R.id.tvMediaDuration);
        btnMediaPrev = findViewById(R.id.btnMediaPrev);
        btnMediaPlayPause = findViewById(R.id.btnMediaPlayPause);
        btnMediaNext = findViewById(R.id.btnMediaNext);

        // Floating Music Pill
        layoutFullscreenMusicPill = findViewById(R.id.layoutFullscreenMusicPill);
        ivPillAlbumArt = findViewById(R.id.ivPillAlbumArt);
        tvPillTrack = findViewById(R.id.tvPillTrack);
        tvPillArtist = findViewById(R.id.tvPillArtist);
        btnPillPlayPause = findViewById(R.id.btnPillPlayPause);
        btnPillNext = findViewById(R.id.btnPillNext);

        // Navigation HUD
        cardTurnInstruction = findViewById(R.id.cardTurnInstruction);
        ivTurnArrow = findViewById(R.id.ivTurnArrow);
        tvTurnDist = findViewById(R.id.tvTurnDist);
        tvTurnDesc = findViewById(R.id.tvTurnDesc);
        layoutNextStepPreview = findViewById(R.id.layoutNextStepPreview);
        tvNextStepDesc = findViewById(R.id.tvNextStepDesc);
        cardSpeedHud = findViewById(R.id.cardSpeedHud);
        if (cardSpeedHud != null) cardSpeedHud.setVisibility(View.GONE);
        tvCurrentSpeed = findViewById(R.id.tvCurrentSpeed);
        tvSpeedLimit = findViewById(R.id.tvSpeedLimit);
        tvSpeedUnit = findViewById(R.id.tvSpeedUnit);
        btnCompass = findViewById(R.id.btnCompass);
        btnVoiceNav = findViewById(R.id.btnVoiceNav);
        btnLayers = findViewById(R.id.btnLayers);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);
        cardBottomNav = findViewById(R.id.cardBottomNav);
        tvNavEta = findViewById(R.id.tvNavEta);
        tvNavSub = findViewById(R.id.tvNavSub);
        btnNavEnd = findViewById(R.id.btnNavEnd);

        // Route Preview HUD
        cardRoutePreview = findViewById(R.id.cardRoutePreview);
        tvPreviewDestName = findViewById(R.id.tvPreviewDestName);
        tvPreviewDestAddress = findViewById(R.id.tvPreviewDestAddress);
        btnCancelRoutePreview = findViewById(R.id.btnCancelRoutePreview);
        tvPreviewDuration = findViewById(R.id.tvPreviewDuration);
        tvPreviewDistance = findViewById(R.id.tvPreviewDistance);
        tvPreviewSub = findViewById(R.id.tvPreviewSub);
        btnStartNavNow = findViewById(R.id.btnStartNavNow);

        mapplsMapView = findViewById(R.id.mapplsMapView);
        layoutRecenterPill = findViewById(R.id.layoutRecenterPill);
        btnMapSearch = findViewById(R.id.btnMapSearch);
        btnCurrentLocation = findViewById(R.id.btnCurrentLocation);

        // Search Destination Overlay Views
        layoutSearchOverlay = findViewById(R.id.layoutSearchOverlay);
        cardSearchBox = findViewById(R.id.cardSearchBox);
        etSearchQuery = findViewById(R.id.etSearchQuery);
        btnSearchClear = findViewById(R.id.btnSearchClear);
        btnSearchImeToggle = findViewById(R.id.btnSearchImeToggle);
        pbSearchProgress = findViewById(R.id.pbSearchProgress);
        lvSearchResults = findViewById(R.id.lvSearchResults);
        btnSearchCancel = findViewById(R.id.btnSearchCancel);

        // Drawer & Cockpit Telemetry
        drawerBackdrop = findViewById(R.id.drawerBackdrop);
        drawerPanel = findViewById(R.id.drawerPanel);
        scrollDrawer = findViewById(R.id.scrollDrawer);
        btnDrawerClose = findViewById(R.id.btnDrawerClose);
        cardBikeStage = findViewById(R.id.cardBikeStage);
        ivDrawerBikeImage = findViewById(R.id.ivDrawerBikeImage);
        tvDrawerBikeName = findViewById(R.id.tvDrawerBikeName);
        viewDrawerBtStatusDot = findViewById(R.id.viewDrawerBtStatusDot);
        tvDrawerBtStatus = findViewById(R.id.tvDrawerBtStatus);
        tvDrawerClock = findViewById(R.id.tvDrawerClock);
        cardBikeConnection = findViewById(R.id.cardBikeConnection);
        pbBleConnecting = findViewById(R.id.pbBleConnecting);
        tvBleDetailMsg = findViewById(R.id.tvBleDetailMsg);
        btnDrawerBleConnect = findViewById(R.id.btnDrawerBleConnect);
        ivDrawerBleActionIcon = findViewById(R.id.ivDrawerBleActionIcon);
        tvDrawerBleActionText = findViewById(R.id.tvDrawerBleActionText);
        itemSavedPlaces = findViewById(R.id.itemSavedPlaces);
        itemAbout = findViewById(R.id.itemAbout);
        btnDrawerExit = findViewById(R.id.btnDrawerExit);
        tvDrawerTitle = findViewById(R.id.tvDrawerTitle);
        layoutDrawerAbout = findViewById(R.id.layoutDrawerAbout);
        btnAboutBack = findViewById(R.id.btnAboutBack);
        btnAboutGithub = findViewById(R.id.btnAboutGithub);
    }

    private void setupListeners() {
        // Media Controls (Left Panel)
        btnMediaPlayPause.setOnClickListener(v -> toggleMediaPlayback());
        btnMediaPrev.setOnClickListener(v -> skipMediaPrevious());
        btnMediaNext.setOnClickListener(v -> skipMediaNext());

        if (pbMediaTrack != null) {
            pbMediaTrack.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser && currentMediaDurSec > 0) {
                        int scrubSec = (int) (((float) progress / seekBar.getMax()) * currentMediaDurSec);
                        tvMediaElapsed.setText(formatTime(scrubSec));
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    isUserScrubbingMedia = true;
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    isUserScrubbingMedia = false;
                    if (currentMediaDurSec > 0) {
                        long targetMs = (long) (((float) seekBar.getProgress() / seekBar.getMax()) * currentMediaDurSec * 1000L);
                        seekMediaTo(targetMs);
                    }
                }
            });
        }

        if (cardTurnInstruction != null) {
            cardTurnInstruction.setOnClickListener(v -> {
                if (currentActiveRoute != null && currentRouteStepIndex < currentActiveRoute.steps.size()) {
                    MapplsApiClient.RouteStep step = currentActiveRoute.steps.get(currentRouteStepIndex);
                    String text = (step.instruction != null && !step.instruction.isEmpty()) ? step.instruction : step.street;
                    if (text != null && !text.isEmpty()) {
                        speakVoiceGuidance(text);
                    }
                }
                if (mapplsMapView != null) {
                    mapplsMapView.centerOnCurrentLocation();
                }
            });
        }

        // Fullscreen Floating Music Pill Controls
        btnPillPlayPause.setOnClickListener(v -> toggleMediaPlayback());
        btnPillNext.setOnClickListener(v -> skipMediaNext());
        layoutFullscreenMusicPill.setOnClickListener(v -> setMapFullscreen(false));

        // Divider Resize / Collapse Interaction
        viewSplitDivider.setOnClickListener(v -> setMapFullscreen(!isMapFullscreen));

        // Right Navigation Drawer
        btnOpenDrawer.setOnClickListener(v -> openDrawer());
        drawerBackdrop.setOnClickListener(v -> closeDrawer());
        if (btnDrawerClose != null) {
            btnDrawerClose.setOnClickListener(v -> closeDrawer());
        }

        // Drawer Actions
        itemSavedPlaces.setOnClickListener(v -> {
            closeDrawer();
            showSavedPlacesDialog();
        });
        itemAbout.setOnClickListener(v -> showDrawerAboutView());
        if (btnAboutBack != null) {
            btnAboutBack.setOnClickListener(v -> hideDrawerAboutView());
        }
        if (btnAboutGithub != null) {
            btnAboutGithub.setOnClickListener(v -> openGithubProfile());
        }

        // Exit App Button
        if (btnDrawerExit != null) {
            btnDrawerExit.setOnClickListener(v -> terminateAppSession());
        }

        if (btnDrawerBleConnect != null) {
            btnDrawerBleConnect.setOnClickListener(v -> startBikeBleConnection());
        }

        // Map HUD Controls
        if (btnCurrentLocation != null) {
            btnCurrentLocation.setOnClickListener(v -> {
                if (locationManager != null && !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    Toast.makeText(this, "Please turn ON device Location / GPS", Toast.LENGTH_LONG).show();
                    try {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    } catch (Exception ignored) {}
                    return;
                }
                centerMapOnCurrentLocation();
                hideRecenterButton();
            });
        }

        if (layoutRecenterPill != null) {
            layoutRecenterPill.setOnClickListener(v -> {
                if (mapplsMapView != null) {
                    mapplsMapView.centerOnCurrentLocation();
                }
                hideRecenterButton();
            });
        }

        if (btnCompass != null) {
            btnCompass.setOnClickListener(v -> {
                if (mapplsMapView != null) {
                    mapplsMapView.toggleOrientation();
                } else {
                    btnCompass.animate().rotation(0f).setDuration(350).start();
                }
            });
        }

        if (mapplsMapView != null) {
            mapplsMapView.setOnMapInteractionListener(new MapplsMapView.OnMapInteractionListener() {
                @Override
                public void onMapDragged() {
                    if (currentActiveRoute != null) {
                        showRecenterButton();
                    }
                }

                @Override
                public void onMapRecentered() {
                    hideRecenterButton();
                }

                @Override
                public void onMapBearingChanged(double bearing) {
                    if (btnCompass != null) {
                        btnCompass.setRotation((float) -bearing);
                    }
                }

                @Override
                public void onOrientationModeChanged(boolean is3D, double bearing) {
                    if (btnCompass != null) {
                        if (is3D) {
                            btnCompass.setBackgroundResource(R.drawable.bg_circle_action_active);
                            btnCompass.animate().rotation((float) -bearing).setDuration(350).start();
                        } else {
                            btnCompass.setBackgroundResource(R.drawable.bg_circle_action);
                            btnCompass.animate().rotation(0f).setDuration(350).start();
                        }
                    }
                }
            });
        }

        btnMapSearch.setOnClickListener(v -> showDestinationSearch());
        setupSearchOverlay();

        btnVoiceNav.setOnClickListener(v -> {
            isVoiceMuted = !isVoiceMuted;
            btnVoiceNav.setImageResource(isVoiceMuted ? R.drawable.ic_volume_off : R.drawable.ic_volume_up);
            btnVoiceNav.setAlpha(isVoiceMuted ? 0.6f : 1.0f);
            String msg = isVoiceMuted ? "Voice Guidance Muted" : "Voice Guidance Active";
            speakVoiceGuidance(msg);
        });

        if (btnStartNavNow != null) {
            btnStartNavNow.setOnClickListener(v -> startActiveNavigation());
        }
        if (btnCancelRoutePreview != null) {
            btnCancelRoutePreview.setOnClickListener(v -> cancelRoutePreview());
        }

        btnLayers.setOnClickListener(v -> {
            if (mapplsMapView != null) {
                mapplsMapView.toggleMapTheme();
            }
        });

        btnZoomIn.setOnClickListener(v -> {
            if (mapplsMapView != null) mapplsMapView.zoomIn();
        });
        btnZoomOut.setOnClickListener(v -> {
            if (mapplsMapView != null) mapplsMapView.zoomOut();
        });

        if (btnNavEnd != null) {
            btnNavEnd.setOnClickListener(v -> endActiveNavigation());
        }

        // Bluetooth Quick Connect Toggle in Drawer
        if (viewDrawerBtStatusDot != null) viewDrawerBtStatusDot.setOnClickListener(v -> toggleBleConnection());
        if (tvDrawerBtStatus != null) tvDrawerBtStatus.setOnClickListener(v -> toggleBleConnection());
    }

    private void speakVoiceGuidance(String message) {
        if (isVoiceMuted || !isTtsReady || tts == null || message == null || message.trim().isEmpty()) {
            return;
        }
        try {
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, "BAJAJ_NAV_TTS");
        } catch (Exception ignored) {}
    }

    private void showSavedPlacesDialog() {
        final String[] placeNames = {
            "🏠 Home (Saved)",
            "🏢 Office / Work",
            "⛽ Fuel Station (Nearby)",
            "📍 Jaipur Pink City (Hawa Mahal)",
            "📍 Delhi Aerocity (IGI Airport)"
        };
        double refLat = (currentRiderLat != 0.0) ? currentRiderLat : 28.6139;
        double refLng = (currentRiderLng != 0.0) ? currentRiderLng : 77.2090;
        final MapplsApiClient.PlaceResult[] places = {
            new MapplsApiClient.PlaceResult("Home", "Saved Primary Location", "", refLat + 0.015, refLng + 0.012, 0, "HOME"),
            new MapplsApiClient.PlaceResult("Office / Work", "Business District Area", "", refLat - 0.020, refLng - 0.015, 0, "WORK"),
            new MapplsApiClient.PlaceResult("Fuel Station", "Highway Fuel & Service Hub", "", refLat + 0.035, refLng - 0.008, 0, "FUEL"),
            new MapplsApiClient.PlaceResult("Jaipur (Pink City)", "Hawa Mahal Rd, Jaipur, Rajasthan", "3T7XV6", 26.9239, 75.8267, 0, "CITY"),
            new MapplsApiClient.PlaceResult("Delhi Aerocity", "IGI Airport, New Delhi", "", 28.5562, 77.1000, 0, "AIRPORT")
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("★ Saved Places & Favorites");
        builder.setItems(placeNames, (dialog, which) -> {
            dialog.dismiss();
            if (which >= 0 && which < places.length) {
                previewRoute(places[which]);
            }
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        styleCockpitDialog(dialog);
        dialog.show();
    }

    private void styleCockpitDialog(AlertDialog dialog) {
        if (dialog == null) return;
        dialog.setOnShowListener(d -> {
            int accent = (currentThemePalette != null) ? currentThemePalette.accentPrimary : Color.parseColor("#38BDF8");
            int border = (currentThemePalette != null) ? currentThemePalette.accentBorder : Color.parseColor("#3338BDF8");
            int density = (int) getResources().getDisplayMetrics().density;

            if (dialog.getWindow() != null) {
                GradientDrawable winBg = new GradientDrawable();
                winBg.setShape(GradientDrawable.RECTANGLE);
                winBg.setCornerRadius(22 * density);
                winBg.setColor(0xF80A0B0E);
                winBg.setStroke((int) (1.2f * density), border);
                dialog.getWindow().setBackgroundDrawable(winBg);
            }

            Button pos = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            if (pos != null) {
                pos.setTextColor(accent);
                pos.setAllCaps(false);
                pos.setTypeface(null, Typeface.BOLD);
            }
            Button neg = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            if (neg != null) {
                neg.setTextColor(0xFF94A3B8);
                neg.setAllCaps(false);
            }
            Button neu = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
            if (neu != null) {
                neu.setTextColor(0xFF94A3B8);
                neu.setAllCaps(false);
            }

            TextView msg = dialog.findViewById(android.R.id.message);
            if (msg != null) {
                msg.setTextColor(0xFFE2E8F0);
                msg.setLineSpacing(0, 1.25f);
            }
        });
    }

    private void showRideStatsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("📊 Ride Statistics & Diagnostics");
        builder.setMessage(
            "• Odometer: 1,420 km\n" +
            "• Trip A: 240.2 km | Trip B: 85.0 km\n" +
            "• Average Speed: 42 km/h\n" +
            "• Top Speed: 112 km/h\n" +
            "• Fuel Economy: 42.5 km/L (Eco Mode)\n" +
            "• Engine Run Time: 34 hrs 12 mins\n" +
            "• Battery Voltage: 12.8 V (Optimal)\n" +
            "• Coolant Temp: Normal (88°C)"
        );
        builder.setPositiveButton("Reset Trip A", (dialog, which) -> {
            Toast.makeText(this, "Trip A reset to 0.0 km", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Close", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        styleCockpitDialog(dialog);
        dialog.show();
    }

    private void showServiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("🔧 Periodic Maintenance & Service");
        builder.setMessage(
            "• Next Service Due: In 2,150 km or 45 days\n" +
            "• Engine Oil (10W-50): 82% life remaining\n" +
            "• Front Brake Pads: Good (4.2 mm)\n" +
            "• Rear Brake Pads: Good (3.8 mm)\n" +
            "• Chain Slack: 25 mm (Optimal)\n" +
            "• Air Filter: Checked\n\n" +
            "Authorized Care Network:\n" +
            "Bajaj Authorized Service Centers (Nationwide Assistance)"
        );
        builder.setPositiveButton("Call Service", (dialog, which) -> {
            try {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18002096060"));
                startActivity(intent);
            } catch (Exception ignored) {}
        });
        builder.setNegativeButton("Close", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        styleCockpitDialog(dialog);
        dialog.show();
    }

    private void showBikeInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("🏍️ Vehicle Information");
        builder.setMessage(
            "• Model: Bajaj Pulsar NS400Z\n" +
            "• Engine: 373cc Liquid-Cooled DOHC 4V\n" +
            "• Max Power: 40 PS @ 8,800 RPM\n" +
            "• Max Torque: 35 Nm @ 6,500 RPM\n" +
            "• Transmission: 6-Speed Assist & Slipper Clutch\n" +
            "• Ride Modes: Road | Rain | Sport | Off-Road\n" +
            "• Cluster: " + (bleManager != null && bleManager.isConnected() ? "Connected (BLE OK)" : "Disconnected") + "\n" +
            "• Fuel Tank Capacity: 12 Litres (High-Octane)\n" +
            "• Fuel Status: Optimal"
        );
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        styleCockpitDialog(dialog);
        dialog.show();
    }

    private void showDrawerAboutView() {
        if (scrollDrawer == null || layoutDrawerAbout == null) return;
        scrollDrawer.setVisibility(View.GONE);
        layoutDrawerAbout.setVisibility(View.VISIBLE);
        layoutDrawerAbout.scrollTo(0, 0);
        if (tvDrawerTitle != null) tvDrawerTitle.setText("ABOUT COCKPIT");
        layoutDrawerAbout.setAlpha(0f);
        layoutDrawerAbout.setTranslationX(40f);
        layoutDrawerAbout.animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(220)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    private void hideDrawerAboutView() {
        if (scrollDrawer == null || layoutDrawerAbout == null) return;
        layoutDrawerAbout.setVisibility(View.GONE);
        scrollDrawer.setVisibility(View.VISIBLE);
        if (tvDrawerTitle != null) tvDrawerTitle.setText("COCKPIT RE");
        scrollDrawer.setAlpha(0f);
        scrollDrawer.setTranslationX(-30f);
        scrollDrawer.animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(200)
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }

    private void openGithubProfile() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Deepak5310"));
            startActivity(intent);
        } catch (Exception ignored) {}
    }

    private void toggleBleConnection() {
        startBikeBleConnection();
    }

    private void toggleMediaPlayback() {
        if (!MediaStateListener.isNotificationListenerEnabled(this)) {
            Toast.makeText(this, "Enable Notification Access to control music", Toast.LENGTH_LONG).show();
            try {
                startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
            } catch (Exception ignored) {}
            return;
        }

        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.togglePlayPause();
        } else {
            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null && svc.getMediaListener() != null) {
                svc.getMediaListener().togglePlayPause();
            } else {
                sendDirectMediaKey(KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            }
        }
    }

    private void skipMediaNext() {
        if (!MediaStateListener.isNotificationListenerEnabled(this)) {
            Toast.makeText(this, "Enable Notification Access to control music", Toast.LENGTH_LONG).show();
            try {
                startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
            } catch (Exception ignored) {}
            return;
        }

        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.skipNext();
        } else {
            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null && svc.getMediaListener() != null) {
                svc.getMediaListener().skipNext();
            } else {
                sendDirectMediaKey(KeyEvent.KEYCODE_MEDIA_NEXT);
            }
        }
    }

    private void skipMediaPrevious() {
        if (!MediaStateListener.isNotificationListenerEnabled(this)) {
            Toast.makeText(this, "Enable Notification Access to control music", Toast.LENGTH_LONG).show();
            try {
                startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
            } catch (Exception ignored) {}
            return;
        }

        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.skipPrevious();
        } else {
            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null && svc.getMediaListener() != null) {
                svc.getMediaListener().skipPrevious();
            } else {
                sendDirectMediaKey(KeyEvent.KEYCODE_MEDIA_PREVIOUS);
            }
        }
    }

    private void seekMediaTo(long targetMs) {
        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.seekTo(targetMs);
        } else {
            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null && svc.getMediaListener() != null) {
                svc.getMediaListener().seekTo(targetMs);
            }
        }
    }

    private void sendDirectMediaKey(int keyCode) {
        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (am != null) {
            long now = SystemClock.uptimeMillis();
            am.dispatchMediaKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0));
            am.dispatchMediaKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0));
        }
    }

    public void setMapFullscreen(boolean fullscreen) {
        isMapFullscreen = fullscreen;
        float density = getResources().getDisplayMetrics().density;
        if (fullscreen) {
            layoutLeftPanel.animate()
                    .alpha(0f)
                    .translationX(-140f)
                    .setDuration(240)
                    .setInterpolator(new AccelerateInterpolator(1.8f))
                    .withEndAction(() -> {
                        layoutLeftPanel.setVisibility(View.GONE);
                        if (viewSplitDivider != null) viewSplitDivider.setVisibility(View.GONE);
                    }).start();

            if (viewSplitDivider != null) {
                viewSplitDivider.animate().alpha(0f).setDuration(160).start();
            }

            if (layoutMapContainer != null && layoutMapContainer.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layoutMapContainer.getLayoutParams();
                lp.setMarginStart(0);
                layoutMapContainer.setLayoutParams(lp);
            }

            layoutFullscreenMusicPill.setVisibility(View.VISIBLE);
            layoutFullscreenMusicPill.setAlpha(0f);
            layoutFullscreenMusicPill.setTranslationY(80f);
            layoutFullscreenMusicPill.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(320)
                    .setInterpolator(new OvershootInterpolator(1.4f))
                    .start();
        } else {
            if (layoutMapContainer != null && layoutMapContainer.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layoutMapContainer.getLayoutParams();
                lp.setMarginStart((int) (8 * density));
                layoutMapContainer.setLayoutParams(lp);
            }

            layoutLeftPanel.setVisibility(View.VISIBLE);
            if (viewSplitDivider != null) {
                viewSplitDivider.setVisibility(View.VISIBLE);
                viewSplitDivider.setAlpha(0f);
                viewSplitDivider.animate().alpha(1f).setDuration(260).start();
            }
            layoutLeftPanel.setTranslationX(-140f);
            layoutLeftPanel.setAlpha(0f);
            layoutLeftPanel.animate()
                    .alpha(1f)
                    .translationX(0f)
                    .setDuration(280)
                    .setInterpolator(new DecelerateInterpolator(2.0f))
                    .start();

            layoutFullscreenMusicPill.animate()
                    .alpha(0f)
                    .translationY(80f)
                    .setDuration(190)
                    .setInterpolator(new AccelerateInterpolator(1.8f))
                    .withEndAction(() -> layoutFullscreenMusicPill.setVisibility(View.GONE))
                    .start();
        }
    }

    private void openDrawer() {
        drawerBackdrop.setVisibility(View.VISIBLE);
        drawerBackdrop.setAlpha(0f);
        drawerBackdrop.animate()
                .alpha(1f)
                .setDuration(260)
                .setInterpolator(new DecelerateInterpolator(2.0f))
                .start();

        drawerPanel.setVisibility(View.VISIBLE);
        int width = drawerPanel.getWidth() > 0 ? drawerPanel.getWidth() : 800;
        drawerPanel.setTranslationX(width);
        drawerPanel.animate()
                .translationX(0f)
                .setDuration(300)
                .setInterpolator(new DecelerateInterpolator(2.2f))
                .start();

        // Staggered cascade entrance for drawer items
        View[] drawerItems = new View[]{
                cardBikeStage,
                cardBikeConnection,
                itemSavedPlaces,
                itemAbout,
                btnDrawerExit
        };

        for (int i = 0; i < drawerItems.length; i++) {
            View item = drawerItems[i];
            if (item != null) {
                item.setAlpha(0f);
                item.setTranslationX(50f);
                item.animate()
                        .alpha(1f)
                        .translationX(0f)
                        .setDuration(250)
                        .setStartDelay(50 + (i * 25))
                        .setInterpolator(new OvershootInterpolator(1.2f))
                        .start();
            }
        }
    }

    private void closeDrawer() {
        if (layoutDrawerAbout != null && layoutDrawerAbout.getVisibility() == View.VISIBLE) {
            layoutDrawerAbout.setVisibility(View.GONE);
            if (scrollDrawer != null) {
                scrollDrawer.setVisibility(View.VISIBLE);
                scrollDrawer.setTranslationX(0f);
                scrollDrawer.setAlpha(1f);
            }
            if (tvDrawerTitle != null) tvDrawerTitle.setText("COCKPIT RE");
        }

        drawerBackdrop.animate()
                .alpha(0f)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator(1.8f))
                .withEndAction(() -> drawerBackdrop.setVisibility(View.GONE))
                .start();

        int width = drawerPanel.getWidth() > 0 ? drawerPanel.getWidth() : 800;
        drawerPanel.animate()
                .translationX(width)
                .setDuration(240)
                .setInterpolator(new AccelerateInterpolator(2.0f))
                .withEndAction(() -> drawerPanel.setVisibility(View.GONE))
                .start();
    }

    private void initLiveSystemSensors() {
        try {
            BatteryManager bm = (BatteryManager) getSystemService(Context.BATTERY_SERVICE);
            if (bm != null) {
                int cap = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                int status = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS);
                isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING
                        || status == BatteryManager.BATTERY_STATUS_FULL);
                if (cap >= 0) {
                    currentBattery = cap;
                    updateBatteryDisplay(currentBattery, isCharging);
                }
            }
        } catch (Exception ignored) {}

        try {
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                tm.registerTelephonyCallback(getMainExecutor(), new MainSignalCallback(this));
            }
        } catch (SecurityException ignored) {}

        initGpsTracking();
    }

    private static class MainSignalCallback extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {
        private final MainActivity activity;

        MainSignalCallback(MainActivity activity) {
            this.activity = activity;
        }

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                activity.currentSignalBars = signalStrength.getLevel();
                activity.runOnUiThread(() -> activity.updateSignalDisplay(activity.currentSignalBars));
            }
        }
    }

    private void updateBatteryDisplay(int percent, boolean charging) {
        // Cockpit telemetry simplified for ICE motorcycles
    }

    private void updateSignalDisplay(int bars) {
        // Cockpit telemetry simplified for ICE motorcycles
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupMicroAnimations() {
        if (viewDrawerBtStatusDot != null) {
            pulseAnimator = ObjectAnimator.ofFloat(viewDrawerBtStatusDot, "alpha", 0.3f, 1.0f);
            pulseAnimator.setDuration(900);
            pulseAnimator.setRepeatMode(ValueAnimator.REVERSE);
            pulseAnimator.setRepeatCount(ValueAnimator.INFINITE);
            pulseAnimator.start();
        }

        View.OnTouchListener tactileTouch = (v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.animate().scaleX(0.92f).scaleY(0.92f).setDuration(90).setInterpolator(new DecelerateInterpolator()).start();
                try {
                    v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                } catch (Exception ignored) {}
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(220).setInterpolator(new OvershootInterpolator(2.2f)).start();
            }
            return false;
        };

        View[] tactileViews = new View[]{
                btnMediaPlayPause, btnMediaPrev, btnMediaNext, btnPillPlayPause, btnPillNext,
                btnOpenDrawer, btnDrawerClose, btnNavEnd, btnCompass, btnCurrentLocation, btnVoiceNav, btnLayers,
                btnZoomIn, btnZoomOut, btnDrawerExit, btnDrawerBleConnect, btnMapSearch, btnStartNavNow, btnCancelRoutePreview,
                layoutRecenterPill, btnSearchCancel, btnSearchClear, btnSearchImeToggle, viewSplitDivider,
                itemSavedPlaces, itemAbout, btnAboutBack, btnAboutGithub
        };
        for (View view : tactileViews) {
            if (view != null) view.setOnTouchListener(tactileTouch);
        }
    }

    private void updateCockpitMedia(String title, String artist, String source, int state, int posSec, int durSec, Bitmap art) {
        runOnUiThread(() -> {
            if (title == null || title.trim().isEmpty() || (state == 0 && (title.isEmpty() || title.equals("No Media")))) {
                tvMediaTrack.setText("No Media Playing");
                tvMediaArtist.setText("Start playback on phone");
                tvMediaSource.setText("Standby");
                tvPillTrack.setText("No Media");
                tvPillArtist.setText("Standby");
                btnMediaPlayPause.setImageResource(R.drawable.ic_media_play);
                btnPillPlayPause.setImageResource(R.drawable.ic_media_play);
                int standbyAccent = (currentThemePalette != null) ? currentThemePalette.accentPrimary : Color.parseColor("#38BDF8");
                btnMediaPlayPause.setColorFilter(standbyAccent);
                btnPillPlayPause.setColorFilter(standbyAccent);
                View dotStandby = findViewById(R.id.viewMediaPulseDot);
                if (dotStandby != null) {
                    dotStandby.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF64748B));
                }
                currentMediaDurSec = 0;
                if (pbMediaTrack != null) {
                    pbMediaTrack.setProgress(0);
                    if (pbMediaTrack instanceof WavySeekBar) {
                        ((WavySeekBar) pbMediaTrack).setPlaying(false);
                    }
                }
                tvMediaElapsed.setText("0:00");
                tvMediaDuration.setText("0:00");
                ivAlbumArt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ivAlbumArt.setImageResource(R.drawable.ic_album_art_placeholder);
                ivPillAlbumArt.setImageResource(R.drawable.ic_pulsar_logo);
            } else {
                tvMediaTrack.setText(title);
                tvPillTrack.setText(title);

                String artistStr = (artist != null && !artist.trim().isEmpty()) ? artist : "Unknown Artist";
                tvMediaArtist.setText(artistStr);
                tvPillArtist.setText(artistStr);

                if (source != null && !source.isEmpty()) {
                    tvMediaSource.setText(source);
                }

                boolean isPlaying = (state == 2);
                int accent = (currentThemePalette != null) ? currentThemePalette.accentPrimary : Color.parseColor("#38BDF8");
                View dotActive = findViewById(R.id.viewMediaPulseDot);
                if (dotActive != null) {
                    dotActive.setBackgroundTintList(android.content.res.ColorStateList.valueOf(isPlaying ? accent : 0xFF64748B));
                }
                if (isPlaying) { // 2 = Playing
                    btnMediaPlayPause.setImageResource(R.drawable.ic_media_pause);
                    btnPillPlayPause.setImageResource(R.drawable.ic_media_pause);
                } else {
                    btnMediaPlayPause.setImageResource(R.drawable.ic_media_play);
                    btnPillPlayPause.setImageResource(R.drawable.ic_media_play);
                }
                btnMediaPlayPause.setColorFilter(accent);
                btnPillPlayPause.setColorFilter(accent);
                if (pbMediaTrack instanceof WavySeekBar) {
                    ((WavySeekBar) pbMediaTrack).setPlaying(isPlaying);
                }

                currentMediaDurSec = durSec;
                if (!isUserScrubbingMedia && pbMediaTrack != null) {
                    if (durSec > 0) {
                        int progress = (int) (((float) posSec / durSec) * pbMediaTrack.getMax());
                        pbMediaTrack.setProgress(Math.min(pbMediaTrack.getMax(), Math.max(0, progress)));
                        tvMediaElapsed.setText(formatTime(posSec));
                        tvMediaDuration.setText(formatTime(durSec));
                    } else if (posSec > 0) {
                        tvMediaElapsed.setText(formatTime(posSec));
                    }
                }

                if (art != null) {
                    ivAlbumArt.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ivAlbumArt.setImageBitmap(art);
                    ivPillAlbumArt.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ivPillAlbumArt.setImageBitmap(art);
                } else {
                    ivAlbumArt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ivAlbumArt.setImageResource(R.drawable.ic_album_art_placeholder);
                    ivPillAlbumArt.setImageResource(R.drawable.ic_pulsar_logo);
                }
            }
        });
    }

    private void updateCockpitMedia(String title, String artist, String source, int state, int posSec, int durSec) {
        Bitmap art = (MediaStateListener.getInstance() != null)
                ? MediaStateListener.getInstance().getCurrentAlbumArt() : null;
        updateCockpitMedia(title, artist, source, state, posSec, durSec, art);
    }

    private static String formatTime(int totalSeconds) {
        int m = totalSeconds / 60;
        int s = totalSeconds % 60;
        return String.format(Locale.getDefault(), "%d:%02d", m, s);
    }

    private void startBikeBleConnection() {
        if (bleManager != null && bleManager.isConnected()) {
            bleManager.setAutoReconnect(false);
            bleManager.disconnect();
            updateBleUiState(BleUiState.DISCONNECTED, null);
            return;
        }

        if (isBleConnecting) {
            isBleConnecting = false;
            bleTimeoutHandler.removeCallbacks(bleTimeoutRunnable);
            if (bleManager != null) {
                bleManager.stopScan();
                bleManager.disconnect();
            }
            updateBleUiState(BleUiState.DISCONNECTED, null);
            return;
        }

        BluetoothManager bm = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter adapter = (bm != null) ? bm.getAdapter() : null;
        if (adapter == null) {
            Toast.makeText(this, "Bluetooth not supported on this device", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!adapter.isEnabled()) {
            try {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } catch (Exception e) {
                Toast.makeText(this, "Please enable Bluetooth in settings", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT
                }, 1003);
                return;
            }
        }

        isBleConnecting = true;
        updateBleUiState(BleUiState.CONNECTING, null);
        bleTimeoutHandler.removeCallbacks(bleTimeoutRunnable);
        bleTimeoutHandler.postDelayed(bleTimeoutRunnable, 30000);

        if (bleManager != null) {
            bleManager.setAutoReconnect(true);
            bleManager.startScanOrConnect();
        }
    }

    private void setStatusDotColor(int color, float alpha) {
        if (viewDrawerBtStatusDot != null) {
            GradientDrawable dot = new GradientDrawable();
            dot.setShape(GradientDrawable.OVAL);
            dot.setColor(color);
            viewDrawerBtStatusDot.setBackground(dot);
            viewDrawerBtStatusDot.setAlpha(alpha);
        }
    }

    private void updateBleUiState(BleUiState state, String bikeName) {
        if (tvDrawerBtStatus == null) return;
        int accent = (currentThemePalette != null) ? currentThemePalette.accentPrimary : 0xFF00E5FF;
        float density = getResources().getDisplayMetrics().density;

        switch (state) {
            case DISCONNECTED:
                isBleConnecting = false;
                setStatusDotColor(0xFF64748B, 0.4f);
                tvDrawerBtStatus.setText("Disconnected");
                tvDrawerBtStatus.setTextColor(0xFF94A3B8);
                if (pbBleConnecting != null) pbBleConnecting.setVisibility(View.GONE);
                if (tvBleDetailMsg != null) {
                    tvBleDetailMsg.setText("Tap connect to pair bike");
                    tvBleDetailMsg.setTextColor(0xFF64748B);
                }
                if (ivDrawerBleActionIcon != null) {
                    ivDrawerBleActionIcon.setImageResource(R.drawable.ic_bluetooth);
                    ivDrawerBleActionIcon.setColorFilter(0xFF000000);
                }
                if (tvDrawerBleActionText != null) {
                    tvDrawerBleActionText.setText("Connect to Bike");
                    tvDrawerBleActionText.setTextColor(0xFF000000);
                }
                if (btnDrawerBleConnect != null) {
                    GradientDrawable bg = new GradientDrawable();
                    bg.setShape(GradientDrawable.RECTANGLE);
                    bg.setCornerRadius(10 * density);
                    bg.setColor(accent);
                    btnDrawerBleConnect.setBackground(bg);
                }
                if (tvDrawerBikeName != null) tvDrawerBikeName.setText("Pulsar NS400Z");
                break;

            case CONNECTING:
                setStatusDotColor(0xFFF59E0B, 1.0f);
                tvDrawerBtStatus.setText("Connecting...");
                tvDrawerBtStatus.setTextColor(0xFFF59E0B);
                if (pbBleConnecting != null) pbBleConnecting.setVisibility(View.VISIBLE);
                if (tvBleDetailMsg != null) {
                    tvBleDetailMsg.setText("Scanning for bike BLE beacon (30s)...");
                    tvBleDetailMsg.setTextColor(0xFFF59E0B);
                }
                if (ivDrawerBleActionIcon != null) {
                    ivDrawerBleActionIcon.setImageResource(R.drawable.ic_close);
                    ivDrawerBleActionIcon.setColorFilter(0xFFEF4444);
                }
                if (tvDrawerBleActionText != null) {
                    tvDrawerBleActionText.setText("Cancel");
                    tvDrawerBleActionText.setTextColor(0xFFEF4444);
                }
                if (btnDrawerBleConnect != null) {
                    GradientDrawable bg = new GradientDrawable();
                    bg.setShape(GradientDrawable.RECTANGLE);
                    bg.setCornerRadius(10 * density);
                    bg.setColor(0x22EF4444);
                    bg.setStroke((int) (1.2f * density), 0xFFEF4444);
                    btnDrawerBleConnect.setBackground(bg);
                }
                if (tvDrawerBikeName != null) tvDrawerBikeName.setText("Searching Bike...");
                break;

            case CONNECTED:
                isBleConnecting = false;
                String displayName = (bikeName != null && !bikeName.trim().isEmpty()) ? bikeName : "Bajaj Pulsar NS400Z";
                setStatusDotColor(0xFF10B981, 1.0f);
                tvDrawerBtStatus.setText("Connected: " + displayName);
                tvDrawerBtStatus.setTextColor(0xFF10B981);
                if (pbBleConnecting != null) pbBleConnecting.setVisibility(View.GONE);
                if (tvBleDetailMsg != null) {
                    tvBleDetailMsg.setText("BLE Live Telemetry & Nav Sync Active");
                    tvBleDetailMsg.setTextColor(0xFF10B981);
                }
                if (ivDrawerBleActionIcon != null) {
                    ivDrawerBleActionIcon.setImageResource(R.drawable.ic_bluetooth);
                    ivDrawerBleActionIcon.setColorFilter(0xFFEF4444);
                }
                if (tvDrawerBleActionText != null) {
                    tvDrawerBleActionText.setText("Disconnect");
                    tvDrawerBleActionText.setTextColor(0xFFEF4444);
                }
                if (btnDrawerBleConnect != null) {
                    GradientDrawable bg = new GradientDrawable();
                    bg.setShape(GradientDrawable.RECTANGLE);
                    bg.setCornerRadius(10 * density);
                    bg.setColor(0x22EF4444);
                    bg.setStroke((int) (1.2f * density), 0xFFEF4444);
                    btnDrawerBleConnect.setBackground(bg);
                }
                if (tvDrawerBikeName != null) tvDrawerBikeName.setText(displayName);
                break;

            case FAILED:
                isBleConnecting = false;
                setStatusDotColor(0xFFEF4444, 1.0f);
                tvDrawerBtStatus.setText("Connection Failed");
                tvDrawerBtStatus.setTextColor(0xFFEF4444);
                if (pbBleConnecting != null) pbBleConnecting.setVisibility(View.GONE);
                if (tvBleDetailMsg != null) {
                    tvBleDetailMsg.setText("Bike cluster not found within 30s");
                    tvBleDetailMsg.setTextColor(0xFFEF4444);
                }
                if (ivDrawerBleActionIcon != null) {
                    ivDrawerBleActionIcon.setImageResource(R.drawable.ic_refresh);
                    ivDrawerBleActionIcon.setColorFilter(0xFF000000);
                }
                if (tvDrawerBleActionText != null) {
                    tvDrawerBleActionText.setText("Retry Connection");
                    tvDrawerBleActionText.setTextColor(0xFF000000);
                }
                if (btnDrawerBleConnect != null) {
                    GradientDrawable bg = new GradientDrawable();
                    bg.setShape(GradientDrawable.RECTANGLE);
                    bg.setCornerRadius(10 * density);
                    bg.setColor(accent);
                    btnDrawerBleConnect.setBackground(bg);
                }
                if (tvDrawerBikeName != null) tvDrawerBikeName.setText("Pulsar NS400Z");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            BluetoothManager bm = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            BluetoothAdapter adapter = (bm != null) ? bm.getAdapter() : null;
            if (adapter != null && adapter.isEnabled()) {
                startBikeBleConnection();
            } else {
                Toast.makeText(this, "Bluetooth is required to connect to bike", Toast.LENGTH_LONG).show();
                updateBleUiState(BleUiState.DISCONNECTED, null);
            }
        }
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        bleTimeoutHandler.removeCallbacks(bleTimeoutRunnable);
        isBleConnecting = false;
        runOnUiThread(() -> {
            if (connected) {
                updateBleUiState(BleUiState.CONNECTED, deviceName);
            } else {
                updateBleUiState(BleUiState.DISCONNECTED, null);
            }
        });
    }

    private void terminateAppSession() {
        if (bleManager != null) {
            bleManager.setAutoReconnect(false);
            bleManager.stopScan();
            bleManager.disconnect();
        }

        try {
            Intent stopIntent = new Intent(this, PulsarForegroundService.class);
            stopIntent.setAction(PulsarForegroundService.ACTION_STOP);
            startService(stopIntent);
        } catch (Exception ignored) {}

        try {
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm != null) {
                nm.cancelAll();
            }
        } catch (Exception ignored) {}

        finishAffinity();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }, 150);
    }

    @Override
    public void onPacketSent(String charUuid, byte[] frame, boolean success) {
        // Log telemetry dispatch
    }

    @Override
    public void onHandlebarEvent(PulsarProtocol.HandlebarEvent event) {
        // Handlebar actions are processed silently to avoid visual distraction during riding
    }

    private void openNotificationSettings() {
        try {
            startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
        } catch (Exception e) {
            Toast.makeText(this, "Unable to open Notification settings", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestAppPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            String[] perms = new String[]{
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.POST_NOTIFICATIONS
            };
            boolean need = false;
            for (String p : perms) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    need = true;
                    break;
                }
            }
            if (need) {
                requestPermissions(perms, PERMISSION_REQ_CODE);
            }
        }
    }

    private final LocationListener gpsLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            if (location == null) return;
            currentRiderLat = location.getLatitude();
            currentRiderLng = location.getLongitude();
            try {
                getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                        .edit()
                        .putFloat("saved_rider_lat", (float) currentRiderLat)
                        .putFloat("saved_rider_lng", (float) currentRiderLng)
                        .apply();
            } catch (Exception ignored) {}
            if (location.hasBearing()) {
                currentRiderBearing = location.getBearing();
            }

            if (location.hasSpeed() && location.getSpeed() >= 0) {
                currentSpeedKmh = Math.round(location.getSpeed() * 3.6f);
            } else if (lastSpeedLocation != null && lastSpeedTimeMs > 0) {
                long dtMs = location.getTime() - lastSpeedTimeMs;
                if (dtMs <= 0) {
                    dtMs = System.currentTimeMillis() - lastSpeedTimeMs;
                }
                if (dtMs > 400 && dtMs < 10000) {
                    float dist = lastSpeedLocation.distanceTo(location);
                    float speedMps = dist / (dtMs / 1000.0f);
                    currentSpeedKmh = Math.round(speedMps * 3.6f);
                } else if (dtMs >= 10000) {
                    currentSpeedKmh = 0;
                }
            } else {
                currentSpeedKmh = 0;
            }
            lastSpeedLocation = location;
            lastSpeedTimeMs = location.getTime() > 0 ? location.getTime() : System.currentTimeMillis();

            if (currentSpeedKmh < 0) currentSpeedKmh = 0;
            if (currentSpeedKmh > 299) currentSpeedKmh = 299;

            if (tvCurrentSpeed != null) {
                int prevSpeed = 0;
                try {
                    prevSpeed = Integer.parseInt(tvCurrentSpeed.getText().toString());
                } catch (Exception ignored) {}
                tvCurrentSpeed.setText(String.valueOf(currentSpeedKmh));
                if (currentSpeedKmh > 80) {
                    tvCurrentSpeed.setTextColor(Color.parseColor("#EF4444"));
                    tvCurrentSpeed.animate().scaleX(1.08f).scaleY(1.08f).setDuration(120).withEndAction(() -> {
                        tvCurrentSpeed.animate().scaleX(1.0f).scaleY(1.0f).setDuration(120).start();
                    }).start();
                } else {
                    tvCurrentSpeed.setTextColor(Color.parseColor("#FFFFFF"));
                    if (Math.abs(currentSpeedKmh - prevSpeed) >= 4) {
                        tvCurrentSpeed.animate().scaleX(1.05f).scaleY(1.05f).setDuration(100).withEndAction(() -> {
                            tvCurrentSpeed.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        }).start();
                    }
                }
            }

            if (mapplsMapView != null) {
                mapplsMapView.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing);
            }
            checkRouteProgress(location);
        }
    };

    private void initGpsTracking() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (locationManager != null && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Location last = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (last == null) {
                    last = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
                if (last == null) {
                    last = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                }
                if (last != null) {
                    currentRiderLat = last.getLatitude();
                    currentRiderLng = last.getLongitude();
                    try {
                        getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                                .edit()
                                .putFloat("saved_rider_lat", (float) currentRiderLat)
                                .putFloat("saved_rider_lng", (float) currentRiderLng)
                                .apply();
                    } catch (Exception ignored) {}
                    if (mapplsMapView != null) {
                        mapplsMapView.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing);
                    }
                }
                try {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 2.0f, gpsLocationListener);
                } catch (Exception ignored) {}
                try {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000L, 5.0f, gpsLocationListener);
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }

    private void centerMapOnCurrentLocation() {
        if (locationManager != null && !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "Please turn ON device Location / GPS", Toast.LENGTH_LONG).show();
            try {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            } catch (Exception ignored) {}
            return;
        }

        try {
            if (locationManager != null && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (loc == null) {
                    loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
                if (loc == null) {
                    loc = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                }
                if (loc != null) {
                    currentRiderLat = loc.getLatitude();
                    currentRiderLng = loc.getLongitude();
                    if (loc.hasBearing()) {
                        currentRiderBearing = loc.getBearing();
                    }
                    try {
                        getSharedPreferences("bajaj_ride_prefs", Context.MODE_PRIVATE)
                                .edit()
                                .putFloat("saved_rider_lat", (float) currentRiderLat)
                                .putFloat("saved_rider_lng", (float) currentRiderLng)
                                .apply();
                    } catch (Exception ignored) {}
                }
            }
        } catch (Exception ignored) {}

        if (mapplsMapView != null) {
            if (currentRiderLat != 0.0 && currentRiderLng != 0.0) {
                mapplsMapView.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing);
                mapplsMapView.centerOnCurrentLocation();
            } else {
                Toast.makeText(this, "Acquiring live GPS fix...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showRecenterButton() {
        if (currentActiveRoute == null) return;
        if (layoutRecenterPill != null && layoutRecenterPill.getVisibility() != View.VISIBLE) {
            layoutRecenterPill.setVisibility(View.VISIBLE);
            layoutRecenterPill.setAlpha(0f);
            layoutRecenterPill.setTranslationY(-35f);
            layoutRecenterPill.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(280)
                    .setInterpolator(new OvershootInterpolator(1.8f))
                    .start();
        }
        if (btnCurrentLocation != null) {
            btnCurrentLocation.setColorFilter(Color.parseColor("#F59E0B"));
        }
    }

    private void hideRecenterButton() {
        if (layoutRecenterPill != null && layoutRecenterPill.getVisibility() == View.VISIBLE) {
            layoutRecenterPill.animate()
                    .alpha(0f)
                    .translationY(-35f)
                    .setDuration(200)
                    .setInterpolator(new AccelerateInterpolator(1.8f))
                    .withEndAction(() -> layoutRecenterPill.setVisibility(View.GONE))
                    .start();
        }
        if (btnCurrentLocation != null) {
            int accent = (currentThemePalette != null) ? currentThemePalette.accentPrimary : Color.parseColor("#38BDF8");
            btnCurrentLocation.setColorFilter(accent);
        }
    }

    private void checkRouteProgress(Location riderLocation) {
        if (currentActiveRoute == null || currentActiveRoute.steps.isEmpty()) return;

        if (currentRouteStepIndex >= currentActiveRoute.steps.size()) {
            endActiveNavigation();
            return;
        }

        MapplsApiClient.RouteStep step = currentActiveRoute.steps.get(currentRouteStepIndex);
        // Skip steps with no valid location data (lat/lng == 0)
        while (step.lat == 0.0 && step.lng == 0.0 && currentRouteStepIndex < currentActiveRoute.steps.size() - 1) {
            currentRouteStepIndex++;
            step = currentActiveRoute.steps.get(currentRouteStepIndex);
        }

        float[] results = new float[1];
        float distToStep;
        if (step.lat != 0.0 || step.lng != 0.0) {
            Location.distanceBetween(riderLocation.getLatitude(), riderLocation.getLongitude(),
                    step.lat, step.lng, results);
            distToStep = results[0];
        } else {
            distToStep = (float) step.distanceMeters;
        }

        // Advance to next maneuver if within 30m of waypoint
        if (distToStep < 30f) {
            if (currentRouteStepIndex < currentActiveRoute.steps.size() - 1) {
                currentRouteStepIndex++;
                step = currentActiveRoute.steps.get(currentRouteStepIndex);
                if (step.lat != 0.0 || step.lng != 0.0) {
                    Location.distanceBetween(riderLocation.getLatitude(), riderLocation.getLongitude(),
                            step.lat, step.lng, results);
                    distToStep = results[0];
                } else {
                    distToStep = (float) step.distanceMeters;
                }
                String instr = (step.instruction != null && !step.instruction.isEmpty()) ? step.instruction : step.street;
                if (instr != null && !instr.isEmpty()) {
                    speakVoiceGuidance(instr);
                }
            } else {
                speakVoiceGuidance("You have arrived at your destination");
                Toast.makeText(this, "Destination Reached", Toast.LENGTH_LONG).show();
                endActiveNavigation();
                return;
            }
        }

        double remDist = distToStep;
        double remDur = step.durationSeconds;
        for (int i = currentRouteStepIndex + 1; i < currentActiveRoute.steps.size(); i++) {
            remDist += currentActiveRoute.steps.get(i).distanceMeters;
            remDur += currentActiveRoute.steps.get(i).durationSeconds;
        }

        updateRouteStepDisplay(step, distToStep, remDist, remDur);
    }

    private void setupSearchOverlay() {
        if (layoutSearchOverlay == null) return;

        // Dismiss when tapping outside the card on the backdrop scrim
        layoutSearchOverlay.setOnClickListener(v -> hideDestinationSearch());
        if (cardSearchBox != null) {
            cardSearchBox.setOnClickListener(v -> {}); // prevent backdrop click
        }
        if (btnSearchCancel != null) {
            btnSearchCancel.setOnClickListener(v -> hideDestinationSearch());
        }
        if (btnSearchClear != null) {
            btnSearchClear.setOnClickListener(v -> {
                if (etSearchQuery != null) etSearchQuery.setText("");
            });
        }

        searchAdapter = new ArrayAdapter<MapplsApiClient.PlaceResult>(
                this, R.layout.item_search_place, searchPlaceList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_search_place, parent, false);
                }
                MapplsApiClient.PlaceResult item = getItem(position);
                if (item != null) {
                    TextView tvName = convertView.findViewById(R.id.tvPlaceName);
                    TextView tvAddr = convertView.findViewById(R.id.tvPlaceAddress);
                    TextView tvPin = convertView.findViewById(R.id.tvPlacePin);
                    TextView tvDist = convertView.findViewById(R.id.tvPlaceDistance);

                    tvName.setText(item.name);
                    tvAddr.setText(item.address);
                    String distStr = item.getFormattedDistance();
                    if (distStr != null && !distStr.isEmpty()) {
                        tvDist.setText(distStr);
                        tvDist.setVisibility(View.VISIBLE);
                    } else {
                        tvDist.setVisibility(View.GONE);
                    }
                    if (item.mapplsPin != null && !item.mapplsPin.isEmpty()) {
                        tvPin.setText(item.mapplsPin);
                        tvPin.setVisibility(View.VISIBLE);
                    } else {
                        tvPin.setVisibility(View.GONE);
                    }
                }
                return convertView;
            }
        };
        if (lvSearchResults != null) {
            lvSearchResults.setAdapter(searchAdapter);
            lvSearchResults.setOnItemClickListener((parent, view, position, id) -> {
                MapplsApiClient.PlaceResult selected = searchPlaceList.get(position);
                hideDestinationSearch();
                previewRoute(selected);
            });
        }
        Runnable searchRunnable = () -> {
            if (etSearchQuery == null) return;
            String query = etSearchQuery.getText().toString().trim();
            if (query.length() < 2) return;
            if (pbSearchProgress != null) pbSearchProgress.setVisibility(View.VISIBLE);
            MapplsApiClient.getInstance().searchPlaces(query, currentRiderLat, currentRiderLng, new MapplsApiClient.PlacesCallback() {
                @Override
                public void onSuccess(List<MapplsApiClient.PlaceResult> results) {
                    if (pbSearchProgress != null) pbSearchProgress.setVisibility(View.INVISIBLE);
                    searchPlaceList.clear();
                    searchPlaceList.addAll(results);
                    searchAdapter.notifyDataSetChanged();
                }

                @Override
                public void onError(String error) {
                    if (pbSearchProgress != null) pbSearchProgress.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Search: " + error, Toast.LENGTH_SHORT).show();
                }
            });
        };

        if (etSearchQuery != null) {
            etSearchQuery.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (btnSearchClear != null) {
                        btnSearchClear.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
                    }
                    searchDebounceHandler.removeCallbacks(searchRunnable);
                    if (s.length() >= 2) {
                        searchDebounceHandler.postDelayed(searchRunnable, 350);
                    }
                }
                @Override
                public void afterTextChanged(Editable s) {}
            });

            etSearchQuery.setOnEditorActionListener((v, actionId, event) -> {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    actionId == EditorInfo.IME_ACTION_DONE ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    searchDebounceHandler.removeCallbacks(searchRunnable);
                    searchRunnable.run();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) imm.hideSoftInputFromWindow(etSearchQuery.getWindowToken(), 0);
                    return true;
                }
                return false;
            });
        }

        // Initialize Integrated Automotive In-App Keyboard
        View keyboardContainer = findViewById(R.id.layoutInAppKeyboard);
        if (keyboardContainer != null && etSearchQuery != null) {
            cockpitKeyboard = new CockpitKeyboard(keyboardContainer, etSearchQuery, query -> {
                searchDebounceHandler.removeCallbacks(searchRunnable);
                searchRunnable.run();
            });
        }

        // Toggle button to optionally switch to System Keyboard (e.g. for voice typing)
        if (btnSearchImeToggle != null && etSearchQuery != null) {
            btnSearchImeToggle.setOnClickListener(v -> {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    if (cockpitKeyboard != null && cockpitKeyboard.isVisible()) {
                        cockpitKeyboard.hide();
                        etSearchQuery.setShowSoftInputOnFocus(true);
                        imm.showSoftInput(etSearchQuery, 0);
                    } else {
                        imm.hideSoftInputFromWindow(etSearchQuery.getWindowToken(), 0);
                        etSearchQuery.setShowSoftInputOnFocus(false);
                        if (cockpitKeyboard != null) cockpitKeyboard.show();
                    }
                }
            });
        }
    }

    private void showDestinationSearch() {
        if (layoutSearchOverlay == null) return;
        layoutSearchOverlay.setVisibility(View.VISIBLE);
        layoutSearchOverlay.setAlpha(0f);
        layoutSearchOverlay.animate()
                .alpha(1f)
                .setDuration(220)
                .setInterpolator(new DecelerateInterpolator(1.8f))
                .start();

        if (cardSearchBox != null) {
            cardSearchBox.setTranslationY(-30f);
            cardSearchBox.animate()
                    .translationY(0f)
                    .setDuration(260)
                    .setInterpolator(new DecelerateInterpolator(2.0f))
                    .start();
        }

        if (cockpitKeyboard != null) {
            cockpitKeyboard.show();
        }
        if (etSearchQuery != null) {
            etSearchQuery.setShowSoftInputOnFocus(false);
            etSearchQuery.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(etSearchQuery.getWindowToken(), 0);
            }
        }
    }

    private void hideDestinationSearch() {
        if (layoutSearchOverlay == null) return;
        if (cardSearchBox != null) {
            cardSearchBox.animate()
                    .translationY(-30f)
                    .setDuration(180)
                    .setInterpolator(new AccelerateInterpolator(1.8f))
                    .start();
        }
        layoutSearchOverlay.animate()
                .alpha(0f)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator(1.8f))
                .withEndAction(() -> {
                    layoutSearchOverlay.setVisibility(View.GONE);
                    if (cardSearchBox != null) cardSearchBox.setTranslationY(0f);
                })
                .start();

        if (cockpitKeyboard != null) {
            cockpitKeyboard.hide();
        }
        if (etSearchQuery != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(etSearchQuery.getWindowToken(), 0);
            }
        }
    }

    private void handleBackPress() {
        if (layoutSearchOverlay != null && layoutSearchOverlay.getVisibility() == View.VISIBLE) {
            hideDestinationSearch();
            return;
        }
        if (cardRoutePreview != null && cardRoutePreview.getVisibility() == View.VISIBLE) {
            cancelRoutePreview();
            return;
        }
        if (currentActiveRoute != null) {
            endActiveNavigation();
            return;
        }
        if (layoutDrawerAbout != null && layoutDrawerAbout.getVisibility() == View.VISIBLE) {
            hideDrawerAboutView();
            return;
        }
        if (drawerBackdrop != null && drawerBackdrop.getVisibility() == View.VISIBLE) {
            closeDrawer();
            return;
        }
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            handleBackPress();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void previewRoute(MapplsApiClient.PlaceResult selected) {
        if (selected == null) return;
        MapplsApiClient.getInstance().getDirections(currentRiderLat, currentRiderLng, selected.lat, selected.lng, selected.mapplsPin, new MapplsApiClient.RouteCallback() {
            @Override
            public void onSuccess(MapplsApiClient.RouteResult route) {
                pendingPreviewRoute = route;
                pendingDestName = selected.name;

                List<double[]> points = decodePolyline(route.geometryPolyline, true);
                if (points.isEmpty()) {
                    for (MapplsApiClient.RouteStep step : route.steps) {
                        points.add(new double[]{step.lng, step.lat});
                    }
                }
                if (mapplsMapView != null) {
                    mapplsMapView.plotRoute(points);
                    mapplsMapView.fitRouteBounds(points);
                }

                if (tvPreviewDestName != null) tvPreviewDestName.setText(selected.name);
                if (tvPreviewDestAddress != null) tvPreviewDestAddress.setText(selected.address);

                int totalMin = (int) Math.round(route.totalDurationSeconds / 60.0);
                String durStr;
                if (totalMin >= 60) {
                    int hrs = totalMin / 60;
                    int mins = totalMin % 60;
                    durStr = hrs + " hr " + mins + " min";
                } else {
                    durStr = totalMin + " min";
                }
                if (tvPreviewDuration != null) tvPreviewDuration.setText(durStr);

                String distStr;
                if (route.totalDistanceMeters >= 1000) {
                    distStr = String.format(Locale.getDefault(), " • %.0f km", route.totalDistanceMeters / 1000.0);
                } else {
                    distStr = " • " + (int) route.totalDistanceMeters + " m";
                }
                if (tvPreviewDistance != null) tvPreviewDistance.setText(distStr);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, (int) route.totalDurationSeconds);
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                if (tvPreviewSub != null) {
                    tvPreviewSub.setText(String.format(Locale.getDefault(), "Fastest route • ETA %s", sdf.format(cal.getTime())));
                }

                if (cardRoutePreview != null) {
                    cardRoutePreview.setVisibility(View.VISIBLE);
                    cardRoutePreview.setAlpha(0f);
                    cardRoutePreview.setTranslationY(40f);
                    cardRoutePreview.animate()
                            .alpha(1f)
                            .translationY(0f)
                            .setDuration(280)
                            .setInterpolator(new OvershootInterpolator(1.3f))
                            .start();
                }
                if (cardTurnInstruction != null) cardTurnInstruction.setVisibility(View.GONE);
                if (cardBottomNav != null) cardBottomNav.setVisibility(View.GONE);
                if (cardSpeedHud != null) cardSpeedHud.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, "Route failed: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startActiveNavigation() {
        if (pendingPreviewRoute == null) return;
        currentActiveRoute = pendingPreviewRoute;
        currentRouteStepIndex = 0;

        if (cardRoutePreview != null) {
            cardRoutePreview.animate()
                    .alpha(0f)
                    .translationY(30f)
                    .setDuration(180)
                    .withEndAction(() -> cardRoutePreview.setVisibility(View.GONE))
                    .start();
        }
        if (cardTurnInstruction != null) {
            cardTurnInstruction.setVisibility(View.VISIBLE);
            cardTurnInstruction.setAlpha(0f);
            cardTurnInstruction.setTranslationY(-30f);
            cardTurnInstruction.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(280)
                    .setInterpolator(new DecelerateInterpolator(2.0f))
                    .start();
        }
        if (cardBottomNav != null) {
            cardBottomNav.setVisibility(View.VISIBLE);
            cardBottomNav.setAlpha(0f);
            cardBottomNav.setTranslationY(30f);
            cardBottomNav.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(280)
                    .setInterpolator(new DecelerateInterpolator(2.0f))
                    .start();
        }
        if (cardSpeedHud != null) {
            cardSpeedHud.setVisibility(View.VISIBLE);
            cardSpeedHud.setAlpha(0f);
            cardSpeedHud.setTranslationX(-35f);
            cardSpeedHud.animate()
                    .alpha(1f)
                    .translationX(0f)
                    .setDuration(300)
                    .setInterpolator(new OvershootInterpolator(1.4f))
                    .start();
        }

        currentSpeedKmh = 0;
        if (tvCurrentSpeed != null) {
            tvCurrentSpeed.setText("0");
            tvCurrentSpeed.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (mapplsMapView != null) {
            mapplsMapView.setNavigating(true);
            mapplsMapView.centerOnCurrentLocation();
        } else {
            centerMapOnCurrentLocation();
        }

        if (!currentActiveRoute.steps.isEmpty()) {
            MapplsApiClient.RouteStep firstStep = currentActiveRoute.steps.get(0);
            double initialManeuverDist = firstStep.distanceMeters;
            if (initialManeuverDist <= 15 && currentActiveRoute.steps.size() > 1) {
                currentRouteStepIndex = 1;
                firstStep = currentActiveRoute.steps.get(1);
                initialManeuverDist = firstStep.distanceMeters;
            }
            updateRouteStepDisplay(firstStep, initialManeuverDist, currentActiveRoute.totalDistanceMeters, currentActiveRoute.totalDurationSeconds);
            String firstInstr = (firstStep.instruction != null && !firstStep.instruction.isEmpty())
                    ? firstStep.instruction : firstStep.street;
            speakVoiceGuidance("Starting route to " + pendingDestName + ". " + firstInstr);
        } else {
            speakVoiceGuidance("Starting route to " + pendingDestName);
        }
    }

    private void cancelRoutePreview() {
        pendingPreviewRoute = null;
        if (cardRoutePreview != null) {
            cardRoutePreview.animate()
                    .alpha(0f)
                    .translationY(30f)
                    .setDuration(190)
                    .withEndAction(() -> cardRoutePreview.setVisibility(View.GONE))
                    .start();
        }
        if (cardSpeedHud != null) cardSpeedHud.setVisibility(View.GONE);
        if (mapplsMapView != null) {
            mapplsMapView.clearRoute();
            mapplsMapView.centerOnCurrentLocation();
        } else {
            centerMapOnCurrentLocation();
        }
    }

    private void updateRouteStepDisplay(MapplsApiClient.RouteStep step, double maneuverDistMeters, double remDistMeters, double remDurSec) {
        runOnUiThread(() -> {
            if (cardTurnInstruction != null && cardTurnInstruction.getVisibility() != View.VISIBLE) {
                cardTurnInstruction.setVisibility(View.VISIBLE);
                cardTurnInstruction.setAlpha(0f);
                cardTurnInstruction.setTranslationY(-30f);
                cardTurnInstruction.animate().alpha(1f).translationY(0f).setDuration(260).setInterpolator(new DecelerateInterpolator(2.0f)).start();
            }
            if (cardBottomNav != null && cardBottomNav.getVisibility() != View.VISIBLE) {
                cardBottomNav.setVisibility(View.VISIBLE);
                cardBottomNav.setAlpha(0f);
                cardBottomNav.setTranslationY(30f);
                cardBottomNav.animate().alpha(1f).translationY(0f).setDuration(260).setInterpolator(new DecelerateInterpolator(2.0f)).start();
            }
            if (cardSpeedHud != null && cardSpeedHud.getVisibility() != View.VISIBLE) {
                cardSpeedHud.setVisibility(View.VISIBLE);
                cardSpeedHud.setAlpha(0f);
                cardSpeedHud.setTranslationX(-35f);
                cardSpeedHud.animate().alpha(1f).translationX(0f).setDuration(280).setInterpolator(new OvershootInterpolator(1.4f)).start();
            }

            String desc = (step.instruction != null && !step.instruction.isEmpty())
                    ? step.instruction : step.street;
            if (desc == null || desc.isEmpty()) {
                desc = "Continue straight";
            }
            if (tvTurnDesc != null) {
                tvTurnDesc.setText(desc);
            }
            if (tvTurnDist != null) {
                if (maneuverDistMeters < 1000) {
                    tvTurnDist.setText(Math.max(10, (int) Math.round(maneuverDistMeters)) + " m");
                } else {
                    tvTurnDist.setText(String.format(Locale.getDefault(), "%.1f km", maneuverDistMeters / 1000.0));
                }
            }

            if (ivTurnArrow != null) {
                int iconRes = R.drawable.ic_straight_nav;
                String lower = desc.toLowerCase(Locale.ROOT);
                if (step.maneuverID == 8 || lower.contains("arrive") || lower.contains("destination")) {
                    iconRes = R.drawable.ic_nav_puck;
                } else if (lower.contains("u-turn") || lower.contains("uturn") || step.maneuverID == 4) {
                    iconRes = R.drawable.ic_uturn_nav;
                } else if (lower.contains("left") || step.maneuverID == 19 || step.maneuverID == 20 || step.maneuverID == 15) {
                    iconRes = R.drawable.ic_turn_left_nav;
                } else if (lower.contains("right") || step.maneuverID == 2 || step.maneuverID == 3 || step.maneuverID == 1) {
                    iconRes = R.drawable.ic_turn_right_nav;
                } else if (lower.contains("straight") || lower.contains("continue") || step.maneuverID == 0 || step.maneuverID == 7) {
                    iconRes = R.drawable.ic_straight_nav;
                }
                ivTurnArrow.setImageResource(iconRes);
                ivTurnArrow.setColorFilter(currentThemePalette != null ? currentThemePalette.accentPrimary : Color.parseColor("#38BDF8"));
                ivTurnArrow.setRotationY(90f);
                ivTurnArrow.animate().rotationY(0f).setDuration(280).setInterpolator(new OvershootInterpolator(1.4f)).start();
            }

            String nextTurnDesc = "";
            if (layoutNextStepPreview != null && tvNextStepDesc != null) {
                if (currentActiveRoute != null && currentRouteStepIndex + 1 < currentActiveRoute.steps.size()) {
                    MapplsApiClient.RouteStep nextStep = currentActiveRoute.steps.get(currentRouteStepIndex + 1);
                    String nextDist = nextStep.distanceMeters < 1000
                            ? (int) Math.round(nextStep.distanceMeters) + " m"
                            : String.format(Locale.getDefault(), "%.1f km", nextStep.distanceMeters / 1000.0);
                    String nextDesc = (nextStep.instruction != null && !nextStep.instruction.isEmpty())
                            ? nextStep.instruction : nextStep.street;
                    String arrowGlyph = "↱";
                    if (nextStep.maneuverID == 19 || nextStep.maneuverID == 20 || nextStep.maneuverID == 15) {
                        arrowGlyph = "↰";
                    } else if (nextStep.maneuverID == 0 || nextStep.maneuverID == 7) {
                        arrowGlyph = "↑";
                    } else if (nextStep.maneuverID == 8) {
                        arrowGlyph = "◉";
                    }
                    nextTurnDesc = nextDesc;
                    tvNextStepDesc.setText("Then " + nextDist + " " + arrowGlyph + " • " + nextDesc);
                    layoutNextStepPreview.setVisibility(View.VISIBLE);
                } else {
                    layoutNextStepPreview.setVisibility(View.GONE);
                }
            }

            if (tvNavEta != null) {
                int totalMin = (int) Math.round(remDurSec / 60.0);
                if (totalMin >= 60) {
                    int hrs = totalMin / 60;
                    int mins = totalMin % 60;
                    tvNavEta.setText(hrs + " hr " + mins + " min");
                } else {
                    tvNavEta.setText(totalMin + " min");
                }
            }
            if (tvNavSub != null) {
                double km = remDistMeters / 1000.0;
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, (int) remDurSec);
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                tvNavSub.setText(String.format(Locale.getDefault(), "%.1f km • %s", km, sdf.format(cal.getTime())));
            }
        });
    }

    private void endActiveNavigation() {
        currentActiveRoute = null;
        pendingPreviewRoute = null;
        currentRouteStepIndex = 0;
        currentSpeedKmh = 0;
        if (cardTurnInstruction != null) {
            cardTurnInstruction.animate()
                    .alpha(0f)
                    .translationY(-30f)
                    .setDuration(200)
                    .withEndAction(() -> cardTurnInstruction.setVisibility(View.GONE))
                    .start();
        }
        if (cardBottomNav != null) {
            cardBottomNav.animate()
                    .alpha(0f)
                    .translationY(30f)
                    .setDuration(200)
                    .withEndAction(() -> cardBottomNav.setVisibility(View.GONE))
                    .start();
        }
        if (cardRoutePreview != null) cardRoutePreview.setVisibility(View.GONE);
        if (cardSpeedHud != null) {
            cardSpeedHud.animate()
                    .alpha(0f)
                    .translationX(-35f)
                    .setDuration(200)
                    .withEndAction(() -> cardSpeedHud.setVisibility(View.GONE))
                    .start();
        }
        if (tvCurrentSpeed != null) {
            tvCurrentSpeed.setText("0");
            tvCurrentSpeed.setTextColor(Color.parseColor("#FFFFFF"));
        }
        if (mapplsMapView != null) {
            mapplsMapView.setNavigating(false);
            mapplsMapView.clearRoute();
            mapplsMapView.centerOnCurrentLocation();
        } else {
            centerMapOnCurrentLocation();
        }
        speakVoiceGuidance("Navigation ended");
    }

    private static List<double[]> decodePolyline(String encoded, boolean isPolyline6) {
        List<double[]> poly = new ArrayList<>();
        if (encoded == null || encoded.isEmpty()) return poly;
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;
        double precision = isPolyline6 ? 1e6 : 1e5;

        try {
            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                poly.add(new double[]{lng / precision, lat / precision});
            }
        } catch (Exception ignored) {}
        return poly;
    }

    @Override
    protected void onResume() {
        super.onResume();
        applyImmersiveFullscreen();
        initGpsTracking();
        clockHandler.post(clockRunnable);

        try {
            NotificationListenerService.requestRebind(new ComponentName(this, PulsarNotificationService.class));
        } catch (Exception ignored) {}

        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.registerObserver(mediaObserver);
            msl.syncMetadata();
        } else {
            PulsarForegroundService svc = PulsarForegroundService.getInstance();
            if (svc != null && svc.getMediaListener() != null) {
                svc.getMediaListener().registerObserver(mediaObserver);
                svc.getMediaListener().syncMetadata();
            }
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(MediaStateListener.ACTION_MEDIA_UPDATE);
        filter.addAction(PhoneStateMonitor.ACTION_TELEMETRY_UPDATE);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(systemUpdatesReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            registerReceiver(systemUpdatesReceiver, filter);
        }

        if (!bleManager.isConnected()) {
            bleManager.startScanOrConnect();
        }
        handleIntent(getIntent());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.unregisterObserver(mediaObserver);
        }
        clockHandler.removeCallbacks(clockRunnable);
        try {
            unregisterReceiver(systemUpdatesReceiver);
        } catch (Exception ignored) {}
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(gpsLocationListener);
            } catch (Exception ignored) {}
        }
    }

    private void initMaterialYouTheme() {
        currentThemePalette = MaterialYouTheme.getPalette(this);
        applyThemePalette(currentThemePalette);
        MaterialYouTheme.registerWallpaperListener(this, palette -> {
            runOnUiThread(() -> applyThemePalette(palette));
        });
    }

    private void applyThemePalette(MaterialYouTheme.Palette palette) {
        if (palette == null) return;
        this.currentThemePalette = palette;
        int density = (int) getResources().getDisplayMetrics().density;

        // 1. Interactive Wavy Media Scrubber
        if (pbMediaTrack instanceof WavySeekBar) {
            ((WavySeekBar) pbMediaTrack).setAccentColor(palette.accentPrimary);
        }

        // 2. Play/Pause and Media Buttons Dynamic Material You styling
        if (btnMediaPlayPause != null) {
            GradientDrawable playBg = new GradientDrawable();
            playBg.setShape(GradientDrawable.OVAL);
            playBg.setColor(0xFF0F1522);
            playBg.setStroke((int) (2.0f * density), palette.accentPrimary);
            btnMediaPlayPause.setBackground(playBg);
            btnMediaPlayPause.setColorFilter(palette.accentPrimary);
        }
        if (btnPillPlayPause != null) {
            btnPillPlayPause.setColorFilter(palette.accentPrimary);
        }
        if (btnMediaNext != null) {
            btnMediaNext.setColorFilter(palette.accentPrimary);
        }
        if (btnMediaPrev != null) {
            btnMediaPrev.setColorFilter(palette.accentPrimary);
        }
        if (btnPillNext != null) {
            btnPillNext.setColorFilter(palette.accentPrimary);
        }
        if (tvMediaSource != null) {
            tvMediaSource.setTextColor(palette.accentPrimary);
        }

        // Left Media Panel Container & Art Stage
        if (layoutLeftPanel != null) {
            GradientDrawable mediaBg = new GradientDrawable();
            mediaBg.setShape(GradientDrawable.RECTANGLE);
            mediaBg.setCornerRadius(22 * density);
            mediaBg.setColor(0xF807090F);
            mediaBg.setStroke((int) (1.2f * density), palette.accentBorder);
            layoutLeftPanel.setBackground(mediaBg);
        }
        View cardMediaArtStage = findViewById(R.id.cardMediaArtStage);
        if (cardMediaArtStage != null) {
            GradientDrawable stageBg = new GradientDrawable();
            stageBg.setShape(GradientDrawable.RECTANGLE);
            stageBg.setCornerRadius(16 * density);
            stageBg.setColor(0xF5080B12);
            stageBg.setStroke((int) (1.2f * density), palette.accentBorder);
            cardMediaArtStage.setBackground(stageBg);
        }
        View layoutSplitHandle = findViewById(R.id.layoutSplitHandle);
        if (layoutSplitHandle != null) {
            GradientDrawable handleBg = new GradientDrawable();
            handleBg.setShape(GradientDrawable.RECTANGLE);
            handleBg.setCornerRadius(10 * density);
            handleBg.setColor(0xF50B0F18);
            handleBg.setStroke((int) (1.2f * density), palette.accentBorder);
            layoutSplitHandle.setBackground(handleBg);
        }
        ImageView ivSplitHandleChevron = findViewById(R.id.ivSplitHandleChevron);
        if (ivSplitHandleChevron != null) {
            ivSplitHandleChevron.setColorFilter(palette.accentPrimary);
        }
        View viewMediaPulseDot = findViewById(R.id.viewMediaPulseDot);
        if (viewMediaPulseDot != null) {
            viewMediaPulseDot.setBackgroundTintList(android.content.res.ColorStateList.valueOf(palette.accentPrimary));
        }

        // Right Map Container & MapView (Matching Rounded Cockpit Card with Neon Accent Border)
        if (layoutMapContainer != null) {
            GradientDrawable mapBg = new GradientDrawable();
            mapBg.setShape(GradientDrawable.RECTANGLE);
            mapBg.setCornerRadius(22 * density);
            mapBg.setColor(0xF807090F);
            mapBg.setStroke((int) (1.2f * density), palette.accentBorder);
            layoutMapContainer.setBackground(mapBg);
            layoutMapContainer.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 22 * density);
                }
            });
            layoutMapContainer.setClipToOutline(true);
        }
        if (mapplsMapView != null) {
            mapplsMapView.setCornerRadius(22f);
        }

        // 3. Mappls Map route polyline, vehicle puck arrow and radar glow
        if (mapplsMapView != null) {
            mapplsMapView.setThemeAccent(palette.accentPrimary);
        }

        // 4. Navigation Maneuver HUD Card
        if (cardTurnInstruction != null) {
            GradientDrawable turnBg = new GradientDrawable();
            turnBg.setShape(GradientDrawable.RECTANGLE);
            turnBg.setCornerRadius(18 * density);
            turnBg.setColor(0xF207080B);
            turnBg.setStroke((int) (1.2f * density), palette.accentBorder);
            cardTurnInstruction.setBackground(turnBg);
        }
        if (ivTurnArrow != null) {
            ivTurnArrow.setColorFilter(palette.accentPrimary);
        }
        if (tvNextStepDesc != null) {
            tvNextStepDesc.setTextColor(palette.accentPrimary);
        }

        // 5. Speed HUD Card & Unit
        if (cardSpeedHud != null) {
            GradientDrawable speedBg = new GradientDrawable();
            speedBg.setShape(GradientDrawable.RECTANGLE);
            speedBg.setCornerRadius(18 * density);
            speedBg.setColor(0xF207080B);
            speedBg.setStroke((int) (1.2f * density), palette.accentBorder);
            cardSpeedHud.setBackground(speedBg);
        }
        if (tvSpeedUnit != null) {
            tvSpeedUnit.setTextColor(palette.accentPrimary);
        }

        // 6. Navigation ETA & Bottom Card
        if (cardBottomNav != null) {
            GradientDrawable botBg = new GradientDrawable();
            botBg.setShape(GradientDrawable.RECTANGLE);
            botBg.setCornerRadius(18 * density);
            botBg.setColor(0xF207080B);
            botBg.setStroke((int) (1.2f * density), palette.accentBorder);
            cardBottomNav.setBackground(botBg);
        }
        if (tvNavEta != null) {
            tvNavEta.setTextColor(palette.accentPrimary);
        }

        // 7. Route Preview Card & Start Button
        if (cardRoutePreview != null) {
            GradientDrawable prevBg = new GradientDrawable();
            prevBg.setShape(GradientDrawable.RECTANGLE);
            prevBg.setCornerRadius(20 * density);
            prevBg.setColor(0xF507080B);
            prevBg.setStroke((int) (1.4f * density), palette.accentBorder);
            cardRoutePreview.setBackground(prevBg);
        }
        if (btnStartNavNow != null) {
            GradientDrawable startBg = new GradientDrawable();
            startBg.setShape(GradientDrawable.RECTANGLE);
            startBg.setCornerRadius(16 * density);
            startBg.setColor(palette.accentPrimary);
            btnStartNavNow.setBackground(startBg);
            btnStartNavNow.setTextColor(0xFF000000);
        }
        if (tvPreviewDuration != null) {
            tvPreviewDuration.setTextColor(palette.accentPrimary);
        }
        ImageView ivPrevSearch = findViewById(R.id.ivPreviewSearchIcon);
        if (ivPrevSearch != null) {
            ivPrevSearch.setColorFilter(palette.accentPrimary);
        }

        // 8. Floating Music Pill
        if (layoutFullscreenMusicPill != null) {
            GradientDrawable pillBg = new GradientDrawable();
            pillBg.setShape(GradientDrawable.RECTANGLE);
            pillBg.setCornerRadius(22 * density);
            pillBg.setColor(0xF50A0B0E);
            pillBg.setStroke((int) (1.4f * density), palette.accentBorder);
            layoutFullscreenMusicPill.setBackground(pillBg);
        }
        if (tvPillArtist != null) {
            tvPillArtist.setTextColor(palette.accentPrimary);
        }

        // 9. Tactical Floating Action Stack Buttons
        if (btnCurrentLocation != null) {
            btnCurrentLocation.setColorFilter(palette.accentPrimary);
        }
        if (btnMapSearch != null) {
            btnMapSearch.setColorFilter(palette.accentPrimary);
        }
        if (btnVoiceNav != null) {
            btnVoiceNav.setColorFilter(palette.accentPrimary);
        }
        if (btnOpenDrawer != null) {
            btnOpenDrawer.setColorFilter(palette.accentPrimary);
        }
        if (btnSearchCancel != null) {
            btnSearchCancel.setTextColor(palette.accentPrimary);
        }

        // 10. Dynamic Re-center Pill styling
        if (layoutRecenterPill != null) {
            GradientDrawable pillBg = new GradientDrawable();
            pillBg.setShape(GradientDrawable.RECTANGLE);
            pillBg.setCornerRadius(19 * density);
            pillBg.setColor(0xF208090C);
            pillBg.setStroke((int) (1.5f * density), palette.accentPrimary);
            layoutRecenterPill.setBackground(pillBg);
        }
        TextView tvRecenter = findViewById(R.id.tvRecenterMap);
        if (tvRecenter != null) {
            tvRecenter.setTextColor(palette.accentPrimary);
        }
        ImageView ivRecenter = findViewById(R.id.ivRecenterIcon);
        if (ivRecenter != null) {
            ivRecenter.setColorFilter(palette.accentPrimary);
        }

        // 11. Right Navigation Drawer Panel
        if (drawerPanel != null) {
            GradientDrawable drawerBg = new GradientDrawable();
            drawerBg.setShape(GradientDrawable.RECTANGLE);
            drawerBg.setCornerRadii(new float[]{24 * density, 24 * density, 0, 0, 0, 0, 24 * density, 24 * density});
            drawerBg.setColor(0xF8050608);
            drawerBg.setStroke((int) (1.2f * density), palette.accentBorder);
            drawerPanel.setBackground(drawerBg);
        }
        if (btnDrawerClose != null) {
            btnDrawerClose.setColorFilter(palette.accentPrimary);
        }
        if (cardBikeStage != null) {
            GradientDrawable stageBg = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[]{0xFF0F172A, 0xFF0B1120, 0xFF060A13}
            );
            stageBg.setCornerRadius(18 * density);
            stageBg.setStroke((int) (1.2f * density), palette.accentBorder);
            cardBikeStage.setBackground(stageBg);
        }
        if (cardBikeConnection != null) {
            GradientDrawable cardBg = new GradientDrawable();
            cardBg.setShape(GradientDrawable.RECTANGLE);
            cardBg.setCornerRadius(14 * density);
            cardBg.setColor(0xEE0B0E14);
            cardBg.setStroke((int) (1.2f * density), palette.accentBorder);
            cardBikeConnection.setBackground(cardBg);
        }
        if (btnDrawerBleConnect != null && !isBleConnecting && (bleManager == null || !bleManager.isConnected())) {
            GradientDrawable btnBg = new GradientDrawable();
            btnBg.setShape(GradientDrawable.RECTANGLE);
            btnBg.setCornerRadius(10 * density);
            btnBg.setColor(palette.accentPrimary);
            btnDrawerBleConnect.setBackground(btnBg);
        }

        // 12. Search Overlay Box & Input Field
        if (cardSearchBox != null) {
            GradientDrawable searchCardBg = new GradientDrawable();
            searchCardBg.setShape(GradientDrawable.RECTANGLE);
            searchCardBg.setCornerRadius(20 * density);
            searchCardBg.setColor(0xF8050608);
            searchCardBg.setStroke((int) (1.4f * density), palette.accentBorder);
            cardSearchBox.setBackground(searchCardBg);
        }
        View searchBar = findViewById(R.id.layoutSearchInputBar);
        if (searchBar != null) {
            GradientDrawable inputBg = new GradientDrawable();
            inputBg.setShape(GradientDrawable.RECTANGLE);
            inputBg.setCornerRadius(12 * density);
            inputBg.setColor(0xFF0F1117);
            inputBg.setStroke((int) (1.2f * density), palette.accentPrimary);
            searchBar.setBackground(inputBg);
        }
        ImageView ivSearchInput = findViewById(R.id.ivSearchInputIcon);
        if (ivSearchInput != null) {
            ivSearchInput.setColorFilter(palette.accentPrimary);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MaterialYouTheme.unregisterWallpaperListener(this);
        if (pulseAnimator != null) {
            pulseAnimator.cancel();
        }
        if (bleManager != null) {
            bleManager.removeListener(this);
        }
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(gpsLocationListener);
            } catch (Exception ignored) {}
        }
        if (tts != null) {
            try {
                tts.stop();
                tts.shutdown();
            } catch (Exception ignored) {}
        }
    }
}
