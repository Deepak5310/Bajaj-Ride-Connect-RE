package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ar a;
    private static volatile dg d;
    public aj b;
    private int e;
    private aj f;
    private aj g;
    private aj h;
    private aj i;
    private byte j = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = dj.b;

    static {
        ar arVar = new ar();
        a = arVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ar.class, arVar);
    }

    private ar() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0006\u0000\u0001\u0007\f\u0006\u0000\u0001\u0006\u0007ᐉ\u0000\bᐉ\u0001\tᐉ\u0002\nᐉ\u0003\u000bᐉ\u0004\fЛ", new Object[]{"e", "f", "g", "h", "b", ContextChain.TAG_INFRA, "c", al.class});
        }
        if (i2 == 3) {
            return new ar();
        }
        if (i2 == 4) {
            return new aq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (ar.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
