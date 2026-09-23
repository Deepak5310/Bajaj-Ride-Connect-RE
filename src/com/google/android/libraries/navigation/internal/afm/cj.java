package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public int c;
    public int d;
    private byte h = 2;
    public int e = 1;
    public com.google.android.libraries.navigation.internal.ael.x f = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        cj cjVar = new cj();
        a = cjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cj.class, cjVar);
    }

    private cj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0017\u001a\u0004\u0000\u0000\u0003\u0017ᔄ\u0000\u0018ᔄ\u0001\u0019ᔊ\u0003\u001a᠌\u0002", new Object[]{"b", "c", "d", "f", "e", bz.a});
        }
        if (i2 == 3) {
            return new cj();
        }
        if (i2 == 4) {
            return new ci();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (cj.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
