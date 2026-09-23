package com.mappls.sdk.geoanalytics.listing;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.mappls.sdk.geoanalytics.listing.model.GeoAnalyticsListResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class MapplsGeoAnalyticsListManager {
    private MapplsGeoAnalyticsList mapplsGeoAnalyticsList;

    class a implements Callback<GeoAnalyticsListResponse> {
        final /* synthetic */ OnResponseCallback a;

        a(OnResponseCallback onResponseCallback) {
            this.a = onResponseCallback;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<GeoAnalyticsListResponse> call, Throwable th) {
            OnResponseCallback onResponseCallback;
            String message;
            int i;
            if (call.isCanceled()) {
                onResponseCallback = this.a;
                message = th.getMessage();
                i = 0;
            } else if (th instanceof UnknownHostException) {
                onResponseCallback = this.a;
                message = th.getMessage();
                i = 1;
            } else {
                onResponseCallback = this.a;
                message = th.getMessage();
                i = 2;
            }
            onResponseCallback.onError(i, message);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<GeoAnalyticsListResponse> call, Response<GeoAnalyticsListResponse> response) {
            OnResponseCallback onResponseCallback;
            int iCode;
            String strMessage;
            OnResponseCallback onResponseCallback2;
            int iCode2;
            String strMessage2;
            if (response.code() == 200) {
                this.a.onSuccess(response.body());
                return;
            }
            if (response.headers().get(StackTraceHelper.MESSAGE_KEY) != null) {
                onResponseCallback2 = this.a;
                iCode2 = response.code();
                strMessage2 = response.headers().get(StackTraceHelper.MESSAGE_KEY);
            } else {
                if (response.errorBody() != null) {
                    try {
                        Map map = (Map) new Gson().fromJson(response.errorBody().string(), Map.class);
                        if (map == null || !map.containsKey("error")) {
                            onResponseCallback = this.a;
                            iCode = response.code();
                            strMessage = response.message();
                        } else {
                            onResponseCallback = this.a;
                            iCode = response.code();
                            strMessage = (String) map.get("error");
                        }
                        onResponseCallback.onError(iCode, strMessage);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                onResponseCallback2 = this.a;
                iCode2 = response.code();
                strMessage2 = response.message();
            }
            onResponseCallback2.onError(iCode2, strMessage2);
        }
    }

    private MapplsGeoAnalyticsListManager(MapplsGeoAnalyticsList mapplsGeoAnalyticsList) {
        this.mapplsGeoAnalyticsList = mapplsGeoAnalyticsList;
    }

    public static MapplsGeoAnalyticsListManager newInstance(MapplsGeoAnalyticsList mapplsGeoAnalyticsList) {
        return new MapplsGeoAnalyticsListManager(mapplsGeoAnalyticsList);
    }

    public void call(OnResponseCallback<GeoAnalyticsListResponse> onResponseCallback) {
        this.mapplsGeoAnalyticsList.enqueue(new a(onResponseCallback));
    }

    public void cancel() {
        this.mapplsGeoAnalyticsList.cancel();
    }

    public GeoAnalyticsListResponse execute() {
        return this.mapplsGeoAnalyticsList.execute().body();
    }

    public boolean isExecuted() {
        return this.mapplsGeoAnalyticsList.executed();
    }
}
