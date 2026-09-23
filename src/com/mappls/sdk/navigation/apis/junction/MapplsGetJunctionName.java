package com.mappls.sdk.navigation.apis.junction;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsGetJunctionName extends MapplsService<Map<String, String>, com.mappls.sdk.navigation.apis.web.a> {

    public static abstract class Builder {
        abstract MapplsGetJunctionName autoBuild();

        public abstract Builder baseUrl(String str);

        public MapplsGetJunctionName build() {
            if (MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                return autoBuild();
            }
            throw new ServicesException("Using Mappls Services requires setting a valid keys.");
        }

        public abstract Builder imageName(List<String> list);

        public abstract Builder junctionViewMode(String str);

        public abstract Builder size(String str);
    }

    public MapplsGetJunctionName() {
        super(com.mappls.sdk.navigation.apis.web.a.class);
    }

    public static Builder builder() {
        return new b.a().baseUrl(Constants.EXPLORE_BASE_URL).junctionViewMode(WeatherCriteria.UNIT_TYPE_DAY).size("280X200");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    @Override // com.mappls.sdk.services.api.MapplsService
    public void cancelCall() {
        super.cancelCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<Map<String, String>> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<Map<String, String>> executeCall() {
        return super.executeCall();
    }

    abstract List<String> imageName();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<Map<String, String>> initializeCall() {
        return getLoginService(true).a(imageName(), junctionViewMode(), size());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public boolean isExecuted() {
        return super.isExecuted();
    }

    abstract String junctionViewMode();

    abstract String size();
}
