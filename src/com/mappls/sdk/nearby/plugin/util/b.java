package com.mappls.sdk.nearby.plugin.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.Polygon;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.utils.ColorUtils;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;
import com.mappls.sdk.plugin.annotation.FillManager;
import com.mappls.sdk.plugin.annotation.FillOptions;
import com.mappls.sdk.plugin.annotation.OnSymbolClickListener;
import com.mappls.sdk.plugin.annotation.SymbolManager;
import com.mappls.sdk.plugin.annotation.SymbolOptions;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfTransformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final OnSymbolClickListener a;
    private final NearbyUIOption b;
    private FillManager c;
    private SymbolManager d;
    private SymbolManager e;

    public b(MapView mapView, MapplsMap mapplsMap, Style style, OnSymbolClickListener onSymbolClickListener, NearbyUIOption nearbyUIOption) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        Intrinsics.checkNotNullParameter(mapplsMap, "mapplsMap");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(onSymbolClickListener, "onSymbolClickListener");
        Intrinsics.checkNotNullParameter(nearbyUIOption, "nearbyUIOption");
        this.a = onSymbolClickListener;
        this.b = nearbyUIOption;
        this.c = new FillManager(mapView, mapplsMap, style);
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
        System.out.println((Object) "clear");
        this.c.clearAll();
        this.e.clearAll();
        this.d.removeClickListener(this.a);
        this.d.clearAll();
    }

    public final void a(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        System.out.println((Object) "Location Marker");
        this.e.clearAll();
        this.e.create(new SymbolOptions().position(latLng).icon("com.mappls.sdk.nearby.plugin.NEARBY_REF_LOCATION_MARKER_ICON"));
    }

    public final void a(LatLng latLng, double d) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        System.out.println((Object) "addSelectedAreaPolygon");
        this.c.clearAll();
        Polygon polygonCircle = TurfTransformation.circle(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()), d, TurfConstants.UNIT_METRES);
        Intrinsics.checkNotNullExpressionValue(polygonCircle, "circle(Point.fromLngLat(…urfConstants.UNIT_METRES)");
        FillOptions fillOptionsGeometry = new FillOptions().geometry(polygonCircle);
        Integer numRefLocationCircleColor = this.b.refLocationCircleColor();
        Intrinsics.checkNotNullExpressionValue(numRefLocationCircleColor, "nearbyUIOption.refLocationCircleColor()");
        this.c.create(fillOptionsGeometry.fillColor(ColorUtils.colorToRgbaString(numRefLocationCircleColor.intValue())).fillOpacity(this.b.refLocationCircleAlpha()));
    }

    public final void a(String mapplsPin) {
        Intrinsics.checkNotNullParameter(mapplsPin, "mapplsPin");
        System.out.println((Object) "Location Marker");
        this.e.clearAll();
        this.e.create(new SymbolOptions().mapplsPin(mapplsPin).icon("com.mappls.sdk.nearby.plugin.NEARBY_REF_LOCATION_MARKER_ICON"));
    }

    public final void a(ArrayList nearbyAtlasResult, Map iconMap) {
        Double d;
        Intrinsics.checkNotNullParameter(nearbyAtlasResult, "nearbyAtlasResult");
        Intrinsics.checkNotNullParameter(iconMap, "iconMap");
        System.out.println((Object) "addNearbyMarkers");
        this.d.clearAll();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = nearbyAtlasResult.iterator();
        while (it2.hasNext()) {
            NearbyAtlasResult nearbyAtlasResult2 = (NearbyAtlasResult) it2.next();
            SymbolOptions symbolOptions = new SymbolOptions();
            if (nearbyAtlasResult2.latitude == null || (d = nearbyAtlasResult2.longitude) == null) {
                symbolOptions.mapplsPin(nearbyAtlasResult2.mapplsPin);
            } else {
                Intrinsics.checkNotNullExpressionValue(d, "it.longitude");
                double dDoubleValue = d.doubleValue();
                Double d2 = nearbyAtlasResult2.latitude;
                Intrinsics.checkNotNullExpressionValue(d2, "it.latitude");
                symbolOptions.geometry(Point.fromLngLat(dDoubleValue, d2.doubleValue()));
            }
            if (nearbyAtlasResult2.keywords.size() > 0 && iconMap.containsKey(nearbyAtlasResult2.keywords.get(0))) {
                symbolOptions.icon((String) iconMap.get(nearbyAtlasResult2.keywords.get(0)));
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("com.mappls.sdk.nearby.plugin.NEARBY_RESULT_DATA", new Gson().toJson(nearbyAtlasResult2));
            symbolOptions.data(jsonObject);
            arrayList.add(symbolOptions);
        }
        this.d.create(arrayList);
    }
}
