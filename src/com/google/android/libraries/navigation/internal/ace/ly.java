package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ly extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ly a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private lx d;

    static {
        ly lyVar = new ly();
        a = lyVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ly.class, lyVar);
    }

    private ly() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\n\n\u0001\u0000\u0000\u0000\nဉ\u000b", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new ly();
        }
        if (i2 == 4) {
            return new lu();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ly.class) {
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
