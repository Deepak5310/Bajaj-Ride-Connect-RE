package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;

/* JADX INFO: loaded from: classes4.dex */
public final class w implements Style.OnStyleLoaded {
    public final /* synthetic */ z a;

    public w(z zVar) {
        this.a = zVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        if (style.getSource("mappls-navigation-route-source") == null) {
            this.a.a(style);
            z zVar = this.a;
            zVar.a(style, zVar.C, zVar.E, zVar.F, zVar.G, zVar.H, zVar.I);
            return;
        }
        if (style.getSource("mappls-navigation-waypoint-source") == null) {
            this.a.a(style);
            z zVar2 = this.a;
            zVar2.a(style, zVar2.C, zVar2.E, zVar2.F, zVar2.G, zVar2.H, zVar2.I);
            return;
        }
        this.a.s = (GeoJsonSource) style.getSource("mappls-navigation-waypoint-source");
        z zVar3 = this.a;
        GeoJsonSource geoJsonSource = zVar3.s;
        if (geoJsonSource != null) {
            geoJsonSource.setGeoJson(zVar3.y);
        }
        this.a.t = (GeoJsonSource) style.getSource("mappls-navigation-route-source");
        z zVar4 = this.a;
        GeoJsonSource geoJsonSource2 = zVar4.t;
        if (geoJsonSource2 != null) {
            geoJsonSource2.setGeoJson(zVar4.x);
        }
    }
}
