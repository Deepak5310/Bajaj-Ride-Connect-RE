package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final v a;
    private static volatile dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.aax.b d;
    private bh e;
    private byte f = 2;

    static {
        v vVar = new v();
        a = vVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(v.class, vVar);
    }

    private v() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\n\r\u0002\u0000\u0000\u0002\nᐉ\u0007\rᐉ\t", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new v();
        }
        if (i2 == 4) {
            return new u();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (v.class) {
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
