package com.google.android.libraries.navigation.internal.zt;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends bi implements cz {
    public static final aa a;
    private static volatile dg f;
    public int b;
    private byte g = 2;
    public String c = "";
    public String d = "";
    public bz e = dj.b;

    static {
        aa aaVar = new aa();
        a = aaVar;
        bi.F(aa.class, aaVar);
    }

    private aa() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0004б", new Object[]{"b", "c", "d", "e", z.class});
        }
        if (i2 == 3) {
            return new aa();
        }
        if (i2 == 4) {
            return new x();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = f;
        if (bcVar == null) {
            synchronized (aa.class) {
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
