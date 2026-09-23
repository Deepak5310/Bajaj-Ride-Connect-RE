package com.mappls.sdk.services.api.auth;

import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
interface AuthenticationService {
    @FormUrlEncoded
    @POST("api/security/oauth/token")
    Call<AtlasAuthToken> getCall(@Field(AccountsQueryParameters.CLIENT_ID) String str, @Field("client_secret") String str2, @Field("refresh_token") String str3, @Field("grant_type") String str4);
}
