package com.bajajconnect.gMaps;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.ble.BleService;
import com.bajajconnect.enums.PrimaryTurns;
import com.bajajconnect.gMaps.util.GmapUtil;
import com.bajajconnect.navigate.adapter.AddRouteAdapter;
import com.bajajconnect.utils.NavCancelledEventBridge;
import com.bajajconnect.utils.NavChromeInsets;
import com.bajajconnect.utils.NavigationHelper;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.bajajconnect.wifi.Screens;
import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.android.libraries.navigation.AlternateRoutesStrategy;
import com.google.android.libraries.navigation.ArrivalEvent;
import com.google.android.libraries.navigation.DisplayOptions;
import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.RouteSegment;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.TimeAndDistance;
import com.google.android.libraries.navigation.Waypoint;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.turf.TurfConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int MAX_ROUTE_REQUEST_ATTEMPTS = 5;
    private static final int MAX_TIME_DISTANCE_RETRIES = 6;
    private static final int MAX_TRIP_SAMPLES = 500;
    private static final long MIRROR_SERVICE_RETRY_MS = 100;
    private static final float TRIP_SAMPLE_MIN_DISTANCE_M = 30.0f;
    private static final long TRIP_SAMPLE_MIN_INTERVAL_MS = 5000;
    private AddRouteAdapter addRouteAdapter;
    private ImageView backBtn;
    private ConstraintLayout bottomView;
    private LinearLayout cancelBtn;
    private LinearLayout cancelNavigationBtn;
    private Navigator defaultNavigator;
    private TextView distanceTv;
    private GoogleMap googleMap;
    private LatLngBounds latLngBounds;
    private LinearLayout navigationBtn;
    private NavigationView navigationView;
    private Polyline previewPolyline;
    private RecyclerView recyclerViewTo;
    private PolylineOptions routePolyline;
    private Handler routePreviewTbtHandler;
    private Runnable routePreviewTbtRunnable;
    private FloatingActionButton soundbtn;
    private TextView textViewDestination;
    private TextView textViewFrom;
    private TextView time;
    private ConstraintLayout topView;
    private boolean isTakeMeHome = false;
    private boolean isRoutePreviewTbtActive = false;
    private boolean navigatorListenersAttached = false;
    private int timeDistanceRetryCount = 0;
    private boolean skipOnDestroyMirroringReset = false;
    private boolean navigationSessionTornDown = false;
    private boolean holdCellularForRouteRequest = false;
    private int routeRequestGeneration = 0;
    private boolean googleGuidanceHadStarted = false;
    private long navSessionStartMs = 0;
    private Double initialRemainingDistanceMeters = null;
    private Double lastRemainingDistanceMeters = null;
    private final ArrayList<double[]> tripLocationSamples = new ArrayList<>();
    private long lastTripSampleMs = 0;
    private Location lastTripSampleLocation = null;
    private final Observer<NavInfo> tripNavInfoObserver = new Observer() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda3
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$0((NavInfo) obj);
        }
    };
    private boolean isSoundOFF = false;
    private Navigator.ArrivalListener arrivalListener = new Navigator.ArrivalListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.11
        @Override // com.google.android.libraries.navigation.Navigator.ArrivalListener
        public void onArrival(ArrivalEvent arrivalEvent) {
            TimeAndDistance currentTimeAndDistance;
            int meters = -1;
            try {
                if (NavigationActivity.this.defaultNavigator != null && (currentTimeAndDistance = NavigationActivity.this.defaultNavigator.getCurrentTimeAndDistance()) != null) {
                    meters = currentTimeAndDistance.getMeters();
                }
            } catch (Exception e) {
                Log.w("NavigationActivity", "onArrival remaining lookup failed", e);
            }
            StringBuilder sb = new StringBuilder("onArrival remainingMeters=");
            sb.append(meters);
            sb.append(" final=");
            sb.append(arrivalEvent != null && arrivalEvent.isFinalDestination());
            Log.i("NavigationActivity", sb.toString());
            if (meters > 80) {
                Log.i("NavigationActivity", "suppress early Arrival — keep guidance + TBT running");
            } else if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onDestinationReached();
            }
        }
    };
    private Navigator.NavigationSessionListener navigationSessionListener = new Navigator.NavigationSessionListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.12
        @Override // com.google.android.libraries.navigation.Navigator.NavigationSessionListener
        public void onNewNavigationSession() {
        }
    };
    private Navigator.ReroutingListener reroutingListener = new Navigator.ReroutingListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.13
        @Override // com.google.android.libraries.navigation.Navigator.ReroutingListener
        public void onReroutingRequestedByOffRoute() {
            Log.e("NavigationActivity", "on rerouting requested — cellular for route + notify cluster");
            MirroringPolicy.ensureCellularNetworkForRouting(NavigationActivity.this);
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onRerouting();
            }
            if (GlobalVar.isNavigationActive) {
                NavigationActivity.this.scheduleFollowRestore("offRoute");
            }
        }
    };
    private Navigator.RouteChangedListener routeChangedListener = new Navigator.RouteChangedListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.14
        @Override // com.google.android.libraries.navigation.Navigator.RouteChangedListener
        public void onRouteChanged() {
            Log.d("NavigationActivity", "onRouteChanged — isNavActive=" + GlobalVar.isNavigationActive + " holdCellular=" + NavigationActivity.this.holdCellularForRouteRequest);
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onRouteReady();
            }
            if (NavigationActivity.this.holdCellularForRouteRequest) {
                Log.d("NavigationActivity", "onRouteChanged — skip SoftAP restore (route request)");
            } else if (GlobalVar.isNavigationActive) {
                MirroringPolicy.restoreClusterNetworkAfterRouting(NavigationActivity.this);
            }
            if (GlobalVar.isNavigationActive) {
                NavigationActivity.this.ensureLiveRoutePolyline("routeChanged");
                NavigationActivity.this.scheduleFollowRestore("routeChanged");
            } else {
                NavigationActivity.this.showRouteOnMap();
            }
        }
    };
    private boolean isNavUpdateRecieverServiceRegistered = false;
    private int routeRequestAttempts = 0;
    private BroadcastReceiver mMessageReceiver = new AnonymousClass16();

    public static Intent createLaunchIntent(Context context) {
        Intent intent = new Intent(context, (Class<?>) NavigationActivity.class);
        intent.addFlags(872546304);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(NavInfo navInfo) {
        if (!this.googleGuidanceHadStarted || navInfo == null) {
            return;
        }
        try {
            int iMax = Math.max(0, navInfo.getDistanceToFinalDestinationMeters().intValue());
            if (iMax > 0) {
                double d = iMax;
                if (this.initialRemainingDistanceMeters == null) {
                    this.initialRemainingDistanceMeters = Double.valueOf(d);
                }
                this.lastRemainingDistanceMeters = Double.valueOf(d);
            }
        } catch (Exception e) {
            Log.w("NavigationActivity", "trip NavInfo remaining failed", e);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        applyShowWhenLockedAndWake();
        super.onCreate(bundle);
        setRequestedOrientation(1);
        Log.d("Bmaps", "gmapsActLoaded");
        setContentView(R.layout.activity_nav_view);
        ClusterNavigationLauncher.clearLaunchNotification(this);
        initView();
        NavApplication.activity = this;
        GoogleNavSdkGate.setNavigationActivityOwnsNavigator(true);
        this.navigationView.onCreate(bundle);
        setUpVariables();
        hideNativeRoutePreviewChrome();
        String action = getIntent().getAction();
        boolean z = action != null && action.equals(GlobalVar.takeMeHomeActionStart);
        this.isTakeMeHome = z;
        if (z) {
            GlobalVar.isIsTakeMeHomeNavStarting = true;
        }
        Log.e("NavActivity", "take me home " + this.isTakeMeHome);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_path);
        this.recyclerViewTo = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AddRouteAdapter addRouteAdapter = new AddRouteAdapter();
        this.addRouteAdapter = addRouteAdapter;
        this.recyclerViewTo.setAdapter(addRouteAdapter);
        ArrayList arrayList = new ArrayList();
        if (NavApplication.eLocation != null && NavApplication.eLocation.placeAddress != null && !NavApplication.eLocation.placeAddress.isEmpty()) {
            arrayList.add(NavApplication.eLocation.placeAddress);
        } else if (NavApplication.eLocation != null && NavApplication.eLocation.placeName != null && !NavApplication.eLocation.placeName.isEmpty()) {
            arrayList.add(NavApplication.eLocation.placeName);
        } else {
            Log.w("NavigationActivity", "onCreate: eLocation missing — continuing without route header");
        }
        this.addRouteAdapter.updateList(arrayList);
        getWindow().addFlags(128);
        Log.e("NavigationActivity", "get MAp");
        GlobalVar.hydrateAppThemeFromPrefs(this);
        applyAppThemeToNavigationView();
        this.navigationView.getMapAsync(this);
        registerBroadcastReciever();
        if (MirroringPolicy.deferMirroringUntilNavigation() && MirroringGlobarVar.isWifiConnected) {
            MirroringPolicy.ensureCellularNetworkForRouting(this);
            if (NavApplication.streamingHandler == null || NavApplication.streamingHandler.isUdpBoundOrBinding()) {
                return;
            }
            NavApplication.streamingHandler.initUdpServer();
            return;
        }
        if (MirroringPolicy.deferMirroringUntilNavigation()) {
            return;
        }
        checkForWifi();
    }

    private void applyShowWhenLockedAndWake() {
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        }
        try {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(2621569);
            }
        } catch (Exception e) {
            Log.w("NavigationActivity", "window lock flags failed", e);
        }
        try {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager == null || powerManager.isInteractive()) {
                return;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(268435466, "BajajRideConnect:NavActivityWake");
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(TRIP_SAMPLE_MIN_INTERVAL_MS);
        } catch (Exception e2) {
            Log.w("NavigationActivity", "wake lock failed", e2);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (GlobalVar.isNavigationActive && !this.navigationSessionTornDown && canReuseExistingNavigatorRouteForGlobalDestination()) {
            Log.i("NavigationActivity", "onNewIntent — same active trip, resume only");
            GoogleNavSdkGate.setNavigationActivityOwnsNavigator(true);
            ensureLiveRoutePolyline("onNewIntentResume");
            scheduleFollowRestore("onNewIntentResume");
            ensureNavMirroringAfterUnlock();
            return;
        }
        StringBuilder sb = new StringBuilder("onNewIntent — retarget dest=");
        sb.append(GlobalVar.lat);
        sb.append(",");
        sb.append(GlobalVar.lng);
        sb.append(" place=");
        sb.append(NavApplication.eLocation != null ? NavApplication.eLocation.placeName : "");
        Log.i("NavigationActivity", sb.toString());
        GoogleNavSdkGate.setNavigationActivityOwnsNavigator(true);
        this.navigationSessionTornDown = false;
        GlobalVar.isNavigationActive = false;
        this.routeRequestGeneration++;
        this.holdCellularForRouteRequest = true;
        String action = intent != null ? intent.getAction() : null;
        boolean z = action != null && action.equals(GlobalVar.takeMeHomeActionStart);
        this.isTakeMeHome = z;
        if (z) {
            GlobalVar.isIsTakeMeHomeNavStarting = true;
        }
        refreshDestinationHeaderFromELocation();
        hideNativeRoutePreviewChrome();
        Navigator navigator = this.defaultNavigator;
        if (navigator == null) {
            return;
        }
        try {
            navigator.stopGuidance();
        } catch (Exception e) {
            Log.w("NavigationActivity", "onNewIntent stopGuidance", e);
        }
        try {
            this.defaultNavigator.clearDestinations();
        } catch (Exception e2) {
            Log.w("NavigationActivity", "onNewIntent clearDestinations", e2);
        }
        try {
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onNavigationStop();
            }
        } catch (Exception e3) {
            Log.w("NavigationActivity", "onNewIntent onNavigationStop", e3);
        }
        try {
            this.navigationView.setNavigationUiEnabled(true);
            this.navigationView.setRecenterButtonEnabled(false);
            this.navigationView.setSpeedometerEnabled(false);
            this.navigationView.setSpeedLimitIconEnabled(false);
        } catch (Exception e4) {
            Log.w("NavigationActivity", "onNewIntent ui reset", e4);
        }
        try {
            MirroringPolicy.ensureCellularNetworkForRouting(this);
        } catch (Exception e5) {
            Log.w("NavigationActivity", "onNewIntent ensureCellular", e5);
        }
        scheduleInitialRouteAfterReady();
    }

    private void refreshDestinationHeaderFromELocation() {
        try {
            if (this.addRouteAdapter == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (NavApplication.eLocation != null && NavApplication.eLocation.placeAddress != null && !NavApplication.eLocation.placeAddress.isEmpty()) {
                arrayList.add(NavApplication.eLocation.placeAddress);
            } else if (NavApplication.eLocation != null && NavApplication.eLocation.placeName != null && !NavApplication.eLocation.placeName.isEmpty()) {
                arrayList.add(NavApplication.eLocation.placeName);
            }
            this.addRouteAdapter.updateList(arrayList);
        } catch (Exception e) {
            Log.w("NavigationActivity", "refreshDestinationHeaderFromELocation", e);
        }
    }

    public void checkForWifi() {
        MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO;
        if (MirroringGlobarVar.isWifiConnected) {
            MirroringGlobarVar.isOnMirroringPage = true;
            beginNavigationMirroring();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginNavigationMirroring() {
        if (!NavApplication.streamingHandler.onSocketsInitialise()) {
            NavApplication.streamingHandler.initWifiServers();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.beginNavigationMirroring();
                }
            }, MIRROR_SERVICE_RETRY_MS);
        } else {
            waitForServicesAndSetupMirroring();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForServicesAndSetupMirroring() {
        if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.onSocketsInitialise() && NavApplication.streamingHandler.udpServerService != null && NavApplication.customProjection != null) {
            NavApplication.streamingHandler.udpServerService.stopScreenCapture();
            NavApplication.customProjection.startActivityRoute(this);
            MirroringGlobarVar.currentScreen = Screens.ROUTE_SCREEN;
            NavApplication.streamingHandler.udpServerService.onScreenChange();
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.waitForServicesAndSetupMirroring();
            }
        }, MIRROR_SERVICE_RETRY_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMirroringWhenRouteReady() {
        if (MirroringGlobarVar.isWifiConnected) {
            if (MirroringPolicy.deferMirroringUntilNavigation()) {
                MirroringPolicy.startRoutePreviewMirroring(this);
            } else {
                if (MirroringGlobarVar.isOnMirroringPage) {
                    return;
                }
                checkForWifi();
            }
        }
    }

    private void initView() {
        this.navigationView = (NavigationView) findViewById(R.id.navigation_view);
        this.navigationBtn = (LinearLayout) findViewById(R.id.linear_layout_navigation);
        this.cancelBtn = (LinearLayout) findViewById(R.id.linear_layout_navigation_cancle);
        this.topView = (ConstraintLayout) findViewById(R.id.constraintLayout);
        this.bottomView = (ConstraintLayout) findViewById(R.id.bottom_view);
        this.textViewFrom = (TextView) findViewById(R.id.text_view_from);
        TextView textView = (TextView) findViewById(R.id.text_view_time);
        this.time = textView;
        textView.setText("30 min");
        this.distanceTv = (TextView) findViewById(R.id.text_view_distance_header);
        this.cancelNavigationBtn = (LinearLayout) findViewById(R.id.cancel_navigation_btn);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.sound_btn);
        this.soundbtn = floatingActionButton;
        floatingActionButton.setVisibility(8);
        this.backBtn = (ImageView) findViewById(R.id.image_view_back);
        applyNavigationBarInsets(this.bottomView, this.cancelNavigationBtn, this.soundbtn);
    }

    private void setUpVariables() {
        this.navigationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.e("NavigationActivity", "start navigation");
                NavigationActivity.this.startNavigation();
            }
        });
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationActivity.this.cancelNavigation(true);
            }
        });
        this.soundbtn.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NavigationActivity.this.isSoundOFF) {
                    NavigationActivity.this.isSoundOFF = false;
                    NavigationActivity.this.toggleSound(true);
                    NavigationActivity.this.soundbtn.setImageDrawable(ContextCompat.getDrawable(NavigationActivity.this, R.drawable.ic_sound_on));
                } else {
                    NavigationActivity.this.isSoundOFF = true;
                    NavigationActivity.this.soundbtn.setImageDrawable(ContextCompat.getDrawable(NavigationActivity.this, R.drawable.ic_sound_off));
                    NavigationActivity.this.toggleSound(false);
                }
            }
        });
        this.cancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.e("NavigationActivity", "cancel navigation");
                NavigationActivity.this.cancelNavigation(true);
            }
        });
        this.cancelNavigationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.gMaps.NavigationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationActivity.this.cancelNavigation(true);
            }
        });
    }

    private void hideNativeRoutePreviewChrome() {
        ConstraintLayout constraintLayout = this.topView;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = this.bottomView;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        LinearLayout linearLayout = this.cancelNavigationBtn;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FloatingActionButton floatingActionButton = this.soundbtn;
        if (floatingActionButton != null) {
            floatingActionButton.setVisibility(8);
        }
    }

    public void startNavigation() {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null) {
            Log.e("NavigationActivity", "startNavigation: navigator is null");
            showToast("Navigation is not ready yet. Please wait for the route.");
            return;
        }
        try {
            if (navigator.getCurrentTimeAndDistance() == null) {
                Log.e("NavigationActivity", "startNavigation: route not ready");
                showToast("Route is still loading. Please wait.");
                Place place = new Place();
                place.setLat(GlobalVar.lat);
                place.setLng(GlobalVar.lng);
                navigateToPlace(place, false);
                return;
            }
            clearPreviewPolyline();
            this.navigationView.setNavigationUiEnabled(true);
            this.googleMap.setMyLocationEnabled(true);
            GlobalVar.isNavigationActive = true;
            this.navigationSessionTornDown = false;
            beginGoogleTripSessionTracking();
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onNavigationStart();
            }
            registerListners();
            this.defaultNavigator.setAudioGuidance(4);
            this.navigationView.setRecenterButtonEnabled(true);
            this.navigationView.setSpeedometerEnabled(true);
            this.navigationView.setSpeedLimitIconEnabled(true);
            this.defaultNavigator.startGuidance();
            this.holdCellularForRouteRequest = false;
            hideRouteLayout();
            ensureLiveRoutePolyline("startGuidance");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startNavigation$1();
                }
            }, 500L);
            recenterNavigationCamera();
            new Handler(Looper.getMainLooper()).postDelayed(new NavigationActivity$$ExternalSyntheticLambda11(this), 300L);
            new Handler(Looper.getMainLooper()).postDelayed(new NavigationActivity$$ExternalSyntheticLambda11(this), 900L);
            if (MirroringGlobarVar.isWifiConnected) {
                MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
                waitForServicesAndStartNavMirroring();
            }
        } catch (Exception e) {
            Log.e("NavigationActivity", "startNavigation: route check failed", e);
            showToast("Unable to start navigation. Please try again.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startNavigation$1() {
        ensureLiveRoutePolyline("startGuidanceDelayed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForServicesAndStartNavMirroring() {
        if (NavApplication.streamingHandler == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.waitForServicesAndStartNavMirroring();
                }
            }, MIRROR_SERVICE_RETRY_MS);
            return;
        }
        if (NavApplication.streamingHandler.udpServerService == null) {
            try {
                NavApplication.streamingHandler.initUdpServer();
            } catch (Exception e) {
                Log.w("NavigationActivity", "initUdpServer for nav mirroring failed", e);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.waitForServicesAndStartNavMirroring();
                }
            }, MIRROR_SERVICE_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.onSocketsInitialise() || NavApplication.customProjection == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.waitForServicesAndStartNavMirroring();
                }
            }, MIRROR_SERVICE_RETRY_MS);
            return;
        }
        if (NavApplication.customProjection.routeInfoPresentation == null && NavApplication.customProjection.routeInfoPresentationMMI == null) {
            try {
                NavApplication.streamingHandler.udpServerService.stopScreenCapture();
                NavApplication.customProjection.startActivityRoute(this);
            } catch (Exception e2) {
                Log.w("NavigationActivity", "startActivityRoute for TBT mirror failed", e2);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.waitForServicesAndStartNavMirroring();
                }
            }, MIRROR_SERVICE_RETRY_MS);
            return;
        }
        try {
            NavApplication.streamingHandler.udpServerService.stopScreenCapture();
            if (GlobalVar.isGoogleNavigation && NavApplication.customProjection.routeInfoPresentation != null) {
                NavApplication.customProjection.routeInfoPresentation.startNavigation();
            } else if (NavApplication.customProjection.routeInfoPresentationMMI != null) {
                NavApplication.customProjection.routeInfoPresentationMMI.startNavigation();
            }
            MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
            NavApplication.streamingHandler.udpServerService.onScreenChange();
        } catch (Exception e3) {
            Log.e("NavigationActivity", "start TBT mirroring failed", e3);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.waitForServicesAndStartNavMirroring();
                }
            }, MIRROR_SERVICE_RETRY_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recenterNavigationCamera() {
        if (this.googleMap == null || this.navigationView == null) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            try {
                this.navigationView.setNavigationUiEnabled(true);
                this.googleMap.setMyLocationEnabled(true);
                this.googleMap.setPadding(0, 0, 0, 120);
                this.googleMap.followMyLocation(0);
            } catch (Exception e) {
                Log.e("NavigationActivity", "recenterNavigationCamera failed", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleFollowRestore(String str) {
        Log.d("NavigationActivity", "scheduleFollowRestore: " + str);
        runOnUiThread(new NavigationActivity$$ExternalSyntheticLambda11(this));
        new Handler(Looper.getMainLooper()).postDelayed(new NavigationActivity$$ExternalSyntheticLambda11(this), 300L);
        new Handler(Looper.getMainLooper()).postDelayed(new NavigationActivity$$ExternalSyntheticLambda11(this), 1000L);
        new Handler(Looper.getMainLooper()).postDelayed(new NavigationActivity$$ExternalSyntheticLambda11(this), 2500L);
    }

    public void cancelNavigation(boolean z) {
        WritableMap writableMapBuildNavCancelledEventBody = buildNavCancelledEventBody();
        tearDownActiveNavigation("cancelNavigation finish=" + z);
        emitNavCancelledEvent(writableMapBuildNavCancelledEventBody);
        if (z) {
            this.skipOnDestroyMirroringReset = true;
            resetMirroringToSearchScreen("cancelNavigation_finish");
            finish();
        } else {
            this.skipOnDestroyMirroringReset = true;
            resetMirroringToSearchScreen("cancelNavigation_no_preview");
            finish();
        }
    }

    private void beginGoogleTripSessionTracking() {
        TimeAndDistance currentTimeAndDistance;
        this.googleGuidanceHadStarted = true;
        this.navSessionStartMs = System.currentTimeMillis();
        this.initialRemainingDistanceMeters = null;
        this.lastRemainingDistanceMeters = null;
        this.tripLocationSamples.clear();
        this.lastTripSampleMs = 0L;
        this.lastTripSampleLocation = null;
        try {
            Navigator navigator = this.defaultNavigator;
            if (navigator != null && (currentTimeAndDistance = navigator.getCurrentTimeAndDistance()) != null && currentTimeAndDistance.getMeters() > 0) {
                Double dValueOf = Double.valueOf(currentTimeAndDistance.getMeters());
                this.initialRemainingDistanceMeters = dValueOf;
                this.lastRemainingDistanceMeters = dValueOf;
            }
        } catch (Exception e) {
            Log.w("NavigationActivity", "initial remaining distance failed", e);
        }
        try {
            NavInfoReceivingService.getNavInfoLiveData().observe(this, this.tripNavInfoObserver);
        } catch (Exception e2) {
            Log.w("NavigationActivity", "observe NavInfo for trip stats failed", e2);
        }
        GoogleMap googleMap = this.googleMap;
        if (googleMap != null) {
            try {
                googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda9
                    @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
                    public final void onMyLocationChange(Location location) {
                        this.f$0.lambda$beginGoogleTripSessionTracking$2(location);
                    }
                });
            } catch (Exception e3) {
                Log.w("NavigationActivity", "setOnMyLocationChangeListener failed", e3);
            }
        }
        Log.i("NavigationActivity", "trip session tracking started");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$beginGoogleTripSessionTracking$2(Location location) {
        if (location != null) {
            appendTripLocationSample(location);
        }
    }

    private void appendTripLocationSample(Location location) {
        if (location == null || !this.googleGuidanceHadStarted) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Location location2 = this.lastTripSampleLocation;
        if (location2 != null) {
            long j = jCurrentTimeMillis - this.lastTripSampleMs;
            float fDistanceTo = location.distanceTo(location2);
            if (j < TRIP_SAMPLE_MIN_INTERVAL_MS && fDistanceTo < 30.0f) {
                return;
            }
        }
        if (this.tripLocationSamples.size() >= 500) {
            ArrayList<double[]> arrayList = this.tripLocationSamples;
            arrayList.subList(0, arrayList.size() / 4).clear();
        }
        this.tripLocationSamples.add(new double[]{location.getLongitude(), location.getLatitude()});
        this.lastTripSampleMs = jCurrentTimeMillis;
        this.lastTripSampleLocation = new Location(location);
    }

    private double haversineTripDistanceMeters() {
        double d = 0.0d;
        if (this.tripLocationSamples.size() < 2) {
            return 0.0d;
        }
        int i = 0;
        while (i < this.tripLocationSamples.size() - 1) {
            double[] dArr = this.tripLocationSamples.get(i);
            i++;
            double[] dArr2 = this.tripLocationSamples.get(i);
            float[] fArr = new float[1];
            Location.distanceBetween(dArr[1], dArr[0], dArr2[1], dArr2[0], fArr);
            d += (double) fArr[0];
        }
        return d;
    }

    private double remainingBasedTripDistanceMeters() {
        Double d = this.initialRemainingDistanceMeters;
        if (d == null || this.lastRemainingDistanceMeters == null) {
            return 0.0d;
        }
        return Math.max(0.0d, d.doubleValue() - this.lastRemainingDistanceMeters.doubleValue());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a8  */
    private WritableMap buildNavCancelledEventBody() {
        String str;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("fromAutoStart", this.isTakeMeHome);
        if (!this.googleGuidanceHadStarted) {
            writableMapCreateMap.putBoolean("showSaveTrip", false);
            return writableMapCreateMap;
        }
        double dMax = Math.max(haversineTripDistanceMeters(), remainingBasedTripDistanceMeters());
        int iMax = this.navSessionStartMs > 0 ? (int) Math.max(0L, (System.currentTimeMillis() - this.navSessionStartMs) / 60000) : 0;
        writableMapCreateMap.putBoolean("showSaveTrip", true);
        writableMapCreateMap.putDouble(DirectionsCriteria.ANNOTATION_DISTANCE, dMax);
        writableMapCreateMap.putInt("timeOfTravel", iMax);
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (double[] dArr : this.tripLocationSamples) {
            WritableArray writableArrayCreateArray2 = Arguments.createArray();
            writableArrayCreateArray2.pushDouble(dArr[0]);
            writableArrayCreateArray2.pushDouble(dArr[1]);
            writableArrayCreateArray.pushArray(writableArrayCreateArray2);
        }
        writableMapCreateMap.putArray("wayPointsCovered", writableArrayCreateArray);
        if (NavApplication.eLocation == null) {
            str = null;
        } else if (NavApplication.eLocation.placeAddress != null && !NavApplication.eLocation.placeAddress.isEmpty()) {
            str = NavApplication.eLocation.placeAddress;
        } else if (NavApplication.eLocation.placeName == null || NavApplication.eLocation.placeName.isEmpty()) {
            str = null;
        } else {
            str = NavApplication.eLocation.placeName;
        }
        if (str != null) {
            writableMapCreateMap.putString("destinationAddress", str);
        } else {
            writableMapCreateMap.putNull("destinationAddress");
        }
        writableMapCreateMap.putNull("sourceAddress");
        writableMapCreateMap.putNull("locationData");
        writableMapCreateMap.putNull("currentLocationAddress");
        if (!this.tripLocationSamples.isEmpty()) {
            ArrayList<double[]> arrayList = this.tripLocationSamples;
            double[] dArr2 = arrayList.get(arrayList.size() - 1);
            WritableArray writableArrayCreateArray3 = Arguments.createArray();
            writableArrayCreateArray3.pushDouble(dArr2[0]);
            writableArrayCreateArray3.pushDouble(dArr2[1]);
            writableMapCreateMap.putArray("currentLocation", writableArrayCreateArray3);
        } else {
            writableMapCreateMap.putNull("currentLocation");
        }
        writableMapCreateMap.putString("mapProvider", "google");
        Log.i("NavigationActivity", "cancel payload showSaveTrip=true distance=" + ((int) dMax) + "m time=" + iMax + "min samples=" + this.tripLocationSamples.size());
        this.googleGuidanceHadStarted = false;
        try {
            NavInfoReceivingService.getNavInfoLiveData().removeObserver(this.tripNavInfoObserver);
        } catch (Exception unused) {
        }
        return writableMapCreateMap;
    }

    private void emitNavCancelledEvent(WritableMap writableMap) {
        try {
            ComponentCallbacks2 application = getApplication();
            if (!(application instanceof ReactApplication)) {
                Log.w("NavigationActivity", "emit NAV_CANCELLED_EVENT skipped — not ReactApplication");
                return;
            }
            ReactContext currentReactContext = ((ReactApplication) application).getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
            if (currentReactContext == null) {
                Log.w("NavigationActivity", "emit NAV_CANCELLED_EVENT skipped — no ReactContext");
            } else {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(NavCancelledEventBridge.EVENT_NAME, writableMap);
                Log.i("NavigationActivity", "emitted NAV_CANCELLED_EVENT");
            }
        } catch (Exception e) {
            Log.e("NavigationActivity", "emit NAV_CANCELLED_EVENT failed", e);
        }
    }

    private void tearDownActiveNavigation(String str) {
        if (this.navigationSessionTornDown && !GlobalVar.isNavigationActive) {
            Log.d("NavigationActivity", "tearDownActiveNavigation skip (already done) " + str);
            return;
        }
        Log.i("NavigationActivity", "tearDownActiveNavigation " + str);
        try {
            NavigationView navigationView = this.navigationView;
            if (navigationView != null) {
                navigationView.setNavigationUiEnabled(false);
            }
        } catch (Exception e) {
            Log.w("NavigationActivity", "tearDown: setNavigationUiEnabled failed", e);
        }
        try {
            Navigator navigator = this.defaultNavigator;
            if (navigator != null) {
                navigator.getSimulator().unsetUserLocation();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        GlobalVar.isNavigationActive = false;
        GlobalVar.isIsTakeMeHomeNavStarting = false;
        GoogleNavSdkGate.setNavigationActivityOwnsNavigator(false);
        try {
            Navigator navigator2 = this.defaultNavigator;
            if (navigator2 != null) {
                navigator2.stopGuidance();
                this.defaultNavigator.unregisterServiceForNavUpdates();
                removeListners();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onNavigationStop();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.navigationSessionTornDown = true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        cancelNavigation(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleSound(boolean z) {
        if (!z) {
            this.defaultNavigator.setAudioGuidance(0);
        } else {
            this.defaultNavigator.setAudioGuidance(4);
        }
    }

    public void hideRouteLayout() {
        this.topView.setVisibility(8);
        this.bottomView.setVisibility(8);
        this.cancelNavigationBtn.setVisibility(0);
        this.soundbtn.setVisibility(0);
    }

    private void applyNavigationBarInsets(View view, View... viewArr) {
        NavChromeInsets.applyBottomChromeInsets(null, view, viewArr);
    }

    public void showRouteLayout() {
        this.topView.setVisibility(0);
        this.bottomView.setVisibility(0);
        this.cancelNavigationBtn.setVisibility(8);
        this.soundbtn.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.e("NAvigationActivity", "onSavedInstanceState");
        try {
            NavigationView navigationView = this.navigationView;
            if (navigationView != null) {
                navigationView.onSaveInstanceState(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.e("NAvigationActivity", "onResume");
        ClusterNavigationLauncher.clearLaunchNotification(this);
        applyAppThemeToNavigationView();
        try {
            NavigationView navigationView = this.navigationView;
            if (navigationView != null) {
                navigationView.onResume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ensureNavMirroringAfterUnlock();
    }

    private void applyAppThemeToNavigationView() {
        NavigationView navigationView = this.navigationView;
        if (navigationView == null) {
            return;
        }
        try {
            navigationView.setForceNightMode(GlobalVar.appThemeIsDark ? 2 : 1);
        } catch (Exception e) {
            Log.w("NavigationActivity", "applyAppThemeToNavigationView", e);
        }
    }

    private void ensureNavMirroringAfterUnlock() {
        if (MirroringGlobarVar.isWifiConnected) {
            if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION) {
                boolean z = NavApplication.customProjection != null && ((GlobalVar.isGoogleNavigation && NavApplication.customProjection.routeInfoPresentation != null) || !(GlobalVar.isGoogleNavigation || NavApplication.customProjection.routeInfoPresentationMMI == null));
                boolean z2 = NavApplication.streamingHandler != null && NavApplication.streamingHandler.onUdpReady();
                if (z && z2 && MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                    return;
                }
                Log.i("NavigationActivity", "onResume — retry TBT mirroring (post-lock / delayed launch / SoftAP) mirrorReady=" + z + " udpLive=" + z2 + " screen=" + MirroringGlobarVar.currentScreen);
                MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
                waitForServicesAndStartNavMirroring();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceRebuildNavMirroringAfterSoftAp() {
        if (MirroringGlobarVar.isWifiConnected) {
            if (NavApplication.customProjection != null && NavApplication.customProjection.mImageReader != null && (NavApplication.customProjection.routeInfoPresentation != null || NavApplication.customProjection.routeInfoPresentationMMI != null)) {
                Log.i("NavigationActivity", "SoftAP resume — keep live projection, re-announce TBT");
                MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
                MirroringGlobarVar.isOnMirroringPage = true;
                MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
                try {
                    if (NavApplication.streamingHandler == null || NavApplication.streamingHandler.udpServerService == null) {
                        return;
                    }
                    NavApplication.streamingHandler.udpServerService.onScreenChange();
                    return;
                } catch (Exception e) {
                    Log.w("NavigationActivity", "SoftAP re-announce TBT failed", e);
                    return;
                }
            }
            Log.i("NavigationActivity", "SoftAP resume — projection missing, rebuild TBT mirroring");
            MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
            MirroringGlobarVar.isOnMirroringPage = true;
            MirroringGlobarVar.currentScreen = Screens.NONE;
            if (NavApplication.streamingHandler != null) {
                try {
                    NavApplication.streamingHandler.initTcpServer();
                    NavApplication.streamingHandler.initUdpServer();
                } catch (Exception e2) {
                    Log.w("NavigationActivity", "forceRebuild: init sockets failed", e2);
                }
            }
            waitForServicesAndStartNavMirroring();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.e("NAvigationActivity", "onConfiguration changed");
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onConfigurationChanged(configuration);
        }
    }

    private void resetMirroringToSearchScreen(String str) {
        try {
            if (MirroringGlobarVar.isWifiConnected) {
                if (NavApplication.customProjection != null && NavApplication.customProjection.routeInfoPresentation != null) {
                    NavApplication.customProjection.routeInfoPresentation.stopNavigation();
                }
                MirroringPolicy.stopMirroringAfterNavigation(this, str);
            }
        } catch (Exception e) {
            Log.e("NavigationActivity", "resetMirroringToSearchScreen failed", e);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Log.e("NAvigationActivity", "onStart start");
        try {
            if (this.navigationView != null) {
                Log.e("NavigationActivity", "onStartCalled");
                this.navigationView.onStart();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.e("NAvigationActivity", "onPause pause");
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onPause();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Log.e("NAvigationActivity", "onStop stop");
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onStop();
        }
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        Log.e("NavigationActivity", "map ready");
        this.googleMap = googleMap;
        Place place = new Place();
        place.setLat(GlobalVar.lat);
        place.setLng(GlobalVar.lng);
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            googleMap.setMyLocationEnabled(false);
            MirroringPolicy.ensureCellularNetworkForRouting(this);
            intializeNavigationApi();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Log.e("NAvigationActivity", "onDestroy pause");
        tearDownActiveNavigation("onDestroy");
        GlobalVar.isNavigationActive = false;
        GlobalVar.isIsTakeMeHomeNavStarting = false;
        if (!this.skipOnDestroyMirroringReset) {
            resetMirroringToSearchScreen("onDestroy");
        }
        try {
            clearPreviewPolyline();
            this.routePolyline = null;
            unregisterRecieer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast.makeText(this, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchRoute() {
        if (this.googleMap == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchRoute$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchRoute$3() {
        MirroringPolicy.ensureCellularNetworkForRouting(this);
        String strResolveOriginLatLng = resolveOriginLatLng();
        if (strResolveOriginLatLng == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.fetchRoute();
                }
            }, 1000L);
            return;
        }
        String apiKey = GmapUtil.getApiKey();
        String str = "https://maps.googleapis.com/maps/api/directions/json?origin=" + strResolveOriginLatLng + "&destination=" + (GlobalVar.lat + "," + GlobalVar.lng) + "&key=" + apiKey;
        Log.e("NavigationActivity", "fetch route " + str);
        FirebasePerfOkHttpClient.enqueue(new OkHttpClient().newCall(new Request.Builder().url(str).build()), new AnonymousClass6(strResolveOriginLatLng));
    }

    /* JADX INFO: renamed from: com.bajajconnect.gMaps.NavigationActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Callback {
        final /* synthetic */ String val$origin;

        AnonymousClass6(String str) {
            this.val$origin = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Log.e("NavigationActivity", "fetchRoute failed", iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                try {
                    JSONArray jSONArray = new JSONObject(response.body().string()).getJSONArray("routes");
                    if (jSONArray.length() == 0) {
                        Log.e("NavigationActivity", "fetchRoute: no routes in response");
                        return;
                    }
                    final List<LatLng> listDecodePolyline = NavigationActivity.this.decodePolyline(jSONArray.getJSONObject(0).getJSONObject("overview_polyline").getString("points"));
                    NavigationActivity navigationActivity = NavigationActivity.this;
                    final String str = this.val$origin;
                    navigationActivity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$6$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0(listDecodePolyline, str);
                        }
                    });
                } catch (Exception e) {
                    Log.e("NavigationActivity", "fetchRoute parse failed", e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(List list, String str) {
            NavigationActivity.this.drawPreviewPolyline(list, str);
        }
    }

    private String resolveOriginLatLng() {
        if (MirroringGlobarVar.currentLat != null && MirroringGlobarVar.currentLng != null) {
            return MirroringGlobarVar.currentLat + "," + MirroringGlobarVar.currentLng;
        }
        GoogleMap googleMap = this.googleMap;
        if (googleMap == null || !googleMap.isMyLocationEnabled()) {
            return null;
        }
        try {
            Location myLocation = this.googleMap.getMyLocation();
            if (myLocation == null) {
                return null;
            }
            return myLocation.getLatitude() + "," + myLocation.getLongitude();
        } catch (Exception e) {
            Log.e("NavigationActivity", "resolveOriginLatLng: getMyLocation failed", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawPreviewPolyline(List<LatLng> list, String str) {
        if (this.googleMap == null || list == null || list.isEmpty()) {
            return;
        }
        clearPreviewPolyline();
        PolylineOptions polylineOptionsWidth = new PolylineOptions().addAll(list).color(-16776961).width(10.0f);
        this.routePolyline = polylineOptionsWidth;
        this.previewPolyline = this.googleMap.addPolyline(polylineOptionsWidth);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<LatLng> it2 = list.iterator();
        while (it2.hasNext()) {
            builder.include(it2.next());
        }
        getCurrentAddress(str);
        LatLngBounds latLngBoundsBuild = builder.build();
        this.latLngBounds = latLngBoundsBuild;
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, 100));
        startMirroringWhenRouteReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreviewPolyline() {
        Polyline polyline = this.previewPolyline;
        if (polyline != null) {
            polyline.remove();
            this.previewPolyline = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureLiveRoutePolyline(final String str) {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null || this.googleMap == null) {
            return;
        }
        try {
            List<RouteSegment> routeSegments = navigator.getRouteSegments();
            if (routeSegments != null && !routeSegments.isEmpty()) {
                final ArrayList arrayList = new ArrayList();
                Iterator<RouteSegment> it2 = routeSegments.iterator();
                while (it2.hasNext()) {
                    List<LatLng> latLngs = it2.next().getLatLngs();
                    if (latLngs != null && !latLngs.isEmpty()) {
                        arrayList.addAll(latLngs);
                    }
                }
                if (arrayList.size() >= 2) {
                    runOnUiThread(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$ensureLiveRoutePolyline$4(arrayList, str);
                        }
                    });
                    return;
                }
                Log.w("NavigationActivity", "ensureLiveRoutePolyline <2 pts (" + str + ")");
                return;
            }
            Log.w("NavigationActivity", "ensureLiveRoutePolyline empty segments (" + str + ")");
        } catch (Exception e) {
            Log.w("NavigationActivity", "ensureLiveRoutePolyline failed (" + str + ")", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureLiveRoutePolyline$4(List list, String str) {
        if (this.googleMap == null) {
            return;
        }
        clearPreviewPolyline();
        PolylineOptions polylineOptionsWidth = new PolylineOptions().addAll(list).color(-16776961).width(10.0f);
        this.routePolyline = polylineOptionsWidth;
        this.previewPolyline = this.googleMap.addPolyline(polylineOptionsWidth);
        Log.d("NavigationActivity", "ensureLiveRoutePolyline " + str + " pts=" + list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRouteOnMap() {
        if (this.navigationView == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showRouteOnMap$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRouteOnMap$6() {
        this.navigationView.setNavigationUiEnabled(true);
        this.navigationView.setRecenterButtonEnabled(false);
        if (GlobalVar.isNavigationActive) {
            return;
        }
        try {
            this.googleMap.setMyLocationEnabled(false);
            this.navigationView.showRouteOverview();
        } catch (Exception e) {
            Log.e("NavigationActivity", "showRouteOverview failed", e);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showRouteOnMap$5();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRouteOnMap$5() {
        NavigationView navigationView;
        if (GlobalVar.isNavigationActive || (navigationView = this.navigationView) == null) {
            return;
        }
        try {
            navigationView.showRouteOverview();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.gMaps.NavigationActivity$7, reason: invalid class name */
    class AnonymousClass7 implements GmapUtil.ResultListener<String> {
        @Override // com.bajajconnect.gMaps.util.GmapUtil.ResultListener
        public void fail(String str) {
        }

        AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$success$0(String str) {
            NavigationActivity.this.textViewFrom.setText(str);
        }

        @Override // com.bajajconnect.gMaps.util.GmapUtil.ResultListener
        public void success(final String str) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$success$0(str);
                }
            });
        }
    }

    public void getCurrentAddress(String str) {
        GmapUtil.reverseGeoCode(str, new AnonymousClass7());
    }

    public List<LatLng> decodePolyline(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i = i3 + 1;
                int iCharAt = str.charAt(i3) - '?';
                i6 |= (iCharAt & 31) << i7;
                i7 += 5;
                if (iCharAt < 32) {
                    break;
                }
                i3 = i;
            }
            int i8 = ((i6 & 1) != 0 ? ~(i6 >> 1) : i6 >> 1) + i4;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                i2 = i + 1;
                int iCharAt2 = str.charAt(i) - '?';
                i9 |= (iCharAt2 & 31) << i10;
                i10 += 5;
                if (iCharAt2 < 32) {
                    break;
                }
                i = i2;
            }
            int i11 = i9 & 1;
            int i12 = i9 >> 1;
            if (i11 != 0) {
                i12 = ~i12;
            }
            i5 += i12;
            arrayList.add(new LatLng(((double) i8) / 100000.0d, ((double) i5) / 100000.0d));
            i4 = i8;
            i3 = i2;
        }
        return arrayList;
    }

    private void navigateToPlace(Place place, final Boolean bool) {
        ensureNavigatorListeners();
        this.holdCellularForRouteRequest = true;
        final int i = this.routeRequestGeneration;
        if (MirroringPolicy.deferMirroringUntilNavigation() && MirroringGlobarVar.isWifiConnected) {
            if (!MirroringPolicy.ensureCellularNetworkForRouting(this)) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$navigateToPlace$7(bool, i);
                    }
                }, MIRROR_SERVICE_RETRY_MS);
                return;
            }
        } else {
            MirroringPolicy.ensureCellularNetworkForRouting(this);
        }
        lambda$navigateToPlace$7(bool, i);
    }

    private void requestRouteToDestination(Boolean bool) {
        lambda$navigateToPlace$7(bool, this.routeRequestGeneration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestRouteToDestination, reason: merged with bridge method [inline-methods] */
    public void lambda$navigateToPlace$7(Boolean bool, int i) {
        if (this.defaultNavigator == null) {
            Log.e("NavigationActivity", "requestRouteToDestination: navigator is null");
            return;
        }
        if (i != this.routeRequestGeneration) {
            Log.w("NavigationActivity", "skip setDestination — superseded gen=" + i);
            return;
        }
        this.holdCellularForRouteRequest = true;
        try {
            MirroringPolicy.ensureCellularNetworkForRouting(this);
        } catch (Exception e) {
            Log.w("NavigationActivity", "ensureCellular before setDestination", e);
        }
        Waypoint waypointBuild = Waypoint.builder().setLatLng(GlobalVar.lat.doubleValue(), GlobalVar.lng.doubleValue()).build();
        RoutingOptions routingOptions = new RoutingOptions();
        routingOptions.routingStrategy(1);
        routingOptions.travelMode(3);
        routingOptions.alternateRoutesStrategy(AlternateRoutesStrategy.SHOW_NONE);
        this.defaultNavigator.setDestination(waypointBuild, routingOptions, new DisplayOptions()).setOnResultListener(new AnonymousClass8(i, bool));
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity.9
            @Override // java.lang.Runnable
            public void run() {
                NavigationActivity.this.updateTimeAndDistance();
            }
        }, 1000L);
    }

    /* JADX INFO: renamed from: com.bajajconnect.gMaps.NavigationActivity$8, reason: invalid class name */
    class AnonymousClass8 implements ListenableResultFuture.OnResultListener<Navigator.RouteStatus> {
        final /* synthetic */ int val$generation;
        final /* synthetic */ Boolean val$reshowRoute;

        AnonymousClass8(int i, Boolean bool) {
            this.val$generation = i;
            this.val$reshowRoute = bool;
        }

        @Override // com.google.android.libraries.navigation.ListenableResultFuture.OnResultListener
        public void onResult(Navigator.RouteStatus routeStatus) {
            final String str;
            if (this.val$generation != NavigationActivity.this.routeRequestGeneration) {
                Log.w("NavigationActivity", "drop stale route result gen=" + this.val$generation + " current=" + NavigationActivity.this.routeRequestGeneration + " status=" + routeStatus);
                return;
            }
            if (AnonymousClass17.$SwitchMap$com$google$android$libraries$navigation$Navigator$RouteStatus[routeStatus.ordinal()] == 1) {
                NavigationActivity.this.clearPreviewPolyline();
                NavigationActivity.this.showRouteOnMap();
                NavigationActivity.this.startMirroringWhenRouteReady();
                if (this.val$reshowRoute.booleanValue()) {
                    NavigationActivity.this.updateTimeAndDistance();
                    NavigationActivity.this.holdCellularForRouteRequest = false;
                    return;
                }
                TimeAndDistance currentTimeAndDistance = NavigationActivity.this.defaultNavigator.getCurrentTimeAndDistance();
                final String string = NavigationActivity.this.getTimeFormatted(currentTimeAndDistance.getSeconds()).toString();
                int meters = currentTimeAndDistance.getMeters();
                if (meters > 1000) {
                    str = (meters / 1000) + "kms";
                } else {
                    str = meters + TurfConstants.UNIT_METERS;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NavigationActivity.this.time.setText(string);
                        NavigationActivity.this.distanceTv.setText(str);
                    }
                });
                Log.i("NavigationActivity", "route OK — auto-starting guidance (skip native preview) takeMeHome=" + NavigationActivity.this.isTakeMeHome);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$8$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResult$0();
                    }
                });
            }
            if (routeStatus != Navigator.RouteStatus.OK) {
                Log.e("NavigationActivity", "route not found " + routeStatus.name() + " attempt=" + (NavigationActivity.this.routeRequestAttempts + 1) + " gen=" + this.val$generation);
                if ((routeStatus == Navigator.RouteStatus.QUOTA_CHECK_FAILED || routeStatus == Navigator.RouteStatus.ROUTE_CANCELED) && NavigationActivity.this.routeRequestAttempts < 5) {
                    NavigationActivity.this.routeRequestAttempts++;
                    long j = ((long) NavigationActivity.this.routeRequestAttempts) * 700;
                    Log.i("NavigationActivity", "retry setDestination in " + j + "ms");
                    Handler handler = new Handler(Looper.getMainLooper());
                    final int i = this.val$generation;
                    final Boolean bool = this.val$reshowRoute;
                    handler.postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$8$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResult$1(i, bool);
                        }
                    }, j);
                    return;
                }
                if (NavigationActivity.this.routeRequestAttempts < 7) {
                    NavigationActivity.this.routeRequestAttempts++;
                    Log.w("NavigationActivity", "final Nav SDK retry after cellular rebind");
                    Handler handler2 = new Handler(Looper.getMainLooper());
                    final int i2 = this.val$generation;
                    final Boolean bool2 = this.val$reshowRoute;
                    handler2.postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$8$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResult$2(i2, bool2);
                        }
                    }, 1200L);
                    return;
                }
                Log.e("NavigationActivity", "Nav SDK route failed — REST polyline only (no guidance)");
                NavigationActivity.this.holdCellularForRouteRequest = false;
                NavigationActivity.this.fetchRoute();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$0() {
            NavigationActivity.this.startNavigation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$1(int i, Boolean bool) {
            if (i != NavigationActivity.this.routeRequestGeneration) {
                return;
            }
            try {
                MirroringPolicy.ensureCellularNetworkForRouting(NavigationActivity.this);
            } catch (Exception e) {
                Log.w("NavigationActivity", "ensureCellular before retry", e);
            }
            NavigationActivity.this.lambda$navigateToPlace$7(bool, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$2(int i, Boolean bool) {
            if (i != NavigationActivity.this.routeRequestGeneration) {
                return;
            }
            try {
                MirroringPolicy.ensureCellularNetworkForRouting(NavigationActivity.this);
            } catch (Exception unused) {
            }
            NavigationActivity.this.lambda$navigateToPlace$7(bool, i);
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.gMaps.NavigationActivity$17, reason: invalid class name */
    static /* synthetic */ class AnonymousClass17 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$libraries$navigation$Navigator$RouteStatus;

        static {
            int[] iArr = new int[Navigator.RouteStatus.values().length];
            $SwitchMap$com$google$android$libraries$navigation$Navigator$RouteStatus = iArr;
            try {
                iArr[Navigator.RouteStatus.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeAndDistance() {
        String str;
        try {
            TimeAndDistance currentTimeAndDistance = this.defaultNavigator.getCurrentTimeAndDistance();
            if (currentTimeAndDistance == null) {
                int i = this.timeDistanceRetryCount;
                this.timeDistanceRetryCount = i + 1;
                if (i < 6) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.updateTimeAndDistance();
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            this.timeDistanceRetryCount = 0;
            String string = getTimeFormatted(currentTimeAndDistance.getSeconds()).toString();
            int meters = currentTimeAndDistance.getMeters();
            if (meters > 1000) {
                str = (meters / 1000) + "kms";
            } else {
                str = meters + TurfConstants.UNIT_METERS;
            }
            this.time.setText(string);
            this.distanceTv.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StringBuilder getTimeFormatted(int i) {
        int iMax = Math.max(i, 0);
        int i2 = iMax / 3600;
        int iRound = (int) Math.round(((double) (iMax % 3600)) / 60.0d);
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(i2);
            sb.append(" hr ");
        }
        if (iRound > 0 && i >= 60) {
            sb.append(iRound);
            sb.append(" min ");
        }
        if (iMax < 60) {
            sb.append(iMax);
            sb.append(" sec ");
        }
        return sb;
    }

    private void startRoutePreviewTbt() {
        stopRoutePreviewTbt();
        this.isRoutePreviewTbtActive = true;
        this.routePreviewTbtHandler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity.10
            @Override // java.lang.Runnable
            public void run() {
                TimeAndDistance currentTimeAndDistance;
                if (!NavigationActivity.this.isRoutePreviewTbtActive || NavigationActivity.this.defaultNavigator == null) {
                    return;
                }
                try {
                    if (GlobalVar.isBlueToothConnected && GlobalVar.TBT_INFO_CHAR != null && (currentTimeAndDistance = NavigationActivity.this.defaultNavigator.getCurrentTimeAndDistance()) != null) {
                        int seconds = currentTimeAndDistance.getSeconds();
                        int meters = currentTimeAndDistance.getMeters();
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(13, seconds);
                        int i = calendar.get(9) == 0 ? 1 : 0;
                        int i2 = calendar.get(10);
                        if (i2 == 0) {
                            i2 = 12;
                        }
                        int i3 = calendar.get(12);
                        double d = meters;
                        byte[] distance = NavigationHelper.formatDistance(d);
                        byte[] distance2 = NavigationHelper.formatDistance(d);
                        int value = PrimaryTurns.STRAIGHT.getValue();
                        byte[] bArr = new byte[48];
                        bArr[0] = 1;
                        byte b = (byte) (((byte) (distance[0] << 4)) | 1);
                        bArr[0] = b;
                        bArr[0] = (byte) (((byte) ((i ^ 1) << 7)) | b);
                        bArr[1] = (byte) value;
                        bArr[2] = distance[4];
                        bArr[3] = distance[3];
                        bArr[4] = distance[2];
                        bArr[5] = distance[1];
                        bArr[6] = (byte) i3;
                        bArr[7] = (byte) i2;
                        bArr[8] = distance2[4];
                        bArr[9] = distance2[3];
                        bArr[10] = distance2[2];
                        bArr[11] = distance2[1];
                        byte b2 = distance2[0];
                        bArr[12] = b2;
                        bArr[12] = (byte) (b2 | ((byte) (GlobalVar.gpsStatus.getValue() << 2)));
                        bArr[14] = (byte) 13;
                        System.arraycopy("Route preview".getBytes(), 0, bArr, 15, 13);
                        int i4 = 0;
                        for (int i5 = 0; i5 < 47; i5++) {
                            i4 = (i4 + bArr[i5]) & 255;
                        }
                        bArr[47] = (byte) i4;
                        BleService.prepareCharAndWrite(GlobalVar.TBT_INFO_CHAR, bArr);
                        StringBuilder sb = new StringBuilder();
                        sb.append("RoutePreview TBT -> ETA: ");
                        sb.append(i2);
                        sb.append(":");
                        sb.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3)));
                        sb.append(i != 0 ? " AM" : " PM");
                        sb.append(" | totalDist=");
                        sb.append(meters);
                        sb.append("m");
                        Log.d("NavigationActivity", sb.toString());
                    }
                } catch (Exception e) {
                    Log.e("NavigationActivity", "RoutePreview TBT error: " + e.getMessage());
                }
                if (NavigationActivity.this.isRoutePreviewTbtActive) {
                    NavigationActivity.this.routePreviewTbtHandler.postDelayed(this, 1000L);
                }
            }
        };
        this.routePreviewTbtRunnable = runnable;
        this.routePreviewTbtHandler.post(runnable);
        Log.d("NavigationActivity", "Started route preview TBT sending");
    }

    private void stopRoutePreviewTbt() {
        Runnable runnable;
        this.isRoutePreviewTbtActive = false;
        Handler handler = this.routePreviewTbtHandler;
        if (handler == null || (runnable = this.routePreviewTbtRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        Log.d("NavigationActivity", "Stopped route preview TBT sending");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureNavigatorListeners() {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null || this.navigatorListenersAttached) {
            return;
        }
        navigator.addNavigationSessionListener(this.navigationSessionListener);
        this.defaultNavigator.addArrivalListener(this.arrivalListener);
        this.defaultNavigator.addReroutingListener(this.reroutingListener);
        this.defaultNavigator.addRouteChangedListener(this.routeChangedListener);
        this.navigatorListenersAttached = true;
    }

    private void addListners() {
        ensureNavigatorListeners();
    }

    private void removeListners() {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null || !this.navigatorListenersAttached) {
            return;
        }
        navigator.removeNavigationSessionListener(this.navigationSessionListener);
        this.defaultNavigator.removeArrivalListener(this.arrivalListener);
        this.defaultNavigator.removeReroutingListener(this.reroutingListener);
        this.defaultNavigator.removeRouteChangedListener(this.routeChangedListener);
        this.navigatorListenersAttached = false;
    }

    private void registerListners() {
        if (this.defaultNavigator.registerServiceForNavUpdates(getPackageName(), NavInfoReceivingService.class.getName(), Integer.MAX_VALUE)) {
            Log.e("NavigationActivity", "Successfully registered service for nav updates");
            this.isNavUpdateRecieverServiceRegistered = true;
        } else {
            Log.e("NavigationActivity", "Failed registered service for nav updates");
            this.isNavUpdateRecieverServiceRegistered = false;
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.gMaps.NavigationActivity$15, reason: invalid class name */
    class AnonymousClass15 implements NavigationApi.NavigatorListener {
        AnonymousClass15() {
        }

        @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
        public void onError(int i) {
            if (i == 1) {
                NavigationActivity.this.showToast("Error loading Navigation API: Your API key is invalid or not authorized to use Navigation.");
            } else {
                if (i != 2) {
                    return;
                }
                NavigationActivity.this.showToast("Error loading Navigation API: User did not accept the Navigation Terms of Use.");
            }
        }

        @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
        public void onNavigatorReady(Navigator navigator) {
            Log.d("NAvigationActivity", "OnNavigator ready");
            NavigationActivity.this.defaultNavigator = navigator;
            NavigationActivity.this.timeDistanceRetryCount = 0;
            NavigationActivity.this.ensureNavigatorListeners();
            NavigationActivity.this.navigationView.setNavigationUiEnabled(true);
            NavigationActivity.this.navigationView.setRecenterButtonEnabled(false);
            NavigationActivity.this.navigationView.setTrafficIncidentCardsEnabled(false);
            NavigationActivity.this.navigationView.setTrafficPromptsEnabled(false);
            navigator.setHeadsUpNotificationEnabled(false);
            navigator.setTaskRemovedBehavior(1);
            Handler handler = new Handler(Looper.getMainLooper());
            final NavigationActivity navigationActivity = NavigationActivity.this;
            handler.post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$15$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    navigationActivity.scheduleInitialRouteAfterReady();
                }
            });
        }
    }

    private void intializeNavigationApi() {
        NavigationApi.getNavigator(this, new AnonymousClass15());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleInitialRouteAfterReady() {
        if (isFinishing() || this.defaultNavigator == null) {
            return;
        }
        boolean zEnsureCellularNetworkForRouting = false;
        this.routeRequestAttempts = 0;
        final int i = this.routeRequestGeneration + 1;
        this.routeRequestGeneration = i;
        this.holdCellularForRouteRequest = true;
        final Context applicationContext = getApplicationContext();
        try {
            zEnsureCellularNetworkForRouting = MirroringPolicy.ensureCellularNetworkForRouting(this);
        } catch (Exception e) {
            Log.w("NavigationActivity", "ensureCellular sync before initial route", e);
        }
        if (zEnsureCellularNetworkForRouting) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleInitialRouteAfterReady$8(i);
                }
            });
        } else {
            new Thread(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleInitialRouteAfterReady$10(applicationContext, i);
                }
            }, "nav-initial-route").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleInitialRouteAfterReady$10(Context context, final int i) {
        try {
            MirroringPolicy.ensureCellularNetworkForRouting(context);
        } catch (Exception e) {
            Log.w("NavigationActivity", "ensureCellular before initial route", e);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleInitialRouteAfterReady$9(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: continueInitialRouteAfterCellular, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$scheduleInitialRouteAfterReady$9(int i) {
        if (isFinishing() || this.defaultNavigator == null) {
            return;
        }
        if (i != this.routeRequestGeneration) {
            Log.w("NavigationActivity", "drop superseded initial route gen=" + i);
            return;
        }
        if (canReuseExistingNavigatorRouteForGlobalDestination()) {
            try {
                TimeAndDistance currentTimeAndDistance = this.defaultNavigator.getCurrentTimeAndDistance();
                StringBuilder sb = new StringBuilder("reusing Navigator route — matches GlobalVar dest, meters=");
                sb.append(currentTimeAndDistance != null ? currentTimeAndDistance.getMeters() : -1);
                Log.i("NavigationActivity", sb.toString());
                clearPreviewPolyline();
                showRouteOnMap();
                startMirroringWhenRouteReady();
                updateTimeAndDistance();
                startNavigation();
                return;
            } catch (Exception e) {
                Log.w("NavigationActivity", "reuse preview route failed", e);
            }
        }
        try {
            this.defaultNavigator.clearDestinations();
        } catch (Exception e2) {
            Log.w("NavigationActivity", "clearDestinations before new route", e2);
        }
        lambda$navigateToPlace$7(false, i);
    }

    private boolean canReuseExistingNavigatorRouteForGlobalDestination() {
        TimeAndDistance currentTimeAndDistance;
        List<RouteSegment> routeSegments;
        LatLng latLng;
        try {
            Navigator navigator = this.defaultNavigator;
            if (navigator != null && (currentTimeAndDistance = navigator.getCurrentTimeAndDistance()) != null && currentTimeAndDistance.getMeters() > 0 && ((GlobalVar.lat.doubleValue() != 0.0d || GlobalVar.lng.doubleValue() != 0.0d) && (routeSegments = this.defaultNavigator.getRouteSegments()) != null && !routeSegments.isEmpty())) {
                boolean z = true;
                int size = routeSegments.size() - 1;
                while (true) {
                    if (size >= 0) {
                        List<LatLng> latLngs = routeSegments.get(size).getLatLngs();
                        if (latLngs != null && !latLngs.isEmpty()) {
                            latLng = latLngs.get(latLngs.size() - 1);
                            break;
                        }
                        size--;
                    } else {
                        latLng = null;
                        break;
                    }
                }
                if (latLng == null) {
                    return false;
                }
                float[] fArr = new float[1];
                Location.distanceBetween(latLng.latitude, latLng.longitude, GlobalVar.lat.doubleValue(), GlobalVar.lng.doubleValue(), fArr);
                if (fArr[0] >= 100.0f) {
                    z = false;
                }
                Log.i("NavigationActivity", "reuse dest check end=" + latLng.latitude + "," + latLng.longitude + " target=" + GlobalVar.lat + "," + GlobalVar.lng + " distM=" + fArr[0] + " match=" + z);
                return z;
            }
            return false;
        } catch (Exception e) {
            Log.w("NavigationActivity", "canReuseExistingNavigatorRouteForGlobalDestination", e);
            return false;
        }
    }

    public void registerBroadcastReciever() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MirroringGlobarVar.ACTION_STOP_NAVIGATION);
        intentFilter.addAction(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION);
        intentFilter.addAction(MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mMessageReceiver, intentFilter);
    }

    public void unregisterRecieer() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
    }

    /* JADX INFO: renamed from: com.bajajconnect.gMaps.NavigationActivity$16, reason: invalid class name */
    class AnonymousClass16 extends BroadcastReceiver {
        AnonymousClass16() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.e("RouteFragment", "intent recieved");
            if (intent.getAction().equals(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION)) {
                if (MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO && Objects.equals(intent.getAction(), MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION)) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NavigationActivity.this.startNavigation();
                        }
                    });
                    return;
                }
                return;
            }
            if (intent.getAction().equals(MirroringGlobarVar.ACTION_STOP_NAVIGATION)) {
                NavigationActivity.this.cancelNavigation(true);
                return;
            }
            if (intent.getAction().equals(MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED)) {
                Log.i("NavigationActivity", "SoftAP reconnected — force rebuild TBT mirroring");
                Handler handler = new Handler(Looper.getMainLooper());
                final NavigationActivity navigationActivity = NavigationActivity.this;
                handler.post(new Runnable() { // from class: com.bajajconnect.gMaps.NavigationActivity$16$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        navigationActivity.forceRebuildNavMirroringAfterSoftAp();
                    }
                });
                return;
            }
            if (intent.getAction().equals(GlobalVar.takeMeHomeActionStart)) {
                NavigationActivity.this.startNavigation();
            }
        }
    }
}
