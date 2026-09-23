package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ll extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ll a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public lh c;
    public com.google.android.libraries.navigation.internal.acc.b d;
    public com.google.android.libraries.navigation.internal.acd.nv f;
    private com.google.android.libraries.navigation.internal.adq.ap i;
    private byte j = 2;
    public String e = "";
    public com.google.android.libraries.navigation.internal.ael.bz g = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        ll llVar = new ll();
        a = llVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ll.class, llVar);
    }

    private ll() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\f\u0006\u0000\u0001\u0003\u0001ᐉ\u0000\u0003ဉ\u0002\u0005ဈ\u0004\u0007ᐉ\u0001\u000bᐉ\u0006\f\u001b", new Object[]{"b", "c", "d", "e", ContextChain.TAG_INFRA, "f", "g", com.google.android.libraries.navigation.internal.ady.p.class});
        }
        if (i2 == 3) {
            return new ll();
        }
        if (i2 == 4) {
            return new lk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (ll.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
