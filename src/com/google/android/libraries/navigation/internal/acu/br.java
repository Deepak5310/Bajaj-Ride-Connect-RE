package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class br extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final br a;
    private static volatile dg f;
    public int b;
    public int d;
    public cs e = cs.a;
    public long c = -1;

    static {
        br brVar = new br();
        a = brVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(br.class, brVar);
    }

    private br() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0000\u0001ဂ\u0000\u00022\u0003င\u0001", new Object[]{"b", "c", "e", bq.a, "d"});
        }
        if (i2 == 3) {
            return new br();
        }
        if (i2 == 4) {
            return new bp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (br.class) {
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
