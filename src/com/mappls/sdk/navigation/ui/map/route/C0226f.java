package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C0226f implements Style.OnStyleLoaded {
    public final /* synthetic */ String a;
    public final /* synthetic */ C0228h b;

    public C0226f(C0228h c0228h, String str) {
        this.b = c0228h;
        this.a = str;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        if (style.getSource("mappls-navigation-arrow-head-source") == null) {
            this.b.a(this.a, style);
            return;
        }
        if (style.getSource("mappls-navigation-arrow-shaft-source") == null) {
            this.b.a(this.a, style);
            return;
        }
        this.b.g = (GeoJsonSource) style.getSource("mappls-navigation-arrow-head-source");
        this.b.f = (GeoJsonSource) style.getSource("mappls-navigation-arrow-shaft-source");
        C0228h c0228h = this.b;
        if (c0228h.g == null || c0228h.f == null) {
            return;
        }
        ArrayList arrayList = c0228h.h;
        if (arrayList != null) {
            c0228h.f.setGeoJson(Feature.fromGeometry(LineString.fromLngLats(arrayList)));
        }
        C0228h c0228h2 = this.b;
        c0228h2.a(c0228h2.h);
    }
}
