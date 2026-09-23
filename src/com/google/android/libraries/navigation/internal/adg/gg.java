package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gg extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final gg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public h c;
    public int d;
    public int e;
    public int h;
    public int i;
    private fs k;
    private byte l = 2;
    public int f = -1;
    public long g = -1;

    static {
        gg ggVar = new gg();
        a = ggVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gg.class, ggVar);
    }

    private gg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0002\u0001ᐉ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဂ\u0004\u0006င\u0005\u0007ဆ\u0006\bᐉ\u0007", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "k"});
        }
        if (i2 == 3) {
            return new gg();
        }
        if (i2 == 4) {
            return new gf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (gg.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
