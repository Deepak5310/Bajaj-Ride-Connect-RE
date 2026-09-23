package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bf a;
    private static volatile dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.aax.b d;
    private com.google.android.libraries.navigation.internal.aax.f e;
    private com.google.android.libraries.navigation.internal.aax.d f;
    private az g;
    private byte h = 2;

    static {
        bf bfVar = new bf();
        a = bfVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bf.class, bfVar);
    }

    private bf() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0003\u000e\u0004\u0000\u0000\u0004\u0003ᐉ\u0002\u0004ᐉ\u0006\rᐉ\u0004\u000eᐉ\u0010", new Object[]{"c", "d", "f", "e", "g"});
        }
        if (i2 == 3) {
            return new bf();
        }
        if (i2 == 4) {
            return new be();
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
            synchronized (bf.class) {
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
