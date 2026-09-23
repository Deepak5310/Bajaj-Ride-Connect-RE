package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final n a;
    private static volatile dg f;
    public int b;
    public int c;
    public bb d;
    public com.google.android.libraries.navigation.internal.aax.d e;
    private com.google.android.libraries.navigation.internal.aax.d g;
    private com.google.android.libraries.navigation.internal.aax.d h;
    private byte i = 2;

    static {
        n nVar = new n();
        a = nVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(n.class, nVar);
    }

    private n() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0004\u0001ᐉ\u0003\u0002ဋ\u0000\u0003ᐉ\u0004\u0005ᐉ\u0005\u0006ᐉ\u0006", new Object[]{"b", "d", "c", "e", "g", "h"});
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
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (n.class) {
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
