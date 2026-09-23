package com.google.android.libraries.navigation.internal.agm;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.zt.ac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends bi implements cz {
    public static final i a;
    private static volatile dg b;
    private int c;
    private ac d;
    private byte e = 2;

    static {
        i iVar = new i();
        a = iVar;
        bi.F(i.class, iVar);
    }

    private i() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0001\u0000\u0001\t\t\u0001\u0000\u0000\u0001\tᐉ\b", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new i();
        }
        if (i2 == 4) {
            return new h();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (i.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
