package com.google.android.libraries.navigation.internal.yv;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends bi implements cz {
    public static final e a;
    private static volatile dg b;
    private cs c = cs.a;

    static {
        e eVar = new e();
        a = eVar;
        bi.F(e.class, eVar);
    }

    private e() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"c", d.a});
        }
        if (i2 == 3) {
            return new e();
        }
        if (i2 == 4) {
            return new c();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (e.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
