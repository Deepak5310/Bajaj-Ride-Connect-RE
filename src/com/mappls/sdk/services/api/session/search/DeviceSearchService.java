package com.mappls.sdk.services.api.session.search;

import com.google.android.gms.actions.SearchIntents;
import com.mappls.sdk.services.api.session.search.model.DeviceSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface DeviceSearchService {
    @GET("api/bff/projects/devices/search")
    Call<DeviceSearchResponse> getSearchDeviceInfo(@Query(SearchIntents.EXTRA_QUERY) String str);
}
