package com.google.android.libraries.navigation.internal.add;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ay a;
    private static volatile dg j;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public com.google.android.libraries.navigation.internal.ael.am f;
    public int g;
    public com.google.android.libraries.navigation.internal.ael.am h;
    public int i;

    static {
        ay ayVar = new ay();
        a = ayVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ay.class, ayVar);
    }

    private ay() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0007\u0002င\u0000\u0003င\u0001\u0004ဉ\u0002\u0005င\u0003\u0006ဉ\u0004\u0007\f", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new ay();
        }
        if (i2 == 4) {
            return new ax();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (ay.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
