package com.google.android.libraries.navigation.internal.aez;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final av a;
    private static volatile dg b;
    private int c;
    private an d;
    private f e;
    private bh f;
    private at g;
    private bb h;
    private byte i = 2;

    static {
        av avVar = new av();
        a = avVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(av.class, avVar);
    }

    private av() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0003Ϫ\u0005\u0000\u0000\u0005\u0003ᐉ\u0002\tᐉ\u0005/ᐉ\t1ᐉ\u0007Ϫᐉ\u000e", new Object[]{"c", "d", "e", "g", "f", "h"});
        }
        if (i2 == 3) {
            return new av();
        }
        if (i2 == 4) {
            return new au();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (av.class) {
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
