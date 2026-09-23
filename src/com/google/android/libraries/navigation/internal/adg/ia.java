package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ia extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final ia a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int c;
    private int g;
    private byte h = 2;
    public com.google.android.libraries.navigation.internal.ael.x b = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bq e = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        ia iaVar = new ia();
        a = iaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ia.class, iaVar);
    }

    private ia() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0002\u0000\u0001ည\u0000\u0003'\u0005'\u0006င\u0001", new Object[]{"g", "b", "d", "e", "c"});
        }
        if (i2 == 3) {
            return new ia();
        }
        if (i2 == 4) {
            return new hz();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (ia.class) {
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
