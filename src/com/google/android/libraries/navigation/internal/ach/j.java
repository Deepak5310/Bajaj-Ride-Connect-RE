package com.google.android.libraries.navigation.internal.ach;

import com.google.android.libraries.navigation.internal.aaq.ar;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends bi implements cz {
    public static final j a;
    private static volatile dg f;
    public int b;
    public long c;
    public ar d;
    public bz e = dj.b;

    static {
        j jVar = new j();
        a = jVar;
        bi.F(j.class, jVar);
    }

    private j() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဂ\u0000\u0002\u001b\u0003ဉ\u0001", new Object[]{"b", "c", "e", f.class, "d"});
        }
        if (i2 == 3) {
            return new j();
        }
        if (i2 == 4) {
            return new i();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (j.class) {
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
