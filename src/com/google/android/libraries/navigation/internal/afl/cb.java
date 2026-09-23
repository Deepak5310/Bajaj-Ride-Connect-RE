package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.acd.rf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cb extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cb a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private mp d;
    private lz e;
    private rf f;
    private com.google.android.libraries.navigation.internal.acd.gl g;
    private com.google.android.libraries.navigation.internal.acd.hz h;
    private com.google.android.libraries.navigation.internal.acd.qn i;
    private eu j;
    private ki k;
    private com.google.android.libraries.navigation.internal.acd.id l;
    private com.google.android.libraries.navigation.internal.acd.id m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.acd.oz f305n;
    private byte o = 2;

    static {
        cb cbVar = new cb();
        a = cbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cb.class, cbVar);
    }

    private cb() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.o);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u000b\u0000\u0001\u0003\u0010\u000b\u0000\u0000\n\u0003ᐉ\u0001\u0004ᐉ\u0002\u0005ᐉ\u0003\u0006ᐉ\u0006\tᐉ\b\nᐉ\t\fဉ\f\rᐉ\n\u000eᐉ\u000b\u000fᐉ\u0004\u0010ᐉ\u0005", new Object[]{"c", "d", "e", "f", ContextChain.TAG_INFRA, "j", "k", "n", "l", "m", "g", "h"});
        }
        if (i2 == 3) {
            return new cb();
        }
        if (i2 == 4) {
            return new ca();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.o = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (cb.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
