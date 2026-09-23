package com.google.android.libraries.navigation.internal.xt;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final aj a;
    private static volatile dg h;
    public String b = "";
    public boolean c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    private int i;

    static {
        aj ajVar = new aj();
        a = ajVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aj.class, ajVar);
    }

    private aj() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004᠌\u0002\u0005ဇ\u0003\u0006ဇ\u0005\u0007ဇ\u0004", new Object[]{ContextChain.TAG_INFRA, "b", "c", "d", com.google.android.libraries.navigation.internal.aae.a.a, "e", "g", "f"});
        }
        if (i2 == 3) {
            return new aj();
        }
        if (i2 == 4) {
            return new ai();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (aj.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
