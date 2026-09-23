package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final at a;
    private static volatile dg b;
    private int c;
    private al d;
    private bl e;
    private bd f;
    private bb g;
    private byte h = 2;

    static {
        at atVar = new at();
        a = atVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(at.class, atVar);
    }

    private at() {
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0012ϫ\u0004\u0000\u0000\u0004\u0012ᐉ\u0000\u001bᐉ\u00066ᐉ\rϫᐉ\u000e", new Object[]{"c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new at();
        }
        if (i2 == 4) {
            return new as();
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
            synchronized (at.class) {
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
