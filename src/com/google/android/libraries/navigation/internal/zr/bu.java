package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bu extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bu a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public long c;
    public boolean d;
    private int f;

    static {
        bu buVar = new bu();
        a = buVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bu.class, buVar);
    }

    private bu() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"f", "b", "c", "d"});
        }
        if (i2 == 3) {
            return new bu();
        }
        if (i2 == 4) {
            return new bt();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (bu.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
