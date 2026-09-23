package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ba a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg q;
    public int b;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public int k;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f180n;
    public int o;
    public int p;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public String j = "";
    public String l = "";

    static {
        ba baVar = new ba();
        a = baVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ba.class, baVar);
    }

    private ba() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001\u001b\u0002ဆ\u0001\u0003င\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006\u0016\u0007ဈ\u0005\bင\u0006\tင\u0000\nဈ\u0007\u000bင\b\f᠌\t\r᠌\n\u000e᠌\u000b", new Object[]{"b", "c", id.class, "f", "g", "h", ContextChain.TAG_INFRA, "d", "j", "k", "e", "l", "m", "n", ay.a, "o", au.a, ContextChain.TAG_PRODUCT, aw.a});
        }
        if (i2 == 3) {
            return new ba();
        }
        if (i2 == 4) {
            return new at();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = q;
        if (bcVar == null) {
            synchronized (ba.class) {
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
