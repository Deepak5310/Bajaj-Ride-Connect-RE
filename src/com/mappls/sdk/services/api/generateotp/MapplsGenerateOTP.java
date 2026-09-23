package com.mappls.sdk.services.api.generateotp;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsGenerateOTP extends MapplsService<Void, GenerateOTPService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String userHandle();

    protected MapplsGenerateOTP() {
        super(GenerateOTPService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsGenerateOTP.Builder().baseUrl(Constants.ANCHOR_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<Void> initializeCall() {
        return getService(true).getCall(userHandle());
    }

    void enqueue(Callback<Void> callback) {
        enqueueCall(callback);
    }

    Response<Void> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsGenerateOTP autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder userHandle(String str);

        public MapplsGenerateOTP build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid rest API key.");
            }
            return autoBuild();
        }
    }
}
