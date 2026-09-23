package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cf extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cf a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public int c;
    public int d;

    static {
        cf cfVar = new cf();
        a = cfVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cf.class, cfVar);
    }

    private cf() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.adu.y yVar = com.google.android.libraries.navigation.internal.adu.y.UNKNOWN_INCIDENT_TYPE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.adu.x.a, "d", com.google.android.libraries.navigation.internal.adu.v.a});
        }
        if (i2 == 3) {
            return new cf();
        }
        if (i2 == 4) {
            return new ce();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (cf.class) {
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
