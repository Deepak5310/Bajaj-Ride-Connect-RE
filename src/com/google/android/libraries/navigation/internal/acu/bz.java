package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bz extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bz a;
    private static volatile dg g;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public com.google.android.libraries.navigation.internal.ael.bq f = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        bz bzVar = new bz();
        a = bzVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bz.class, bzVar);
    }

    private bz() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဇ\u0000\u0002ဍ\u0001\u0003ဍ\u0002\u0004-", new Object[]{"b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new bz();
        }
        if (i2 == 4) {
            return new by();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (bz.class) {
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
