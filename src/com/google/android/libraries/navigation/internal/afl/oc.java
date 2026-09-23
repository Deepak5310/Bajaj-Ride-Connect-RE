package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class oc extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final oc a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public com.google.android.libraries.navigation.internal.ael.bt b = com.google.android.libraries.navigation.internal.ael.cm.a;
    private int d;
    private boolean e;
    private com.google.android.libraries.navigation.internal.acd.oz f;

    static {
        oc ocVar = new oc();
        a = ocVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(oc.class, ocVar);
    }

    private oc() {
    }

    public static /* synthetic */ void e(oc ocVar) {
        ocVar.d |= 1;
        ocVar.e = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0017\u0002ဇ\u0000\u0003ဉ\u0001", new Object[]{"d", "b", "e", "f"});
        }
        if (i2 == 3) {
            return new oc();
        }
        if (i2 == 4) {
            return new ob();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (oc.class) {
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
