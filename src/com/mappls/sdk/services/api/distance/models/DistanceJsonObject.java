package com.mappls.sdk.services.api.distance.models;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.PointAsCoordinatesTypeAdapter;
import com.mappls.sdk.services.api.distance.DistanceMatrixAdapterFactory;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class DistanceJsonObject implements Serializable {
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DistanceMatrixAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return gsonBuilder.create().toJson(this);
    }
}
