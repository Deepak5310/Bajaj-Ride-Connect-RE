package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class et extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final et a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private com.google.android.libraries.navigation.internal.ael.cs c = com.google.android.libraries.navigation.internal.ael.cs.a;
    private com.google.android.libraries.navigation.internal.ael.cs d;
    private com.google.android.libraries.navigation.internal.ael.cs e;
    private com.google.android.libraries.navigation.internal.ael.cs f;
    private com.google.android.libraries.navigation.internal.ael.cs g;
    private com.google.android.libraries.navigation.internal.ael.cs h;

    static {
        et etVar = new et();
        a = etVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(et.class, etVar);
    }

    private et() {
        com.google.android.libraries.navigation.internal.ael.cs csVar = com.google.android.libraries.navigation.internal.ael.cs.a;
        this.d = csVar;
        this.e = csVar;
        this.f = csVar;
        this.g = csVar;
        this.h = csVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0006\u0000\u0000\u0001\r\u0006\u0006\u0000\u0000\u00012\u00022\u00032\u000b2\f2\r2", new Object[]{"c", en.a, "d", ep.a, "e", er.a, "f", eo.a, "g", eq.a, "h", es.a});
        }
        if (i2 == 3) {
            return new et();
        }
        if (i2 == 4) {
            return new em();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (et.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
