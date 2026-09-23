package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class nu extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final nu a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.acd.oz d;
    private com.google.android.libraries.navigation.internal.adq.al e;
    private byte f = 2;

    static {
        nu nuVar = new nu();
        a = nuVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(nu.class, nuVar);
    }

    private nu() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0004\u0005\u0002\u0000\u0000\u0001\u0004ဉ\u0003\u0005ᐉ\u0004", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new nu();
        }
        if (i2 == 4) {
            return new nt();
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
            synchronized (nu.class) {
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
