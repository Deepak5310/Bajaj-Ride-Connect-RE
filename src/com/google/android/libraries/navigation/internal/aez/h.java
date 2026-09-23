package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.adr.gh;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.afl.lr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final h a;
    private static volatile dg b;
    private int c;
    private gh d;
    private lr e;

    static {
        h hVar = new h();
        a = hVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(h.class, hVar);
    }

    private h() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\u0006\b\u0002\u0000\u0000\u0000\u0006ဉ\u0002\bဉ\u0001", new Object[]{"c", "e", "d"});
        }
        if (i2 == 3) {
            return new h();
        }
        if (i2 == 4) {
            return new g();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (h.class) {
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
