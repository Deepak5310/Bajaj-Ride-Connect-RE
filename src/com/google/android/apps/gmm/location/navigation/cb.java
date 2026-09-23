package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class cb extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final cb a;
    private static volatile dg d;
    public com.google.android.libraries.navigation.internal.ael.bz b = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz c = dj.b;

    static {
        cb cbVar = new cb();
        a = cbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cb.class, cbVar);
    }

    private cb() {
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
            return new cb();
        }
        if (i2 == 4) {
            return new ca();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (cb.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
