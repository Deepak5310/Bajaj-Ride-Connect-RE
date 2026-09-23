package com.mappls.sdk.plugins.places.placepicker.plugin;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.services.api.EntryCoordinate;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
final class e implements Style.OnStyleLoaded {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        if (style.getSource("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID") == null) {
            this.a.b();
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.d != null) {
            for (EntryCoordinate entryCoordinate : this.a.d) {
                arrayList.add(Feature.fromGeometry(Point.fromLngLat(entryCoordinate.getEntryLongitude(), entryCoordinate.getEntryLatitude())));
            }
        }
        ((GeoJsonSource) style.getSourceAs("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID")).setGeoJson(FeatureCollection.fromFeatures(arrayList));
    }
}
