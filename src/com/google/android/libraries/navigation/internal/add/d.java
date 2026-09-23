package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final d a;
    private static volatile dg i;
    public int b;
    public ay c;
    public v e;
    public c f;
    public boolean h;
    public bz d = dj.b;
    public bz g = dj.b;

    static {
        d dVar = new d();
        a = dVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(d.class, dVar);
    }

    private d() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new dk(a, "\u0000\u0006\u0000\u0001\u0002\u0007\u0006\u0000\u0002\u0000\u0002ဉ\u0000\u0003\u001b\u0004ဉ\u0001\u0005ဉ\u0002\u0006\u001b\u0007\u0007", new Object[]{"b", "c", "d", f.class, "e", "f", "g", t.class, "h"});
        }
        if (i3 == 3) {
            return new d();
        }
        if (i3 == 4) {
            return new a();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        dg bcVar = i;
        if (bcVar == null) {
            synchronized (d.class) {
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
