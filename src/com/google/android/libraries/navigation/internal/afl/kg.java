package com.google.android.libraries.navigation.internal.afl;

import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final kg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public long b = 33554432;
    public double c = 0.25d;
    public double d = 0.8d;
    public double e = 0.9d;
    public int f = DateTimeConstants.MILLIS_PER_WEEK;
    public long g = 3145728;
    public boolean h;
    private int j;

    static {
        kg kgVar = new kg();
        a = kgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(kg.class, kgVar);
    }

    private kg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0002\r\u0007\u0000\u0000\u0000\u0002ဂ\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004\u0007င\u0006\bဂ\u0007\rဇ\f", new Object[]{"j", "b", "c", "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new kg();
        }
        if (i3 == 4) {
            return new kf();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (kg.class) {
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
