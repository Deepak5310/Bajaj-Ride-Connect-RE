package com.mappls.sdk.services.api.session.endsession;

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
public abstract class MapplsEndSession extends MapplsService<Void, EndSessionService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String clusterId();

    abstract String sessionType();

    public MapplsEndSession() {
        super(EndSessionService.class);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<Void> initializeCall() {
        return getLoginService(true).getCall(sessionType(), clusterId());
    }

    public static Builder builder() {
        return new AutoValue_MapplsEndSession.Builder().baseUrl(Constants.OUTPOST_BASE_URL).sessionType("global");
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
        abstract MapplsEndSession autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder clusterId(String str);

        public abstract Builder sessionType(String str);

        public MapplsEndSession build() throws ServicesException {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId()) && !MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                throw new ServicesException("Using Mappls Services requires setting a valid client_id and client_secret.");
            }
            return autoBuild();
        }
    }
}
