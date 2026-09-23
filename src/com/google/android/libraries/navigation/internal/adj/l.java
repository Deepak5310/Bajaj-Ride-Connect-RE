package com.google.android.libraries.navigation.internal.adj;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends bi implements cz {
    public static final l a;
    private static volatile dg e;
    public int b;
    public f c;
    public f d;

    static {
        l lVar = new l();
        a = lVar;
        bi.F(l.class, lVar);
    }

    private l() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"b", "c", "d"});
        }
        if (i2 == 3) {
            return new l();
        }
        if (i2 == 4) {
            return new k();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (l.class) {
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
