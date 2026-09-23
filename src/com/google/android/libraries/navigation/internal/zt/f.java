package com.google.android.libraries.navigation.internal.zt;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends bi implements cz {
    public static final f a;
    private static volatile dg f;
    public int b;
    public long c;
    public int d;
    public int e;
    private byte g = 2;

    static {
        f fVar = new f();
        a = fVar;
        bi.F(f.class, fVar);
    }

    private f() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔂ\u0000\u0002ᔆ\u0001\u0003ᔆ\u0002", new Object[]{"b", "c", "d", "e"});
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
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (f.class) {
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
