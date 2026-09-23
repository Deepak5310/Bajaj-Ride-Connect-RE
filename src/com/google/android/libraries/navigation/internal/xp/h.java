package com.google.android.libraries.navigation.internal.xp;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends bi implements cz {
    public static final h a;
    private static volatile dg j;
    public int b;
    public String c = "";
    public x d = x.b;
    public String e = "";
    public bz f = dj.b;
    public bz g = dj.b;
    public boolean h;
    public long i;

    static {
        h hVar = new h();
        a = hVar;
        bi.F(h.class, hVar);
    }

    private h() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001ဈ\u0002\u0002ဈ\u0000\u0003ည\u0001\u0004\u001b\u0005\u001a\bဇ\u0003\tဂ\u0004", new Object[]{"b", "e", "c", "d", "f", k.class, "g", "h", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new h();
        }
        if (i2 == 4) {
            return new g();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (h.class) {
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
