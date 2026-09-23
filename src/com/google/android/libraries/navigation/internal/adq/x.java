package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends bi implements cz {
    public static final x a;
    private static volatile dg b;
    private int c;
    private bg d;
    private com.google.android.libraries.navigation.internal.zq.n e;
    private byte f = 2;

    static {
        x xVar = new x();
        a = xVar;
        bi.F(x.class, xVar);
    }

    private x() {
        Object[] objArr = dj.a;
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0002\u0000\u0001\"7\u0002\u0000\u0000\u0002\"ᐉ\b7ᐉ\f", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new x();
        }
        if (i2 == 4) {
            return new w();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (x.class) {
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
