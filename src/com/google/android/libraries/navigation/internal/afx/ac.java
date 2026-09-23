package com.google.android.libraries.navigation.internal.afx;

import androidx.autofill.HintConstants;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends cc {
    private static final long serialVersionUID = 0;
    public final InetSocketAddress a;
    private final SocketAddress b;
    private final String c;
    private final String d;

    public ac(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        com.google.android.libraries.navigation.internal.yx.ar.r(socketAddress, "proxyAddress");
        com.google.android.libraries.navigation.internal.yx.ar.r(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            com.google.android.libraries.navigation.internal.yx.ar.o(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.b = socketAddress;
        this.a = inetSocketAddress;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.b, acVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.a, acVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, acVar.c) && com.google.android.libraries.navigation.internal.yx.am.a(this.d, acVar.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.a, this.c, this.d});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("proxyAddr", this.b);
        akVarB.g("targetAddr", this.a);
        akVarB.g(HintConstants.AUTOFILL_HINT_USERNAME, this.c);
        return akVarB.e("hasPassword", this.d != null).toString();
    }
}
