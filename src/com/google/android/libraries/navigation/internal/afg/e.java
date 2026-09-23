package com.google.android.libraries.navigation.internal.afg;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends bi implements cz {
    public static final e a;
    private static volatile dg d;
    public Object c;
    public int b = 0;
    private byte e = 2;

    static {
        e eVar = new e();
        a = eVar;
        bi.F(e.class, eVar);
    }

    private e() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0001\u0000\u0002\u0004\u0003\u0000\u0000\u0002\u0002м\u0000\u0003м\u0000\u0004<\u0000", new Object[]{"c", "b", l.class, h.class, p.class});
        }
        if (i2 == 3) {
            return new e();
        }
        if (i2 == 4) {
            return new d();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = d;
        if (bcVar == null) {
            synchronized (e.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
