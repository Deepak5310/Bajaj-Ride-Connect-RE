package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    private int g;

    static {
        fl flVar = new fl();
        a = flVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fl.class, flVar);
    }

    private fl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0005\u0018\u0004\u0000\u0000\u0000\u0005ဇ\u0004\u0007ဇ\u0006\u0014ဇ\u0013\u0018ဇ\u0017", new Object[]{"g", "b", "c", "d", "e"});
        }
        if (i2 == 3) {
            return new fl();
        }
        if (i2 == 4) {
            return new fk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (fl.class) {
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
