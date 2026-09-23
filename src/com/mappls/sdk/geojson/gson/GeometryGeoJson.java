package com.mappls.sdk.geojson.gson;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.GeometryAdapterFactory;

/* JADX INFO: loaded from: classes6.dex */
public class GeometryGeoJson {
    public static Geometry fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(GeometryAdapterFactory.create());
        return (Geometry) gsonBuilder.create().fromJson(str, Geometry.class);
    }
}
