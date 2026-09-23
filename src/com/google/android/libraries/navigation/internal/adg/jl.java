package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jl extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final jl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public ia d;
    public int e;
    public int f;
    public fs i;
    private byte k = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int g = -1;
    public long h = -1;

    static {
        jl jlVar = new jl();
        a = jlVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jl.class, jlVar);
    }

    private jl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.k);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001o\u0007\u0000\u0001\u0003\u0001Л\u0002ᐉ\u0000\u0003င\u0004\bဂ\u0005\tင\u0002\nင\u0003oᐉ\t", new Object[]{"b", "c", ce.class, "d", "g", "h", "e", "f", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new jl();
        }
        if (i2 == 4) {
            return new jk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.k = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (jl.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
