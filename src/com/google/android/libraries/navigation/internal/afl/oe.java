package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class oe extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final oe a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    private int d;
    private com.google.android.libraries.navigation.internal.acd.pb e;
    private byte f = 2;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        oe oeVar = new oe();
        a = oeVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(oe.class, oeVar);
    }

    private oe() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0002\u0000\u0001\u0004\u0005\u0002\u0000\u0001\u0001\u0004Л\u0005ဉ\u0001", new Object[]{"d", "b", oa.class, "e"});
        }
        if (i2 == 3) {
            return new oe();
        }
        if (i2 == 4) {
            return new od();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (oe.class) {
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
