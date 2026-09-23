package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final dl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c;
    public int d;
    public dj e;
    public boolean f;
    public boolean g;

    static {
        dl dlVar = new dl();
        a = dlVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dl.class, dlVar);
    }

    private dl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0001\u0002ဉ\u0002\u0003ဇ\u0003\u0004င\u0000\u0005ဇ\u0004", new Object[]{"b", "d", "e", "f", "c", "g"});
        }
        if (i2 == 3) {
            return new dl();
        }
        if (i2 == 4) {
            return new dk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (dl.class) {
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
