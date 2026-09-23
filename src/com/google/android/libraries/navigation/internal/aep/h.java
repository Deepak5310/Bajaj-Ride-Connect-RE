package com.google.android.libraries.navigation.internal.aep;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends bi implements cz {
    public static final h a;
    public static final bh b;
    private static volatile dg i;
    public int c;
    public boolean d;
    public com.google.android.libraries.navigation.internal.aas.b e;
    public g f;
    public com.google.android.libraries.navigation.internal.aaj.b g;
    public c h;
    private byte j = 2;

    static {
        h hVar = new h();
        a = hVar;
        bi.F(h.class, hVar);
        b = bi.t(com.google.android.libraries.navigation.internal.adf.b.a, hVar, hVar, null, 436338559, es.MESSAGE, h.class);
    }

    private h() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0002\u0001ဇ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0005ᐉ\u0003\u0007ဉ\u0004", new Object[]{"c", "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new h();
        }
        if (i3 == 4) {
            return new a();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
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
