package com.mappls.sdk.services.api.generateotp;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface GenerateOTPService {
    @POST("api/users/authenticate")
    Call<Void> getCall(@Query("handle") String str);
}
