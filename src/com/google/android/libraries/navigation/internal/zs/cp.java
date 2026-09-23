package com.google.android.libraries.navigation.internal.zs;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cp a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg r;
    public int b;
    public int c;
    public boolean d;
    public com.google.android.libraries.navigation.internal.ael.ed e;
    public com.google.android.libraries.navigation.internal.afj.b f;
    public long g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f674n;
    public int o;
    public int p;
    public int q;

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
            com.google.android.libraries.navigation.internal.ael.bo boVar = cq.a;
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000f\u0000\u0001\u0001\u001c\u000f\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0006ဉ\u0003\u0007င\u0005\bင\u0006\t᠌\u0007\nဇ\b\fင\t\rင\n\u000eဏ\u000b\u000fင\f\u0011င\u000f\u001bဂ\u0004\u001cဏ\r", new Object[]{"b", "c", boVar, "d", "e", "f", "h", ContextChain.TAG_INFRA, "j", com.google.android.libraries.navigation.internal.ady.ak.a, "k", "l", "m", "n", "o", "q", "g", ContextChain.TAG_PRODUCT});
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
        com.google.android.libraries.navigation.internal.ael.dg bcVar = r;
        if (bcVar == null) {
            synchronized (cp.class) {
                bcVar = r;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    r = bcVar;
                }
            }
        }
        return bcVar;
    }
}
