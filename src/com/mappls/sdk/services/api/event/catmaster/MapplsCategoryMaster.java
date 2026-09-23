package com.mappls.sdk.services.api.event.catmaster;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.event.catmaster.model.ReportMasterResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsCategoryMaster extends MapplsService<ReportMasterResponse, CategoryMasterService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected MapplsCategoryMaster() {
        super(CategoryMasterService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsCategoryMaster.Builder().baseUrl(Constants.EXPLORE_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<ReportMasterResponse> initializeCall() {
        return getLoginService(true).getCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ReportMasterResponse.class, new CategoryMasterJsonDeserializer()).create();
        return gsonBuilder;
    }

    void enqueue(Callback<ReportMasterResponse> callback) {
        enqueueCall(callback);
    }

    Response<ReportMasterResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsCategoryMaster autoBuild();

        public abstract Builder baseUrl(String str);

        public MapplsCategoryMaster build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            return autoBuild();
        }
    }
}
