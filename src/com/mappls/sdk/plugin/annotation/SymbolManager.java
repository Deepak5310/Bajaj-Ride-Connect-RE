package com.mappls.sdk.plugin.annotation;

import com.google.common.base.Ascii;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SymbolManager extends AnnotationManager<SymbolLayer, Symbol, SymbolOptions, OnSymbolDragListener, OnSymbolClickListener, OnSymbolLongClickListener> {
    private static final String PROPERTY_ICON_ALLOW_OVERLAP = "icon-allow-overlap";
    private static final String PROPERTY_ICON_IGNORE_PLACEMENT = "icon-ignore-placement";
    private static final String PROPERTY_ICON_KEEP_UPRIGHT = "icon-keep-upright";
    private static final String PROPERTY_ICON_OPTIONAL = "icon-optional";
    private static final String PROPERTY_ICON_PADDING = "icon-padding";
    private static final String PROPERTY_ICON_PITCH_ALIGNMENT = "icon-pitch-alignment";
    private static final String PROPERTY_ICON_ROTATION_ALIGNMENT = "icon-rotation-alignment";
    private static final String PROPERTY_ICON_TEXT_FIT = "icon-text-fit";
    private static final String PROPERTY_ICON_TEXT_FIT_PADDING = "icon-text-fit-padding";
    private static final String PROPERTY_ICON_TRANSLATE = "icon-translate";
    private static final String PROPERTY_ICON_TRANSLATE_ANCHOR = "icon-translate-anchor";
    private static final String PROPERTY_SYMBOL_AVOID_EDGES = "symbol-avoid-edges";
    private static final String PROPERTY_SYMBOL_PLACEMENT = "symbol-placement";
    private static final String PROPERTY_SYMBOL_SPACING = "symbol-spacing";
    private static final String PROPERTY_TEXT_ALLOW_OVERLAP = "text-allow-overlap";
    private static final String PROPERTY_TEXT_IGNORE_PLACEMENT = "text-ignore-placement";
    private static final String PROPERTY_TEXT_KEEP_UPRIGHT = "text-keep-upright";
    private static final String PROPERTY_TEXT_LINE_HEIGHT = "text-line-height";
    private static final String PROPERTY_TEXT_MAX_ANGLE = "text-max-angle";
    private static final String PROPERTY_TEXT_OPTIONAL = "text-optional";
    private static final String PROPERTY_TEXT_PADDING = "text-padding";
    private static final String PROPERTY_TEXT_PITCH_ALIGNMENT = "text-pitch-alignment";
    private static final String PROPERTY_TEXT_ROTATION_ALIGNMENT = "text-rotation-alignment";
    private static final String PROPERTY_TEXT_TRANSLATE = "text-translate";
    private static final String PROPERTY_TEXT_TRANSLATE_ANCHOR = "text-translate-anchor";
    private static final String PROPERTY_TEXT_VARIABLE_ANCHOR = "text-variable-anchor";

    public SymbolManager(MapView mapView, MapplsMap mapplsMap, Style style) {
        this(mapView, mapplsMap, style, null, null);
    }

    public SymbolManager(MapView mapView, MapplsMap mapplsMap, Style style, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, null, geoJsonOptions);
    }

    SymbolManager(MapView mapView, MapplsMap mapplsMap, Style style, c<SymbolLayer> cVar, String str, GeoJsonOptions geoJsonOptions, d dVar) {
        super(mapView, mapplsMap, style, cVar, dVar, str, geoJsonOptions);
    }

    public SymbolManager(MapView mapView, MapplsMap mapplsMap, Style style, String str) {
        this(mapView, mapplsMap, style, str, null);
    }

    public SymbolManager(MapView mapView, MapplsMap mapplsMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapplsMap, style, new h(), str, geoJsonOptions, d.a(mapView, mapplsMap));
    }

    public List<Symbol> create(FeatureCollection featureCollection) {
        List<Feature> listFeatures = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (listFeatures != null) {
            Iterator<Feature> it2 = listFeatures.iterator();
            while (it2.hasNext()) {
                SymbolOptions symbolOptionsFromFeature = SymbolOptions.fromFeature(it2.next(), this.style);
                if (symbolOptionsFromFeature != null) {
                    arrayList.add(symbolOptionsFromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public List<Symbol> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return "id";
    }

    public Expression getFilter() {
        return ((SymbolLayer) this.layer).getFilter();
    }

    public Boolean getIconAllowOverlap() {
        return ((SymbolLayer) this.layer).getIconAllowOverlap().value;
    }

    public Boolean getIconIgnorePlacement() {
        return ((SymbolLayer) this.layer).getIconIgnorePlacement().value;
    }

    public Boolean getIconKeepUpright() {
        return ((SymbolLayer) this.layer).getIconKeepUpright().value;
    }

    public Boolean getIconOptional() {
        return ((SymbolLayer) this.layer).getIconOptional().value;
    }

    public Float getIconPadding() {
        return ((SymbolLayer) this.layer).getIconPadding().value;
    }

    public String getIconPitchAlignment() {
        return ((SymbolLayer) this.layer).getIconPitchAlignment().value;
    }

    public String getIconRotationAlignment() {
        return ((SymbolLayer) this.layer).getIconRotationAlignment().value;
    }

    public String getIconTextFit() {
        return ((SymbolLayer) this.layer).getIconTextFit().value;
    }

    public Float[] getIconTextFitPadding() {
        return ((SymbolLayer) this.layer).getIconTextFitPadding().value;
    }

    public Float[] getIconTranslate() {
        return ((SymbolLayer) this.layer).getIconTranslate().value;
    }

    public String getIconTranslateAnchor() {
        return ((SymbolLayer) this.layer).getIconTranslateAnchor().value;
    }

    public Boolean getSymbolAvoidEdges() {
        return ((SymbolLayer) this.layer).getSymbolAvoidEdges().value;
    }

    public String getSymbolPlacement() {
        return ((SymbolLayer) this.layer).getSymbolPlacement().value;
    }

    public Float getSymbolSpacing() {
        return ((SymbolLayer) this.layer).getSymbolSpacing().value;
    }

    public Boolean getTextAllowOverlap() {
        return ((SymbolLayer) this.layer).getTextAllowOverlap().value;
    }

    public Boolean getTextIgnorePlacement() {
        return ((SymbolLayer) this.layer).getTextIgnorePlacement().value;
    }

    public Boolean getTextKeepUpright() {
        return ((SymbolLayer) this.layer).getTextKeepUpright().value;
    }

    public Float getTextLineHeight() {
        return ((SymbolLayer) this.layer).getTextLineHeight().value;
    }

    public Float getTextMaxAngle() {
        return ((SymbolLayer) this.layer).getTextMaxAngle().value;
    }

    public Boolean getTextOptional() {
        return ((SymbolLayer) this.layer).getTextOptional().value;
    }

    public Float getTextPadding() {
        return ((SymbolLayer) this.layer).getTextPadding().value;
    }

    public String getTextPitchAlignment() {
        return ((SymbolLayer) this.layer).getTextPitchAlignment().value;
    }

    public String getTextRotationAlignment() {
        return ((SymbolLayer) this.layer).getTextRotationAlignment().value;
    }

    public Float[] getTextTranslate() {
        return ((SymbolLayer) this.layer).getTextTranslate().value;
    }

    public String getTextTranslateAnchor() {
        return ((SymbolLayer) this.layer).getTextTranslateAnchor().value;
    }

    public String[] getTextVariableAnchor() {
        return ((SymbolLayer) this.layer).getTextVariableAnchor().value;
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        Map<String, Boolean> map = this.dataDrivenPropertyUsageMap;
        Boolean bool = Boolean.FALSE;
        map.put("symbol-sort-key", bool);
        this.dataDrivenPropertyUsageMap.put("icon-size", bool);
        this.dataDrivenPropertyUsageMap.put("icon-image", bool);
        this.dataDrivenPropertyUsageMap.put("icon-rotate", bool);
        this.dataDrivenPropertyUsageMap.put("icon-offset", bool);
        this.dataDrivenPropertyUsageMap.put("icon-anchor", bool);
        this.dataDrivenPropertyUsageMap.put("text-field", bool);
        this.dataDrivenPropertyUsageMap.put("text-font", bool);
        this.dataDrivenPropertyUsageMap.put("text-size", bool);
        this.dataDrivenPropertyUsageMap.put("text-max-width", bool);
        this.dataDrivenPropertyUsageMap.put("text-letter-spacing", bool);
        this.dataDrivenPropertyUsageMap.put("text-justify", bool);
        this.dataDrivenPropertyUsageMap.put("text-radial-offset", bool);
        this.dataDrivenPropertyUsageMap.put("text-anchor", bool);
        this.dataDrivenPropertyUsageMap.put("text-rotate", bool);
        this.dataDrivenPropertyUsageMap.put("text-transform", bool);
        this.dataDrivenPropertyUsageMap.put("text-offset", bool);
        this.dataDrivenPropertyUsageMap.put("icon-opacity", bool);
        this.dataDrivenPropertyUsageMap.put("icon-color", bool);
        this.dataDrivenPropertyUsageMap.put("icon-halo-color", bool);
        this.dataDrivenPropertyUsageMap.put("icon-halo-width", bool);
        this.dataDrivenPropertyUsageMap.put("icon-halo-blur", bool);
        this.dataDrivenPropertyUsageMap.put("text-opacity", bool);
        this.dataDrivenPropertyUsageMap.put("text-color", bool);
        this.dataDrivenPropertyUsageMap.put("text-halo-color", bool);
        this.dataDrivenPropertyUsageMap.put("text-halo-width", bool);
        this.dataDrivenPropertyUsageMap.put("text-halo-blur", bool);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        str.hashCode();
        str.hashCode();
        String str6 = "icon-halo-color";
        String str7 = "text-radial-offset";
        String str8 = "icon-rotate";
        byte b = -1;
        switch (str.hashCode()) {
            case -2146810373:
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                if (str.equals(str3)) {
                    b = 0;
                }
                break;
            case -2041493401:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                str3 = "text-rotate";
                if (str.equals("icon-offset")) {
                    b = 1;
                }
                break;
            case -1946894033:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                b = str.equals(str8) ? (byte) 2 : (byte) -1;
                str8 = str8;
                str3 = "text-rotate";
                break;
            case -1717422239:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                b = str.equals(str7) ? (byte) 3 : (byte) -1;
                str7 = str7;
                str3 = "text-rotate";
                break;
            case -1708933018:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                b = str.equals(str6) ? (byte) 4 : (byte) -1;
                str6 = str6;
                str3 = "text-rotate";
                break;
            case -1690648887:
                str5 = "icon-color";
                str2 = "icon-halo-width";
                if (str.equals(str2)) {
                    b = 5;
                }
                str4 = str5;
                str3 = "text-rotate";
                break;
            case -1600683761:
                str5 = "icon-color";
                b = str.equals(str5) ? (byte) 6 : (byte) -1;
                str2 = "icon-halo-width";
                str4 = str5;
                str3 = "text-rotate";
                break;
            case -1595213049:
                if (str.equals("icon-image")) {
                    b = 7;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1436636971:
                if (str.equals("icon-size")) {
                    b = 8;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1336352187:
                if (str.equals("symbol-sort-key")) {
                    b = 9;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1262567732:
                if (str.equals("text-transform")) {
                    b = 10;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1084154641:
                if (str.equals("text-font")) {
                    b = Ascii.VT;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1083772767:
                if (str.equals("text-size")) {
                    b = Ascii.FF;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -888013006:
                if (str.equals("text-halo-color")) {
                    b = Ascii.CR;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -886443260:
                if (str.equals("icon-halo-blur")) {
                    b = Ascii.SO;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -869728875:
                if (str.equals("text-halo-width")) {
                    b = Ascii.SI;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -483024021:
                if (str.equals("text-opacity")) {
                    b = Ascii.DLE;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -465299984:
                if (str.equals("text-justify")) {
                    b = 17;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 317300605:
                if (str.equals("text-max-width")) {
                    b = Ascii.DC2;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 428355132:
                if (str.equals("text-letter-spacing")) {
                    b = 19;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 525511352:
                if (str.equals("text-halo-blur")) {
                    b = Ascii.DC4;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 748171971:
                if (str.equals("text-color")) {
                    b = Ascii.NAK;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 750756954:
                if (str.equals("text-field")) {
                    b = Ascii.SYN;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 1419415223:
                if (str.equals("icon-opacity")) {
                    b = Ascii.ETB;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 1660037973:
                if (str.equals("text-anchor")) {
                    b = Ascii.CAN;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 1859954313:
                if (str.equals("icon-anchor")) {
                    b = Ascii.EM;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 2053557555:
                if (str.equals("text-offset")) {
                    b = Ascii.SUB;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            default:
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
        }
        switch (b) {
            case 0:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textRotate(Expression.get(str3)));
                break;
            case 1:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconOffset(Expression.get("icon-offset")));
                break;
            case 2:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconRotate(Expression.get(str8)));
                break;
            case 3:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textRadialOffset(Expression.get(str7)));
                break;
            case 4:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconHaloColor(Expression.get(str6)));
                break;
            case 5:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconHaloWidth(Expression.get(str2)));
                break;
            case 6:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconColor(Expression.get(str4)));
                break;
            case 7:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconImage(Expression.get("icon-image")));
                break;
            case 8:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconSize(Expression.get("icon-size")));
                break;
            case 9:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.symbolSortKey(Expression.get("symbol-sort-key")));
                break;
            case 10:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textTransform(Expression.get("text-transform")));
                break;
            case 11:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textFont(Expression.get("text-font")));
                break;
            case 12:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textSize(Expression.get("text-size")));
                break;
            case 13:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textHaloColor(Expression.get("text-halo-color")));
                break;
            case 14:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconHaloBlur(Expression.get("icon-halo-blur")));
                break;
            case 15:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textHaloWidth(Expression.get("text-halo-width")));
                break;
            case 16:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textOpacity(Expression.get("text-opacity")));
                break;
            case 17:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textJustify(Expression.get("text-justify")));
                break;
            case 18:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textMaxWidth(Expression.get("text-max-width")));
                break;
            case 19:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textLetterSpacing(Expression.get("text-letter-spacing")));
                break;
            case 20:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textHaloBlur(Expression.get("text-halo-blur")));
                break;
            case 21:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textColor(Expression.get("text-color")));
                break;
            case 22:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textField(Expression.get("text-field")));
                break;
            case 23:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconOpacity(Expression.get("icon-opacity")));
                break;
            case 24:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textAnchor(Expression.get("text-anchor")));
                break;
            case 25:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconAnchor(Expression.get("icon-anchor")));
                break;
            case 26:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textOffset(Expression.get("text-offset")));
                break;
        }
    }

    @Override // com.mappls.sdk.plugin.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((SymbolLayer) this.layer).setFilter(expression);
    }

    public void setIconAllowOverlap(Boolean bool) {
        PropertyValue<Boolean> propertyValueIconAllowOverlap = PropertyFactory.iconAllowOverlap(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_ALLOW_OVERLAP, propertyValueIconAllowOverlap);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconAllowOverlap);
    }

    public void setIconIgnorePlacement(Boolean bool) {
        PropertyValue<Boolean> propertyValueIconIgnorePlacement = PropertyFactory.iconIgnorePlacement(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_IGNORE_PLACEMENT, propertyValueIconIgnorePlacement);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconIgnorePlacement);
    }

    public void setIconKeepUpright(Boolean bool) {
        PropertyValue<Boolean> propertyValueIconKeepUpright = PropertyFactory.iconKeepUpright(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_KEEP_UPRIGHT, propertyValueIconKeepUpright);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconKeepUpright);
    }

    public void setIconOptional(Boolean bool) {
        PropertyValue<Boolean> propertyValueIconOptional = PropertyFactory.iconOptional(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_OPTIONAL, propertyValueIconOptional);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconOptional);
    }

    public void setIconPadding(Float f) {
        PropertyValue<Float> propertyValueIconPadding = PropertyFactory.iconPadding(f);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_PADDING, propertyValueIconPadding);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconPadding);
    }

    public void setIconPitchAlignment(String str) {
        PropertyValue<String> propertyValueIconPitchAlignment = PropertyFactory.iconPitchAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_PITCH_ALIGNMENT, propertyValueIconPitchAlignment);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconPitchAlignment);
    }

    public void setIconRotationAlignment(String str) {
        PropertyValue<String> propertyValueIconRotationAlignment = PropertyFactory.iconRotationAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_ROTATION_ALIGNMENT, propertyValueIconRotationAlignment);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconRotationAlignment);
    }

    public void setIconTextFit(String str) {
        PropertyValue<String> propertyValueIconTextFit = PropertyFactory.iconTextFit(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TEXT_FIT, propertyValueIconTextFit);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconTextFit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setIconTextFitPadding(Float[] fArr) {
        PropertyValue<Float[]> propertyValueIconTextFitPadding = PropertyFactory.iconTextFitPadding(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TEXT_FIT_PADDING, propertyValueIconTextFitPadding);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconTextFitPadding);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setIconTranslate(Float[] fArr) {
        PropertyValue<Float[]> propertyValueIconTranslate = PropertyFactory.iconTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TRANSLATE, propertyValueIconTranslate);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconTranslate);
    }

    public void setIconTranslateAnchor(String str) {
        PropertyValue<String> propertyValueIconTranslateAnchor = PropertyFactory.iconTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TRANSLATE_ANCHOR, propertyValueIconTranslateAnchor);
        ((SymbolLayer) this.layer).setProperties(propertyValueIconTranslateAnchor);
    }

    public void setSymbolAvoidEdges(Boolean bool) {
        PropertyValue<Boolean> propertyValueSymbolAvoidEdges = PropertyFactory.symbolAvoidEdges(bool);
        this.constantPropertyUsageMap.put(PROPERTY_SYMBOL_AVOID_EDGES, propertyValueSymbolAvoidEdges);
        ((SymbolLayer) this.layer).setProperties(propertyValueSymbolAvoidEdges);
    }

    public void setSymbolPlacement(String str) {
        PropertyValue<String> propertyValueSymbolPlacement = PropertyFactory.symbolPlacement(str);
        this.constantPropertyUsageMap.put(PROPERTY_SYMBOL_PLACEMENT, propertyValueSymbolPlacement);
        ((SymbolLayer) this.layer).setProperties(propertyValueSymbolPlacement);
    }

    public void setSymbolSpacing(Float f) {
        PropertyValue<Float> propertyValueSymbolSpacing = PropertyFactory.symbolSpacing(f);
        this.constantPropertyUsageMap.put(PROPERTY_SYMBOL_SPACING, propertyValueSymbolSpacing);
        ((SymbolLayer) this.layer).setProperties(propertyValueSymbolSpacing);
    }

    public void setTextAllowOverlap(Boolean bool) {
        PropertyValue<Boolean> propertyValueTextAllowOverlap = PropertyFactory.textAllowOverlap(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_ALLOW_OVERLAP, propertyValueTextAllowOverlap);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextAllowOverlap);
    }

    public void setTextIgnorePlacement(Boolean bool) {
        PropertyValue<Boolean> propertyValueTextIgnorePlacement = PropertyFactory.textIgnorePlacement(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_IGNORE_PLACEMENT, propertyValueTextIgnorePlacement);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextIgnorePlacement);
    }

    public void setTextKeepUpright(Boolean bool) {
        PropertyValue<Boolean> propertyValueTextKeepUpright = PropertyFactory.textKeepUpright(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_KEEP_UPRIGHT, propertyValueTextKeepUpright);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextKeepUpright);
    }

    public void setTextLineHeight(Float f) {
        PropertyValue<Float> propertyValueTextLineHeight = PropertyFactory.textLineHeight(f);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_LINE_HEIGHT, propertyValueTextLineHeight);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextLineHeight);
    }

    public void setTextMaxAngle(Float f) {
        PropertyValue<Float> propertyValueTextMaxAngle = PropertyFactory.textMaxAngle(f);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_MAX_ANGLE, propertyValueTextMaxAngle);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextMaxAngle);
    }

    public void setTextOptional(Boolean bool) {
        PropertyValue<Boolean> propertyValueTextOptional = PropertyFactory.textOptional(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_OPTIONAL, propertyValueTextOptional);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextOptional);
    }

    public void setTextPadding(Float f) {
        PropertyValue<Float> propertyValueTextPadding = PropertyFactory.textPadding(f);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_PADDING, propertyValueTextPadding);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextPadding);
    }

    public void setTextPitchAlignment(String str) {
        PropertyValue<String> propertyValueTextPitchAlignment = PropertyFactory.textPitchAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_PITCH_ALIGNMENT, propertyValueTextPitchAlignment);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextPitchAlignment);
    }

    public void setTextRotationAlignment(String str) {
        PropertyValue<String> propertyValueTextRotationAlignment = PropertyFactory.textRotationAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_ROTATION_ALIGNMENT, propertyValueTextRotationAlignment);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextRotationAlignment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextTranslate(Float[] fArr) {
        PropertyValue<Float[]> propertyValueTextTranslate = PropertyFactory.textTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_TRANSLATE, propertyValueTextTranslate);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextTranslate);
    }

    public void setTextTranslateAnchor(String str) {
        PropertyValue<String> propertyValueTextTranslateAnchor = PropertyFactory.textTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_TRANSLATE_ANCHOR, propertyValueTextTranslateAnchor);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextTranslateAnchor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextVariableAnchor(String[] strArr) {
        PropertyValue<String[]> propertyValueTextVariableAnchor = PropertyFactory.textVariableAnchor(strArr);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_VARIABLE_ANCHOR, propertyValueTextVariableAnchor);
        ((SymbolLayer) this.layer).setProperties(propertyValueTextVariableAnchor);
    }
}
