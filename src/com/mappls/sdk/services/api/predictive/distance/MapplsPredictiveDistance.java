package com.mappls.sdk.services.api.predictive.distance;

import com.google.android.gms.common.Scopes;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.predictive.MapplsDirectionSpeedType;
import com.mappls.sdk.services.api.predictive.distance.models.PredictiveDistanceResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsPredictiveDistance extends MapplsService<PredictiveDistanceResponse, DistanceService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String internalDateTime();

    abstract List<String> internalDestination();

    abstract List<String> internalSources();

    abstract String internalSpeedType();

    abstract String profile();

    protected MapplsPredictiveDistance() {
        super(DistanceService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsPredictiveDistance.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).profile("driving");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<PredictiveDistanceResponse> initializeCall() {
        return getLoginService(true).getCall(toMap());
    }

    private static String formatCoordinates(List<String> list) {
        return MapplsUtils.join(";", list.toArray());
    }

    private Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("source", formatCoordinates(internalSources()));
        map.put("target", formatCoordinates(internalDestination()));
        map.put(Scopes.PROFILE, profile());
        if (internalSpeedType() != null) {
            map.put("speedTypes", internalSpeedType());
        }
        if (internalDateTime() != null) {
            map.put("date_time", internalDateTime());
        }
        return map;
    }

    void enqueue(Callback<PredictiveDistanceResponse> callback) {
        enqueueCall(callback);
    }

    Response<PredictiveDistanceResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        private final List<String> sources = new ArrayList();
        private final List<String> target = new ArrayList();

        abstract MapplsPredictiveDistance autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder internalDateTime(String str);

        abstract Builder internalDestination(List<String> list);

        abstract Builder internalSources(List<String> list);

        abstract Builder internalSpeedType(String str);

        public abstract Builder profile(String str);

        public Builder sources(List<Point> list) {
            ArrayList arrayList = new ArrayList();
            for (Point point : list) {
                arrayList.add(MapplsUtils.formatCoordinate(point.longitude()) + "," + MapplsUtils.formatCoordinate(point.latitude()));
            }
            this.sources.addAll(arrayList);
            return this;
        }

        public Builder destinations(List<Point> list) {
            ArrayList arrayList = new ArrayList();
            for (Point point : list) {
                arrayList.add(MapplsUtils.formatCoordinate(point.longitude()) + "," + MapplsUtils.formatCoordinate(point.latitude()));
            }
            this.target.addAll(arrayList);
            return this;
        }

        public Builder sourceList(List<String> list) {
            this.sources.addAll(list);
            return this;
        }

        public Builder destinationList(List<String> list) {
            this.target.addAll(list);
            return this;
        }

        public Builder addSource(Point point) {
            this.sources.add(MapplsUtils.formatCoordinate(point.longitude()) + "," + MapplsUtils.formatCoordinate(point.latitude()));
            return this;
        }

        public Builder addDestination(Point point) {
            this.target.add(MapplsUtils.formatCoordinate(point.longitude()) + "," + MapplsUtils.formatCoordinate(point.latitude()));
            return this;
        }

        public Builder addSource(String str) {
            this.sources.add(str);
            return this;
        }

        public Builder addDestination(String str) {
            this.target.add(str);
            return this;
        }

        public Builder speedType(MapplsDirectionSpeedType mapplsDirectionSpeedType) {
            return internalSpeedType(mapplsDirectionSpeedType.speedType()).internalDateTime(mapplsDirectionSpeedType.speedDateTime());
        }

        public MapplsPredictiveDistance build() {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid rest API key.");
            }
            if (this.sources.size() < 1) {
                throw new ServicesException("At least one coordinates must be provided for source with your API request.");
            }
            if (this.target.size() < 1) {
                throw new ServicesException("At least one coordinates must be provided for destination with your API request.");
            }
            internalSources(this.sources);
            internalDestination(this.target);
            return autoBuild();
        }
    }
}
