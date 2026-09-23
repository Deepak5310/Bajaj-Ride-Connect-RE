package com.google.android.libraries.navigation.internal.afx;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public String a;
    public String b;
    private SocketAddress c;
    private InetSocketAddress d;

    public final ac a() {
        return new ac(this.c, this.d, this.a, this.b);
    }

    public final void b(SocketAddress socketAddress) {
        com.google.android.libraries.navigation.internal.yx.ar.r(socketAddress, "proxyAddress");
        this.c = socketAddress;
    }

    public final void c(InetSocketAddress inetSocketAddress) {
        com.google.android.libraries.navigation.internal.yx.ar.r(inetSocketAddress, "targetAddress");
        this.d = inetSocketAddress;
    }
}
