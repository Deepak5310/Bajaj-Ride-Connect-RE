package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cm;
import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bg a;
    private static volatile dg f;
    public cs d = cs.a;
    public com.google.android.libraries.navigation.internal.ael.bt b = cm.a;
    public com.google.android.libraries.navigation.internal.ael.bz c = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz e = dj.b;

    static {
        bg bgVar = new bg();
        a = bgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bg.class, bgVar);
    }

    private bg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0002\u0000\u0001.\u0002\u001b\u00032", new Object[]{"b", "c", bd.class, "d", bf.a});
        }
        if (i2 == 3) {
            return new bg();
        }
        if (i2 == 4) {
            return new be();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (bg.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
