package com.google.android.libraries.navigation.internal.acu;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bd a;
    private static volatile dg l;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public cs i = cs.a;
    public boolean j;
    public int k;

    static {
        bd bdVar = new bd();
        a = bdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bd.class, bdVar);
    }

    private bd() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\t\u0000\u0001\u0001\t\t\u0001\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u00072\bဇ\u0006\tဍ\u0007", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, bc.a, "j", "k"});
        }
        if (i2 == 3) {
            return new bd();
        }
        if (i2 == 4) {
            return new bb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (bd.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
