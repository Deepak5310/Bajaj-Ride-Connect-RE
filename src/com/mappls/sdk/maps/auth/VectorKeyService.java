package com.mappls.sdk.maps.auth;

import com.mappls.sdk.maps.auth.model.PublicKeyToken;
import retrofit2.Call;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes4.dex */
interface VectorKeyService {
    @GET("api/advance/vectorMaps/public")
    Call<PublicKeyToken> getCall();
}
