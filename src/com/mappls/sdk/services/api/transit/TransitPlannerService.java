package com.mappls.sdk.services.api.transit;

import com.mappls.sdk.services.api.transit.model.TransitPlannerResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes4.dex */
interface TransitPlannerService {
    @GET("v1/TransitPlanner")
    Call<TransitPlannerResponse> getCall(@QueryMap Map<String, Object> map);
}
