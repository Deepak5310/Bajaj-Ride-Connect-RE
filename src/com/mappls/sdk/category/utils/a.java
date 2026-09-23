package com.mappls.sdk.category.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.utils.ColorUtils;
import com.mappls.sdk.plugin.annotation.LineManager;
import com.mappls.sdk.plugin.annotation.LineOptions;
import com.mappls.sdk.plugin.annotation.OnSymbolClickListener;
import com.mappls.sdk.plugin.annotation.SymbolManager;
import com.mappls.sdk.plugin.annotation.SymbolOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    private final OnSymbolClickListener a;
    private final SearchCategoryUIOption b;
    private LineManager c;
    private SymbolManager d;
    private SymbolManager e;

    public a(MapView mapView, MapplsMap mapplsMap, Style style, OnSymbolClickListener onSymbolClickListener, SearchCategoryUIOption searchCategoryUIOption) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        Intrinsics.checkNotNullParameter(mapplsMap, "mapplsMap");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(onSymbolClickListener, "onSymbolClickListener");
        Intrinsics.checkNotNullParameter(searchCategoryUIOption, "searchCategoryUIOption");
        this.a = onSymbolClickListener;
        this.b = searchCategoryUIOption;
        this.c = new LineManager(mapView, mapplsMap, style);
        this.d = new SymbolManager(mapView, mapplsMap, style);
        SymbolManager symbolManager = new SymbolManager(mapView, mapplsMap, style);
        this.e = symbolManager;
        Boolean bool = Boolean.TRUE;
        symbolManager.setIconAllowOverlap(bool);
        this.e.setIconIgnorePlacement(bool);
        this.d.setIconAllowOverlap(Boolean.FALSE);
        this.d.setIconIgnorePlacement(bool);
        this.d.addClickListener(onSymbolClickListener);
    }

    public final void a() {
        this.c.clearAll();
        this.e.clearAll();
        this.d.removeClickListener(this.a);
        this.d.clearAll();
    }

    public final void a(LineString lineString) {
        Intrinsics.checkNotNullParameter(lineString, "lineString");
        this.c.clearAll();
        LineOptions lineOptionsLineWidth = new LineOptions().geometry(lineString).lineWidth(this.b.polylineWidth());
        Integer numPolylineColor = this.b.polylineColor();
        Intrinsics.checkNotNullExpressionValue(numPolylineColor, "searchCategoryUIOption.polylineColor()");
        this.c.create(lineOptionsLineWidth.lineColor(ColorUtils.colorToRgbaString(numPolylineColor.intValue())));
    }

    public final void a(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        this.e.clearAll();
        this.e.create(new SymbolOptions().position(latLng).icon("com.mappls.sdk.category.plugin.NEARBY_REF_LOCATION_MARKER_ICON"));
    }

    public final void a(String mapplsPin) {
        Intrinsics.checkNotNullParameter(mapplsPin, "mapplsPin");
        this.e.clearAll();
        this.e.create(new SymbolOptions().mapplsPin(mapplsPin).icon("com.mappls.sdk.category.plugin.NEARBY_REF_LOCATION_MARKER_ICON"));
    }

    public final void a(List<? extends PoiResult> nearbyAtlasResult, Map<String, String> iconMap) {
        Intrinsics.checkNotNullParameter(nearbyAtlasResult, "nearbyAtlasResult");
        Intrinsics.checkNotNullParameter(iconMap, "iconMap");
        this.d.clearAll();
        ArrayList arrayList = new ArrayList();
        for (PoiResult poiResult : nearbyAtlasResult) {
            SymbolOptions symbolOptions = new SymbolOptions();
            if (poiResult.getLatitude() == null || poiResult.getLongitude() == null) {
                symbolOptions.mapplsPin(poiResult.getMapplsPin());
            } else {
                Double longitude = poiResult.getLongitude();
                Intrinsics.checkNotNullExpressionValue(longitude, "it.longitude");
                double dDoubleValue = longitude.doubleValue();
                Double latitude = poiResult.getLatitude();
                Intrinsics.checkNotNullExpressionValue(latitude, "it.latitude");
                symbolOptions.geometry(Point.fromLngLat(dDoubleValue, latitude.doubleValue()));
            }
            if (poiResult.getKeywords().size() > 0 && iconMap.containsKey(poiResult.getKeywords().get(0))) {
                symbolOptions.icon(iconMap.get(poiResult.getKeywords().get(0)));
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("com.mappls.sdk.category.plugin.NEARBY_RESULT_DATA", new Gson().toJson(poiResult));
            symbolOptions.data(jsonObject);
            arrayList.add(symbolOptions);
        }
        this.d.create(arrayList);
    }

    public final void b() {
        this.c.onDestroy();
        this.e.onDestroy();
        this.d.onDestroy();
    }
}
