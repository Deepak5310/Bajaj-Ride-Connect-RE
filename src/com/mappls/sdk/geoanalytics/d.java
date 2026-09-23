package com.mappls.sdk.geoanalytics;

import java.util.HashMap;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes6.dex */
interface d {
    @GET("geoFeature")
    Observable<ResponseBody> a(@QueryMap HashMap<String, String> map);
}
