package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RouteLeg extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract Builder annotation(LegAnnotation legAnnotation);

        public abstract RouteLeg build();

        public abstract Builder distance(Double d);

        public abstract Builder dsocd(Double d);

        public abstract Builder duration(Double d);

        public abstract Builder rdrd(Double d);

        public abstract Builder rdrdm(Double d);

        public abstract Builder socdi(Double d);

        public abstract Builder socdm(Double d);

        public abstract Builder steps(List<LegStep> list);

        public abstract Builder summary(String str);

        public abstract Builder tc(Double d);

        public abstract Builder weight(Double d);
    }

    public abstract LegAnnotation annotation();

    public abstract Double distance();

    public abstract Double dsocd();

    public abstract Double duration();

    public abstract Double rdrd();

    public abstract Double rdrdm();

    public abstract Double socdi();

    public abstract Double socdm();

    public abstract List<LegStep> steps();

    public abstract String summary();

    public abstract Double tc();

    public abstract Builder toBuilder();

    public abstract Double weight();

    public static Builder builder() {
        return new C$AutoValue_RouteLeg.Builder();
    }

    public static TypeAdapter<RouteLeg> typeAdapter(Gson gson) {
        return new AutoValue_RouteLeg.GsonTypeAdapter(gson);
    }

    public static RouteLeg fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (RouteLeg) gsonBuilder.create().fromJson(str, RouteLeg.class);
    }
}
