package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends bi implements cz {
    public static final u a;
    private static volatile dg g;
    public int b;
    public int c;
    public lz d;
    public mf e;
    public p f;
    private byte h = 2;

    static {
        u uVar = new u();
        a = uVar;
        bi.F(u.class, uVar);
    }

    private u() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0003\u0001ဌ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0005ᐉ\u0004", new Object[]{"b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new u();
        }
        if (i2 == 4) {
            return new n();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (u.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
