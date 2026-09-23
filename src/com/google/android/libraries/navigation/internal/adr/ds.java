package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ds extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ds a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public int c;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        ds dsVar = new ds();
        a = dsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ds.class, dsVar);
    }

    private ds() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"b", "c", dq.a, "d", dw.class});
        }
        if (i2 == 3) {
            return new ds();
        }
        if (i2 == 4) {
            return new dp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (ds.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
