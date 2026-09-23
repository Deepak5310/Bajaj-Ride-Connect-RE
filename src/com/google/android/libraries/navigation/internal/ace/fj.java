package com.google.android.libraries.navigation.internal.ace;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    private int l;

    static {
        fj fjVar = new fj();
        a = fjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fj.class, fjVar);
    }

    private fj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\t\u0000\u0001\u0006\u0011\t\u0000\u0000\u0000\u0006ဇ\u0002\u0007ဇ\u0003\tဇ\u0006\nဇ\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000fဇ\u000b\u0011ဇ\r", new Object[]{"l", "b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new fj();
        }
        if (i2 == 4) {
            return new fi();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (fj.class) {
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
