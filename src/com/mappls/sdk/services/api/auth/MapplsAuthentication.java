package com.mappls.sdk.services.api.auth;

import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsAuthentication extends MapplsService<AtlasAuthToken, AuthenticationService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String grantType();

    abstract String refreshToken();

    public MapplsAuthentication() {
        super(AuthenticationService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsAuthentication.Builder().grantType("client_credentials").baseUrl(Constants.OUTPOST_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<AtlasAuthToken> initializeCall() {
        return getService(false).getCall(MapplsAccountManager.getInstance().getAtlasClientId(), MapplsAccountManager.getInstance().getAtlasClientSecret(), refreshToken(), grantType());
    }

    void enqueue(Callback<AtlasAuthToken> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<AtlasAuthToken> executeCall() throws IOException {
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
        abstract MapplsAuthentication autoBuild();

        abstract Builder baseUrl(String str);

        public abstract Builder grantType(String str);

        public abstract Builder refreshToken(String str);

        public MapplsAuthentication build() throws ServicesException {
            return autoBuild();
        }
    }
}
