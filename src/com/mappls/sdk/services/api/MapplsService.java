package com.mappls.sdk.services.api;

import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.google.common.net.HttpHeaders;
import com.google.gson.GsonBuilder;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.auth.MapplsAuthentication;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import com.mappls.sdk.services.log.LoggerUtils;
import com.mappls.sdk.services.utils.ApiCallHelper;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.http.conn.ConnectTimeoutException;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsService<T, S> {
    protected static final int MAX_URL_SIZE = 8192;
    protected static OkHttpClient atlasOkHttpClient;
    protected static OkHttpClient loginAtlasOkHttpClient;
    protected static OkHttpClient loginOkHttpClient;
    protected static OkHttpClient okHttpClient;
    protected static OkHttpClient plainOkHttpClient;
    private Call<T> call;
    private okhttp3.Call.Factory callFactory;
    private final boolean enableDebug = false;
    HostnameVerifier hostnameVerifier = new HostnameVerifier() { // from class: com.mappls.sdk.services.api.MapplsService.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (!MapplsAccountManager.getInstance().isDisableHostnameVerifier()) {
                return true;
            }
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates == null || peerCertificates.length == 0 || !str.equalsIgnoreCase(sSLSession.getPeerHost())) {
                    return false;
                }
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init((KeyStore) null);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    if (trustManagers.length == 1) {
                        TrustManager trustManager = trustManagers[0];
                        if (trustManager instanceof X509TrustManager) {
                            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                            for (Certificate certificate : peerCertificates) {
                                x509TrustManager.checkServerTrusted(new X509Certificate[]{(X509Certificate) certificate}, "RSA");
                            }
                            return true;
                        }
                    }
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SSLPeerUnverifiedException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    };
    private Retrofit retrofit;
    private S service;
    private final Class<S> serviceType;

    protected abstract String baseUrl();

    protected abstract Call<T> initializeCall();

    public boolean isEnableDebug() {
        return false;
    }

    public MapplsService(Class<S> cls) {
        this.serviceType = cls;
    }

    static void initProxy() {
        okHttpClient = null;
        atlasOkHttpClient = null;
        loginAtlasOkHttpClient = null;
        loginOkHttpClient = null;
    }

    static void initTimeOut() {
        loginAtlasOkHttpClient = null;
        loginOkHttpClient = null;
    }

    protected Call<T> getCall() {
        if (this.call == null) {
            this.call = initializeCall();
        }
        return this.call;
    }

    protected Response<T> executeCall() throws IOException {
        return getCall().execute();
    }

    protected void enqueueCall(Callback<T> callback) {
        getCall().enqueue(callback);
    }

    protected void cancelCall() {
        getCall().cancel();
    }

    protected Call<T> cloneCall() {
        return getCall().clone();
    }

    protected boolean isExecuted() {
        return getCall().isExecuted();
    }

    protected S getService(boolean z) throws InvalidKeyException, InvalidAlgorithmParameterException {
        S s = this.service;
        if (s != null) {
            return s;
        }
        Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().baseUrl(baseUrl()).addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()));
        Iterator<CallAdapter.Factory> it2 = getCallAdapterFactory().iterator();
        while (it2.hasNext()) {
            builderAddConverterFactory.addCallAdapterFactory(it2.next());
        }
        if (MapplsApiConfiguration.getInstance().getCertificateHash() == null && SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getSDKConfigData() != null) {
            if (SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getSDKConfigDownloadTime().longValue() + 604800000 < System.currentTimeMillis()) {
                MapplsApiConfiguration.getInstance().setValidationData(null);
                SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(null);
            } else {
                MapplsApiConfiguration.getInstance().setValidationData(SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).getSDKConfigData());
                if (MapplsApiConfiguration.getInstance().getExpiry().longValue() * 1000 <= System.currentTimeMillis()) {
                    MapplsApiConfiguration.getInstance().setValidationData(null);
                    SDKPreferenceHelper.getInstance(MapplsUtils.getSDKContext()).setSDKConfigData(null);
                }
            }
        }
        if (getCallFactory() != null) {
            builderAddConverterFactory.callFactory(getCallFactory());
        } else {
            builderAddConverterFactory.client(z ? getAtlasOkHttpClient() : getOkHttpClient());
        }
        Retrofit retrofitBuild = builderAddConverterFactory.build();
        this.retrofit = retrofitBuild;
        S s2 = (S) retrofitBuild.create(this.serviceType);
        this.service = s2;
        return s2;
    }

    protected S getPlainService() {
        S s = this.service;
        if (s != null) {
            return s;
        }
        Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().baseUrl(baseUrl()).addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()));
        builderAddConverterFactory.client(getPlainOkHttpClient());
        Retrofit retrofitBuild = builderAddConverterFactory.build();
        this.retrofit = retrofitBuild;
        S s2 = (S) retrofitBuild.create(this.serviceType);
        this.service = s2;
        return s2;
    }

    protected S getLoginService(boolean z) {
        S s = this.service;
        if (s != null) {
            return s;
        }
        Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().baseUrl(baseUrl()).addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()));
        Iterator<CallAdapter.Factory> it2 = getCallAdapterFactory().iterator();
        while (it2.hasNext()) {
            builderAddConverterFactory.addCallAdapterFactory(it2.next());
        }
        if (getCallFactory() != null) {
            builderAddConverterFactory.callFactory(getCallFactory());
        } else {
            builderAddConverterFactory.client(z ? getLoginAtlasOkHttpClient() : getLoginOkHttpClient());
        }
        Retrofit retrofitBuild = builderAddConverterFactory.build();
        this.retrofit = retrofitBuild;
        S s2 = (S) retrofitBuild.create(this.serviceType);
        this.service = s2;
        return s2;
    }

    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    protected List<CallAdapter.Factory> getCallAdapterFactory() {
        return new ArrayList();
    }

    public okhttp3.Call.Factory getCallFactory() {
        return this.callFactory;
    }

    public void setCallFactory(okhttp3.Call.Factory factory) {
        this.callFactory = factory;
    }

    protected synchronized OkHttpClient getPlainOkHttpClient() {
        if (plainOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new UserAgentInterceptor());
            if (MapplsApiConfiguration.getInstance().proxyHost != null) {
                builder.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsApiConfiguration.getInstance().proxyHost, MapplsApiConfiguration.getInstance().proxyPort.intValue())));
            }
            builder.hostnameVerifier(this.hostnameVerifier);
            builder.retryOnConnectionFailure(false);
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            plainOkHttpClient = builder.build();
        }
        return plainOkHttpClient;
    }

    protected synchronized OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            SDKConfigInterceptor sDKConfigInterceptor = new SDKConfigInterceptor();
            builder.addInterceptor(new UserAgentInterceptor());
            builder.addInterceptor(new RegionInterceptor());
            builder.addInterceptor(sDKConfigInterceptor);
            if (MapplsApiConfiguration.getInstance().proxyHost != null) {
                builder.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsApiConfiguration.getInstance().proxyHost, MapplsApiConfiguration.getInstance().proxyPort.intValue())));
            }
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            builder.retryOnConnectionFailure(false);
            if (MapplsApiConfiguration.getInstance().getCertificateHash() != null) {
                CertificatePinner.Builder builder2 = new CertificatePinner.Builder();
                Iterator<String> it2 = MapplsApiConfiguration.getInstance().getCertificateHash().iterator();
                while (it2.hasNext()) {
                    builder2.add("*.mappls.com", "sha256/" + it2.next());
                }
                builder.certificatePinner(builder2.build());
            } else {
                builder.hostnameVerifier(this.hostnameVerifier);
            }
            OkHttpClient okHttpClientBuild = builder.build();
            okHttpClient = okHttpClientBuild;
            sDKConfigInterceptor.setOkHttpClient(okHttpClientBuild);
        }
        return okHttpClient;
    }

    protected synchronized OkHttpClient getLoginOkHttpClient() {
        if (loginOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            InitialiserInterceptor initialiserInterceptor = new InitialiserInterceptor();
            SDKConfigInterceptor sDKConfigInterceptor = new SDKConfigInterceptor();
            builder.addInterceptor(new UserAgentInterceptor());
            builder.addInterceptor(new AnalyticsInterceptor());
            builder.addInterceptor(sDKConfigInterceptor);
            builder.addInterceptor(initialiserInterceptor);
            builder.addInterceptor(new RegionInterceptor());
            builder.addInterceptor(new AddParametersInterceptor());
            if (MapplsApiConfiguration.getInstance().proxyHost != null) {
                builder.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsApiConfiguration.getInstance().proxyHost, MapplsApiConfiguration.getInstance().proxyPort.intValue())));
            }
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            builder.retryOnConnectionFailure(false);
            builder.callTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            builder.connectTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            builder.readTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            builder.writeTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            if (MapplsApiConfiguration.getInstance().getCertificateHash() != null) {
                CertificatePinner.Builder builder2 = new CertificatePinner.Builder();
                Iterator<String> it2 = MapplsApiConfiguration.getInstance().getCertificateHash().iterator();
                while (it2.hasNext()) {
                    builder2.add("*.mappls.com", "sha256/" + it2.next());
                }
                builder.certificatePinner(builder2.build());
            } else {
                builder.hostnameVerifier(this.hostnameVerifier);
            }
            OkHttpClient okHttpClientBuild = builder.build();
            loginOkHttpClient = okHttpClientBuild;
            initialiserInterceptor.setHttpClient(okHttpClientBuild);
            sDKConfigInterceptor.setOkHttpClient(loginOkHttpClient);
        }
        return loginOkHttpClient;
    }

    protected synchronized OkHttpClient getAtlasOkHttpClient() {
        if (atlasOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OAuthInterceptor oAuthInterceptor = new OAuthInterceptor();
            SDKConfigInterceptor sDKConfigInterceptor = new SDKConfigInterceptor();
            builder.addInterceptor(new UserAgentInterceptor());
            builder.addInterceptor(sDKConfigInterceptor);
            builder.addInterceptor(oAuthInterceptor);
            builder.addInterceptor(new RegionInterceptor());
            if (MapplsApiConfiguration.getInstance().proxyHost != null) {
                builder.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsApiConfiguration.getInstance().proxyHost, MapplsApiConfiguration.getInstance().proxyPort.intValue())));
            }
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            builder.retryOnConnectionFailure(false);
            if (MapplsApiConfiguration.getInstance().getCertificateHash() != null) {
                CertificatePinner.Builder builder2 = new CertificatePinner.Builder();
                Iterator<String> it2 = MapplsApiConfiguration.getInstance().getCertificateHash().iterator();
                while (it2.hasNext()) {
                    builder2.add("*.mappls.com", "sha256/" + it2.next());
                }
                builder.certificatePinner(builder2.build());
            } else {
                builder.hostnameVerifier(this.hostnameVerifier);
            }
            OkHttpClient okHttpClientBuild = builder.build();
            atlasOkHttpClient = okHttpClientBuild;
            oAuthInterceptor.setHttpClient(okHttpClientBuild);
            sDKConfigInterceptor.setOkHttpClient(atlasOkHttpClient);
        }
        return atlasOkHttpClient;
    }

    protected synchronized OkHttpClient getLoginAtlasOkHttpClient() {
        if (loginAtlasOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            LoginOAuthInterceptor loginOAuthInterceptor = new LoginOAuthInterceptor();
            InitialiserInterceptor initialiserInterceptor = new InitialiserInterceptor();
            SDKConfigInterceptor sDKConfigInterceptor = new SDKConfigInterceptor();
            builder.addInterceptor(new UserAgentInterceptor());
            builder.addInterceptor(new AnalyticsInterceptor());
            builder.addInterceptor(sDKConfigInterceptor);
            builder.addInterceptor(initialiserInterceptor);
            builder.addInterceptor(loginOAuthInterceptor);
            builder.addInterceptor(new RegionInterceptor());
            builder.addInterceptor(new AddParametersInterceptor());
            if (MapplsApiConfiguration.getInstance().proxyHost != null) {
                builder.proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsApiConfiguration.getInstance().proxyHost, MapplsApiConfiguration.getInstance().proxyPort.intValue())));
            }
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            builder.retryOnConnectionFailure(false);
            builder.callTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            builder.connectTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            builder.readTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            builder.writeTimeout(MapplsApiConfiguration.getInstance().timeOut, TimeUnit.SECONDS);
            if (MapplsApiConfiguration.getInstance().getCertificateHash() != null) {
                CertificatePinner.Builder builder2 = new CertificatePinner.Builder();
                Iterator<String> it2 = MapplsApiConfiguration.getInstance().getCertificateHash().iterator();
                while (it2.hasNext()) {
                    builder2.add("*.mappls.com", "sha256/" + it2.next());
                }
                builder.certificatePinner(builder2.build());
            } else {
                builder.hostnameVerifier(this.hostnameVerifier);
            }
            OkHttpClient okHttpClientBuild = builder.build();
            loginAtlasOkHttpClient = okHttpClientBuild;
            initialiserInterceptor.setHttpClient(okHttpClientBuild);
            loginOAuthInterceptor.setHttpClient(loginAtlasOkHttpClient);
            sDKConfigInterceptor.setOkHttpClient(loginAtlasOkHttpClient);
        }
        return loginAtlasOkHttpClient;
    }

    private static class UserAgentInterceptor implements Interceptor {
        private UserAgentInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            return chain.proceed(request.newBuilder().headers(request.headers().newBuilder().removeAll(HttpHeaders.USER_AGENT).addUnsafeNonAscii(HttpHeaders.USER_AGENT, ApiCallHelper.getHeaderUserAgent()).build()).build());
        }
    }

    private static class OAuthInterceptor implements Interceptor {
        private OkHttpClient httpClient;

        OAuthInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            String host = request.url().url().getHost();
            if (host.contains("127.0.") || host.contains(AndroidInfoHelpers.DEVICE_LOCALHOST)) {
                return chain.proceed(request);
            }
            Request.Builder builderNewBuilder = request.newBuilder();
            builderNewBuilder.header(HttpHeaders.ACCEPT, "application/json");
            if (MapplsAccountManager.getInstance().getAccessToken() == null) {
                synchronized (this.httpClient) {
                    if (MapplsAccountManager.getInstance().getAccessToken() == null) {
                        try {
                            Response<AtlasAuthToken> responseExecuteCall = MapplsAuthentication.builder().build().executeCall();
                            if (responseExecuteCall.code() == 200 && responseExecuteCall.body() != null) {
                                if (MapplsLMSManager.isInitialised()) {
                                    if (responseExecuteCall.body().projectCode != null) {
                                        MapplsLMSManager.getInstance().setProjectCode(responseExecuteCall.body().projectCode);
                                    }
                                    if (responseExecuteCall.body().clientId != null) {
                                        MapplsLMSManager.getInstance().setClientId(responseExecuteCall.body().clientId);
                                    }
                                }
                                LoggerUtils.e("OAuthInterceptor", String.format(Locale.US, "Authentication API Success: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall.code()), responseExecuteCall.body().accessToken));
                                MapplsAccountManager.getInstance().setAccessToken(responseExecuteCall.body().accessToken);
                            } else {
                                LoggerUtils.e("OAuthInterceptor", String.format(Locale.US, "Authentication API: Failure Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall.code()), responseExecuteCall.message()));
                                return new okhttp3.Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                            }
                        } catch (SocketTimeoutException e) {
                            e = e;
                            LoggerUtils.e("OAuthInterceptor", e.getMessage(), e);
                            return new okhttp3.Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        } catch (SSLHandshakeException e2) {
                            e = e2;
                            LoggerUtils.e("OAuthInterceptor", e.getMessage(), e);
                            return new okhttp3.Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        } catch (ConnectTimeoutException e3) {
                            e = e3;
                            LoggerUtils.e("OAuthInterceptor", e.getMessage(), e);
                            return new okhttp3.Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        }
                    }
                    setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
                    return chain.proceed(builderNewBuilder.build());
                }
            }
            String accessToken = MapplsAccountManager.getInstance().getAccessToken();
            setAuthHeader(builderNewBuilder, accessToken);
            Request requestBuild = builderNewBuilder.build();
            okhttp3.Response responseProceed = chain.proceed(requestBuild);
            if (responseProceed.code() == 401) {
                synchronized (this.httpClient) {
                    String accessToken2 = MapplsAccountManager.getInstance().getAccessToken();
                    if (accessToken2 == null || accessToken2.equalsIgnoreCase(accessToken)) {
                        Response<AtlasAuthToken> responseExecuteCall2 = MapplsAuthentication.builder().build().executeCall();
                        if (responseExecuteCall2.code() == 200 && responseExecuteCall2.body() != null) {
                            if (MapplsLMSManager.isInitialised()) {
                                if (responseExecuteCall2.body().projectCode != null) {
                                    MapplsLMSManager.getInstance().setProjectCode(responseExecuteCall2.body().projectCode);
                                }
                                if (responseExecuteCall2.body().clientId != null) {
                                    MapplsLMSManager.getInstance().setClientId(responseExecuteCall2.body().clientId);
                                }
                            }
                            MapplsAccountManager.getInstance().setAccessToken(responseExecuteCall2.body().accessToken);
                        } else {
                            LoggerUtils.e("OAuthInterceptor", String.format(Locale.US, "Authentication API: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall2.code()), responseExecuteCall2.message()));
                            return new okhttp3.Response.Builder().request(requestBuild).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        }
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
}
