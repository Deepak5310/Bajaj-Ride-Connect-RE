package com.mappls.sdk.services.api.tripoptimisation.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.PointAsCoordinatesTypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import com.mappls.sdk.services.api.directions.models.DirectionsJsonObject;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TripOptimisationResponse extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract TripOptimisationResponse build();

        public abstract Builder code(String str);

        public abstract Builder trips(List<DirectionsRoute> list);

        public abstract Builder waypoints(List<TripsWaypoint> list);
    }

    public abstract String code();

    public abstract Builder toBuilder();

    public abstract List<DirectionsRoute> trips();

    public abstract List<TripsWaypoint> waypoints();

    public static Builder builder() {
        return new C$AutoValue_TripOptimisationResponse.Builder();
    }

    public static TripOptimisationResponse fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return (TripOptimisationResponse) gsonBuilder.create().fromJson(str, TripOptimisationResponse.class);
    }

    public static TypeAdapter<TripOptimisationResponse> typeAdapter(Gson gson) {
        return new AutoValue_TripOptimisationResponse.GsonTypeAdapter(gson);
    }
}
