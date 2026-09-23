package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.CircleLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class CircleManager extends AnnotationManager<CircleLayer, Circle, CircleOptions, OnCircleDragListener, OnCircleClickListener, OnCircleLongClickListener> {
    private static final String PROPERTY_CIRCLE_PITCH_ALIGNMENT = "circle-pitch-alignment";
    private static final String PROPERTY_CIRCLE_PITCH_SCALE = "circle-pitch-scale";
    private static final String PROPERTY_CIRCLE_TRANSLATE = "circle-translate";
    private static final String PROPERTY_CIRCLE_TRANSLATE_ANCHOR = "circle-translate-anchor";

    public CircleManager(MapView mapView, MapplsMap mapplsMap, Style style) {
        this(mapView, mapplsMap, style, null, null);
    }

    public CircleManager(MapView mapView, MapplsMap mapplsMap, Style style, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, null, geoJsonOptions);
    }

    CircleManager(MapView mapView, MapplsMap mapplsMap, Style style, c<CircleLayer> cVar, String str, GeoJsonOptions geoJsonOptions, d dVar) {
        super(mapView, mapplsMap, style, cVar, dVar, str, geoJsonOptions);
    }

    public CircleManager(MapView mapView, MapplsMap mapplsMap, Style style, String str) {
        this(mapView, mapplsMap, style, str, null);
    }

    public CircleManager(MapView mapView, MapplsMap mapplsMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, new a(), str, geoJsonOptions, d.a(mapView, mapplsMap));
    }

    public List<Circle> create(FeatureCollection featureCollection) {
        List<Feature> listFeatures = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (listFeatures != null) {
            Iterator<Feature> it2 = listFeatures.iterator();
            while (it2.hasNext()) {
                CircleOptions circleOptionsFromFeature = CircleOptions.fromFeature(it2.next());
                if (circleOptionsFromFeature != null) {
                    arrayList.add(circleOptionsFromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public List<Circle> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return "id";
    }

    public String getCirclePitchAlignment() {
        return ((CircleLayer) this.layer).getCirclePitchAlignment().value;
    }

    public String getCirclePitchScale() {
        return ((CircleLayer) this.layer).getCirclePitchScale().value;
    }

    public Float[] getCircleTranslate() {
        return ((CircleLayer) this.layer).getCircleTranslate().value;
    }

    public String getCircleTranslateAnchor() {
        return ((CircleLayer) this.layer).getCircleTranslateAnchor().value;
    }

    public Expression getFilter() {
        return ((CircleLayer) this.layer).getFilter();
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        Map<String, Boolean> map = this.dataDrivenPropertyUsageMap;
        Boolean bool = Boolean.FALSE;
        map.put("circle-radius", bool);
        this.dataDrivenPropertyUsageMap.put("circle-color", bool);
        this.dataDrivenPropertyUsageMap.put("circle-blur", bool);
        this.dataDrivenPropertyUsageMap.put("circle-opacity", bool);
        this.dataDrivenPropertyUsageMap.put("circle-stroke-width", bool);
        this.dataDrivenPropertyUsageMap.put("circle-stroke-color", bool);
        this.dataDrivenPropertyUsageMap.put("circle-stroke-opacity", bool);
    }

    public void setCirclePitchAlignment(String str) {
        PropertyValue<String> propertyValueCirclePitchAlignment = PropertyFactory.circlePitchAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_PITCH_ALIGNMENT, propertyValueCirclePitchAlignment);
        ((CircleLayer) this.layer).setProperties(propertyValueCirclePitchAlignment);
    }

    public void setCirclePitchScale(String str) {
        PropertyValue<String> propertyValueCirclePitchScale = PropertyFactory.circlePitchScale(str);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_PITCH_SCALE, propertyValueCirclePitchScale);
        ((CircleLayer) this.layer).setProperties(propertyValueCirclePitchScale);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCircleTranslate(Float[] fArr) {
        PropertyValue<Float[]> propertyValueCircleTranslate = PropertyFactory.circleTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_TRANSLATE, propertyValueCircleTranslate);
        ((CircleLayer) this.layer).setProperties(propertyValueCircleTranslate);
    }

    public void setCircleTranslateAnchor(String str) {
        PropertyValue<String> propertyValueCircleTranslateAnchor = PropertyFactory.circleTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_CIRCLE_TRANSLATE_ANCHOR, propertyValueCircleTranslateAnchor);
        ((CircleLayer) this.layer).setProperties(propertyValueCircleTranslateAnchor);
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "circle-opacity":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleOpacity(Expression.get("circle-opacity")));
                break;
            case "circle-radius":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleRadius(Expression.get("circle-radius")));
                break;
            case "circle-stroke-color":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleStrokeColor(Expression.get("circle-stroke-color")));
                break;
            case "circle-stroke-width":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleStrokeWidth(Expression.get("circle-stroke-width")));
                break;
            case "circle-blur":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleBlur(Expression.get("circle-blur")));
                break;
            case "circle-color":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleColor(Expression.get("circle-color")));
                break;
            case "circle-stroke-opacity":
                ((CircleLayer) this.layer).setProperties(PropertyFactory.circleStrokeOpacity(Expression.get("circle-stroke-opacity")));
                break;
        }
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((CircleLayer) this.layer).setFilter(expression);
    }
}
