package com.google.android.libraries.navigation.internal.acj;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends bi implements cz {
    public static final s a;
    private static volatile dg f;
    private int g;
    private byte h = 2;
    public bz b = dj.b;
    public bz c = dj.b;
    public String d = "";
    public bz e = dj.b;

    static {
        s sVar = new s();
        a = sVar;
        bi.F(s.class, sVar);
    }

    private s() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0003\u0001\u0001\u001b\u0003\u001b\u0004ለ\u0000\u0005Л", new Object[]{"g", "b", p.class, "c", j.class, "d", "e", r.class});
        }
        if (i2 == 3) {
            return new s();
        }
        if (i2 == 4) {
            return new m();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (s.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
