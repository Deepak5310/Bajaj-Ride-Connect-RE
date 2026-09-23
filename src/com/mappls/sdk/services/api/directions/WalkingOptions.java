package com.mappls.sdk.services.api.directions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WalkingOptions {

    public static abstract class Builder {
        public abstract Builder alleyBias(Double d);

        public abstract WalkingOptions build();

        public abstract Builder walkingSpeed(Double d);

        public abstract Builder walkwayBias(Double d);
    }

    @SerializedName("alley_bias")
    public abstract Double alleyBias();

    @SerializedName("walking_speed")
    public abstract Double walkingSpeed();

    @SerializedName("walkway_bias")
    public abstract Double walkwayBias();

    public static WalkingOptions fromJson(String str) {
        return (WalkingOptions) new GsonBuilder().registerTypeAdapterFactory(WalkingOptionsAdapterFactory.create()).create().fromJson(str, WalkingOptions.class);
    }

    public static TypeAdapter<WalkingOptions> typeAdapter(Gson gson) {
        return new AutoValue_WalkingOptions.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$AutoValue_WalkingOptions.Builder();
    }

    public final String toJson() {
        return new GsonBuilder().registerTypeAdapterFactory(WalkingOptionsAdapterFactory.create()).create().toJson(this, WalkingOptions.class);
    }
}
