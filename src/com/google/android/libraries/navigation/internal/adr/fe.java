package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fe extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fe a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public int c;
    public int d;
    public int e;

    static {
        fe feVar = new fe();
        a = feVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fe.class, feVar);
    }

    private fe() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = com.google.android.libraries.navigation.internal.adg.ew.a;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.adg.ew.a, "d", boVar, "e", boVar});
        }
        if (i2 == 3) {
            return new fe();
        }
        if (i2 == 4) {
            return new fd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (fe.class) {
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
