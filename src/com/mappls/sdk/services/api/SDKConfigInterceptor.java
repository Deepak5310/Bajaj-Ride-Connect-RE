package com.mappls.sdk.services.api;

import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.mappls.sdk.services.api.sdkconfig.MapplsSDKConfig;
import com.mappls.sdk.services.api.sdkconfig.model.SDKConfigResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
public class SDKConfigInterceptor implements Interceptor {
    private OkHttpClient okHttpClient;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        Request request = chain.request();
        String host = request.url().url().getHost();
        if (host.contains("127.0.") || host.contains(AndroidInfoHelpers.DEVICE_LOCALHOST)) {
            return chain.proceed(request);
        }
        if (SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getSDKConfigDownloadTime().longValue() + 604800000 < System.currentTimeMillis()) {
            MapplsApiConfiguration.getInstance().setValidationData(null);
            SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(null);
        }
        if (MapplsApiConfiguration.getInstance().getExpiry() == null) {
            synchronized (this.okHttpClient) {
                if (MapplsApiConfiguration.getInstance().getExpiry() == null) {
                    if (SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getSDKConfigData() == null) {
                        retrofit2.Response<SDKConfigResponse> responseExecuteCall = MapplsSDKConfig.builder().configUrl("https://sdkconfig.mappls.com/SSL/config_prod_1.0.0.json").build().executeCall();
                        if (responseExecuteCall.code() == 200 && responseExecuteCall.body() != null) {
                            SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigDownloadTime(Long.valueOf(System.currentTimeMillis()));
                            SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(responseExecuteCall.body().getData());
                            MapplsApiConfiguration.getInstance().setValidationData(responseExecuteCall.body().getData());
                            if (MapplsApiConfiguration.getInstance().getExpiry().longValue() * 1000 <= System.currentTimeMillis()) {
                                SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(null);
                                MapplsApiConfiguration.getInstance().setValidationData(null);
                                return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(10).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK is not Configured").message("SDK is not Configured").build();
                            }
                        } else {
                            return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(10).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK is not Configured").message("SDK is not Configured").build();
                        }
                    } else {
                        MapplsApiConfiguration.getInstance().setValidationData(SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getSDKConfigData());
                        if (MapplsApiConfiguration.getInstance().getExpiry().longValue() * 1000 <= System.currentTimeMillis()) {
                            SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(null);
                            MapplsApiConfiguration.getInstance().setValidationData(null);
                        }
                    }
                }
            }
        }
        if (MapplsApiConfiguration.getInstance().getExpiry() == null || MapplsApiConfiguration.getInstance().getExpiry().longValue() * 1000 <= System.currentTimeMillis()) {
            synchronized (this.okHttpClient) {
                if (MapplsApiConfiguration.getInstance().getExpiry() == null || MapplsApiConfiguration.getInstance().getExpiry().longValue() * 1000 <= System.currentTimeMillis()) {
                    retrofit2.Response<SDKConfigResponse> responseExecuteCall2 = MapplsSDKConfig.builder().configUrl("https://sdkconfig.mappls.com/SSL/config_prod_1.0.0.json").build().executeCall();
                    if (responseExecuteCall2.code() == 200 && responseExecuteCall2.body() != null) {
                        SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigDownloadTime(Long.valueOf(System.currentTimeMillis()));
                        SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(responseExecuteCall2.body().getData());
                        MapplsApiConfiguration.getInstance().setValidationData(responseExecuteCall2.body().getData());
                        if (MapplsApiConfiguration.getInstance().getExpiry().longValue() * 1000 <= System.currentTimeMillis()) {
                            SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(null);
                            MapplsApiConfiguration.getInstance().setValidationData(null);
                            return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(10).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK is not Configured").message("SDK is not Configured").build();
                        }
                    } else {
                        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(10).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK is not configured").message("SDK is not configured").build();
                    }
                }
            }
        }
        String url = request.url().getUrl();
        if (url.contains(Constants.ADVANCE_MAP_BASE_URL)) {
            url = url.replace(Constants.ADVANCE_MAP_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getApisUrl());
        } else if (url.contains(Constants.ANCHOR_BASE_URL)) {
            url = url.replace(Constants.ANCHOR_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getAnchorUrl());
        } else if (url.contains(Constants.OUTPOST_BASE_URL)) {
            url = url.replace(Constants.OUTPOST_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getOutpostUrl());
        } else if (url.contains(Constants.ATLAS_BASE_URL)) {
            url = url.replace(Constants.ATLAS_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getAtlasUrl());
        } else if (url.contains(Constants.EXPLORE_BASE_URL)) {
            url = url.replace(Constants.EXPLORE_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getExploreUrl());
        } else if (url.contains(Constants.TRAFFIC_BASE_URL)) {
            url = url.replace(Constants.TRAFFIC_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getTrafficUrl());
        } else if (url.contains(Constants.MGIS_BASE_URL)) {
            url = url.replace(Constants.MGIS_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getMgisUrl());
        } else if (url.contains(Constants.MGIS_APIS_BASE_URL)) {
            url = url.replace(Constants.MGIS_APIS_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getMgisApiUrl());
        } else if (url.contains(Constants.INTOUCH_BASE_URL)) {
            url = url.replace(Constants.INTOUCH_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getIntouchUrl());
        } else if (url.contains(Constants.GEOANALYTICS_BASE_URL)) {
            url = url.replace(Constants.GEOANALYTICS_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getGeoanalyticsUrl());
        } else if (url.contains(Constants.BACKEND_API_BASE_URL) && MapplsApiConfiguration.getInstance().getUrlData().getBackendUrl() != null) {
            url = url.replace(Constants.BACKEND_API_BASE_URL, MapplsApiConfiguration.getInstance().getUrlData().getBackendUrl());
        }
        return chain.proceed(request.newBuilder().url(url).build());
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }
}
