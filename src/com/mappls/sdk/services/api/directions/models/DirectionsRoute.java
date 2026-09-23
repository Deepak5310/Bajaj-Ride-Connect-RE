package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DirectionsRoute extends DirectionsJsonObject {
    private List<Point> points = null;

    public static abstract class Builder {
        public abstract Builder alternatives(List<DirectionsRoute> list);

        public abstract Builder betterRouteId(String str);

        public abstract DirectionsRoute build();

        public abstract Builder distance(Double d);

        public abstract Builder dsocd(Double d);

        public abstract Builder duration(Double d);

        public abstract Builder geometry(String str);

        public abstract Builder legs(List<RouteLeg> list);

        public abstract Builder rdrd(Double d);

        public abstract Builder rdrdm(Double d);

        public abstract Builder routeClasses(RouteClasses routeClasses);

        public abstract Builder routeId(String str);

        public abstract Builder routeIndex(Integer num);

        public abstract Builder routeOptions(RouteOptions routeOptions);

        public abstract Builder socdi(Double d);

        public abstract Builder socdm(Double d);

        public abstract Builder summary(String str);

        public abstract Builder tc(Double d);

        public abstract Builder weight(Double d);

        public abstract Builder weightName(String str);
    }

    public abstract List<DirectionsRoute> alternatives();

    public abstract String betterRouteId();

    public abstract Double distance();

    public abstract Double dsocd();

    public abstract Double duration();

    public abstract String geometry();

    public abstract List<RouteLeg> legs();

    public abstract Double rdrd();

    public abstract Double rdrdm();

    @SerializedName("contains_classes")
    public abstract RouteClasses routeClasses();

    public abstract String routeId();

    public abstract Integer routeIndex();

    public abstract RouteOptions routeOptions();

    public abstract Double socdi();

    public abstract Double socdm();

    public abstract String summary();

    public abstract Double tc();

    public abstract Builder toBuilder();

    public abstract Double weight();

    @SerializedName("weight_name")
    public abstract String weightName();

    public static Builder builder() {
        return new C$AutoValue_DirectionsRoute.Builder();
    }

    public static DirectionsRoute fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (DirectionsRoute) gsonBuilder.create().fromJson(str, DirectionsRoute.class);
    }

    public static TypeAdapter<DirectionsRoute> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsRoute.GsonTypeAdapter(gson);
    }

    public List<Point> getCoordinates() {
        if (this.points == null) {
            this.points = PolylineUtils.decode(geometry(), 6);
        }
        return this.points;
    }
}
