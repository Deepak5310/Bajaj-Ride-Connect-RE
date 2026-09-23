package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final dp a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public com.google.android.libraries.navigation.internal.ael.bt b = com.google.android.libraries.navigation.internal.ael.cm.a;
    public com.google.android.libraries.navigation.internal.ael.bq c = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        dp dpVar = new dp();
        a = dpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dp.class, dpVar);
    }

    private dp() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001%\u0002'", new Object[]{"b", "c"});
        }
        if (i2 == 3) {
            return new dp();
        }
        if (i2 == 4) {
            return new Cdo();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (dp.class) {
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
