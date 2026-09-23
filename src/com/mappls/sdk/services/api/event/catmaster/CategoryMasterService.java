package com.mappls.sdk.services.api.event.catmaster;

import com.mappls.sdk.services.api.event.catmaster.model.ReportMasterResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes4.dex */
interface CategoryMasterService {
    @GET("apis/O2O/action/reportCatMaster")
    Call<ReportMasterResponse> getCall();
}
