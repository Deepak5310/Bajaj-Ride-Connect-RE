package com.google.android.libraries.navigation.internal.ace;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bk a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg p;
    public int b;
    public int c;
    public boolean k;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f162n;
    public boolean o;
    private int q;
    private int r;
    private int s;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;
    public boolean h = true;
    public boolean i = true;
    public boolean j = true;
    public int l = 360;

    static {
        bk bkVar = new bk();
        a = bkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bk.class, bkVar);
    }

    private bk() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\f\u0000\u0005\u0001Ƴ\f\u0000\u0000\u0000\u0001ဇ\u0000\tဇ\u0007\u0012ဇ\u0011\u0016ဇ\u0016\u0017ဇ\u0012\u0018ဇ\u0017\u0019ဇ\b©ဇ*æငAĄဇIƞဇaƳဇ\u0082", new Object[]{"b", "q", "r", "s", "c", "d", "e", "g", ContextChain.TAG_INFRA, "h", "j", "f", "k", "l", "m", "n", "o"});
        }
        if (i2 == 3) {
            return new bk();
        }
        if (i2 == 4) {
            return new bj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = p;
        if (bcVar == null) {
            synchronized (bk.class) {
                bcVar = p;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    p = bcVar;
                }
            }
        }
        return bcVar;
    }
}
