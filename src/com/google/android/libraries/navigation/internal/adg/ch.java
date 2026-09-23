package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ch extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ch a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    static {
        ch chVar = new ch();
        a = chVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ch.class, chVar);
    }

    private ch() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0006င\u0005", new Object[]{"b", "c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new ch();
        }
        if (i2 == 4) {
            return new cf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (ch.class) {
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
