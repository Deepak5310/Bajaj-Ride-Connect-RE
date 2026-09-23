package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final z a;
    private static volatile dg g;
    public int b;
    public h c;
    public com.google.android.libraries.navigation.internal.ael.bz d = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz e = dj.b;
    public ay f;

    static {
        z zVar = new z();
        a = zVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(z.class, zVar);
    }

    private z() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b\u0004ဉ\u0001", new Object[]{"b", "c", "d", am.class, "e", l.class, "f"});
        }
        if (i2 == 3) {
            return new z();
        }
        if (i2 == 4) {
            return new y();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (z.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
