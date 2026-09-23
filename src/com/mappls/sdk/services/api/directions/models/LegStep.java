package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LegStep extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract Builder bannerInstructions(List<BannerInstructions> list);

        public abstract LegStep build();

        public abstract Builder destinations(String str);

        public abstract Builder distance(double d);

        public abstract Builder drivingSide(String str);

        public abstract Builder duration(double d);

        public abstract Builder geometry(String str);

        public abstract Builder intersections(List<StepIntersection> list);

        public abstract Builder maneuver(StepManeuver stepManeuver);

        public abstract Builder mode(String str);

        public abstract Builder name(String str);

        public abstract Builder ref(String str);

        public abstract Builder rotaryName(String str);

        public abstract Builder weight(Double d);
    }

    @SerializedName("banner_instructions")
    public abstract List<BannerInstructions> bannerInstructions();

    public abstract String destinations();

    public abstract double distance();

    @SerializedName("driving_side")
    public abstract String drivingSide();

    public abstract double duration();

    public abstract String geometry();

    public abstract List<StepIntersection> intersections();

    public abstract StepManeuver maneuver();

    public abstract String mode();

    public abstract String name();

    public abstract String ref();

    @SerializedName("rotary_name")
    public abstract String rotaryName();

    public abstract Builder toBuilder();

    public abstract Double weight();

    public static Builder builder() {
        return new C$AutoValue_LegStep.Builder();
    }

    public static LegStep fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (LegStep) gsonBuilder.create().fromJson(str, LegStep.class);
    }

    public static TypeAdapter<LegStep> typeAdapter(Gson gson) {
        return new AutoValue_LegStep.GsonTypeAdapter(gson);
    }
}
