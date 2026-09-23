package com.mappls.sdk.navigation.ui.navigation;

import android.content.Context;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import com.google.firebase.perf.util.Constants;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.MapplsMapOptions;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.annotations.MarkerOptions;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdateFactory;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NavigationLocationProvider;
import com.mappls.sdk.navigation.camera.MathUtils;
import com.mappls.sdk.navigation.camera.NavigationCamera;
import com.mappls.sdk.navigation.camera.ProgressChangeListener;
import com.mappls.sdk.navigation.camera.RouteInformation;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.iface.INavigationListener;
import com.mappls.sdk.navigation.iface.LocationChangedListener;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.ui.NavigationOptions;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutNavigationViewBinding;
import com.mappls.sdk.navigation.ui.map.route.NavigationMapRoute;
import com.mappls.sdk.navigation.ui.model.CustomInfoBarItem;
import com.mappls.sdk.navigation.ui.navigation.finished.NavigationFinishedView;
import com.mappls.sdk.navigation.ui.navigation.infobar.InfobarBottomSheetView;
import com.mappls.sdk.navigation.util.GPSInfo;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegAnnotation;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationView extends CoordinatorLayout implements LifecycleOwner, OnMapReadyCallback, MapplsMap.OnMoveListener, LocationChangedListener, INavigationListener {
    LayoutNavigationViewBinding binding;
    private List<CustomInfoBarItem> customInfoBarItems;
    Handler gpsHandler;
    private GPSInfo gpsInfo;
    Runnable gpsRunnable;
    private boolean isConfigurationChange;
    private boolean isInPIPMode;
    private boolean isMapInitialised;
    private boolean isViewCreated;
    private LifecycleRegistry lifecycleRegistry;
    private MapView mapView;
    private MapplsMap mapplsMap;
    private NavigationCallback navigationCallback;
    private com.mappls.sdk.navigation.ui.map.c navigationMap;
    private NavigationViewCallback navigationViewCallback;
    private q navigationViewModel;
    private final NavigationOptions options;

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawPolyLine() {
        if (this.navigationMap != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(MapplsNavigationHelper.getInstance().getCurrentRoute());
            this.navigationMap.c.a(arrayList);
            com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
            cVar.c.a(new f());
        }
    }

    private void finishNavigation() {
        NavigationFinishedView navigationFinishedView = this.binding.navigationFinishedView;
        if (navigationFinishedView != null) {
            navigationFinishedView.show();
        }
        this.binding.constraintLayout2.setVisibility(8);
        this.binding.infobarView.setVisibility(8);
        this.binding.searchAlongRouteView.setVisibility(8);
        this.binding.settingsView.hide();
        this.binding.directionList.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixPreviewNavigationMarker() {
        try {
            com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
            if (cVar != null) {
                cVar.c(false);
                List navigationSteps = MapplsNavigationHelper.getInstance().getNavigationSteps();
                NavLocation navLocation = ((NavigationStep) navigationSteps.get(selectedInstructionPosition())).getNavLocation();
                if (navLocation != null) {
                    LatLng latLng = new LatLng(navLocation.getLatitude(), navLocation.getLongitude());
                    com.mappls.sdk.navigation.ui.map.c cVar2 = this.navigationMap;
                    MapplsMap mapplsMap = cVar2.a;
                    double maxZoomLevel = mapplsMap != null ? mapplsMap.getMaxZoomLevel() : 18.0d;
                    if (cVar2.a != null) {
                        cVar2.a.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().tilt(0.0d).zoom(maxZoomLevel).bearing(0.0d).target(latLng).build()), Constants.MAX_URL_LENGTH);
                    }
                    NavLocation navLocation2 = ((NavigationStep) navigationSteps.get(selectedInstructionPosition())).getNavLocation();
                    if (navLocation2 != null) {
                        float locationAngle = getLocationAngle(navLocation2);
                        com.mappls.sdk.navigation.ui.map.c cVar3 = this.navigationMap;
                        LatLng latLng2 = new LatLng(navLocation2.getLatitude(), navLocation2.getLongitude());
                        com.mappls.sdk.navigation.ui.map.plugins.c cVar4 = cVar3.e;
                        if (cVar4 != null) {
                            cVar4.c = locationAngle;
                            cVar4.d = latLng2;
                            cVar4.a.removeCallbacksAndMessages(null);
                            cVar4.a.postDelayed(cVar4.h, 100L);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Timber.e(e);
            e.printStackTrace();
        }
    }

    private void initializeViewModel() {
        q qVar = (q) new ViewModelProvider((FragmentActivity) getContext()).get(q.class);
        this.navigationViewModel = qVar;
        qVar.d = this.options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextPreviousButtonPressed(boolean z) {
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null) {
            cVar.c(false);
        }
        if (z) {
            com.mappls.sdk.navigation.ui.map.c cVar2 = this.navigationMap;
            if (cVar2 != null) {
                com.mappls.sdk.navigation.ui.map.plugins.c cVar3 = cVar2.e;
                if (cVar3 != null) {
                    cVar3.a(true);
                }
                this.navigationMap.b(false);
            }
            fixPreviewNavigationMarker();
            return;
        }
        com.mappls.sdk.navigation.ui.map.c cVar4 = this.navigationMap;
        if (cVar4 != null) {
            com.mappls.sdk.navigation.ui.map.plugins.c cVar5 = cVar4.e;
            if (cVar5 != null) {
                cVar5.a(true);
            }
            this.navigationMap.b(false);
        }
        fixPreviewNavigationMarker();
    }

    private void onRestoreInstanceState(Bundle bundle) {
        com.mappls.sdk.navigation.ui.model.a aVar = (com.mappls.sdk.navigation.ui.model.a) bundle.getParcelable("mappls_navigation_view_state");
        if (aVar != null) {
            if (aVar.e) {
                this.binding.directionList.show();
            } else {
                this.binding.directionList.hide();
            }
            this.binding.navigationFinishedView.hide();
            this.binding.nextAdviseView.setVisibility(aVar.a ? 0 : 8);
            this.binding.followButton.setVisibility(aVar.b ? 0 : 8);
            this.binding.tvSpeed.setVisibility(aVar.c ? 0 : 8);
            if (aVar.d) {
                this.binding.settingsView.show();
            } else {
                this.binding.settingsView.hide();
            }
        }
    }

    private void subscribe() {
        this.binding.infobarView.subscribe(this, this.navigationViewModel);
        this.binding.instructionContainer.subscribe(this, this.navigationViewModel);
        this.binding.instructionContainerPip.subscribe(this, this.navigationViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEvents(List<ReportDetails> list) {
        NavigationMapRoute navigationMapRoute;
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar == null || (navigationMapRoute = cVar.c) == null) {
            return;
        }
        navigationMapRoute.a(list);
    }

    public void addRoute(ELocation eLocation) {
        if (this.mapplsMap != null) {
            followMe(false);
            if (eLocation.latitude == null || eLocation.longitude == null) {
                this.mapplsMap.addMarker(new MarkerOptions().mapplsPin(eLocation.getMapplsPin()));
                this.mapplsMap.animateCamera(CameraMapplsPinUpdateFactory.newMapplsPinZoom(eLocation.getMapplsPin(), 12.0d));
            } else {
                this.mapplsMap.addMarker(new MarkerOptions().position(new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue())));
                this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue()), 12.0d));
            }
        }
        this.binding.searchAlongRouteView.setRouteDetail(eLocation);
        this.binding.searchAlongRouteView.show();
    }

    public synchronized void followMe(boolean z) {
        NavigationCamera navigationCamera;
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null) {
            NavigationCamera navigationCamera2 = cVar.f;
            if (z != (navigationCamera2 != null && navigationCamera2.isTrackingEnabled())) {
                if (MapplsNavigationHelper.getInstance().isNavigating()) {
                    this.navigationMap.c(z);
                }
                if (!this.isInPIPMode && z) {
                    com.mappls.sdk.navigation.ui.map.a aVar = this.navigationMap.d;
                    aVar.getClass();
                    aVar.a(aVar.b);
                }
            }
        }
        if (z) {
            if (MapplsNavigationHelper.getInstance().isNavigating()) {
                this.binding.instructionContainer.setFollowMe();
                if (this.binding.followButton.getVisibility() == 0) {
                    this.binding.followButton.hide();
                }
            }
            com.mappls.sdk.navigation.ui.map.c cVar2 = this.navigationMap;
            if (cVar2 != null && (navigationCamera = cVar2.f) != null) {
                LocationComponent locationComponent = cVar2.g;
                navigationCamera.resume((locationComponent == null || !locationComponent.isLocationComponentActivated()) ? null : cVar2.g.getLastKnownLocation());
            }
            com.mappls.sdk.navigation.ui.map.c cVar3 = this.navigationMap;
            if (cVar3 != null) {
                com.mappls.sdk.navigation.ui.map.plugins.c cVar4 = cVar3.e;
                if (cVar4 != null) {
                    cVar4.a(false);
                }
                if (!this.isInPIPMode) {
                    this.navigationMap.b(true);
                }
            }
        } else if (this.binding.followButton.getVisibility() != 0) {
            this.binding.followButton.show();
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    float getLocationAngle(NavLocation navLocation) {
        try {
            List<NavLocation> path = NavigationContext.getNavigationContext().getCalculatedRoute().getPath();
            return (float) MathUtils.wrap(navLocation.bearingTo(path.get(path.indexOf(navLocation) + 1)), 0.0d, 360.0d);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public Location getLocationForNavigation() {
        LocationComponent locationComponent;
        Location location = new Location("gps");
        NavLocation startLocation = MapplsNavigationViewHelper.getInstance().getStartLocation();
        if (startLocation != null) {
            location.setLatitude(startLocation.getLatitude());
            location.setLongitude(startLocation.getLongitude());
        }
        try {
            NavLocation firstLocation = MapplsNavigationHelper.getInstance().getFirstLocation();
            if (firstLocation.distanceTo(NavigationLocationProvider.convertLocation(location, getContext())) < 10.0f) {
                firstLocation.setBearing(firstLocation.bearingTo(MapplsNavigationHelper.getInstance().getSecondLocation()));
                return NavigationLocationProvider.revertLocation(firstLocation, getContext());
            }
            com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
            Location lastKnownLocation = (cVar == null || (locationComponent = cVar.g) == null || !locationComponent.isLocationComponentActivated()) ? null : cVar.g.getLastKnownLocation();
            return lastKnownLocation != null ? lastKnownLocation : NavigationLocationProvider.revertLocation(NavigationContext.getNavigationContext().getLocationProvider().getFirstTimeRunDefaultLocation(), getContext());
        } catch (Exception e) {
            e.printStackTrace();
            Timber.e(e);
            return NavigationLocationProvider.revertLocation(NavigationContext.getNavigationContext().getLocationProvider().getFirstTimeRunDefaultLocation(), getContext());
        }
    }

    public void hideWarning() {
        if (this.options.showWarningMessage().booleanValue()) {
            this.binding.warningTextView.setVisibility(4);
        }
    }

    public void init() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            return;
        }
        if (this.isMapInitialised) {
            com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
            if (cVar != null) {
                InfobarBottomSheetView infobarBottomSheetView = this.binding.infobarView;
                MapplsMap mapplsMap = cVar.a;
                infobarBottomSheetView.isTrafficEnable(mapplsMap == null ? cVar.j : mapplsMap.isEnableTraffic());
            }
        } else {
            mapView.getMapAsync(this);
        }
        onRouteProgress(MapplsNavigationHelper.getInstance().getAdviseInfo());
        this.binding.soundView.setSoundControll();
        this.binding.directionList.init();
        this.navigationViewModel.c.setValue(MapplsNavigationViewHelper.getInstance().getDestination());
        subscribe();
    }

    public void locationModeNavigation(boolean z) {
        MapplsMap mapplsMap;
        LocationComponent locationComponent;
        try {
            if (this.navigationMap != null && (mapplsMap = this.mapplsMap) != null && mapplsMap.getStyle() != null && this.mapplsMap.getStyle().isFullyLoaded()) {
                this.navigationMap.a(z);
                if (!z) {
                    MapplsNavigationHelper.getInstance().removeLocationChangeListener(this);
                    this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().bearing(0.0d).tilt(0.0d).build()));
                    return;
                }
                MapplsNavigationHelper.getInstance().addLocationChangeListener(this);
                if (getContext() != null) {
                    Location locationForNavigation = getLocationForNavigation();
                    com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
                    if (cVar != null && (locationComponent = cVar.g) != null && locationComponent.isLocationComponentActivated()) {
                        cVar.g.forceLocationUpdate(locationForNavigation);
                    }
                }
                followMe(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Timber.e(e);
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onAlternateRoutesUpdate(List<AlternateRoute> list) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setClickable(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
        TextView textView = this.binding.tvSpeed;
        Context context = getContext();
        textView.setBackground(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewSpeedBackground).resourceId));
        this.binding.tvSpeed.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewSpeedTextColor));
        ImageView imageView = this.binding.searchAlongRoute;
        Context context2 = getContext();
        imageView.setBackground(AppCompatResources.getDrawable(context2, com.mappls.sdk.navigation.ui.theme.a.a(context2, R.attr.navigationViewSearchAlongRouteBackground).resourceId));
        ImageView imageView2 = this.binding.searchAlongRoute;
        Context context3 = getContext();
        imageView2.setImageDrawable(AppCompatResources.getDrawable(context3, com.mappls.sdk.navigation.ui.theme.a.a(context3, R.attr.navigationViewSearchAlongRouteIcon).resourceId));
        if (!this.options.showBottomInfoBar().booleanValue()) {
            this.binding.infobarView.setVisibility(8);
        }
        if (!this.options.showInstructionBanner().booleanValue()) {
            this.binding.instructionContainer.setVisibility(8);
            this.binding.instructionContainerPip.setVisibility(8);
        }
        if (!this.options.showWarningMessage().booleanValue()) {
            this.binding.warningTextView.setVisibility(4);
        }
        this.binding.soundView.setSoundControllerCallback(new h());
        if (!this.options.showSoundToggleButton().booleanValue()) {
            this.binding.soundView.setVisibility(8);
        }
        MapplsNavigationHelper.getInstance().setOnSpeedLimitListener(new i(this));
        this.binding.infobarView.updateOptions(this.options);
        this.binding.infobarView.setCustomInfoBarItem(this.customInfoBarItems);
        if (this.options.showSearchDuringNavigationOption().booleanValue()) {
            this.binding.searchAlongRoute.setVisibility(0);
        } else {
            this.binding.searchAlongRoute.setVisibility(8);
        }
        if (!this.options.showCurrentSpeed().booleanValue()) {
            this.binding.tvSpeed.setVisibility(8);
        }
        this.binding.navigationFinishedView.setCallback(new j(this));
        this.binding.infobarView.setOnInfobarCallback(new l(this));
        this.binding.searchAlongRoute.setOnClickListener(new m(this));
        this.binding.followButton.setOnClickListener(new n(this));
        this.binding.instructionContainer.setNextPreviousIconClickListener(new o(this));
        this.binding.settingsView.setSettingsCallback(new p(this));
        this.binding.searchAlongRouteView.setSearchRouteCallback(new a(this));
        this.binding.directionList.setOnDirectionClick(new b(this));
    }

    public boolean onBackPressed(boolean z) {
        if (this.binding.directionList.onBackPress()) {
            return false;
        }
        if (this.binding.searchAlongRouteView.isVisible()) {
            this.binding.searchAlongRouteView.hide();
            MapplsMap mapplsMap = this.mapplsMap;
            if (mapplsMap != null) {
                mapplsMap.clear();
            }
            return true;
        }
        if (this.binding.settingsView.onBackPress()) {
            return true;
        }
        if (z) {
            MapplsNavigationHelper.getInstance().stopNavigation();
        }
        return false;
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onBetterRouteAvailable(List<DirectionsRoute> list) {
    }

    public void onConfigurationChange(Configuration configuration) {
        followMe(true);
        this.isConfigurationChange = true;
    }

    public void onCreate(Bundle bundle) {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.binding.mapLayout.setVisibility(0);
            MapView mapView = new MapView(getContext(), MapplsMapOptions.createFromAttributes(getContext()).textureMode(true));
            this.mapView = mapView;
            this.binding.mapLayout.addView(mapView);
            this.mapView.onCreate(bundle);
        } else {
            this.binding.mapLayout.setVisibility(8);
        }
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        MapplsNavigationHelper.getInstance().addNavigationListener(this);
        MapplsNavigationHelper.getInstance().setNavigationEventLoadedListener(new c(this));
        MapplsNavigationHelper.getInstance().setNavigationEventListener(new d(this));
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        init();
        this.isViewCreated = true;
    }

    public void onDestroy() {
        this.isViewCreated = false;
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.clear();
        }
        locationModeNavigation(false);
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null) {
            LocationComponent locationComponent = cVar.g;
            if (locationComponent != null && locationComponent.isLocationComponentActivated()) {
                cVar.g.setRenderMode(18);
            }
            NavigationMapRoute navigationMapRoute = this.navigationMap.c;
            if (navigationMapRoute != null) {
                navigationMapRoute.a();
            }
        }
        MapplsMap mapplsMap2 = this.mapplsMap;
        if (mapplsMap2 != null) {
            mapplsMap2.removeOnMoveListener(this);
            this.mapplsMap.removeAnnotations();
        }
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onDestroy();
        }
        this.binding.infobarView.unsubscribe();
        this.binding.instructionContainer.unsubscribe();
        this.binding.instructionContainerPip.unsubscribe();
        MapplsNavigationHelper.getInstance().removeNavigationListener(this);
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onETARefreshed(String str) {
        drawPolyLine();
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onEvent(NavEvent navEvent) {
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onGPSConnectionChanged(boolean z) {
        if (z) {
            hideWarning();
        } else {
            showWarning("GPS connection Lost", getResources().getColor(R.color.red));
        }
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onLocationChanged(Location location) {
        LocationComponent locationComponent;
        hideWarning();
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar == null || (locationComponent = cVar.g) == null || !locationComponent.isLocationComponentActivated()) {
            return;
        }
        cVar.g.forceLocationUpdate(location);
    }

    public void onLowMemory() {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onLowMemory();
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        mapplsMap.clear();
        getContext();
        MapView mapView = this.mapView;
        if (mapView != null && mapView.getCompassView() != null) {
            if (com.mappls.sdk.navigation.ui.theme.a.a()) {
                mapView.getCompassView().setBackgroundResource(R.drawable.compass_background_dark);
            } else {
                mapView.getCompassView().setBackgroundResource(R.drawable.compass_background_light);
            }
        }
        mapplsMap.addOnMoveListener(this);
        getContext();
        mapplsMap.setMapplsStyle(com.mappls.sdk.navigation.ui.theme.a.a() ? this.options.mapplsMapDarkStyle() : this.options.mapplsMapLightStyle());
        mapplsMap.getStyle(new e(this, mapplsMap));
        NavigationViewCallback navigationViewCallback = this.navigationViewCallback;
        if (navigationViewCallback != null) {
            navigationViewCallback.onNavigationMapReady(mapplsMap);
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMove(MoveGestureDetector moveGestureDetector) {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
        this.binding.infobarView.showRouteOverview(true);
        followMe(false);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationCancelled() {
        this.gpsHandler.removeCallbacksAndMessages(null);
        hideWarning();
        locationModeNavigation(false);
        NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            navigationCallback.onNavigationCancelled();
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationFinished() {
        this.gpsHandler.removeCallbacksAndMessages(null);
        locationModeNavigation(false);
        hideWarning();
        finishNavigation();
        NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            navigationCallback.onNavigationFinished();
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationStarted() {
        this.binding.navigationFinishedView.hide();
        NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            navigationCallback.onNavigationStarted();
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNewRoute(String str) {
        List<RouteLeg> listLegs;
        NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            navigationCallback.onNewRoute(str);
        }
        this.binding.instructionContainer.setDataContainer(true);
        this.binding.instructionContainerPip.setDataContainer();
        this.binding.directionList.onNewRoute();
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.removeAnnotations();
        }
        DirectionsRoute currentRoute = MapplsNavigationHelper.getInstance().getCurrentRoute();
        q qVar = this.navigationViewModel;
        AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
        int nodeIndex = MapplsNavigationHelper.getInstance().getNodeIndex();
        qVar.getClass();
        if (currentRoute != null && (listLegs = currentRoute.legs()) != null && listLegs.size() > 0 && listLegs.get(0).annotation() != null) {
            double dDoubleValue = currentRoute.distance() != null ? currentRoute.distance().doubleValue() : 0.0d;
            if (adviseInfo != null) {
                qVar.a.setValue(new com.mappls.sdk.navigation.ui.navigation.infobar.l(adviseInfo, listLegs.get(0).annotation().congestion(), dDoubleValue, nodeIndex));
            }
        }
        drawPolyLine();
    }

    public void onPause() {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onPause();
        }
    }

    public void onPictureInPictureModeChange(boolean z) {
        this.isInPIPMode = z;
        if (z) {
            this.binding.infobarView.setVisibility(8);
            this.binding.soundView.setVisibility(8);
            this.binding.nextAdviseView.setVisibility(8);
            this.binding.searchAlongRoute.setVisibility(8);
            this.binding.instructionContainer.setVisibility(8);
            if (this.options.showInstructionBanner().booleanValue()) {
                this.binding.instructionContainerPip.setVisibility(0);
            }
            this.binding.alertView.updateRouteEvent(null);
            this.binding.settingsView.hide();
            this.binding.directionList.hide();
            hideWarning();
            this.binding.tvSpeed.setVisibility(8);
            com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
            if (cVar != null) {
                cVar.a.getUiSettings().setLogoMargins(0, 0, 0, 100);
                cVar.a.getUiSettings().setCompassEnabled(false);
                cVar.d.a(com.mappls.sdk.navigation.ui.map.c.k);
            }
        } else {
            if (this.options.showBottomInfoBar().booleanValue()) {
                this.binding.infobarView.setVisibility(0);
            }
            if (this.options.showSoundToggleButton().booleanValue()) {
                this.binding.soundView.setVisibility(0);
            } else {
                this.binding.soundView.setVisibility(8);
            }
            this.binding.nextAdviseView.setVisibility(0);
            if (this.options.showSearchDuringNavigationOption().booleanValue()) {
                this.binding.searchAlongRoute.setVisibility(0);
            } else {
                this.binding.searchAlongRoute.setVisibility(8);
            }
            if (this.options.showInstructionBanner().booleanValue()) {
                this.binding.instructionContainer.setVisibility(0);
            }
            this.binding.instructionContainerPip.setVisibility(8);
            com.mappls.sdk.navigation.ui.map.c cVar2 = this.navigationMap;
            if (cVar2 != null) {
                if (cVar2.b.getResources().getConfiguration().orientation == 1) {
                    cVar2.a.getUiSettings().setLogoMargins(0, 0, 0, 300);
                } else {
                    cVar2.a.getUiSettings().setLogoMargins(0, 0, 0, 150);
                }
                cVar2.a.getUiSettings().setCompassEnabled(true);
                this.navigationMap.b(true);
            }
        }
        AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
        if (this.mapplsMap != null) {
            Location location = adviseInfo.getLocation();
            this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).build()));
        }
        followMe(true);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onReRoutingRequested() {
    }

    public void onResume() {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onResume();
        }
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onRouteProgress(AdviseInfo adviseInfo) {
        LegAnnotation legAnnotationAnnotation;
        NavigationCamera navigationCamera;
        hideWarning();
        if (adviseInfo == null) {
            Timber.e("No Route Information found", new Object[0]);
            return;
        }
        NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            navigationCallback.onRouteProgress(adviseInfo);
        }
        q qVar = this.navigationViewModel;
        DirectionsRoute currentRoute = MapplsNavigationHelper.getInstance().getCurrentRoute();
        int nodeIndex = MapplsNavigationHelper.getInstance().getNodeIndex();
        qVar.b.setValue(new com.mappls.sdk.navigation.ui.navigation.instructioncontainer.e(adviseInfo));
        if (!adviseInfo.isRouteBeingRecalculated() || adviseInfo.isOnRoute()) {
            qVar.a.setValue(new com.mappls.sdk.navigation.ui.navigation.infobar.l(adviseInfo, (currentRoute == null || currentRoute.legs() == null || currentRoute.legs().size() <= 0 || (legAnnotationAnnotation = currentRoute.legs().get(0).annotation()) == null) ? null : legAnnotationAnnotation.congestion(), (currentRoute == null || currentRoute.distance() == null) ? 0.0d : currentRoute.distance().doubleValue(), nodeIndex));
        }
        if (adviseInfo.isRouteBeingRecalculated() && !adviseInfo.isOnRoute()) {
            this.binding.alertView.updateRouteEvent(null);
            this.binding.tvSpeed.setVisibility(8);
            return;
        }
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null && (navigationCamera = cVar.f) != null && navigationCamera.isTrackingEnabled()) {
            this.binding.instructionContainer.setCurrentItem(adviseInfo.getPosition() == 0 ? 1 : adviseInfo.getPosition());
        }
        if (adviseInfo.getDistanceToNextAdvise() > 100) {
            if (this.isInPIPMode || !this.options.showCurrentSpeed().booleanValue()) {
                this.binding.tvSpeed.setVisibility(8);
            } else {
                this.binding.tvSpeed.setVisibility(0);
            }
            if (adviseInfo.getLocation() != null) {
                Location location = adviseInfo.getLocation();
                this.binding.tvSpeed.setText((((int) (location.getSpeed() * 18.0f)) / 5) + "\nkm/h");
            } else {
                this.binding.tvSpeed.setText("0\nkm/h");
            }
        } else {
            this.binding.tvSpeed.setVisibility(8);
        }
        if (!this.isInPIPMode && this.options.showNextInstructionBanner().booleanValue()) {
            this.binding.nextAdviseView.setVisibility(0);
        }
        List navigationSteps = MapplsNavigationHelper.getInstance().getNavigationSteps();
        if (adviseInfo.getPosition() != this.binding.instructionContainer.getSelectedItem() || navigationSteps.size() <= 2 || navigationSteps.size() - 1 <= adviseInfo.getPosition()) {
            this.binding.nextAdviseView.setVisibility(8);
        } else {
            LegStep legStep = (LegStep) ((NavigationStep) navigationSteps.get((adviseInfo.getPosition() == 0 ? 1 : adviseInfo.getPosition()) + 1)).getExtraInfo();
            if (legStep == null || !this.options.showNextInstructionBanner().booleanValue()) {
                this.binding.nextAdviseView.setVisibility(8);
            } else {
                this.binding.nextAdviseView.setDurationText(DirectionFormatter.getFormattedDistanceRound((float) ((LegStep) adviseInfo.getInfo()).distance(), com.mappls.sdk.navigation.ui.utils.d.a()));
                this.binding.nextAdviseView.setNextLegStep(legStep);
            }
        }
        if (adviseInfo.isOnRoute() && !this.isInPIPMode && this.options.showNextInstructionBanner().booleanValue()) {
            this.binding.nextAdviseView.setVisibility(0);
        }
        this.binding.instructionContainer.setDataContainer(false);
        this.binding.instructionContainerPip.setDataContainer();
        com.mappls.sdk.navigation.ui.map.c cVar2 = this.navigationMap;
        if (cVar2 != null) {
            Location location2 = adviseInfo.getLocation();
            MapplsNavigationHelper.getInstance().getNavigationSteps();
            RouteInformation routeInformation = new RouteInformation(MapplsNavigationHelper.getInstance().getCurrentRoute(), location2, adviseInfo);
            com.mappls.sdk.navigation.ui.f fVar = cVar2.i;
            if (fVar != null) {
                Iterator it2 = fVar.a.iterator();
                while (it2.hasNext()) {
                    ((ProgressChangeListener) it2.next()).onProgressChange(location2, routeInformation);
                }
            }
        }
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onSatelliteInfoChanged(GPSInfo gPSInfo) {
        if (!MapplsNavigationHelper.getInstance().isNavigating()) {
            hideWarning();
        } else {
            this.gpsInfo = gPSInfo;
            this.gpsHandler.postDelayed(this.gpsRunnable, 2000L);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onSaveInstanceState(bundle);
        }
        try {
            bundle.putParcelable("mappls_navigation_view_state", new com.mappls.sdk.navigation.ui.model.a(this.binding.nextAdviseView.getVisibility() == 0, this.binding.followButton.getVisibility() == 0, this.binding.tvSpeed.getVisibility() == 0, this.binding.settingsView.isVisible(), this.binding.directionList.isVisible()));
        } catch (Exception unused) {
        }
    }

    public void onStart() {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onStart();
        }
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null) {
            NavigationMapRoute navigationMapRoute = cVar.c;
            if (navigationMapRoute != null) {
                navigationMapRoute.onStart();
            }
            NavigationCamera navigationCamera = cVar.f;
            if (navigationCamera != null) {
                navigationCamera.onStart();
            }
        }
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    public void onStop() {
        if (this.options.isUsingInternalMap().booleanValue()) {
            this.mapView.onStop();
        }
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null) {
            NavigationMapRoute navigationMapRoute = cVar.c;
            if (navigationMapRoute != null) {
                navigationMapRoute.onStop();
            }
            NavigationCamera navigationCamera = cVar.f;
            if (navigationCamera != null) {
                navigationCamera.onStop();
            }
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onWayPointReached(WayPoint wayPoint) {
        NavigationCallback navigationCallback = this.navigationCallback;
        if (navigationCallback != null) {
            navigationCallback.onWayPointReached(wayPoint);
        }
    }

    public int selectedInstructionPosition() {
        return this.binding.instructionContainer.getSelectedItem();
    }

    public void setCustomInfoBarItem(List<CustomInfoBarItem> list) {
        this.customInfoBarItems.clear();
        this.customInfoBarItems.addAll(list);
        LayoutNavigationViewBinding layoutNavigationViewBinding = this.binding;
        if (layoutNavigationViewBinding != null) {
            layoutNavigationViewBinding.infobarView.setCustomInfoBarItem(list);
        }
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
        if (this.isViewCreated) {
            init();
        }
    }

    public void setNavigationViewCallback(NavigationViewCallback navigationViewCallback) {
        this.navigationViewCallback = navigationViewCallback;
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            navigationViewCallback.onNavigationMapReady(mapplsMap);
        }
    }

    public void setOnNavigationCallback(NavigationCallback navigationCallback) {
        this.navigationCallback = navigationCallback;
    }

    public void showWarning(String str, int i) {
        if (this.options.showWarningMessage().booleanValue()) {
            this.binding.warningTextView.setVisibility(0);
            this.binding.warningTextView.setText(str);
            this.binding.warningTextView.setBackgroundColor(i);
        }
    }

    public void toggleTheme() {
        Context context = getContext();
        NavigationOptions navigationOptions = this.navigationViewModel.d;
        context.setTheme((com.mappls.sdk.navigation.ui.theme.a.a() ? navigationOptions.navigationDarkTheme() : navigationOptions.navigationLightTheme()).intValue());
        getContext();
        MapView mapView = this.mapView;
        if (mapView != null && mapView.getCompassView() != null) {
            if (com.mappls.sdk.navigation.ui.theme.a.a()) {
                mapView.getCompassView().setBackgroundResource(R.drawable.compass_background_dark);
            } else {
                mapView.getCompassView().setBackgroundResource(R.drawable.compass_background_light);
            }
        }
        TextView textView = this.binding.tvSpeed;
        Context context2 = getContext();
        textView.setBackground(AppCompatResources.getDrawable(context2, com.mappls.sdk.navigation.ui.theme.a.a(context2, R.attr.navigationViewSpeedBackground).resourceId));
        this.binding.tvSpeed.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewSpeedTextColor));
        ImageView imageView = this.binding.searchAlongRoute;
        Context context3 = getContext();
        imageView.setBackground(AppCompatResources.getDrawable(context3, com.mappls.sdk.navigation.ui.theme.a.a(context3, R.attr.navigationViewSearchAlongRouteBackground).resourceId));
        ImageView imageView2 = this.binding.searchAlongRoute;
        Context context4 = getContext();
        imageView2.setImageDrawable(AppCompatResources.getDrawable(context4, com.mappls.sdk.navigation.ui.theme.a.a(context4, R.attr.navigationViewSearchAlongRouteIcon).resourceId));
        this.binding.infobarView.toogleTheme();
        this.binding.directionList.toggleTheme();
        this.binding.soundView.toggleTheme();
        this.binding.nextAdviseView.toggleTheme();
        this.binding.alertView.toggleTheme();
        this.binding.settingsView.toggleTheme();
        this.binding.followButton.toggleTheme();
        this.binding.navigationFinishedView.toggleTheme();
        MapplsNavigationHelper mapplsNavigationHelper = MapplsNavigationHelper.getInstance();
        getContext();
        mapplsNavigationHelper.setJunctionViewMode(com.mappls.sdk.navigation.ui.theme.a.a() ? "night" : WeatherCriteria.UNIT_TYPE_DAY);
        com.mappls.sdk.navigation.ui.map.c cVar = this.navigationMap;
        if (cVar != null) {
            cVar.b.getContext();
            if (com.mappls.sdk.navigation.ui.theme.a.a()) {
                cVar.a.getUiSettings().setCompassImage(ContextCompat.getDrawable(cVar.b.getContext(), R.drawable.compass_north_up_dark));
            } else {
                cVar.a.getUiSettings().setCompassImage(ContextCompat.getDrawable(cVar.b.getContext(), R.drawable.compass_north_up_light));
            }
        }
    }

    public NavigationView(Context context, NavigationOptions navigationOptions) {
        super(context);
        this.binding = LayoutNavigationViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        this.gpsHandler = new Handler();
        this.customInfoBarItems = new ArrayList();
        this.isViewCreated = false;
        this.gpsRunnable = new g(this);
        this.options = navigationOptions;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        com.mappls.sdk.navigation.ui.theme.a.a(getContext(), navigationOptions);
        initializeViewModel();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = LayoutNavigationViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        this.gpsHandler = new Handler();
        this.customInfoBarItems = new ArrayList();
        this.isViewCreated = false;
        this.gpsRunnable = new g(this);
        NavigationOptions navigationOptionsCreateFromAttributes = NavigationOptions.createFromAttributes(context, attributeSet);
        this.options = navigationOptionsCreateFromAttributes;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        com.mappls.sdk.navigation.ui.theme.a.a(getContext(), navigationOptionsCreateFromAttributes);
        initializeViewModel();
    }
}
