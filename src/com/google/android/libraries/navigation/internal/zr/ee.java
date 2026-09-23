package com.google.android.libraries.navigation.internal.zr;

import com.google.android.libraries.navigation.internal.adr.hr;
import com.google.android.libraries.navigation.internal.adr.ht;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ee extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ee a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int c;
    public int d;
    public int e = 1;
    public String f = "";
    public boolean g;

    static {
        ee eeVar = new ee();
        a = eeVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ee.class, eeVar);
    }

    private ee() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ဈ\u0003\u0005ဇ\u0004", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.aap.k.a, "d", ht.a, "e", hr.a, "f", "g"});
        }
        if (i2 == 3) {
            return new ee();
        }
        if (i2 == 4) {
            return new ed();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (ee.class) {
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
