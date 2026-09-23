package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ka extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ka a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c = 6;
    public int d = 1;
    public boolean e = true;
    public boolean f;
    public boolean g;
    private jt i;
    private jz j;
    private boolean k;

    static {
        ka kaVar = new ka();
        a = kaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ka.class, kaVar);
    }

    private ka() {
    }

    public static /* synthetic */ void c(ka kaVar) {
        kaVar.b |= 16;
        kaVar.k = false;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\r\b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0005\u0006ဇ\u000b\u0007ဇ\u0004\bဇ\b\fဉ\u0002\rဉ\u0003", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.ady.ak.a, "d", jv.a, "e", "g", "k", "f", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new ka();
        }
        if (i2 == 4) {
            return new ju();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (ka.class) {
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
