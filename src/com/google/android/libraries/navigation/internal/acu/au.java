package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final au a;
    private static volatile dg c;
    public com.google.android.libraries.navigation.internal.ael.bz b = dj.b;

    static {
        au auVar = new au();
        a = auVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(au.class, auVar);
    }

    private au() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"b", as.class});
        }
        if (i2 == 3) {
            return new au();
        }
        if (i2 == 4) {
            return new at();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (au.class) {
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
