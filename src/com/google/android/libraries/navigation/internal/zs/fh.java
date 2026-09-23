package com.google.android.libraries.navigation.internal.zs;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg l;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public String k = "";

    static {
        fh fhVar = new fh();
        a = fhVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fh.class, fhVar);
    }

    private fh() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004ဆ\u0003\u0005င\u0004\u0006ဆ\u0005\u0007င\u0006\bင\u0007\tဈ\b", new Object[]{"b", "c", ff.a, "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k"});
        }
        if (i2 == 3) {
            return new fh();
        }
        if (i2 == 4) {
            return new fe();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = l;
        if (bcVar == null) {
            synchronized (fh.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
