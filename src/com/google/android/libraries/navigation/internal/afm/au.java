package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final au a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public float e;
    public String c = "";
    public String d = "";
    public String f = "";
    public String g = "";

    static {
        au auVar = new au();
        a = auVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(au.class, auVar);
    }

    private au() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"b", "c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new au();
        }
        if (i2 == 4) {
            return new at();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (au.class) {
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
