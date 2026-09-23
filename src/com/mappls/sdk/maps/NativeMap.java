package com.mappls.sdk.maps;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.annotations.Polygon;
import com.mappls.sdk.maps.annotations.Polyline;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.geometry.ProjectedMeters;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.TransitionOptions;
import com.mappls.sdk.maps.style.light.Light;
import com.mappls.sdk.maps.style.model.MapplsStyle;
import com.mappls.sdk.maps.style.sources.Source;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface NativeMap {
    void addAnnotationIcon(String str, int i, int i2, float f, byte[] bArr);

    void addImages(Image[] imageArr);

    void addLayer(Layer layer);

    void addLayerAbove(Layer layer, String str);

    void addLayerAt(Layer layer, int i);

    void addLayerBelow(Layer layer, String str);

    long addMarker(Marker marker);

    long[] addMarkers(List<Marker> list);

    long addPolygon(Polygon polygon);

    long[] addPolygons(List<Polygon> list);

    long addPolyline(Polyline polyline);

    long[] addPolylines(List<Polyline> list);

    void addSnapshotCallback(MapplsMap.SnapshotReadyCallback snapshotReadyCallback);

    void addSource(Source source);

    void cancelTransitions();

    void destroy();

    void easeTo(LatLng latLng, double d, double d2, double d3, double[] dArr, long j, boolean z);

    void flyTo(LatLng latLng, double d, double d2, double d3, double[] dArr, long j);

    double getBearing();

    CameraPosition getCameraForGeometry(Geometry geometry, int[] iArr, double d, double d2);

    CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, int[] iArr, double d, double d2);

    CameraPosition getCameraPosition();

    double[] getContentPadding();

    boolean getDebug();

    RectF getDensityDependantRectangle(RectF rectF);

    Bitmap getImage(String str);

    LatLng getLatLng();

    Layer getLayer(String str);

    List<Layer> getLayers();

    Light getLight();

    String getMapplsStyle();

    double getMaxPitch();

    double getMaxZoom();

    double getMetersPerPixelAtLatitude(double d);

    double getMinPitch();

    double getMinZoom();

    long getNativePtr();

    double getPitch();

    float getPixelRatio();

    boolean getPrefetchTiles();

    int getPrefetchZoomDelta();

    Source getSource(String str);

    List<Source> getSources();

    String getStyleJson();

    String getStyleUri();

    List<MapplsStyle> getStyles();

    double getTopOffsetPixelsForAnnotationSymbol(String str);

    TransitionOptions getTransitionOptions();

    void getVisibleCoordinateBounds(double[] dArr);

    double getZoom();

    boolean isDestroyed();

    boolean isFullyLoaded();

    void jumpTo(LatLng latLng, double d, double d2, double d3, double[] dArr);

    LatLng latLngForPixel(PointF pointF);

    LatLng latLngForProjectedMeters(ProjectedMeters projectedMeters);

    void latLngsForPixels(double[] dArr, double[] dArr2);

    void moveBy(double d, double d2, long j);

    void onLowMemory();

    PointF pixelForLatLng(LatLng latLng);

    void pixelsForLatLngs(double[] dArr, double[] dArr2);

    ProjectedMeters projectedMetersForLatLng(LatLng latLng);

    long[] queryPointAnnotations(RectF rectF);

    List<Feature> queryRenderedFeatures(PointF pointF, String[] strArr, Expression expression);

    List<Feature> queryRenderedFeatures(RectF rectF, String[] strArr, Expression expression);

    long[] queryShapeAnnotations(RectF rectF);

    void removeAnnotation(long j);

    void removeAnnotationIcon(String str);

    void removeAnnotations(long[] jArr);

    void removeImage(String str);

    boolean removeLayer(Layer layer);

    boolean removeLayer(String str);

    boolean removeLayerAt(int i);

    boolean removeSource(Source source);

    boolean removeSource(String str);

    void resetNorth();

    void resetPosition();

    void resetZoom();

    void resizeView(int i, int i2);

    void rotateBy(double d, double d2, double d3, double d4, long j);

    void setApiBaseUrl(String str);

    void setBearing(double d, double d2, double d3, long j);

    void setBearing(double d, long j);

    void setContentPadding(double[] dArr);

    void setDebug(boolean z);

    void setGestureInProgress(boolean z);

    void setLatLng(LatLng latLng, long j);

    void setLatLngBounds(LatLngBounds latLngBounds);

    void setMapplsStyle(MapplsStyle mapplsStyle);

    void setMaxPitch(double d);

    void setMaxZoom(double d);

    void setMinPitch(double d);

    void setMinZoom(double d);

    void setOnFpsChangedListener(MapplsMap.OnFpsChangedListener onFpsChangedListener);

    void setOnSurfaceBitmapChangedListener(MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener);

    void setPitch(double d, long j);

    void setPrefetchTiles(boolean z);

    void setPrefetchZoomDelta(int i);

    void setReachability(boolean z);

    void setStyleJson(String str);

    void setTransitionOptions(TransitionOptions transitionOptions);

    void setVisibleCoordinateBounds(LatLng[] latLngArr, RectF rectF, double d, long j);

    void setZoom(double d, PointF pointF, long j);

    void triggerRepaint();

    void updateMarker(Marker marker);

    void updatePolygon(Polygon polygon);

    void updatePolyline(Polyline polyline);
}
