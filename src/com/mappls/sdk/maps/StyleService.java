package com.mappls.sdk.maps;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface StyleService {
    @POST("getStyles/json")
    Call<GetStylesResponse> getStyles(@Query("logo_resolution") String str);
}
