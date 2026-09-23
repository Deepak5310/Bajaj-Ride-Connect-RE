package com.mappls.sdk.services.api;

import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.whoami.MapplsLicensing;
import com.mappls.sdk.services.api.whoami.model.LicensingHeader;
import com.mappls.sdk.services.api.whoami.model.LicensingOutputParams;
import com.mappls.sdk.services.api.whoami.model.LicensingParams;
import com.mappls.sdk.services.api.whoami.model.LicensingResponse;
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

/* JADX INFO: loaded from: classes4.dex */
public class InitialiserInterceptor implements Interceptor {
    private OkHttpClient httpClient;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String token;
        Request request = chain.request();
        String host = request.url().url().getHost();
        if (host.contains("127.0.") || host.contains(AndroidInfoHelpers.DEVICE_LOCALHOST)) {
            return chain.proceed(request);
        }
        if (MapplsApiConfiguration.getInstance().isLoginRequired() == null) {
            synchronized (this.httpClient) {
                if (MapplsApiConfiguration.getInstance().isLoginRequired() == null) {
                    try {
                        retrofit2.Response<LicensingResponse> responseExecuteCall = MapplsLicensing.builder().deviceId(MapplsAccountManager.getInstance().getClusterId()).build().executeCall();
                        if (responseExecuteCall.code() == 200 && responseExecuteCall.body() != null) {
                            MapplsApiConfiguration.getInstance().isLoginRequired = responseExecuteCall.body().isUserLoginRequired();
                            if (MapplsApiConfiguration.getInstance().isLoginRequired() != null && MapplsApiConfiguration.getInstance().isLoginRequired().booleanValue() && (token = MapplsApiConfiguration.getInstance().iTokenRepo.getToken()) != null) {
                                MapplsAccountManager.getInstance().setRefreshToken(token, null);
                            }
                            if (responseExecuteCall.body().getLicensingHeader() != null) {
                                LicensingHeader licensingHeader = responseExecuteCall.body().getLicensingHeader();
                                MapplsApiConfiguration.getInstance().xMsSeh = licensingHeader.getxMsSeh();
                                MapplsApiConfiguration.getInstance().xDh = licensingHeader.getxDh();
                            }
                            if (responseExecuteCall.body().getLicensingParams() != null) {
                                LicensingParams licensingParams = responseExecuteCall.body().getLicensingParams();
                                MapplsApiConfiguration.getInstance().clusterId = licensingParams.getClusterDevice();
                                MapplsApiConfiguration.getInstance().deviceFingerPrint = licensingParams.getDeviceFingerprint();
                                MapplsApiConfiguration.getInstance().vin = licensingParams.getVin();
                                MapplsApiConfiguration.getInstance().userId = licensingParams.getUserId();
                            }
                            if (responseExecuteCall.body().getLicensingOutputParams() != null) {
                                LicensingOutputParams licensingOutputParams = responseExecuteCall.body().getLicensingOutputParams();
                                if (licensingOutputParams.getDeviceRegion() != null && licensingOutputParams.getDeviceRegion().size() > 0) {
                                    MapplsAccountManager.getInstance().setRegion(licensingOutputParams.getDeviceRegion().get(0));
                                }
                            }
                            LoggerUtils.e("InitialiserInterceptor", String.format(Locale.US, "Initialising Api Success: Code = %d", Integer.valueOf(responseExecuteCall.code())));
                        } else {
                            if (responseExecuteCall.code() == 7) {
                                return new Response.Builder().request(request).protocol(responseExecuteCall.raw().protocol()).code(7).body(ResponseBody.create(MediaType.parse("text"), "")).message("Authentication Failed").header(StackTraceHelper.MESSAGE_KEY, "Authentication Failed").build();
                            }
                            LoggerUtils.e("InitialiserInterceptor", String.format(Locale.US, "Initialising Api Failure: Code = %d Message = %s", Integer.valueOf(responseExecuteCall.code()), responseExecuteCall.message()));
                            return new Response.Builder().request(request).protocol(responseExecuteCall.raw().protocol()).code(8).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK not initialised").message("SDK not initialised").build();
                        }
                    } catch (SocketTimeoutException e) {
                        e = e;
                        LoggerUtils.e("InitialiserInterceptor", e.getMessage(), e);
                        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(8).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK not initialised").message("SDK not initialised").build();
                    } catch (SSLHandshakeException e2) {
                        e = e2;
                        LoggerUtils.e("InitialiserInterceptor", e.getMessage(), e);
                        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(8).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK not initialised").message("SDK not initialised").build();
                    } catch (ConnectTimeoutException e3) {
                        e = e3;
                        LoggerUtils.e("InitialiserInterceptor", e.getMessage(), e);
                        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(8).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "SDK not initialised").message("SDK not initialised").build();
                    }
                }
            }
        }
        return chain.proceed(request);
    }

    public void setHttpClient(OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
    }
}
