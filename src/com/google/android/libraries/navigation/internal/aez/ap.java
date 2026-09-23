package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final ap a;
    private static volatile dg b;
    private int c;
    private n d;
    private az e;
    private b f;
    private ar g;
    private byte h = 2;

    static {
        ap apVar = new ap();
        a = apVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ap.class, apVar);
    }

    private ap() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0004\u0016\u0004\u0000\u0000\u0004\u0004ᐉ\b\u000fᐉ\u0012\u0010ᐉ\t\u0016ᐉ\u0005", new Object[]{"c", "e", "g", "f", "d"});
        }
        if (i2 == 3) {
            return new ap();
        }
        if (i2 == 4) {
            return new ao();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (ap.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
