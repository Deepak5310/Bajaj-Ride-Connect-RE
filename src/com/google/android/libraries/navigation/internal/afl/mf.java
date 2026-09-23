package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mf extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final mf a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public ll c;
    public int e;
    public lv f;
    public mb g;
    private com.google.android.libraries.navigation.internal.acd.pb i;
    private byte j = 2;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        mf mfVar = new mf();
        a = mfVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mf.class, mfVar);
    }

    private mf() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\u0017\u0006\u0000\u0001\u0001\u0001ᐉ\u0000\u0003\u001b\u0014᠌\u0001\u0015ဉ\u0002\u0016ဉ\u0003\u0017ဉ\u0004", new Object[]{"b", "c", "d", kw.class, "e", md.a, ContextChain.TAG_INFRA, "f", "g"});
        }
        if (i2 == 3) {
            return new mf();
        }
        if (i2 == 4) {
            return new mc();
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
            synchronized (mf.class) {
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
