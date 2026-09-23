package com.google.android.libraries.navigation.internal.zs;

import com.google.android.libraries.navigation.internal.adr.ih;
import com.google.android.libraries.navigation.internal.adr.ii;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fx extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fx a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public com.google.android.libraries.navigation.internal.ael.am c;
    public com.google.android.libraries.navigation.internal.ael.am d;
    public int e;
    public int f;
    public int g;

    static {
        fx fxVar = new fx();
        a = fxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fx.class, fxVar);
    }

    private fx() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            ii.a aVar = ii.a.DELAY_NODATA;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဏ\u0002\u0004᠌\u0003\u0005᠌\u0004", new Object[]{"b", "c", "d", "e", "f", ih.a, "g", ih.a});
        }
        if (i2 == 3) {
            return new fx();
        }
        if (i2 == 4) {
            return new fw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (fx.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
