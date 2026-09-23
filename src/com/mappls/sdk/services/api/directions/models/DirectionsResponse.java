package com.mappls.sdk.services.api.directions.models;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.PointAsCoordinatesTypeAdapter;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DirectionsResponse extends DirectionsJsonObject {
    public abstract String code();

    public abstract String message();

    public abstract List<DirectionsRoute> routes();

    @SerializedName("sessionId")
    public abstract String sessionId();

    public abstract Builder toBuilder();

    @SerializedName(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)
    public abstract String uuid();

    public abstract List<DirectionsWaypoint> waypoints();

    public static Builder builder() {
        return new C$AutoValue_DirectionsResponse.Builder();
    }

    public static DirectionsResponse fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return (DirectionsResponse) gsonBuilder.create().fromJson(str, DirectionsResponse.class);
    }

    public static TypeAdapter<DirectionsResponse> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsResponse.GsonTypeAdapter(gson);
    }

    public static abstract class Builder {
        abstract DirectionsResponse autoBuild();

        public abstract Builder code(String str);

        public abstract Builder message(String str);

        public abstract Builder routes(List<DirectionsRoute> list);

        abstract List<DirectionsRoute> routes();

        public abstract Builder sessionId(String str);

        public abstract Builder uuid(String str);

        public abstract Builder waypoints(List<DirectionsWaypoint> list);

        public DirectionsResponse build() {
            return autoBuild();
        }
    }
}
