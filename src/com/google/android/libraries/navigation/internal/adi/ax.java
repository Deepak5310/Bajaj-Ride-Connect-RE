package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ax extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final ax a;
    private static volatile dg c;
    private byte d = 2;
    public com.google.android.libraries.navigation.internal.ael.bz b = dj.b;

    static {
        ax axVar = new ax();
        a = axVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ax.class, axVar);
    }

    private ax() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.d);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"b", av.class});
        }
        if (i2 == 3) {
            return new ax();
        }
        if (i2 == 4) {
            return new aw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.d = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (ax.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
