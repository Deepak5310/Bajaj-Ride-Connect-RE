package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final av a;
    private static volatile dg k;
    public int b;
    public int c;
    public int e;
    public int f;
    public com.google.android.libraries.navigation.internal.afb.b i;
    private byte l = 2;
    public com.google.android.libraries.navigation.internal.ael.x d = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.x g = com.google.android.libraries.navigation.internal.ael.x.b;
    public String h = "";
    public String j = "";

    static {
        av avVar = new av();
        a = avVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(av.class, avVar);
    }

    private av() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\b\u0000\u0001\u0001\u000e\b\u0000\u0000\u0001\u0001᠌\u0000\u0003ည\u0005\u0005ᐉ\u000b\u0007ဈ\f\bင\u0006\tဈ\n\u000bည\t\u000eင\b", new Object[]{"b", "c", at.a, "d", ContextChain.TAG_INFRA, "j", "e", "h", "g", "f"});
        }
        if (i2 == 3) {
            return new av();
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
        dg bcVar = k;
        if (bcVar == null) {
            synchronized (av.class) {
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
