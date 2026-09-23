package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class om extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final om a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public boolean b = true;
    public boolean c;
    private int e;
    private boolean f;

    static {
        om omVar = new om();
        a = omVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(om.class, omVar);
    }

    private om() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0013\u001b\u0002\u0000\u0000\u0000\u0013ဇ\u0013\u001bဇ\u001a", new Object[]{"e", "b", "c"});
        }
        if (i2 == 3) {
            return new om();
        }
        if (i2 == 4) {
            return new ol();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (om.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
