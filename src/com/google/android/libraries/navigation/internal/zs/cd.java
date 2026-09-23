package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cd extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cd a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public int c;
    public int d;

    static {
        cd cdVar = new cd();
        a = cdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cd.class, cdVar);
    }

    private cd() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဆ\u0000\u0002᠌\u0001", new Object[]{"b", "c", "d", cb.a});
        }
        if (i2 == 3) {
            return new cd();
        }
        if (i2 == 4) {
            return new ca();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (cd.class) {
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
