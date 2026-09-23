package com.mappls.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.perf.util.Constants;
import com.mappls.android.lms.MapplsLMSAPI;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes6.dex */
public class HttpService implements RemoteService {
    private static final String LOGTAG = "MapplsAnalyticsAPI.Message";
    private static final int MAX_UNAVAILABLE_HTTP_RESPONSE_CODE = 599;
    private static final int MIN_UNAVAILABLE_HTTP_RESPONSE_CODE = 500;
    private static boolean sIsMapplsAnalyticsBlocked;

    private boolean onOfflineMode(OfflineMode offlineMode) {
        if (offlineMode == null) {
            return false;
        }
        try {
            return offlineMode.isOffline();
        } catch (Exception e) {
            MPLog.v(LOGTAG, "Client State should not throw exception, will assume is not on offline mode", e);
            return false;
        }
    }

    private static byte[] slurp(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr, 0, 8192);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // com.mappls.android.util.RemoteService
    public void checkIsMapplsAnalyticsBlocked() {
        new Thread(new Runnable() { // from class: com.mappls.android.util.HttpService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress byName = InetAddress.getByName("www.mappls.com");
                    boolean unused = HttpService.sIsMapplsAnalyticsBlocked = byName.isLoopbackAddress() || byName.isAnyLocalAddress();
                    if (HttpService.sIsMapplsAnalyticsBlocked) {
                        MPLog.v(HttpService.LOGTAG, "AdBlocker is enabled. Won't be able to use Mappls Analytics services.");
                    }
                } catch (Exception unused2) {
                }
            }
        }).start();
    }

    @Override // com.mappls.android.util.RemoteService
    public boolean isOnline(Context context, OfflineMode offlineMode) {
        boolean z;
        String string;
        if (sIsMapplsAnalyticsBlocked || onOfflineMode(offlineMode)) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                string = "A default network has not been set so we cannot be certain whether we are offline";
                z = true;
            } else {
                boolean zIsConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
                StringBuilder sb = new StringBuilder("ConnectivityManager says we ");
                sb.append(zIsConnectedOrConnecting ? "are" : "are not");
                sb.append(" online");
                z = zIsConnectedOrConnecting;
                string = sb.toString();
            }
            MPLog.v(LOGTAG, string);
            return z;
        } catch (SecurityException unused) {
            MPLog.v(LOGTAG, "Don't have permission to check connectivity, will assume we are online");
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0148  */
    /* JADX WARN: Code duplicated, block: B:72:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mappls.android.util.RemoteService
    public byte[] performRequest(String str, Map<String, Object> map, SSLSocketFactory sSLSocketFactory) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        MPLog.v(LOGTAG, "Attempting request to " + str);
        InputStream inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        int i = 0;
        byte[] bArrSlurp = null;
        Object[] objArr = false;
        while (i < 3 && objArr == false) {
            try {
                URL url = new URL(str);
                httpURLConnection = (HttpURLConnection) ((URLConnection) (MapplsLMSAPI.host != null ? FirebasePerfUrlConnection.instrument(url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(MapplsLMSAPI.host, MapplsLMSAPI.port.intValue())))) : FirebasePerfUrlConnection.instrument(url.openConnection())));
                if (sSLSocketFactory != null) {
                    try {
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                        }
                    } catch (EOFException unused) {
                        inputStream = null;
                        MPLog.d(LOGTAG, "Failure to connect, likely caused by a known issue with Android lib. Retrying.");
                        i++;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (IOException e) {
                        e = e;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            try {
                                if (httpURLConnection2.getResponseCode() >= 500) {
                                    throw new RemoteService.ServiceUnavailableException("Service Unavailable", httpURLConnection2.getHeaderField(HttpHeaders.RETRY_AFTER));
                                }
                            } catch (Throwable th) {
                                th = th;
                                httpURLConnection = httpURLConnection2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (httpURLConnection == null) {
                                    throw th;
                                }
                                httpURLConnection.disconnect();
                                throw th;
                            }
                        }
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection == null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
                httpURLConnection.setConnectTimeout(Constants.MAX_URL_LENGTH);
                httpURLConnection.setReadTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                if (map != null) {
                    Uri.Builder builder = new Uri.Builder();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        builder.appendQueryParameter(entry.getKey(), entry.getValue().toString());
                    }
                    String encodedQuery = builder.build().getEncodedQuery();
                    if (map.containsKey("data")) {
                        encodedQuery = (String) map.get("data");
                    }
                    httpURLConnection.setFixedLengthStreamingMode(encodedQuery.getBytes().length);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "text/plain");
                    httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "*/*");
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                    bufferedWriter.write(encodedQuery);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    try {
                        bArrSlurp = slurp(inputStream);
                        inputStream.close();
                        httpURLConnection.disconnect();
                        objArr = true;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection == null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (EOFException unused4) {
                    MPLog.d(LOGTAG, "Failure to connect, likely caused by a known issue with Android lib. Retrying.");
                    i++;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e2) {
                    e = e2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        if (httpURLConnection2.getResponseCode() >= 500 && httpURLConnection2.getResponseCode() <= MAX_UNAVAILABLE_HTTP_RESPONSE_CODE) {
                            throw new RemoteService.ServiceUnavailableException("Service Unavailable", httpURLConnection2.getHeaderField(HttpHeaders.RETRY_AFTER));
                        }
                    }
                    throw e;
                }
            } catch (EOFException unused5) {
                httpURLConnection = null;
                inputStream = null;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
            }
        }
        if (i >= 3) {
            MPLog.v(LOGTAG, "Could not connect to Mappls Analytics service after three retries.");
        }
        return bArrSlurp;
    }
}
