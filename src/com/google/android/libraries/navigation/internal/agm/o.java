package com.google.android.libraries.navigation.internal.agm;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends bi implements cz {
    public static final o a;
    private static volatile dg b;
    private int c;
    private i d;
    private b e;
    private g f;
    private m g;
    private byte h = 2;

    static {
        o oVar = new o();
        a = oVar;
        bi.F(o.class, oVar);
    }

    private o() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0004\u0000\u0001\u0007\u001d\u0004\u0000\u0000\u0004\u0007ᐉ\u0006\bᐉ\u0017\u0010ᐉ\u000b\u001dᐉ\u0012", new Object[]{"c", "d", "g", "e", "f"});
        }
        if (i2 == 3) {
            return new o();
        }
        if (i2 == 4) {
            return new n();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (o.class) {
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
