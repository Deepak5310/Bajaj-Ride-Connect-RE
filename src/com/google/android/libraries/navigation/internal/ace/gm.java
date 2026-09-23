package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gm extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gm a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public ga c;
    public com.google.android.libraries.navigation.internal.ael.cs d = com.google.android.libraries.navigation.internal.ael.cs.a;
    public com.google.android.libraries.navigation.internal.ael.cs e = com.google.android.libraries.navigation.internal.ael.cs.a;
    private byte g = 2;

    static {
        gm gmVar = new gm();
        a = gmVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gm.class, gmVar);
    }

    private gm() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\b\u0003\u0002\u0000\u0001\u0001ᐉ\u0000\u00032\b2", new Object[]{"b", "c", "d", gh.a, "e", gg.a});
        }
        if (i2 == 3) {
            return new gm();
        }
        if (i2 == 4) {
            return new gd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (gm.class) {
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
