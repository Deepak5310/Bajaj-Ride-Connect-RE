package com.google.android.libraries.navigation.internal.acu;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final aj a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile dg f173n;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public boolean j;
    public bz k;
    public bg l;
    public com.google.android.libraries.navigation.internal.aci.b m;

    static {
        aj ajVar = new aj();
        a = ajVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aj.class, ajVar);
    }

    private aj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဍ\u0000\u0002ဍ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bဇ\u0007\tဉ\b\nဉ\t\u000bဉ\n", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m"});
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
        dg bcVar = f173n;
        if (bcVar == null) {
            synchronized (aj.class) {
                bcVar = f173n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f173n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
