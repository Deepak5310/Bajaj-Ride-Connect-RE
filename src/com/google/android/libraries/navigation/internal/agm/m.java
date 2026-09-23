package com.google.android.libraries.navigation.internal.agm;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends bi implements cz {
    public static final m a;
    private static volatile dg b;
    private int c;
    private l d;
    private byte e = 2;

    static {
        m mVar = new m();
        a = mVar;
        bi.F(m.class, mVar);
    }

    private m() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001\u0003ᐉ\u0002", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new m();
        }
        if (i2 == 4) {
            return new j();
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
            synchronized (m.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
