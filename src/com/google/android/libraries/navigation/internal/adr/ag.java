package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ag a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public String c = "";
    public int d;
    public int e;

    static {
        ag agVar = new ag();
        a = agVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ag.class, agVar);
    }

    private ag() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0005\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0005᠌\u0004", new Object[]{"b", "c", "d", com.google.android.libraries.navigation.internal.ady.r.a, "e", com.google.android.libraries.navigation.internal.ady.t.a});
        }
        if (i2 == 3) {
            return new ag();
        }
        if (i2 == 4) {
            return new af();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (ag.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
