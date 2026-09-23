package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fd extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fd a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;

    static {
        fd fdVar = new fd();
        a = fdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fd.class, fdVar);
    }

    private fd() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new fd();
        }
        if (i2 == 4) {
            return new fc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (fd.class) {
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
