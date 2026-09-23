package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends bi implements cz {
    public static final r a;
    private static volatile dg f;
    public int b;
    public com.google.android.libraries.navigation.internal.aeb.b c;
    public String d = "";
    public int e;

    static {
        r rVar = new r();
        a = rVar;
        bi.F(r.class, rVar);
    }

    private r() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0001\u000f\u0003\u0000\u0000\u0000\u0001ဈ\u0001\u0005᠌\t\u000fဉ\u0000", new Object[]{"b", "d", "e", p.a, "c"});
        }
        if (i2 == 3) {
            return new r();
        }
        if (i2 == 4) {
            return new o();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (r.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
