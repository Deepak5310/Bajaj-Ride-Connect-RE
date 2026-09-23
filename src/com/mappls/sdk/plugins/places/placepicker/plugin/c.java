package com.mappls.sdk.plugins.places.placepicker.plugin;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements MapView.OnDidFinishLoadingStyleListener {
    private final MapView a;
    private final MapplsMap b;
    private String c;
    private final PlacePickerOptions d;

    public c(MapView mapView, MapplsMap mapplsMap, PlacePickerOptions placePickerOptions) {
        this.a = mapView;
        this.b = mapplsMap;
        this.d = placePickerOptions;
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    static String a(c cVar) {
        cVar.getClass();
        StringBuilder sb = new StringBuilder("https://geoanalytics.mappls.com/placegeom?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&TRANSPARENT=true&SRS=EPSG:3857&WIDTH=");
        sb.append(cVar.a.getWidth());
        sb.append("&HEIGHT=");
        sb.append(cVar.a.getHeight());
        sb.append("&BBOX={bbox-epsg-3857}&datasetNme=building_footprint&FORMAT=image/png&env=linestrokecolor:");
        sb.append((cVar.d.buildingAppearanceStrokeColor().contains("#") ? cVar.d.buildingAppearanceStrokeColor().replace("#", "") : cVar.d.buildingAppearanceStrokeColor()).toUpperCase(Locale.ROOT));
        sb.append(";linestrokewidth:");
        sb.append(cVar.d.buildingAppearanceStrokeWidth());
        sb.append(";polygonfillopacity:");
        sb.append(cVar.d.buildingAppearanceFillOpacity());
        sb.append(";linestrokeopacity:");
        sb.append(cVar.d.buildingAppearanceStrokeOpacity());
        sb.append(";polygonfillcolor:");
        sb.append((cVar.d.buildingAppearanceFillColor().contains("#") ? cVar.d.buildingAppearanceFillColor().replace("#", "") : cVar.d.buildingAppearanceFillColor()).toUpperCase(Locale.ROOT));
        sb.append("&CQL_FILTER=eloc = '");
        sb.append(cVar.c);
        sb.append("'");
        return sb.toString();
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        if (this.c == null) {
            this.b.getStyle(new a());
        } else {
            this.b.getStyle(new a());
            this.b.getStyle(new b(this));
        }
    }

    public final void a() {
        this.c = null;
        this.b.getStyle(new a());
    }

    public final void a(String str) {
        this.c = str;
        this.b.getStyle(new a());
        this.b.getStyle(new b(this));
    }
}
