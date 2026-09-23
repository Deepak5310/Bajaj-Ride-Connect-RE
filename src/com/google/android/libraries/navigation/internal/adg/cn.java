package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cn extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cn a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;

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
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0000\u0001\u001b\u0002\u001b\u0003\u001b", new Object[]{"b", cp.class, "c", cp.class, "d", cp.class});
        }
        if (i2 == 3) {
            return new cn();
        }
        if (i2 == 4) {
            return new cm();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (cn.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
