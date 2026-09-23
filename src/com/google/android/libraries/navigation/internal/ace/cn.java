package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cn extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cn a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    public com.google.android.libraries.navigation.internal.ael.bq c = com.google.android.libraries.navigation.internal.ael.bj.a;
    private cm e;

    static {
        cn cnVar = new cn();
        a = cnVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cn.class, cnVar);
    }

    private cn() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001'\u0002ဉ\u0000", new Object[]{"b", "c", "e"});
        }
        if (i2 == 3) {
            return new cn();
        }
        if (i2 == 4) {
            return new ck();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (cn.class) {
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
