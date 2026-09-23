package com.mappls.sdk.services.api.tripoptimisation;

import com.google.android.gms.common.Scopes;
import com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes4.dex */
interface TripOptimisationService {
    @GET("advancedmaps/v1/{rest_api_key}/{resource}/{profile}/{coordinates}")
    Call<TripOptimisationResponse> getCall(@Path(Scopes.PROFILE) String str, @Path("resource") String str2, @Path("coordinates") String str3, @Path("rest_api_key") String str4, @QueryMap Map<String, Object> map);
}
