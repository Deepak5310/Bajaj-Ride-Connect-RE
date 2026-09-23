package com.mappls.sdk.services.api.costestimation;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsCostEstimation extends MapplsService<CostEstimationResponse, CostEstimationService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    public abstract String baseUrl();

    abstract Double distance();

    abstract Integer fuelEfficiency();

    abstract String fuelEfficiencyUnit();

    abstract Double fuelPrice();

    abstract Boolean isTollEnabled();

    abstract Double latitude();

    abstract Double longitude();

    abstract String routeId();

    abstract Integer routeIndex();

    abstract String vehicleFuelType();

    abstract String vehicleType();

    public MapplsCostEstimation() {
        super(CostEstimationService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsCostEstimation.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<CostEstimationResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    void enqueue(Callback<CostEstimationResponse> callback) {
        enqueueCall(callback);
    }

    Response<CostEstimationResponse> execute() throws IOException {
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
        if (routeId() != null) {
            map.put(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, routeId());
        }
        if (routeIndex() != null) {
            map.put("routeIdx", routeIndex());
        }
        if (vehicleType() != null) {
            map.put("vehicleType", vehicleType());
        }
        if (isTollEnabled() != null) {
            map.put("isTollEnabled", isTollEnabled());
        }
        if (vehicleFuelType() != null) {
            map.put("vehicleFuelType", vehicleFuelType());
        }
        if (fuelEfficiency() != null) {
            map.put("fuelEfficiency", fuelEfficiency());
        }
        if (fuelEfficiencyUnit() != null) {
            map.put("fuelEfficiencyUnit", fuelEfficiencyUnit());
        }
        if (fuelPrice() != null) {
            map.put("fuelPrice", fuelPrice());
        }
        if (distance() != null) {
            map.put(DirectionsCriteria.ANNOTATION_DISTANCE, distance());
        }
        if (latitude() != null) {
            map.put("latitude", latitude());
        }
        if (longitude() != null) {
            map.put("longitude", longitude());
        }
        return map;
    }

    public static abstract class Builder {
        abstract MapplsCostEstimation autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder distance(Double d);

        public abstract Builder fuelEfficiency(Integer num);

        public abstract Builder fuelEfficiencyUnit(String str);

        public abstract Builder fuelPrice(Double d);

        public abstract Builder isTollEnabled(Boolean bool);

        public abstract Builder latitude(Double d);

        public abstract Builder longitude(Double d);

        public abstract Builder routeId(String str);

        public abstract Builder routeIndex(Integer num);

        public abstract Builder vehicleFuelType(String str);

        public abstract Builder vehicleType(String str);

        public MapplsCostEstimation build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid keys.");
            }
            return autoBuild();
        }
    }
}
