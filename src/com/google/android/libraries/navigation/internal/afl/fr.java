package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fr extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fr a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public boolean b;
    public int c;
    public boolean d;
    private int f;

    static {
        fr frVar = new fr();
        a = frVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fr.class, frVar);
    }

    private fr() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.c = 15;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0005\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0003င\u0002\u0005ဇ\u0003", new Object[]{"f", "b", "c", "d"});
        }
        if (i2 == 3) {
            return new fr();
        }
        if (i2 == 4) {
            return new fq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (fr.class) {
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
