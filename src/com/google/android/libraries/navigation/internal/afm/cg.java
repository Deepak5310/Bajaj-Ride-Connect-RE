package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public int c;
    private int f;
    private byte g = 2;
    public com.google.android.libraries.navigation.internal.ael.x d = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        cg cgVar = new cg();
        a = cgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cg.class, cgVar);
    }

    private cg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0001$&\u0003\u0000\u0000\u0003$ᔄ\u0000%ᔄ\u0001&ᔊ\u0002", new Object[]{"f", "b", "c", "d"});
        }
        if (i2 == 3) {
            return new cg();
        }
        if (i2 == 4) {
            return new cf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (cg.class) {
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
