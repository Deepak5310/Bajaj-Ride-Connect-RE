package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final lp a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    public com.google.android.libraries.navigation.internal.afm.z c;
    private oz e;
    private com.google.android.libraries.navigation.internal.adq.al f;
    private byte g = 2;

    static {
        lp lpVar = new lp();
        a = lpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lp.class, lpVar);
    }

    private lp() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0000\u0002\u0002ᐉ\u0000\u0003ဉ\u0001\u0004ᐉ\u0002", new Object[]{"b", "c", "e", "f"});
        }
        if (i2 == 3) {
            return new lp();
        }
        if (i2 == 4) {
            return new lo();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (lp.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
