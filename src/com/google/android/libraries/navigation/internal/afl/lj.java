package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lj extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final lj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg q;
    public int b;
    public com.google.android.libraries.navigation.internal.acc.b d;
    public lr g;
    public boolean j;
    public boolean k;
    public com.google.android.libraries.navigation.internal.adq.al l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public mj f319n;
    public boolean o;
    public com.google.android.libraries.navigation.internal.ady.h p;
    private byte r = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int e = 2;
    public com.google.android.libraries.navigation.internal.ael.bz f = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int h = 2;
    public com.google.android.libraries.navigation.internal.ael.bz i = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        lj ljVar = new lj();
        a = ljVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lj.class, ljVar);
    }

    private lj() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.r);
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = com.google.android.libraries.navigation.internal.adr.fx.a;
            com.google.android.libraries.navigation.internal.adr.bm.a aVar = com.google.android.libraries.navigation.internal.adr.bm.a.KILOMETERS;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000e\u0000\u0001\u0001%\u000e\u0000\u0003\u0001\u0001\u001b\u0003ဉ\u0000\u0005᠌\u0001\u0006ဉ\u0002\u0007᠌\u0003\t\u001b\u000eဇ\b\u000fᐉ\t\u0010ဇ\n\u0013ဉ\f\u0016ဇ\r ဇ\u0007\"ဉ\u000f%\u001b", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.adr.ls.class, "d", "e", boVar, "g", "h", com.google.android.libraries.navigation.internal.adr.bl.a, ContextChain.TAG_INFRA, com.google.android.libraries.navigation.internal.adr.la.class, "k", "l", "m", "n", "o", "j", ContextChain.TAG_PRODUCT, "f", com.google.android.libraries.navigation.internal.adr.ge.class});
        }
        if (i2 == 3) {
            return new lj();
        }
        if (i2 == 4) {
            return new li();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.r = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = q;
        if (bcVar == null) {
            synchronized (lj.class) {
                bcVar = q;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    q = bcVar;
                }
            }
        }
        return bcVar;
    }
}
