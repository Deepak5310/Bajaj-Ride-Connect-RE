package com.google.android.libraries.navigation.internal.zp;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cb extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final cb a;
    private static volatile dg h;
    public int b;
    public int c;
    public int f;
    public h g;
    private byte i = 2;
    public int d = -1;
    public com.google.android.libraries.navigation.internal.ael.bq e = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        cb cbVar = new cb();
        a = cbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cb.class, cbVar);
    }

    private cb() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0005\u0000\u0001\u0001è\u0005\u0000\u0001\u0001\u0001င\u0000\u0003င\u0001\u0004\u0016\u0006᠌\u0005èᐉ\t", new Object[]{"b", "c", "d", "e", "f", bz.a, "g"});
        }
        if (i2 == 3) {
            return new cb();
        }
        if (i2 == 4) {
            return new by();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (cb.class) {
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
