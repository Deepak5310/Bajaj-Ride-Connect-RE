package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final az a;
    private static volatile dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.aax.b d;
    private com.google.android.libraries.navigation.internal.adq.ap e;
    private byte f = 2;

    static {
        az azVar = new az();
        a = azVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(az.class, azVar);
    }

    private az() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\u0002\u0004\u0002\u0000\u0000\u0002\u0002ᐉ\u0003\u0004ᐉ\u0005", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new az();
        }
        if (i2 == 4) {
            return new ay();
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
            synchronized (az.class) {
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
