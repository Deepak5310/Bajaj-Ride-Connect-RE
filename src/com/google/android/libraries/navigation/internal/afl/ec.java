package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ec extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ec a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public com.google.android.libraries.navigation.internal.ael.bq b = com.google.android.libraries.navigation.internal.ael.bj.a;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    private int h;

    static {
        ec ecVar = new ec();
        a = ecVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ec.class, ecVar);
    }

    private ec() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0001\u0000\u0001\u0016\u0002ဇ\u0000\u0005ဇ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"h", "b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new ec();
        }
        if (i2 == 4) {
            return new eb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (ec.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
