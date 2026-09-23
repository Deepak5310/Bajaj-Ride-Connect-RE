package com.mappls.sdk.services.api;

import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.google.common.net.HttpHeaders;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.auth.MapplsAuthentication;
import com.mappls.sdk.services.api.auth.model.AtlasAuthToken;
import com.mappls.sdk.services.log.LoggerUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Locale;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.conn.ConnectTimeoutException;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class LoginOAuthInterceptor implements Interceptor {
    private OkHttpClient httpClient;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Timber.tag("APICalls").d("LoginOAuthInterceptor->intercept", new Object[0]);
        Request request = chain.request();
        String host = request.url().url().getHost();
        if (host.contains("127.0.") || host.contains(AndroidInfoHelpers.DEVICE_LOCALHOST)) {
            return chain.proceed(request);
        }
        if (MapplsApiConfiguration.getInstance().isLoginRequired() == null) {
            return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(8).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK not initialised").message("SDK not initialised").build();
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        builderNewBuilder.header(HttpHeaders.ACCEPT, "application/json");
        if (MapplsApiConfiguration.getInstance().isLoginRequired() == null || !MapplsApiConfiguration.getInstance().isLoginRequired().booleanValue()) {
            if (MapplsAccountManager.getInstance().getAccessToken() == null) {
                synchronized (this.httpClient) {
                    if (MapplsApiConfiguration.getInstance().isLoginRequired() == null) {
                        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(8).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK not initialised").message("SDK not initialised").build();
                    }
                    if (MapplsAccountManager.getInstance().getAccessToken() == null) {
                        try {
                            retrofit2.Response<AtlasAuthToken> responseExecuteCall = MapplsAuthentication.builder().build().executeCall();
                            if (responseExecuteCall.code() == 200 && responseExecuteCall.body() != null) {
                                if (MapplsLMSManager.isInitialised()) {
                                    if (responseExecuteCall.body().projectCode != null) {
                                        MapplsLMSManager.getInstance().setProjectCode(responseExecuteCall.body().projectCode);
                                    }
                                    if (responseExecuteCall.body().clientId != null) {
                                        MapplsLMSManager.getInstance().setClientId(responseExecuteCall.body().clientId);
                                    }
                                }
                                LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Authentication API Success: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall.code()), responseExecuteCall.body().accessToken));
                                MapplsAccountManager.getInstance().setAccessToken(responseExecuteCall.body().accessToken);
                            } else {
                                LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Authentication API Failure: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall.code()), responseExecuteCall.message()));
                                return new Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                            }
                        } catch (SocketTimeoutException e) {
                            e = e;
                            LoggerUtils.e("OAuthInterceptor", e.getMessage(), e);
                            return new Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        } catch (SSLHandshakeException e2) {
                            e = e2;
                            LoggerUtils.e("OAuthInterceptor", e.getMessage(), e);
                            return new Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        } catch (ConnectTimeoutException e3) {
                            e = e3;
                            LoggerUtils.e("OAuthInterceptor", e.getMessage(), e);
                            return new Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        }
                    }
                    setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
                    return chain.proceed(builderNewBuilder.build());
                }
            }
            String accessToken = MapplsAccountManager.getInstance().getAccessToken();
            setAuthHeader(builderNewBuilder, accessToken);
            Request requestBuild = builderNewBuilder.build();
            Response responseProceed = chain.proceed(requestBuild);
            if (responseProceed.code() == 401) {
                synchronized (this.httpClient) {
                    String accessToken2 = MapplsAccountManager.getInstance().getAccessToken();
                    if (accessToken2 == null || accessToken2.equalsIgnoreCase(accessToken)) {
                        retrofit2.Response<AtlasAuthToken> responseExecuteCall2 = MapplsAuthentication.builder().build().executeCall();
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
                            LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Authentication API: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall2.code()), responseExecuteCall2.message()));
                            return new Response.Builder().request(requestBuild).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
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
        if (MapplsAccountManager.getInstance().getRefreshToken() == null) {
            return new Response.Builder().request(request).code(101).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Whitelisting Required").header(StackTraceHelper.MESSAGE_KEY, "User Whitelisting Required").build();
        }
        if (MapplsAccountManager.getInstance().getAccessToken() == null) {
            synchronized (this.httpClient) {
                if (MapplsAccountManager.getInstance().getAccessToken() == null) {
                    retrofit2.Response<AtlasAuthToken> responseExecuteCall3 = MapplsAuthentication.builder().refreshToken(MapplsAccountManager.getInstance().getRefreshToken()).grantType("refresh_token").build().executeCall();
                    if (responseExecuteCall3.code() == 200 && responseExecuteCall3.body() != null) {
                        if (MapplsLMSManager.isInitialised()) {
                            if (responseExecuteCall3.body().projectCode != null) {
                                MapplsLMSManager.getInstance().setProjectCode(responseExecuteCall3.body().projectCode);
                            }
                            if (responseExecuteCall3.body().clientId != null) {
                                MapplsLMSManager.getInstance().setClientId(responseExecuteCall3.body().clientId);
                            }
                            MapplsLMSManager.getInstance().setUserId(responseExecuteCall3.body().userId);
                        }
                        MapplsAccountManager.getInstance().setRefreshToken(responseExecuteCall3.body().refreshToken, responseExecuteCall3.body().accessToken);
                        MapplsAccountManager.getInstance().setUserId(responseExecuteCall3.body().userId);
                        MapplsApiConfiguration.getInstance().iTokenRepo.setToken(responseExecuteCall3.body().refreshToken);
                    } else {
                        if (responseExecuteCall3.code() == 401) {
                            MapplsApiConfiguration.getInstance().iTokenRepo.clearToken();
                            LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Refresh Token API API: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall3.code()), responseExecuteCall3.message()));
                            return new Response.Builder().request(request).body(responseExecuteCall3.errorBody()).protocol(Protocol.HTTP_1_0).code(102).header(StackTraceHelper.MESSAGE_KEY, "Session Expired").message("Session Expired").build();
                        }
                        LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Refresh Token API API: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall3.code()), responseExecuteCall3.message()));
                        return new Response.Builder().request(request).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                    }
                }
                setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
                return chain.proceed(builderNewBuilder.build());
            }
        }
        String accessToken3 = MapplsAccountManager.getInstance().getAccessToken();
        setAuthHeader(builderNewBuilder, accessToken3);
        Request requestBuild2 = builderNewBuilder.build();
        Response responseProceed2 = chain.proceed(requestBuild2);
        if (responseProceed2.code() == 401) {
            synchronized (this.httpClient) {
                String accessToken4 = MapplsAccountManager.getInstance().getAccessToken();
                if (accessToken4 == null || accessToken4.equalsIgnoreCase(accessToken3)) {
                    retrofit2.Response<AtlasAuthToken> responseExecuteCall4 = MapplsAuthentication.builder().refreshToken(MapplsAccountManager.getInstance().getRefreshToken()).grantType("refresh_token").build().executeCall();
                    if (responseExecuteCall4.code() == 200 && responseExecuteCall4.body() != null) {
                        if (MapplsLMSManager.isInitialised()) {
                            if (responseExecuteCall4.body().projectCode != null) {
                                MapplsLMSManager.getInstance().setProjectCode(responseExecuteCall4.body().projectCode);
                            }
                            if (responseExecuteCall4.body().clientId != null) {
                                MapplsLMSManager.getInstance().setClientId(responseExecuteCall4.body().clientId);
                            }
                            MapplsLMSManager.getInstance().setUserId(responseExecuteCall4.body().userId);
                        }
                        MapplsAccountManager.getInstance().setRefreshToken(responseExecuteCall4.body().refreshToken, responseExecuteCall4.body().accessToken);
                        MapplsAccountManager.getInstance().setUserId(responseExecuteCall4.body().userId);
                        MapplsApiConfiguration.getInstance().iTokenRepo.setToken(responseExecuteCall4.body().refreshToken);
                    } else {
                        if (responseExecuteCall4.code() != 401 && responseExecuteCall4.code() != 400) {
                            LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Refresh Token API API: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall4.code()), responseExecuteCall4.message()));
                            return new Response.Builder().request(requestBuild2).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).protocol(Protocol.HTTP_1_0).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                        }
                        MapplsApiConfiguration.getInstance().iTokenRepo.clearToken();
                        LoggerUtils.e("LoginOAuthInterceptor", String.format(Locale.US, "Refresh Token API API: Code = %d,  Message = %s", Integer.valueOf(responseExecuteCall4.code()), responseExecuteCall4.message()));
                        return responseProceed2.newBuilder().code(102).header(StackTraceHelper.MESSAGE_KEY, "Session Expired").message("Session Expired").build();
                    }
                }
                if (MapplsAccountManager.getInstance().getAccessToken() != null) {
                    responseProceed2.close();
                    setAuthHeader(builderNewBuilder, MapplsAccountManager.getInstance().getAccessToken());
                    return chain.proceed(builderNewBuilder.build());
                }
            }
        }
        return responseProceed2;
    }

    private void setAuthHeader(Request.Builder builder, String str) {
        builder.header(HttpHeaders.AUTHORIZATION, String.format("bearer %s", str));
    }

    public void setHttpClient(OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
    }
}
