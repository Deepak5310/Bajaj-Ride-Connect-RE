package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class no extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final com.google.android.libraries.navigation.internal.ael.br a = new nm();
    public static final no b;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int c = 2592000;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;
    private int g;

    static {
        no noVar = new no();
        b = noVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(no.class, noVar);
    }

    private no() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(b, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0002\u0000\u0001င\u0000\u0003\u001b\u0004ࠞ", new Object[]{"g", "c", "e", bc.class, "d", com.google.android.libraries.navigation.internal.adi.am.a});
        }
        if (i2 == 3) {
            return new no();
        }
        if (i2 == 4) {
            return new nn();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (no.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(b);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
