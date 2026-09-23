package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bb a;
    private static volatile dg b;
    private int c;
    private ap d;
    private byte e = 2;

    static {
        bb bbVar = new bb();
        a = bbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bb.class, bbVar);
    }

    private bb() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\u0002ᐉ\u0002", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new bb();
        }
        if (i2 == 4) {
            return new ba();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (bb.class) {
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
