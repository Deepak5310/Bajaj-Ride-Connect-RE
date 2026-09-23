package com.bajajconnect.navigate;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.gMaps.ClusterNavigationLauncher;
import com.bajajconnect.navigate.fragment.HomeFragment;
import com.bajajconnect.navigate.fragment.NavigationFragment;
import com.bajajconnect.navigate.fragment.RouteFragment;
import com.bajajconnect.navigate.maps.plugins.BearingIconPlugin;
import com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin;
import com.bajajconnect.navigate.maps.plugins.MapEventsPlugin;
import com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin;
import com.bajajconnect.navigate.maps.traffic.TrafficPlugin;
import com.bajajconnect.navigate.utils.MapplsSessionHelper;
import com.bajajconnect.navigate.utils.NavigationLocationEngine;
import com.bajajconnect.utils.NavCancelledEventBridge;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.facebook.react.bridge.WritableMap;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.annotations.MarkerOptions;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentActivationOptions;
import com.mappls.sdk.maps.location.LocationComponentOptions;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.maps.location.permissions.PermissionsListener;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class HomeActivity extends BaseActivity implements MapplsMap.OnMapLongClickListener, MapplsMap.InfoWindowAdapter, FragmentManager.OnBackStackChangedListener, LocationEngineCallback<LocationEngineResult>, PermissionsListener {
    public static int DEFAULT_BOTTOM_PADDING = 0;
    public static int DEFAULT_PADDING = 0;
    private static final int MAPPLS_MAX_TRIP_SAMPLES = 400;
    private static final float MAPPLS_TRIP_SAMPLE_MIN_DISTANCE_M = 8.0f;
    private static final long MAPPLS_TRIP_SAMPLE_MIN_INTERVAL_MS = 2000;
    BearingIconPlugin _bearingIconPlugin;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f30app;
    private Fragment currentFragment;
    private DirectionPolylinePlugin directionPolylinePlugin;
    private boolean firstFix;
    private LocationEngine locationEngine;
    private MapEventsPlugin mapEventsPlugin;
    public MapplsMap mapplsMap;
    private NavigationLocationEngine navigationLocationEngine;
    private PermissionsManager permissionsManager;
    private RouteArrowPlugin routeArrowPlugin;
    boolean isVisible = false;
    Handler backStackHandler = new Handler();
    public boolean isTakeMeHome = false;
    Runnable backStackRunnable = new Runnable() { // from class: com.bajajconnect.navigate.HomeActivity$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private boolean isHomeFragmentStarted = false;
    private boolean mapplsGuidanceHadStarted = false;
    private long mapplsNavSessionStartMs = 0;
    private Double mapplsInitialRemainingMeters = null;
    private Double mapplsLastRemainingMeters = null;
    private final List<double[]> mapplsTripSamples = new ArrayList();
    private long mapplsLastTripSampleMs = 0;
    private Location mapplsLastTripSampleLocation = null;
    private boolean mapplsNavCancelledEmitted = false;

    @Override // com.mappls.sdk.maps.MapplsMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onFailure(Exception exc) {
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        try {
            onBackStackChangedWithDelay();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    private void setupUI() {
        View viewFindViewById;
        int identifier = getResources().getIdentifier("move_to_current_location", "id", getPackageName());
        if (identifier == 0 || (viewFindViewById = findViewById(identifier)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public NavApplication getMyApplication() {
        return NavApplication.forFragments();
    }

    public NavigationApplication getNavigationApplication() {
        NavigationApplication navigationApplication = NavApplication.navigationApplication();
        return navigationApplication != null ? navigationApplication : (NavigationApplication) getApplication();
    }

    @Override // com.bajajconnect.navigate.BaseActivity, com.mappls.sdk.navigation.activities.MapActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        }
        getWindow().addFlags(524288);
        getWindow().addFlags(2621569);
        super.onCreate(bundle);
        ClusterNavigationLauncher.clearLaunchNotification(this);
        if (Build.VERSION.SDK_INT < 27) {
            getWindow().addFlags(2621568);
        }
        PowerManager powerManager = (PowerManager) getSystemService("power");
        if (powerManager != null && !powerManager.isInteractive()) {
            powerManager.newWakeLock(268435466, "BajajRideConnect:WakeLock").acquire(3000L);
        }
        String action = getIntent().getAction();
        this.isTakeMeHome = action != null && action.equals(GlobalVar.takeMeHomeActionStart);
        try {
            this.f30app = getMyApplication();
            DEFAULT_PADDING = (int) getResources().getDimension(R.dimen.default_map_padding);
            DEFAULT_BOTTOM_PADDING = (int) getResources().getDimension(R.dimen.default_map_bottom_padding);
            this.navigationLocationEngine = new NavigationLocationEngine();
            getSupportFragmentManager().addOnBackStackChangedListener(this);
            setupUI();
        } catch (Exception unused) {
        }
        MapplsNavigationHelper.getInstance().init(getNavigationApplication());
        MapplsSessionHelper.applyBuildConfigCredentials();
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(HomeActivity.class);
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        MapplsNavigationHelper.getInstance().setNavigationEventEnabled(true);
        MapplsNavigationHelper.getInstance().setMute(false);
        MapplsNavigationHelper.getInstance().setCongestionDelayEventEnabled(true);
        MapplsNavigationHelper.getInstance().showRoadConditionsEvents(true);
        MapplsNavigationHelper.getInstance().showSafetyEvents(true);
        MapplsNavigationHelper.getInstance().showTrafficEvents(true);
        MapplsNavigationHelper.getInstance().setNavigationEventAudioPromptEnabled(true);
        MapplsNavigationHelper.getInstance().speakRoadConditionsEvents(true);
        MapplsNavigationHelper.getInstance().speakSafetyEvents(true);
        MapplsNavigationHelper.getInstance().speakTrafficEvents(true);
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        Mappls.getInstance(this);
        showDestinationMarker();
        navigateTo(HomeFragment.newInstance(GlobalVar.locationString), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDestinationMarker() {
        if (this.mapplsMap != null) {
            NavApplication navApplication = this.f30app;
            ELocation eLocation = navApplication != null ? navApplication.getELocation() : NavApplication.eLocation;
            if (eLocation != null) {
                if (eLocation.mapplsPin != null) {
                    this.mapplsMap.addMarker(new MarkerOptions().mapplsPin(eLocation.mapplsPin));
                } else if (eLocation.latitude != null && eLocation.longitude != null) {
                    this.mapplsMap.addMarker(new MarkerOptions().position(new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue())));
                }
            }
            if (GlobalVar.waypoints == null || GlobalVar.waypoints.isEmpty()) {
                return;
            }
            for (int i = 0; i < GlobalVar.waypoints.size(); i++) {
                this.mapplsMap.addMarker(new MarkerOptions().mapplsPin(GlobalVar.waypoints.get(i).mapplsPin));
            }
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.HomeActivity.1
            @Override // java.lang.Runnable
            public void run() {
                HomeActivity.this.showDestinationMarker();
            }
        }, 1000L);
    }

    private String getAtlasClientId() {
        return "96dHZVzsAusdFSRGu047EP1OFqsfrwiJ19XJyUx0RRyUz35b0PgtCrbotg-HXvqrPZrmnvVYanbgDngvVX3S_w==";
    }

    private String getAtlasClientSecret() {
        return "lrFxI-iSEg8ktludBF9Ct_cKzeK5YAIgJuuvNwpTKIpmZZAMy7EwOfCSwYTOrEJwt78FT46APVqk-_mEDwVhMG2AeSda1vxG";
    }

    private String getMapSDKKey() {
        return "4987143528819d02c77104f5ed70f3b3";
    }

    private String getRestAPIKey() {
        return "4987143528819d02c77104f5ed70f3b3";
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onSuccess(LocationEngineResult locationEngineResult) {
        if (locationEngineResult != null) {
            Location lastLocation = locationEngineResult.getLastLocation();
            Timber.i("onLocationChanged", new Object[0]);
            if (lastLocation != null) {
                try {
                    if (lastLocation.getLatitude() <= 0.0d) {
                        return;
                    }
                    Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("RouteFragment");
                    if (!this.firstFix && (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isVisible())) {
                        this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastLocation), 16.0d), 500);
                        this.firstFix = true;
                        Fragment fragment = this.currentFragment;
                        if (fragment != null) {
                            ((HomeFragment) fragment).getReverseGeoCode(Double.valueOf(lastLocation.getLatitude()), Double.valueOf(lastLocation.getLongitude()));
                        }
                    }
                    this.f30app.setCurrentLocation(lastLocation);
                } catch (Exception unused) {
                }
            }
        }
    }

    public DirectionPolylinePlugin getDirectionPolylinePlugin() {
        return this.directionPolylinePlugin;
    }

    @Override // com.mappls.sdk.navigation.activities.MapActivity
    public MapView getMapView() {
        return this.mapView;
    }

    public NavLocation getUserLocation() {
        if (this.f30app.getCurrentLocation() == null) {
            return null;
        }
        NavLocation navLocation = new NavLocation("router");
        navLocation.setLatitude(this.f30app.getCurrentLocation().getLatitude());
        navLocation.setLongitude(this.f30app.getCurrentLocation().getLongitude());
        return navLocation;
    }

    public void clearPOIs() {
        try {
            MapplsMap mapplsMap = this.mapplsMap;
            if (mapplsMap == null) {
                return;
            }
            mapplsMap.removeAnnotations();
            DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
            if (directionPolylinePlugin != null) {
                directionPolylinePlugin.removeAllData();
            }
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapLongClickListener
    public boolean onMapLongClick(LatLng latLng) {
        if (!(fragmentOnTopOfStack() instanceof HomeFragment)) {
            return false;
        }
        latLng.getLatitude();
        return false;
    }

    Fragment fragmentOnTopOfStack() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount() - 1;
        if (backStackEntryCount < 0) {
            return null;
        }
        return getSupportFragmentManager().findFragmentByTag(getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount).getName());
    }

    Fragment getFragmentOnTopOfBackStack() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount() - 1;
        if (backStackEntryCount < 0) {
            return null;
        }
        String name = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount).getName();
        Timber.i(name, " fragment Tag");
        return getSupportFragmentManager().findFragmentByTag(name);
    }

    private void onBackStackChangedWithDelay() {
        Fragment fragmentOnTopOfBackStack = getFragmentOnTopOfBackStack();
        this.currentFragment = fragmentOnTopOfBackStack;
        if (!(fragmentOnTopOfBackStack instanceof RouteFragment) && !(fragmentOnTopOfBackStack instanceof NavigationFragment) && this.directionPolylinePlugin != null) {
            Log.e("HomeActivtiy", "remove all data");
            this.directionPolylinePlugin.removeAllData();
            this.directionPolylinePlugin.setEnabled(false);
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        this.backStackHandler.removeCallbacksAndMessages(null);
        this.backStackHandler.postDelayed(this.backStackRunnable, 100L);
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        Timber.d("map loading failed with code " + i + " and message " + str, new Object[0]);
        GlobalVar.isIsTakeMeHomeNavStarting = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableLocationComponent(Style style) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            LocationComponentOptions locationComponentOptionsBuild = LocationComponentOptions.builder(this).trackingGesturesManagement(true).accuracyAlpha(0.0f).accuracyColor(ContextCompat.getColor(this, R.color.accuracy_green)).build();
            LocationComponent locationComponent = this.mapplsMap.getLocationComponent();
            locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(this, style).locationComponentOptions(locationComponentOptionsBuild).build());
            locationComponent.setLocationComponentEnabled(true);
            this.locationEngine = locationComponent.getLocationEngine();
            this.locationEngine.requestLocationUpdates(new LocationEngineRequest.Builder(1000L).setPriority(0).setFastestInterval(100L).build(), this, getMainLooper());
            locationComponent.setCameraMode(24);
            locationComponent.setRenderMode(4);
            return;
        }
        PermissionsManager permissionsManager = new PermissionsManager(this);
        this.permissionsManager = permissionsManager;
        permissionsManager.requestLocationPermissions(this);
    }

    public MapplsMap getMapboxMap() {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            return mapplsMap;
        }
        return null;
    }

    @Override // com.mappls.sdk.navigation.activities.MapActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LocationEngine locationEngine = this.locationEngine;
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates(this);
        }
        try {
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onNavigationStop();
            }
            MapplsNavigationHelper.getInstance().stopNavigation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMapplsGuidanceStarted() {
        this.mapplsGuidanceHadStarted = true;
        this.mapplsNavSessionStartMs = System.currentTimeMillis();
        this.mapplsInitialRemainingMeters = null;
        this.mapplsLastRemainingMeters = null;
        this.mapplsTripSamples.clear();
        this.mapplsLastTripSampleMs = 0L;
        this.mapplsLastTripSampleLocation = null;
        this.mapplsNavCancelledEmitted = false;
        Log.i("HomeActivity", "Mappls guidance started — trip tracking armed");
    }

    public void onMapplsRouteProgress(AdviseInfo adviseInfo) {
        if (!this.mapplsGuidanceHadStarted || adviseInfo == null) {
            return;
        }
        try {
            double leftDistance = adviseInfo.getLeftDistance();
            if (leftDistance > 0.0d) {
                if (this.mapplsInitialRemainingMeters == null) {
                    this.mapplsInitialRemainingMeters = Double.valueOf(leftDistance);
                }
                this.mapplsLastRemainingMeters = Double.valueOf(leftDistance);
            }
        } catch (Exception unused) {
        }
        Location location = adviseInfo.getLocation();
        if (location == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Location location2 = this.mapplsLastTripSampleLocation;
        if (location2 != null) {
            long j = jCurrentTimeMillis - this.mapplsLastTripSampleMs;
            float fDistanceTo = location.distanceTo(location2);
            if (j < MAPPLS_TRIP_SAMPLE_MIN_INTERVAL_MS && fDistanceTo < MAPPLS_TRIP_SAMPLE_MIN_DISTANCE_M) {
                return;
            }
        }
        if (this.mapplsTripSamples.size() >= 400) {
            List<double[]> list = this.mapplsTripSamples;
            list.subList(0, list.size() / 4).clear();
        }
        this.mapplsTripSamples.add(new double[]{location.getLongitude(), location.getLatitude()});
        this.mapplsLastTripSampleMs = jCurrentTimeMillis;
        this.mapplsLastTripSampleLocation = new Location(location);
    }

    public void endMapplsNavigation(String str) {
        WritableMap writableMapBuildBody;
        Log.i("HomeActivity", "endMapplsNavigation reason=" + str + " guidanceStarted=" + this.mapplsGuidanceHadStarted + " alreadyEmitted=" + this.mapplsNavCancelledEmitted);
        if (this.mapplsNavCancelledEmitted) {
            writableMapBuildBody = null;
        } else {
            this.mapplsNavCancelledEmitted = true;
            writableMapBuildBody = NavCancelledEventBridge.buildBody(this.mapplsGuidanceHadStarted, this.isTakeMeHome, this.mapplsNavSessionStartMs, this.mapplsInitialRemainingMeters, this.mapplsLastRemainingMeters, this.mapplsTripSamples);
            this.mapplsGuidanceHadStarted = false;
        }
        Fragment fragment = this.currentFragment;
        if (fragment instanceof NavigationFragment) {
            try {
                ((NavigationFragment) fragment).onBackPressed(true);
            } catch (Exception e) {
                Timber.e(e);
            }
        }
        try {
            MirroringPolicy.stopMirroringAfterNavigation(this, "HomeActivity.endMapplsNavigation:" + str);
        } catch (Exception e2) {
            Timber.e(e2);
        }
        if (writableMapBuildBody != null) {
            NavCancelledEventBridge.emit(this, writableMapBuildBody);
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof NavigationFragment) {
            Log.e("HomeActivity", "Navigation cancel — emit NAV_CANCELLED_EVENT + finish");
            endMapplsNavigation("onBackPressed");
        } else if (fragment instanceof RouteFragment) {
            finish();
        } else {
            finish();
        }
    }

    @Override // com.mappls.sdk.maps.location.permissions.PermissionsListener
    public void onExplanationNeeded(List<String> list) {
        Toast.makeText(this, R.string.user_location_permission_explanation, 1).show();
    }

    @Override // com.mappls.sdk.maps.location.permissions.PermissionsListener
    public void onPermissionResult(boolean z) {
        if (z) {
            MapplsMap mapplsMap = this.mapplsMap;
            if (mapplsMap != null) {
                mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.HomeActivity.2
                    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                    public void onStyleLoaded(Style style) {
                        HomeActivity.this.enableLocationComponent(style);
                    }
                });
                return;
            }
            return;
        }
        Toast.makeText(this, R.string.user_location_permission_not_granted, 1).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.permissionsManager.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(final MapplsMap mapplsMap) {
        if (mapplsMap == null) {
            return;
        }
        this.mapplsMap = mapplsMap;
        GlobalVar.hydrateAppThemeFromPrefs(this);
        String strMapplsStyleForAppTheme = GlobalVar.mapplsStyleForAppTheme();
        Log.i("HomeActivity", "Mappls style for app theme dark=" + GlobalVar.appThemeIsDark + " style=" + strMapplsStyleForAppTheme);
        this.mapplsMap.setMapplsStyle(strMapplsStyleForAppTheme, new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.HomeActivity.3
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                try {
                    new TrafficPlugin(HomeActivity.this.mapView, HomeActivity.this.mapplsMap).setEnabled(true);
                } catch (Exception e) {
                    Timber.e(e);
                }
                HomeActivity.this.directionPolylinePlugin = new DirectionPolylinePlugin(HomeActivity.this.mapView, mapplsMap);
                HomeActivity.this.routeArrowPlugin = new RouteArrowPlugin(HomeActivity.this.mapView, HomeActivity.this.mapplsMap);
                HomeActivity.this.mapEventsPlugin = new MapEventsPlugin(HomeActivity.this.mapView, HomeActivity.this.mapplsMap);
                HomeActivity.this.enableLocationComponent(style);
                HomeActivity.this.directionPolylinePlugin.setEnableCongestion(true);
                HomeActivity.this._bearingIconPlugin = new BearingIconPlugin(HomeActivity.this.mapView, HomeActivity.this.mapplsMap);
                HomeActivity.this.mapplsMap.setMaxZoomPreference(18.5d);
                HomeActivity.this.mapplsMap.setMinZoomPreference(4.0d);
                mapplsMap.setInfoWindowAdapter(HomeActivity.this);
                HomeActivity.this.mapplsMap.addOnMapLongClickListener(HomeActivity.this);
                HomeActivity.this.setCompassDrawable();
            }
        });
    }

    public RouteArrowPlugin getRouteArrowPlugin() {
        return this.routeArrowPlugin;
    }

    public MapEventsPlugin getMapEventPlugin() {
        return this.mapEventsPlugin;
    }

    public BearingIconPlugin getBearingIconPlugin() {
        return this._bearingIconPlugin;
    }

    public void setCompassDrawable() {
        this.mapView.getCompassView().setBackgroundResource(R.drawable.compass_background);
        this.mapplsMap.getUiSettings().setCompassImage(ContextCompat.getDrawable(this, R.drawable.compass_north_up));
        int iDpToPx = dpToPx(MAPPLS_TRIP_SAMPLE_MIN_DISTANCE_M);
        int iDpToPx2 = dpToPx(MAPPLS_TRIP_SAMPLE_MIN_DISTANCE_M);
        this.mapView.getCompassView().setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        ViewCompat.setElevation(this.mapView.getCompassView(), iDpToPx2);
        this.mapplsMap.getUiSettings().setCompassMargins(dpToPx(20.0f), dpToPx(150.0f), dpToPx(20.0f), dpToPx(20.0f));
    }

    public int dpToPx(float f) {
        return (int) (f * getResources().getDisplayMetrics().density);
    }

    private void showWhenLockedAndTurnScreenOn() {
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        } else {
            getWindow().addFlags(2621440);
        }
    }
}
