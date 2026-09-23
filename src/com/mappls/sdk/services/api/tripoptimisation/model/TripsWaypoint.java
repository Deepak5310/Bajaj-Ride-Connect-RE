package com.mappls.sdk.services.api.tripoptimisation.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import com.mappls.sdk.services.api.directions.models.DirectionsJsonObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TripsWaypoint extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract TripsWaypoint build();

        public abstract Builder distance(Double d);

        public abstract Builder hint(String str);

        public abstract Builder name(String str);

        public abstract Builder rawLocation(double[] dArr);

        public abstract Builder tripsIndex(Integer num);

        public abstract Builder waypointIndex(Integer num);
    }

    public abstract Double distance();

    public abstract String hint();

    public abstract String name();

    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    abstract double[] rawLocation();

    public abstract Builder toBuilder();

    @SerializedName("trips_index")
    public abstract Integer tripsIndex();

    @SerializedName("waypoint_index")
    public abstract Integer waypointIndex();

    public static Builder builder() {
        return new C$AutoValue_TripsWaypoint.Builder();
    }

    public static TypeAdapter<TripsWaypoint> typeAdapter(Gson gson) {
        return new AutoValue_TripsWaypoint.GsonTypeAdapter(gson);
    }

    public static TripsWaypoint fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (TripsWaypoint) gsonBuilder.create().fromJson(str, TripsWaypoint.class);
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }
}
