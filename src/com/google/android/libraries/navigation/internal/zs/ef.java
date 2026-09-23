package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ef extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ef a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f = 1;

    static {
        ef efVar = new ef();
        a = efVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ef.class, efVar);
    }

    private ef() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = ed.a;
            com.google.android.libraries.navigation.internal.adr.el.a aVar = com.google.android.libraries.navigation.internal.adr.el.a.ALERT;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003", new Object[]{"b", "c", boVar, "d", com.google.android.libraries.navigation.internal.adr.ek.a, "e", com.google.android.libraries.navigation.internal.adr.fo.a, "f", com.google.android.libraries.navigation.internal.adr.dn.a});
        }
        if (i2 == 3) {
            return new ef();
        }
        if (i2 == 4) {
            return new ec();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (ef.class) {
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
