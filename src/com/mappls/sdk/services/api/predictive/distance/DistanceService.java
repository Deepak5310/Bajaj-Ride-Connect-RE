package com.mappls.sdk.services.api.predictive.distance;

import com.mappls.sdk.services.api.predictive.distance.models.PredictiveDistanceResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes4.dex */
interface DistanceService {
    @GET("advancedmaps/v2/distance")
    Call<PredictiveDistanceResponse> getCall(@QueryMap Map<String, Object> map);
}
