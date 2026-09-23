package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah extends bi implements cz {
    public static final ah a;
    private static volatile dg h;
    public int b;
    public boolean e;
    public com.google.android.libraries.navigation.internal.zq.l g;
    public bq c = bj.a;
    public bq d = bj.a;
    public bz f = dj.b;

    static {
        ah ahVar = new ah();
        a = ahVar;
        bi.F(ah.class, ahVar);
    }

    private ah() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0005\u0000\u0001\u0002\u001a\u0005\u0000\u0003\u0000\u0002ࠞ\u0003ࠞ\tဇ\u0005\r\u001b\u001aဉ\u0013", new Object[]{"b", "c", ac.a, "d", af.a, "e", "f", d.class, "g"});
        }
        if (i2 == 3) {
            return new ah();
        }
        if (i2 == 4) {
            return new ae();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (ah.class) {
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
        bz bzVar = this.f;
        if (bzVar.c()) {
            return;
        }
        this.f = bi.A(bzVar);
    }
}
