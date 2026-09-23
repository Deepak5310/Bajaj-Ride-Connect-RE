package com.google.android.libraries.navigation.internal.zp;

import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bx extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bx a;
    public static final com.google.android.libraries.navigation.internal.ael.bh b;
    private static volatile dg c;

    static {
        bx bxVar = new bx();
        a = bxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bx.class, bxVar);
        b = com.google.android.libraries.navigation.internal.ael.bi.J(cb.a, null, ExifDirectoryBase.TAG_SUB_IFD_OFFSET, es.INT32, Integer.class);
    }

    private bx() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new bx();
        }
        if (i2 == 4) {
            return new bw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = c;
        if (bcVar == null) {
            synchronized (bx.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
