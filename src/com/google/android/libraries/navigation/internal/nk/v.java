package com.google.android.libraries.navigation.internal.nk;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends bi implements cz {
    public static final v a;
    private static volatile dg l;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    static {
        v vVar = new v();
        a = vVar;
        bi.F(v.class, vVar);
    }

    private v() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k"});
        }
        if (i2 == 3) {
            return new v();
        }
        if (i2 == 4) {
            return new u();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (v.class) {
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
