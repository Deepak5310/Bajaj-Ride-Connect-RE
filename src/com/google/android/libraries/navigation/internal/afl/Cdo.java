package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.afl.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class Cdo extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final Cdo a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public boolean b;
    public int c = 5;
    private int e;

    static {
        Cdo cdo = new Cdo();
        a = cdo;
        com.google.android.libraries.navigation.internal.ael.bi.F(Cdo.class, cdo);
    }

    private Cdo() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဇ\u0001\u0003င\u0002", new Object[]{"e", "b", "c"});
        }
        if (i2 == 3) {
            return new Cdo();
        }
        if (i2 == 4) {
            return new dn();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (Cdo.class) {
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
