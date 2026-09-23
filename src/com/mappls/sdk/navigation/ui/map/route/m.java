package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements Style.OnStyleLoaded {
    public final /* synthetic */ String a;
    public final /* synthetic */ q b;

    public m(q qVar, String str) {
        this.b = qVar;
        this.a = str;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        GeoJsonSource geoJsonSource;
        if (style.getSource("mappls-navigation-route-event-source-id") == null) {
            this.b.a(this.a, style);
            return;
        }
        this.b.c = (GeoJsonSource) style.getSource("mappls-navigation-route-event-source-id");
        q qVar = this.b;
        FeatureCollection featureCollection = qVar.e;
        if (featureCollection == null || (geoJsonSource = qVar.c) == null) {
            return;
        }
        geoJsonSource.setGeoJson(featureCollection);
    }
}
