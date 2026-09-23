package com.bajajconnect.navigate;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.navigate.fragment.NavigationFragment;
import com.bajajconnect.navigate.maps.plugins.BearingIconPlugin;
import com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin;
import com.bajajconnect.navigate.maps.plugins.MapEventsPlugin;
import com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin;
import com.bajajconnect.navigate.utils.NavigationCompassEngine;
import com.bajajconnect.navigate.utils.NavigationLocationEngine;
import com.bajajconnect.variables.GlobalVar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentActivationOptions;
import com.mappls.sdk.maps.location.LocationComponentOptions;
import com.mappls.sdk.maps.location.OnCameraTrackingChangedListener;
import com.mappls.sdk.maps.location.permissions.PermissionsListener;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCodeManager;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationActivity extends BaseActivity implements MapplsMap.InfoWindowAdapter, View.OnClickListener, MapplsMap.OnMarkerClickListener, MapplsMap.OnMapLongClickListener, FragmentManager.OnBackStackChangedListener, OnCameraTrackingChangedListener, PermissionsListener {
    public static int DEFAULT_BOTTOM_PADDING;
    public static int DEFAULT_PADDING;
    BearingIconPlugin _bearingIconPlugin;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f31app;
    private Fragment currentFragment;
    private DirectionPolylinePlugin directionPolylinePlugin;
    private boolean firstFix;
    private FloatingActionButton floatingActionButton;
    private MapEventsPlugin mapEventsPlugin;
    public MapplsMap mapplsMap;
    private NavigationLocationEngine navigationLocationEngine;
    private PermissionsManager permissionsManager;
    private RouteArrowPlugin routeArrowPlugin;
    private Bundle savedInstanceState;
    boolean isVisible = false;
    Handler backStackHandler = new Handler();
    Runnable backStackRunnable = new Runnable() { // from class: com.bajajconnect.navigate.NavigationActivity$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };

    private void setupUI() {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override // com.mappls.sdk.maps.location.OnCameraTrackingChangedListener
    public void onCameraTrackingChanged(int i) {
    }

    @Override // com.mappls.sdk.maps.location.OnCameraTrackingChangedListener
    public void onCameraTrackingDismissed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.mappls.sdk.maps.location.permissions.PermissionsListener
    public void onExplanationNeeded(List<String> list) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapLongClickListener
    public boolean onMapLongClick(LatLng latLng) {
        return false;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override // com.mappls.sdk.maps.location.permissions.PermissionsListener
    public void onPermissionResult(boolean z) {
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

    public NavApplication getMyApplication() {
        return NavApplication.forFragments();
    }

    @Override // com.bajajconnect.navigate.BaseActivity, com.mappls.sdk.navigation.activities.MapActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        showWhenLockedAndTurnScreenOn();
        super.onCreate(bundle);
        Log.d("Bmaps", "navigateActLoaded");
        this.savedInstanceState = bundle;
        try {
            this.f31app = getMyApplication();
            DEFAULT_PADDING = (int) getResources().getDimension(R.dimen.default_map_padding);
            DEFAULT_BOTTOM_PADDING = (int) getResources().getDimension(R.dimen.default_map_bottom_padding);
            this.navigationLocationEngine = new NavigationLocationEngine();
            getSupportFragmentManager().addOnBackStackChangedListener(this);
            setupUI();
        } catch (Exception unused) {
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.NavigationActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$1();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        navigateTo(new NavigationFragment(), true);
    }

    @Override // com.mappls.sdk.navigation.activities.MapActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.mappls.sdk.navigation.activities.MapActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.permissionsManager.onRequestPermissionsResult(i, strArr, iArr);
    }

    public DirectionPolylinePlugin getDirectionPolylinePlugin() {
        return this.directionPolylinePlugin;
    }

    @Override // com.mappls.sdk.navigation.activities.MapActivity
    public MapView getMapView() {
        return this.mapView;
    }

    public NavLocation getUserLocation() {
        if (this.f31app.getCurrentLocation() == null) {
            return null;
        }
        NavLocation navLocation = new NavLocation("router");
        navLocation.setLatitude(this.f31app.getCurrentLocation().getLatitude());
        navLocation.setLongitude(this.f31app.getCurrentLocation().getLongitude());
        return navLocation;
    }

    public void startNavigation() {
        onBackPressed();
        navigateTo(new NavigationFragment(), true);
    }

    public float getLocationAccuracy() {
        if (this.f31app.getCurrentLocation() != null) {
            return this.f31app.getCurrentLocation().getAccuracy();
        }
        return 0.0f;
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
        this.currentFragment = getFragmentOnTopOfBackStack();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        this.backStackHandler.removeCallbacksAndMessages(null);
        this.backStackHandler.postDelayed(this.backStackRunnable, 100L);
    }

    public void getReverseGeoCode(final LatLng latLng) {
        showProgress();
        MapplsReverseGeoCodeManager.newInstance(MapplsReverseGeoCode.builder().setLocation(latLng.getLatitude(), latLng.getLongitude()).build()).call(new OnResponseCallback<PlaceResponse>() { // from class: com.bajajconnect.navigate.NavigationActivity.1
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(PlaceResponse placeResponse) {
                if (placeResponse != null) {
                    Place place = placeResponse.getPlaces().get(0);
                    ELocation eLocation = new ELocation();
                    eLocation.entryLongitude = Double.valueOf(latLng.getLongitude());
                    eLocation.longitude = Double.valueOf(latLng.getLongitude());
                    eLocation.entryLatitude = Double.valueOf(latLng.getLatitude());
                    eLocation.latitude = Double.valueOf(latLng.getLatitude());
                    eLocation.placeName = place.getFormattedAddress();
                    eLocation.placeAddress = NavigationActivity.this.getString(R.string.point_on_map);
                    Fragment unused = NavigationActivity.this.currentFragment;
                }
                NavigationActivity.this.hideProgress();
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                Toast.makeText(NavigationActivity.this, str, 1).show();
                NavigationActivity.this.hideProgress();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableLocationComponent(Style style) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            LocationComponentOptions locationComponentOptionsBuild = LocationComponentOptions.builder(this).trackingGesturesManagement(true).accuracyColor(ContextCompat.getColor(this, R.color.accuracy_green)).build();
            LocationComponent locationComponent = this.mapplsMap.getLocationComponent();
            locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(this, style).locationComponentOptions(locationComponentOptionsBuild).locationEngine(this.navigationLocationEngine).build());
            locationComponent.setCompassEngine(new NavigationCompassEngine());
            locationComponent.setLocationComponentEnabled(true);
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

    public BearingIconPlugin getBearingIconPlugin() {
        return this._bearingIconPlugin;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
        Fragment fragment = this.currentFragment;
        if (fragment instanceof NavigationFragment) {
            ((NavigationFragment) fragment).onBackPressed(false);
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(final MapplsMap mapplsMap) {
        if (mapplsMap == null) {
            return;
        }
        try {
            this.mapplsMap = mapplsMap;
            GlobalVar.hydrateAppThemeFromPrefs(this);
            this.mapplsMap.setMapplsStyle(GlobalVar.mapplsStyleForAppTheme(), new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.NavigationActivity.2
                @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                public void onStyleLoaded(Style style) {
                    NavigationActivity.this.directionPolylinePlugin = new DirectionPolylinePlugin(NavigationActivity.this.mapView, mapplsMap);
                    NavigationActivity.this.routeArrowPlugin = new RouteArrowPlugin(NavigationActivity.this.mapView, NavigationActivity.this.mapplsMap);
                    NavigationActivity.this.mapEventsPlugin = new MapEventsPlugin(NavigationActivity.this.mapView, NavigationActivity.this.mapplsMap);
                    NavigationActivity.this.enableLocationComponent(style);
                    NavigationActivity.this.directionPolylinePlugin.setEnableCongestion(true);
                    NavigationActivity.this._bearingIconPlugin = new BearingIconPlugin(NavigationActivity.this.mapView, NavigationActivity.this.mapplsMap);
                    mapplsMap.setInfoWindowAdapter(NavigationActivity.this);
                    NavigationActivity.this.mapplsMap.setMaxZoomPreference(18.5d);
                    NavigationActivity.this.mapplsMap.setMinZoomPreference(4.0d);
                    NavigationActivity.this.setCompassDrawable();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RouteArrowPlugin getRouteArrowPlugin() {
        return this.routeArrowPlugin;
    }

    public MapEventsPlugin getMapEventPlugin() {
        return this.mapEventsPlugin;
    }

    public void setCompassDrawable() {
        this.mapView.getCompassView().setBackgroundResource(R.drawable.compass_background);
        this.mapplsMap.getUiSettings().setCompassImage(ContextCompat.getDrawable(this, R.drawable.compass_north_up));
        int iDpToPx = dpToPx(8.0f);
        int iDpToPx2 = dpToPx(8.0f);
        this.mapView.getCompassView().setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        ViewCompat.setElevation(this.mapView.getCompassView(), iDpToPx2);
        this.mapplsMap.getUiSettings().setCompassMargins(dpToPx(20.0f), dpToPx(120.0f), dpToPx(20.0f), dpToPx(20.0f));
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
