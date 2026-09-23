package com.mappls.sdk.services.api.directions.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StepManeuver extends DirectionsJsonObject {
    public static final String ARRIVE = "arrive";
    public static final String CONTINUE = "continue";
    public static final String DEPART = "depart";
    public static final String END_OF_ROAD = "end of road";
    public static final String EXIT_ROTARY = "exit rotary";
    public static final String EXIT_ROUNDABOUT = "exit roundabout";
    public static final String FORK = "fork";
    public static final String MERGE = "merge";
    public static final String NEW_NAME = "new name";
    public static final String NOTIFICATION = "notification";
    public static final String OFF_RAMP = "off ramp";
    public static final String ON_RAMP = "on ramp";
    public static final String ROTARY = "rotary";
    public static final String ROUNDABOUT = "roundabout";
    public static final String ROUNDABOUT_TURN = "roundabout turn";
    public static final String TURN = "turn";

    public static abstract class Builder {
        public abstract Builder bearingAfter(Double d);

        public abstract Builder bearingBefore(Double d);

        public abstract StepManeuver build();

        public abstract Builder degree(Double d);

        public abstract Builder exit(Integer num);

        public abstract Builder instruction(String str);

        public abstract Builder maneuverId(Integer num);

        public abstract Builder modifier(String str);

        public abstract Builder rawLocation(double[] dArr);

        public abstract Builder shortInstruction(String str);

        public abstract Builder type(String str);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StepManeuverType {
    }

    @SerializedName("bearing_after")
    public abstract Double bearingAfter();

    @SerializedName("bearing_before")
    public abstract Double bearingBefore();

    @SerializedName("degree")
    public abstract Double degree();

    public abstract Integer exit();

    public abstract String instruction();

    @SerializedName("maneuver_id")
    public abstract Integer maneuverId();

    public abstract String modifier();

    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    protected abstract double[] rawLocation();

    @SerializedName("short_instruction")
    public abstract String shortInstruction();

    public abstract Builder toBuilder();

    public abstract String type();

    public static StepManeuver fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (StepManeuver) gsonBuilder.create().fromJson(str, StepManeuver.class);
    }

    public static Builder builder() {
        return new C$AutoValue_StepManeuver.Builder();
    }

    public static TypeAdapter<StepManeuver> typeAdapter(Gson gson) {
        return new AutoValue_StepManeuver.GsonTypeAdapter(gson);
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }
}
