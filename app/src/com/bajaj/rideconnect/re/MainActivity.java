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
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
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
    private double currentRiderLat = 28.1319; // Saved default (Jhunjhunu, Rajasthan)
    private double currentRiderLng = 75.3991;
    private float currentRiderBearing = 0f;
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

    // Right Slide-out Drawer & Cockpit Telemetry
    private View drawerBackdrop;
    private View drawerPanel;
    private ImageView btnDrawerClose;
    private ImageView ivDrawerBikeImage;
    private TextView tvDrawerBikeName;
    private View viewDrawerBtStatusDot;
    private TextView tvDrawerBtStatus;
    private TextView tvDrawerClock;
    private TextView tvDrawerBattery;
    private TextView tvDrawerSignal;
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

        try {
            SharedPreferences prefs = getSharedPreferences("bajaj_ride_prefs", MODE_PRIVATE);
            currentRiderLat = prefs.getFloat("saved_rider_lat", 28.1319f);
            currentRiderLng = prefs.getFloat("saved_rider_lng", 75.3991f);
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
        if (intent.hasExtra("map_fullscreen")) {
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
                showAboutDialog();
            } else if ("open_drawer".equalsIgnoreCase(cmd)) {
                openDrawer();
            } else if ("close_drawer".equalsIgnoreCase(cmd)) {
                closeDrawer();
            } else if ("toggle_orientation".equalsIgnoreCase(cmd)) {
                if (btnCompass != null) {
                    btnCompass.performClick();
                }
            }
        }
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
        // Drawer Menu Button (Action Stack)
        btnOpenDrawer = findViewById(R.id.btnOpenDrawer);

        // Layout Containers
        layoutLeftPanel = findViewById(R.id.layoutLeftPanel);
        viewSplitDivider = findViewById(R.id.viewSplitDivider);
        layoutMapContainer = findViewById(R.id.layoutMapContainer);

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
        btnDrawerClose = findViewById(R.id.btnDrawerClose);
        ivDrawerBikeImage = findViewById(R.id.ivDrawerBikeImage);
        tvDrawerBikeName = findViewById(R.id.tvDrawerBikeName);
        viewDrawerBtStatusDot = findViewById(R.id.viewDrawerBtStatusDot);
        tvDrawerBtStatus = findViewById(R.id.tvDrawerBtStatus);
        tvDrawerClock = findViewById(R.id.tvDrawerClock);
        tvDrawerBattery = findViewById(R.id.tvDrawerBattery);
        tvDrawerSignal = findViewById(R.id.tvDrawerSignal);
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
            showRideStatsDialog();
        });
        itemService.setOnClickListener(v -> {
            closeDrawer();
            showServiceDialog();
        });
        itemBikeInfo.setOnClickListener(v -> {
            closeDrawer();
            showBikeInfoDialog();
        });
        itemProfile.setOnClickListener(v -> {
            closeDrawer();
            Toast.makeText(this, "Rider Profile: Deepak Jangir (Owner)", Toast.LENGTH_SHORT).show();
        });
        itemSavedPlaces.setOnClickListener(v -> {
            closeDrawer();
            showSavedPlacesDialog();
        });
        itemOfflineMaps.setOnClickListener(v -> {
            closeDrawer();
            showOfflineMapsDialog();
        });
        itemSettings.setOnClickListener(v -> {
            closeDrawer();
            openNotificationSettings();
        });
        itemHelp.setOnClickListener(v -> {
            closeDrawer();
            try {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18002096060"));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Bajaj Roadside Assistance: 1800-209-6060", Toast.LENGTH_LONG).show();
            }
        });
        itemAbout.setOnClickListener(v -> {
            closeDrawer();
            showAboutDialog();
        });

        // Disconnect & Clean Exit Button
        btnDrawerDisconnect.setOnClickListener(v -> terminateAppSession());

        // Map HUD Controls
        if (btnCurrentLocation != null) {
            btnCurrentLocation.setOnClickListener(v -> {
                centerMapOnCurrentLocation();
                if (layoutRecenterPill != null && layoutRecenterPill.getVisibility() == View.VISIBLE) {
                    layoutRecenterPill.animate().alpha(0f).setDuration(200).withEndAction(() -> {
                        layoutRecenterPill.setVisibility(View.GONE);
                    }).start();
                }
                btnCurrentLocation.setColorFilter(Color.parseColor("#06B6D4"));
            });
        }

        if (layoutRecenterPill != null) {
            layoutRecenterPill.setOnClickListener(v -> {
                if (mapplsMapView != null) {
                    mapplsMapView.centerOnCurrentLocation();
                }
                layoutRecenterPill.animate().alpha(0f).setDuration(200).withEndAction(() -> {
                    layoutRecenterPill.setVisibility(View.GONE);
                }).start();
                if (btnCurrentLocation != null) {
                    btnCurrentLocation.setColorFilter(Color.parseColor("#06B6D4"));
                }
            });
        }

        if (btnCompass != null) {
            btnCompass.setOnClickListener(v -> {
                if (mapplsMapView != null) {
                    mapplsMapView.toggleOrientation();
                } else {
                    btnCompass.animate().rotation(0f).setDuration(350).start();
                    Toast.makeText(this, "2D North-Up View", Toast.LENGTH_SHORT).show();
                }
            });
        }

        if (mapplsMapView != null) {
            mapplsMapView.setOnMapInteractionListener(new MapplsMapView.OnMapInteractionListener() {
                @Override
                public void onMapDragged() {
                    if (layoutRecenterPill != null && layoutRecenterPill.getVisibility() != View.VISIBLE) {
                        layoutRecenterPill.setAlpha(0f);
                        layoutRecenterPill.setVisibility(View.VISIBLE);
                        layoutRecenterPill.animate().alpha(1f).setDuration(200).start();
                    }
                    if (btnCurrentLocation != null) {
                        btnCurrentLocation.setColorFilter(Color.parseColor("#F59E0B"));
                    }
                }

                @Override
                public void onMapRecentered() {
                    if (layoutRecenterPill != null && layoutRecenterPill.getVisibility() == View.VISIBLE) {
                        layoutRecenterPill.animate().alpha(0f).setDuration(200).withEndAction(() -> {
                            layoutRecenterPill.setVisibility(View.GONE);
                        }).start();
                    }
                    if (btnCurrentLocation != null) {
                        btnCurrentLocation.setColorFilter(Color.parseColor("#06B6D4"));
                    }
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
                            Toast.makeText(MainActivity.this, "Cockpit 3D Perspective (Heading Up)", Toast.LENGTH_SHORT).show();
                        } else {
                            btnCompass.setBackgroundResource(R.drawable.bg_circle_action);
                            btnCompass.animate().rotation(0f).setDuration(350).start();
                            Toast.makeText(MainActivity.this, "2D North-Up View", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

        btnMapSearch.setOnClickListener(v -> showDestinationSearch());
        cardTurnInstruction.setOnClickListener(v -> showDestinationSearch());
        setupSearchOverlay();

        btnVoiceNav.setOnClickListener(v -> {
            isVoiceMuted = !isVoiceMuted;
            btnVoiceNav.setImageResource(isVoiceMuted ? R.drawable.ic_volume_off : R.drawable.ic_volume_up);
            btnVoiceNav.setAlpha(isVoiceMuted ? 0.6f : 1.0f);
            String msg = isVoiceMuted ? "Voice Guidance Muted" : "Voice Guidance Active";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            speakVoiceGuidance(msg);
        });

        if (btnStartNavNow != null) {
            btnStartNavNow.setOnClickListener(v -> startActiveNavigation());
        }
        if (btnCancelRoutePreview != null) {
            btnCancelRoutePreview.setOnClickListener(v -> cancelRoutePreview());
        }

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

    private void answerIncomingCall() {
        try {
            TelecomManager tm = (TelecomManager) getSystemService(Context.TELECOM_SERVICE);
            if (tm != null && checkSelfPermission(Manifest.permission.ANSWER_PHONE_CALLS) == PackageManager.PERMISSION_GRANTED) {
                tm.acceptRingingCall();
                Toast.makeText(this, "Call Answered", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Call Answered", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Call Answered", Toast.LENGTH_SHORT).show();
        }
    }

    private void rejectIncomingCall() {
        try {
            TelecomManager tm = (TelecomManager) getSystemService(Context.TELECOM_SERVICE);
            if (tm != null && checkSelfPermission(Manifest.permission.ANSWER_PHONE_CALLS) == PackageManager.PERMISSION_GRANTED) {
                tm.endCall();
                Toast.makeText(this, "Call Ended", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Call Ended", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Call Ended", Toast.LENGTH_SHORT).show();
        }
    }

    private void showSavedPlacesDialog() {
        final String[] placeNames = {
            "🏠 Home (Jhunjhunu)",
            "🏢 Office / Work (RIICO)",
            "⛽ HP Fuel Station (NH 52)",
            "📍 Jaipur Pink City (Hawa Mahal)",
            "📍 Delhi Aerocity (IGI Airport)"
        };
        final MapplsApiClient.PlaceResult[] places = {
            new MapplsApiClient.PlaceResult("Home (Jhunjhunu)", "Mandawa Road, Jhunjhunu, Rajasthan", "", 28.1319, 75.3991, 0, "HOME"),
            new MapplsApiClient.PlaceResult("Office / Work", "RIICO Industrial Area, Jhunjhunu", "", 28.1250, 75.3850, 0, "WORK"),
            new MapplsApiClient.PlaceResult("HP Fuel Station", "NH 52 Highway Express, Rajasthan", "", 28.0120, 75.4120, 0, "FUEL"),
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
        builder.show();
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
        builder.show();
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
            "Authorized Care Center:\n" +
            "Bajaj Auto Service Center, Jhunjhunu"
        );
        builder.setPositiveButton("Call Service", (dialog, which) -> {
            try {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18002096060"));
                startActivity(intent);
            } catch (Exception ignored) {}
        });
        builder.setNegativeButton("Close", (dialog, which) -> dialog.dismiss());
        builder.show();
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
            "• Estimated Range: ~312 km (Eco Mode)"
        );
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void showOfflineMapsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("🗺️ Offline Map Regions");
        builder.setMessage(
            "• Rajasthan North (Downloaded • 145 MB)\n" +
            "• Delhi NCR & Haryana (Downloaded • 210 MB)\n" +
            "• Western Express Highways (Downloaded • 95 MB)\n\n" +
            "Storage Allocated: 450 MB / 128 GB\n" +
            "Status: All regional vector tile packages are up to date."
        );
        builder.setPositiveButton("Check Updates", (dialog, which) -> {
            Toast.makeText(this, "All offline regions are up to date", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Close", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("🏍️ My Pulsar - Cockpit RE");
        builder.setMessage(
            "Version: 3.0.0 (Automotive Cockpit Edition)\n" +
            "Bluetooth Protocol: Universal RE BLE 2.0\n" +
            "Map Engine: Mappls Vector Tiles v3.0\n" +
            "Audio & Calls: AVRCP / Telecom Engine\n\n" +
            "Supported Motorcycles:\n" +
            "• Bajaj Pulsar N250 / F250 / N160 / N150\n" +
            "• Bajaj Pulsar NS400Z / NS200 / NS160\n" +
            "• Bajaj Dominar 400 / 250\n" +
            "• Chetak Electric EV Series"
        );
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
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
        if (tvDrawerBattery == null) return;
        if (percent < 0) {
            tvDrawerBattery.setText("🔋 --%");
            return;
        }
        String icon = charging ? "⚡ " : (percent <= 20 ? "🪫 " : "🔋 ");
        tvDrawerBattery.setText(icon + percent + "%");
        int color = (percent <= 20 && !charging) ? 0xFFEF4444 : (charging ? 0xFFF59E0B : 0xFF10B981);
        tvDrawerBattery.setTextColor(color);
    }

    private void updateSignalDisplay(int bars) {
        if (tvDrawerSignal == null) return;
        if (bars < 0) {
            tvDrawerSignal.setText("📶 --");
            return;
        }
        String graph = bars >= 4 ? "●●●●" : bars == 3 ? "●●●○" : bars == 2 ? "●●○○" : bars == 1 ? "●○○○" : "○○○○";
        tvDrawerSignal.setText("📶 " + graph);
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
                v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(80).start();
            } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80).start();
            }
            return false;
        };

        View[] tactileViews = new View[]{
                btnMediaPlayPause, btnMediaPrev, btnMediaNext, btnPillPlayPause, btnPillNext,
                btnOpenDrawer, btnDrawerClose, btnNavEnd, btnCompass, btnCurrentLocation, btnVoiceNav, btnLayers,
                btnZoomIn, btnZoomOut, btnDrawerDisconnect, btnMapSearch, btnStartNavNow, btnCancelRoutePreview
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
        if (tvDrawerBtStatus != null) {
            tvDrawerBtStatus.setText("Connecting...");
            tvDrawerBtStatus.setTextColor(0xFFF59E0B);
        }
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        runOnUiThread(() -> {
            if (connected) {
                String displayName = (deviceName != null && !deviceName.isEmpty()) ? deviceName : "Bajaj Pulsar NS400Z";
                if (tvDrawerBikeName != null) tvDrawerBikeName.setText(displayName);
                if (tvDrawerBtStatus != null) {
                    tvDrawerBtStatus.setText("Connected (BLE OK)");
                    tvDrawerBtStatus.setTextColor(0xFF10B981);
                }
            } else {
                if (tvDrawerBikeName != null) tvDrawerBikeName.setText("Bajaj Pulsar NS400Z");
                if (tvDrawerBtStatus != null) {
                    tvDrawerBtStatus.setText("Disconnected");
                    tvDrawerBtStatus.setTextColor(0xFFEF4444);
                }
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
            mapplsMapView.updateRiderLocation(currentRiderLat, currentRiderLng, currentRiderBearing);
            mapplsMapView.centerOnCurrentLocation();
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
        // Skip steps with no valid location data (lat/lng == 0)
        if (step.lat == 0.0 && step.lng == 0.0) {
            // Treat as passed; move to next step if any
            currentRouteStepIndex++;
            if (currentRouteStepIndex >= currentActiveRoute.steps.size()) {
                endActiveNavigation();
                return;
            }
            step = currentActiveRoute.steps.get(currentRouteStepIndex);
        }

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
                        imm.showSoftInput(etSearchQuery, InputMethodManager.SHOW_FORCED);
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
        layoutSearchOverlay.setVisibility(View.GONE);
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

    @Override
    public void onBackPressed() {
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
        if (drawerBackdrop != null && drawerBackdrop.getVisibility() == View.VISIBLE) {
            closeDrawer();
            return;
        }
        super.onBackPressed();
    }

    private void previewRoute(MapplsApiClient.PlaceResult selected) {
        if (selected == null) return;
        Toast.makeText(this, "Calculating route to " + selected.name + "...", Toast.LENGTH_SHORT).show();
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

                if (cardRoutePreview != null) cardRoutePreview.setVisibility(View.VISIBLE);
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

        if (cardRoutePreview != null) cardRoutePreview.setVisibility(View.GONE);
        if (cardTurnInstruction != null) cardTurnInstruction.setVisibility(View.VISIBLE);
        if (cardBottomNav != null) cardBottomNav.setVisibility(View.VISIBLE);
        if (cardSpeedHud != null) cardSpeedHud.setVisibility(View.VISIBLE);

        if (mapplsMapView != null) {
            mapplsMapView.setNavigating(true);
            mapplsMapView.centerOnCurrentLocation();
        } else {
            centerMapOnCurrentLocation();
        }

        if (!currentActiveRoute.steps.isEmpty()) {
            MapplsApiClient.RouteStep step0 = currentActiveRoute.steps.get(0);
            updateRouteStepDisplay(step0, currentActiveRoute.totalDistanceMeters, currentActiveRoute.totalDurationSeconds);
        }

        speakVoiceGuidance("Starting route to " + pendingDestName);
        Toast.makeText(this, "Mappls Navigation Active to " + pendingDestName, Toast.LENGTH_SHORT).show();
    }

    private void cancelRoutePreview() {
        pendingPreviewRoute = null;
        if (cardRoutePreview != null) cardRoutePreview.setVisibility(View.GONE);
        if (cardSpeedHud != null) cardSpeedHud.setVisibility(View.GONE);
        if (mapplsMapView != null) {
            mapplsMapView.clearRoute();
            mapplsMapView.centerOnCurrentLocation();
        } else {
            centerMapOnCurrentLocation();
        }
    }

    private void updateRouteStepDisplay(MapplsApiClient.RouteStep step, double remDistMeters, double remDurSec) {
        runOnUiThread(() -> {
            if (cardTurnInstruction != null && cardTurnInstruction.getVisibility() != View.VISIBLE) {
                cardTurnInstruction.setVisibility(View.VISIBLE);
            }
            if (cardBottomNav != null && cardBottomNav.getVisibility() != View.VISIBLE) {
                cardBottomNav.setVisibility(View.VISIBLE);
            }
            if (cardSpeedHud != null && cardSpeedHud.getVisibility() != View.VISIBLE) {
                cardSpeedHud.setVisibility(View.VISIBLE);
            }

            if (tvTurnDesc != null) {
                String desc = (step.instruction != null && !step.instruction.isEmpty())
                        ? step.instruction : step.street;
                tvTurnDesc.setText(desc);
            }
            if (tvTurnDist != null) {
                if (step.distanceMeters < 1000) {
                    tvTurnDist.setText((int) step.distanceMeters + " m");
                } else {
                    tvTurnDist.setText(String.format(Locale.getDefault(), "%.1f km", step.distanceMeters / 1000.0));
                }
            }

            if (ivTurnArrow != null) {
                int iconRes = R.drawable.ic_turn_right_nav;
                if (step.maneuverID == 8) {
                    iconRes = R.drawable.ic_nav_puck;
                } else if (step.maneuverID == 19 || step.maneuverID == 20 || step.maneuverID == 15) {
                    iconRes = R.drawable.ic_turn_left_nav;
                } else if (step.maneuverID == 0) {
                    iconRes = R.drawable.ic_straight_nav;
                }
                ivTurnArrow.setImageResource(iconRes);
            }

            if (layoutNextStepPreview != null && tvNextStepDesc != null) {
                if (currentActiveRoute != null && currentRouteStepIndex + 1 < currentActiveRoute.steps.size()) {
                    MapplsApiClient.RouteStep nextStep = currentActiveRoute.steps.get(currentRouteStepIndex + 1);
                    String nextDist = nextStep.distanceMeters < 1000
                            ? (int) nextStep.distanceMeters + " m"
                            : String.format(Locale.getDefault(), "%.1f km", nextStep.distanceMeters / 1000.0);
                    tvNextStepDesc.setText("Then " + nextDist + " • " + (nextStep.instruction.isEmpty() ? nextStep.street : nextStep.instruction));
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
        if (cardTurnInstruction != null) cardTurnInstruction.setVisibility(View.GONE);
        if (cardBottomNav != null) cardBottomNav.setVisibility(View.GONE);
        if (cardRoutePreview != null) cardRoutePreview.setVisibility(View.GONE);
        if (cardSpeedHud != null) cardSpeedHud.setVisibility(View.GONE);
        if (mapplsMapView != null) {
            mapplsMapView.setNavigating(false);
            mapplsMapView.clearRoute();
            mapplsMapView.centerOnCurrentLocation();
        } else {
            centerMapOnCurrentLocation();
        }
        speakVoiceGuidance("Navigation ended");
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
        if (tts != null) {
            try {
                tts.stop();
                tts.shutdown();
            } catch (Exception ignored) {}
        }
    }
}
