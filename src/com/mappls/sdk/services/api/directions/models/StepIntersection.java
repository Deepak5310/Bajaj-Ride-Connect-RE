package com.mappls.sdk.services.api.directions.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StepIntersection extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract Builder bearings(List<Integer> list);

        public abstract StepIntersection build();

        public abstract Builder classes(List<String> list);

        public abstract Builder entry(List<Boolean> list);

        public abstract Builder in(Integer num);

        public abstract Builder lanes(List<IntersectionLanes> list);

        public abstract Builder out(Integer num);

        public abstract Builder rawLocation(double[] dArr);
    }

    public abstract List<Integer> bearings();

    public abstract List<String> classes();

    public abstract List<Boolean> entry();

    public abstract Integer in();

    public abstract List<IntersectionLanes> lanes();

    public abstract Integer out();

    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    protected abstract double[] rawLocation();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_StepIntersection.Builder();
    }

    public static TypeAdapter<StepIntersection> typeAdapter(Gson gson) {
        return new AutoValue_StepIntersection.GsonTypeAdapter(gson);
    }

    public static StepIntersection fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (StepIntersection) gsonBuilder.create().fromJson(str, StepIntersection.class);
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }
}
