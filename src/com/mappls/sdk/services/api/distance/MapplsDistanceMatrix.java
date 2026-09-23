package com.mappls.sdk.services.api.distance;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTime;
import com.mappls.sdk.services.api.distance.models.DistanceResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsDistanceMatrix extends MapplsService<DistanceResponse, DistanceMatrixService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String coordinates();

    abstract String destinations();

    abstract String fallbackCoordinate();

    abstract Double fallbackSpeed();

    abstract String internalDateTime();

    abstract String profile();

    abstract String resource();

    abstract Integer routeType();

    abstract String sources();

    protected MapplsDistanceMatrix() {
        super(DistanceMatrixService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsDistanceMatrix.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).resource(DirectionsCriteria.RESOURCE_DISTANCE).profile("driving");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(DistanceMatrixAdapterFactory.create());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<DistanceResponse> initializeCall() {
        return getLoginService(true).getCall(resource(), profile(), coordinates(), MapplsAccountManager.getInstance().getRestAPIKey(), routeType(), sources(), destinations(), fallbackSpeed(), fallbackCoordinate(), internalDateTime());
    }

    void enqueue(Callback<DistanceResponse> callback) {
        enqueueCall(callback);
    }

    Response<DistanceResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        private List<String> coordinates = new ArrayList();
        private List<Integer> destinations;
        private List<Integer> sources;

        abstract MapplsDistanceMatrix autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder coordinates(String str);

        abstract Builder destinations(String str);

        public abstract Builder fallbackCoordinate(String str);

        public abstract Builder fallbackSpeed(Double d);

        abstract Builder internalDateTime(String str);

        public abstract Builder profile(String str);

        public abstract Builder resource(String str);

        public abstract Builder routeType(Integer num);

        abstract Builder sources(String str);

        private static String formatCoordinates(List<String> list) {
            return MapplsUtils.join(";", list.toArray());
        }

        public Builder coordinates(List<Point> list) {
            ArrayList arrayList = new ArrayList();
            for (Point point : list) {
                arrayList.add(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
            }
            this.coordinates.addAll(arrayList);
            return this;
        }

        public Builder sources(List<Integer> list) {
            this.sources = list;
            return this;
        }

        public Builder destinations(List<Integer> list) {
            this.destinations = list;
            return this;
        }

        public Builder coordinate(Point point) {
            this.coordinates.add(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
            return this;
        }

        public Builder coordinate(String str) {
            this.coordinates.add(str);
            return this;
        }

        public Builder coordinateList(List<String> list) {
            this.coordinates.addAll(list);
            return this;
        }

        public Builder dateTime(MapplsDirectionDateTime mapplsDirectionDateTime) {
            return internalDateTime(mapplsDirectionDateTime.type() + "," + mapplsDirectionDateTime.dateTimeInMillis());
        }

        public MapplsDistanceMatrix build() {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid rest API key.");
            }
            List<String> list = this.coordinates;
            if (list == null || list.size() < 2) {
                throw new ServicesException("At least two coordinates must be provided with your API request.");
            }
            if (this.coordinates.size() > 100) {
                throw new ServicesException("Maximum of 100 coordinates are allowed including origin and destination for this API.");
            }
            coordinates(formatCoordinates(this.coordinates));
            List<Integer> list2 = this.sources;
            if (list2 != null) {
                sources(MapplsUtils.join(";", list2.toArray()));
            }
            List<Integer> list3 = this.destinations;
            if (list3 != null) {
                destinations(MapplsUtils.join(";", list3.toArray()));
            }
            return autoBuild();
        }
    }
}
