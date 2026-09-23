package com.google.android.libraries.navigation.internal.acj;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
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
    public long f;
    private int h;

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
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဂ\u0004", new Object[]{"h", "b", "c", "d", "e", "f"});
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
                    bcVar = new bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
