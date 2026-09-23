package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class nl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final nl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg t;
    public int b;
    public int d;
    public int e;
    public int k;
    public int l;
    public boolean m;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public long s;
    public boolean c = true;
    public int f = 30;
    public String g = "";
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz i = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String j = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f321n = "";

    static {
        nl nlVar = new nl();
        a = nlVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(nl.class, nlVar);
    }

    private nl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0011\u0000\u0001\u0001\u0012\u0011\u0000\u0002\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005ဈ\u0004\u0006\u001b\u0007\u001b\bဈ\u0005\tင\u0006\nင\u0007\u000bဇ\b\fဈ\t\rဇ\n\u000eဇ\u000b\u000fဇ\f\u0010ဇ\r\u0012ဂ\u000f", new Object[]{"b", "c", "d", nh.a, "e", "f", "g", "h", nf.class, ContextChain.TAG_INFRA, nk.class, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s"});
        }
        if (i2 == 3) {
            return new nl();
        }
        if (i2 == 4) {
            return new ng();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = t;
        if (bcVar == null) {
            synchronized (nl.class) {
                bcVar = t;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    t = bcVar;
                }
            }
        }
        return bcVar;
    }
}
