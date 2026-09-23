package com.google.android.libraries.navigation.internal.acm;

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
public final class aa extends bi implements cz {
    public static final aa a;
    private static volatile dg l;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public t j;
    public int i = 1;
    public bz k = dj.b;

    static {
        aa aaVar = new aa();
        a = aaVar;
        bi.F(aa.class, aaVar);
    }

    private aa() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\t\u0000\u0001\u0001\n\t\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\tဉ\u0007\n\u001b", new Object[]{"b", "c", "d", "e", "f", "g", u.a, "h", y.a, ContextChain.TAG_INFRA, w.a, "j", "k", o.class});
        }
        if (i2 == 3) {
            return new aa();
        }
        if (i2 == 4) {
            return new p();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (aa.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
