package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gk a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    static {
        gk gkVar = new gk();
        a = gkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gk.class, gkVar);
    }

    private gk() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဆ\u0000\u0002င\u0001\u0003ဆ\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"b", "c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new gk();
        }
        if (i2 == 4) {
            return new gj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (gk.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
