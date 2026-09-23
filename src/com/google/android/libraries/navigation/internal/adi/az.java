package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final az a;
    public static final com.google.android.libraries.navigation.internal.ael.bh b;
    private static volatile dg c;
    private byte d = 2;

    static {
        az azVar = new az();
        a = azVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(az.class, azVar);
        b = com.google.android.libraries.navigation.internal.ael.bi.t(com.google.android.libraries.navigation.internal.afb.b.a, azVar, azVar, null, 42398195, es.MESSAGE, az.class);
    }

    private az() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.d);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0000", null);
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
            this.d = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (az.class) {
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
