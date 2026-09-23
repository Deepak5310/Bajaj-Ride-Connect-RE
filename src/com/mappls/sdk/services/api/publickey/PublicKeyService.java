package com.mappls.sdk.services.api.publickey;

import com.mappls.sdk.services.api.publickey.model.PublicKeyResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
interface PublicKeyService {
    @POST("api/security/sdk/public")
    Call<PublicKeyResponse> getCall(@Body PublicKeyRequest publicKeyRequest);
}
