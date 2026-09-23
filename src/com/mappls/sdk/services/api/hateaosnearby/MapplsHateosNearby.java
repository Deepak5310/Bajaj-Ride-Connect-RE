package com.mappls.sdk.services.api.hateaosnearby;

import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsHateosNearby extends MapplsService<NearbyAtlasResponse, NearbyHateosService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract String hyperlink();

    public MapplsHateosNearby() {
        super(NearbyHateosService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsHateosNearby.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<NearbyAtlasResponse> initializeCall() {
        return getLoginService(true).getCall(hyperlink());
    }

    void enqueue(Callback<NearbyAtlasResponse> callback) {
        enqueueCall(callback);
    }

    Response<NearbyAtlasResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        abstract MapplsHateosNearby autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder hyperlink(String str);

        public MapplsHateosNearby build() throws ServicesException {
            return autoBuild();
        }
    }
}
