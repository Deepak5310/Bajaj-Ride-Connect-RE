package com.mappls.sdk.services.api.traffic;

import com.mappls.sdk.services.api.traffic.model.TrafficRoadDetailResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface TrafficRoadDetailService {
    @GET("advancedmaps/v2/traffic_flow/adjacent")
    Call<TrafficRoadDetailResponse> getCall(@Query("lat") Double d, @Query("lng") Double d2, @Query("radius") Long l);
}
