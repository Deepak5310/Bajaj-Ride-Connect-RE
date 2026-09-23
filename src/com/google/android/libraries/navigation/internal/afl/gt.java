package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gt extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gt a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private gh d;
    private com.google.android.libraries.navigation.internal.acd.oz e;
    private byte f = 2;

    static {
        gt gtVar = new gt();
        a = gtVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gt.class, gtVar);
    }

    private gt() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0002\u0000\u0001\u0002\u0004\u0002\u0000\u0000\u0001\u0002ᐉ\u0001\u0004ဉ\u0004", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new gt();
        }
        if (i2 == 4) {
            return new gs();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (gt.class) {
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
