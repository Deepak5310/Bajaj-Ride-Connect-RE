package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public int c = 0;
    public Object d;
    public fe e;

    static {
        fg fgVar = new fg();
        a = fgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fg.class, fgVar);
    }

    private fg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001<\u0000\u0003ဉ\u0000\u0004<\u0000", new Object[]{"d", "c", "b", ab.class, "e", ex.class});
        }
        if (i2 == 3) {
            return new fg();
        }
        if (i2 == 4) {
            return new fc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (fg.class) {
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
