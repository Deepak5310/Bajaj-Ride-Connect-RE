package com.google.android.libraries.navigation.internal.zp;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bv a;
    public static final com.google.android.libraries.navigation.internal.ael.bh b;
    private static volatile dg c;

    static {
        bv bvVar = new bv();
        a = bvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bv.class, bvVar);
        b = com.google.android.libraries.navigation.internal.ael.bi.t(cb.a, bvVar, bvVar, null, 355, es.MESSAGE, bv.class);
    }

    private bv() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new bv();
        }
        if (i2 == 4) {
            return new bu();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (bv.class) {
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
