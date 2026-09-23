package com.mappls.sdk.maps;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* JADX INFO: loaded from: classes4.dex */
interface GetCoordinatesService {
    @GET("apis/O2O/entity/{mapplsPin}/coordinates")
    Call<CoordinateResponse> getCall(@Path("mapplsPin") String str);
}
