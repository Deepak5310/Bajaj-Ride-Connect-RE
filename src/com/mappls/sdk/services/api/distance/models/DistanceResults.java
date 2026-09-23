package com.mappls.sdk.services.api.distance.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DistanceResults extends DistanceJsonObject {

    public static abstract class Builder {
        public abstract DistanceResults build();

        public abstract Builder code(String str);

        public abstract Builder destinations(List<DirectionsWaypoint> list);

        @SerializedName("distances")
        public abstract Builder distances(List<Double[]> list);

        @SerializedName("durations")
        public abstract Builder durations(List<Double[]> list);

        @SerializedName("fallback_speed_cells")
        public abstract Builder fallbackSpeedCells(List<Double[]> list);

        public abstract Builder sources(List<DirectionsWaypoint> list);
    }

    public abstract String code();

    public abstract List<DirectionsWaypoint> destinations();

    @SerializedName("distances")
    public abstract List<Double[]> distances();

    @SerializedName("durations")
    public abstract List<Double[]> durations();

    @SerializedName("fallback_speed_cells")
    public abstract List<Double[]> fallbackSpeedCells();

    public abstract List<DirectionsWaypoint> sources();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_DistanceResults.Builder();
    }

    public static TypeAdapter<DistanceResults> typeAdapter(Gson gson) {
        return new AutoValue_DistanceResults.GsonTypeAdapter(gson);
    }
}
