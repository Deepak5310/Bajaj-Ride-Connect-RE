package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fg extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final fg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg r;
    public int b;
    public int d;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f197n;
    public int o;
    public int p;
    public fs q;
    private byte s = 2;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.bq e = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bt f = com.google.android.libraries.navigation.internal.ael.cm.a;
    public int g = 1;
    public int h = 1;

    static {
        fg fgVar = new fg();
        a = fgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fg.class, fgVar);
    }

    private fg() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.m = -1;
        this.f197n = -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.s);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000f\u0000\u0001\u0001\u0011\u000f\u0000\u0002\u0001\u0001ည\u0000\u0002'\u0003င\b\u0004င\n\u0005ဆ\u000b\u0006᠌\u0002\u0007င\u0001\b᠌\u0003\nင\u0005\u000bဂ\t\f%\rင\u0006\u000eင\u0007\u000f᠌\u0004\u0011ᐉ\r", new Object[]{"b", "c", "e", "m", "o", ContextChain.TAG_PRODUCT, "g", fe.a, "d", "h", fe.a, "j", "n", "f", "k", "l", ContextChain.TAG_INFRA, cy.a, "q"});
        }
        if (i2 == 3) {
            return new fg();
        }
        if (i2 == 4) {
            return new fd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.s = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = r;
        if (bcVar == null) {
            synchronized (fg.class) {
                bcVar = r;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    r = bcVar;
                }
            }
        }
        return bcVar;
    }
}
