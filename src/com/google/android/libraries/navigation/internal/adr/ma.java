package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ma extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ma a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public lg c;
    public int d;
    public String e;
    public lz f;
    public int g;

    static {
        ma maVar = new ma();
        a = maVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ma.class, maVar);
    }

    private ma() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.e = "";
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\t\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0003᠌\u0001\u0005ဈ\u0003\bဉ\u0006\t᠌\u0007", new Object[]{"b", "c", "d", lw.a, "e", "f", "g", lu.a});
        }
        if (i2 == 3) {
            return new ma();
        }
        if (i2 == 4) {
            return new lt();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (ma.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
