package com.google.android.libraries.navigation.internal.zp;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final r a;
    public static final com.google.android.libraries.navigation.internal.ael.bh b;
    private static volatile dg e;
    public int c;
    public t d;

    static {
        r rVar = new r();
        a = rVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(r.class, rVar);
        b = com.google.android.libraries.navigation.internal.ael.bi.t(cb.a, rVar, rVar, null, 312, es.MESSAGE, r.class);
    }

    private r() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0001\u000e\u000e\u0001\u0000\u0000\u0000\u000eဉ\r", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new r();
        }
        if (i2 == 4) {
            return new q();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (r.class) {
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
