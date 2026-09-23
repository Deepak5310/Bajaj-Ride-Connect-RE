package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BannerComponents extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract BannerComponents build();

        public abstract Builder text(String str);

        public abstract Builder type(String str);
    }

    public abstract String text();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_BannerComponents.Builder();
    }

    public static BannerComponents fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (BannerComponents) gsonBuilder.create().fromJson(str, BannerComponents.class);
    }

    public static TypeAdapter<BannerComponents> typeAdapter(Gson gson) {
        return new AutoValue_BannerComponents.GsonTypeAdapter(gson);
    }
}
