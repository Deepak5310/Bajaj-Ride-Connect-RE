package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.adr.gh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends bi implements cz {
    public static final n a;
    private static volatile dg b;
    private int c;
    private gh d;
    private al e;
    private bc f;
    private byte g = 2;

    static {
        n nVar = new n();
        a = nVar;
        bi.F(n.class, nVar);
    }

    private n() {
        Object[] objArr = dj.a;
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u00061\u0003\u0000\u0000\u0001\u0006ဉ\u0004\u000fᐉ\u000f1ဉ\u001c", new Object[]{"c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new n();
        }
        if (i2 == 4) {
            return new m();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (n.class) {
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
