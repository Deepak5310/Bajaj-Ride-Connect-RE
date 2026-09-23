package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.acd.pb;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final j a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public int c;
    public String d = "";
    public String e = "";
    private pb g;

    static {
        j jVar = new j();
        a = jVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(j.class, jVar);
    }

    private j() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"b", "c", h.a, "g", "d", "e"});
        }
        if (i2 == 3) {
            return new j();
        }
        if (i2 == 4) {
            return new g();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (j.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
