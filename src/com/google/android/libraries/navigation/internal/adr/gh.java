package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private ka d;

    static {
        gh ghVar = new gh();
        a = ghVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gh.class, ghVar);
    }

    private gh() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\u0014\u0014\u0001\u0000\u0000\u0000\u0014ဉ\u0000", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new gh();
        }
        if (i2 == 4) {
            return new fw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (gh.class) {
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
