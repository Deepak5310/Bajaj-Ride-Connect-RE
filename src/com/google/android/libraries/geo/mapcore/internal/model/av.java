package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class av extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final av a;
    private static volatile dg h;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    static {
        av avVar = new av();
        a = avVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(av.class, avVar);
    }

    private av() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004᠌\u0003\u0005င\u0004", new Object[]{"b", "c", "d", "e", "f", com.google.android.libraries.navigation.internal.adi.am.a, "g"});
        }
        if (i2 == 3) {
            return new av();
        }
        if (i2 == 4) {
            return new au();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (av.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
