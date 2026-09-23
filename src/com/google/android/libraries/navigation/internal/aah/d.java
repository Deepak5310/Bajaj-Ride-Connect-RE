package com.google.android.libraries.navigation.internal.aah;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
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
    private static volatile dg d;
    private byte e = 2;
    public bz c = dj.b;

    static {
        d dVar = new d();
        a = dVar;
        bi.F(d.class, dVar);
        b = bi.t(com.google.android.libraries.navigation.internal.adf.b.a, dVar, dVar, null, 361814206, es.MESSAGE, d.class);
    }

    private d() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"c", c.class});
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
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (d.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void b() {
        bz bzVar = this.c;
        if (bzVar.c()) {
            return;
        }
        this.c = bi.A(bzVar);
    }
}
