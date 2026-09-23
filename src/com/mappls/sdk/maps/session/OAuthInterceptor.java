package com.mappls.sdk.maps.session;

import com.google.common.net.HttpHeaders;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.auth.MapplsAuthentication;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class OAuthInterceptor implements Interceptor {
    private OkHttpClient httpClient;

    OAuthInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        builderNewBuilder.header(HttpHeaders.ACCEPT, "application/json");
        setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        if (responseProceed.code() == 401 || responseProceed.code() == 400) {
            synchronized (this.httpClient) {
                retrofit2.Response<AtlasAuthToken> responseExecuteCall = MapplsAuthentication.builder().build().executeCall();
                if (responseExecuteCall != null && responseExecuteCall.body() != null) {
                    MapplsAccountManager.getInstance().setAccessToken(responseExecuteCall.body().accessToken);
                }
                if (responseExecuteCall.code() != 200) {
                    return responseProceed;
                }
                if (MapplsAccountManager.getInstance().getAccessToken() != null) {
                    responseProceed.close();
                    setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
                    return chain.proceed(builderNewBuilder.build());
                }
            }
        }
        return responseProceed;
    }

    private void setAuthHeader(Request.Builder builder, String str) {
        builder.header(HttpHeaders.AUTHORIZATION, String.format("bearer %s", str));
    }

    protected void setHttpClient(OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
    }
}
