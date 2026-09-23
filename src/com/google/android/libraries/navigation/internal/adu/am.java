package com.google.android.libraries.navigation.internal.adu;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends bi implements cz {
    public static final am a;
    private static volatile dg c;
    public com.google.android.libraries.navigation.internal.adq.aj b;
    private int d;

    static {
        am amVar = new am();
        a = amVar;
        bi.F(am.class, amVar);
    }

    private am() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0001", new Object[]{"d", "b"});
        }
        if (i2 == 3) {
            return new am();
        }
        if (i2 == 4) {
            return new al();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (am.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
