package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ap a;
    private static volatile dg f;
    public int b;
    private byte g = 2;
    public String c = "";
    public String d = "";
    public com.google.android.libraries.navigation.internal.ael.bz e = dj.b;

    static {
        ap apVar = new ap();
        a = apVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ap.class, apVar);
    }

    private ap() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0003\u0000\u0001\u0002\f\u0003\u0000\u0001\u0001\u0002ဈ\u0000\u0003ဈ\u0001\fЛ", new Object[]{"b", "c", "d", "e", bv.class});
        }
        if (i2 == 3) {
            return new ap();
        }
        if (i2 == 4) {
            return new ao();
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
            synchronized (ap.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.e;
        if (bzVar.c()) {
            return;
        }
        this.e = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
