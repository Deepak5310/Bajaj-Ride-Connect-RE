package com.bajajconnect.navigate.maps.plugins;

import androidx.core.content.ContextCompat;
import com.bajajconnect.R;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.utils.MathUtils;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfMeasurement;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RouteArrowPlugin implements MapView.OnDidFinishLoadingStyleListener {
    static final String ARROW_BEARING = "mappls-navigation-arrow-bearing";
    static final String ARROW_HEAD_CASING_LAYER_ID = "mappls-navigation-arrow-head-casing-layer";
    static final Float[] ARROW_HEAD_CASING_OFFSET;
    static final String ARROW_HEAD_ICON = "mappls-navigation-arrow-head-icon";
    static final String ARROW_HEAD_ICON_CASING = "mappls-navigation-arrow-head-icon-casing";
    static final String ARROW_HEAD_LAYER_ID = "mappls-navigation-arrow-head-layer";
    static final Float[] ARROW_HEAD_OFFSET;
    static final String ARROW_HEAD_SOURCE_ID = "mappls-navigation-arrow-head-source";
    static final String ARROW_SHAFT_CASING_LINE_LAYER_ID = "mappls-navigation-arrow-shaft-casing-layer";
    static final String ARROW_SHAFT_LINE_LAYER_ID = "mappls-navigation-arrow-shaft-layer";
    static final String ARROW_SHAFT_SOURCE_ID = "mappls-navigation-arrow-shaft-source";
    static final int MAX_DEGREES = 360;
    private GeoJsonSource arrowHeadGeoJsonSource;
    private GeoJsonSource arrowShaftGeoJsonSource;
    private List<Point> maneuverPoints;
    private MapView mapView;
    private MapplsMap mapplsMap;

    public void addUpcomingManeuverArrow(LegStep legStep, LegStep legStep2) {
    }

    static {
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(-7.0f);
        ARROW_HEAD_CASING_OFFSET = new Float[]{fValueOf, fValueOf2};
        ARROW_HEAD_OFFSET = new Float[]{fValueOf, fValueOf2};
    }

    public RouteArrowPlugin(MapView mapView, MapplsMap mapplsMap) {
        this.mapView = mapView;
        this.mapplsMap = mapplsMap;
        mapView.addOnDidFinishLoadingStyleListener(this);
        mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin.1
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                RouteArrowPlugin.this.initialize("directions-marker-layer", style);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize(String str, Style style) {
        initializeArrowShaft(style);
        initializeArrowHead(style);
        addArrowHeadIcon(style);
        addArrowHeadIconCasing(style);
        LineLayer lineLayerCreateArrowShaftLayer = createArrowShaftLayer(style);
        LineLayer lineLayerCreateArrowShaftCasingLayer = createArrowShaftCasingLayer(style);
        SymbolLayer symbolLayerCreateArrowHeadLayer = createArrowHeadLayer(style);
        SymbolLayer symbolLayerCreateArrowHeadCasingLayer = createArrowHeadCasingLayer(style);
        style.addLayerAbove(lineLayerCreateArrowShaftCasingLayer, str);
        style.addLayerAbove(symbolLayerCreateArrowHeadCasingLayer, lineLayerCreateArrowShaftCasingLayer.getId());
        style.addLayerAbove(lineLayerCreateArrowShaftLayer, symbolLayerCreateArrowHeadCasingLayer.getId());
        style.addLayerAbove(symbolLayerCreateArrowHeadLayer, lineLayerCreateArrowShaftLayer.getId());
    }

    void updateVisibilityTo(final boolean z) {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin.2
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(RouteArrowPlugin.ARROW_SHAFT_CASING_LINE_LAYER_ID);
                arrayList.add(RouteArrowPlugin.ARROW_SHAFT_LINE_LAYER_ID);
                arrayList.add(RouteArrowPlugin.ARROW_HEAD_CASING_LAYER_ID);
                arrayList.add(RouteArrowPlugin.ARROW_HEAD_LAYER_ID);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Layer layer = style.getLayer((String) it2.next());
                    if (layer != null) {
                        String str = z ? "visible" : "none";
                        if (!str.equals(layer.getVisibility().getValue())) {
                            layer.setProperties(PropertyFactory.visibility(str));
                        }
                    }
                }
            }
        });
    }

    private List<Point> obtainArrowPointsFrom(List<Point> list, List<Point> list2) {
        Collections.reverse(list);
        LineString lineStringFromLngLats = LineString.fromLngLats(list);
        LineString lineStringFromLngLats2 = LineString.fromLngLats(list2);
        LineString lineStringLineSliceAlong = TurfMisc.lineSliceAlong(lineStringFromLngLats, 0.0d, 30.0d, TurfConstants.UNIT_METERS);
        LineString lineStringLineSliceAlong2 = TurfMisc.lineSliceAlong(lineStringFromLngLats2, 0.0d, 30.0d, TurfConstants.UNIT_METERS);
        Collections.reverse(lineStringLineSliceAlong.coordinates());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(lineStringLineSliceAlong.coordinates());
        arrayList.addAll(lineStringLineSliceAlong2.coordinates());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateArrowShaftWith(List<Point> list) {
        if (list == null && this.mapplsMap.getStyle() != null && this.mapplsMap.getStyle().isFullyLoaded()) {
            return;
        }
        this.arrowShaftGeoJsonSource.setGeoJson(Feature.fromGeometry(LineString.fromLngLats(list)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateArrowHeadWith(List<Point> list) {
        if (list == null && this.mapplsMap.getStyle() != null && this.mapplsMap.getStyle().isFullyLoaded()) {
            return;
        }
        double dBearing = TurfMeasurement.bearing(list.get(list.size() - 2), list.get(list.size() - 1));
        Feature featureFromGeometry = Feature.fromGeometry(list.get(list.size() - 1));
        featureFromGeometry.addNumberProperty(ARROW_BEARING, Float.valueOf((float) MathUtils.wrap(dBearing, 0.0d, 360.0d)));
        this.arrowHeadGeoJsonSource.setGeoJson(featureFromGeometry);
    }

    private void initializeArrowShaft(Style style) {
        if (style.getSource(ARROW_SHAFT_SOURCE_ID) == null) {
            GeoJsonSource geoJsonSource = new GeoJsonSource(ARROW_SHAFT_SOURCE_ID, FeatureCollection.fromFeatures(new Feature[0]), new GeoJsonOptions().withMaxZoom(16));
            this.arrowShaftGeoJsonSource = geoJsonSource;
            style.addSource(geoJsonSource);
        }
        List<Point> list = this.maneuverPoints;
        if (list != null) {
            updateArrowShaftWith(list);
        }
    }

    private void initializeArrowHead(Style style) {
        if (style.getSource(ARROW_HEAD_SOURCE_ID) == null) {
            GeoJsonSource geoJsonSource = new GeoJsonSource(ARROW_HEAD_SOURCE_ID, FeatureCollection.fromFeatures(new Feature[0]), new GeoJsonOptions().withMaxZoom(16));
            this.arrowHeadGeoJsonSource = geoJsonSource;
            style.addSource(geoJsonSource);
        }
        List<Point> list = this.maneuverPoints;
        if (list != null) {
            updateArrowHeadWith(list);
        }
    }

    private void addArrowHeadIcon(Style style) {
        style.addImage(ARROW_HEAD_ICON, BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(this.mapView.getContext(), R.drawable.ic_arrow_head)));
    }

    private void addArrowHeadIconCasing(Style style) {
        style.addImage(ARROW_HEAD_ICON_CASING, BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(this.mapView.getContext(), R.drawable.ic_arrow_head_casing)));
    }

    private LineLayer createArrowShaftLayer(Style style) {
        LineLayer lineLayer = (LineLayer) style.getLayerAs(ARROW_SHAFT_LINE_LAYER_ID);
        if (lineLayer != null) {
            style.removeLayer(lineLayer);
        }
        return new LineLayer(ARROW_SHAFT_LINE_LAYER_ID, ARROW_SHAFT_SOURCE_ID).withProperties(PropertyFactory.lineColor(Expression.color(ContextCompat.getColor(this.mapView.getContext(), R.color.white))), PropertyFactory.lineWidth(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Float.valueOf(2.6f)), Expression.stop(22, Float.valueOf(13.0f)))), PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.visibility("none"), PropertyFactory.lineOpacity(Expression.step(Expression.zoom(), Double.valueOf(0.0d), Expression.stop(14, Double.valueOf(1.0d)))));
    }

    private LineLayer createArrowShaftCasingLayer(Style style) {
        LineLayer lineLayer = (LineLayer) style.getLayer(ARROW_SHAFT_CASING_LINE_LAYER_ID);
        if (lineLayer != null) {
            style.removeLayer(lineLayer);
        }
        return new LineLayer(ARROW_SHAFT_CASING_LINE_LAYER_ID, ARROW_SHAFT_SOURCE_ID).withProperties(PropertyFactory.lineColor(Expression.color(ContextCompat.getColor(this.mapView.getContext(), R.color.colorGray700))), PropertyFactory.lineWidth(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Float.valueOf(3.4f)), Expression.stop(22, Double.valueOf(17.0d)))), PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.visibility("none"), PropertyFactory.lineOpacity(Expression.step(Expression.zoom(), Double.valueOf(0.0d), Expression.stop(14, Double.valueOf(1.0d)))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SymbolLayer createArrowHeadLayer(Style style) {
        SymbolLayer symbolLayer = (SymbolLayer) style.getLayer(ARROW_HEAD_LAYER_ID);
        if (symbolLayer != null) {
            style.removeLayer(symbolLayer);
        }
        return new SymbolLayer(ARROW_HEAD_LAYER_ID, ARROW_HEAD_SOURCE_ID).withProperties(PropertyFactory.iconImage(ARROW_HEAD_ICON), PropertyFactory.iconAllowOverlap((Boolean) true), PropertyFactory.iconIgnorePlacement((Boolean) true), PropertyFactory.iconSize(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Double.valueOf(0.2d)), Expression.stop(22, Double.valueOf(0.8d)))), PropertyFactory.iconOffset(ARROW_HEAD_OFFSET), PropertyFactory.iconRotationAlignment("map"), PropertyFactory.iconRotate(Expression.get(ARROW_BEARING)), PropertyFactory.visibility("none"), PropertyFactory.iconOpacity(Expression.step(Expression.zoom(), Double.valueOf(0.0d), Expression.stop(14, Double.valueOf(1.0d)))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SymbolLayer createArrowHeadCasingLayer(Style style) {
        SymbolLayer symbolLayer = (SymbolLayer) style.getLayer(ARROW_HEAD_CASING_LAYER_ID);
        if (symbolLayer != null) {
            style.removeLayer(symbolLayer);
        }
        return new SymbolLayer(ARROW_HEAD_CASING_LAYER_ID, ARROW_HEAD_SOURCE_ID).withProperties(PropertyFactory.iconImage(ARROW_HEAD_ICON_CASING), PropertyFactory.iconAllowOverlap((Boolean) true), PropertyFactory.iconIgnorePlacement((Boolean) true), PropertyFactory.iconSize(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Double.valueOf(0.2d)), Expression.stop(22, Double.valueOf(0.8d)))), PropertyFactory.iconOffset(ARROW_HEAD_CASING_OFFSET), PropertyFactory.iconRotationAlignment("map"), PropertyFactory.iconRotate(Expression.get(ARROW_BEARING)), PropertyFactory.visibility("none"), PropertyFactory.iconOpacity(Expression.step(Expression.zoom(), Double.valueOf(0.0d), Expression.stop(14, Double.valueOf(1.0d)))));
    }

    void redraw(final String str) {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin.3
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (style.getSource(RouteArrowPlugin.ARROW_HEAD_SOURCE_ID) == null) {
                    RouteArrowPlugin.this.initialize(str, style);
                    return;
                }
                if (style.getSource(RouteArrowPlugin.ARROW_SHAFT_SOURCE_ID) == null) {
                    RouteArrowPlugin.this.initialize(str, style);
                    return;
                }
                RouteArrowPlugin.this.arrowHeadGeoJsonSource = (GeoJsonSource) style.getSource(RouteArrowPlugin.ARROW_HEAD_SOURCE_ID);
                RouteArrowPlugin.this.arrowShaftGeoJsonSource = (GeoJsonSource) style.getSource(RouteArrowPlugin.ARROW_SHAFT_SOURCE_ID);
                if (RouteArrowPlugin.this.arrowHeadGeoJsonSource == null || RouteArrowPlugin.this.arrowShaftGeoJsonSource == null) {
                    return;
                }
                RouteArrowPlugin routeArrowPlugin = RouteArrowPlugin.this;
                routeArrowPlugin.updateArrowShaftWith(routeArrowPlugin.maneuverPoints);
                RouteArrowPlugin routeArrowPlugin2 = RouteArrowPlugin.this;
                routeArrowPlugin2.updateArrowHeadWith(routeArrowPlugin2.maneuverPoints);
            }
        });
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        redraw("directions-marker-layer");
    }
}
