package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements Style.OnStyleLoaded {
    public final /* synthetic */ FeatureCollection a;
    public final /* synthetic */ FeatureCollection b;
    public final /* synthetic */ r c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ z f;

    public v(z zVar, FeatureCollection featureCollection, B b, FeatureCollection featureCollection2, r rVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f = zVar;
        this.a = featureCollection;
        this.b = featureCollection2;
        this.c = rVar;
        this.d = arrayList;
        this.e = arrayList2;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        GeoJsonOptions geoJsonOptionsWithMaxZoom = new GeoJsonOptions().withMaxZoom(16);
        this.f.y = this.a;
        if (style.getSource("mappls-navigation-waypoint-source") == null) {
            z zVar = this.f;
            zVar.s = new GeoJsonSource("mappls-navigation-waypoint-source", zVar.y, geoJsonOptionsWithMaxZoom);
            style.addSource(this.f.s);
        } else {
            this.f.s = (GeoJsonSource) style.getSource("mappls-navigation-waypoint-source");
            z zVar2 = this.f;
            GeoJsonSource geoJsonSource = zVar2.s;
            if (geoJsonSource != null) {
                geoJsonSource.setGeoJson(zVar2.y);
            }
        }
        GeoJsonOptions geoJsonOptionsWithMaxZoom2 = new GeoJsonOptions().withMaxZoom(16);
        this.f.x = this.b;
        if (style.getSource("mappls-navigation-route-source") == null) {
            z zVar3 = this.f;
            zVar3.t = new GeoJsonSource("mappls-navigation-route-source", zVar3.x, geoJsonOptionsWithMaxZoom2);
            style.addSource(this.f.t);
        } else {
            this.f.t = (GeoJsonSource) style.getSource("mappls-navigation-route-source");
            z zVar4 = this.f;
            GeoJsonSource geoJsonSource2 = zVar4.t;
            if (geoJsonSource2 != null) {
                geoJsonSource2.setGeoJson(zVar4.x);
            }
        }
        z zVar5 = this.f;
        zVar5.a(style, this.c, zVar5.E, zVar5.F, zVar5.G, zVar5.H, zVar5.I);
        this.f.a(true, style);
        this.f.a(0);
        this.f.b(true, style);
        if (this.d.isEmpty() || !this.e.isEmpty()) {
            return;
        }
        z zVar6 = this.f;
        C0224d c0224d = (C0224d) zVar6.z.getAndSet(new C0224d(this.d, 0, zVar6.K, zVar6.B));
        if (c0224d != null) {
            c0224d.e.set(true);
        }
        C0224d c0224d2 = (C0224d) zVar6.z.get();
        if (c0224d2 != null) {
            c0224d2.start();
        }
    }
}
