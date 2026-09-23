package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mr extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mr a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private int d;
    private com.google.android.libraries.navigation.internal.afl.lr e;
    private com.google.android.libraries.navigation.internal.adq.al f;
    private oz g;
    private byte h = 2;

    static {
        mr mrVar = new mr();
        a = mrVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mr.class, mrVar);
    }

    private mr() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0002\u0002\u0016\u0003\u0000\u0000\u0001\u0002ဉ\u0002\u0003ᐉ\u0004\u0016ဉ\"", new Object[]{"c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new mr();
        }
        if (i2 == 4) {
            return new mq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (mr.class) {
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
