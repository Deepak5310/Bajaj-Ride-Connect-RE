package com.mappls.sdk.services.api.predictive.directions;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.predictive.directions.model.PredictiveDirectionsResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsPredictiveDirectionManager {
    private final MapplsPredictiveDirections mapplsPredictiveDirections;

    private MapplsPredictiveDirectionManager(MapplsPredictiveDirections mapplsPredictiveDirections) {
        this.mapplsPredictiveDirections = mapplsPredictiveDirections;
    }

    public static MapplsPredictiveDirectionManager newInstance(MapplsPredictiveDirections mapplsPredictiveDirections) {
        return new MapplsPredictiveDirectionManager(mapplsPredictiveDirections);
    }

    @Deprecated
    public PredictiveDirectionsResponse execute() throws IOException {
        return this.mapplsPredictiveDirections.execute().body();
    }

    public ApiResponse<PredictiveDirectionsResponse> executeCall() throws IOException {
        Response<PredictiveDirectionsResponse> responseExecute = this.mapplsPredictiveDirections.execute();
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

    public void call(final OnResponseCallback<PredictiveDirectionsResponse> onResponseCallback) {
        this.mapplsPredictiveDirections.enqueue(new Callback<PredictiveDirectionsResponse>() { // from class: com.mappls.sdk.services.api.predictive.directions.MapplsPredictiveDirectionManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<PredictiveDirectionsResponse> call, Response<PredictiveDirectionsResponse> response) {
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
            public void onFailure(Call<PredictiveDirectionsResponse> call, Throwable th) {
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
        this.mapplsPredictiveDirections.cancel();
    }

    public boolean isExecuted() {
        return this.mapplsPredictiveDirections.executed();
    }
}
