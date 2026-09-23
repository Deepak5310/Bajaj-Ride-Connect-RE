package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final i a;
    private static volatile dg d;
    public com.google.android.libraries.navigation.internal.ael.bq b = com.google.android.libraries.navigation.internal.ael.bj.a;
    public String c = "";

    static {
        i iVar = new i();
        a = iVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(i.class, iVar);
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
            return new dk(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001,\u0002Ȉ", new Object[]{"b", "c"});
        }
        if (i2 == 3) {
            return new i();
        }
        if (i2 == 4) {
            return new g();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (i.class) {
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
