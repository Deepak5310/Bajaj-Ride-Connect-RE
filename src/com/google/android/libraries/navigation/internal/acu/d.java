package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final d a;
    private static volatile dg d;
    public int b;
    public double c;

    static {
        d dVar = new d();
        a = dVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(d.class, dVar);
    }

    private d() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001က\u0000", new Object[]{"b", "c"});
        }
        if (i2 == 3) {
            return new d();
        }
        if (i2 == 4) {
            return new c();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (d.class) {
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
