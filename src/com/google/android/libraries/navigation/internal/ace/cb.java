package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cb extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cb a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public ca b;
    private int d;
    private int e;
    private bx f;

    static {
        cb cbVar = new cb();
        a = cbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cb.class, cbVar);
    }

    private cb() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u000217\u0002\u0000\u0000\u00001ဉ\u00007ဉ$", new Object[]{"d", "e", "b", "f"});
        }
        if (i2 == 3) {
            return new cb();
        }
        if (i2 == 4) {
            return new by();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (cb.class) {
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
