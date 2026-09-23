package com.google.android.libraries.navigation.internal.acj;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends bi implements cz {
    public static final ak a;
    private static volatile dg h;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;

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
            return new dk(a, "\u0004\u0005\u0000\u0001\u0002\u0007\u0005\u0000\u0000\u0000\u0002င\u0000\u0003င\u0001\u0004င\u0002\u0005᠌\u0003\u0007ဇ\u0004", new Object[]{"b", "c", "d", "e", "f", ai.a, "g"});
        }
        if (i2 == 3) {
            return new ak();
        }
        if (i2 == 4) {
            return new ah();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (ak.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
