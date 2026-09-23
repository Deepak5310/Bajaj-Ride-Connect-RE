package com.google.android.libraries.navigation.internal.aaq;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends bi implements cz {
    public static final k a;
    private static volatile dg d;
    public int b;
    public int c;
    private int e;

    static {
        k kVar = new k();
        a = kVar;
        bi.F(k.class, kVar);
    }

    private k() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001င\u0000\u0003᠌\u0002", new Object[]{"e", "b", "c", com.google.android.libraries.navigation.internal.aao.a.a});
        }
        if (i2 == 3) {
            return new k();
        }
        if (i2 == 4) {
            return new j();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (k.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
