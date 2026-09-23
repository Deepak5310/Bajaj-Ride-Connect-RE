package com.mappls.sdk.geoanalytics.listing;

import com.mappls.sdk.geoanalytics.listing.model.GeoAnalyticsListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes6.dex */
interface b {
    @GET("listingapi")
    Call<GeoAnalyticsListResponse> a(@Query("layertype") String str, @Query("geo_bound_type") String str2, @Query("geo_bound") String str3, @Query("get_attr") String str4);
}
