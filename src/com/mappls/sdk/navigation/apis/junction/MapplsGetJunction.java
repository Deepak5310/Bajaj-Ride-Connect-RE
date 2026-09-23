package com.mappls.sdk.navigation.apis.junction;

import com.mappls.sdk.navigation.model.JunctionApiResponse;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsGetJunction extends MapplsService<JunctionApiResponse, com.mappls.sdk.navigation.apis.web.a> {

    public static abstract class Builder {
        abstract MapplsGetJunction autoBuild();

        public abstract Builder baseUrl(String str);

        public MapplsGetJunction build() {
            if (MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                return autoBuild();
            }
            throw new ServicesException("Using Mappls Services requires setting a valid keys.");
        }

        public abstract Builder junctionViewMode(String str);

        public abstract Builder routeId(String str);

        public abstract Builder routeIdx(Integer num);

        public abstract Builder size(String str);
    }

    public MapplsGetJunction() {
        super(com.mappls.sdk.navigation.apis.web.a.class);
    }

    public static Builder builder() {
        return new a.C0093a().baseUrl(Constants.EXPLORE_BASE_URL).junctionViewMode(WeatherCriteria.UNIT_TYPE_DAY).size("280X200");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    @Override // com.mappls.sdk.services.api.MapplsService
    public void cancelCall() {
        super.cancelCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<JunctionApiResponse> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<JunctionApiResponse> executeCall() {
        return super.executeCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<JunctionApiResponse> initializeCall() {
        return getLoginService(true).a(routeId(), junctionViewMode(), routeIdx(), size());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public boolean isExecuted() {
        return super.isExecuted();
    }

    abstract String junctionViewMode();

    abstract String routeId();

    abstract Integer routeIdx();

    abstract String size();
}
