package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ia extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ia a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.acd.oz d;

    static {
        ia iaVar = new ia();
        a = iaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ia.class, iaVar);
    }

    private ia() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0001\u0000\u0001\b\b\u0001\u0000\u0000\u0000\bဉ\u0007", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new ia();
        }
        if (i2 == 4) {
            return new hz();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ia.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
