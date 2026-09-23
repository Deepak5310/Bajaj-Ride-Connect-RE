package com.mappls.sdk.services.api.sdkconfig;

import com.mappls.sdk.services.api.sdkconfig.model.SDKConfigResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes4.dex */
interface SDKConfigService {
    @GET
    Call<SDKConfigResponse> getCall(@Url String str);
}
