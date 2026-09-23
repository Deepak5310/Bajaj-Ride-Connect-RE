package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LegAnnotation extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract Builder baseDuration(List<Double> list);

        public abstract LegAnnotation build();

        public abstract Builder congestion(List<String> list);

        public abstract Builder distance(List<Double> list);

        public abstract Builder duration(List<Double> list);

        public abstract Builder maxspeed(List<MaxSpeed> list);

        public abstract Builder nodes(List<Long> list);

        public abstract Builder speed(List<Double> list);

        public abstract Builder speedLimit(List<Double> list);

        public abstract Builder tollRoad(List<String> list);
    }

    public abstract List<Double> baseDuration();

    public abstract List<String> congestion();

    public abstract List<Double> distance();

    public abstract List<Double> duration();

    public abstract List<MaxSpeed> maxspeed();

    public abstract List<Long> nodes();

    public abstract List<Double> speed();

    @SerializedName(DirectionsCriteria.ANNOTATION_SPEED_LIMIT)
    public abstract List<Double> speedLimit();

    public abstract Builder toBuilder();

    @SerializedName(DirectionsCriteria.ANNOTATION_TOLL_ROAD)
    public abstract List<String> tollRoad();

    public static Builder builder() {
        return new C$AutoValue_LegAnnotation.Builder();
    }

    public static TypeAdapter<LegAnnotation> typeAdapter(Gson gson) {
        return new AutoValue_LegAnnotation.GsonTypeAdapter(gson);
    }

    public static LegAnnotation fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (LegAnnotation) gsonBuilder.create().fromJson(str, LegAnnotation.class);
    }
}
