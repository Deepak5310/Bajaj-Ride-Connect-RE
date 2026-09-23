package com.google.android.libraries.navigation.internal.acj;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.adr.hr;
import com.google.android.libraries.navigation.internal.adr.ht;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends bi implements cz {
    public static final am a;
    private static volatile dg l;
    public int b;
    public int c;
    public int d;
    public int e;
    public int g;
    public int h;
    public com.google.android.libraries.navigation.internal.aci.b i;
    public int k;
    public bz f = dj.b;
    public int j = 1;

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
            return new dk(a, "\u0004\t\u0000\u0001\u0001\f\t\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0004င\u0002\u0007\u001b\b᠌\u0003\tင\u0004\nဉ\u0005\u000b᠌\u0006\f᠌\u0007", new Object[]{"b", "c", "d", "e", "f", ak.class, "g", com.google.android.libraries.navigation.internal.aap.k.a, "h", ContextChain.TAG_INFRA, "j", hr.a, "k", ht.a});
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
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (am.class) {
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
