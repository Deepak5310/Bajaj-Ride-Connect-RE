package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class qt extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final qt a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private oz d;

    static {
        qt qtVar = new qt();
        a = qtVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(qt.class, qtVar);
    }

    private qt() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\b\b\u0001\u0000\u0000\u0000\bဉ\u0007", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new qt();
        }
        if (i2 == 4) {
            return new qs();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (qt.class) {
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
