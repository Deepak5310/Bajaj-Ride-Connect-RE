package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hv extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    private static volatile com.google.android.libraries.navigation.internal.ael.dg A;
    public static final hv a;
    public int b;
    public Cif d;
    public com.google.android.libraries.navigation.internal.aaq.ap e;
    public hq f;
    public id g;
    public ah h;
    public int i;
    public int j;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f225n;
    public com.google.android.libraries.navigation.internal.adq.h q;
    public int s;
    public boolean t;
    public int w;
    private byte B = 2;
    public String c = "";
    public int k = 3;
    public com.google.android.libraries.navigation.internal.ael.bz o = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz p = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz r = com.google.android.libraries.navigation.internal.ael.dj.b;
    public boolean u = true;
    public com.google.android.libraries.navigation.internal.ael.bz v = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz x = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz y = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz z = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        hv hvVar = new hv();
        a = hvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(hv.class, hvVar);
    }

    private hv() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.B);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0018\u0000\u0001\u0001\u001b\u0018\u0000\u0007\u0004\u0001ᐉ\u0001\u0003ဉ\u0004\u0005ᐉ\u0005\u0006ဈ\u0000\u0007᠌\u0006\b᠌\u0007\t᠌\b\n᠌\t\u000bင\n\fЛ\r\u001b\u000eဉ\f\u000fЛ\u0010င\r\u0012င\u000b\u0013ဉ\u0003\u0014\u001b\u0015᠌\u0011\u0016\u001b\u0017ဇ\u000e\u0018ဇ\u0010\u0019\u001b\u001a\u001b\u001bဉ\u0002", new Object[]{"b", "d", "g", "h", "c", ContextChain.TAG_INFRA, com.google.android.libraries.navigation.internal.aap.k.a, "j", ht.a, "k", hr.a, "l", gx.a, "m", "o", bh.class, ContextChain.TAG_PRODUCT, ds.class, "q", "r", dm.class, "s", "n", "f", "v", hi.class, "w", em.a, "x", ho.class, "t", "u", "z", he.class, "y", hk.class, "e"});
        }
        if (i2 == 3) {
            return new hv();
        }
        if (i2 == 4) {
            return new gw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.B = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = A;
        if (bcVar == null) {
            synchronized (hv.class) {
                bcVar = A;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    A = bcVar;
                }
            }
        }
        return bcVar;
    }
}
