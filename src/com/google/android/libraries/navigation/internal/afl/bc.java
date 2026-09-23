package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final com.google.android.libraries.navigation.internal.ael.br a = new ba();
    public static final bc b;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int c;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    private int f;

    static {
        bc bcVar = new bc();
        b = bcVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bc.class, bcVar);
    }

    private bc() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(b, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0001\u0000\u0001င\u0000\u0003ࠞ", new Object[]{"f", "c", "d", com.google.android.libraries.navigation.internal.adi.am.a});
        }
        if (i2 == 3) {
            return new bc();
        }
        if (i2 == 4) {
            return new bb();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (bc.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(b);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
