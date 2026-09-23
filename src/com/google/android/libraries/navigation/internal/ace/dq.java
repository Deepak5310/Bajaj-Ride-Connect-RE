package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dq extends com.google.android.libraries.navigation.internal.ael.bi implements dr {
    public static final dq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public int b;
    private int d;

    static {
        dq dqVar = new dq();
        a = dqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dq.class, dqVar);
    }

    private dq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ace.dr
    public final bm a() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\u0013\u0013\u0001\u0000\u0000\u0000\u0013᠌\u0012", new Object[]{"d", "b", bl.a});
        }
        if (i2 == 3) {
            return new dq();
        }
        if (i2 == 4) {
            return new dp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (dq.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
