package com.google.android.libraries.navigation.internal.acd;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lt extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final lt a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c;
    public com.google.android.libraries.navigation.internal.afm.z e;
    public int f;
    public int g;
    private pb i;
    private byte j = 2;
    public com.google.android.libraries.navigation.internal.ael.bt d = com.google.android.libraries.navigation.internal.ael.cm.a;

    static {
        lt ltVar = new lt();
        a = ltVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lt.class, ltVar);
    }

    private lt() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001᠌\u0000\u0002\u0014\u0003ᐉ\u0001\u0004င\u0002\u0005င\u0003\u0006ဉ\u0004", new Object[]{"b", "c", lr.a, "d", "e", "f", "g", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new lt();
        }
        if (i2 == 4) {
            return new lq();
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
            synchronized (lt.class) {
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
