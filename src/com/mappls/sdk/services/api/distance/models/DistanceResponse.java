package com.mappls.sdk.services.api.distance.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DistanceResponse extends DistanceJsonObject {

    public static abstract class Builder {
        public abstract DistanceResponse build();

        public abstract Builder responseCode(long j);

        @SerializedName("results")
        public abstract Builder results(DistanceResults distanceResults);

        public abstract Builder version(String str);
    }

    public abstract long responseCode();

    @SerializedName("results")
    public abstract DistanceResults results();

    public abstract Builder toBuilder();

    public abstract String version();

    public static Builder builder() {
        return new C$AutoValue_DistanceResponse.Builder();
    }

    public static TypeAdapter<DistanceResponse> typeAdapter(Gson gson) {
        return new AutoValue_DistanceResponse.GsonTypeAdapter(gson);
    }
}
