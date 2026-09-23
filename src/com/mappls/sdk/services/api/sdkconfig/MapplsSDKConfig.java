package com.mappls.sdk.services.api.sdkconfig;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.sdkconfig.model.SDKConfigResponse;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsSDKConfig extends MapplsService<SDKConfigResponse, SDKConfigService> {

    public static abstract class Builder {
        public abstract Builder baseUrl(String str);

        public abstract MapplsSDKConfig build();

        public abstract Builder configUrl(String str);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String configUrl();

    protected MapplsSDKConfig() {
        super(SDKConfigService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsSDKConfig.Builder().baseUrl("https://sdkconfig.mappls.com/");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<SDKConfigResponse> initializeCall() {
        return getPlainService().getCall(configUrl());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<SDKConfigResponse> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<SDKConfigResponse> executeCall() throws IOException {
        return super.executeCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public boolean isExecuted() {
        return super.isExecuted();
    }
}
