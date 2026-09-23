package com.google.android.libraries.navigation.internal.zp;

import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bs a;
    private static volatile dg b;
    private cs c = cs.a;

    static {
        bs bsVar = new bs();
        a = bsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bs.class, bsVar);
    }

    private bs() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0001\u0000\u0000\u00032", new Object[]{"c", br.a});
        }
        if (i2 == 3) {
            return new bs();
        }
        if (i2 == 4) {
            return new bq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (bs.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
