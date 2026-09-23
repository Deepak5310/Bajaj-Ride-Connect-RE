package com.mappls.sdk.navigation.apis.web;

import com.google.gson.GsonBuilder;
import com.mappls.sdk.services.api.MapplsApiConfiguration;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static b d = new b();
    private a a = null;
    private OkHttpClient.Builder b;
    private Retrofit.Builder c;

    private b() {
        new OkHttpClient.Builder();
        this.b = new OkHttpClient.Builder();
        this.c = null;
    }

    public static b a() {
        return d;
    }

    public final a b() {
        if (this.a == null) {
            OkHttpClient.Builder builder = this.b;
            long j = 60;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.readTimeout(j, timeUnit);
            this.b.connectTimeout(j, timeUnit);
            if (MapplsApiConfiguration.getInstance().getProxyHost() != null) {
                this.b.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsApiConfiguration.getInstance().getProxyHost(), MapplsApiConfiguration.getInstance().getProxyPort())));
            }
            OkHttpClient okHttpClientBuild = this.b.build();
            if (this.c == null) {
                this.c = new Retrofit.Builder().baseUrl("https://outpost.mappls.com/api/security/").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()));
            }
            this.a = (a) this.c.client(okHttpClientBuild).build().create(a.class);
        }
        return this.a;
    }
}
