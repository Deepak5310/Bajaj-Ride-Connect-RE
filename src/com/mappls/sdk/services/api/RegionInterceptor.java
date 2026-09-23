package com.mappls.sdk.services.api;

import com.mappls.sdk.services.account.MapplsAccountManager;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class RegionInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (MapplsAccountManager.getInstance().getRegion() != null) {
            request = request.newBuilder().url(request.url().newBuilder().setQueryParameter("region", MapplsAccountManager.getInstance().getRegion()).toString()).build();
        }
        return chain.proceed(request);
    }
}
