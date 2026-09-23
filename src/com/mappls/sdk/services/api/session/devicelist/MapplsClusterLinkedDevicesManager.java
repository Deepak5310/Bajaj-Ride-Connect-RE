package com.mappls.sdk.services.api.session.devicelist;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.session.devicelist.model.Device;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsClusterLinkedDevicesManager {
    private final MapplsClusterLinkedDevices mapplsClusterLinkedDevices;

    private MapplsClusterLinkedDevicesManager(MapplsClusterLinkedDevices mapplsClusterLinkedDevices) {
        this.mapplsClusterLinkedDevices = mapplsClusterLinkedDevices;
    }

    public static MapplsClusterLinkedDevicesManager newInstance(MapplsClusterLinkedDevices mapplsClusterLinkedDevices) {
        return new MapplsClusterLinkedDevicesManager(mapplsClusterLinkedDevices);
    }

    @Deprecated
    public List<Device> execute() throws IOException {
        return this.mapplsClusterLinkedDevices.execute().body();
    }

    public ApiResponse<List<Device>> executeCall() throws IOException {
        Response<List<Device>> responseExecute = this.mapplsClusterLinkedDevices.execute();
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

    public void call(final OnResponseCallback<List<Device>> onResponseCallback) {
        this.mapplsClusterLinkedDevices.enqueue(new Callback<List<Device>>() { // from class: com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevicesManager.1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
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
            public void onFailure(Call<List<Device>> call, Throwable th) {
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
        this.mapplsClusterLinkedDevices.cancel();
    }

    public boolean isExecuted() {
        return this.mapplsClusterLinkedDevices.executed();
    }
}
