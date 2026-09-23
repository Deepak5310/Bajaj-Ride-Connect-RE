package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class i implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ List b;
    final /* synthetic */ f c;

    final class a implements Style.OnStyleLoaded {
        a() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            style.addImagesAsync(i.this.a);
            List list = i.this.b;
            if (list != null) {
                FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures((List<Feature>) list);
                GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSourceAs("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
                if (geoJsonSource != null) {
                    geoJsonSource.setGeoJson(featureCollectionFromFeatures);
                }
                f.a(i.this.c, true, style);
            }
        }
    }

    i(f fVar, HashMap map, ArrayList arrayList) {
        this.c = fVar;
        this.a = map;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.c.getStyle(new a());
    }
}
