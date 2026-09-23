package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.PointAsCoordinatesTypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import com.mappls.sdk.services.api.directions.WalkingOptions;
import com.mappls.sdk.services.api.directions.WalkingOptionsAdapterFactory;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RouteOptions extends DirectionsJsonObject {

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        public abstract Builder alternatives(Boolean bool);

        public abstract Builder annotations(String str);

        public abstract Builder approaches(String str);

        public abstract Builder aux(Double d);

        public abstract Builder bannerInstructions(Boolean bool);

        public abstract Builder baseUrl(String str);

        public abstract Builder batteryCapacity(Integer num);

        public abstract Builder bearings(String str);

        public abstract RouteOptions build();

        public abstract Builder continueStraight(Boolean bool);

        public abstract Builder coordinates(List<String> list);

        public abstract Builder dateTime(String str);

        public abstract Builder deviceID(String str);

        public abstract Builder efficiency(Double d);

        public abstract Builder exclude(String str);

        public abstract Builder geometries(String str);

        public abstract Builder instructions(Boolean bool);

        public abstract Builder isSort(Boolean bool);

        public abstract Builder language(String str);

        public abstract Builder lessVerbose(Boolean bool);

        public abstract Builder mass(Integer num);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        public abstract Builder radiuses(String str);

        public abstract Builder regen(Double d);

        public abstract Builder requestUuid(String str);

        public abstract Builder resource(String str);

        public abstract Builder roundaboutExits(Boolean bool);

        public abstract Builder routeRefresh(Boolean bool);

        public abstract Builder routeType(Integer num);

        public abstract Builder sessionId(String str);

        public abstract Builder skipWaypoints(Boolean bool);

        public abstract Builder soc(String str);

        public abstract Builder steps(Boolean bool);

        public abstract Builder user(String str);

        public abstract Builder walkingOptions(WalkingOptions walkingOptions);

        public abstract Builder waypointIndices(String str);

        public abstract Builder waypointNames(String str);

        public abstract Builder waypointTargets(String str);
    }

    @SerializedName(AccountsQueryParameters.ACCESS_TOKEN)
    public abstract String accessToken();

    public abstract Boolean alternatives();

    public abstract String annotations();

    public abstract String approaches();

    public abstract Double aux();

    @SerializedName("banner_instructions")
    public abstract Boolean bannerInstructions();

    public abstract String baseUrl();

    public abstract Integer batteryCapacity();

    public abstract String bearings();

    @SerializedName("continueStraight")
    public abstract Boolean continueStraight();

    public abstract List<String> coordinates();

    public abstract String dateTime();

    public abstract String deviceID();

    public abstract Double efficiency();

    public abstract String exclude();

    public abstract String geometries();

    @SerializedName("instructions")
    public abstract Boolean instructions();

    public abstract Boolean isSort();

    public abstract String language();

    @SerializedName("lessverbose")
    public abstract Boolean lessVerbose();

    public abstract Integer mass();

    public abstract String overview();

    public abstract String profile();

    public abstract String radiuses();

    public abstract Double regen();

    @SerializedName("uuid")
    public abstract String requestUuid();

    public abstract String resource();

    public abstract Boolean roundaboutExits();

    public abstract Boolean routeRefresh();

    public abstract Integer routeType();

    @SerializedName("sessionId")
    public abstract String sessionId();

    @SerializedName("skip_waypoints")
    public abstract Boolean skipWaypoints();

    public abstract String soc();

    public abstract Boolean steps();

    public abstract Builder toBuilder();

    public abstract String user();

    public abstract WalkingOptions walkingOptions();

    @SerializedName("waypoints")
    public abstract String waypointIndices();

    @SerializedName("waypoint_names")
    public abstract String waypointNames();

    @SerializedName("waypoint_targets")
    public abstract String waypointTargets();

    public static Builder builder() {
        return new C$AutoValue_RouteOptions.Builder();
    }

    public static RouteOptions fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        gsonBuilder.registerTypeAdapterFactory(WalkingOptionsAdapterFactory.create());
        return (RouteOptions) gsonBuilder.create().fromJson(str, RouteOptions.class);
    }

    public static TypeAdapter<RouteOptions> typeAdapter(Gson gson) {
        return new AutoValue_RouteOptions.GsonTypeAdapter(gson);
    }
}
