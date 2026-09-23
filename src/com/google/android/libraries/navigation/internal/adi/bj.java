package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bj a;
    private static volatile dg e;
    public int b;
    public boolean c;
    public int d;

    static {
        bj bjVar = new bj();
        a = bjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bj.class, bjVar);
    }

    private bj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"b", "c"});
        }
        if (i2 == 3) {
            return new bj();
        }
        if (i2 == 4) {
            return new bi();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (bj.class) {
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
