package com.mappls.sdk.services.api;

import com.mappls.sdk.services.utils.ApiCallHelper;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class AnalyticsInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request.newBuilder().headers(request.headers().newBuilder().addUnsafeNonAscii("x-sa", ApiCallHelper.getAnalyticsHeader(MapplsApiConfiguration.getInstance().getLocation(), MapplsApiConfiguration.getInstance().isNavigating())).build()).build());
    }
}
