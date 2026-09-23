package com.google.android.libraries.navigation.internal.aga;

import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dy implements com.google.android.libraries.navigation.internal.afx.cd {
    private final com.google.android.libraries.navigation.internal.yx.br c;
    private final InetSocketAddress d;
    private final dw f;
    public static final Logger a = Logger.getLogger(dy.class.getName());
    private static final dw e = new dw();
    private static final com.google.android.libraries.navigation.internal.yx.br b = new dx();

    public dy() {
        com.google.android.libraries.navigation.internal.yx.br brVar = b;
        dw dwVar = e;
        String str = System.getenv("GRPC_PROXY_EXP");
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar);
        this.c = brVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(dwVar);
        this.f = dwVar;
        if (str == null) {
            this.d = null;
            return;
        }
        String[] strArrSplit = str.split(":", 2);
        int i = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        a.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "overrideProxy", "Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        this.d = new InetSocketAddress(strArrSplit[0], i);
    }

    private final com.google.android.libraries.navigation.internal.afx.cc b(InetSocketAddress inetSocketAddress) throws IOException {
        try {
            URI uri = new URI(UriUtil.HTTPS_SCHEME, null, inetSocketAddress.getHostString(), inetSocketAddress.getPort(), null, null, null);
            ProxySelector proxySelector = (ProxySelector) this.c.a();
            if (proxySelector == null) {
                a.logp(Level.FINE, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "proxy selector is null, so continuing without proxy lookup");
                return null;
            }
            List<Proxy> listSelect = proxySelector.select(uri);
            if (listSelect.size() > 1) {
                a.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "More than 1 proxy detected, gRPC will select the first one");
            }
            Proxy proxy = listSelect.get(0);
            if (proxy.type() == Proxy.Type.DIRECT) {
                return null;
            }
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
            PasswordAuthentication passwordAuthenticationA = dw.a(inetSocketAddress2.getHostString(), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
            if (inetSocketAddress2.isUnresolved()) {
                inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
            }
            com.google.android.libraries.navigation.internal.afx.ab abVar = new com.google.android.libraries.navigation.internal.afx.ab();
            abVar.c(inetSocketAddress);
            abVar.b(inetSocketAddress2);
            if (passwordAuthenticationA == null) {
                return abVar.a();
            }
            abVar.a = passwordAuthenticationA.getUserName();
            abVar.b = passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null;
            return abVar.a();
        } catch (URISyntaxException e2) {
            a.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl", "detectProxy", "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e2);
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.cd
    public final com.google.android.libraries.navigation.internal.afx.cc a(SocketAddress socketAddress) throws IOException {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        if (this.d == null) {
            return b((InetSocketAddress) socketAddress);
        }
        com.google.android.libraries.navigation.internal.afx.ab abVar = new com.google.android.libraries.navigation.internal.afx.ab();
        abVar.b(this.d);
        abVar.c((InetSocketAddress) socketAddress);
        return abVar.a();
    }
}
