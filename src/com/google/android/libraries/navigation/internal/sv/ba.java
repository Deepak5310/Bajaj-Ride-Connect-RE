package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ba a;
    private static volatile dg e;
    public com.google.android.libraries.navigation.internal.ael.bz b = dj.b;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public boolean d;

    static {
        ba baVar = new ba();
        a = baVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ba.class, baVar);
    }

    private ba() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ț\u0002\n\u0003\u0007", new Object[]{"b", "c", "d"});
        }
        if (i2 == 3) {
            return new ba();
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
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (ba.class) {
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
