package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class he extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final he a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public com.google.android.libraries.navigation.internal.ael.bp b = com.google.android.libraries.navigation.internal.ael.ay.a;
    public int c = -1;
    public boolean d;
    private int f;

    static {
        he heVar = new he();
        a = heVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(he.class, heVar);
    }

    private he() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0001\u0000\u0002င\u0000\u0003ဇ\u0001\u0004$", new Object[]{"f", "c", "d", "b"});
        }
        if (i2 == 3) {
            return new he();
        }
        if (i2 == 4) {
            return new hd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (he.class) {
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
