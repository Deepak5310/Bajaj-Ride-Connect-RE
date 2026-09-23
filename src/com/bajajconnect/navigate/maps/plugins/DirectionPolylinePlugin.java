package com.bajajconnect.navigate.maps.plugins;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.bajajconnect.R;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.utils.ColorUtils;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public final class DirectionPolylinePlugin implements MapView.OnDidFinishLoadingStyleListener, MapplsMap.OnMapClickListener {
    private static final String CONGESTION_LAYER = "congestion_layer";
    private static final String CONSTANT_END = "end_marker";
    private static final String CONSTANT_START = "start_marker";
    private static final String CONSTANT_TRACK_POINTS = "track_points";
    private static final String CONSTANT_WAYPOINTS = "via_points";
    private static final String FILTER_TEXT = "direction_type";
    private static final String POSITION_TEXT = "position_text";
    private List<String> layerIds;
    private MapView mMapView;
    private MapplsMap mapplsMap;
    private OnNewRouteSelectedListener onNewRouteSelectedListener;
    LatLng position;
    private LineString traversed;
    private List<LineString> trips;
    private List<LatLng> wayPoints;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Handler traversedHandler = new Handler(Looper.getMainLooper());
    boolean bearingVisibility = false;
    float bearing = 0.0f;
    private boolean enabled = false;
    private LatLng startLatLng = null;
    private LatLng endLatLng = null;
    private List<DirectionsRoute> directionsRouteList = null;
    private int selected = 0;
    private boolean enableCongestion = false;
    Runnable updatePolylineStateRunnable = new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.1
        @Override // java.lang.Runnable
        public void run() {
            DirectionPolylinePlugin.this.updateSelectedPolylineStates();
        }
    };
    Runnable updateTraversedPolylineStateRunnable = new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.2
        @Override // java.lang.Runnable
        public void run() {
            DirectionPolylinePlugin.this.updateTraversedPolylineStates();
        }
    };

    public interface OnNewRouteSelectedListener {
        void onNewRouteSelected(int i, DirectionsRoute directionsRoute);
    }

    public DirectionPolylinePlugin(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        this.mMapView = mapView;
        updateState();
        updateTraversedState();
        mapView.addOnDidFinishLoadingStyleListener(this);
        mapplsMap.addOnMapClickListener(this);
    }

    public boolean isEnableCongestion() {
        return this.enableCongestion;
    }

    public void setEnableCongestion(boolean z) {
        this.enableCongestion = z;
    }

    public void setCurrentLocation(Location location) {
        List<LineString> list = this.trips;
        if (list == null || list.size() <= 0 || this.trips.get(0) == null) {
            return;
        }
        Point point = this.trips.get(0).coordinates().get(0);
        if (point.latitude() == location.getLatitude() && point.longitude() == location.getLongitude()) {
            return;
        }
        this.traversed = TurfMisc.lineSlice(point, Point.fromLngLat(location.getLongitude(), location.getLatitude()), this.trips.get(0));
        updateTraversedPolylineStatus();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        if (z != this.enabled) {
            this.enabled = z;
            updateState();
        }
    }

    public void setOnNewRouteSelectedListener(OnNewRouteSelectedListener onNewRouteSelectedListener) {
        this.onNewRouteSelectedListener = onNewRouteSelectedListener;
    }

    public void removePolylineClickListener() {
        this.onNewRouteSelectedListener = null;
    }

    public void showSelectedOnly(final boolean z) {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.3
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                Iterator it2 = DirectionPolylinePlugin.this.layerIds.iterator();
                while (it2.hasNext()) {
                    Layer layer = style.getLayer((String) it2.next());
                    if (layer != null && (layer.getId().equalsIgnoreCase("route_alternate") || layer.getId().equalsIgnoreCase("route_alternate_case"))) {
                        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                        propertyValueArr[0] = PropertyFactory.visibility(z ? "none" : "visible");
                        layer.setProperties(propertyValueArr);
                        PropertyValue<?>[] propertyValueArr2 = new PropertyValue[1];
                        propertyValueArr2[0] = PropertyFactory.lineOpacity(Float.valueOf(z ? 0.0f : 1.0f));
                        layer.setProperties(propertyValueArr2);
                    }
                }
            }
        });
    }

    public void toggle() {
        this.enabled = !this.enabled;
        updateState();
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        updateState();
        updateTraversedState();
        if (isEnabled()) {
            updatePolylineStatus();
        }
    }

    private void updateTraversedState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.4
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (style.getSource("traversed_directions") == null) {
                    DirectionPolylinePlugin.this.initialiseTraversed(style);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseTraversed(Style style) {
        if (style.getSource("traversed_directions") == null) {
            style.addSource(new GeoJsonSource("traversed_directions"));
        }
        addTraversedPathLayer(style);
    }

    private void updateState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.5
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (style.getSourceAs("directions") == null) {
                    DirectionPolylinePlugin.this.initialise(style);
                } else {
                    DirectionPolylinePlugin directionPolylinePlugin = DirectionPolylinePlugin.this;
                    directionPolylinePlugin.setVisibility(directionPolylinePlugin.enabled, style);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialise(Style style) {
        this.layerIds = new ArrayList();
        addDirectionPolylineSource(style);
        addDirectionsLayer(style);
        addImagesToMap(style);
    }

    private void addDirectionPolylineSource(Style style) {
        style.addSource(new GeoJsonSource("directions"));
    }

    private void addDirectionsLayer(Style style) {
        try {
            addSelectedPathLayer(style);
            addAlternatePathLayer(style);
            addCongestionLayer(style);
            addSymbolLayer(style);
        } catch (Exception unused) {
            Timber.e("Unable to attach directions Layers to current style.", new Object[0]);
        }
    }

    private void addCongestionLayer(Style style) {
        Expression.Interpolator interpolatorExponential = Expression.exponential(Float.valueOf(1.5f));
        Expression expressionZoom = Expression.zoom();
        Float fValueOf = Float.valueOf(6.5f);
        LineLayer lineLayerWithProperties = new LineLayer(CONGESTION_LAYER, "directions").withProperties(PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.lineWidth(Expression.interpolate(interpolatorExponential, expressionZoom, Expression.stop(14, fValueOf), Expression.stop(20, fValueOf))), PropertyFactory.lineColor(Expression.match(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(0))), Expression.stop("moderate", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#ff8c1a")))), Expression.stop("heavy", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#981b25")))), Expression.stop("severe", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#8b0000")))))));
        if (style.getSource(CONGESTION_LAYER) == null) {
            style.addLayerAbove(lineLayerWithProperties, "route_selected");
        }
    }

    private void addSymbolLayer(Style style) {
        SymbolLayer symbolLayerWithProperties = new SymbolLayer("directions-marker-layer", "directions").withProperties(PropertyFactory.iconImage(CONSTANT_WAYPOINTS), PropertyFactory.iconAnchor("bottom"));
        symbolLayerWithProperties.withFilter(DirectionsSymbolLayer.FILTER);
        symbolLayerWithProperties.setSourceLayer("directions");
        style.addLayer(symbolLayerWithProperties);
        this.layerIds.add(symbolLayerWithProperties.getId());
    }

    private void addTraversedPathLayer(Style style) {
        addTrafficLayersToMap(DirectionsLayer.getTraversedLineLayer("route_traversed_case", 0.0f, TraversedRoute.FILTER, TraversedRoute.FUNCTION_LINE_COLOR_CASE, TraversedRoute.FUNCTION_LINE_WIDTH_CASE, TraversedRoute.FUNCTION_LINE_OFFSET, TraversedRoute.FUNCTION_LINE_OPACITY_CASE), DirectionsLayer.getTraversedLineLayer("route_traversed", 0.0f, TraversedRoute.FILTER, TraversedRoute.FUNCTION_LINE_COLOR, TraversedRoute.FUNCTION_LINE_WIDTH, TraversedRoute.FUNCTION_LINE_OFFSET), "highway_name", style);
    }

    private void addSelectedPathLayer(Style style) {
        addTrafficLayersToMap(DirectionsLayer.getLineLayer("route_selected_case", 0.0f, SelectedRoute.FILTER, SelectedRoute.FUNCTION_LINE_COLOR_CASE, SelectedRoute.FUNCTION_LINE_WIDTH_CASE, SelectedRoute.FUNCTION_LINE_OFFSET, SelectedRoute.FUNCTION_LINE_OPACITY_CASE), DirectionsLayer.getLineLayer("route_selected", 0.0f, SelectedRoute.FILTER, SelectedRoute.FUNCTION_LINE_COLOR, SelectedRoute.FUNCTION_LINE_WIDTH, SelectedRoute.FUNCTION_LINE_OFFSET), "highway_name", style);
    }

    private void addAlternatePathLayer(Style style) {
        addTrafficLayersToMap(DirectionsLayer.getLineLayer("route_alternate_case", 0.0f, AlternateRoute.FILTER, AlternateRoute.FUNCTION_LINE_COLOR_CASE, AlternateRoute.FUNCTION_LINE_WIDTH_CASE, AlternateRoute.FUNCTION_LINE_OFFSET), DirectionsLayer.getLineLayer("route_alternate", 0.0f, AlternateRoute.FILTER, AlternateRoute.FUNCTION_LINE_COLOR, AlternateRoute.FUNCTION_LINE_WIDTH, AlternateRoute.FUNCTION_LINE_OFFSET), getLastAddedLayerId(), style);
    }

    private void addAdvicesSymbolLayer(Style style) {
        SymbolLayer symbolLayerWithProperties = new SymbolLayer("directions-marker-advices-layer", "directions").withProperties(PropertyFactory.iconImage(CONSTANT_TRACK_POINTS));
        symbolLayerWithProperties.withFilter(DirectionsSymbolLayer.FILTER_ADVICES);
        symbolLayerWithProperties.setSourceLayer("directions");
        style.addLayerAbove(symbolLayerWithProperties, getLastAddedLayerId());
        this.layerIds.add(symbolLayerWithProperties.getId());
    }

    private String getLastAddedLayerId() {
        List<String> list = this.layerIds;
        return list.get(list.size() - 1);
    }

    private void addTrafficLayersToMap(Layer layer, Layer layer2, String str, Style style) {
        if (style.getLayer(str) != null) {
            style.addLayerBelow(layer, str);
        } else {
            style.addLayer(layer);
        }
        style.addLayerAbove(layer2, layer.getId());
        this.layerIds.add(layer.getId());
        this.layerIds.add(layer2.getId());
    }

    private void addAboveTrafficLayersToMap(Layer layer, Layer layer2, String str, Style style) {
        if (style.getLayer(str) != null) {
            style.addLayerAbove(layer, str);
        } else {
            style.addLayer(layer);
        }
        style.addLayerAbove(layer2, layer.getId());
        this.layerIds.add(layer.getId());
        this.layerIds.add(layer2.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibility(boolean z, Style style) {
        List<String> list;
        List<Layer> layers;
        if (this.mapplsMap == null || (list = this.layerIds) == null || list.size() <= 0 || (layers = style.getLayers()) == null || layers.size() <= 0) {
            return;
        }
        for (Layer layer : layers) {
            if (this.layerIds.contains(layer.getId())) {
                PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
                layer.setProperties(propertyValueArr);
            }
        }
        setBearingLayerVisibility(this.bearingVisibility, style);
    }

    public int getSelected() {
        return this.selected;
    }

    public void setSelected(int i) {
        this.selected = i;
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.6
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                DirectionPolylinePlugin.this.setVisibility(true, style);
            }
        });
        updatePolylineStatus();
    }

    public void setTrips(List<LineString> list, LatLng latLng, LatLng latLng2, List<LatLng> list2, List<DirectionsRoute> list3) {
        this.startLatLng = latLng;
        this.endLatLng = latLng2;
        this.wayPoints = list2;
        this.trips = list;
        this.directionsRouteList = list3;
        this.selected = 0;
        updatePolylineStatus();
        updateTraversedPolylineStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateSelectedPolylineStates() {
        if (this.trips == null) {
            return;
        }
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.7
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(final Style style) {
                DirectionPolylinePlugin.this.setVisibility(true, style);
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList(DirectionPolylinePlugin.this.trips.size());
                        int i = 0;
                        int i2 = 0;
                        while (i2 < DirectionPolylinePlugin.this.trips.size()) {
                            Feature featureFromGeometry = Feature.fromGeometry((LineString) DirectionPolylinePlugin.this.trips.get(i2));
                            featureFromGeometry.addStringProperty(DirectionPolylinePlugin.FILTER_TEXT, DirectionPolylinePlugin.this.selected == i2 ? "selected" : "alternate");
                            featureFromGeometry.addNumberProperty(DirectionPolylinePlugin.POSITION_TEXT, Integer.valueOf(i2));
                            arrayList.add(featureFromGeometry);
                            i2++;
                        }
                        if (DirectionPolylinePlugin.this.position != null) {
                            Feature featureFromGeometry2 = Feature.fromGeometry(Point.fromLngLat(DirectionPolylinePlugin.this.position.getLongitude(), DirectionPolylinePlugin.this.position.getLatitude()));
                            featureFromGeometry2.addStringProperty("icon", "directions-marker-bearing-image");
                            featureFromGeometry2.addStringProperty(DirectionPolylinePlugin.FILTER_TEXT, "bearing");
                            arrayList.add(featureFromGeometry2);
                        }
                        if (DirectionPolylinePlugin.this.endLatLng != null) {
                            Feature featureFromGeometry3 = Feature.fromGeometry(Point.fromLngLat(DirectionPolylinePlugin.this.endLatLng.getLongitude(), DirectionPolylinePlugin.this.endLatLng.getLatitude()));
                            featureFromGeometry3.addStringProperty("icon", DirectionPolylinePlugin.CONSTANT_END);
                            featureFromGeometry3.addStringProperty(DirectionPolylinePlugin.FILTER_TEXT, "marker");
                            arrayList.add(DirectionPolylinePlugin.this.appendIdInFeature(featureFromGeometry3, "end-marker"));
                        }
                        if (DirectionPolylinePlugin.this.wayPoints != null) {
                            for (LatLng latLng : DirectionPolylinePlugin.this.wayPoints) {
                                Feature featureFromGeometry4 = Feature.fromGeometry(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
                                featureFromGeometry4.addStringProperty("icon", DirectionPolylinePlugin.CONSTANT_WAYPOINTS);
                                featureFromGeometry4.addStringProperty(DirectionPolylinePlugin.FILTER_TEXT, "marker");
                                arrayList.add(DirectionPolylinePlugin.this.appendIdInFeature(featureFromGeometry4, "via-marker-" + i));
                                i++;
                            }
                        }
                        final FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(arrayList);
                        DirectionPolylinePlugin.this.mMapView.post(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSourceAs("directions");
                                if (geoJsonSource != null) {
                                    geoJsonSource.setGeoJson(featureCollectionFromFeatures);
                                }
                            }
                        });
                        DirectionPolylinePlugin.this.addCongestion(arrayList, style);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCongestion(List<Feature> list, final Style style) {
        List<DirectionsRoute> list2;
        if (!this.enableCongestion || (list2 = this.directionsRouteList) == null || this.trips == null) {
            return;
        }
        list.addAll(createCongestionFeature(list2.get(this.selected), this.trips.get(this.selected)));
        final FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(list);
        this.mMapView.post(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.8
            @Override // java.lang.Runnable
            public void run() {
                GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSourceAs("directions");
                if (geoJsonSource != null) {
                    geoJsonSource.setGeoJson(featureCollectionFromFeatures);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateTraversedPolylineStates() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.9
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (DirectionPolylinePlugin.this.traversed == null) {
                    FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(new ArrayList());
                    GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSourceAs("traversed_directions");
                    if (geoJsonSource != null) {
                        geoJsonSource.setGeoJson(featureCollectionFromFeatures);
                        return;
                    }
                    return;
                }
                Feature featureFromGeometry = Feature.fromGeometry(DirectionPolylinePlugin.this.traversed);
                featureFromGeometry.addStringProperty(DirectionPolylinePlugin.FILTER_TEXT, "traversed");
                GeoJsonSource geoJsonSource2 = (GeoJsonSource) style.getSourceAs("traversed_directions");
                if (geoJsonSource2 != null) {
                    geoJsonSource2.setGeoJson(featureFromGeometry);
                }
            }
        });
    }

    private List<Feature> createCongestionFeature(DirectionsRoute directionsRoute, LineString lineString) {
        ArrayList arrayList = new ArrayList();
        if (directionsRoute.legs() != null) {
            RouteLeg routeLeg = directionsRoute.legs().get(0);
            if (routeLeg != null && routeLeg.annotation() != null && routeLeg.annotation().congestion() != null) {
                List<String> listCongestion = routeLeg.annotation().congestion();
                for (int i = 0; i < listCongestion.size(); i++) {
                    if (listCongestion.size() + 1 <= lineString.coordinates().size()) {
                        String str = listCongestion.get(i);
                        Point point = lineString.coordinates().get(i);
                        Point point2 = lineString.coordinates().get(i + 1);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(point);
                        arrayList2.add(point2);
                        Feature featureFromGeometry = Feature.fromGeometry(LineString.fromLngLats(arrayList2));
                        featureFromGeometry.addStringProperty(DirectionsCriteria.ANNOTATION_CONGESTION, str);
                        arrayList.add(featureFromGeometry);
                    }
                }
            }
        }
        return arrayList;
    }

    private void addImagesToMap(Style style) {
        try {
            Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(this.mMapView.getContext().getResources().getDrawable(R.drawable.destination));
            Bitmap bitmapFromDrawable2 = BitmapUtils.getBitmapFromDrawable(this.mMapView.getContext().getResources().getDrawable(R.drawable.destination));
            Bitmap bitmapFromDrawable3 = BitmapUtils.getBitmapFromDrawable(this.mMapView.getContext().getResources().getDrawable(R.drawable.destination));
            Bitmap bitmapFromDrawable4 = BitmapUtils.getBitmapFromDrawable(this.mMapView.getContext().getResources().getDrawable(R.drawable.destination));
            style.addImage(CONSTANT_START, bitmapFromDrawable);
            style.addImage(CONSTANT_END, bitmapFromDrawable2);
            style.addImage(CONSTANT_WAYPOINTS, bitmapFromDrawable3);
            style.addImage(CONSTANT_TRACK_POINTS, bitmapFromDrawable4);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePolylineStatus() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.updatePolylineStateRunnable, 100L);
    }

    private void updateTraversedPolylineStatus() {
        this.traversedHandler.removeCallbacksAndMessages(null);
        this.traversedHandler.postDelayed(this.updateTraversedPolylineStateRunnable, 10L);
    }

    public void removeAllData() {
        if (this.mapplsMap.getStyle() == null || !this.mapplsMap.getStyle().isFullyLoaded()) {
            return;
        }
        GeoJsonSource geoJsonSource = (GeoJsonSource) this.mapplsMap.getStyle().getSourceAs("directions");
        if (geoJsonSource != null) {
            geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(new ArrayList()));
        }
        GeoJsonSource geoJsonSource2 = (GeoJsonSource) this.mapplsMap.getStyle().getSourceAs("traversed_directions");
        if (geoJsonSource2 != null) {
            geoJsonSource2.setGeoJson(FeatureCollection.fromFeatures(new ArrayList()));
        }
    }

    public void setBearingLayerVisibility(boolean z, Style style) {
        Layer layer = style.getLayer("directions-marker-bearing-layer");
        if (layer != null) {
            PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
            propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
            layer.setProperties(propertyValueArr);
        }
        this.bearingVisibility = z;
    }

    public void setBearingIcon(float f, LatLng latLng) {
        this.bearing = f;
        this.position = latLng;
        updatePolylineStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Feature appendIdInFeature(Feature feature, String str) {
        try {
            JSONObject jSONObject = new JSONObject(feature.toJson());
            jSONObject.put("id", str);
            return Feature.fromJson(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
    public boolean onMapClick(LatLng latLng) {
        if (this.directionsRouteList == null) {
            return false;
        }
        HashMap<LineString, DirectionsRoute> map = new HashMap<>();
        for (DirectionsRoute directionsRoute : this.directionsRouteList) {
            map.put(LineString.fromPolyline(directionsRoute.geometry(), 6), directionsRoute);
        }
        findClickedRoute(this.mapplsMap, latLng, map, this.directionsRouteList);
        return false;
    }

    private void findClickedRoute(final MapplsMap mapplsMap, LatLng latLng, final HashMap<LineString, DirectionsRoute> map, final List<DirectionsRoute> list) {
        final HashMap map2 = new HashMap();
        final Point pointFromLngLat = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
        final PointF screenLocation = mapplsMap.getProjection().toScreenLocation(latLng);
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.10
            @Override // java.lang.Runnable
            public void run() {
                DirectionPolylinePlugin.this.calculateClickDistances(mapplsMap, map2, pointFromLngLat, screenLocation, map);
                ArrayList arrayList = new ArrayList(map2.keySet());
                Collections.sort(arrayList);
                if (arrayList.size() > 0) {
                    Double d = (Double) arrayList.get(0);
                    if (d.doubleValue() < 100.0d) {
                        final DirectionsRoute directionsRoute = (DirectionsRoute) map2.get(d);
                        final int iIndexOf = list.indexOf(directionsRoute);
                        DirectionPolylinePlugin.this.selected = iIndexOf;
                        DirectionPolylinePlugin.this.mMapView.post(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DirectionPolylinePlugin.this.updatePolylineStatus();
                                if (DirectionPolylinePlugin.this.onNewRouteSelectedListener != null) {
                                    DirectionPolylinePlugin.this.onNewRouteSelectedListener.onNewRouteSelected(iIndexOf, directionsRoute);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateClickDistances(final MapplsMap mapplsMap, final HashMap<Double, DirectionsRoute> map, Point point, final PointF pointF, final HashMap<LineString, DirectionsRoute> map2) {
        final LineString next;
        final Point pointFindPointOnLine;
        Iterator<LineString> it2 = map2.keySet().iterator();
        while (it2.hasNext() && (pointFindPointOnLine = findPointOnLine(point, (next = it2.next()))) != null) {
            this.mMapView.post(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.11
                @Override // java.lang.Runnable
                public void run() {
                    PointF screenLocation = mapplsMap.getProjection().toScreenLocation(new LatLng(pointFindPointOnLine.latitude(), pointFindPointOnLine.longitude()));
                    double dHypot = Math.hypot(pointF.x - screenLocation.x, pointF.y - screenLocation.y);
                    Timber.d("Distance is equal 2  --->  " + dHypot, new Object[0]);
                    map.put(Double.valueOf(dHypot), (DirectionsRoute) map2.get(next));
                }
            });
        }
    }

    private Point findPointOnLine(Point point, LineString lineString) {
        return (Point) TurfMisc.nearestPointOnLine(point, lineString.coordinates()).geometry();
    }

    private static class DirectionsLayer {
        private DirectionsLayer() {
        }

        static LineLayer getLineLayer(String str, float f, Expression expression, Expression expression2, Expression expression3, Expression expression4) {
            return getLineLayer(str, f, expression, expression2, expression3, expression4, null);
        }

        static LineLayer getLineLayer(String str, float f, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5) {
            LineLayer lineLayer = new LineLayer(str, "directions");
            lineLayer.setSourceLayer("directions");
            lineLayer.setProperties(PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.lineColor(expression2), PropertyFactory.lineWidth(expression3), PropertyFactory.lineOffset(expression4));
            if (expression5 != null) {
                lineLayer.setProperties(PropertyFactory.lineOpacity(expression5));
            }
            lineLayer.setFilter(expression);
            lineLayer.setMinZoom(f);
            return lineLayer;
        }

        static LineLayer getTraversedLineLayer(String str, float f, Expression expression, Expression expression2, Expression expression3, Expression expression4) {
            return getTraversedLineLayer(str, f, expression, expression2, expression3, expression4, null);
        }

        static LineLayer getTraversedLineLayer(String str, float f, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5) {
            LineLayer lineLayer = new LineLayer(str, "traversed_directions");
            lineLayer.setSourceLayer("directions");
            lineLayer.setProperties(PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.lineColor(expression2), PropertyFactory.lineWidth(expression3), PropertyFactory.lineOffset(expression4));
            if (expression5 != null) {
                lineLayer.setProperties(PropertyFactory.lineOpacity(expression5));
            }
            lineLayer.setFilter(expression);
            lineLayer.setMinZoom(f);
            return lineLayer;
        }
    }

    private static class DirectionsFunction {
        private DirectionsFunction() {
        }

        static Expression getLineColorFunction(int i, int i2) {
            return Expression.match(Expression.get(DirectionPolylinePlugin.FILTER_TEXT), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(0))), Expression.stop("selected", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i)))), Expression.stop("alternate", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2)))), Expression.stop("traversed", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2)))));
        }

        private static Expression getIconImageFunction() {
            return Expression.string(Expression.get(Expression.literal("icon")));
        }
    }

    private static class DirectionPolylineData {
        private static final String SOURCE_ID = "directions";
        private static final String SOURCE_LAYER = "directions";
        private static final String TRAVERSED_SOURCE_ID = "traversed_directions";

        private DirectionPolylineData() {
        }
    }

    private static class DirectionType {
        static final Expression FUNCTION_LINE_COLOR = DirectionsFunction.getLineColorFunction(DirectionsColor.BASE_SELECTED_ROUTE, DirectionsColor.BASE_ALTERNATE_ROUTE);
        static final Expression FUNCTION_LINE_COLOR_CASE = DirectionsFunction.getLineColorFunction(DirectionsColor.CASE_SELECTED_ROUTE, DirectionsColor.CASE_ALTERNATE_ROUTE);

        private DirectionType() {
        }
    }

    private static class SelectedRoute extends DirectionType {
        private static final String BASE_LAYER_ID = "route_selected";
        private static final Expression FILTER;
        static final Expression FUNCTION_LINE_OFFSET;
        static final Expression FUNCTION_LINE_OPACITY_CASE;
        static final Expression FUNCTION_LINE_WIDTH;
        static final Expression FUNCTION_LINE_WIDTH_CASE;
        private static final String LOCAL_CASE_LAYER_ID = "route_selected_case";
        private static final float ZOOM_LEVEL = 0.0f;

        private SelectedRoute() {
            super();
        }

        static {
            Float fValueOf = Float.valueOf(1.5f);
            Expression.Interpolator interpolatorExponential = Expression.exponential(fValueOf);
            Expression expressionZoom = Expression.zoom();
            Float fValueOf2 = Float.valueOf(6.5f);
            FUNCTION_LINE_WIDTH = Expression.interpolate(interpolatorExponential, expressionZoom, Expression.stop(14, fValueOf2), Expression.stop(20, fValueOf2));
            Expression.Interpolator interpolatorExponential2 = Expression.exponential(fValueOf);
            Expression expressionZoom2 = Expression.zoom();
            Float fValueOf3 = Float.valueOf(8.0f);
            FUNCTION_LINE_WIDTH_CASE = Expression.interpolate(interpolatorExponential2, expressionZoom2, Expression.stop(14, fValueOf3), Expression.stop(20, fValueOf3));
            Expression.Interpolator interpolatorExponential3 = Expression.exponential(fValueOf);
            Expression expressionZoom3 = Expression.zoom();
            Float fValueOf4 = Float.valueOf(0.0f);
            FUNCTION_LINE_OFFSET = Expression.interpolate(interpolatorExponential3, expressionZoom3, Expression.stop(14, fValueOf4), Expression.stop(20, fValueOf4));
            Float fValueOf5 = Float.valueOf(1.0f);
            FUNCTION_LINE_OPACITY_CASE = Expression.interpolate(Expression.exponential(fValueOf5), Expression.zoom(), Expression.stop(15, fValueOf5), Expression.stop(16, fValueOf5));
            FILTER = Expression.match(Expression.get(DirectionPolylinePlugin.FILTER_TEXT), Expression.literal(false), Expression.stop("selected", true));
        }
    }

    private static class TraversedRoute extends DirectionType {
        private static final String BASE_LAYER_ID = "route_traversed";
        private static final String CASE_LAYER_ID = "route_traversed_case";
        private static final Expression FILTER;
        static final Expression FUNCTION_LINE_OFFSET;
        static final Expression FUNCTION_LINE_OPACITY_CASE;
        static final Expression FUNCTION_LINE_WIDTH;
        static final Expression FUNCTION_LINE_WIDTH_CASE;
        private static final float ZOOM_LEVEL = 0.0f;

        private TraversedRoute() {
            super();
        }

        static {
            Float fValueOf = Float.valueOf(1.5f);
            Expression.Interpolator interpolatorExponential = Expression.exponential(fValueOf);
            Expression expressionZoom = Expression.zoom();
            Float fValueOf2 = Float.valueOf(6.5f);
            FUNCTION_LINE_WIDTH = Expression.interpolate(interpolatorExponential, expressionZoom, Expression.stop(14, fValueOf2), Expression.stop(20, fValueOf2));
            Expression.Interpolator interpolatorExponential2 = Expression.exponential(fValueOf);
            Expression expressionZoom2 = Expression.zoom();
            Float fValueOf3 = Float.valueOf(8.0f);
            FUNCTION_LINE_WIDTH_CASE = Expression.interpolate(interpolatorExponential2, expressionZoom2, Expression.stop(14, fValueOf3), Expression.stop(20, fValueOf3));
            Expression.Interpolator interpolatorExponential3 = Expression.exponential(fValueOf);
            Expression expressionZoom3 = Expression.zoom();
            Float fValueOf4 = Float.valueOf(0.0f);
            FUNCTION_LINE_OFFSET = Expression.interpolate(interpolatorExponential3, expressionZoom3, Expression.stop(7, fValueOf4), Expression.stop(9, fValueOf4), Expression.stop(11, fValueOf4), Expression.stop(18, fValueOf4), Expression.stop(20, fValueOf4));
            Float fValueOf5 = Float.valueOf(1.0f);
            FUNCTION_LINE_OPACITY_CASE = Expression.interpolate(Expression.exponential(fValueOf5), Expression.zoom(), Expression.stop(15, fValueOf5), Expression.stop(16, fValueOf5));
            FILTER = Expression.match(Expression.get(DirectionPolylinePlugin.FILTER_TEXT), Expression.literal(false), Expression.stop("traversed", true));
        }
    }

    private static class AlternateRoute extends DirectionType {
        private static final String BASE_LAYER_ID = "route_alternate";
        private static final String CASE_LAYER_ID = "route_alternate_case";
        private static final Expression FILTER;
        static final Expression FUNCTION_LINE_OFFSET;
        static final Expression FUNCTION_LINE_OPACITY_CASE;
        static final Expression FUNCTION_LINE_WIDTH;
        static final Expression FUNCTION_LINE_WIDTH_CASE;
        private static final float ZOOM_LEVEL = 0.0f;

        private AlternateRoute() {
            super();
        }

        static {
            Float fValueOf = Float.valueOf(1.5f);
            Expression.Interpolator interpolatorExponential = Expression.exponential(fValueOf);
            Expression expressionZoom = Expression.zoom();
            Float fValueOf2 = Float.valueOf(6.5f);
            FUNCTION_LINE_WIDTH = Expression.interpolate(interpolatorExponential, expressionZoom, Expression.stop(14, fValueOf2), Expression.stop(20, fValueOf2));
            Expression.Interpolator interpolatorExponential2 = Expression.exponential(fValueOf);
            Expression expressionZoom2 = Expression.zoom();
            Float fValueOf3 = Float.valueOf(8.0f);
            FUNCTION_LINE_WIDTH_CASE = Expression.interpolate(interpolatorExponential2, expressionZoom2, Expression.stop(14, fValueOf3), Expression.stop(20, fValueOf3));
            Expression.Interpolator interpolatorExponential3 = Expression.exponential(fValueOf);
            Expression expressionZoom3 = Expression.zoom();
            Float fValueOf4 = Float.valueOf(0.0f);
            FUNCTION_LINE_OFFSET = Expression.interpolate(interpolatorExponential3, expressionZoom3, Expression.stop(7, fValueOf4), Expression.stop(9, fValueOf4), Expression.stop(11, fValueOf4), Expression.stop(18, fValueOf4), Expression.stop(20, fValueOf4));
            Float fValueOf5 = Float.valueOf(1.0f);
            FUNCTION_LINE_OPACITY_CASE = Expression.interpolate(Expression.exponential(fValueOf5), Expression.zoom(), Expression.stop(15, fValueOf5), Expression.stop(16, fValueOf5));
            FILTER = Expression.match(Expression.get(DirectionPolylinePlugin.FILTER_TEXT), Expression.literal(false), Expression.stop("alternate", true));
        }
    }

    private static class DirectionsSymbolLayer extends DirectionType {
        private static final String BASE_ADVICES_LAYER_ID = "directions-marker-advices-layer";
        private static final String BASE_BEARING_LAYER_ID = "directions-marker-bearing-layer";
        private static final String BASE_LAYER_ID = "directions-marker-layer";
        private static final Expression FILTER = Expression.match(Expression.get(DirectionPolylinePlugin.FILTER_TEXT), Expression.literal(false), Expression.stop("marker", true));
        private static final Expression FILTER_ADVICES = Expression.match(Expression.get(DirectionPolylinePlugin.FILTER_TEXT), Expression.literal(false), Expression.stop("advices", true));
        private static final String ICON_BEARING_IMAGE = "directions-marker-bearing-image";
        private static final String ICON_IMAGE = "directions-marker-image";

        private DirectionsSymbolLayer() {
            super();
        }
    }

    private static class DirectionsColor {
        private static final int BASE_SELECTED_ROUTE = Color.parseColor("#07b9fc");
        private static final int CASE_SELECTED_ROUTE = Color.parseColor("#000000");
        private static final int BASE_ALTERNATE_ROUTE = Color.parseColor("#a1bbd2");
        private static final int CASE_ALTERNATE_ROUTE = Color.parseColor("#000000");

        private DirectionsColor() {
        }
    }
}
