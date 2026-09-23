package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final bv a;
    private static volatile dg e;
    public int b;
    private byte f = 2;
    public int c = 37;
    public com.google.android.libraries.navigation.internal.ael.bz d = dj.b;

    static {
        bv bvVar = new bv();
        a = bvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bv.class, bvVar);
    }

    private bv() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001ᴌ\u0000\u0002Л", new Object[]{"b", "c", bt.a, "d", bs.class});
        }
        if (i2 == 3) {
            return new bv();
        }
        if (i2 == 4) {
            return new bq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = e;
        if (bcVar == null) {
            synchronized (bv.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.d;
        if (bzVar.c()) {
            return;
        }
        this.d = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
