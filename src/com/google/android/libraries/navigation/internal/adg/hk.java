package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final hk a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public com.google.android.libraries.navigation.internal.ael.bq b = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bq c = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        hk hkVar = new hk();
        a = hkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(hk.class, hkVar);
    }

    private hk() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001'\u0002'\u0003'\u0004\u001b", new Object[]{"b", "c", "d", "e", hj.class});
        }
        if (i2 == 3) {
            return new hk();
        }
        if (i2 == 4) {
            return new hh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (hk.class) {
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
