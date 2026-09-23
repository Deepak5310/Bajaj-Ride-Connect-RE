package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final h a;
    private static volatile dg i;
    public int b;
    public long c;
    public float d;
    public float e;
    public float f;
    public boolean g;
    public bm h;

    static {
        h hVar = new h();
        a = hVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(h.class, hVar);
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
            return new dk(a, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ဇ\u0004\u0006ဉ\u0005", new Object[]{"b", "c", "d", "e", "f", "g", "h"});
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
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
