package com.google.android.libraries.navigation.internal.acx;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends bi implements cz {
    public static final d a;
    public static final bh b;
    private static volatile dg f;
    public int c;
    public int d;
    public boolean e;
    private byte g = 2;

    static {
        d dVar = new d();
        a = dVar;
        bi.F(d.class, dVar);
        b = bi.t(com.google.android.libraries.navigation.internal.adf.b.a, dVar, dVar, null, 421707520, es.MESSAGE, d.class);
    }

    private d() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\t\n\u0002\u0000\u0000\u0000\t᠌\u0000\nဇ\b", new Object[]{"c", "d", b.a, "e"});
        }
        if (i2 == 3) {
            return new d();
        }
        if (i2 == 4) {
            return new a();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (d.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
