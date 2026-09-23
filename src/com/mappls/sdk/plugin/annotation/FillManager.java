package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.FillLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FillManager extends AnnotationManager<FillLayer, Fill, FillOptions, OnFillDragListener, OnFillClickListener, OnFillLongClickListener> {
    private static final String PROPERTY_FILL_ANTIALIAS = "fill-antialias";
    private static final String PROPERTY_FILL_TRANSLATE = "fill-translate";
    private static final String PROPERTY_FILL_TRANSLATE_ANCHOR = "fill-translate-anchor";

    public FillManager(MapView mapView, MapplsMap mapplsMap, Style style) {
        this(mapView, mapplsMap, style, null, null);
    }

    public FillManager(MapView mapView, MapplsMap mapplsMap, Style style, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, null, geoJsonOptions);
    }

    FillManager(MapView mapView, MapplsMap mapplsMap, Style style, c<FillLayer> cVar, String str, GeoJsonOptions geoJsonOptions, d dVar) {
        super(mapView, mapplsMap, style, cVar, dVar, str, geoJsonOptions);
    }

    public FillManager(MapView mapView, MapplsMap mapplsMap, Style style, String str) {
        this(mapView, mapplsMap, style, str, null);
    }

    public FillManager(MapView mapView, MapplsMap mapplsMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, new e(), str, geoJsonOptions, d.a(mapView, mapplsMap));
    }

    public List<Fill> create(FeatureCollection featureCollection) {
        List<Feature> listFeatures = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (listFeatures != null) {
            Iterator<Feature> it2 = listFeatures.iterator();
            while (it2.hasNext()) {
                FillOptions fillOptionsFromFeature = FillOptions.fromFeature(it2.next());
                if (fillOptionsFromFeature != null) {
                    arrayList.add(fillOptionsFromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public List<Fill> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return "id";
    }

    public Boolean getFillAntialias() {
        return ((FillLayer) this.layer).getFillAntialias().value;
    }

    public Float[] getFillTranslate() {
        return ((FillLayer) this.layer).getFillTranslate().value;
    }

    public String getFillTranslateAnchor() {
        return ((FillLayer) this.layer).getFillTranslateAnchor().value;
    }

    public Expression getFilter() {
        return ((FillLayer) this.layer).getFilter();
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        Map<String, Boolean> map = this.dataDrivenPropertyUsageMap;
        Boolean bool = Boolean.FALSE;
        map.put("fill-opacity", bool);
        this.dataDrivenPropertyUsageMap.put("fill-color", bool);
        this.dataDrivenPropertyUsageMap.put("fill-outline-color", bool);
        this.dataDrivenPropertyUsageMap.put("fill-pattern", bool);
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "fill-color":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillColor(Expression.get("fill-color")));
                break;
            case "fill-opacity":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillOpacity(Expression.get("fill-opacity")));
                break;
            case "fill-pattern":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillPattern(Expression.get("fill-pattern")));
                break;
            case "fill-outline-color":
                ((FillLayer) this.layer).setProperties(PropertyFactory.fillOutlineColor(Expression.get("fill-outline-color")));
                break;
        }
    }

    public void setFillAntialias(Boolean bool) {
        PropertyValue<Boolean> propertyValueFillAntialias = PropertyFactory.fillAntialias(bool);
        this.constantPropertyUsageMap.put(PROPERTY_FILL_ANTIALIAS, propertyValueFillAntialias);
        ((FillLayer) this.layer).setProperties(propertyValueFillAntialias);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFillTranslate(Float[] fArr) {
        PropertyValue<Float[]> propertyValueFillTranslate = PropertyFactory.fillTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_FILL_TRANSLATE, propertyValueFillTranslate);
        ((FillLayer) this.layer).setProperties(propertyValueFillTranslate);
    }

    public void setFillTranslateAnchor(String str) {
        PropertyValue<String> propertyValueFillTranslateAnchor = PropertyFactory.fillTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_FILL_TRANSLATE_ANCHOR, propertyValueFillTranslateAnchor);
        ((FillLayer) this.layer).setProperties(propertyValueFillTranslateAnchor);
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((FillLayer) this.layer).setFilter(expression);
    }
}
