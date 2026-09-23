package com.google.android.libraries.navigation.internal.afl;

import com.google.android.libraries.navigation.internal.acd.rf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mv extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mv a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.afm.cn d;
    private mr e;
    private mp f;
    private rf g;
    private com.google.android.libraries.navigation.internal.acd.id h;
    private byte i = 2;

    static {
        mv mvVar = new mv();
        a = mvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mv.class, mvVar);
    }

    private mv() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u000b\u0005\u0000\u0000\u0005\u0001ᐉ\u0000\u0002ᐉ\u0001\u0005ᐉ\u0004\u0006ᐉ\u0005\u000bᐉ\u0006", new Object[]{"c", "d", "e", "f", "g", "h"});
        }
        if (i2 == 3) {
            return new mv();
        }
        if (i2 == 4) {
            return new mu();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (mv.class) {
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
