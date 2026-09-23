package com.google.android.libraries.navigation.internal.zr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final be a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg m;
    public int b;
    public int c;
    public int d;
    public int e;
    public ak f;
    public ak g;
    public am h;
    public float i;
    public int j;
    public int k;
    public com.google.android.libraries.navigation.internal.ael.bz l = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        be beVar = new be();
        a = beVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(be.class, beVar);
    }

    private be() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = com.google.android.libraries.navigation.internal.afl.dt.a;
            com.google.android.libraries.navigation.internal.ael.bo boVar2 = com.google.android.libraries.navigation.internal.afl.dt.a;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0001\r\n\u0000\u0001\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ခ\u0006\b᠌\u0007\tင\u000b\r\u001a", new Object[]{"b", "c", boVar, "d", boVar2, "e", boVar2, "f", "g", "h", ContextChain.TAG_INFRA, "j", az.a, "k", "l"});
        }
        if (i2 == 3) {
            return new be();
        }
        if (i2 == 4) {
            return new bb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = m;
        if (bcVar == null) {
            synchronized (be.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
