package com.google.android.libraries.navigation.internal.ace;

import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class oc extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final oc a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b = DateTimeConstants.MILLIS_PER_MINUTE;
    public int c = DateTimeConstants.MILLIS_PER_MINUTE;
    public int d = 4;
    private int f;

    static {
        oc ocVar = new oc();
        a = ocVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(oc.class, ocVar);
    }

    private oc() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"f", "b", "c", "d"});
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
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (oc.class) {
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
