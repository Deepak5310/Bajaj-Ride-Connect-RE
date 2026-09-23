package com.mappls.sdk.services.api.tripoptimisation;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.GsonBuilder;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.directions.DirectionsAdapterFactory;
import com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsTripOptimisation extends MapplsService<TripOptimisationResponse, TripOptimisationService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    public abstract String baseUrl();

    abstract Boolean continueStraight();

    abstract String destination();

    abstract String destinationType();

    abstract String geometries();

    abstract Boolean lessVerbose();

    abstract String origin();

    abstract String overview();

    abstract String profile();

    abstract String resource();

    abstract Boolean roundTrip();

    abstract String sourceType();

    abstract Boolean steps();

    abstract List<String> waypoints();

    public MapplsTripOptimisation() {
        super(TripOptimisationService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsTripOptimisation.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).profile("driving").resource(TripOptimisationCriteria.RESOURCE_TRIP_OPTIMISATION).overview("full").geometries("polyline6");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<TripOptimisationResponse> initializeCall() {
        return getLoginService(true).getCall(profile(), resource(), getCoordinates(), MapplsAccountManager.getInstance().getRestAPIKey(), createRequest());
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put("overview", overview());
        map.put("geometries", geometries());
        if (steps() != null) {
            map.put("steps", steps());
        }
        if (sourceType() != null) {
            map.put("source", sourceType());
        }
        if (destinationType() != null) {
            map.put(FirebaseAnalytics.Param.DESTINATION, destinationType());
        }
        if (roundTrip() != null) {
            map.put("roundtrip", roundTrip());
        }
        if (lessVerbose() != null) {
            map.put("lessVerbose", lessVerbose());
        }
        if (continueStraight() != null) {
            map.put("continue_straight", continueStraight());
        }
        return map;
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return super.getGsonBuilder().registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    void enqueue(Callback<TripOptimisationResponse> callback) {
        enqueueCall(callback);
    }

    Response<TripOptimisationResponse> execute() throws IOException {
        return executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    private String getCoordinates() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(origin());
        arrayList.addAll(waypoints());
        arrayList.add(destination());
        return MapplsUtils.join(";", arrayList.toArray());
    }

    public static abstract class Builder {
        private List<String> coordinates = new ArrayList();

        abstract MapplsTripOptimisation autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder continueStraight(Boolean bool);

        public abstract Builder destination(String str);

        public abstract Builder destinationType(String str);

        public abstract Builder geometries(String str);

        public abstract Builder lessVerbose(Boolean bool);

        public abstract Builder origin(String str);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        public abstract Builder resource(String str);

        public abstract Builder roundTrip(Boolean bool);

        public abstract Builder sourceType(String str);

        public abstract Builder steps(Boolean bool);

        abstract Builder waypoints(List<String> list);

        public Builder origin(Point point) {
            return origin(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
        }

        public Builder destination(Point point) {
            return destination(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
        }

        public Builder addWayPoint(Point point) {
            return addWayPoint(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
        }

        public Builder addWayPoint(String str) {
            this.coordinates.add(str);
            return this;
        }

        public MapplsTripOptimisation build() {
            if (MapplsUtils.isEmpty(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid Rest API Key.");
            }
            waypoints(this.coordinates);
            return autoBuild();
        }
    }
}
