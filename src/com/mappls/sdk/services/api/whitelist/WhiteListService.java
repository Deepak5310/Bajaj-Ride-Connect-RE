package com.mappls.sdk.services.api.whitelist;

import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
interface WhiteListService {
    @FormUrlEncoded
    @POST("api/sso/login/viaOtp")
    Call<AtlasAuthToken> getCall(@FieldMap Map<String, String> map);
}
