package com.google.android.libraries.navigation.internal.gd;

import androidx.work.WorkRequest;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends bi implements cz {
    public static final k a;
    private static volatile dg g;
    public int b;
    public int c = 100;
    public int d = 3;
    public long e = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    public int f;

    static {
        k kVar = new k();
        a = kVar;
        bi.F(k.class, kVar);
    }

    private k() {
    }

    public static /* synthetic */ void b(k kVar) {
        kVar.b |= 1;
        kVar.c = 100;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဂ\u0002\u0004င\u0003", new Object[]{"b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new k();
        }
        if (i2 == 4) {
            return new j();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (k.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
