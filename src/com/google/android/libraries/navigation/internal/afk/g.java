package com.google.android.libraries.navigation.internal.afk;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.be;
import com.google.android.libraries.navigation.internal.ael.bf;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends be implements bf {
    public static final g a;
    private static volatile dg f;
    public int b;
    public com.google.android.libraries.navigation.internal.afa.d c;
    public int d;
    public com.google.android.libraries.navigation.internal.aba.f e;
    private byte g = 2;

    static {
        g gVar = new g();
        a = gVar;
        bi.F(g.class, gVar);
    }

    private g() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"b", "c", "d", e.a, "e"});
        }
        if (i2 == 3) {
            return new g();
        }
        if (i2 == 4) {
            return new d();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (g.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
