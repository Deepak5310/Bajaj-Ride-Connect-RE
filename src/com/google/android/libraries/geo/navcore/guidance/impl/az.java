package com.google.android.libraries.geo.navcore.guidance.impl;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class az extends bi implements cz {
    public static final az a;
    private static volatile dg b;

    static {
        az azVar = new az();
        a = azVar;
        bi.F(az.class, azVar);
    }

    private az() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
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
            throw null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (az.class) {
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
