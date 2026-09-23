package com.mappls.sdk.services.api.session.delete;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsDeleteSession extends MapplsService<SessionResponse, DeleteSessionService> {

    public static abstract class Builder {
        public abstract Builder baseUrl(String str);

        public abstract MapplsDeleteSession build();

        public abstract Builder hyperlink(String str);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String hyperlink();

    public MapplsDeleteSession() {
        super(DeleteSessionService.class);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<SessionResponse> initializeCall() {
        return getLoginService(true).getCall(hyperlink());
    }

    public static Builder builder() {
        return new AutoValue_MapplsDeleteSession.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL);
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
