package com.google.android.libraries.navigation.internal.nk;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends bi implements cz {
    public static final b a;
    private static volatile dg i;
    public int b;
    public r c;
    public f d;
    public p e;
    public v f;
    public x g;
    public d h;

    static {
        b bVar = new b();
        a = bVar;
        bi.F(b.class, bVar);
    }

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new dk(a, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"b", "c", "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new b();
        }
        if (i3 == 4) {
            return new a();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        dg bcVar = i;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
