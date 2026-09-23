package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class iy extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final iy a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    private int d;
    private jc e;
    private byte f = 2;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        iy iyVar = new iy();
        a = iyVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(iy.class, iyVar);
    }

    private iy() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ᔉ\u0000\u0002\u001a", new Object[]{"d", "e", "b"});
        }
        if (i2 == 3) {
            return new iy();
        }
        if (i2 == 4) {
            return new ix();
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
            synchronized (iy.class) {
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
