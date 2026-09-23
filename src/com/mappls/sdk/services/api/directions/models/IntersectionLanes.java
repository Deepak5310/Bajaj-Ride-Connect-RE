package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IntersectionLanes extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract IntersectionLanes build();

        public abstract Builder indications(List<String> list);

        public abstract Builder valid(Boolean bool);
    }

    public abstract List<String> indications();

    public abstract Builder toBuilder();

    public abstract Boolean valid();

    public static Builder builder() {
        return new C$AutoValue_IntersectionLanes.Builder();
    }

    public static TypeAdapter<IntersectionLanes> typeAdapter(Gson gson) {
        return new AutoValue_IntersectionLanes.GsonTypeAdapter(gson);
    }

    public static IntersectionLanes fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (IntersectionLanes) gsonBuilder.create().fromJson(str, IntersectionLanes.class);
    }
}
