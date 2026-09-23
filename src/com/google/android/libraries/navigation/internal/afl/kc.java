package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kc extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final kc a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public boolean b;
    private int d;

    static {
        kc kcVar = new kc();
        a = kcVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(kc.class, kcVar);
    }

    private kc() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\r\r\u0001\u0000\u0000\u0000\rဇ\t", new Object[]{"d", "b"});
        }
        if (i2 == 3) {
            return new kc();
        }
        if (i2 == 4) {
            return new kb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (kc.class) {
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
