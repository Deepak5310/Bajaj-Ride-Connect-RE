package com.google.android.libraries.navigation.internal.aap;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.br;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag extends bi implements cz {
    public static final br a = new ae();
    public static final ag b;
    private static volatile dg f;
    public ad c;
    public x d;
    public bq e = bj.a;
    private int g;

    static {
        ag agVar = new ag();
        b = agVar;
        bi.F(ag.class, agVar);
    }

    private ag() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(b, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ࠬ", new Object[]{"g", "c", "d", "e", a.a});
        }
        if (i2 == 3) {
            return new ag();
        }
        if (i2 == 4) {
            return new af();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (ag.class) {
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
