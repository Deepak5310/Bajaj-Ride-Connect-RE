package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class nq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final nq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public int c = 3;
    public com.google.android.libraries.navigation.internal.ael.bt d = com.google.android.libraries.navigation.internal.ael.cm.a;
    public String e = "";
    public String f = "";

    static {
        nq nqVar = new nq();
        a = nqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(nq.class, nqVar);
    }

    private nq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002\u0014\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new nq();
        }
        if (i2 == 4) {
            return new np();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (nq.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
