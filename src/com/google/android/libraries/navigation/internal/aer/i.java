package com.google.android.libraries.navigation.internal.aer;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends bi implements cz {
    public static final i a;
    private static volatile dg e;
    public int b;
    public int c;
    public h d;

    static {
        i iVar = new i();
        a = iVar;
        bi.F(i.class, iVar);
    }

    private i() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\f\u0003ဉ\u0000", new Object[]{"b", "c", "d"});
        }
        if (i2 == 3) {
            return new i();
        }
        if (i2 == 4) {
            return new b();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (i.class) {
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
