package com.mappls.sdk.services.api.tripplan;

import com.mappls.sdk.services.api.tripplan.model.SmartTripPlanResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
interface SmartTripPlanService {
    @POST("apis/O2O/ev/add-via-points")
    Call<SmartTripPlanResponse> getCall(@Body Map<String, Object> map);
}
