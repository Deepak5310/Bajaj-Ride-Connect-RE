package com.google.android.libraries.navigation.internal.zp;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bc a;
    private static volatile dg d;
    public int b;
    public int c;

    static {
        bc bcVar = new bc();
        a = bcVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bc.class, bcVar);
    }

    private bc() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0000\u0004᠌\u0003", new Object[]{"b", "c", ba.a});
        }
        if (i2 == 3) {
            return new bc();
        }
        if (i2 == 4) {
            return new az();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (bc.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
