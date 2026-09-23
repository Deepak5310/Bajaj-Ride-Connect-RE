package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final aw a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.x d = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        aw awVar = new aw();
        a = awVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aw.class, awVar);
    }

    private aw() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0002\u0000\u0001;<\u0002\u0000\u0000\u0000;ည\u0000<ည\u0001", new Object[]{"b", "c", "d"});
        }
        if (i2 == 3) {
            return new aw();
        }
        if (i2 == 4) {
            return new av();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (aw.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
