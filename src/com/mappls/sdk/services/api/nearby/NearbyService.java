package com.mappls.sdk.services.api.nearby;

import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes4.dex */
public interface NearbyService {
    @GET("api/places/nearby/json")
    Call<NearbyAtlasResponse> getCall(@QueryMap Map<String, Object> map);
}
