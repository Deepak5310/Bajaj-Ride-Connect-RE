package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final eq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public String b = "";
    public int c;
    private int e;

    static {
        eq eqVar = new eq();
        a = eqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(eq.class, eqVar);
    }

    private eq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"e", "b", "c"});
        }
        if (i2 == 3) {
            return new eq();
        }
        if (i2 == 4) {
            return new ep();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (eq.class) {
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
