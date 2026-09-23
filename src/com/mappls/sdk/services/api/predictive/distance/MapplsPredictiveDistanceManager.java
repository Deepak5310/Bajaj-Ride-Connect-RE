package com.mappls.sdk.services.api.predictive.distance;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.predictive.distance.models.PredictiveDistanceResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsPredictiveDistanceManager {
    private final MapplsPredictiveDistance mapplsPredictiveDistance;

    private MapplsPredictiveDistanceManager(MapplsPredictiveDistance mapplsPredictiveDistance) {
        this.mapplsPredictiveDistance = mapplsPredictiveDistance;
    }

    public static MapplsPredictiveDistanceManager newInstance(MapplsPredictiveDistance mapplsPredictiveDistance) {
        return new MapplsPredictiveDistanceManager(mapplsPredictiveDistance);
    }

    @Deprecated
    public PredictiveDistanceResponse execute() throws IOException {
        return this.mapplsPredictiveDistance.execute().body();
    }

    public ApiResponse<PredictiveDistanceResponse> executeCall() throws IOException {
        Response<PredictiveDistanceResponse> responseExecute = this.mapplsPredictiveDistance.execute();
        if (responseExecute.code() == 200) {
            return ApiResponse.success(responseExecute.body());
        }
        if (responseExecute.headers().get(StackTraceHelper.MESSAGE_KEY) != null) {
            return ApiResponse.error(responseExecute.code(), responseExecute.headers().get(StackTraceHelper.MESSAGE_KEY));
        }
        if (responseExecute.errorBody() != null) {
            try {
                Map map = (Map) new Gson().fromJson(responseExecute.errorBody().string(), Map.class);
                if (map != null && map.containsKey("error")) {
                    return ApiResponse.error(responseExecute.code(), (String) map.get("error"));
                }
                return ApiResponse.error(responseExecute.code(), responseExecute.message());
            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.error(responseExecute.code(), responseExecute.message());
            }
        }
        return ApiResponse.error(responseExecute.code(), responseExecute.message());
    }

    public void call(final OnResponseCallback<PredictiveDistanceResponse> onResponseCallback) {
        this.mapplsPredictiveDistance.enqueue(new Callback<PredictiveDistanceResponse>() { // from class: com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistanceManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<PredictiveDistanceResponse> call, Response<PredictiveDistanceResponse> response) {
                if (response.code() == 200) {
                    onResponseCallback.onSuccess(response.body());
                    return;
                }
                if (response.headers().get(StackTraceHelper.MESSAGE_KEY) != null) {
                    onResponseCallback.onError(response.code(), response.headers().get(StackTraceHelper.MESSAGE_KEY));
                    return;
                }
                if (response.errorBody() != null) {
                    try {
                        Map map = (Map) new Gson().fromJson(response.errorBody().string(), Map.class);
                        if (map != null && map.containsKey("error")) {
                            onResponseCallback.onError(response.code(), (String) map.get("error"));
                        } else {
                            onResponseCallback.onError(response.code(), response.message());
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        onResponseCallback.onError(response.code(), response.message());
                        return;
                    }
                }
                onResponseCallback.onError(response.code(), response.message());
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PredictiveDistanceResponse> call, Throwable th) {
                if (call.isCanceled()) {
                    onResponseCallback.onError(0, th.getMessage());
                } else if (th instanceof UnknownHostException) {
                    onResponseCallback.onError(1, th.getMessage());
                } else {
                    onResponseCallback.onError(2, th.getMessage());
                }
            }
        });
    }

    public void cancel() {
        this.mapplsPredictiveDistance.cancel();
    }

    public boolean isExecuted() {
        return this.mapplsPredictiveDistance.executed();
    }
}
