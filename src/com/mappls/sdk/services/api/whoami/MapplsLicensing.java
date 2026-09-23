package com.mappls.sdk.services.api.whoami;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.whoami.model.LicensingResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsLicensing extends MapplsService<LicensingResponse, LicensingService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String deviceId();

    public MapplsLicensing() {
        super(LicensingService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsLicensing.Builder().baseUrl(Constants.ANCHOR_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<LicensingResponse> initializeCall() {
        return getService(true).getCall(deviceId());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<LicensingResponse> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<LicensingResponse> executeCall() throws IOException {
        return super.executeCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public boolean isExecuted() {
        return super.isExecuted();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void cancelCall() {
        super.cancelCall();
    }

    public static abstract class Builder {
        abstract MapplsLicensing autoBuild();

        abstract Builder baseUrl(String str);

        public abstract Builder deviceId(String str);

        public MapplsLicensing build() {
            return autoBuild();
        }
    }
}
