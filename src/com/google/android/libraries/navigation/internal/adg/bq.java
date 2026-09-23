package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public long c;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int e;

    static {
        bq bqVar = new bq();
        a = bqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bq.class, bqVar);
    }

    private bq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဂ\u0000\u0002\u001b\u0003င\u0001", new Object[]{"b", "c", "d", bo.class, "e"});
        }
        if (i2 == 3) {
            return new bq();
        }
        if (i2 == 4) {
            return new bp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (bq.class) {
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
