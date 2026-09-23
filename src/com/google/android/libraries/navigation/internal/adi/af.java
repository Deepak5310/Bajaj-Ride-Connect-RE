package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final af a;
    private static volatile dg i;
    public int b;
    public ar c;
    public d d;
    public int e;
    public bl f;
    private byte j = 2;
    public String g = "";
    public com.google.android.libraries.navigation.internal.ael.bq h = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        af afVar = new af();
        a = afVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(af.class, afVar);
    }

    private af() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new dk(a, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ဉ\u0001\u0004ဆ\u0003\u0005ဉ\u0004\u0006ဈ\u0005\u0007\u0016", new Object[]{"b", "c", "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new af();
        }
        if (i3 == 4) {
            return new ae();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = i;
        if (bcVar == null) {
            synchronized (af.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
