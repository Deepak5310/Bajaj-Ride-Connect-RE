package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class nk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final nk a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public String b = "";
    private int d;

    static {
        nk nkVar = new nk();
        a = nkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(nk.class, nkVar);
    }

    private nk() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဈ\u0001", new Object[]{"d", "b"});
        }
        if (i2 == 3) {
            return new nk();
        }
        if (i2 == 4) {
            return new nj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (nk.class) {
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
