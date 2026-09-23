package com.mappls.sdk.maps;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.collection.LongSparseArray;
import com.mappls.sdk.maps.annotations.Annotation;
import com.mappls.sdk.maps.annotations.BaseMarkerOptions;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.annotations.Polygon;
import com.mappls.sdk.maps.annotations.PolygonOptions;
import com.mappls.sdk.maps.annotations.Polyline;
import com.mappls.sdk.maps.annotations.PolylineOptions;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class AnnotationManager {
    private static final long NO_ANNOTATION_ID = -1;
    private static final String TAG = "Mbgl-AnnotationManager";
    private Annotations annotations;
    private final LongSparseArray<Annotation> annotationsArray;
    private final IconManager iconManager;
    private final InfoWindowManager infoWindowManager;
    private final MapView mapView;
    private MapplsMap mapplsMap;
    private Markers markers;
    private MapplsMap.OnMarkerClickListener onMarkerClickListener;
    private MapplsMap.OnPolygonClickListener onPolygonClickListener;
    private MapplsMap.OnPolylineClickListener onPolylineClickListener;
    private Polygons polygons;
    private Polylines polylines;
    private final LongSparseArray<LatLng> positions;
    private final List<Marker> selectedMarkers;
    private ShapeAnnotations shapeAnnotations;

    AnnotationManager(LongSparseArray<Annotation> longSparseArray, IconManager iconManager, Annotations annotations, Markers markers, Polygons polygons, Polylines polylines, ShapeAnnotations shapeAnnotations, LongSparseArray<LatLng> longSparseArray2) {
        this.infoWindowManager = new InfoWindowManager();
        this.selectedMarkers = new ArrayList();
        this.mapView = null;
        this.annotationsArray = longSparseArray;
        this.iconManager = iconManager;
        this.annotations = annotations;
        this.markers = markers;
        this.polygons = polygons;
        this.polylines = polylines;
        this.shapeAnnotations = shapeAnnotations;
        this.positions = longSparseArray2;
    }

    AnnotationManager(MapView mapView, LongSparseArray<Annotation> longSparseArray, IconManager iconManager, Annotations annotations, Markers markers, Polygons polygons, Polylines polylines, ShapeAnnotations shapeAnnotations, LongSparseArray<LatLng> longSparseArray2) {
        this.infoWindowManager = new InfoWindowManager();
        this.selectedMarkers = new ArrayList();
        this.mapView = mapView;
        this.annotationsArray = longSparseArray;
        this.iconManager = iconManager;
        this.annotations = annotations;
        this.markers = markers;
        this.polygons = polygons;
        this.polylines = polylines;
        this.positions = longSparseArray2;
        this.shapeAnnotations = shapeAnnotations;
    }

    AnnotationManager bind(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        return this;
    }

    void update() {
        this.infoWindowManager.update();
    }

    Annotation getAnnotation(long j) {
        return this.annotations.obtainBy(j);
    }

    List<Annotation> getAnnotations() {
        return this.annotations.obtainAll();
    }

    void removeAnnotation(long j) {
        this.annotations.removeBy(j);
    }

    void removeAnnotation(Annotation annotation) {
        if (annotation instanceof Marker) {
            Marker marker = (Marker) annotation;
            marker.hideInfoWindow();
            if (this.selectedMarkers.contains(marker)) {
                this.selectedMarkers.remove(marker);
            }
            this.iconManager.iconCleanup(marker.getIcon());
        }
        this.annotations.removeBy(annotation);
    }

    void removeAnnotations(List<? extends Annotation> list) {
        for (Annotation annotation : list) {
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                marker.hideInfoWindow();
                if (this.selectedMarkers.contains(marker)) {
                    this.selectedMarkers.remove(marker);
                }
                this.iconManager.iconCleanup(marker.getIcon());
            }
        }
        this.annotations.removeBy(list);
    }

    void removeAnnotations() {
        int size = this.annotationsArray.size();
        long[] jArr = new long[size];
        this.selectedMarkers.clear();
        for (int i = 0; i < size; i++) {
            long jKeyAt = this.annotationsArray.keyAt(i);
            jArr[i] = jKeyAt;
            Annotation annotation = this.annotationsArray.get(jKeyAt);
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                marker.hideInfoWindow();
                this.iconManager.iconCleanup(marker.getIcon());
            }
        }
        this.annotations.removeAll();
    }

    Marker addMarker(BaseMarkerOptions baseMarkerOptions, MapplsMap mapplsMap, MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        return this.markers.addBy(baseMarkerOptions, mapplsMap, onMarkerAddedListener);
    }

    List<Marker> addMarkers(List<? extends BaseMarkerOptions> list, MapplsMap mapplsMap, MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        return this.markers.addBy(list, mapplsMap, onMarkerAddedListener);
    }

    void updateMarker(Marker marker, MapplsMap mapplsMap, MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        if (!isAddedToMap(marker)) {
            logNonAdded(marker);
        } else {
            this.markers.update(marker, mapplsMap, onMarkerAddedListener);
        }
    }

    List<Marker> getMarkers() {
        return this.markers.obtainAll();
    }

    List<Marker> getMarkersInRect(RectF rectF) {
        return this.markers.obtainAllIn(rectF);
    }

    void reloadMarkers() {
        this.markers.reload();
    }

    Polygon addPolygon(PolygonOptions polygonOptions, MapplsMap mapplsMap) {
        return this.polygons.addBy(polygonOptions, mapplsMap);
    }

    List<Polygon> addPolygons(List<PolygonOptions> list, MapplsMap mapplsMap) {
        return this.polygons.addBy(list, mapplsMap);
    }

    void updatePolygon(Polygon polygon) {
        if (!isAddedToMap(polygon)) {
            logNonAdded(polygon);
        } else {
            this.polygons.update(polygon);
        }
    }

    List<Polygon> getPolygons() {
        return this.polygons.obtainAll();
    }

    Polyline addPolyline(PolylineOptions polylineOptions, MapplsMap mapplsMap) {
        return this.polylines.addBy(polylineOptions, mapplsMap);
    }

    List<Polyline> addPolylines(List<PolylineOptions> list, MapplsMap mapplsMap) {
        return this.polylines.addBy(list, mapplsMap);
    }

    void updatePolyline(Polyline polyline) {
        if (!isAddedToMap(polyline)) {
            logNonAdded(polyline);
        } else {
            this.polylines.update(polyline);
        }
    }

    List<Polyline> getPolylines() {
        return this.polylines.obtainAll();
    }

    void showMarkers(List<Marker> list, final MapplsMap mapplsMap, final int[] iArr, final MapplsMap.CancelableCallback cancelableCallback) {
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Marker marker : list) {
            if (marker.getPosition() == null) {
                arrayList2.add(marker.getMapplsPin());
            } else {
                arrayList.add(marker.getPosition());
            }
        }
        if (arrayList2.size() > 0) {
            MapplsPinHelper.getInstance().getAnnotation(arrayList2, new CoordinateCallback() { // from class: com.mappls.sdk.maps.AnnotationManager.1
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list2) {
                    if (list2.size() > 0) {
                        for (CoordinateResult coordinateResult : list2) {
                            arrayList.add(new LatLng(coordinateResult.getLatitude().doubleValue(), coordinateResult.getLongitude().doubleValue()));
                        }
                    }
                    if (arrayList.size() > 0) {
                        if (arrayList.size() == 1) {
                            mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom((LatLng) arrayList.get(0), mapplsMap.getMaxZoomLevel()));
                            return;
                        }
                        LatLngBounds latLngBoundsBuild = new LatLngBounds.Builder().includes(arrayList).build();
                        MapplsMap mapplsMap2 = mapplsMap;
                        int[] iArr2 = iArr;
                        mapplsMap2.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, iArr2[0], iArr2[1], iArr2[2], iArr2[3]));
                        return;
                    }
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onCancel();
                    }
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                    if (arrayList.size() > 0) {
                        if (arrayList.size() == 1) {
                            mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom((LatLng) arrayList.get(0), mapplsMap.getMaxZoomLevel()));
                            return;
                        }
                        LatLngBounds latLngBoundsBuild = new LatLngBounds.Builder().includes(arrayList).build();
                        MapplsMap mapplsMap2 = mapplsMap;
                        int[] iArr2 = iArr;
                        mapplsMap2.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, iArr2[0], iArr2[1], iArr2[2], iArr2[3]));
                        return;
                    }
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onCancel();
                    }
                }
            });
            return;
        }
        if (arrayList.size() <= 0) {
            if (cancelableCallback != null) {
                cancelableCallback.onCancel();
            }
        } else if (arrayList.size() == 1) {
            mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom((LatLng) arrayList.get(0), mapplsMap.getMaxZoomLevel()));
        } else {
            mapplsMap.animateCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds.Builder().includes(arrayList).build(), iArr[0], iArr[1], iArr[2], iArr[3]));
        }
    }

    void showMarker(Marker marker, final double d) {
        if (marker.getPosition() == null) {
            MapplsPinHelper.getInstance().getAnnotation(marker.getMapplsPin(), new CoordinateCallback() { // from class: com.mappls.sdk.maps.AnnotationManager.2
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list) {
                    if (list.size() > 0) {
                        AnnotationManager.this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue()), d));
                    }
                }
            });
        } else {
            this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), d));
        }
    }

    void setOnMarkerClickListener(MapplsMap.OnMarkerClickListener onMarkerClickListener) {
        this.onMarkerClickListener = onMarkerClickListener;
    }

    void setOnPolygonClickListener(MapplsMap.OnPolygonClickListener onPolygonClickListener) {
        this.onPolygonClickListener = onPolygonClickListener;
    }

    void setOnPolylineClickListener(MapplsMap.OnPolylineClickListener onPolylineClickListener) {
        this.onPolylineClickListener = onPolylineClickListener;
    }

    void selectMarker(Marker marker) {
        MapView mapView;
        if (this.selectedMarkers.contains(marker)) {
            return;
        }
        if (!this.infoWindowManager.isAllowConcurrentMultipleOpenInfoWindows()) {
            deselectMarkers();
        }
        if ((this.infoWindowManager.isInfoWindowValidForMarker(marker) || this.infoWindowManager.getInfoWindowAdapter() != null) && (mapView = this.mapView) != null) {
            this.infoWindowManager.add(marker.showInfoWindow(this.mapplsMap, mapView));
        }
        this.selectedMarkers.add(marker);
    }

    void deselectMarkers() {
        if (this.selectedMarkers.isEmpty()) {
            return;
        }
        for (Marker marker : this.selectedMarkers) {
            if (marker != null && marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
            }
        }
        this.selectedMarkers.clear();
    }

    void deselectMarker(Marker marker) {
        if (this.selectedMarkers.contains(marker)) {
            if (marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
            }
            this.selectedMarkers.remove(marker);
        }
    }

    List<Marker> getSelectedMarkers() {
        return this.selectedMarkers;
    }

    InfoWindowManager getInfoWindowManager() {
        return this.infoWindowManager;
    }

    void adjustTopOffsetPixels(MapplsMap mapplsMap) {
        int size = this.annotationsArray.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = this.annotationsArray.get(i);
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                marker.setTopOffsetPixels(this.iconManager.getTopOffsetPixelsForIcon(marker.getIcon()));
            }
        }
        if (this.mapView != null) {
            for (Marker marker2 : this.selectedMarkers) {
                if (marker2.isInfoWindowShown()) {
                    marker2.hideInfoWindow();
                    marker2.showInfoWindow(mapplsMap, this.mapView);
                }
            }
        }
    }

    private boolean isAddedToMap(Annotation annotation) {
        return (annotation == null || annotation.getId() == -1 || this.annotationsArray.indexOfKey(annotation.getId()) <= -1) ? false : true;
    }

    private void logNonAdded(Annotation annotation) {
        Logger.w(TAG, String.format("Attempting to update non-added %s with value %s", annotation.getClass().getCanonicalName(), annotation));
    }

    boolean onTap(PointF pointF) {
        long jExecute = new MarkerHitResolver(this.mapplsMap, this.positions).execute(getMarkerHitFromTouchArea(pointF));
        if (jExecute != -1 && isClickHandledForMarker(jExecute)) {
            return true;
        }
        Annotation annotationExecute = new ShapeAnnotationHitResolver(this.shapeAnnotations).execute(getShapeAnnotationHitFromTap(pointF));
        return annotationExecute != null && handleClickForShapeAnnotation(annotationExecute);
    }

    private ShapeAnnotationHit getShapeAnnotationHitFromTap(PointF pointF) {
        float dimension = Mappls.getApplicationContext().getResources().getDimension(R.dimen.mappls_maps_eight_dp);
        return new ShapeAnnotationHit(new RectF(pointF.x - dimension, pointF.y - dimension, pointF.x + dimension, pointF.y + dimension));
    }

    private boolean handleClickForShapeAnnotation(Annotation annotation) {
        MapplsMap.OnPolylineClickListener onPolylineClickListener;
        MapplsMap.OnPolygonClickListener onPolygonClickListener;
        if ((annotation instanceof Polygon) && (onPolygonClickListener = this.onPolygonClickListener) != null) {
            onPolygonClickListener.onPolygonClick((Polygon) annotation);
            return true;
        }
        if (!(annotation instanceof Polyline) || (onPolylineClickListener = this.onPolylineClickListener) == null) {
            return false;
        }
        onPolylineClickListener.onPolylineClick((Polyline) annotation);
        return true;
    }

    private MarkerHit getMarkerHitFromTouchArea(PointF pointF) {
        float highestIconHeight = (int) (((double) this.iconManager.getHighestIconHeight()) * 1.5d);
        float highestIconWidth = (int) (((double) this.iconManager.getHighestIconWidth()) * 1.5d);
        RectF rectF = new RectF(pointF.x - highestIconHeight, pointF.y - highestIconWidth, pointF.x + highestIconHeight, pointF.y + highestIconWidth);
        return new MarkerHit(rectF, getMarkersInRect(rectF));
    }

    private boolean isClickHandledForMarker(long j) {
        Marker marker = (Marker) getAnnotation(j);
        if (onClickMarker(marker)) {
            return true;
        }
        toggleMarkerSelectionState(marker);
        return true;
    }

    private boolean onClickMarker(Marker marker) {
        MapplsMap.OnMarkerClickListener onMarkerClickListener = this.onMarkerClickListener;
        return onMarkerClickListener != null && onMarkerClickListener.onMarkerClick(marker);
    }

    private void toggleMarkerSelectionState(Marker marker) {
        if (!this.selectedMarkers.contains(marker)) {
            selectMarker(marker);
        } else {
            deselectMarker(marker);
        }
    }

    private static class ShapeAnnotationHitResolver {
        private ShapeAnnotations shapeAnnotations;

        ShapeAnnotationHitResolver(ShapeAnnotations shapeAnnotations) {
            this.shapeAnnotations = shapeAnnotations;
        }

        public Annotation execute(ShapeAnnotationHit shapeAnnotationHit) {
            List<Annotation> listObtainAllIn = this.shapeAnnotations.obtainAllIn(shapeAnnotationHit.tapPoint);
            if (listObtainAllIn.size() > 0) {
                return listObtainAllIn.get(0);
            }
            return null;
        }
    }

    private static class MarkerHitResolver {
        private Bitmap bitmap;
        private int bitmapHeight;
        private int bitmapWidth;
        private PointF markerLocation;
        private final LongSparseArray<LatLng> positionsArray;
        private final Projection projection;
        private View view;
        private Rect hitRectView = new Rect();
        private RectF hitRectMarker = new RectF();
        private RectF highestSurfaceIntersection = new RectF();
        private long closestMarkerId = -1;
        private final int minimalTouchSize = (int) (Mappls.getApplicationContext().getResources().getDisplayMetrics().density * 32.0f);

        MarkerHitResolver(MapplsMap mapplsMap, LongSparseArray<LatLng> longSparseArray) {
            this.projection = mapplsMap.getProjection();
            this.positionsArray = longSparseArray;
        }

        public long execute(MarkerHit markerHit) {
            resolveForMarkers(markerHit);
            return this.closestMarkerId;
        }

        private void resolveForMarkers(MarkerHit markerHit) {
            Iterator it2 = markerHit.markers.iterator();
            while (it2.hasNext()) {
                resolveForMarker(markerHit, (Marker) it2.next());
            }
        }

        private void resolveForMarker(MarkerHit markerHit, Marker marker) {
            if (marker.getMapplsPin() != null && marker.getPosition() == null) {
                this.markerLocation = this.projection.toScreenLocation(this.positionsArray.get(marker.getId(), null));
            } else {
                this.markerLocation = this.projection.toScreenLocation(marker.getPosition());
            }
            Bitmap bitmap = marker.getIcon().getBitmap();
            this.bitmap = bitmap;
            int height = bitmap.getHeight();
            this.bitmapHeight = height;
            int i = this.minimalTouchSize;
            if (height < i) {
                this.bitmapHeight = i;
            }
            int width = this.bitmap.getWidth();
            this.bitmapWidth = width;
            int i2 = this.minimalTouchSize;
            if (width < i2) {
                this.bitmapWidth = i2;
            }
            this.hitRectMarker.set(0.0f, 0.0f, this.bitmapWidth, this.bitmapHeight);
            this.hitRectMarker.offsetTo(this.markerLocation.x - (this.bitmapWidth / 2), this.markerLocation.y - (this.bitmapHeight / 2));
            hitTestMarker(markerHit, marker, this.hitRectMarker);
        }

        private void hitTestMarker(MarkerHit markerHit, Marker marker, RectF rectF) {
            if (rectF.contains(markerHit.getTapPointX(), markerHit.getTapPointY())) {
                rectF.intersect(markerHit.tapRect);
                if (isRectangleHighestSurfaceIntersection(rectF)) {
                    this.highestSurfaceIntersection = new RectF(rectF);
                    this.closestMarkerId = marker.getId();
                }
            }
        }

        private boolean isRectangleHighestSurfaceIntersection(RectF rectF) {
            return rectF.width() * rectF.height() > this.highestSurfaceIntersection.width() * this.highestSurfaceIntersection.height();
        }
    }

    private static class ShapeAnnotationHit {
        private final RectF tapPoint;

        ShapeAnnotationHit(RectF rectF) {
            this.tapPoint = rectF;
        }
    }

    private static class MarkerHit {
        private final List<Marker> markers;
        private final RectF tapRect;

        MarkerHit(RectF rectF, List<Marker> list) {
            this.tapRect = rectF;
            this.markers = list;
        }

        float getTapPointX() {
            return this.tapRect.centerX();
        }

        float getTapPointY() {
            return this.tapRect.centerY();
        }
    }
}
