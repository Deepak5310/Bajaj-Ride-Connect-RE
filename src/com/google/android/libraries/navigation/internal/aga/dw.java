package com.google.android.libraries.navigation.internal.aga;

import com.facebook.common.util.UriUtil;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dw {
    public static final PasswordAuthentication a(String str, InetAddress inetAddress, int i) {
        URL url;
        try {
            url = new URL(UriUtil.HTTPS_SCHEME, str, i, "");
        } catch (MalformedURLException unused) {
            dy.a.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl$1", "requestPasswordAuthentication", "failed to create URL for Authenticator: {0} {1}", new Object[]{UriUtil.HTTPS_SCHEME, str});
            url = null;
        }
        return Authenticator.requestPasswordAuthentication(str, inetAddress, i, UriUtil.HTTPS_SCHEME, "", null, url, Authenticator.RequestorType.PROXY);
    }
}
