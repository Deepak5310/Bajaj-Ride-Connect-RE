package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.model.AdvancedMarker;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.FeatureLayer;
import com.google.android.gms.maps.model.FeatureLayerOptions;
import com.google.android.gms.maps.model.FeatureType;
import com.google.android.gms.maps.model.FollowMyLocationOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapCapabilities;
import com.google.android.gms.maps.model.MapColorScheme;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.libraries.navigation.internal.afl.fd;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleMap {
    public static final String DEMO_MAP_ID = "demo_map_id";
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;

    @Deprecated
    public static final int MAP_TYPE_TERRAIN = 3;
    private static final fd[] a = {fd.CAMERA_3D, fd.CAMERA_2D_NORTH_UP, fd.CAMERA_2D_HEADING_UP};
    private final com.google.android.libraries.navigation.internal.ly.k b;
    private MapCapabilities c;
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private UiSettings f;

    /* JADX INFO: compiled from: PG */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CameraPerspective {
        public static final int TILTED = 0;
        public static final int TOP_DOWN_HEADING_UP = 2;
        public static final int TOP_DOWN_NORTH_UP = 1;
    }

    /* JADX INFO: compiled from: PG */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* JADX INFO: compiled from: PG */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    /* JADX INFO: compiled from: PG */
    @Deprecated
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnCameraFollowLocationCallback {
        void onCameraStartedFollowingLocation();

        void onCameraStoppedFollowingLocation();
    }

    /* JADX INFO: compiled from: PG */
    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    /* JADX INFO: compiled from: PG */
    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    /* JADX INFO: compiled from: PG */
    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    /* JADX INFO: compiled from: PG */
    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMapCapabilitiesChangedListener {
        void onMapCapabilitiesChanged(MapCapabilities mapCapabilities);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    /* JADX INFO: compiled from: PG */
    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnMyLocationClickListener {
        void onMyLocationClick(Location location);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnPoiClickListener {
        void onPoiClick(PointOfInterest pointOfInterest);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    /* JADX INFO: compiled from: PG */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public GoogleMap(com.google.android.libraries.navigation.internal.ly.k kVar) {
        com.google.android.libraries.navigation.internal.lh.be.j(kVar);
        this.b = kVar;
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.b.i(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return new GroundOverlay(this.b.k(groundOverlayOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        if (markerOptions instanceof AdvancedMarkerOptions) {
            markerOptions.c = 1;
        }
        try {
            com.google.android.libraries.navigation.internal.lz.p pVarN = this.b.n(markerOptions);
            return markerOptions.c == 1 ? new AdvancedMarker(pVarN) : new Marker(pVarN);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.b.o(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.b.p(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return new TileOverlay(this.b.q(tileOverlayOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void followMyLocation(@CameraPerspective int i) {
        if (i >= 0) {
            fd[] fdVarArr = a;
            int length = fdVarArr.length;
            if (i < 3) {
                try {
                    this.b.w(fdVarArr[i], null);
                    return;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }
        throw new IllegalArgumentException("Invalid perspective");
    }

    public final CameraPosition getCameraPosition() {
        try {
            CameraPosition cameraPositionH = this.b.h();
            return new CameraPosition(cameraPositionH.target, cameraPositionH.zoom, cameraPositionH.tilt, cameraPositionH.bearing);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public FeatureLayer getFeatureLayer(FeatureLayerOptions featureLayerOptions) {
        String featureType = featureLayerOptions.getFeatureType();
        String datasetId = featureLayerOptions.getDatasetId();
        boolean zEquals = featureType.equals(FeatureType.DATASET);
        FeatureLayer featureLayer = zEquals ? (FeatureLayer) this.e.get(datasetId) : (FeatureLayer) this.e.get(featureType);
        if (featureLayer == null) {
            try {
                featureLayer = new FeatureLayer(this.b.j(featureLayerOptions));
                if (zEquals) {
                    this.e.put(datasetId, featureLayer);
                } else {
                    this.e.put(featureType, featureLayer);
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return featureLayer;
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            com.google.android.libraries.navigation.internal.lz.j jVarL = this.b.l();
            if (jVarL != null) {
                return new IndoorBuilding(jVarL);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public MapCapabilities getMapCapabilities() {
        if (this.c == null) {
            try {
                this.c = new MapCapabilities(this.b.m());
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return this.c;
    }

    @MapColorScheme
    public int getMapColorScheme() {
        try {
            return this.b.c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.b.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.b.a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.b.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return new Location(this.b.e());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.b.f());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        if (this.f == null) {
            try {
                this.f = new UiSettings(this.b.g());
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return this.f;
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.b.al();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isCameraFollowingMyLocation() {
        try {
            return this.b.am();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.b.an();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.b.ao();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.b.ap();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void removeOnMapCapabilitiesChangedListener(OnMapCapabilitiesChangedListener onMapCapabilitiesChangedListener) {
        try {
            if (this.d.containsKey(onMapCapabilitiesChangedListener)) {
                this.b.z((com.google.android.libraries.navigation.internal.ly.at) this.d.get(onMapCapabilitiesChangedListener));
                this.d.remove(onMapCapabilitiesChangedListener);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.b.aq(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.b.D(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.D(new e(infoWindowAdapter));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
    }

    public boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        try {
            return this.b.ar(mapStyleOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.b.K(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.K(new s(onCameraChangeListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        if (onCameraIdleListener == null) {
            try {
                this.b.L(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.L(new w(onCameraIdleListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnCameraMoveCanceledListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (onCameraMoveCanceledListener == null) {
            try {
                this.b.M(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.M(new v(onCameraMoveCanceledListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        try {
            if (onCameraMoveListener == null) {
                this.b.N(null);
            } else {
                this.b.N(new u(onCameraMoveListener));
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        try {
            if (onCameraMoveStartedListener == null) {
                this.b.O(null);
            } else {
                this.b.O(new t(onCameraMoveStartedListener));
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener == null) {
            try {
                this.b.P(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.P(new l(onCircleClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnFollowMyLocationCallback(OnCameraFollowLocationCallback onCameraFollowLocationCallback) {
        if (onCameraFollowLocationCallback == null) {
            try {
                this.b.Q(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.Q(new q(onCameraFollowLocationCallback));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener == null) {
            try {
                this.b.R(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.R(new j(onGroundOverlayClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.b.S(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.S(new k(onIndoorStateChangeListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.b.T(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.T(new b(onInfoWindowClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        if (onInfoWindowCloseListener == null) {
            try {
                this.b.U(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.U(new d(onInfoWindowCloseListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        if (onInfoWindowLongClickListener == null) {
            try {
                this.b.V(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.V(new c(onInfoWindowLongClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.b.W(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.W(new x(onMapClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.b.X(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.X(new i(onMapLoadedCallback));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.b.Y(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.Y(new y(onMapLongClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.b.Z(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.Z(new z(onMarkerClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.b.aa(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.aa(new a(onMarkerDragListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.b.ab(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.ab(new g(onMyLocationButtonClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.b.ac(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.ac(new f(onMyLocationChangeListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        if (onMyLocationClickListener == null) {
            try {
                this.b.ad(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.ad(new h(onMyLocationClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnPoiClickListener(OnPoiClickListener onPoiClickListener) {
        if (onPoiClickListener == null) {
            try {
                this.b.ae(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.ae(new p(onPoiClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener == null) {
            try {
                this.b.af(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.af(new m(onPolygonClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener == null) {
            try {
                this.b.ag(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.b.ag(new n(onPolylineClickListener));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.b.s(cameraUpdate.a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.b.v();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.b.y(cameraUpdate.a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void resetMinMaxZoomPreference() {
        try {
            this.b.A();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.b.B(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.b.C(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.b.E(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMapColorScheme(@MapColorScheme int i) {
        try {
            this.b.F(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            this.b.G(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMaxZoomPreference(float f) {
        try {
            this.b.H(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMinZoomPreference(float f) {
        try {
            this.b.I(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.b.J(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.b.ah(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.b.ai(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.b.aj(new o(snapshotReadyCallback), bitmap != null ? new com.google.android.libraries.navigation.internal.lo.n(bitmap) : null);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.b.ak();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void addOnMapCapabilitiesChangedListener(OnMapCapabilitiesChangedListener onMapCapabilitiesChangedListener) {
        try {
            r rVar = new r();
            this.d.put(onMapCapabilitiesChangedListener, rVar);
            this.b.r(rVar);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.b.u(cameraUpdate.a, i, cancelableCallback == null ? null : new aa(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void followMyLocation(@CameraPerspective int i, FollowMyLocationOptions followMyLocationOptions) {
        if (i >= 0) {
            fd[] fdVarArr = a;
            int length = fdVarArr.length;
            if (i < 3) {
                try {
                    this.b.w(fdVarArr[i], followMyLocationOptions);
                    return;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }
        throw new IllegalArgumentException("Invalid perspective");
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.b.t(cameraUpdate.a, cancelableCallback == null ? null : new aa(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
