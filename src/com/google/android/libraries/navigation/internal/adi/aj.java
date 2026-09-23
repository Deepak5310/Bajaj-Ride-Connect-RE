package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final aj a;
    private static volatile dg l;
    public int b;
    public ap e;
    public int f;
    public h g;
    public bx h;
    public bj i;
    public com.google.android.libraries.navigation.internal.ael.bq j;
    public com.google.android.libraries.navigation.internal.adf.b k;
    private byte m = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz d = dj.b;

    static {
        aj ajVar = new aj();
        a = ajVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aj.class, ajVar);
    }

    private aj() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        this.j = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.m);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\t\u0000\u0001\u0001\u001b\t\u0000\u0003\u0004\u0001Л\u0002Л\u0003ᐉ\u0001\u0004᠌\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0016ဉ\u000b\u0017'\u001bᐉ\u0015", new Object[]{"b", "c", bd.class, "d", x.class, "e", "f", ah.a, "g", "h", ContextChain.TAG_INFRA, "j", "k"});
        }
        if (i2 == 3) {
            return new aj();
        }
        if (i2 == 4) {
            return new ag();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.m = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (aj.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.d;
        if (bzVar.c()) {
            return;
        }
        this.d = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
