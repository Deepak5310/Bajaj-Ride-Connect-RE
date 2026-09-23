package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hg extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final hg a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f201n;
    public int b;
    public ho c;
    public df d;
    public hk e;
    public long f;
    public int g;
    public com.google.android.libraries.navigation.internal.adq.d h;
    public com.google.android.libraries.navigation.internal.adq.d i;
    public com.google.android.libraries.navigation.internal.adq.d j;
    public int k;
    public int l;
    public boolean m;
    private byte o = 2;

    static {
        hg hgVar = new hg();
        a = hgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(hg.class, hgVar);
    }

    private hg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.o);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000b\u0000\u0001\u0001\f\u000b\u0000\u0000\u0001\u0001ဉ\u0000\u0002ᐉ\u0001\u0003ဉ\u0002\u0004စ\u0003\u0005ဉ\u0005\u0007ဉ\u0006\bင\b\tင\t\nဇ\n\u000bဉ\u0007\fင\u0004", new Object[]{"b", "c", "d", "e", "f", "h", ContextChain.TAG_INFRA, "k", "l", "m", "j", "g"});
        }
        if (i2 == 3) {
            return new hg();
        }
        if (i2 == 4) {
            return new hf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.o = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f201n;
        if (bcVar == null) {
            synchronized (hg.class) {
                bcVar = f201n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f201n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
