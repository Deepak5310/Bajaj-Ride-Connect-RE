package com.mappls.sdk.services.api.fuleCost;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.fuleCost.models.FuelCostResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsFuelCost extends MapplsService<FuelCostResponse, FuelCostService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract Double latitude();

    abstract Double longitude();

    public MapplsFuelCost() {
        super(FuelCostService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsFuelCost.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<FuelCostResponse> initializeCall() {
        return getLoginService(true).getCall(latitude(), longitude());
    }

    void enqueue(Callback<FuelCostResponse> callback) {
        enqueueCall(callback);
    }

    Response<FuelCostResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsFuelCost autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder latitude(Double d);

        abstract Builder longitude(Double d);

        public Builder location(Double d, Double d2) {
            return latitude(d).longitude(d2);
        }

        public MapplsFuelCost build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid keys.");
            }
            return autoBuild();
        }
    }
}
