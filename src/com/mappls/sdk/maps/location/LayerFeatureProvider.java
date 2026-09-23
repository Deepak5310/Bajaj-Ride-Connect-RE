package com.mappls.sdk.maps.location;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.Point;

/* JADX INFO: loaded from: classes4.dex */
class LayerFeatureProvider {
    LayerFeatureProvider() {
    }

    Feature generateLocationFeature(Feature feature, boolean z) {
        if (feature != null) {
            return feature;
        }
        Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(0.0d, 0.0d));
        featureFromGeometry.addNumberProperty("mappls-property-gps-bearing", Float.valueOf(0.0f));
        featureFromGeometry.addNumberProperty("mappls-property-compass-bearing", Float.valueOf(0.0f));
        featureFromGeometry.addBooleanProperty("mappls-property-location-stale", Boolean.valueOf(z));
        return featureFromGeometry;
    }
}
