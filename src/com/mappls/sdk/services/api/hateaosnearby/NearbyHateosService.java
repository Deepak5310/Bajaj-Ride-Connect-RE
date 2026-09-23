package com.mappls.sdk.services.api.hateaosnearby;

import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes4.dex */
public interface NearbyHateosService {
    @GET
    Call<NearbyAtlasResponse> getCall(@Url String str);
}
