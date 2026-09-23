package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bt a;
    private static volatile dg h;
    public int b;
    public com.google.android.libraries.navigation.internal.aci.f c;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bq e = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz f = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz g = dj.b;

    static {
        bt btVar = new bt();
        a = btVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bt.class, btVar);
    }

    private bt() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0004\u0000\u0001ဉ\u0000\u0003'\u0004'\u0005\u001b\u0006\u001b", new Object[]{"b", "c", "d", "e", "f", com.google.android.libraries.navigation.internal.aci.b.class, "g", com.google.android.libraries.navigation.internal.acm.aa.class});
        }
        if (i2 == 3) {
            return new bt();
        }
        if (i2 == 4) {
            return new bs();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (bt.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.f;
        if (bzVar.c()) {
            return;
        }
        this.f = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
