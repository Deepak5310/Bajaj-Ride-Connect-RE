package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jt extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final jt a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private com.google.android.libraries.navigation.internal.ael.cs c = com.google.android.libraries.navigation.internal.ael.cs.a;

    static {
        jt jtVar = new jt();
        a = jtVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jt.class, jtVar);
    }

    private jt() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0000\u0004\u0004\u0001\u0001\u0000\u0000\u00042", new Object[]{"c", js.a});
        }
        if (i2 == 3) {
            return new jt();
        }
        if (i2 == 4) {
            return new jp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (jt.class) {
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
