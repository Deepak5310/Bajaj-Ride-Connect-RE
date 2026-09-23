package com.mappls.sdk.services.api.whoami;

import com.mappls.sdk.services.api.whoami.model.LicensingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface LicensingService {
    @GET("api/bff/projects/whoami")
    Call<LicensingResponse> getCall(@Query("deviceId") String str);
}
