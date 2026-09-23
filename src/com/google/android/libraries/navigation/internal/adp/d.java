package com.google.android.libraries.navigation.internal.adp;

import com.google.android.libraries.navigation.internal.aax.f;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends bi implements cz {
    public static final d a;
    private static volatile dg b;
    private int c;
    private f d;
    private byte e = 2;

    static {
        d dVar = new d();
        a = dVar;
        bi.F(d.class, dVar);
    }

    private d() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001\u0006ᐉ\t", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new d();
        }
        if (i2 == 4) {
            return new c();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (d.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
