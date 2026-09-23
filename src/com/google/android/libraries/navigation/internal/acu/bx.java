package com.google.android.libraries.navigation.internal.acu;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bx extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bx a;
    private static volatile dg k;
    public int b;
    public bv c;
    public bv d;
    public bv e;
    public bv f;
    public float g;
    public bv h;
    public bv i;
    public int j;

    static {
        bx bxVar = new bx();
        a = bxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bx.class, bxVar);
    }

    private bx() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ခ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bင\u0007", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new bx();
        }
        if (i2 == 4) {
            return new bw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = k;
        if (bcVar == null) {
            synchronized (bx.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
