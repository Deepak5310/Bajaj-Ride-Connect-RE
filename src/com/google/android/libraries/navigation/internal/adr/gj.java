package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public Cif c;
    public com.google.android.libraries.navigation.internal.aaq.b d;
    public ar f;
    public gr g;
    public dc h;
    public j i;
    public com.google.android.libraries.navigation.internal.ael.bz j;
    private byte l = 2;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        gj gjVar = new gj();
        a = gjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gj.class, gjVar);
    }

    private gj() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        this.j = com.google.android.libraries.navigation.internal.ael.dj.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\u000e\b\u0000\u0002\u0003\u0001ᐉ\u0000\u0002Л\u0005ᐉ\u0003\u0007ဉ\u0004\nဉ\u0005\u000bဉ\u0007\f\u001b\u000eဉ\u0001", new Object[]{"b", "c", "e", ib.class, "f", "g", "h", ContextChain.TAG_INFRA, "j", gp.class, "d"});
        }
        if (i2 == 3) {
            return new gj();
        }
        if (i2 == 4) {
            return new gi();
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
            synchronized (gj.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.e;
        if (bzVar.c()) {
            return;
        }
        this.e = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
