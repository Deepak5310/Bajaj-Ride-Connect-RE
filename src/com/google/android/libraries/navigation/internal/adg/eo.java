package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eo extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final eo a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg x;
    public int b;
    public int c;
    public int d;
    public ch g;
    public ip h;
    public int i;
    public boolean l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f187n;
    public int o;
    public int p;
    public ak q;
    public int r;
    public int s;
    public p t;
    public int u;
    public int v;
    private byte y = 2;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bq f = com.google.android.libraries.navigation.internal.ael.bj.a;
    public int j = 1;
    public int k = 1;
    public com.google.android.libraries.navigation.internal.ael.bz w = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        eo eoVar = new eo();
        a = eoVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(eo.class, eoVar);
    }

    private eo() {
    }

    public static /* synthetic */ void d(eo eoVar) {
        eoVar.b |= 64;
        eoVar.i = Integer.MAX_VALUE;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.y);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0003\u0002\u0001ဆ\u0000\u0002ဆ\u0001\u0003Л\u0004ဉ\u0004\u0005ᐉ\u0005\u0006င\u0006\u0007ဇ\t\b'\t᠌\u0007\n᠌\b\u000bဏ\n\fဏ\u000b\rဏ\f\u000e᠌\r\u000fဉ\u000e\u0010င\u0010\u0011င\u000f\u0012ဉ\u0011\u0013င\u0012\u0014\u001b\u0015င\u0013", new Object[]{"b", "c", "d", "e", cr.class, "g", "h", ContextChain.TAG_INFRA, "l", "f", "j", a.a, "k", ek.a, "m", "n", "o", ContextChain.TAG_PRODUCT, em.a, "q", "s", "r", "t", "u", "w", dx.class, "v"});
        }
        if (i2 == 3) {
            return new eo();
        }
        if (i2 == 4) {
            return new ej();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.y = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = x;
        if (bcVar == null) {
            synchronized (eo.class) {
                bcVar = x;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    x = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.e;
        if (bzVar.c()) {
            return;
        }
        this.e = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
