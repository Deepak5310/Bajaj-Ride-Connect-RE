package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ip extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final com.google.android.libraries.navigation.internal.ael.br a = new il();
    public static final ip b;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg x;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f203n;
    public int o;
    public boolean q;
    public float t;
    public float u;
    public float v;
    public float w;
    private byte y = 2;
    public com.google.android.libraries.navigation.internal.ael.bq j = com.google.android.libraries.navigation.internal.ael.bj.a;
    public int p = 1;
    public com.google.android.libraries.navigation.internal.ael.bz r = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bq s = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        ip ipVar = new ip();
        b = ipVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ip.class, ipVar);
    }

    private ip() {
    }

    public static /* synthetic */ void d(ip ipVar) {
        ipVar.c |= 4096;
        ipVar.q = true;
    }

    public static /* synthetic */ void e(ip ipVar) {
        ipVar.c |= 1024;
        ipVar.o = 16;
    }

    public static /* synthetic */ void f(ip ipVar) {
        ipVar.c |= 512;
        ipVar.f203n = 16;
    }

    public static /* synthetic */ void g(ip ipVar) {
        ipVar.c |= 256;
        ipVar.m = 1493172224;
    }

    public static /* synthetic */ void h(ip ipVar) {
        ipVar.c |= 128;
        ipVar.l = 1;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.y);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(b, "\u0001\u0014\u0000\u0001\u0001\u0016\u0014\u0000\u0003\u0001\u0001ဆ\u0000\u0002င\u0001\u0003ဆ\u0002\u0004င\u0003\u0005င\u0006\u0006Л\u0007ခ\r\bခ\u000e\t'\nင\u0004\u000bင\u0005\fࠞ\rင\t\u000eင\n\u000f᠌\u000b\u0010င\u0007\u0011ဆ\b\u0012ဇ\f\u0014ခ\u0010\u0016ခ\u0012", new Object[]{"c", "d", "e", "f", "g", "k", "r", cr.class, "t", "u", "s", "h", ContextChain.TAG_INFRA, "j", a.a, "n", "o", ContextChain.TAG_PRODUCT, in.a, "l", "m", "q", "v", "w"});
        }
        if (i2 == 3) {
            return new ip();
        }
        if (i2 == 4) {
            return new im();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            this.y = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = x;
        if (bcVar == null) {
            synchronized (ip.class) {
                bcVar = x;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(b);
                    x = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bq bqVar = this.j;
        if (bqVar.c()) {
            return;
        }
        this.j = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
    }
}
