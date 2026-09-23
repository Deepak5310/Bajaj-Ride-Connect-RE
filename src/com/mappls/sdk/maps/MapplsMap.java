package com.mappls.sdk.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.gestures.AndroidGesturesManager;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.gestures.RotateGestureDetector;
import com.mappls.sdk.gestures.ShoveGestureDetector;
import com.mappls.sdk.gestures.StandardScaleGestureDetector;
import com.mappls.sdk.maps.annotations.Annotation;
import com.mappls.sdk.maps.annotations.BaseMarkerOptions;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.annotations.MarkerOptions;
import com.mappls.sdk.maps.annotations.Polygon;
import com.mappls.sdk.maps.annotations.PolygonOptions;
import com.mappls.sdk.maps.annotations.Polyline;
import com.mappls.sdk.maps.annotations.PolylineOptions;
import com.mappls.sdk.maps.camera.CameraMapplsPinBoundUpdate;
import com.mappls.sdk.maps.camera.CameraMapplsPinCallback;
import com.mappls.sdk.maps.camera.CameraMapplsPinPosition;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdate;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdateFactory;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.offline.OfflineRegionDefinition;
import com.mappls.sdk.maps.style.OnStyleLoadListener;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.model.MapplsStyle;
import com.mappls.sdk.maps.widgets.indoor.IndoorConstants;
import com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class MapplsMap {
    private static final String TAG = "Mbgl-MapplsMap";
    private AnnotationManager annotationManager;
    private final List<Style.OnStyleLoaded> awaitingStyleGetters;
    private final CameraChangeDispatcher cameraChangeDispatcher;
    private boolean debugActive;
    private final List<OnDeveloperAnimationListener> developerAnimationStartedListeners;
    private LocationComponent locationComponent;
    private final NativeMap nativeMapView;
    private OnFpsChangedListener onFpsChangedListener;
    private final OnGesturesManagerInteractionListener onGesturesManagerInteractionListener;
    private OnStyleLoadListener onStyleLoadListener;
    private OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener;
    private PlaceIdPlugin placeIdPlugin;
    private final Projection projection;
    private boolean started;
    private Style style;
    private StyleLayerControl styleLayerControl;
    private Style.OnStyleLoaded styleLoadedCallback;
    private TrafficPlugin trafficPlugin;
    private final Transform transform;
    private final UiSettings uiSettings;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    @Deprecated
    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 3;
        public static final int REASON_API_GESTURE = 1;
        public static final int REASON_DEVELOPER_ANIMATION = 2;

        void onCameraMoveStarted(int i);
    }

    public interface OnCompassAnimationListener {
        void onCompassAnimation();

        void onCompassAnimationFinished();
    }

    public interface OnDeveloperAnimationListener {
        void onDeveloperAnimationStarted();
    }

    public interface OnFlingListener {
        void onFling();
    }

    public interface OnFpsChangedListener {
        void onFpsChanged(double d);
    }

    interface OnGesturesManagerInteractionListener {
        void cancelAllVelocityAnimations();

        AndroidGesturesManager getGesturesManager();

        void onAddFlingListener(OnFlingListener onFlingListener);

        void onAddMapClickListener(OnMapClickListener onMapClickListener);

        void onAddMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

        void onAddMoveListener(OnMoveListener onMoveListener);

        void onAddRotateListener(OnRotateListener onRotateListener);

        void onAddScaleListener(OnScaleListener onScaleListener);

        void onAddShoveListener(OnShoveListener onShoveListener);

        void onRemoveFlingListener(OnFlingListener onFlingListener);

        void onRemoveMapClickListener(OnMapClickListener onMapClickListener);

        void onRemoveMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

        void onRemoveMoveListener(OnMoveListener onMoveListener);

        void onRemoveRotateListener(OnRotateListener onRotateListener);

        void onRemoveScaleListener(OnScaleListener onScaleListener);

        void onRemoveShoveListener(OnShoveListener onShoveListener);

        void setGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z, boolean z2);
    }

    public interface OnInfoWindowClickListener {
        boolean onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        boolean onMapClick(LatLng latLng);
    }

    public interface OnMapLongClickListener {
        boolean onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerAddedListener {
        void onFailure();

        void onSuccess();
    }

    @Deprecated
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMoveListener {
        void onMove(MoveGestureDetector moveGestureDetector);

        void onMoveBegin(MoveGestureDetector moveGestureDetector);

        void onMoveEnd(MoveGestureDetector moveGestureDetector);
    }

    @Deprecated
    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    @Deprecated
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface OnRotateListener {
        void onRotate(RotateGestureDetector rotateGestureDetector);

        void onRotateBegin(RotateGestureDetector rotateGestureDetector);

        void onRotateEnd(RotateGestureDetector rotateGestureDetector);
    }

    public interface OnScaleListener {
        void onScale(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector);
    }

    public interface OnShoveListener {
        void onShove(ShoveGestureDetector shoveGestureDetector);

        void onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector);
    }

    public interface OnSurfaceBitmapChangeListener {
        void onSurfaceBitmapChanged(Bitmap bitmap);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    MapplsMap(NativeMap nativeMap, Transform transform, Projection projection, OnGesturesManagerInteractionListener onGesturesManagerInteractionListener, CameraChangeDispatcher cameraChangeDispatcher, List<OnDeveloperAnimationListener> list) {
        this.awaitingStyleGetters = new ArrayList();
        this.nativeMapView = nativeMap;
        this.uiSettings = null;
        this.projection = projection;
        this.transform = transform;
        this.onGesturesManagerInteractionListener = onGesturesManagerInteractionListener;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
        this.developerAnimationStartedListeners = list;
    }

    MapplsMap(NativeMap nativeMap, Transform transform, UiSettings uiSettings, Projection projection, OnGesturesManagerInteractionListener onGesturesManagerInteractionListener, CameraChangeDispatcher cameraChangeDispatcher, List<OnDeveloperAnimationListener> list) {
        this.awaitingStyleGetters = new ArrayList();
        this.nativeMapView = nativeMap;
        this.uiSettings = uiSettings;
        this.projection = projection;
        this.transform = transform;
        this.onGesturesManagerInteractionListener = onGesturesManagerInteractionListener;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
        this.developerAnimationStartedListeners = list;
    }

    public void triggerRepaint() {
        this.nativeMapView.triggerRepaint();
    }

    void initialise(Context context, MapplsMapOptions mapplsMapOptions) {
        this.transform.initialise(this, mapplsMapOptions);
        UiSettings uiSettings = this.uiSettings;
        if (uiSettings != null) {
            uiSettings.initialise(context, mapplsMapOptions);
        }
        setDebugActive(mapplsMapOptions.getDebugActive());
        setApiBaseUrl(mapplsMapOptions);
        setPrefetchesTiles(mapplsMapOptions);
    }

    public void getStyle(Style.OnStyleLoaded onStyleLoaded) {
        Style style = this.style;
        if (style != null && style.isFullyLoaded()) {
            onStyleLoaded.onStyleLoaded(this.style);
        } else {
            this.awaitingStyleGetters.add(onStyleLoaded);
        }
    }

    public Style getStyle() {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded()) {
            return null;
        }
        return this.style;
    }

    public void setMapplsStyle(String str) {
        this.onStyleLoadListener = null;
        setStyle(new Style.Builder().fromMapplsStyle(str));
    }

    void onStart() {
        this.started = true;
        if (TextUtils.isEmpty(this.nativeMapView.getStyleUri()) && TextUtils.isEmpty(this.nativeMapView.getStyleJson())) {
            setStyle(new Style.Builder());
        }
        this.locationComponent.onStart();
    }

    void onStop() {
        this.started = false;
        this.locationComponent.onStop();
    }

    void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(MapplsConstants.STATE_CAMERA_POSITION, this.transform.getCameraPosition());
        bundle.putBoolean(MapplsConstants.STATE_DEBUG_ACTIVE, isDebugActive());
        UiSettings uiSettings = this.uiSettings;
        if (uiSettings != null) {
            uiSettings.onSaveInstanceState(bundle);
        }
    }

    void onRestoreInstanceState(Bundle bundle) {
        CameraPosition cameraPosition = (CameraPosition) bundle.getParcelable(MapplsConstants.STATE_CAMERA_POSITION);
        UiSettings uiSettings = this.uiSettings;
        if (uiSettings != null) {
            uiSettings.onRestoreInstanceState(bundle);
        }
        if (cameraPosition != null) {
            moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(cameraPosition).build()));
        }
        this.nativeMapView.setDebug(bundle.getBoolean(MapplsConstants.STATE_DEBUG_ACTIVE));
    }

    void onDestroy() {
        this.locationComponent.onDestroy();
        Style style = this.style;
        if (style != null) {
            style.clear();
        }
        this.cameraChangeDispatcher.onDestroy();
    }

    public void setFloor(int i) {
        if (getUiSettings() == null || getUiSettings().getLayerControl() == null) {
            return;
        }
        getUiSettings().getLayerControl().setFloor(i);
    }

    void onPreMapReady() {
        this.transform.invalidateCameraPosition();
        this.annotationManager.reloadMarkers();
        this.annotationManager.adjustTopOffsetPixels(this);
        if (getUiSettings() != null && getUiSettings().getAttributionsView() != null && getUiSettings().getAttributionsView().getMap() == null) {
            getUiSettings().getAttributionsView().setMap(this);
        }
        if (getUiSettings() == null || getUiSettings().getLayerControl() == null || getUiSettings().getLayerControl().getMap() != null) {
            return;
        }
        getUiSettings().getLayerControl().setMap(this);
        getUiSettings().getLayerControl().addOnIndoorListener(new IndoorListener() { // from class: com.mappls.sdk.maps.MapplsMap.1
            @Override // com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener
            public void showControl(int i, int i2, int i3) {
                MapplsMap.this.getUiSettings().getLayerControl().onFloorsChange(IndoorConstants.getFloors(i3, i));
            }

            @Override // com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener
            public void hideControl() {
                MapplsMap.this.getUiSettings().getLayerControl().onFloorsChange(new ArrayList());
                MapplsMap.this.getUiSettings().getLayerControl().setFloor(0);
            }
        });
    }

    public void addOnIndoorListener(IndoorListener indoorListener) {
        if (getUiSettings().getLayerControl() != null) {
            getUiSettings().getLayerControl().addOnIndoorListener(indoorListener);
        }
    }

    public boolean removeIndoorListener(IndoorListener indoorListener) {
        if (getUiSettings().getLayerControl() != null) {
            return getUiSettings().getLayerControl().removeIndoorListener(indoorListener);
        }
        return false;
    }

    void onPostMapReady() {
        this.transform.invalidateCameraPosition();
    }

    void onFinishLoadingStyle() {
        notifyStyleLoaded();
    }

    void onFailLoadingStyle() {
        this.styleLoadedCallback = null;
        OnStyleLoadListener onStyleLoadListener = this.onStyleLoadListener;
        if (onStyleLoadListener != null) {
            onStyleLoadListener.onError("Fail to load style");
            this.onStyleLoadListener = null;
        }
    }

    void onUpdateRegionChange() {
        this.annotationManager.update();
    }

    void onUpdateFullyRendered() {
        UiSettings uiSettings;
        CameraPosition cameraPositionInvalidateCameraPosition = this.transform.invalidateCameraPosition();
        if (cameraPositionInvalidateCameraPosition == null || (uiSettings = this.uiSettings) == null) {
            return;
        }
        uiSettings.update(cameraPositionInvalidateCameraPosition);
    }

    long getNativeMapPtr() {
        return this.nativeMapView.getNativePtr();
    }

    private void setPrefetchesTiles(MapplsMapOptions mapplsMapOptions) {
        if (!mapplsMapOptions.getPrefetchesTiles()) {
            setPrefetchZoomDelta(0);
        } else {
            setPrefetchZoomDelta(mapplsMapOptions.getPrefetchZoomDelta());
        }
    }

    @Deprecated
    public void setPrefetchesTiles(boolean z) {
        this.nativeMapView.setPrefetchTiles(z);
    }

    @Deprecated
    public boolean getPrefetchesTiles() {
        return this.nativeMapView.getPrefetchTiles();
    }

    public void setPrefetchZoomDelta(int i) {
        this.nativeMapView.setPrefetchZoomDelta(i);
    }

    public int getPrefetchZoomDelta() {
        return this.nativeMapView.getPrefetchZoomDelta();
    }

    public void setMinZoomPreference(double d) {
        this.transform.setMinZoom(d);
    }

    public double getMinZoomLevel() {
        return this.transform.getMinZoom();
    }

    public void setMaxZoomPreference(double d) {
        this.transform.setMaxZoom(d);
    }

    public double getMaxZoomLevel() {
        return this.transform.getMaxZoom();
    }

    public void setMinPitchPreference(double d) {
        this.transform.setMinPitch(d);
    }

    public double getMinPitch() {
        return this.transform.getMinPitch();
    }

    public void setMaxPitchPreference(double d) {
        this.transform.setMaxPitch(d);
    }

    public double getMaxPitch() {
        return this.transform.getMaxPitch();
    }

    public UiSettings getUiSettings() {
        return this.uiSettings;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void cancelTransitions() {
        this.transform.cancelTransitions();
    }

    public final CameraPosition getCameraPosition() {
        return this.transform.getCameraPosition();
    }

    public void setCameraPosition(CameraPosition cameraPosition) {
        moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), (CancelableCallback) null);
    }

    public void setCameraMapplsPinPosition(CameraMapplsPinPosition cameraMapplsPinPosition) {
        moveCamera(CameraMapplsPinUpdateFactory.newCameraPosition(cameraMapplsPinPosition), (CancelableCallback) null);
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        moveCamera(cameraUpdate, (CancelableCallback) null);
    }

    public final void moveCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        notifyDeveloperAnimationListeners();
        this.transform.moveCamera(this, cameraUpdate, cancelableCallback);
    }

    public final void easeCamera(CameraUpdate cameraUpdate) {
        easeCamera(cameraUpdate, 300);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        easeCamera(cameraUpdate, 300, cancelableCallback);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i) {
        easeCamera(cameraUpdate, i, (CancelableCallback) null);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        easeCamera(cameraUpdate, i, true, cancelableCallback);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i, boolean z) {
        easeCamera(cameraUpdate, i, z, (CancelableCallback) null);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i, boolean z, CancelableCallback cancelableCallback) {
        if (i <= 0) {
            throw new IllegalArgumentException("Null duration passed into easeCamera");
        }
        notifyDeveloperAnimationListeners();
        this.transform.easeCamera(this, cameraUpdate, i, z, cancelableCallback);
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        animateCamera(cameraUpdate, 300, (CancelableCallback) null);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        animateCamera(cameraUpdate, 300, cancelableCallback);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i) {
        animateCamera(cameraUpdate, i, (CancelableCallback) null);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        if (i <= 0) {
            throw new IllegalArgumentException("Null duration passed into animateCamera");
        }
        notifyDeveloperAnimationListeners();
        this.transform.animateCamera(this, cameraUpdate, i, cancelableCallback);
    }

    public final void moveCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate) {
        moveCamera(cameraMapplsPinUpdate, (CancelableCallback) null);
    }

    public final void moveCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, CancelableCallback cancelableCallback) {
        notifyDeveloperAnimationListeners();
        this.transform.moveCamera(this, cameraMapplsPinUpdate, cancelableCallback);
    }

    public final void easeCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate) {
        easeCamera(cameraMapplsPinUpdate, 300);
    }

    public final void easeCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, CancelableCallback cancelableCallback) {
        easeCamera(cameraMapplsPinUpdate, 300, cancelableCallback);
    }

    public final void easeCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, int i) {
        easeCamera(cameraMapplsPinUpdate, i, (CancelableCallback) null);
    }

    public final void easeCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, int i, CancelableCallback cancelableCallback) {
        easeCamera(cameraMapplsPinUpdate, i, true, cancelableCallback);
    }

    public final void easeCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, int i, boolean z) {
        easeCamera(cameraMapplsPinUpdate, i, z, (CancelableCallback) null);
    }

    public final void easeCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, int i, boolean z, CancelableCallback cancelableCallback) {
        if (i <= 0) {
            throw new IllegalArgumentException("Null duration passed into easeCamera");
        }
        notifyDeveloperAnimationListeners();
        this.transform.easeCamera(this, cameraMapplsPinUpdate, i, z, cancelableCallback);
    }

    public final void animateCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate) {
        animateCamera(cameraMapplsPinUpdate, 300, (CancelableCallback) null);
    }

    public final void animateCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, CancelableCallback cancelableCallback) {
        animateCamera(cameraMapplsPinUpdate, 300, cancelableCallback);
    }

    public final void animateCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, int i) {
        animateCamera(cameraMapplsPinUpdate, i, (CancelableCallback) null);
    }

    public final void animateCamera(CameraMapplsPinUpdate cameraMapplsPinUpdate, int i, CancelableCallback cancelableCallback) {
        if (i <= 0) {
            throw new IllegalArgumentException("Null duration passed into animateCamera");
        }
        notifyDeveloperAnimationListeners();
        this.transform.animateCamera(this, cameraMapplsPinUpdate, i, cancelableCallback);
    }

    public final void moveCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate) {
        moveCamera(cameraMapplsPinBoundUpdate, (CancelableCallback) null);
    }

    public final void moveCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, final CancelableCallback cancelableCallback) {
        cameraMapplsPinBoundUpdate.getCameraMapplsPinPosition(this, new CameraMapplsPinCallback() { // from class: com.mappls.sdk.maps.MapplsMap.2
            @Override // com.mappls.sdk.maps.camera.CameraMapplsPinCallback
            public void getCameraUpdate(CameraUpdate cameraUpdate) {
                MapplsMap.this.moveCamera(cameraUpdate, cancelableCallback);
            }

            @Override // com.mappls.sdk.maps.camera.CameraMapplsPinCallback
            public void onError() {
                CancelableCallback cancelableCallback2 = cancelableCallback;
                if (cancelableCallback2 != null) {
                    cancelableCallback2.onCancel();
                }
            }
        });
    }

    public final void easeCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate) {
        easeCamera(cameraMapplsPinBoundUpdate, 300);
    }

    public final void easeCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, CancelableCallback cancelableCallback) {
        easeCamera(cameraMapplsPinBoundUpdate, 300, cancelableCallback);
    }

    public final void easeCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, int i) {
        easeCamera(cameraMapplsPinBoundUpdate, i, (CancelableCallback) null);
    }

    public final void easeCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, int i, CancelableCallback cancelableCallback) {
        easeCamera(cameraMapplsPinBoundUpdate, i, true, cancelableCallback);
    }

    public final void easeCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, int i, boolean z) {
        easeCamera(cameraMapplsPinBoundUpdate, i, z, (CancelableCallback) null);
    }

    public final void easeCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, final int i, final boolean z, final CancelableCallback cancelableCallback) {
        cameraMapplsPinBoundUpdate.getCameraMapplsPinPosition(this, new CameraMapplsPinCallback() { // from class: com.mappls.sdk.maps.MapplsMap.3
            @Override // com.mappls.sdk.maps.camera.CameraMapplsPinCallback
            public void getCameraUpdate(CameraUpdate cameraUpdate) {
                MapplsMap.this.easeCamera(cameraUpdate, i, z, cancelableCallback);
            }

            @Override // com.mappls.sdk.maps.camera.CameraMapplsPinCallback
            public void onError() {
                CancelableCallback cancelableCallback2 = cancelableCallback;
                if (cancelableCallback2 != null) {
                    cancelableCallback2.onFinish();
                }
            }
        });
    }

    public final void animateCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate) {
        animateCamera(cameraMapplsPinBoundUpdate, 300, (CancelableCallback) null);
    }

    public final void animateCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, CancelableCallback cancelableCallback) {
        animateCamera(cameraMapplsPinBoundUpdate, 300, cancelableCallback);
    }

    public final void animateCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, int i) {
        animateCamera(cameraMapplsPinBoundUpdate, i, (CancelableCallback) null);
    }

    public final void animateCamera(CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, final int i, final CancelableCallback cancelableCallback) {
        cameraMapplsPinBoundUpdate.getCameraMapplsPinPosition(this, new CameraMapplsPinCallback() { // from class: com.mappls.sdk.maps.MapplsMap.4
            @Override // com.mappls.sdk.maps.camera.CameraMapplsPinCallback
            public void getCameraUpdate(CameraUpdate cameraUpdate) {
                MapplsMap.this.animateCamera(cameraUpdate, i, cancelableCallback);
            }

            @Override // com.mappls.sdk.maps.camera.CameraMapplsPinCallback
            public void onError() {
                CancelableCallback cancelableCallback2 = cancelableCallback;
                if (cancelableCallback2 != null) {
                    cancelableCallback2.onFinish();
                }
            }
        });
    }

    public void scrollBy(float f, float f2) {
        scrollBy(f, f2, 0L);
    }

    public void scrollBy(float f, float f2, long j) {
        notifyDeveloperAnimationListeners();
        this.nativeMapView.moveBy(f, f2, j);
    }

    public void resetNorth() {
        notifyDeveloperAnimationListeners();
        this.transform.resetNorth();
    }

    public void setFocalBearing(double d, float f, float f2, long j) {
        notifyDeveloperAnimationListeners();
        this.transform.setBearing(d, f, f2, j);
    }

    public float getHeight() {
        return this.projection.getHeight();
    }

    public float getWidth() {
        return this.projection.getWidth();
    }

    public void setOfflineRegionDefinition(OfflineRegionDefinition offlineRegionDefinition) {
        setOfflineRegionDefinition(offlineRegionDefinition, null);
    }

    public void setOfflineRegionDefinition(OfflineRegionDefinition offlineRegionDefinition, Style.OnStyleLoaded onStyleLoaded) {
        double minZoom = offlineRegionDefinition.getMinZoom();
        double maxZoom = offlineRegionDefinition.getMaxZoom();
        moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(offlineRegionDefinition.getBounds().getCenter()).zoom(minZoom).build()));
        setMinZoomPreference(minZoom);
        setMaxZoomPreference(maxZoom);
        setStyle(new Style.Builder());
    }

    public void enableDem() {
        StyleLayerControl styleLayerControl = this.styleLayerControl;
        if (styleLayerControl != null) {
            styleLayerControl.setDemEnabled(true);
        }
    }

    public void disableDem() {
        StyleLayerControl styleLayerControl = this.styleLayerControl;
        if (styleLayerControl != null) {
            styleLayerControl.setDemEnabled(false);
        }
    }

    public void enableMonuments() {
        StyleLayerControl styleLayerControl = this.styleLayerControl;
        if (styleLayerControl != null) {
            styleLayerControl.setMonumentsEnabled(true);
        }
    }

    public void disableMonuments() {
        StyleLayerControl styleLayerControl = this.styleLayerControl;
        if (styleLayerControl != null) {
            styleLayerControl.setMonumentsEnabled(false);
        }
    }

    public boolean isDebugActive() {
        return this.debugActive;
    }

    public void setDebugActive(boolean z) {
        this.debugActive = z;
        this.nativeMapView.setDebug(z);
    }

    @Deprecated
    public void cycleDebugOptions() {
        boolean z = !this.nativeMapView.getDebug();
        this.debugActive = z;
        this.nativeMapView.setDebug(z);
    }

    private void setApiBaseUrl(MapplsMapOptions mapplsMapOptions) {
        String apiBaseUrl = mapplsMapOptions.getApiBaseUrl();
        if (TextUtils.isEmpty(apiBaseUrl)) {
            return;
        }
        this.nativeMapView.setApiBaseUrl(apiBaseUrl);
    }

    public List<MapplsStyle> getMapplsAvailableStyles() {
        return this.nativeMapView.getStyles();
    }

    public void setMapplsStyle(String str, Style.OnStyleLoaded onStyleLoaded) {
        this.onStyleLoadListener = null;
        setStyle(new Style.Builder().fromMapplsStyle(str), onStyleLoaded);
    }

    public void setMapplsStyle(String str, final OnStyleLoadListener onStyleLoadListener) {
        this.onStyleLoadListener = onStyleLoadListener;
        if (Mappls.getStyleHelper().getStyle(str) != null) {
            setStyle(new Style.Builder().fromMapplsStyle(str), new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.MapplsMap.5
                @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                public void onStyleLoaded(Style style) {
                    MapplsMap.this.onStyleLoadListener = null;
                    OnStyleLoadListener onStyleLoadListener2 = onStyleLoadListener;
                    if (onStyleLoadListener2 != null) {
                        onStyleLoadListener2.onStyleLoaded(style);
                    }
                }
            });
            return;
        }
        this.onStyleLoadListener = null;
        if (onStyleLoadListener != null) {
            onStyleLoadListener.onError(str + " style not found");
        }
    }

    public void setStyle(Style.Builder builder) {
        setStyle(builder, null);
    }

    public void setStyle(Style.Builder builder, Style.OnStyleLoaded onStyleLoaded) {
        this.styleLoadedCallback = onStyleLoaded;
        this.locationComponent.onStartLoadingMap();
        Style style = this.style;
        if (style != null) {
            style.clear();
        }
        this.style = builder.build(this.nativeMapView);
        if (!TextUtils.isEmpty(builder.getMapplsStyle())) {
            if (Mappls.getStyleHelper().getStyle(builder.getMapplsStyle()) != null) {
                this.nativeMapView.setMapplsStyle(Mappls.getStyleHelper().getStyle(builder.getMapplsStyle()));
                return;
            } else {
                Timber.e("%s style not found", builder.getMapplsStyle());
                return;
            }
        }
        if (!TextUtils.isEmpty(builder.getJson())) {
            this.nativeMapView.setStyleJson(builder.getJson());
        } else {
            this.nativeMapView.setStyleJson("{\"version\": 8,\"sources\": {},\"layers\": []}");
        }
    }

    void notifyStyleLoaded() {
        if (this.nativeMapView.isDestroyed()) {
            return;
        }
        Style style = this.style;
        if (style != null) {
            style.onDidFinishLoadingStyle();
            this.locationComponent.onFinishLoadingStyle();
            Style.OnStyleLoaded onStyleLoaded = this.styleLoadedCallback;
            if (onStyleLoaded != null) {
                onStyleLoaded.onStyleLoaded(this.style);
            }
            Iterator<Style.OnStyleLoaded> it2 = this.awaitingStyleGetters.iterator();
            while (it2.hasNext()) {
                it2.next().onStyleLoaded(this.style);
            }
        } else {
            MapStrictMode.strictModeViolation("No style to provide.");
        }
        this.styleLoadedCallback = null;
        this.awaitingStyleGetters.clear();
    }

    void injectStyleLayerControl(StyleLayerControl styleLayerControl) {
        this.styleLayerControl = styleLayerControl;
    }

    void injectTrafficPlugin(TrafficPlugin trafficPlugin) {
        this.trafficPlugin = trafficPlugin;
    }

    void injectPlaceIdPlugin(PlaceIdPlugin placeIdPlugin) {
        this.placeIdPlugin = placeIdPlugin;
    }

    @Deprecated
    public Marker addMarker(MarkerOptions markerOptions) {
        return this.annotationManager.addMarker(markerOptions, this, null);
    }

    @Deprecated
    public Marker addMarker(BaseMarkerOptions baseMarkerOptions) {
        return this.annotationManager.addMarker(baseMarkerOptions, this, null);
    }

    @Deprecated
    public Marker addMarker(MarkerOptions markerOptions, OnMarkerAddedListener onMarkerAddedListener) {
        return this.annotationManager.addMarker(markerOptions, this, onMarkerAddedListener);
    }

    public void enableTraffic(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.setEnable(z);
        }
    }

    public boolean isEnableTraffic() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnable();
        }
        return false;
    }

    public void enableTrafficFreeFlow(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableFreeFlow(z);
        }
    }

    public boolean isEnableTrafficFreeFlow() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableFreeFlow();
        }
        return false;
    }

    public void enableTrafficNonFreeFlow(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableNonFreeFlow(z);
        }
    }

    public boolean isEnableTrafficNonFreeFlow() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableNonFreeFlow();
        }
        return false;
    }

    public void enableTrafficClosure(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableClosure(z);
        }
    }

    public boolean isEnableTrafficClosure() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableClosure();
        }
        return false;
    }

    public void enableTrafficStopIcon(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableStopIcon(z);
        }
    }

    public boolean isEnableTrafficStopIcon() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableStopIcon();
        }
        return false;
    }

    public void enableTrafficOther1(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableOth1(z);
        }
    }

    public boolean isEnableTrafficOther1() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableOth1();
        }
        return false;
    }

    public void enableTrafficOther2(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableOth2(z);
        }
    }

    public boolean isEnableTrafficOther2() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableOth2();
        }
        return false;
    }

    public void enableTrafficOther3(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableOth3(z);
        }
    }

    public boolean isEnableTrafficOther3() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableOth3();
        }
        return false;
    }

    public void enableTrafficOther4(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableOth4(z);
        }
    }

    public boolean isEnableTrafficOther4() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableOth4();
        }
        return false;
    }

    public void enableTrafficOther5(boolean z) {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            trafficPlugin.enableOth5(z);
        }
    }

    public boolean isEnableTrafficOther5() {
        TrafficPlugin trafficPlugin = this.trafficPlugin;
        if (trafficPlugin != null) {
            return trafficPlugin.isEnableOth5();
        }
        return false;
    }

    @Deprecated
    public Marker addMarker(BaseMarkerOptions baseMarkerOptions, OnMarkerAddedListener onMarkerAddedListener) {
        return this.annotationManager.addMarker(baseMarkerOptions, this, onMarkerAddedListener);
    }

    @Deprecated
    public List<Marker> addMarkers(List<? extends BaseMarkerOptions> list) {
        return this.annotationManager.addMarkers(list, this, null);
    }

    @Deprecated
    public List<Marker> addMarkers(List<? extends BaseMarkerOptions> list, OnMarkerAddedListener onMarkerAddedListener) {
        return this.annotationManager.addMarkers(list, this, onMarkerAddedListener);
    }

    @Deprecated
    public void updateMarker(Marker marker) {
        this.annotationManager.updateMarker(marker, this, null);
    }

    @Deprecated
    public void updateMarker(Marker marker, OnMarkerAddedListener onMarkerAddedListener) {
        this.annotationManager.updateMarker(marker, this, onMarkerAddedListener);
    }

    @Deprecated
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return this.annotationManager.addPolyline(polylineOptions, this);
    }

    @Deprecated
    public List<Polyline> addPolylines(List<PolylineOptions> list) {
        return this.annotationManager.addPolylines(list, this);
    }

    @Deprecated
    public void updatePolyline(Polyline polyline) {
        this.annotationManager.updatePolyline(polyline);
    }

    @Deprecated
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return this.annotationManager.addPolygon(polygonOptions, this);
    }

    @Deprecated
    public List<Polygon> addPolygons(List<PolygonOptions> list) {
        return this.annotationManager.addPolygons(list, this);
    }

    @Deprecated
    public void updatePolygon(Polygon polygon) {
        this.annotationManager.updatePolygon(polygon);
    }

    @Deprecated
    public void removeMarker(Marker marker) {
        this.annotationManager.removeAnnotation(marker);
    }

    @Deprecated
    public void removePolyline(Polyline polyline) {
        this.annotationManager.removeAnnotation(polyline);
    }

    @Deprecated
    public void removePolygon(Polygon polygon) {
        this.annotationManager.removeAnnotation(polygon);
    }

    @Deprecated
    public void removeAnnotation(Annotation annotation) {
        this.annotationManager.removeAnnotation(annotation);
    }

    @Deprecated
    public void removeAnnotation(long j) {
        this.annotationManager.removeAnnotation(j);
    }

    @Deprecated
    public void removeAnnotations(List<? extends Annotation> list) {
        this.annotationManager.removeAnnotations(list);
    }

    @Deprecated
    public void removeAnnotations() {
        this.annotationManager.removeAnnotations();
    }

    @Deprecated
    public void clear() {
        this.annotationManager.removeAnnotations();
    }

    @Deprecated
    public Annotation getAnnotation(long j) {
        return this.annotationManager.getAnnotation(j);
    }

    @Deprecated
    public List<Annotation> getAnnotations() {
        return this.annotationManager.getAnnotations();
    }

    @Deprecated
    public List<Marker> getMarkers() {
        return this.annotationManager.getMarkers();
    }

    @Deprecated
    public List<Polygon> getPolygons() {
        return this.annotationManager.getPolygons();
    }

    @Deprecated
    public List<Polyline> getPolylines() {
        return this.annotationManager.getPolylines();
    }

    @Deprecated
    public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        this.annotationManager.setOnMarkerClickListener(onMarkerClickListener);
    }

    @Deprecated
    public void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        this.annotationManager.setOnPolygonClickListener(onPolygonClickListener);
    }

    @Deprecated
    public void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        this.annotationManager.setOnPolylineClickListener(onPolylineClickListener);
    }

    @Deprecated
    public void selectMarker(Marker marker) {
        if (marker == null) {
            Logger.w(TAG, "marker was null, so just returning");
        } else {
            this.annotationManager.selectMarker(marker);
        }
    }

    @Deprecated
    public void deselectMarkers() {
        this.annotationManager.deselectMarkers();
    }

    @Deprecated
    public void deselectMarker(Marker marker) {
        this.annotationManager.deselectMarker(marker);
    }

    @Deprecated
    public List<Marker> getSelectedMarkers() {
        return this.annotationManager.getSelectedMarkers();
    }

    @Deprecated
    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.annotationManager.getInfoWindowManager().setInfoWindowAdapter(infoWindowAdapter);
    }

    @Deprecated
    public InfoWindowAdapter getInfoWindowAdapter() {
        return this.annotationManager.getInfoWindowManager().getInfoWindowAdapter();
    }

    @Deprecated
    public void setAllowConcurrentMultipleOpenInfoWindows(boolean z) {
        this.annotationManager.getInfoWindowManager().setAllowConcurrentMultipleOpenInfoWindows(z);
    }

    @Deprecated
    public boolean isAllowConcurrentMultipleOpenInfoWindows() {
        return this.annotationManager.getInfoWindowManager().isAllowConcurrentMultipleOpenInfoWindows();
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.nativeMapView.setLatLngBounds(latLngBounds);
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds) {
        return getCameraForLatLngBounds(latLngBounds, new int[]{0, 0, 0, 0});
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, int[] iArr) {
        return getCameraForLatLngBounds(latLngBounds, iArr, this.transform.getRawBearing(), this.transform.getTilt());
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, double d, double d2) {
        return getCameraForLatLngBounds(latLngBounds, new int[]{0, 0, 0, 0}, d, d2);
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, int[] iArr, double d, double d2) {
        return this.nativeMapView.getCameraForLatLngBounds(latLngBounds, iArr, d, d2);
    }

    public CameraPosition getCameraForGeometry(Geometry geometry) {
        return getCameraForGeometry(geometry, new int[]{0, 0, 0, 0});
    }

    public CameraPosition getCameraForGeometry(Geometry geometry, int[] iArr) {
        return getCameraForGeometry(geometry, iArr, this.transform.getBearing(), this.transform.getTilt());
    }

    public CameraPosition getCameraForGeometry(Geometry geometry, double d, double d2) {
        return getCameraForGeometry(geometry, new int[]{0, 0, 0, 0}, d, d2);
    }

    public CameraPosition getCameraForGeometry(Geometry geometry, int[] iArr, double d, double d2) {
        return this.nativeMapView.getCameraForGeometry(geometry, iArr, d, d2);
    }

    @Deprecated
    public void setPadding(int i, int i2, int i3, int i4) {
        this.projection.setContentPadding(new int[]{i, i2, i3, i4});
        UiSettings uiSettings = this.uiSettings;
        if (uiSettings != null) {
            uiSettings.invalidate();
        }
    }

    @Deprecated
    public int[] getPadding() {
        return this.projection.getContentPadding();
    }

    public void addOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        this.cameraChangeDispatcher.addOnCameraIdleListener(onCameraIdleListener);
    }

    public void setOnPlaceClickListener(OnPlaceClickListener onPlaceClickListener) {
        this.placeIdPlugin.setOnPlaceClickListener(onPlaceClickListener);
    }

    public void removeOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        this.cameraChangeDispatcher.removeOnCameraIdleListener(onCameraIdleListener);
    }

    public void addOnCameraMoveCancelListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.cameraChangeDispatcher.addOnCameraMoveCancelListener(onCameraMoveCanceledListener);
    }

    public void removeOnCameraMoveCancelListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.cameraChangeDispatcher.removeOnCameraMoveCancelListener(onCameraMoveCanceledListener);
    }

    public void addOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.cameraChangeDispatcher.addOnCameraMoveStartedListener(onCameraMoveStartedListener);
    }

    public void removeOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.cameraChangeDispatcher.removeOnCameraMoveStartedListener(onCameraMoveStartedListener);
    }

    public void addOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        this.cameraChangeDispatcher.addOnCameraMoveListener(onCameraMoveListener);
    }

    public void removeOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        this.cameraChangeDispatcher.removeOnCameraMoveListener(onCameraMoveListener);
    }

    public void setOnFpsChangedListener(OnFpsChangedListener onFpsChangedListener) {
        this.onFpsChangedListener = onFpsChangedListener;
        this.nativeMapView.setOnFpsChangedListener(onFpsChangedListener);
    }

    OnFpsChangedListener getOnFpsChangedListener() {
        return this.onFpsChangedListener;
    }

    OnSurfaceBitmapChangeListener getOnSurfaceBitmapChangeListener() {
        return this.onSurfaceBitmapChangeListener;
    }

    public void setOnSurfaceBitmapChangeListener(OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener) {
        this.onSurfaceBitmapChangeListener = onSurfaceBitmapChangeListener;
        this.nativeMapView.setOnSurfaceBitmapChangedListener(onSurfaceBitmapChangeListener);
    }

    public void addOnFlingListener(OnFlingListener onFlingListener) {
        this.onGesturesManagerInteractionListener.onAddFlingListener(onFlingListener);
    }

    public void removeOnFlingListener(OnFlingListener onFlingListener) {
        this.onGesturesManagerInteractionListener.onRemoveFlingListener(onFlingListener);
    }

    public void addOnMoveListener(OnMoveListener onMoveListener) {
        this.onGesturesManagerInteractionListener.onAddMoveListener(onMoveListener);
    }

    public void removeOnMoveListener(OnMoveListener onMoveListener) {
        this.onGesturesManagerInteractionListener.onRemoveMoveListener(onMoveListener);
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.onGesturesManagerInteractionListener.onAddRotateListener(onRotateListener);
    }

    public void removeOnRotateListener(OnRotateListener onRotateListener) {
        this.onGesturesManagerInteractionListener.onRemoveRotateListener(onRotateListener);
    }

    public void addOnScaleListener(OnScaleListener onScaleListener) {
        this.onGesturesManagerInteractionListener.onAddScaleListener(onScaleListener);
    }

    public void removeOnScaleListener(OnScaleListener onScaleListener) {
        this.onGesturesManagerInteractionListener.onRemoveScaleListener(onScaleListener);
    }

    public void addOnShoveListener(OnShoveListener onShoveListener) {
        this.onGesturesManagerInteractionListener.onAddShoveListener(onShoveListener);
    }

    public void removeOnShoveListener(OnShoveListener onShoveListener) {
        this.onGesturesManagerInteractionListener.onRemoveShoveListener(onShoveListener);
    }

    public void setGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z, boolean z2) {
        this.onGesturesManagerInteractionListener.setGesturesManager(androidGesturesManager, z, z2);
    }

    public AndroidGesturesManager getGesturesManager() {
        return this.onGesturesManagerInteractionListener.getGesturesManager();
    }

    public void cancelAllVelocityAnimations() {
        this.onGesturesManagerInteractionListener.cancelAllVelocityAnimations();
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.onGesturesManagerInteractionListener.onAddMapClickListener(onMapClickListener);
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.onGesturesManagerInteractionListener.onRemoveMapClickListener(onMapClickListener);
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.onGesturesManagerInteractionListener.onAddMapLongClickListener(onMapLongClickListener);
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.onGesturesManagerInteractionListener.onRemoveMapLongClickListener(onMapLongClickListener);
    }

    public void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.annotationManager.getInfoWindowManager().setOnInfoWindowClickListener(onInfoWindowClickListener);
    }

    public OnInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.annotationManager.getInfoWindowManager().getOnInfoWindowClickListener();
    }

    public void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.annotationManager.getInfoWindowManager().setOnInfoWindowLongClickListener(onInfoWindowLongClickListener);
    }

    public OnInfoWindowLongClickListener getOnInfoWindowLongClickListener() {
        return this.annotationManager.getInfoWindowManager().getOnInfoWindowLongClickListener();
    }

    public void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.annotationManager.getInfoWindowManager().setOnInfoWindowCloseListener(onInfoWindowCloseListener);
    }

    public OnInfoWindowCloseListener getOnInfoWindowCloseListener() {
        return this.annotationManager.getInfoWindowManager().getOnInfoWindowCloseListener();
    }

    public void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        if (this.started) {
            this.nativeMapView.addSnapshotCallback(snapshotReadyCallback);
        }
    }

    public List<Feature> queryRenderedFeatures(PointF pointF, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(pointF, strArr, (Expression) null);
    }

    public List<Feature> queryRenderedFeatures(PointF pointF, Expression expression, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(pointF, strArr, expression);
    }

    public List<Feature> queryRenderedFeatures(RectF rectF, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(rectF, strArr, (Expression) null);
    }

    public List<Feature> queryRenderedFeatures(RectF rectF, Expression expression, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(rectF, strArr, expression);
    }

    void injectLocationComponent(LocationComponent locationComponent) {
        this.locationComponent = locationComponent;
    }

    void injectAnnotationManager(AnnotationManager annotationManager) {
        this.annotationManager = annotationManager.bind(this);
    }

    public LocationComponent getLocationComponent() {
        return this.locationComponent;
    }

    Transform getTransform() {
        return this.transform;
    }

    private void notifyDeveloperAnimationListeners() {
        Iterator<OnDeveloperAnimationListener> it2 = this.developerAnimationStartedListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onDeveloperAnimationStarted();
        }
    }
}
