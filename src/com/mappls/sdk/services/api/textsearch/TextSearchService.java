package com.mappls.sdk.services.api.textsearch;

import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes4.dex */
public interface TextSearchService {
    @GET("api/places/textsearch/json")
    Call<AutoSuggestAtlasResponse> getCall(@QueryMap Map<String, Object> map);
}
