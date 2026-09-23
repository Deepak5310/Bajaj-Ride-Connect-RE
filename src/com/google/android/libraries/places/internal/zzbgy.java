package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgy {
    zzbgy() {
    }

    public static final PasswordAuthentication zza(String str, InetAddress inetAddress, int i, String str2, String str3, String str4) {
        URL url;
        try {
            url = new URL(UriUtil.HTTPS_SCHEME, str, i, "");
        } catch (MalformedURLException unused) {
            zzbha.zza.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl$1", "requestPasswordAuthentication", "failed to create URL for Authenticator: {0} {1}", new Object[]{UriUtil.HTTPS_SCHEME, str});
            url = null;
        }
        return Authenticator.requestPasswordAuthentication(str, inetAddress, i, UriUtil.HTTPS_SCHEME, "", null, url, Authenticator.RequestorType.PROXY);
    }
}
