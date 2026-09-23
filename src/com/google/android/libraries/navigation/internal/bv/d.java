package com.google.android.libraries.navigation.internal.bv;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends bi implements cz {
    public static final d a;
    private static volatile dg g;
    public lz b;
    public mf c;
    public b d;
    public int e;
    private int h;
    private byte i = 2;
    public String f = "";

    static {
        d dVar = new d();
        a = dVar;
        bi.F(d.class, dVar);
    }

    private d() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\t\u0005\u0000\u0000\u0002\u0001ᐉ\u0000\u0002ᐉ\u0001\u0005ဉ\u0004\u0007ဋ\u0006\tဈ\b", new Object[]{"h", "b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new d();
        }
        if (i2 == 4) {
            return new c();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (d.class) {
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
