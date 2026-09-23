package com.google.android.libraries.navigation.internal.gd;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.afl.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends bi implements cz {
    public static final m a;
    private static volatile dg g;
    public int b;
    public long e;
    public am f;
    private byte h = 2;
    public String c = "";
    public String d = "";

    static {
        m mVar = new m();
        a = mVar;
        bi.F(m.class, mVar);
    }

    private m() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဈ\u0001\u0002ဂ\u0002\u0003ᐉ\u0003\u0004ဈ\u0000", new Object[]{"b", "d", "e", "f", "c"});
        }
        if (i2 == 3) {
            return new m();
        }
        if (i2 == 4) {
            return new l();
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
            synchronized (m.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
