package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final n a;
    private static volatile dg b;
    private int c;
    private v d;
    private v e;
    private v f;
    private com.google.android.libraries.navigation.internal.aax.f g;
    private byte h = 2;

    static {
        n nVar = new n();
        a = nVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(n.class, nVar);
    }

    private n() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0000\u0004\u0001ᐉ\u0001\u0002ᐉ\u0002\u0005ᐉ\u0003Ϫᐉ\u0010", new Object[]{"c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new n();
        }
        if (i2 == 4) {
            return new m();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (n.class) {
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
