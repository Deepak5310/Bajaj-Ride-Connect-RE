package com.google.android.libraries.navigation.internal.adl;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad extends bi implements cz {
    public static final ad a;
    private static volatile dg c;
    public bz b = dj.b;

    static {
        ad adVar = new ad();
        a = adVar;
        bi.F(ad.class, adVar);
    }

    private ad() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"b", z.class});
        }
        if (i2 == 3) {
            return new ad();
        }
        if (i2 == 4) {
            return new ac();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (ad.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
