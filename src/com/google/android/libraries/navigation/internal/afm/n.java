package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final n a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean g;
    public com.google.android.libraries.navigation.internal.ael.bq f = com.google.android.libraries.navigation.internal.ael.bj.a;
    public boolean h = true;

    static {
        n nVar = new n();
        a = nVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(n.class, nVar);
    }

    private n() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new dk(a, "\u0001\u0006\u0000\u0001\u0001\u0012\u0006\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0010ࠞ\u0011ဇ\u0003\u0012ဇ\u0004", new Object[]{"b", "c", "d", "e", "f", l.a, "g", "h"});
        }
        if (i3 == 3) {
            return new n();
        }
        if (i3 == 4) {
            return new k();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (n.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
