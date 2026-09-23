package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final al a;
    private static volatile dg l;
    public int b;
    public int c;
    public aj d;
    public int e;
    public p j;
    private byte m = 2;
    public com.google.android.libraries.navigation.internal.ael.bq f = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz g = dj.b;
    public int h = -1;
    public int i = -1;
    public String k = "";

    static {
        al alVar = new al();
        a = alVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(al.class, alVar);
    }

    private al() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.m);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0002\u0001᠌\u0000\u0002ᐉ\u0001\u0003င\u0002\u0004'\u0005Л\u0006င\u0003\u0007င\u0004\bဉ\u0005\tဈ\u0006", new Object[]{"b", "c", am.a, "d", "e", "f", "g", bz.class, "h", ContextChain.TAG_INFRA, "j", "k"});
        }
        if (i2 == 3) {
            return new al();
        }
        if (i2 == 4) {
            return new ak();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.m = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (al.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
