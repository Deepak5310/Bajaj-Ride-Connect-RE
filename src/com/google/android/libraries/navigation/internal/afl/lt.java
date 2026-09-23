package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lt extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final lt a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public com.google.android.libraries.navigation.internal.acd.mh c;
    public long d;
    public long e;
    public String f = "";
    public int g;
    public int h;
    public int i;

    static {
        lt ltVar = new lt();
        a = ltVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lt.class, ltVar);
    }

    private lt() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002စ\u0001\u0003င\u0005\u0004င\u0006\u0005င\u0007\u0006စ\u0002\u0007ဈ\u0003", new Object[]{"b", "c", "d", "g", "h", ContextChain.TAG_INFRA, "e", "f"});
        }
        if (i2 == 3) {
            return new lt();
        }
        if (i2 == 4) {
            return new ls();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (lt.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
