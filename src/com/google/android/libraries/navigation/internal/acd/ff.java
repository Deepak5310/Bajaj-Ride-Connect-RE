package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ff extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ff a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private oz d;
    private com.google.android.libraries.navigation.internal.adq.al e;
    private byte f = 2;

    static {
        ff ffVar = new ff();
        a = ffVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ff.class, ffVar);
    }

    private ff() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0002\u0000\u0001\u0001\u0006\u0002\u0000\u0000\u0001\u0001ဉ\u0000\u0006ᐉ\u0001", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new ff();
        }
        if (i2 == 4) {
            return new fe();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ff.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
