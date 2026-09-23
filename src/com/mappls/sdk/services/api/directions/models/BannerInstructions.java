package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BannerInstructions extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract BannerInstructions build();

        public abstract Builder distanceAlongGeometry(double d);

        public abstract Builder primary(BannerText bannerText);

        public abstract Builder secondary(Integer num);

        public abstract Builder sub(BannerText bannerText);
    }

    @SerializedName("distance_along_geometry")
    public abstract double distanceAlongGeometry();

    public abstract BannerText primary();

    public abstract Integer secondary();

    public abstract BannerText sub();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_BannerInstructions.Builder();
    }

    public static BannerInstructions fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (BannerInstructions) gsonBuilder.create().fromJson(str, BannerInstructions.class);
    }

    public static TypeAdapter<BannerInstructions> typeAdapter(Gson gson) {
        return new AutoValue_BannerInstructions.GsonTypeAdapter(gson);
    }
}
