package com.google.android.libraries.navigation.internal.aai;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.zq.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends bi implements cz {
    public static final h a;
    private static volatile dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.aax.b d;
    private com.google.android.libraries.navigation.internal.aax.d e;
    private com.google.android.libraries.navigation.internal.aax.f f;
    private n g;
    private byte h = 2;

    static {
        h hVar = new h();
        a = hVar;
        bi.F(h.class, hVar);
    }

    private h() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0004\u0000\u0001\u0001\u0013\u0004\u0000\u0000\u0004\u0001ᐉ\u0000\u0004ᐉ\u0002\fᐉ\r\u0013ᐉ\u0012", new Object[]{"c", "d", "e", "f", "g"});
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
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (h.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
