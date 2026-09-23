package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ky extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ky a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private int d;
    private int e;
    private int f;
    private com.google.android.libraries.navigation.internal.aav.g g;
    private com.google.android.libraries.navigation.internal.adq.x h;
    private com.google.android.libraries.navigation.internal.adw.e i;
    private com.google.android.libraries.navigation.internal.adq.ba j;
    private com.google.android.libraries.navigation.internal.adg.bg k;
    private com.google.android.libraries.navigation.internal.aeb.e l;
    private byte m = 2;

    static {
        ky kyVar = new ky();
        a = kyVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ky.class, kyVar);
    }

    private ky() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.m);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0004\u0017°\u0006\u0000\u0000\u0004\u0017ᐉ,BᐉWqဉG\u0086ᐉa\u008fဉ\u0011°ᐉn", new Object[]{"c", "d", "e", "f", "h", "j", ContextChain.TAG_INFRA, "k", "g", "l"});
        }
        if (i2 == 3) {
            return new ky();
        }
        if (i2 == 4) {
            return new kx();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.m = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ky.class) {
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
