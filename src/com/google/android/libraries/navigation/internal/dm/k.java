package com.google.android.libraries.navigation.internal.dm;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends bi implements cz {
    public static final k a;
    private static volatile dg g;
    public int b;
    public i c;
    public String d = "";
    public long e;
    public long f;

    static {
        k kVar = new k();
        a = kVar;
        bi.F(k.class, kVar);
    }

    private k() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new k();
        }
        if (i2 == 4) {
            return new j();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (k.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
