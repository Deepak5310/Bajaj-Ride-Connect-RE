package com.google.android.libraries.navigation.internal.aer;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.br;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends bi implements cz {
    public static final br a = new j();
    public static final l b;
    private static volatile dg f;
    public int c;
    public bq d;
    public long e;
    private int g;

    static {
        l lVar = new l();
        b = lVar;
        bi.F(l.class, lVar);
    }

    private l() {
        Object[] objArr = dj.a;
        this.d = bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(b, "\u0000\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0001\u0000\u0002\f\u0003,\u0004ဂ\u0000", new Object[]{"g", "c", "d", "e"});
        }
        if (i2 == 3) {
            return new l();
        }
        if (i2 == 4) {
            return new k();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (l.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new bc(b);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
