package com.mappls.sdk.services.api.whitelist;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.MapplsApiConfiguration;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsWhitelistManager {
    private final MapplsWhitelist mapplsWhitelist;

    private MapplsWhitelistManager(MapplsWhitelist mapplsWhitelist) {
        this.mapplsWhitelist = mapplsWhitelist;
    }

    public static MapplsWhitelistManager newInstance(MapplsWhitelist mapplsWhitelist) {
        return new MapplsWhitelistManager(mapplsWhitelist);
    }

    public ApiResponse<Void> executeCall() throws IOException {
        Response<AtlasAuthToken> responseExecute = this.mapplsWhitelist.execute();
        if (responseExecute.code() == 200) {
            AtlasAuthToken atlasAuthTokenBody = responseExecute.body();
            if (atlasAuthTokenBody != null) {
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().setUserId(atlasAuthTokenBody.userId);
                }
                MapplsAccountManager.getInstance().setRefreshToken(atlasAuthTokenBody.refreshToken, atlasAuthTokenBody.accessToken);
                MapplsAccountManager.getInstance().setUserId(atlasAuthTokenBody.userId);
                MapplsApiConfiguration.getInstance().getTokenRepo().setToken(atlasAuthTokenBody.refreshToken);
                return ApiResponse.success(null);
            }
            return ApiResponse.error(responseExecute.code(), "Something went Wrong");
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

    public void call(final OnResponseCallback<Void> onResponseCallback) {
        this.mapplsWhitelist.enqueue(new Callback<AtlasAuthToken>() { // from class: com.mappls.sdk.services.api.whitelist.MapplsWhitelistManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<AtlasAuthToken> call, Response<AtlasAuthToken> response) {
                if (response.code() == 200) {
                    AtlasAuthToken atlasAuthTokenBody = response.body();
                    if (atlasAuthTokenBody != null) {
                        if (MapplsLMSManager.isInitialised()) {
                            MapplsLMSManager.getInstance().setUserId(atlasAuthTokenBody.userId);
                        }
                        MapplsAccountManager.getInstance().setRefreshToken(atlasAuthTokenBody.refreshToken, atlasAuthTokenBody.accessToken);
                        MapplsAccountManager.getInstance().setUserId(atlasAuthTokenBody.userId);
                        MapplsApiConfiguration.getInstance().getTokenRepo().setToken(atlasAuthTokenBody.refreshToken);
                        onResponseCallback.onSuccess(null);
                        return;
                    }
                    onResponseCallback.onError(response.code(), "");
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
            public void onFailure(Call<AtlasAuthToken> call, Throwable th) {
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
        this.mapplsWhitelist.cancel();
    }

    public boolean isExecuted() {
        return this.mapplsWhitelist.executed();
    }
}
