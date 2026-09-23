package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final z a;
    private static volatile dg f;
    public int b;
    public x d;
    public String c = "";
    public bz e = dj.b;

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
            return new dk(a, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u001b", new Object[]{"b", "c", "d", "e", x.class});
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
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (z.class) {
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
