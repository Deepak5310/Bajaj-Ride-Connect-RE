package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LineManager extends AnnotationManager<LineLayer, Line, LineOptions, OnLineDragListener, OnLineClickListener, OnLineLongClickListener> {
    private static final String PROPERTY_LINE_CAP = "line-cap";
    private static final String PROPERTY_LINE_DASHARRAY = "line-dasharray";
    private static final String PROPERTY_LINE_MITER_LIMIT = "line-miter-limit";
    private static final String PROPERTY_LINE_ROUND_LIMIT = "line-round-limit";
    private static final String PROPERTY_LINE_TRANSLATE = "line-translate";
    private static final String PROPERTY_LINE_TRANSLATE_ANCHOR = "line-translate-anchor";

    public LineManager(MapView mapView, MapplsMap mapplsMap, Style style) {
        this(mapView, mapplsMap, style, null, null);
    }

    public LineManager(MapView mapView, MapplsMap mapplsMap, Style style, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, null, geoJsonOptions);
    }

    LineManager(MapView mapView, MapplsMap mapplsMap, Style style, c<LineLayer> cVar, String str, GeoJsonOptions geoJsonOptions, d dVar) {
        super(mapView, mapplsMap, style, cVar, dVar, str, geoJsonOptions);
    }

    public LineManager(MapView mapView, MapplsMap mapplsMap, Style style, String str) {
        this(mapView, mapplsMap, style, str, null);
    }

    public LineManager(MapView mapView, MapplsMap mapplsMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, new f(), str, geoJsonOptions, d.a(mapView, mapplsMap));
    }

    public List<Line> create(FeatureCollection featureCollection) {
        List<Feature> listFeatures = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (listFeatures != null) {
            Iterator<Feature> it2 = listFeatures.iterator();
            while (it2.hasNext()) {
                LineOptions lineOptionsFromFeature = LineOptions.fromFeature(it2.next());
                if (lineOptionsFromFeature != null) {
                    arrayList.add(lineOptionsFromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public List<Line> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return "id";
    }

    public Expression getFilter() {
        return ((LineLayer) this.layer).getFilter();
    }

    public String getLineCap() {
        return ((LineLayer) this.layer).getLineCap().value;
    }

    public Float[] getLineDasharray() {
        return ((LineLayer) this.layer).getLineDasharray().value;
    }

    public Float getLineMiterLimit() {
        return ((LineLayer) this.layer).getLineMiterLimit().value;
    }

    public Float getLineRoundLimit() {
        return ((LineLayer) this.layer).getLineRoundLimit().value;
    }

    public Float[] getLineTranslate() {
        return ((LineLayer) this.layer).getLineTranslate().value;
    }

    public String getLineTranslateAnchor() {
        return ((LineLayer) this.layer).getLineTranslateAnchor().value;
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        Map<String, Boolean> map = this.dataDrivenPropertyUsageMap;
        Boolean bool = Boolean.FALSE;
        map.put("line-join", bool);
        this.dataDrivenPropertyUsageMap.put("line-opacity", bool);
        this.dataDrivenPropertyUsageMap.put("line-color", bool);
        this.dataDrivenPropertyUsageMap.put("line-width", bool);
        this.dataDrivenPropertyUsageMap.put("line-gap-width", bool);
        this.dataDrivenPropertyUsageMap.put("line-offset", bool);
        this.dataDrivenPropertyUsageMap.put("line-blur", bool);
        this.dataDrivenPropertyUsageMap.put("line-pattern", bool);
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "line-blur":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineBlur(Expression.get("line-blur")));
                break;
            case "line-join":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineJoin(Expression.get("line-join")));
                break;
            case "line-gap-width":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineGapWidth(Expression.get("line-gap-width")));
                break;
            case "line-color":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineColor(Expression.get("line-color")));
                break;
            case "line-width":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineWidth(Expression.get("line-width")));
                break;
            case "line-opacity":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineOpacity(Expression.get("line-opacity")));
                break;
            case "line-offset":
                ((LineLayer) this.layer).setProperties(PropertyFactory.lineOffset(Expression.get("line-offset")));
                break;
            case "line-pattern":
                ((LineLayer) this.layer).setProperties(PropertyFactory.linePattern(Expression.get("line-pattern")));
                break;
        }
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((LineLayer) this.layer).setFilter(expression);
    }

    public void setLineCap(String str) {
        PropertyValue<String> propertyValueLineCap = PropertyFactory.lineCap(str);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_CAP, propertyValueLineCap);
        ((LineLayer) this.layer).setProperties(propertyValueLineCap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLineDasharray(Float[] fArr) {
        PropertyValue<Float[]> propertyValueLineDasharray = PropertyFactory.lineDasharray(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_DASHARRAY, propertyValueLineDasharray);
        ((LineLayer) this.layer).setProperties(propertyValueLineDasharray);
    }

    public void setLineMiterLimit(Float f) {
        PropertyValue<Float> propertyValueLineMiterLimit = PropertyFactory.lineMiterLimit(f);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_MITER_LIMIT, propertyValueLineMiterLimit);
        ((LineLayer) this.layer).setProperties(propertyValueLineMiterLimit);
    }

    public void setLineRoundLimit(Float f) {
        PropertyValue<Float> propertyValueLineRoundLimit = PropertyFactory.lineRoundLimit(f);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_ROUND_LIMIT, propertyValueLineRoundLimit);
        ((LineLayer) this.layer).setProperties(propertyValueLineRoundLimit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLineTranslate(Float[] fArr) {
        PropertyValue<Float[]> propertyValueLineTranslate = PropertyFactory.lineTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_TRANSLATE, propertyValueLineTranslate);
        ((LineLayer) this.layer).setProperties(propertyValueLineTranslate);
    }

    public void setLineTranslateAnchor(String str) {
        PropertyValue<String> propertyValueLineTranslateAnchor = PropertyFactory.lineTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_LINE_TRANSLATE_ANCHOR, propertyValueLineTranslateAnchor);
        ((LineLayer) this.layer).setProperties(propertyValueLineTranslateAnchor);
    }
}
