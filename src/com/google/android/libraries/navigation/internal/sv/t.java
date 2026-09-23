package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final t a;
    private static volatile dg d;
    public com.google.android.libraries.navigation.internal.ael.bz b = dj.b;
    public String c = "";

    static {
        t tVar = new t();
        a = tVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(t.class, tVar);
    }

    private t() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002Ȉ", new Object[]{"b", "c"});
        }
        if (i2 == 3) {
            return new t();
        }
        if (i2 == 4) {
            return new s();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (t.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
