package com.mappls.sdk.services.api.generateotp;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsGenerateOtpManager {
    private final MapplsGenerateOTP mapplsGenerateOTP;

    private MapplsGenerateOtpManager(MapplsGenerateOTP mapplsGenerateOTP) {
        this.mapplsGenerateOTP = mapplsGenerateOTP;
    }

    public static MapplsGenerateOtpManager newInstance(MapplsGenerateOTP mapplsGenerateOTP) {
        return new MapplsGenerateOtpManager(mapplsGenerateOTP);
    }

    @Deprecated
    public String execute() throws IOException {
        Response<Void> responseExecute = this.mapplsGenerateOTP.execute();
        if (responseExecute.code() == 201) {
            return responseExecute.headers().get(HttpHeaders.LOCATION);
        }
        return null;
    }

    public ApiResponse<String> executeCall() throws IOException {
        Response<Void> responseExecute = this.mapplsGenerateOTP.execute();
        if (responseExecute.code() == 201) {
            return ApiResponse.success(responseExecute.headers().get(HttpHeaders.LOCATION), 201);
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

    public void call(final OnResponseCallback<String> onResponseCallback) {
        this.mapplsGenerateOTP.enqueue(new Callback<Void>() { // from class: com.mappls.sdk.services.api.generateotp.MapplsGenerateOtpManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 201) {
                    onResponseCallback.onSuccess(response.headers().get(HttpHeaders.LOCATION));
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
            public void onFailure(Call<Void> call, Throwable th) {
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
        this.mapplsGenerateOTP.cancel();
    }

    public boolean isExecuted() {
        return this.mapplsGenerateOTP.executed();
    }
}
