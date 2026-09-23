package com.mappls.sdk.services.api.event.submitreport;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
interface SubmitReportService {
    @POST("apis/O2O/action/report")
    Call<Void> getCall(@Body Map<String, Object> map);
}
