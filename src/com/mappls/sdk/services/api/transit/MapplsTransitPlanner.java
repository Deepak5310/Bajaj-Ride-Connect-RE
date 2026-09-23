package com.mappls.sdk.services.api.transit;

import com.BV.LinearGradient.LinearGradientManager;
import com.google.gson.GsonBuilder;
import com.henninghall.date_picker.props.ModeProp;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.transit.model.TransitPlannerResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsTransitPlanner extends MapplsService<TransitPlannerResponse, TransitPlannerService> {
    abstract Boolean arriveBy();

    @Override // com.mappls.sdk.services.api.MapplsService
    public abstract String baseUrl();

    abstract String date();

    abstract String destination();

    abstract Integer maxTransfers();

    abstract String mode();

    abstract Boolean optimalRoute();

    abstract String origin();

    abstract Integer searchWindow();

    abstract Boolean showIntermediateStops();

    abstract String time();

    abstract Double walkSpeed();

    public MapplsTransitPlanner() {
        super(TransitPlannerService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsTransitPlanner.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).mode(TransitPlannerCriteria.MODE_TRANSIT);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<TransitPlannerResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    void enqueue(Callback<TransitPlannerResponse> callback) {
        enqueueCall(callback);
    }

    Response<TransitPlannerResponse> execute() throws IOException {
        return executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put(ModeProp.name, mode());
        map.put(LinearGradientManager.PROP_LOCATIONS, origin() + ";" + destination());
        if (date() != null) {
            map.put("date", date());
        }
        if (time() != null) {
            map.put("time", time());
        }
        if (arriveBy() != null) {
            map.put("arriveBy", arriveBy());
        }
        if (optimalRoute() != null) {
            map.put("optimalRoute", optimalRoute());
        }
        if (searchWindow() != null) {
            map.put("searchWindow", searchWindow());
        }
        if (maxTransfers() != null) {
            map.put("maxTransfers", maxTransfers());
        }
        if (showIntermediateStops() != null) {
            map.put("showIntermediateStops", showIntermediateStops());
        }
        return map;
    }

    public static abstract class Builder {
        public abstract Builder arriveBy(Boolean bool);

        abstract MapplsTransitPlanner autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder date(String str);

        public abstract Builder destination(String str);

        public abstract Builder maxTransfers(Integer num);

        public abstract Builder mode(String str);

        public abstract Builder optimalRoute(Boolean bool);

        public abstract Builder origin(String str);

        public abstract Builder searchWindow(Integer num);

        public abstract Builder showIntermediateStops(Boolean bool);

        public abstract Builder time(String str);

        public abstract Builder walkSpeed(Double d);

        public Builder origin(Point point) {
            return origin(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.latitude()), MapplsUtils.formatCoordinate(point.longitude())));
        }

        public Builder destination(Point point) {
            return destination(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.latitude()), MapplsUtils.formatCoordinate(point.longitude())));
        }

        public MapplsTransitPlanner build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid keys.");
            }
            return autoBuild();
        }
    }
}
