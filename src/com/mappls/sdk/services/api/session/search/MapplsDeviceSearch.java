package com.mappls.sdk.services.api.session.search;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.session.search.model.DeviceSearchResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsDeviceSearch extends MapplsService<DeviceSearchResponse, DeviceSearchService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    public abstract String query();

    public MapplsDeviceSearch() {
        super(DeviceSearchService.class);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<DeviceSearchResponse> initializeCall() {
        return getLoginService(true).getSearchDeviceInfo(query());
    }

    void enqueue(Callback<DeviceSearchResponse> callback) {
        enqueueCall(callback);
    }

    Response<DeviceSearchResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static Builder builder() {
        return new AutoValue_MapplsDeviceSearch.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL);
    }

    public static abstract class Builder {
        abstract MapplsDeviceSearch autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder query(String str);

        public MapplsDeviceSearch build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            return autoBuild();
        }
    }
}
