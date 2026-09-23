package com.google.android.libraries.navigation.internal.aev;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.ed;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends bi implements cz {
    public static final h a;
    private static volatile dg i;
    public int b;
    public Object d;
    public ed e;
    public long g;
    public com.google.android.libraries.navigation.internal.aeu.b h;
    public int c = 0;
    public String f = "";

    static {
        h hVar = new h();
        a = hVar;
        bi.F(h.class, hVar);
    }

    private h() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new dk(a, "\u0004\u0006\u0001\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ለ\u0001\u0003ဂ\u0002\u0005<\u0000\u0006<\u0000\u0007ဉ\u0003", new Object[]{"d", "c", "b", "e", "f", "g", d.class, f.class, "h"});
        }
        if (i3 == 3) {
            return new h();
        }
        if (i3 == 4) {
            return new g();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        dg bcVar = i;
        if (bcVar == null) {
            synchronized (h.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
