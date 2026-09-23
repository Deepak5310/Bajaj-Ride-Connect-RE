package com.bajaj.rideconnect.re;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.app.Dialog;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    // Top Status Bar
    private TextView tvTopBikeName;
    private View viewTopBtStatusDot;
    private TextView tvTopBtStatus;
    private TextView tvTopSignal;
    private TextView tvTopBattery;
    private TextView tvTopClock;
    private ImageView btnTopNotifications;
    private ImageView btnOpenDrawer;

    // Main Split Layout
    private LinearLayout layoutLeftPanel;
    private LinearLayout viewSplitDivider;
    private View layoutMapContainer;
    private boolean isMapFullscreen = false;

    // Left Panel Tabs
    private LinearLayout tabMedia;
    private LinearLayout tabCalls;
    private LinearLayout tabSms;
    private LinearLayout tabBike;
    private ImageView ivTabMediaIcon;
    private TextView tvTabMediaLabel;
    private ImageView ivTabCallsIcon;
    private TextView tvTabCallsLabel;
    private ImageView ivTabSmsIcon;
    private TextView tvTabSmsLabel;
    private ImageView ivTabBikeIcon;
    private TextView tvTabBikeLabel;

    // Tab Views
    private View viewTabMedia;
    private View viewTabCalls;
    private View viewTabSms;
    private View viewTabBike;

    // Media Controls & Info (Left Panel)
    private ImageView ivAlbumArt;
    private TextView tvMediaTrack;
    private TextView tvMediaArtist;
    private TextView tvMediaSource;
    private ProgressBar pbMediaTrack;
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

    // Calls Tab Views
    private TextView tvCallerName;
    private TextView tvCallerNumber;
    private Button btnCallReject;
    private Button btnCallAccept;

    // SMS Tab Views
    private TextView tvSmsSender;
    private TextView tvSmsPreview;

    // Bike Tab Views
    private TextView tvBikeTabName;
    private TextView tvBikeTabRange;
    private TextView tvBikeTabStatus;

    // Navigation Map & HUD
    private View cardTurnInstruction;
    private ImageView ivTurnArrow;
    private TextView tvTurnDist;
    private TextView tvTurnDesc;
    private View cardSpeedHud;
    private TextView tvCurrentSpeed;
    private TextView tvSpeedLimit;
    private ImageView btnCompass;
    private ImageView btnVoiceNav;
    private ImageView btnLayers;
    private ImageView btnZoomIn;
    private ImageView btnZoomOut;
    private TextView tvNavEta;
    private TextView tvNavSub;
    private Button btnNavEnd;

    // Mappls Engine & Cockpit Controls
    private MapplsMapView mapplsMapView;
    private ImageView btnMapSearch;
    private ImageView btnCurrentLocation;
    private LocationManager locationManager;
    private double currentRiderLat = 28.6139;
    private double currentRiderLng = 77.2090;
    private float currentRiderBearing = 0f;
    private MapplsApiClient.RouteResult currentActiveRoute = null;
    private int currentRouteStepIndex = 0;

    // Search Destination Overlay Views
    private View layoutSearchOverlay;
    private View cardSearchBox;
    private EditText etSearchQuery;
    private ImageView btnSearchClear;
    private ProgressBar pbSearchProgress;
    private ListView lvSearchResults;
    private TextView btnSearchCancel;
    private final List<MapplsApiClient.PlaceResult> searchPlaceList = new ArrayList<>();
    private ArrayAdapter<MapplsApiClient.PlaceResult> searchAdapter;
    private final Handler searchDebounceHandler = new Handler(Looper.getMainLooper());

    // Right Slide-out Drawer
    private View drawerBackdrop;
    private View drawerPanel;
    private ImageView btnDrawerClose;
    private ImageView ivDrawerBikeImage;
    private TextView tvDrawerBikeName;
    private TextView tvDrawerBtStatus;
    private TextView tvDrawerRange;
    private View itemRideStats;
    private View itemService;
    private View itemBikeInfo;
    private View itemProfile;
    private View itemSavedPlaces;
    private View itemOfflineMaps;
    private View itemSettings;
    private View itemHelp;
    private View itemAbout;
    private View btnDrawerDisconnect;

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
            if (tvTopClock != null) {
                tvTopClock.setText(clockFormat.format(new Date()));
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

        initViews();
        setupListeners();
        setupMicroAnimations();
        initLiveSystemSensors();

        bleManager = PulsarBleManager.getInstance(this);
        bleManager.addListener(this);

        PulsarForegroundService.start(this);

        requestAppPermissions();
    }

    private void setupEdgeToEdge() {
        Window window = getWindow();
        if (window == null) return;
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);

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
            if (decor == null) return;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowInsetsController controller = decor.getWindowInsetsController();
                if (controller != null) {
                    controller.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                    controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                }
            }

            decor.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
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
        // Top Bar
        tvTopBikeName = findViewById(R.id.tvTopBikeName);
        viewTopBtStatusDot = findViewById(R.id.viewTopBtStatusDot);
        tvTopBtStatus = findViewById(R.id.tvTopBtStatus);
        tvTopSignal = findViewById(R.id.tvTopSignal);
        tvTopBattery = findViewById(R.id.tvTopBattery);
        tvTopClock = findViewById(R.id.tvTopClock);
        btnTopNotifications = findViewById(R.id.btnTopNotifications);
        btnOpenDrawer = findViewById(R.id.btnOpenDrawer);

        // Layout Containers
        layoutLeftPanel = findViewById(R.id.layoutLeftPanel);
        viewSplitDivider = findViewById(R.id.viewSplitDivider);
        layoutMapContainer = findViewById(R.id.layoutMapContainer);

        // Tabs
        tabMedia = findViewById(R.id.tabMedia);
        tabCalls = findViewById(R.id.tabCalls);
        tabSms = findViewById(R.id.tabSms);
        tabBike = findViewById(R.id.tabBike);
        ivTabMediaIcon = findViewById(R.id.ivTabMediaIcon);
        tvTabMediaLabel = findViewById(R.id.tvTabMediaLabel);
        ivTabCallsIcon = findViewById(R.id.ivTabCallsIcon);
        tvTabCallsLabel = findViewById(R.id.tvTabCallsLabel);
        ivTabSmsIcon = findViewById(R.id.ivTabSmsIcon);
        tvTabSmsLabel = findViewById(R.id.tvTabSmsLabel);
        ivTabBikeIcon = findViewById(R.id.ivTabBikeIcon);
        tvTabBikeLabel = findViewById(R.id.tvTabBikeLabel);

        // Tab Views
        viewTabMedia = findViewById(R.id.viewTabMedia);
        viewTabCalls = findViewById(R.id.viewTabCalls);
        viewTabSms = findViewById(R.id.viewTabSms);
        viewTabBike = findViewById(R.id.viewTabBike);

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

        // Calls Tab
        tvCallerName = findViewById(R.id.tvCallerName);
        tvCallerNumber = findViewById(R.id.tvCallerNumber);
        btnCallReject = findViewById(R.id.btnCallReject);
        btnCallAccept = findViewById(R.id.btnCallAccept);

        // SMS Tab
        tvSmsSender = findViewById(R.id.tvSmsSender);
        tvSmsPreview = findViewById(R.id.tvSmsPreview);

        // Bike Tab
        tvBikeTabName = findViewById(R.id.tvBikeTabName);
        tvBikeTabRange = findViewById(R.id.tvBikeTabRange);
        tvBikeTabStatus = findViewById(R.id.tvBikeTabStatus);

        // Navigation HUD
        cardTurnInstruction = findViewById(R.id.cardTurnInstruction);
        ivTurnArrow = findViewById(R.id.ivTurnArrow);
        tvTurnDist = findViewById(R.id.tvTurnDist);
        tvTurnDesc = findViewById(R.id.tvTurnDesc);
        cardSpeedHud = findViewById(R.id.cardSpeedHud);
        tvCurrentSpeed = findViewById(R.id.tvCurrentSpeed);
        tvSpeedLimit = findViewById(R.id.tvSpeedLimit);
        btnCompass = findViewById(R.id.btnCompass);
        btnVoiceNav = findViewById(R.id.btnVoiceNav);
        btnLayers = findViewById(R.id.btnLayers);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);
        tvNavEta = findViewById(R.id.tvNavEta);
        tvNavSub = findViewById(R.id.tvNavSub);
        btnNavEnd = findViewById(R.id.btnNavEnd);

        mapplsMapView = findViewById(R.id.mapplsMapView);
        btnMapSearch = findViewById(R.id.btnMapSearch);
        btnCurrentLocation = findViewById(R.id.btnCurrentLocation);

        // Search Destination Overlay Views
        layoutSearchOverlay = findViewById(R.id.layoutSearchOverlay);
        cardSearchBox = findViewById(R.id.cardSearchBox);
        etSearchQuery = findViewById(R.id.etSearchQuery);
        btnSearchClear = findViewById(R.id.btnSearchClear);
        pbSearchProgress = findViewById(R.id.pbSearchProgress);
        lvSearchResults = findViewById(R.id.lvSearchResults);
        btnSearchCancel = findViewById(R.id.btnSearchCancel);

        // Drawer
        drawerBackdrop = findViewById(R.id.drawerBackdrop);
        drawerPanel = findViewById(R.id.drawerPanel);
        btnDrawerClose = findViewById(R.id.btnDrawerClose);
        ivDrawerBikeImage = findViewById(R.id.ivDrawerBikeImage);
        tvDrawerBikeName = findViewById(R.id.tvDrawerBikeName);
        tvDrawerBtStatus = findViewById(R.id.tvDrawerBtStatus);
        tvDrawerRange = findViewById(R.id.tvDrawerRange);
        itemRideStats = findViewById(R.id.itemRideStats);
        itemService = findViewById(R.id.itemService);
        itemBikeInfo = findViewById(R.id.itemBikeInfo);
        itemProfile = findViewById(R.id.itemProfile);
        itemSavedPlaces = findViewById(R.id.itemSavedPlaces);
        itemOfflineMaps = findViewById(R.id.itemOfflineMaps);
        itemSettings = findViewById(R.id.itemSettings);
        itemHelp = findViewById(R.id.itemHelp);
        itemAbout = findViewById(R.id.itemAbout);
        btnDrawerDisconnect = findViewById(R.id.btnDrawerDisconnect);
    }

    private void setupListeners() {
        // Quick Tabs Switcher
        tabMedia.setOnClickListener(v -> switchTab(0));
        tabCalls.setOnClickListener(v -> switchTab(1));
        tabSms.setOnClickListener(v -> switchTab(2));
        tabBike.setOnClickListener(v -> switchTab(3));

        // Media Controls (Left Panel)
        btnMediaPlayPause.setOnClickListener(v -> toggleMediaPlayback());
        btnMediaPrev.setOnClickListener(v -> skipMediaPrevious());
        btnMediaNext.setOnClickListener(v -> skipMediaNext());

        // Fullscreen Floating Music Pill Controls
        btnPillPlayPause.setOnClickListener(v -> toggleMediaPlayback());
        btnPillNext.setOnClickListener(v -> skipMediaNext());
        layoutFullscreenMusicPill.setOnClickListener(v -> setMapFullscreen(false));

        // Divider Resize / Collapse Interaction
        viewSplitDivider.setOnClickListener(v -> setMapFullscreen(!isMapFullscreen));

        // Right Navigation Drawer
        btnOpenDrawer.setOnClickListener(v -> openDrawer());
        btnDrawerClose.setOnClickListener(v -> closeDrawer());
        drawerBackdrop.setOnClickListener(v -> closeDrawer());

        // Drawer Actions
        itemRideStats.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Ride Stats: 1,420 km total • 42.5 km/l avg", Toast.LENGTH_SHORT).show();
        });
        itemService.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Next Service: Due in 2,150 km or 45 days", Toast.LENGTH_SHORT).show();
        });
        itemBikeInfo.setOnClickListener(v -> {
            closeDrawer();
            switchTab(3);
        });
        itemProfile.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Rider Profile: Deepak Jangir (Owner)", Toast.LENGTH_SHORT).show();
        });
        itemSavedPlaces.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Saved Places: Home, Work, Highway Cafe", Toast.LENGTH_SHORT).show();
        });
        itemOfflineMaps.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Offline Maps: Region Rajasthan (Downloaded)", Toast.LENGTH_SHORT).show();
        });
        itemSettings.setOnClickListener(v -> {
            closeDrawer();
            openNotificationSettings();
        });
        itemHelp.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Bajaj Roadside Assistance: 1800-209-6060", Toast.LENGTH_LONG).show();
        });
        itemAbout.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "My Pulsar (Bajaj Ride Connect RE) v2.5.0\nUniversal BLE Cockpit", Toast.LENGTH_SHORT).show();
        });

        // Disconnect & Clean Exit Button
        btnDrawerDisconnect.setOnClickListener(v -> terminateAppSession());

        // Notification Bell
        btnTopNotifications.setOnClickListener(v -> openNotificationSettings());

        // Map HUD Controls
        if (btnCurrentLocation != null) {
            btnCurrentLocation.setOnClickListener(v -> centerMapOnCurrentLocation());
        }
        btnMapSearch.setOnClickListener(v -> showDestinationSearch());
        cardTurnInstruction.setOnClickListener(v -> showDestinationSearch());
        setupSearchOverlay();

        btnVoiceNav.setOnClickListener(v -> {
            isVoiceMuted = !isVoiceMuted;
            btnVoiceNav.setAlpha(isVoiceMuted ? 0.4f : 1.0f);
            Toast.makeText(this, isVoiceMuted ? "Voice Guidance Muted" : "Voice Guidance Active", Toast.LENGTH_SHORT).show();
        });

        btnLayers.setOnClickListener(v -> {
            isSatelliteLayer = !isSatelliteLayer;
            if (mapplsMapView != null) {
                mapplsMapView.setSatelliteMode(isSatelliteLayer);
            }
            Toast.makeText(this, isSatelliteLayer ? "Layer: Satellite/Hybrid" : "Layer: Minimal Dark Vector", Toast.LENGTH_SHORT).show();
        });

        btnZoomIn.setOnClickListener(v -> {
            if (mapplsMapView != null) mapplsMapView.zoomIn();
        });
        btnZoomOut.setOnClickListener(v -> {
            if (mapplsMapView != null) mapplsMapView.zoomOut();
        });

        btnNavEnd.setOnClickListener(v -> endActiveNavigation());

        // Top Status Quick Connect
        viewTopBtStatusDot.setOnClickListener(v -> toggleBleConnection());
        tvTopBtStatus.setOnClickListener(v -> toggleBleConnection());
    }

    private void toggleBleConnection() {
        if (bleManager.isConnected()) {
            bleManager.disconnect();
            Toast.makeText(this, "Disconnected from Bike", Toast.LENGTH_SHORT).show();
        } else {
            requestAppPermissions();
            bleManager.setAutoReconnect(true);
            bleManager.startScanOrConnect();
            setConnectingState();
        }
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

    private void sendDirectMediaKey(int keyCode) {
        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (am != null) {
            long now = SystemClock.uptimeMillis();
            am.dispatchMediaKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0));
            am.dispatchMediaKeyEvent(new KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0));
        }
    }

    private void switchTab(int tabIndex) {
        viewTabMedia.setVisibility(tabIndex == 0 ? View.VISIBLE : View.GONE);
        viewTabCalls.setVisibility(tabIndex == 1 ? View.VISIBLE : View.GONE);
        viewTabSms.setVisibility(tabIndex == 2 ? View.VISIBLE : View.GONE);
        viewTabBike.setVisibility(tabIndex == 3 ? View.VISIBLE : View.GONE);

        updateTabAppearance(tabMedia, ivTabMediaIcon, tvTabMediaLabel, tabIndex == 0);
        updateTabAppearance(tabCalls, ivTabCallsIcon, tvTabCallsLabel, tabIndex == 1);
        updateTabAppearance(tabSms, ivTabSmsIcon, tvTabSmsLabel, tabIndex == 2);
        updateTabAppearance(tabBike, ivTabBikeIcon, tvTabBikeLabel, tabIndex == 3);
    }

    private void updateTabAppearance(LinearLayout tab, ImageView icon, TextView label, boolean active) {
        tab.setBackgroundResource(active ? R.drawable.bg_tab_pill_active : R.drawable.bg_tab_pill_inactive);
        int color = active ? 0xFF38BDF8 : 0xFF64748B;
        label.setTextColor(color);
        icon.setColorFilter(color);
    }

    public void setMapFullscreen(boolean fullscreen) {
        isMapFullscreen = fullscreen;
        if (fullscreen) {
            layoutLeftPanel.animate().alpha(0f).translationX(-100f).setDuration(220)
                    .withEndAction(() -> {
                        layoutLeftPanel.setVisibility(View.GONE);
                        viewSplitDivider.setVisibility(View.GONE);
                    }).start();

            layoutFullscreenMusicPill.setVisibility(View.VISIBLE);
            layoutFullscreenMusicPill.setAlpha(0f);
            layoutFullscreenMusicPill.setTranslationY(60f);
            layoutFullscreenMusicPill.animate().alpha(1f).translationY(0f).setDuration(280).start();
        } else {
            layoutLeftPanel.setVisibility(View.VISIBLE);
            viewSplitDivider.setVisibility(View.VISIBLE);
            layoutLeftPanel.setTranslationX(-100f);
            layoutLeftPanel.animate().alpha(1f).translationX(0f).setDuration(250).start();

            layoutFullscreenMusicPill.animate().alpha(0f).translationY(60f).setDuration(180)
                    .withEndAction(() -> layoutFullscreenMusicPill.setVisibility(View.GONE)).start();
        }
    }

    private void openDrawer() {
        drawerBackdrop.setVisibility(View.VISIBLE);
        drawerBackdrop.setAlpha(0f);
        drawerBackdrop.animate().alpha(1f).setDuration(240).start();

        drawerPanel.setVisibility(View.VISIBLE);
        int width = drawerPanel.getWidth() > 0 ? drawerPanel.getWidth() : 800;
        drawerPanel.setTranslationX(width);
        drawerPanel.animate().translationX(0f).setDuration(260).start();
    }

    private void closeDrawer() {
        drawerBackdrop.animate().alpha(0f).setDuration(200)
                .withEndAction(() -> drawerBackdrop.setVisibility(View.GONE)).start();

        int width = drawerPanel.getWidth() > 0 ? drawerPanel.getWidth() : 800;
        drawerPanel.animate().translationX(width).setDuration(220)
                .withEndAction(() -> drawerPanel.setVisibility(View.GONE)).start();
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
        if (percent < 0) {
            tvTopBattery.setText("🔋 --%");
            return;
        }
        String icon = charging ? "⚡ " : (percent <= 20 ? "🪫 " : "🔋 ");
        tvTopBattery.setText(icon + percent + "%");
        if (percent <= 20 && !charging) {
            tvTopBattery.setTextColor(0xFFEF4444);
        } else if (charging) {
            tvTopBattery.setTextColor(0xFFF59E0B);
        } else {
            tvTopBattery.setTextColor(0xFF10B981);
        }
    }

    private void updateSignalDisplay(int bars) {
        if (bars < 0) {
            tvTopSignal.setText("📶 --");
            return;
        }
        String graph = bars >= 4 ? "●●●●" : bars == 3 ? "●●●○" : bars == 2 ? "●●○○" : bars == 1 ? "●○○○" : "○○○○";
        tvTopSignal.setText("📶 " + graph);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupMicroAnimations() {
        pulseAnimator = ObjectAnimator.ofFloat(viewTopBtStatusDot, "alpha", 0.3f, 1.0f);
        pulseAnimator.setDuration(900);
        pulseAnimator.setRepeatMode(ValueAnimator.REVERSE);
        pulseAnimator.setRepeatCount(ValueAnimator.INFINITE);
        pulseAnimator.start();

        View.OnTouchListener tactileTouch = (v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(80).start();
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80).start();
            }
            return false;
        };

        View[] tactileViews = new View[]{
                btnMediaPlayPause, btnMediaPrev, btnMediaNext, btnPillPlayPause, btnPillNext,
                btnOpenDrawer, btnDrawerClose, btnNavEnd, btnCompass, btnCurrentLocation, btnVoiceNav, btnLayers,
                btnZoomIn, btnZoomOut, btnDrawerDisconnect, btnMapSearch
        };
        for (View view : tactileViews) {
            if (view != null) view.setOnTouchListener(tactileTouch);
        }
    }

    private void updateCockpitNavigation(String maneuver, String desc, double stepDist, double totalDist,
                                        int etaHour, int etaMin, boolean isPm, String street) {
        runOnUiThread(() -> {
            if (desc != null && !desc.isEmpty()) {
                tvTurnDesc.setText(desc);
            }
            tvTurnDist.setText(PulsarProtocol.formatDistance(stepDist));
            tvNavEta.setText(PulsarProtocol.formatEta(etaHour, etaMin, isPm));
            tvNavSub.setText(PulsarProtocol.formatDistance(totalDist) + " remaining • On Route");

            if ("DESTINATION".equalsIgnoreCase(maneuver)) {
                ivTurnArrow.setImageResource(R.drawable.ic_nav_puck);
            } else {
                ivTurnArrow.setImageResource(R.drawable.ic_turn_right_nav);
            }
        });
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
                pbMediaTrack.setProgress(0);
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

                if (state == 2) { // 2 = Playing
                    btnMediaPlayPause.setImageResource(R.drawable.ic_media_pause);
                    btnPillPlayPause.setImageResource(R.drawable.ic_media_pause);
                } else {
                    btnMediaPlayPause.setImageResource(R.drawable.ic_media_play);
                    btnPillPlayPause.setImageResource(R.drawable.ic_media_play);
                }

                if (durSec > 0) {
                    int percent = (int) (((float) posSec / durSec) * 100);
                    pbMediaTrack.setProgress(Math.min(100, Math.max(0, percent)));
                    tvMediaElapsed.setText(formatTime(posSec));
                    tvMediaDuration.setText(formatTime(durSec));
                } else if (posSec > 0) {
                    tvMediaElapsed.setText(formatTime(posSec));
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

    private void setConnectingState() {
        tvTopBtStatus.setText("Connecting...");
        tvTopBtStatus.setTextColor(0xFFF59E0B);
        tvDrawerBtStatus.setText("Connecting...");
        tvDrawerBtStatus.setTextColor(0xFFF59E0B);
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        runOnUiThread(() -> {
            if (connected) {
                String displayName = (deviceName != null && !deviceName.isEmpty()) ? deviceName : "BAJAJ PULSAR";
                tvTopBikeName.setText(displayName.toUpperCase());
                tvTopBtStatus.setText("Connected");
                tvTopBtStatus.setTextColor(0xFF10B981);

                tvDrawerBikeName.setText(displayName);
                tvDrawerBtStatus.setText("Connected (GATT OK)");
                tvDrawerBtStatus.setTextColor(0xFF10B981);

                tvBikeTabName.setText(displayName);
                tvBikeTabStatus.setText("Cluster: Connected (" + (deviceAddress != null ? deviceAddress : "OK") + ")");
            } else {
                tvTopBikeName.setText("BAJAJ PULSAR");
                tvTopBtStatus.setText("Disconnected");
                tvTopBtStatus.setTextColor(0xFFEF4444);

                tvDrawerBikeName.setText("Bajaj Pulsar");
                tvDrawerBtStatus.setText("Disconnected");
                tvDrawerBtStatus.setTextColor(0xFFEF4444);

                tvBikeTabStatus.setText("Cluster: Disconnected (Searching...)");
            }
        });
    }

    private void terminateAppSession() {
        Toast.makeText(this, "Exiting My Pulsar and closing all services...", Toast.LENGTH_SHORT).show();

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
        runOnUiThread(() -> {
            if (event.musicNext) Toast.makeText(this, "Handlebar: Track Next", Toast.LENGTH_SHORT).show();
            else if (event.musicPrev) Toast.makeText(this, "Handlebar: Track Prev", Toast.LENGTH_SHORT).show();
            else if (event.musicPlay) Toast.makeText(this, "Handlebar: Music Play", Toast.LENGTH_SHORT).show();
            else if (event.musicPause) Toast.makeText(this, "Handlebar: Music Pause", Toast.LENGTH_SHORT).show();
            else if (event.callAccept) Toast.makeText(this, "Handlebar: Answer Call", Toast.LENGTH_SHORT).show();
            else if (event.callReject) Toast.makeText(this, "Handlebar: End Call", Toast.LENGTH_SHORT).show();
        });
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
            if (location.hasBearing()) {
                currentRiderBearing = location.getBearing();
            }
            if (location.hasSpeed()) {
                int kmh = Math.round(location.getSpeed() * 3.6f);
                if (tvCurrentSpeed != null) {
                    tvCurrentSpeed.setText(String.valueOf(kmh));
                }
            }
            if (mapplsMapView != null) {
                mapplsMapView.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing);
            }
            checkRouteProgress(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override
        public void onProviderEnabled(String provider) {}
        @Override
        public void onProviderDisabled(String provider) {}
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
                }
            }
        } catch (Exception ignored) {}

        if (mapplsMapView != null) {
            mapplsMapView.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing);
            mapplsMapView.centerOnLocation(currentRiderLat, currentRiderLng);
            Toast.makeText(this, String.format(Locale.getDefault(), "Location: %.4f, %.4f", currentRiderLat, currentRiderLng), Toast.LENGTH_SHORT).show();
        }
    }

    private void checkRouteProgress(Location riderLocation) {
        if (currentActiveRoute == null || currentActiveRoute.steps.isEmpty()) return;

        if (currentRouteStepIndex >= currentActiveRoute.steps.size()) {
            endActiveNavigation();
            return;
        }

        MapplsApiClient.RouteStep step = currentActiveRoute.steps.get(currentRouteStepIndex);
        float[] results = new float[1];
        Location.distanceBetween(riderLocation.getLatitude(), riderLocation.getLongitude(),
                step.lat, step.lng, results);
        float distToStep = results[0];

        // Advance to next maneuver if within 30m of waypoint
        if (distToStep < 30f && currentRouteStepIndex < currentActiveRoute.steps.size() - 1) {
            currentRouteStepIndex++;
            step = currentActiveRoute.steps.get(currentRouteStepIndex);
        }

        double remDist = distToStep;
        double remDur = step.durationSeconds;
        for (int i = currentRouteStepIndex + 1; i < currentActiveRoute.steps.size(); i++) {
            remDist += currentActiveRoute.steps.get(i).distanceMeters;
            remDur += currentActiveRoute.steps.get(i).durationSeconds;
        }

        updateRouteStepDisplay(step, remDist, remDur);
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
                    tvName.setText(item.name);
                    tvAddr.setText(item.address);
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
                startMapplsNavigation(selected.name, selected.lat, selected.lng);
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
    }

    private void showDestinationSearch() {
        if (layoutSearchOverlay == null) return;
        layoutSearchOverlay.setVisibility(View.VISIBLE);
        if (etSearchQuery != null) {
            etSearchQuery.requestFocus();
            etSearchQuery.postDelayed(() -> {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) imm.showSoftInput(etSearchQuery, InputMethodManager.SHOW_IMPLICIT);
            }, 100);
        }
    }

    private void hideDestinationSearch() {
        if (layoutSearchOverlay == null) return;
        layoutSearchOverlay.setVisibility(View.GONE);
        if (etSearchQuery != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) imm.hideSoftInputFromWindow(etSearchQuery.getWindowToken(), 0);
        }
    }

    @Override
    public void onBackPressed() {
        if (layoutSearchOverlay != null && layoutSearchOverlay.getVisibility() == View.VISIBLE) {
            hideDestinationSearch();
            return;
        }
        if (drawerBackdrop != null && drawerBackdrop.getVisibility() == View.VISIBLE) {
            closeDrawer();
            return;
        }
        super.onBackPressed();
    }

    private void startMapplsNavigation(String destName, double destLat, double destLng) {
        Toast.makeText(this, "Calculating Mappls route to " + destName + "...", Toast.LENGTH_SHORT).show();
        MapplsApiClient.getInstance().getDirections(currentRiderLat, currentRiderLng, destLat, destLng, new MapplsApiClient.RouteCallback() {
            @Override
            public void onSuccess(MapplsApiClient.RouteResult route) {
                currentActiveRoute = route;
                currentRouteStepIndex = 0;

                List<double[]> points = decodePolyline(route.geometryPolyline, true);
                if (points.isEmpty()) {
                    for (MapplsApiClient.RouteStep step : route.steps) {
                        points.add(new double[]{step.lng, step.lat});
                    }
                }
                if (mapplsMapView != null) {
                    mapplsMapView.plotRoute(points);
                }

                if (!route.steps.isEmpty()) {
                    MapplsApiClient.RouteStep step0 = route.steps.get(0);
                    updateRouteStepDisplay(step0, route.totalDistanceMeters, route.totalDurationSeconds);
                }

                Toast.makeText(MainActivity.this, "Mappls Navigation Active • Streaming to Cluster", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, "Route failed: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateRouteStepDisplay(MapplsApiClient.RouteStep step, double remDistMeters, double remDurSec) {
        runOnUiThread(() -> {
            if (tvTurnDesc != null) tvTurnDesc.setText(step.instruction);
            if (tvTurnDist != null) {
                if (step.distanceMeters < 1000) {
                    tvTurnDist.setText((int) step.distanceMeters + " m");
                } else {
                    tvTurnDist.setText(String.format(Locale.getDefault(), "%.1f km", step.distanceMeters / 1000.0));
                }
            }
            if (tvNavEta != null) {
                int durMin = (int) Math.round(remDurSec / 60.0);
                tvNavEta.setText(durMin + " min");
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
        currentRouteStepIndex = 0;
        if (mapplsMapView != null) {
            mapplsMapView.clearRoute();
        }
        updateCockpitNavigation("IDLE", "Navigation Idle", 0.0, 0.0, 12, 0, false, "No Active Route");
        Toast.makeText(this, "Navigation Ended", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
    }
}
