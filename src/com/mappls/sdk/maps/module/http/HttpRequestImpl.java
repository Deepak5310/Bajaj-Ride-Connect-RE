package com.mappls.sdk.maps.module.http;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mappls.sdk.maps.MapplsMapConfiguration;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.http.HttpLogger;
import com.mappls.sdk.maps.http.HttpRequest;
import com.mappls.sdk.maps.http.HttpResponder;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.utils.ApiCallHelper;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
public class HttpRequestImpl implements HttpRequest {
    static final OkHttpClient DEFAULT_CLIENT;
    static OkHttpClient client;
    private Call call;
    private static final String userAgentString = ApiCallHelper.getHeaderUserAgent();
    static PublicKeyInterceptor publicKeyInterceptor = new PublicKeyInterceptor();
    static OAuthInterceptor oAuthInterceptor = new OAuthInterceptor();

    static {
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().dispatcher(getDispatcher()).addInterceptor(publicKeyInterceptor).addInterceptor(oAuthInterceptor).build();
        DEFAULT_CLIENT = okHttpClientBuild;
        client = okHttpClientBuild;
    }

    public HttpRequestImpl() {
        if (publicKeyInterceptor.getOkHttpClient() == null) {
            publicKeyInterceptor.setClient(client);
        }
        if (oAuthInterceptor.getOkHttpClient() == null) {
            oAuthInterceptor.setOkHttpClient(client);
        }
    }

    @Override // com.mappls.sdk.maps.http.HttpRequest
    public void executeRequest(HttpResponder httpResponder, long j, String str, String str2, String str3, boolean z) {
        String str4 = "map_tile";
        OkHttpCallback okHttpCallback = new OkHttpCallback(httpResponder);
        try {
            String strReplace = str.replace("mmi_h", "mt1");
            if (MapplsAccountManager.getInstance().getMapSDKKey() != null) {
                strReplace = strReplace.replace("v_mmi", MapplsAccountManager.getInstance().getMapSDKKey());
            }
            if (!strReplace.startsWith(UriUtil.HTTP_SCHEME)) {
                strReplace = "https://" + strReplace;
            }
            if (!MapplsMapConfiguration.getInstance().isAllowOtherUrls() && !strReplace.toLowerCase().contains("mapmyindia") && !strReplace.toLowerCase().contains(DirectionsCriteria.PROFILE_DEFAULT_USER)) {
                HttpLogger.log(6, String.format("[HTTP] Invalid resourceUrl %s", strReplace));
                return;
            }
            if (HttpUrl.parse(strReplace) == null) {
                HttpLogger.log(6, String.format("[HTTP] Unable to parse resourceUrl %s", strReplace));
                return;
            }
            Request.Builder builder = new Request.Builder();
            if (!MapplsMapConfiguration.getInstance().isUsingRasterStyle() && ((strReplace.contains("/vector_tile/") || strReplace.contains("/map_tile/") || strReplace.contains("/vectorTiles/")) && MapplsMapManager.getInstance().getRawPublicKey() != null)) {
                if (!strReplace.contains("map_tile")) {
                    str4 = "vector_tile";
                }
                String strReplace2 = strReplace.replace(str4, "vectorTiles");
                String strSubstring = strReplace2.substring(strReplace2.lastIndexOf("vectorTiles/") + 12, strReplace2.length());
                strReplace = strReplace2.replace(strSubstring, "pbf");
                String str5 = new String(Base64.encode(RSAEncrypter.getInstance().encryptWithRSA(VTAuthentication.getInstance().getKey(), strSubstring), 2));
                builder.header("Content-Type", "text/plain");
                builder.header("TILE", str5);
            }
            builder.url(strReplace).tag(strReplace.toLowerCase(MapplsConstants.MAPPLS_LOCALE)).addHeader(HttpHeaders.USER_AGENT, userAgentString);
            if (str2.length() > 0) {
                builder.addHeader(HttpHeaders.IF_NONE_MATCH, str2);
            } else if (str3.length() > 0) {
                builder.addHeader(HttpHeaders.IF_MODIFIED_SINCE, str3);
            }
            Call callNewCall = client.newCall(builder.build());
            this.call = callNewCall;
            FirebasePerfOkHttpClient.enqueue(callNewCall, okHttpCallback);
        } catch (Exception e) {
            okHttpCallback.handleFailure(this.call, e);
        }
    }

    @Override // com.mappls.sdk.maps.http.HttpRequest
    public void cancelRequest() {
        Call call = this.call;
        if (call != null) {
            HttpLogger.log(3, String.format("[HTTP] This request was cancelled (%s). This is expected for tiles that were being prefetched but are no longer needed for the map to render.", call.request().url()));
            this.call.cancel();
        }
    }

    public static void enablePrintRequestUrlOnFailure(boolean z) {
        HttpLogger.logRequestUrl = z;
    }

    public static void enableLog(boolean z) {
        HttpLogger.logEnabled = z;
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            client = okHttpClient;
        } else {
            client = DEFAULT_CLIENT;
        }
    }

    public static void setProxy(String str, int i) {
        client.newBuilder().proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
    }

    private static class OkHttpCallback implements Callback {
        private HttpResponder httpRequest;

        OkHttpCallback(HttpResponder httpResponder) {
            this.httpRequest = httpResponder;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            handleFailure(call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                HttpLogger.log(2, String.format("[HTTP] Request was successful (code = %s).", Integer.valueOf(response.code())));
            } else {
                HttpLogger.log(3, String.format("[HTTP] Request with response = %s: %s", Integer.valueOf(response.code()), !TextUtils.isEmpty(response.message()) ? response.message() : "No additional information"));
            }
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                HttpLogger.log(6, "[HTTP] Received empty response body");
                return;
            }
            try {
                try {
                    byte[] bArrBytes = responseBodyBody.bytes();
                    response.close();
                    this.httpRequest.onResponse(response.code(), response.header(HttpHeaders.ETAG), response.header(HttpHeaders.LAST_MODIFIED), response.header(HttpHeaders.CACHE_CONTROL), response.header(HttpHeaders.EXPIRES), response.header(HttpHeaders.RETRY_AFTER), response.header("x-rate-limit-reset"), bArrBytes);
                } catch (IOException e) {
                    onFailure(call, e);
                    response.close();
                }
            } catch (Throwable th) {
                response.close();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleFailure(Call call, Exception exc) {
            String message = exc.getMessage() != null ? exc.getMessage() : "Error processing the request";
            int failureType = getFailureType(exc);
            if (HttpLogger.logEnabled && call != null && call.request() != null) {
                HttpLogger.logFailure(failureType, message, call.request().url().getUrl());
            }
            this.httpRequest.handleFailure(failureType, message);
        }

        private int getFailureType(Exception exc) {
            if ((exc instanceof NoRouteToHostException) || (exc instanceof UnknownHostException) || (exc instanceof SocketException) || (exc instanceof ProtocolException) || (exc instanceof SSLException)) {
                return 0;
            }
            return exc instanceof InterruptedIOException ? 1 : 2;
        }
    }

    private static Dispatcher getDispatcher() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(20);
        return dispatcher;
    }
}
