package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ej extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ej a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public boolean b;
    private int d;

    static {
        ej ejVar = new ej();
        a = ejVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ej.class, ejVar);
    }

    private ej() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001''\u0001\u0000\u0000\u0000'ဇ\u0003", new Object[]{"d", "b"});
        }
        if (i2 == 3) {
            return new ej();
        }
        if (i2 == 4) {
            return new ei();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (ej.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
