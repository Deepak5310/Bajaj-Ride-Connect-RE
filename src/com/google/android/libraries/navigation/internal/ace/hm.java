package com.google.android.libraries.navigation.internal.ace;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hm extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final hm a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg t;
    public boolean b;
    public boolean c;
    public hl d;
    public boolean e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f165n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean s;
    private int u;
    private int v;
    private int w;
    private int x;

    static {
        hm hmVar = new hm();
        a = hmVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(hm.class, hmVar);
    }

    private hm() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0012\u0000\u0004\u0007`\u0012\u0000\u0000\u0000\u0007ဇ\b\fဇ\f\u000eဉ\u000e\u000fဇ\u000f\u001d᠌#\u001fဇ-(ဇ6,ဇ80ဇ<5ဇA:ဇGAဇLPဇXQဇYSဇ[Tဇ\\Vင^`ဇe", new Object[]{"u", "v", "w", "x", "b", "c", "d", "e", "f", bl.a, "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s"});
        }
        if (i2 == 3) {
            return new hm();
        }
        if (i2 == 4) {
            return new hd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = t;
        if (bcVar == null) {
            synchronized (hm.class) {
                bcVar = t;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    t = bcVar;
                }
            }
        }
        return bcVar;
    }
}
