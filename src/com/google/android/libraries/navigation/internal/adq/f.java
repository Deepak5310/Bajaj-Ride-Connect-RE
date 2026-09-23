package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends bi implements cz {
    public static final f a;
    private static volatile dg g;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    static {
        f fVar = new f();
        a = fVar;
        bi.F(f.class, fVar);
    }

    private f() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.aeh.a.a, "d", "e", "f"});
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
            throw null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (f.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
