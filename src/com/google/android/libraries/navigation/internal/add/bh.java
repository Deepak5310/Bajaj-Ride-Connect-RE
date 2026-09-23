package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bh a;
    private static volatile dg i;
    public int b;
    public int c;
    public an e;
    public aq g;
    public com.google.android.libraries.navigation.internal.ade.c h;
    public String d = "";
    public bz f = dj.b;

    static {
        bh bhVar = new bh();
        a = bhVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bh.class, bhVar);
    }

    private bh() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new dk(a, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003ဉ\u0000\u0004\u001b\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"b", "c", "d", "e", "f", bl.class, "g", "h"});
        }
        if (i3 == 3) {
            return new bh();
        }
        if (i3 == 4) {
            return new bg();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        dg bcVar = i;
        if (bcVar == null) {
            synchronized (bh.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
