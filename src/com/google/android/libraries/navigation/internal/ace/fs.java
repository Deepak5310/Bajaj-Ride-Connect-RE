package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fs extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fs a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;
    public fr c;
    public fn d;
    private int f;

    static {
        fs fsVar = new fs();
        a = fsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fs.class, fsVar);
    }

    private fs() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0002\u0007\u0003\u0000\u0001\u0000\u0002\u001b\u0006ဉ\u0001\u0007ဉ\u0002", new Object[]{"f", "b", com.google.android.libraries.navigation.internal.adi.bp.class, "c", "d"});
        }
        if (i2 == 3) {
            return new fs();
        }
        if (i2 == 4) {
            return new fo();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (fs.class) {
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
