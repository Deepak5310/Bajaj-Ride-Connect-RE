package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ud extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ud a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    public String c = "";
    private pb e;

    static {
        ud udVar = new ud();
        a = udVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ud.class, udVar);
    }

    private ud() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0002\u0004\u0002\u0000\u0000\u0000\u0002ဉ\u0000\u0004ဈ\u0002", new Object[]{"b", "e", "c"});
        }
        if (i2 == 3) {
            return new ud();
        }
        if (i2 == 4) {
            return new uc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (ud.class) {
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
