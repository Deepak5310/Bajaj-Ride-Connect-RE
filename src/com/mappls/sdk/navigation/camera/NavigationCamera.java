package com.mappls.sdk.navigation.camera;

import android.location.Location;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.OnCameraTrackingChangedListener;
import com.mappls.sdk.maps.location.OnLocationCameraTransitionListener;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationCamera {
    private static final double MAX_TILT = 60.0d;
    private static final double MIN_TILT = 0.0d;
    public static final int NAVIGATION_TRACKING_MODE_GPS = 0;
    public static final int NAVIGATION_TRACKING_MODE_NONE = 2;
    public static final int NAVIGATION_TRACKING_MODE_NORTH = 1;
    private static final String NULL_ROUTE_ERROR_MESSAGE = "Unable to show route overview, the route is null.";
    private static final int ONE_POINT = 1;
    private CameraAnimationDelegate animationDelegate;
    private Camera camera;
    private final OnCameraTrackingChangedListener cameraTrackingChangedListener;
    private Location currentLocation;
    private RouteInformation currentRouteInformation;
    private AdviseInfo currentRouteProgress;
    private boolean isCameraResetting;
    private LocationComponent locationComponent;
    private MapplsMap mapplsMap;
    private INavigation navigation;
    private NavigationMode navigationMode;
    private ProgressChangeListener progressChangeListener;
    private int trackingCameraMode;
    private final CopyOnWriteArraySet<OnTrackingModeTransitionListener> onTrackingModeTransitionListeners = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<OnTrackingModeChangedListener> onTrackingModeChangedListeners = new CopyOnWriteArraySet<>();
    private final OnLocationCameraTransitionListener cameraTransitionListener = new NavigationCameraTransitionListener(this);

    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackingMode {
    }

    public void onRouteProgress(AdviseInfo adviseInfo) {
        this.currentRouteProgress = adviseInfo;
        this.currentLocation = adviseInfo.getLocation();
        tryToBuildRouteInformationAndAdjustCamera();
    }

    public void setMaxCameraZoom(double d) {
        Camera camera = this.camera;
        if (camera == null || !(camera instanceof DynamicCamera)) {
            return;
        }
        ((DynamicCamera) camera).setMaxCameraZoom(d);
    }

    public void setMinCameraZoom(double d) {
        Camera camera = this.camera;
        if (camera == null || !(camera instanceof DynamicCamera)) {
            return;
        }
        ((DynamicCamera) camera).setMinCameraZoom(d);
    }

    public void setDefaultZoom(double d) {
        Camera camera = this.camera;
        if (camera == null || !(camera instanceof DynamicCamera)) {
            return;
        }
        ((DynamicCamera) camera).setDefaultZoom(d);
    }

    public NavigationCamera(MapplsMap mapplsMap) {
        NavigationCameraTrackingChangedListener navigationCameraTrackingChangedListener = new NavigationCameraTrackingChangedListener(this);
        this.cameraTrackingChangedListener = navigationCameraTrackingChangedListener;
        this.navigationMode = NavigationMode.DEFAULT;
        this.trackingCameraMode = 0;
        this.progressChangeListener = new ProgressChangeListener() { // from class: com.mappls.sdk.navigation.camera.NavigationCamera.1
            @Override // com.mappls.sdk.navigation.camera.ProgressChangeListener
            public void onProgressChange(Location location, RouteInformation routeInformation) {
                NavigationCamera.this.currentRouteProgress = routeInformation.getAdviseInfo();
                NavigationCamera.this.currentLocation = location;
                NavigationCamera.this.tryToBuildRouteInformationAndAdjustCamera();
            }
        };
        this.mapplsMap = mapplsMap;
        this.locationComponent = mapplsMap.getLocationComponent();
        this.animationDelegate = new CameraAnimationDelegate(mapplsMap);
        this.locationComponent.addOnCameraTrackingChangedListener(navigationCameraTrackingChangedListener);
        this.camera = new DynamicCamera(mapplsMap);
    }

    NavigationCamera(MapplsMap mapplsMap, LocationComponent locationComponent) {
        NavigationCameraTrackingChangedListener navigationCameraTrackingChangedListener = new NavigationCameraTrackingChangedListener(this);
        this.cameraTrackingChangedListener = navigationCameraTrackingChangedListener;
        this.navigationMode = NavigationMode.DEFAULT;
        this.trackingCameraMode = 0;
        this.progressChangeListener = new ProgressChangeListener() { // from class: com.mappls.sdk.navigation.camera.NavigationCamera.1
            @Override // com.mappls.sdk.navigation.camera.ProgressChangeListener
            public void onProgressChange(Location location, RouteInformation routeInformation) {
                NavigationCamera.this.currentRouteProgress = routeInformation.getAdviseInfo();
                NavigationCamera.this.currentLocation = location;
                NavigationCamera.this.tryToBuildRouteInformationAndAdjustCamera();
            }
        };
        this.mapplsMap = mapplsMap;
        this.locationComponent = locationComponent;
        this.animationDelegate = new CameraAnimationDelegate(mapplsMap);
        this.locationComponent.addOnCameraTrackingChangedListener(navigationCameraTrackingChangedListener);
        this.camera = new DynamicCamera(mapplsMap);
    }

    public void start(DirectionsRoute directionsRoute) {
        if (directionsRoute != null) {
            this.currentRouteInformation = buildRouteInformationFromRoute(directionsRoute);
        }
        this.navigation.setProgressChangeListener(this.progressChangeListener);
    }

    public void resume(Location location) {
        if (location != null) {
            this.currentRouteInformation = buildRouteInformationFromLocation(location, null);
        }
        this.navigation.setProgressChangeListener(this.progressChangeListener);
    }

    public void updateCameraTrackingMode(int i) {
        setCameraMode(i);
    }

    public boolean isTrackingEnabled() {
        return this.trackingCameraMode != 2;
    }

    public int getCameraTrackingMode() {
        return this.trackingCameraMode;
    }

    public void resetCameraPositionWith(int i) {
        resetWith(i);
    }

    @Deprecated
    public void showRouteOverview(int[] iArr) {
        showRouteGeometryOverview(iArr);
    }

    public boolean showRouteGeometryOverview(int[] iArr) {
        updateCameraTrackingMode(2);
        DirectionsRoute route = getRoute();
        if (route == null) {
            Timber.e(NULL_ROUTE_ERROR_MESSAGE, new Object[0]);
            return false;
        }
        return showOverviewForRoute(iArr, new RouteInformation(route, null, null));
    }

    public boolean showRouteGeometryRemainingOverview(int[] iArr) {
        DirectionsRoute route = getRoute();
        if (route == null) {
            Timber.e(NULL_ROUTE_ERROR_MESSAGE, new Object[0]);
            return false;
        }
        return showOverviewForRoute(iArr, new RouteInformation(route, null, this.currentRouteProgress));
    }

    private boolean showOverviewForRoute(int[] iArr, RouteInformation routeInformation) {
        updateCameraTrackingMode(2);
        return animateCameraForRouteOverview(routeInformation, iArr);
    }

    private DirectionsRoute getRoute() {
        if (this.currentRouteProgress != null) {
            return MapplsNavigationHelper.getInstance().getCurrentRoute();
        }
        RouteInformation routeInformation = this.currentRouteInformation;
        if (routeInformation != null) {
            return routeInformation.getRoute();
        }
        return null;
    }

    public void update(NavigationCameraUpdate navigationCameraUpdate) {
        this.animationDelegate.render(navigationCameraUpdate, 300, null);
    }

    public void update(NavigationCameraUpdate navigationCameraUpdate, int i) {
        this.animationDelegate.render(navigationCameraUpdate, i, null);
    }

    public void update(NavigationCameraUpdate navigationCameraUpdate, int i, MapplsMap.CancelableCallback cancelableCallback) {
        this.animationDelegate.render(navigationCameraUpdate, i, cancelableCallback);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        INavigation iNavigation = this.navigation;
        if (iNavigation != null) {
            iNavigation.setProgressChangeListener(this.progressChangeListener);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        INavigation iNavigation = this.navigation;
        if (iNavigation != null) {
            iNavigation.removeProgressChangeListener(this.progressChangeListener);
        }
    }

    public void addProgressChangeListener(INavigation iNavigation) {
        this.navigation = iNavigation;
        iNavigation.setProgressChangeListener(this.progressChangeListener);
    }

    public void removeProgressChangeListener() {
        INavigation iNavigation = this.navigation;
        if (iNavigation != null) {
            iNavigation.removeProgressChangeListener(this.progressChangeListener);
        }
    }

    public void addOnTrackingModeTransitionListener(OnTrackingModeTransitionListener onTrackingModeTransitionListener) {
        this.onTrackingModeTransitionListeners.add(onTrackingModeTransitionListener);
    }

    public void removeOnTrackingModeTransitionListener(OnTrackingModeTransitionListener onTrackingModeTransitionListener) {
        this.onTrackingModeTransitionListeners.remove(onTrackingModeTransitionListener);
    }

    public void addOnTrackingModeChangedListener(OnTrackingModeChangedListener onTrackingModeChangedListener) {
        this.onTrackingModeChangedListeners.add(onTrackingModeChangedListener);
    }

    public void removeOnTrackingModeChangedListener(OnTrackingModeChangedListener onTrackingModeChangedListener) {
        this.onTrackingModeChangedListeners.remove(onTrackingModeChangedListener);
    }

    void updateTransitionListenersFinished(int i) {
        onCameraTransitionFinished();
        Integer numFindTrackingModeFor = findTrackingModeFor(i);
        if (numFindTrackingModeFor == null) {
            return;
        }
        Iterator<OnTrackingModeTransitionListener> it2 = this.onTrackingModeTransitionListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onTransitionFinished(numFindTrackingModeFor.intValue());
        }
    }

    void updateTransitionListenersCancelled(int i) {
        Integer numFindTrackingModeFor = findTrackingModeFor(i);
        if (numFindTrackingModeFor == null) {
            return;
        }
        Iterator<OnTrackingModeTransitionListener> it2 = this.onTrackingModeTransitionListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onTransitionCancelled(numFindTrackingModeFor.intValue());
        }
    }

    Integer findTrackingModeFor(int i) {
        if (i == 34) {
            return 0;
        }
        if (i == 36) {
            return 1;
        }
        return i == 8 ? 2 : null;
    }

    void updateIsResetting(boolean z) {
        this.isCameraResetting = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToBuildRouteInformationAndAdjustCamera() {
        AdviseInfo adviseInfo;
        if (!isTrackingEnabled() || (adviseInfo = this.currentRouteProgress) == null) {
            return;
        }
        RouteInformation routeInformation = new RouteInformation(null, this.currentLocation, adviseInfo);
        this.currentRouteInformation = routeInformation;
        if (this.isCameraResetting) {
            return;
        }
        adjustCameraFromLocation(routeInformation);
    }

    private RouteInformation buildRouteInformationFromRoute(DirectionsRoute directionsRoute) {
        return new RouteInformation(directionsRoute, null, null);
    }

    private RouteInformation buildRouteInformationFromLocation(Location location, AdviseInfo adviseInfo) {
        return new RouteInformation(null, location, adviseInfo);
    }

    private void onCameraTransitionFinished() {
        RouteInformation routeInformation;
        if (!this.isCameraResetting || (routeInformation = this.currentRouteInformation) == null) {
            return;
        }
        adjustCameraForReset(routeInformation);
    }

    private boolean animateCameraForRouteOverview(RouteInformation routeInformation, int[] iArr) {
        List<Point> listOverview = this.camera.overview(routeInformation);
        if (listOverview.isEmpty() || listOverview.size() <= 1) {
            return false;
        }
        animateMapplsMapForRouteOverview(iArr, listOverview);
        return true;
    }

    private void animateMapplsMapForRouteOverview(int[] iArr, List<Point> list) {
        this.mapplsMap.animateCamera(buildResetCameraUpdate(), 150, new CameraOverviewCancelableCallback(buildOverviewCameraUpdate(iArr, list), this.mapplsMap));
    }

    private CameraUpdate buildResetCameraUpdate() {
        return CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().tilt(0.0d).bearing(0.0d).build());
    }

    private CameraUpdate buildOverviewCameraUpdate(int[] iArr, List<Point> list) {
        return CameraUpdateFactory.newLatLngBounds(convertRoutePointsToLatLngBounds(list), iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    private LatLngBounds convertRoutePointsToLatLngBounds(List<Point> list) {
        ArrayList arrayList = new ArrayList();
        for (Point point : list) {
            arrayList.add(new LatLng(point.latitude(), point.longitude()));
        }
        return new LatLngBounds.Builder().includes(arrayList).build();
    }

    private void setCameraMode(int i) {
        Integer numFindCameraModeFor = findCameraModeFor(i);
        if (numFindCameraModeFor != null) {
            this.trackingCameraMode = i;
            updateTrackingModeListenersWith(i);
            if (numFindCameraModeFor.intValue() == this.locationComponent.getCameraMode() || !this.locationComponent.isLocationComponentActivated()) {
                return;
            }
            this.locationComponent.setCameraMode(numFindCameraModeFor.intValue(), this.cameraTransitionListener);
            return;
        }
        Timber.e("Using unsupported camera tracking mode - %d.", Integer.valueOf(i));
    }

    private Integer findCameraModeFor(int i) {
        if (i == 0) {
            return 34;
        }
        if (i == 1) {
            return 36;
        }
        return i == 2 ? 8 : null;
    }

    private void updateTrackingModeListenersWith(int i) {
        Iterator<OnTrackingModeChangedListener> it2 = this.onTrackingModeChangedListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onTrackingModeChanged(i);
        }
    }

    private void resetWith(int i) {
        updateIsResetting(true);
        resetDynamicCamera(this.camera);
        updateCameraTrackingMode(i);
    }

    private void resetDynamicCamera(Camera camera) {
        if (camera instanceof DynamicCamera) {
            ((DynamicCamera) camera).forceResetZoomLevel();
        }
    }

    private void adjustCameraForReset(RouteInformation routeInformation) {
        float fTilt = (float) this.camera.tilt(routeInformation);
        double dZoom = this.camera.zoom(routeInformation);
        if (this.locationComponent.isLocationComponentActivated()) {
            this.locationComponent.zoomWhileTracking(dZoom, getZoomAnimationDuration(dZoom), new ResetCancelableCallback(this));
            double d = fTilt;
            this.locationComponent.tiltWhileTracking(d, getTiltAnimationDuration(d));
        }
    }

    private void adjustCameraFromLocation(RouteInformation routeInformation) {
        double dTilt;
        if (this.navigationMode == NavigationMode.DEFAULT) {
            dTilt = this.camera.tilt(routeInformation);
        } else if (this.navigationMode == NavigationMode.TWO_D) {
            dTilt = 0.0d;
        } else {
            dTilt = this.navigationMode == NavigationMode.THREE_D ? 60.0d : this.camera.tilt(routeInformation);
        }
        double dZoom = this.camera.zoom(routeInformation);
        if (this.locationComponent.isLocationComponentActivated()) {
            this.locationComponent.zoomWhileTracking(dZoom, getZoomAnimationDuration(dZoom));
            this.locationComponent.tiltWhileTracking(dTilt, getTiltAnimationDuration(dTilt));
            if (routeInformation.getLocation() != null) {
                this.locationComponent.forceLocationUpdate(routeInformation.getLocation());
            }
        }
    }

    private long getZoomAnimationDuration(double d) {
        return (long) MathUtils.clamp(Math.abs(this.mapplsMap.getCameraPosition().zoom - d) * 500.0d, 300.0d, 1000.0d);
    }

    public void toggleTilt(boolean z) {
        if (z) {
            this.navigationMode = NavigationMode.THREE_D;
            if (this.locationComponent.isLocationComponentActivated()) {
                this.locationComponent.tiltWhileTracking(60.0d, getTiltAnimationDuration(60.0d));
                return;
            }
            return;
        }
        this.navigationMode = NavigationMode.TWO_D;
        if (this.locationComponent.isLocationComponentActivated()) {
            this.locationComponent.tiltWhileTracking(0.0d, getTiltAnimationDuration(0.0d));
        }
    }

    public void resetNavigationMode() {
        this.navigationMode = NavigationMode.DEFAULT;
        adjustCameraForReset(this.currentRouteInformation);
    }

    public NavigationMode getNavigationMode() {
        return this.navigationMode;
    }

    private long getTiltAnimationDuration(double d) {
        return (long) MathUtils.clamp(Math.abs(this.mapplsMap.getCameraPosition().tilt - d) * 500.0d, 750.0d, 1000.0d);
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
