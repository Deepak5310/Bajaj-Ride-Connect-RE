package com.mappls.sdk.maps.style.sources;

import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.geometry.LatLngBounds;

/* JADX INFO: loaded from: classes4.dex */
public interface GeometryTileProvider {
    FeatureCollection getFeaturesForBounds(LatLngBounds latLngBounds, int i);
}
