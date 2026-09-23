package com.mappls.sdk.maps.auth;

import com.mappls.sdk.maps.auth.model.PublicKeyToken;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.utils.Constants;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsVectorKey extends MapplsService<PublicKeyToken, VectorKeyService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    public MapplsVectorKey() {
        super(VectorKeyService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsVectorKey.Builder().baseUrl(Constants.OUTPOST_BASE_URL);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<PublicKeyToken> initializeCall() {
        return getLoginService(true).getCall();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public void enqueueCall(Callback<PublicKeyToken> callback) {
        super.enqueueCall(callback);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    public Response<PublicKeyToken> executeCall() throws IOException {
        return super.executeCall();
    }

    public static abstract class Builder {
        abstract MapplsVectorKey autoBuild();

        abstract Builder baseUrl(String str);

        public MapplsVectorKey build() throws ServicesException {
            return autoBuild();
        }
    }
}
