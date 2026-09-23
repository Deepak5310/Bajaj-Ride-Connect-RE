package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ea extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final ea a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public int c;
    public dt d;
    public dt e;
    public int g;
    public ef i;
    public int j;
    private byte l = 2;
    public long f = -1;
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        ea eaVar = new ea();
        a = eaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ea.class, eaVar);
    }

    private ea() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0003\u0001င\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006\u001b\u0007ᐉ\u0006\bင\u0007", new Object[]{"b", "c", "d", "e", "f", "g", "h", w.class, ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new ea();
        }
        if (i2 == 4) {
            return new dz();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (ea.class) {
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
