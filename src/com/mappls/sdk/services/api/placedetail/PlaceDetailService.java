package com.mappls.sdk.services.api.placedetail;

import com.mappls.sdk.services.api.placedetail.model.PlaceDetailResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* JADX INFO: loaded from: classes4.dex */
interface PlaceDetailService {
    @GET("apis/O2O/entity/{mapplsPin}")
    Call<PlaceDetailResponse> getCall(@Path("mapplsPin") String str);
}
