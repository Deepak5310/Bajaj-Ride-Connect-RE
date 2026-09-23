package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class h implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ f b;

    final class a implements Style.OnStyleLoaded {
        a() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            f.a(h.this.b, true, style);
            FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures((List<Feature>) h.this.a);
            GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSourceAs("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
            if (geoJsonSource != null) {
                geoJsonSource.setGeoJson(featureCollectionFromFeatures);
            }
        }
    }

    h(f fVar, ArrayList arrayList) {
        this.b = fVar;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.getStyle(new a());
    }
}
