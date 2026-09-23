package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final at a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public long h;
    public com.google.android.libraries.navigation.internal.zr.ds i;
    public com.google.android.libraries.navigation.internal.act.b j;
    private byte l = 2;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public com.google.android.libraries.navigation.internal.ael.bz g = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        at atVar = new at();
        a = atVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(at.class, atVar);
    }

    private at() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0001\u0001\u0001ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0003\u0005Л\u0006ဂ\u0006\u0007ဈ\u0005\bဉ\u0007\tဉ\b", new Object[]{"b", "c", "d", "e", "g", com.google.android.libraries.navigation.internal.aej.b.class, "h", "f", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new at();
        }
        if (i2 == 4) {
            return new as();
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
            synchronized (at.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
