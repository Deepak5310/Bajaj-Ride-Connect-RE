package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fk a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    public String c = "";
    private int e;

    static {
        fk fkVar = new fk();
        a = fkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fk.class, fkVar);
    }

    private fk() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\t\u0002\u0000\u0000\u0000\u0001င\u0000\tဈ\u0011", new Object[]{"e", "b", "c"});
        }
        if (i2 == 3) {
            return new fk();
        }
        if (i2 == 4) {
            return new fj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (fk.class) {
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
