package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int c;
    public int d;
    public int f;
    private int h;
    private byte i = 2;
    public com.google.android.libraries.navigation.internal.ael.x b = com.google.android.libraries.navigation.internal.ael.x.b;
    public int e = 1;

    static {
        gq gqVar = new gq();
        a = gqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gq.class, gqVar);
    }

    private gq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ည\u0000\u0002င\u0002\u0003င\u0001\u0004᠌\u0003\u0005င\u0004", new Object[]{"h", "b", "d", "c", "e", gn.a, "f"});
        }
        if (i2 == 3) {
            return new gq();
        }
        if (i2 == 4) {
            return new gp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (gq.class) {
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
