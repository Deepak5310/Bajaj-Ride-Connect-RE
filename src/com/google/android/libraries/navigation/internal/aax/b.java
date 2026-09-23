package com.google.android.libraries.navigation.internal.aax;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends bi implements cz {
    public static final b a;
    private static volatile dg e;
    public int b;
    public long c;
    public long d;
    private byte f = 2;

    static {
        b bVar = new b();
        a = bVar;
        bi.F(b.class, bVar);
    }

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔅ\u0000\u0002ᔅ\u0001", new Object[]{"b", "c", "d"});
        }
        if (i2 == 3) {
            return new b();
        }
        if (i2 == 4) {
            return new a();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
