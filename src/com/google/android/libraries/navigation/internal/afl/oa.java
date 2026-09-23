package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class oa extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final oa a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg z;
    public int b;
    public long c;
    public com.google.android.libraries.navigation.internal.afm.z e;
    public com.google.android.libraries.navigation.internal.afm.z f;
    public int g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f323n;
    public String o;
    public com.google.android.libraries.navigation.internal.adr.ft p;
    public com.google.android.libraries.navigation.internal.aat.b q;
    public String r;
    public String s;
    public float t;
    public com.google.android.libraries.navigation.internal.aap.d u;
    public com.google.android.libraries.navigation.internal.aap.d v;
    public com.google.android.libraries.navigation.internal.aap.d w;
    public long x;
    public long y;
    private byte A = 2;
    public int d = 127;

    static {
        oa oaVar = new oa();
        a = oaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(oa.class, oaVar);
    }

    private oa() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.f323n = "";
        this.o = "";
        this.r = "";
        this.s = "";
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.A);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0017\u0000\u0001\u0001\u0018\u0017\u0000\u0000\u0003\u0001စ\u0000\u0002᠌\u0001\u0004ᐉ\u0002\u0005ဈ\u0006\u0006ဈ\t\u0007ဈ\n\bဈ\u000b\tᐉ\u0003\nᐉ\r\u000bင\u0004\fင\u0005\rဈ\u0007\u000eဈ\u000f\u000fဈ\u0010\u0010ခ\u0011\u0011ဉ\u0012\u0012ဉ\u0013\u0013ဈ\f\u0014ဂ\u0015\u0015ဂ\u0016\u0016ဈ\b\u0017ဉ\u0014\u0018ဉ\u000e", new Object[]{"b", "c", "d", ny.a, "e", ContextChain.TAG_INFRA, "l", "m", "n", "f", ContextChain.TAG_PRODUCT, "g", "h", "j", "r", "s", "t", "u", "v", "o", "x", "y", "k", "w", "q"});
        }
        if (i2 == 3) {
            return new oa();
        }
        if (i2 == 4) {
            return new nx();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.A = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = z;
        if (bcVar == null) {
            synchronized (oa.class) {
                bcVar = z;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    z = bcVar;
                }
            }
        }
        return bcVar;
    }
}
