package com.mappls.sdk.maps.module.http;

import com.mappls.sdk.maps.MapplsMapConfiguration;
import com.mappls.sdk.maps.auth.MapplsVectorKey;
import com.mappls.sdk.maps.auth.model.PublicKeyToken;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
class PublicKeyInterceptor implements Interceptor {
    private static long timestamp;
    private OkHttpClient okHttpClient;

    PublicKeyInterceptor() {
    }

    public static void logout() {
        timestamp = 0L;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().getUrl();
        if (!MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
            if (MapplsMapManager.getInstance().getRawPublicKey() == null) {
                synchronized (this.okHttpClient) {
                    if (MapplsMapManager.getInstance().getRawPublicKey() == null) {
                        retrofit2.Response<PublicKeyToken> responseExecuteCall = MapplsVectorKey.builder().build().executeCall();
                        if (responseExecuteCall.code() == 200 && responseExecuteCall.body() != null) {
                            MapplsMapManager.getInstance().setRawPublicKey(responseExecuteCall.body().getPublicKey());
                            VTAuthentication.getInstance().clearKey();
                        } else {
                            return new Response.Builder().request(request).code(responseExecuteCall.code()).body(responseExecuteCall.errorBody()).protocol(Protocol.HTTP_1_0).message(responseExecuteCall.message()).headers(responseExecuteCall.headers()).build();
                        }
                    }
                    return chain.proceed(request);
                }
            }
            if (url.contains("vectorTiles") || url.contains("/vector_tile/") || url.contains("/map_tile/")) {
                Response responseProceed = chain.proceed(request);
                if (responseProceed.code() > 399 && responseProceed.code() < 500 && ((MapplsMapManager.getInstance().getRawPublicKey() == null || responseProceed.code() == 422 || responseProceed.code() == 409) && System.currentTimeMillis() - timestamp > 2000)) {
                    Timber.d("request failed with %d", Integer.valueOf(responseProceed.code()));
                    timestamp = System.currentTimeMillis();
                    String rawPublicKey = MapplsMapManager.getInstance().getRawPublicKey();
                    synchronized (this.okHttpClient) {
                        String rawPublicKey2 = MapplsMapManager.getInstance().getRawPublicKey();
                        if (MapplsMapManager.getInstance().getRawPublicKey() == null || rawPublicKey2.equalsIgnoreCase(rawPublicKey)) {
                            retrofit2.Response<PublicKeyToken> responseExecuteCall2 = MapplsVectorKey.builder().build().executeCall();
                            if (responseExecuteCall2.code() == 200 && responseExecuteCall2.body() != null) {
                                MapplsMapManager.getInstance().setRawPublicKey(responseExecuteCall2.body().getPublicKey());
                                VTAuthentication.getInstance().clearKey();
                            } else {
                                return new Response.Builder().request(request).code(responseExecuteCall2.code()).body(responseExecuteCall2.errorBody()).protocol(Protocol.HTTP_1_0).message(responseExecuteCall2.message()).headers(responseExecuteCall2.headers()).build();
                            }
                        }
                    }
                }
                return responseProceed;
            }
        }
        return chain.proceed(request);
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public void setClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }
}
