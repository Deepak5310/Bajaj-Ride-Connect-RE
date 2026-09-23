package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dr extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final dr a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public boolean b;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    private int j;
    public float c = 25.0f;
    public int h = 75;

    static {
        dr drVar = new dr();
        a = drVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dr.class, drVar);
    }

    private dr() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007င\u0006", new Object[]{"j", "b", "c", "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new dr();
        }
        if (i3 == 4) {
            return new dq();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (dr.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
