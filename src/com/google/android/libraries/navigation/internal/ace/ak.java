package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ak a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;

    static {
        ak akVar = new ak();
        a = akVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ak.class, akVar);
    }

    private ak() {
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
            return new ak();
        }
        if (i2 == 4) {
            return new aj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ak.class) {
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
