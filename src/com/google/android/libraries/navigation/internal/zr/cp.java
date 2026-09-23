package com.google.android.libraries.navigation.internal.zr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cp a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f669n;
    public int b;
    public long c;
    public int d;
    public int e;
    public int f;
    public am g;
    public am h;
    public int i;
    public int j;
    public am k;
    public int l;
    public int m;

    static {
        cp cpVar = new cp();
        a = cpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cp.class, cpVar);
    }

    private cp() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nင\t\u000bင\n", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m"});
        }
        if (i2 == 3) {
            return new cp();
        }
        if (i2 == 4) {
            return new co();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f669n;
        if (bcVar == null) {
            synchronized (cp.class) {
                bcVar = f669n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f669n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
