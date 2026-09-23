package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final x a;
    private static volatile dg g;
    public int b;
    public int c;
    public int e;
    private boolean h;
    private com.google.android.libraries.navigation.internal.ado.n i;
    private byte j = 2;
    public String d = "";
    public com.google.android.libraries.navigation.internal.ael.bz f = dj.b;

    static {
        x xVar = new x();
        a = xVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(x.class, xVar);
    }

    private x() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0005\u0000\u0001\u0001\b\u0005\u0000\u0001\u0002\u0001᠌\u0000\u0002ဈ\u0001\u0003င\u0002\u0004Л\bᐉ\u0007", new Object[]{"b", "c", v.a, "d", "e", "f", t.class, ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new x();
        }
        if (i2 == 4) {
            return new u();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (x.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
