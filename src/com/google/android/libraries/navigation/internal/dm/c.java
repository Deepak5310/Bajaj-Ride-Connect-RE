package com.google.android.libraries.navigation.internal.dm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends bi implements cz {
    public static final c a;
    private static volatile dg j;
    public int b;
    public bz c = dj.b;
    public int d;
    public int e;
    public int f;
    public long g;
    public long h;
    public long i;

    static {
        c cVar = new c();
        a = cVar;
        bi.F(c.class, cVar);
    }

    private c() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0007\u0000\u0001\u0001\n\u0007\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0004င\u0002\u0005င\u0003\bဂ\u0006\tဂ\u0007\nဂ\b", new Object[]{"b", "c", e.class, "d", "e", "f", "g", "h", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new c();
        }
        if (i2 == 4) {
            return new b();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (c.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
