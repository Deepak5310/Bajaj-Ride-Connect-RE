package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class pe extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final pe a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f324n;
    public int b;
    public long d;
    public com.google.android.libraries.navigation.internal.adq.al f;
    public boolean h;
    public com.google.android.libraries.navigation.internal.zr.ao j;
    public com.google.android.libraries.navigation.internal.zr.bi k;
    public hw l;
    public gp m;
    private qo o;
    private com.google.android.libraries.navigation.internal.agm.o p;
    private com.google.android.libraries.navigation.internal.zq.w q;
    private byte r = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String e = "";
    public com.google.android.libraries.navigation.internal.ael.bz g = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz i = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        pe peVar = new pe();
        a = peVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(pe.class, peVar);
    }

    private pe() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.r);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u000e\u0000\u0001\u0001$\u000e\u0000\u0003\u0007\u0001\u001b\u0002ဂ\u0000\u0003ᐉ\u0002\u0004ᐉ\u0007\u0005ဈ\u0001\u0011ဉ\b\u0014ᐉ\u000b\u0016ᐉ\r\u0019ᐉ\u0010\u001dЛ\u001eဇ\u0005 Л!ဉ\u0006$ဉ\u0013", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.aes.h.class, "d", "f", "k", "e", "l", "o", "m", ContextChain.TAG_PRODUCT, "g", qs.class, "h", ContextChain.TAG_INFRA, cq.class, "j", "q"});
        }
        if (i2 == 3) {
            return new pe();
        }
        if (i2 == 4) {
            return new pd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.r = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f324n;
        if (bcVar == null) {
            synchronized (pe.class) {
                bcVar = f324n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f324n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
