package com.mappls.sdk.services.api.session.create;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;
import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsCreateSession extends MapplsService<SessionResponse, CreateSessionService> {

    public static abstract class Builder {
        public abstract Builder baseUrl(String str);

        public abstract MapplsCreateSession build();

        public abstract Builder clusterId(String str);

        public abstract Builder sessionRequest(SessionRequestModel sessionRequestModel);

        public abstract Builder sessionType(String str);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String clusterId();

    abstract SessionRequestModel sessionRequest();

    abstract String sessionType();

    public MapplsCreateSession() {
        super(CreateSessionService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsCreateSession.Builder().baseUrl(Constants.OUTPOST_BASE_URL).sessionType("global");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<SessionResponse> initializeCall() {
        return getLoginService(true).getCall(sessionType(), clusterId(), sessionRequest());
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<SessionResponse> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<SessionResponse> executeCall() throws IOException {
        return super.executeCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void cancelCall() {
        super.cancelCall();
    }
}
