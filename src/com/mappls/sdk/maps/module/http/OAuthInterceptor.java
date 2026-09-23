package com.mappls.sdk.maps.module.http;

import com.google.common.net.HttpHeaders;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.auth.MapplsAuthentication;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
class OAuthInterceptor implements Interceptor {
    private OkHttpClient httpClient;

    OAuthInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        builderNewBuilder.header(HttpHeaders.ACCEPT, "application/json");
        synchronized (this.httpClient) {
            if (MapplsAccountManager.getInstance().getAccessToken() == null) {
                retrofit2.Response<AtlasAuthToken> responseExecuteCall = MapplsAuthentication.builder().build().executeCall();
                if (responseExecuteCall != null && responseExecuteCall.body() != null) {
                    MapplsAccountManager.getInstance().setAccessToken(responseExecuteCall.body().accessToken);
                }
                if (responseExecuteCall.code() != 200) {
                    return new Response.Builder().request(request).code(responseExecuteCall.code()).body(responseExecuteCall.errorBody()).protocol(Protocol.HTTP_1_0).message(responseExecuteCall.message()).headers(responseExecuteCall.headers()).build();
                }
            }
            setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
            Response responseProceed = chain.proceed(builderNewBuilder.build());
            if (responseProceed.code() == 401 || responseProceed.code() == 400) {
                retrofit2.Response<AtlasAuthToken> responseExecuteCall2 = MapplsAuthentication.builder().build().executeCall();
                if (responseExecuteCall2 != null && responseExecuteCall2.body() != null) {
                    MapplsAccountManager.getInstance().setAccessToken(responseExecuteCall2.body().accessToken);
                }
                if (responseExecuteCall2.code() != 200) {
                    return responseProceed;
                }
                if (MapplsAccountManager.getInstance().getAccessToken() != null) {
                    responseProceed.close();
                    setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
                    return chain.proceed(builderNewBuilder.build());
                }
            }
            return responseProceed;
        }
    }

    private void setAuthHeader(Request.Builder builder, String str) {
        builder.header(HttpHeaders.AUTHORIZATION, String.format("bearer %s", str));
    }

    OkHttpClient getOkHttpClient() {
        return this.httpClient;
    }

    void setOkHttpClient(OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
    }
}
