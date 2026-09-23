package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mz extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mz a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public mt b;
    private int d;
    private com.google.android.libraries.navigation.internal.acd.pb e;
    private byte f = 2;

    static {
        mz mzVar = new mz();
        a = mzVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mz.class, mzVar);
    }

    private mz() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0005\u0002\u0000\u0000\u0001\u0001ᐉ\u0000\u0005ဉ\u0004", new Object[]{"d", "b", "e"});
        }
        if (i2 == 3) {
            return new mz();
        }
        if (i2 == 4) {
            return new my();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (mz.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
