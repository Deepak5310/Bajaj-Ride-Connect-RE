package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final bi a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg q;
    public int b;
    public iv c;
    public int e;
    public gi f;
    public fi g;
    public as h;
    public jn i;
    public eh j;
    public hc k;
    public hm l;
    public gy m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f181n;
    public com.google.android.libraries.navigation.internal.ael.bz o;
    public com.google.android.libraries.navigation.internal.ael.bz p;
    private com.google.android.libraries.navigation.internal.aeg.d r;
    private cl s;
    private byte t = 2;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        bi biVar = new bi();
        a = biVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bi.class, biVar);
    }

    private bi() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        this.o = com.google.android.libraries.navigation.internal.ael.dj.b;
        this.p = com.google.android.libraries.navigation.internal.ael.dj.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.t);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0010\u0000\u0001\u0001\u0014\u0010\u0000\u0003\n\u0001ᐉ\u0000\u0002ဉ\u0001\u0003Л\u0006ᐉ\u0005\u0007ᐉ\u0006\bᐉ\u0007\tᐉ\b\nᐉ\t\u000bᐉ\u000b\rဉ\u0012\u000eင\u0013\u000f\u001b\u0010ဋ\u0002\u0011ᐉ\r\u0013\u001b\u0014ᐉ\u000e", new Object[]{"b", "r", "c", "d", ga.class, "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "m", "n", "o", eq.class, "e", "l", ContextChain.TAG_PRODUCT, bu.class, "s"});
        }
        if (i2 == 3) {
            return new bi();
        }
        if (i2 == 4) {
            return new bh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.t = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = q;
        if (bcVar == null) {
            synchronized (bi.class) {
                bcVar = q;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    q = bcVar;
                }
            }
        }
        return bcVar;
    }
}
