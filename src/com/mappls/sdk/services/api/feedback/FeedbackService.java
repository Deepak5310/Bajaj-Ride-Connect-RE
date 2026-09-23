package com.mappls.sdk.services.api.feedback;

import java.util.HashMap;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
public interface FeedbackService {
    @FormUrlEncoded
    @POST("api/feedback/search/json")
    Call<Void> getCall(@FieldMap HashMap<String, String> map);
}
