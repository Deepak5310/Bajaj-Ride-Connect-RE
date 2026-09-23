package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bi a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;

    static {
        bi biVar = new bi();
        a = biVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bi.class, biVar);
    }

    private bi() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0003\u0000\u0001\u00129\u0003\u0000\u0000\u0000\u0012ဇ\u00008ဇ\u00019ဇ\u0002", new Object[]{"b", "c", "d", "e"});
        }
        if (i2 == 3) {
            return new bi();
        }
        if (i2 == 4) {
            return new bh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (bi.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
