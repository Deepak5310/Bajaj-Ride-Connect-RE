package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final lh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg o;
    public int b;
    public int f;
    public int g;
    public com.google.android.libraries.navigation.internal.adr.ku j;
    public le m;
    private lr p;
    private com.google.android.libraries.navigation.internal.ael.cs q = com.google.android.libraries.navigation.internal.ael.cs.a;
    private byte r = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz i = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz k = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.x l = com.google.android.libraries.navigation.internal.ael.x.b;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.ael.bz f318n = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        lh lhVar = new lh();
        a = lhVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lh.class, lhVar);
    }

    private lh() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.r);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\r\u0000\u0001\u0001(\r\u0001\u0006\u0005\u0001\u001b\u0002Л\u0003င\u0001\u0004᠌\u0003\u0005ဉ\u0004\b\u001b\u0011ᐉ\t\u0013Л\u0018ည\f\u001aЛ\"ᐉ\u0010%\u001b(2", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.adr.ma.class, "d", com.google.android.libraries.navigation.internal.adr.ki.class, "f", "g", com.google.android.libraries.navigation.internal.adr.as.a, ContextChain.TAG_PRODUCT, ContextChain.TAG_INFRA, la.class, "j", "k", com.google.android.libraries.navigation.internal.adr.bb.class, "l", "h", com.google.android.libraries.navigation.internal.adr.el.class, "m", "n", lg.class, "q", lc.a});
        }
        if (i2 == 3) {
            return new lh();
        }
        if (i2 == 4) {
            return new lb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.r = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = o;
        if (bcVar == null) {
            synchronized (lh.class) {
                bcVar = o;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    o = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void e() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.d;
        if (bzVar.c()) {
            return;
        }
        this.d = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
