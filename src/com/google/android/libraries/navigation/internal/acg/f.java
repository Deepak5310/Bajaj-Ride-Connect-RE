package com.google.android.libraries.navigation.internal.acg;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bu;
import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends bi implements cz {
    public static final f a;
    public static final bu d = new bu(c.e, c.DECORATION_RELEVANCE_STATE_UNSPECIFIED);
    private static volatile dg e;
    public int b;
    public cs c = cs.a;
    private int f;

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
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0001\u0000\u0000\u0001င\u0000\u0002࠲", new Object[]{"f", "b", "c", e.a, b.a});
        }
        if (i2 == 3) {
            return new f();
        }
        if (i2 == 4) {
            return new d();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (f.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
