package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class id extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final id a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg m;
    public int b;
    public int c;
    public int d;
    public int e;
    public int g;
    public int i;
    public int j;
    public bw k;
    public bw l;
    public com.google.android.libraries.navigation.internal.ael.bq f = com.google.android.libraries.navigation.internal.ael.bj.a;
    public String h = "";

    static {
        id idVar = new id();
        a = idVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(id.class, idVar);
    }

    private id() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0001\u000f\n\u0000\u0001\u0000\u0001ဆ\u0000\u0002င\u0003\u0003\u0016\u0004ဈ\u0006\bဏ\u0005\nဉ\n\u000bဉ\u000b\fင\b\u000eင\t\u000fဆ\u0002", new Object[]{"b", "c", "e", "f", "h", "g", "k", "l", ContextChain.TAG_INFRA, "j", "d"});
        }
        if (i2 == 3) {
            return new id();
        }
        if (i2 == 4) {
            return new ic();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = m;
        if (bcVar == null) {
            synchronized (id.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
