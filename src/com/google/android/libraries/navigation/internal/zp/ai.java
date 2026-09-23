package com.google.android.libraries.navigation.internal.zp;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ai a;
    private static volatile dg e;
    public int b;
    public boolean c;
    public boolean d;

    static {
        ai aiVar = new ai();
        a = aiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ai.class, aiVar);
    }

    private ai() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"b", "c", "d"});
        }
        if (i2 == 3) {
            return new ai();
        }
        if (i2 == 4) {
            return new ah();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (ai.class) {
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
