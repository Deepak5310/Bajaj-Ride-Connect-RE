package com.google.android.libraries.navigation.internal.aai;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends bi implements cz {
    public static final f a;
    public static final bh b;
    private static volatile dg c;
    private int d;
    private j e;
    private b f;
    private d g;
    private byte h = 2;

    static {
        f fVar = new f();
        a = fVar;
        bi.F(f.class, fVar);
        b = bi.t(com.google.android.libraries.navigation.internal.adf.b.a, fVar, fVar, null, 299174093, es.MESSAGE, f.class);
    }

    private f() {
        Object[] objArr = dj.a;
        bj bjVar = bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0007\u000f\u0003\u0000\u0000\u0003\u0007ᐉ\u0005\u000eᐉ\u0001\u000fᐉ\f", new Object[]{"d", "f", "e", "g"});
        }
        if (i2 == 3) {
            return new f();
        }
        if (i2 == 4) {
            return new e();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (f.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
