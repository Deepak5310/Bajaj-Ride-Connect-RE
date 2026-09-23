package com.mappls.sdk.services.api.session.update;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;
import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsUpdateSession extends MapplsService<SessionResponse, UpdateSessionService> {

    public static abstract class Builder {
        public abstract Builder baseUrl(String str);

        public abstract MapplsUpdateSession build();

        public abstract Builder clusterId(String str);

        public abstract Builder hyperlink(String str);

        public abstract Builder sessionRequest(SessionRequestModel sessionRequestModel);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract String clusterId();

    abstract String hyperlink();

    abstract SessionRequestModel sessionRequest();

    public MapplsUpdateSession() {
        super(UpdateSessionService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsUpdateSession.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<SessionResponse> initializeCall() {
        return getLoginService(true).getCall(hyperlink(), clusterId(), sessionRequest());
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
