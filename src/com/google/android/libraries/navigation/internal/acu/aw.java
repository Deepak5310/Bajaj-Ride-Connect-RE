package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final aw a;
    private static volatile dg f;
    public int b;
    public int c = 0;
    public Object d;
    public long e;

    static {
        aw awVar = new aw();
        a = awVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aw.class, awVar);
    }

    private aw() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\r\u0001\u0001\u0001d\r\u0000\u0000\u0000\u0001စ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000d<\u0000", new Object[]{"d", "c", "b", "e", bi.class, cb.class, cd.class, x.class, v.class, f.class, d.class, b.class, r.class, ab.class, bo.class, n.class});
        }
        if (i2 == 3) {
            return new aw();
        }
        if (i2 == 4) {
            return new av();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (aw.class) {
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
