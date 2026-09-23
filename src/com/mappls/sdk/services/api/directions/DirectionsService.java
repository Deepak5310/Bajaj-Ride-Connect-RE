package com.mappls.sdk.services.api.directions;

import com.google.android.gms.common.Scopes;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes4.dex */
public interface DirectionsService {
    @GET("advancedmaps/v1/{rest_api_ley}/{resource}/{profile}/{coordinates}")
    Call<DirectionsResponse> getCall(@Path(Scopes.PROFILE) String str, @Path("resource") String str2, @Path("coordinates") String str3, @Path("rest_api_ley") String str4, @Query("radiuses") String str5, @Query("steps") Boolean bool, @Query("bearings") String str6, @Query("lessverbose") Boolean bool2, @Query("annotations") String str7, @Query("language") String str8, @Query("roundabout_exits") Boolean bool3, @Query("continue_straight") Boolean bool4, @Query("banner_instructions") Boolean bool5, @Query("exclude") String str9, @Query("routeRefresh") Boolean bool6, @Query("deviceId") String str10, @Query("sessionId") String str11, @Query("isSort") Boolean bool7, @Query("skip_waypoints") Boolean bool8, @Query("instructions") Boolean bool9, @Query("rtype") Integer num, @QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("advancedmaps/v1/{rest_api_ley}/{resource}/{profile}")
    Call<DirectionsResponse> postCall(@Path(Scopes.PROFILE) String str, @Path("resource") String str2, @Field("coordinates") String str3, @Query("rest_api_ley") String str4, @Query("radiuses") String str5, @Query("steps") Boolean bool, @Query("bearings") String str6, @Query("lessverbose") Boolean bool2, @Query("annotations") String str7, @Query("language") String str8, @Query("roundabout_exits") Boolean bool3, @Query("continue_straight") Boolean bool4, @Query("banner_instructions") Boolean bool5, @Query("exclude") String str9, @Query("routeRefresh") Boolean bool6, @Query("deviceId") String str10, @Query("sessionId") String str11, @Query("isSort") Boolean bool7, @Query("skip_waypoints") Boolean bool8, @Query("instructions") Boolean bool9, @Query("rtype") Integer num, @QueryMap Map<String, Object> map);
}
