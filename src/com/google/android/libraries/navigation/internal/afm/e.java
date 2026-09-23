package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final e a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public int c;
    public int d = 1;
    public String e = "";
    public String f = "";

    static {
        e eVar = new e();
        a = eVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(e.class, eVar);
    }

    private e() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0004င\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"b", "c", c.a, "d", "e", "f"});
        }
        if (i2 == 3) {
            return new e();
        }
        if (i2 == 4) {
            return new b();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (e.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
