package com.mappls.sdk.services.api.fuleCost;

import com.mappls.sdk.services.api.fuleCost.models.FuelCostResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
public interface FuelCostService {
    @GET("apis/O2O/action/fuelPrice")
    Call<FuelCostResponse> getCall(@Query("latitude") Double d, @Query("longitude") Double d2);
}
