package com.google.android.libraries.navigation.internal.adc;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.ed;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends bi implements cz {
    public static final d a;
    private static volatile dg l;
    public int b;
    public int d;
    public long i;
    public int j;
    public ed k;
    public String c = "";
    public bz e = dj.b;
    public String f = "";
    public String g = "";
    public String h = "";

    static {
        d dVar = new d();
        a = dVar;
        bi.F(d.class, dVar);
    }

    private d() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0000\t\u0000\u0001\u0001\n\t\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0004Ț\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0002\t\f\nဉ\u0000", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k"});
        }
        if (i2 == 3) {
            return new d();
        }
        if (i2 == 4) {
            return new a();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (d.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
