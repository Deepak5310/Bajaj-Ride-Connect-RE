package com.google.android.libraries.navigation.internal.db;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap extends bi implements cz {
    public static final ap a;
    private static volatile dg f;
    public long b;
    public boolean c;
    public boolean d;
    public bq e = bj.a;
    private int g;

    static {
        ap apVar = new ap();
        a = apVar;
        bi.F(ap.class, apVar);
    }

    private ap() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001ဂ\u0000\u0005ဇ\u0004\u0006\u0016\tဇ\u0005", new Object[]{"g", "b", "c", "e", "d"});
        }
        if (i2 == 3) {
            return new ap();
        }
        if (i2 == 4) {
            return new ao();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (ap.class) {
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
