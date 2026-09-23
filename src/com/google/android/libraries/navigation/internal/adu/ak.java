package com.google.android.libraries.navigation.internal.adu;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends bi implements cz {
    public static final ak a;
    private static volatile dg f;
    public int b;
    public bz c = dj.b;
    public af d;
    public aj e;

    static {
        ak akVar = new ak();
        a = akVar;
        bi.F(ak.class, akVar);
    }

    private ak() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0002\b\u0003\u0000\u0001\u0000\u0002\u001b\u0007ဉ\u0004\bဉ\u0005", new Object[]{"b", "c", j.class, "d", "e"});
        }
        if (i2 == 3) {
            return new ak();
        }
        if (i2 == 4) {
            return new z();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (ak.class) {
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
