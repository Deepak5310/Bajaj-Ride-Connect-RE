package com.google.android.libraries.navigation.internal.add;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final t a;
    private static volatile dg j;
    public int b;
    public Object d;
    public k f;
    public bb i;
    public int c = 0;
    public String e = "";
    public bz g = dj.b;
    public bz h = dj.b;

    static {
        t tVar = new t();
        a = tVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(t.class, tVar);
    }

    private t() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0000\t\u0001\u0001\u0001\n\t\u0000\u0002\u0000\u0001Ȉ\u0003<\u0000\u0004<\u0000\u0005ဉ\u0000\u0006Ț\u0007Ț\bဉ\u0001\t<\u0000\n<\u0000", new Object[]{"d", "c", "b", "e", n.class, i.class, "f", "g", "h", ContextChain.TAG_INFRA, q.class, s.class});
        }
        if (i2 == 3) {
            return new t();
        }
        if (i2 == 4) {
            return new o();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (t.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        bz bzVar = this.g;
        if (bzVar.c()) {
            return;
        }
        this.g = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
