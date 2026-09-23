package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bu extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bu a;
    private static volatile dg d;
    public int b = 0;
    public Object c;

    static {
        bu buVar = new bu();
        a = buVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bu.class, buVar);
    }

    private bu() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0000\u0003\u0001\u0000\u0001\u0006\u0003\u0000\u0000\u0000\u0001<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"c", "b", bs.class, bq.class, bo.class});
        }
        if (i2 == 3) {
            return new bu();
        }
        if (i2 == 4) {
            return new bm();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (bu.class) {
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
