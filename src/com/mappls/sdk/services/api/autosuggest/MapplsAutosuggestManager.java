package com.mappls.sdk.services.api.autosuggest;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsAutosuggestManager {
    private MapplsAutoSuggest mapplsAutoSuggest;

    private MapplsAutosuggestManager(MapplsAutoSuggest mapplsAutoSuggest) {
        this.mapplsAutoSuggest = mapplsAutoSuggest;
    }

    public static MapplsAutosuggestManager newInstance(MapplsAutoSuggest mapplsAutoSuggest) {
        return new MapplsAutosuggestManager(mapplsAutoSuggest);
    }

    @Deprecated
    public AutoSuggestAtlasResponse execute() throws IOException {
        return this.mapplsAutoSuggest.execute().body();
    }

    public ApiResponse<AutoSuggestAtlasResponse> executeCall() throws IOException {
        Response<AutoSuggestAtlasResponse> responseExecute = this.mapplsAutoSuggest.execute();
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

    public void call(final OnResponseCallback<AutoSuggestAtlasResponse> onResponseCallback) {
        this.mapplsAutoSuggest.enqueue(new Callback<AutoSuggestAtlasResponse>() { // from class: com.mappls.sdk.services.api.autosuggest.MapplsAutosuggestManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<AutoSuggestAtlasResponse> call, Response<AutoSuggestAtlasResponse> response) {
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
            public void onFailure(Call<AutoSuggestAtlasResponse> call, Throwable th) {
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
        this.mapplsAutoSuggest.cancel();
    }

    public boolean isExecuted() {
        return this.mapplsAutoSuggest.executed();
    }
}
