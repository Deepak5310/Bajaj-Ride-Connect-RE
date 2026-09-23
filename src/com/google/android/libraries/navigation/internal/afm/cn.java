package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cn extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cn a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private r e;
    private byte f = 2;
    private String d = "";

    static {
        cn cnVar = new cn();
        a = cnVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cn.class, cnVar);
    }

    private cn() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\u0001\u0007\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0007ᐉ\u000f", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new cn();
        }
        if (i2 == 4) {
            return new cm();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (cn.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
