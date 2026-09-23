package com.mappls.sdk.services.api.publickey;

import android.provider.Settings;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.publickey.model.PublicKeyResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import retrofit2.Call;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsPublicKey extends MapplsService<PublicKeyResponse, PublicKeyService> {
    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    public MapplsPublicKey() {
        super(PublicKeyService.class);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<PublicKeyResponse> initializeCall() {
        return getService(true).getCall(new PublicKeyRequest(Settings.Secure.getString(MapplsUtils.getSDKContext().getContentResolver(), "android_id"), "SHA256"));
    }

    public static Builder builder() {
        return new AutoValue_MapplsPublicKey.Builder().baseUrl(Constants.OUTPOST_BASE_URL);
    }

    public static abstract class Builder {
        abstract MapplsPublicKey autobuild();

        public abstract Builder baseUrl(String str);

        public MapplsPublicKey build() {
            if (MapplsUtils.getSDKContext() == null) {
                throw new ServicesException("You should initialise component using MapplsAccountManager class");
            }
            return autobuild();
        }
    }
}
