package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final v a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public z d;
    private ab f;
    private r g;
    private byte h = 2;
    public int c = 1;

    static {
        v vVar = new v();
        a = vVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(v.class, vVar);
    }

    private v() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0004\u0000\u0001\u0001\u000e\u0004\u0000\u0000\u0004\u0001ᴌ\u0000\u0002ᐉ\u0001\rᐉ\u0004\u000eᐉ\u0005", new Object[]{"b", "c", t.a, "d", "f", "g"});
        }
        if (i2 == 3) {
            return new v();
        }
        if (i2 == 4) {
            return new s();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (v.class) {
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
