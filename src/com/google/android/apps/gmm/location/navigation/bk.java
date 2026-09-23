package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bk extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bk a;
    private static volatile dg b;

    static {
        bk bkVar = new bk();
        a = bkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bk.class, bkVar);
    }

    private bk() {
        com.google.android.libraries.navigation.internal.ael.ay ayVar = com.google.android.libraries.navigation.internal.ael.ay.a;
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
            return new bk();
        }
        if (i2 == 4) {
            return new bj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (bk.class) {
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
