package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RouteClasses extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract RouteClasses build();

        public abstract Builder ferry(Integer num);

        public abstract Builder motorway(Integer num);

        public abstract Builder restricted(Integer num);

        public abstract Builder toll(Integer num);

        public abstract Builder tunnel(Integer num);
    }

    public abstract Integer ferry();

    public abstract Integer motorway();

    public abstract Integer restricted();

    public abstract Integer toll();

    public abstract Integer tunnel();

    public static Builder builder() {
        return new C$AutoValue_RouteClasses.Builder();
    }

    public static TypeAdapter<RouteClasses> typeAdapter(Gson gson) {
        return new AutoValue_RouteClasses.GsonTypeAdapter(gson);
    }

    public static RouteClasses fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (RouteClasses) gsonBuilder.create().fromJson(str, RouteClasses.class);
    }
}
