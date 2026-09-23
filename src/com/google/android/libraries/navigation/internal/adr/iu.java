package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class iu extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final iu a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public int d;
    public int e;

    static {
        iu iuVar = new iu();
        a = iuVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(iu.class, iuVar);
    }

    private iu() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\n\u0003\u0000\u0000\u0000\u0001ည\u0000\u0006᠌\u0006\n᠌\b", new Object[]{"b", "c", "d", is.a, "e", iq.a});
        }
        if (i2 == 3) {
            return new iu();
        }
        if (i2 == 4) {
            return new ip();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (iu.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
