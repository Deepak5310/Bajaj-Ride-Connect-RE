package com.mappls.sdk.services.api.directions.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DirectionsWaypoint extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract DirectionsWaypoint build();

        public abstract Builder distance(Double d);

        public abstract Builder hint(String str);

        public abstract Builder name(String str);

        public abstract Builder rawLocation(double[] dArr);
    }

    public abstract Double distance();

    public abstract String hint();

    public abstract String name();

    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    abstract double[] rawLocation();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_DirectionsWaypoint.Builder();
    }

    public static TypeAdapter<DirectionsWaypoint> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsWaypoint.GsonTypeAdapter(gson);
    }

    public static DirectionsWaypoint fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (DirectionsWaypoint) gsonBuilder.create().fromJson(str, DirectionsWaypoint.class);
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }
}
