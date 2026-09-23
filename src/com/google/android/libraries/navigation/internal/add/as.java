package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final as a;
    private static volatile dg f;
    public int b;
    public au c;
    public au d;
    public boolean e;

    static {
        as asVar = new as();
        a = asVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(as.class, asVar);
    }

    private as() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0007", new Object[]{"b", "c", "d", "e"});
        }
        if (i2 == 3) {
            return new as();
        }
        if (i2 == 4) {
            return new ar();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (as.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
