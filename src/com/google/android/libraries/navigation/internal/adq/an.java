package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an extends bi implements cz {
    public static final an a;
    private static volatile dg b;
    private int c;
    private al d;
    private bc e;
    private byte f = 2;

    static {
        an anVar = new an();
        a = anVar;
        bi.F(an.class, anVar);
    }

    private an() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0002\u0000\u0001\u0002'\u0002\u0000\u0000\u0001\u0002ᐉ\u0001'ဉ\u001d", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new an();
        }
        if (i2 == 4) {
            return new am();
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
            synchronized (an.class) {
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
