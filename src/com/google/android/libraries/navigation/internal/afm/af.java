package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final af a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public long c;
    private byte g = 2;
    public String d = "";
    public String e = "";

    static {
        af afVar = new af();
        a = afVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(af.class, afVar);
    }

    private af() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0001\u0002\t\u0003\u0000\u0000\u0001\u0002စ\u0000\u0004ᔈ\u0001\tဈ\u0003", new Object[]{"b", "c", "d", "e"});
        }
        if (i2 == 3) {
            return new af();
        }
        if (i2 == 4) {
            return new ae();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (af.class) {
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
