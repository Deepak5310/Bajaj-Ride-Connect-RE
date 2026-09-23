package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bs a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    public com.google.android.libraries.navigation.internal.ael.cs b = com.google.android.libraries.navigation.internal.ael.cs.a;
    private com.google.android.libraries.navigation.internal.ael.cs d = com.google.android.libraries.navigation.internal.ael.cs.a;

    static {
        bs bsVar = new bs();
        a = bsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bs.class, bsVar);
    }

    private bs() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0000\u0003\u0004\u0002\u0002\u0000\u0000\u00032\u00042", new Object[]{"b", bp.a, "d", br.a});
        }
        if (i2 == 3) {
            return new bs();
        }
        if (i2 == 4) {
            return new bq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (bs.class) {
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
