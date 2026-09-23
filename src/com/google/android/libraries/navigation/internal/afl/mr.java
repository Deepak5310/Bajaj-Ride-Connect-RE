package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mr extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final mr a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    private int d;
    private int e;
    private com.google.android.libraries.navigation.internal.adu.b f;
    private mf g;
    private com.google.android.libraries.navigation.internal.adu.o h;
    private com.google.android.libraries.navigation.internal.acd.pb i;
    private com.google.android.libraries.navigation.internal.adg.bg j;
    private byte k = 2;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        mr mrVar = new mr();
        a = mrVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mr.class, mrVar);
    }

    private mr() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.k);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0002\u0001.\u0006\u0000\u0001\u0005\u0001Л\u0011ᐉ\b\u001cဉ\u001e'ᐉ\u0002(ᐉ'.ᐉ\f", new Object[]{"d", "e", "b", ky.class, "g", ContextChain.TAG_INFRA, "f", "j", "h"});
        }
        if (i2 == 3) {
            return new mr();
        }
        if (i2 == 4) {
            return new mq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.k = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (mr.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
