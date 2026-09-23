package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class el extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final el a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private eq d;
    private b e;

    static {
        el elVar = new el();
        a = elVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(el.class, elVar);
    }

    private el() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\r\u000f\u0002\u0000\u0000\u0000\rဉ\f\u000fဉ\u000e", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new el();
        }
        if (i2 == 4) {
            return new ek();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (el.class) {
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
