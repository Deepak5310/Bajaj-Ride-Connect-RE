package com.mappls.sdk.navigation.ui.map.plugins;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Style.OnStyleLoaded {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        this.a.a(true, style);
        ArrayList arrayList = new ArrayList();
        LatLng latLng = this.a.d;
        if (latLng != null) {
            Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(latLng.getLongitude(), this.a.d.getLatitude()));
            featureFromGeometry.addStringProperty("icon", "directions-marker-bearing-image");
            featureFromGeometry.addStringProperty("direction_type", "bearing");
            arrayList.add(featureFromGeometry);
        }
        Layer layer = style.getLayer("directions-marker-bearing-layer");
        if (layer != null) {
            layer.setProperties(PropertyFactory.iconRotate(Float.valueOf(this.a.c)));
        }
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(arrayList);
        GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSource("directions_bearing");
        if (geoJsonSource != null) {
            geoJsonSource.setGeoJson(featureCollectionFromFeatures);
        }
    }
}
