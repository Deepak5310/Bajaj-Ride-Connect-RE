package com.google.android.libraries.navigation.internal.zr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bi a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg t;
    public int b;
    public int c;
    public int d;
    public fb e;
    public ac f;
    public long g;
    public q i;
    public fd k;
    public fj l;
    public ag m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public de f668n;
    public i o;
    public di p;
    public int q;
    public dx r;
    public bo s;
    private w u;
    private ca v;
    private ex w;
    private byte x = 2;
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bq j = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        bi biVar = new bi();
        a = biVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bi.class, biVar);
    }

    private bi() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.x);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0013\u0000\u0002\u0003?\u0013\u0000\u0002\u0006\u0003င\u0002\u0010ᐉ\f\u0011ᐉ\r\u0012ဉ\u0006\u0013ဉ\u000e\u0014ဉ\u000f\u0015ဉ\u0010\u0016ᐉ\u0011\u0018ဂ\u0007\u0019င\u0013\u001bЛ\u001cဉ\u0015\u001dᐉ\u0016\u001fဉ\t#'$ᐉ\b/ဉ 3ဉ$?ဉ\u0005", new Object[]{"b", "c", "d", "k", "l", "f", "m", "n", "o", ContextChain.TAG_PRODUCT, "g", "q", "h", bg.class, "r", "v", ContextChain.TAG_INFRA, "j", "u", "s", "w", "e"});
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
            this.x = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = t;
        if (bcVar == null) {
            synchronized (bi.class) {
                bcVar = t;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    t = bcVar;
                }
            }
        }
        return bcVar;
    }
}
