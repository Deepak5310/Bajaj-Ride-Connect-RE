package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ll extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ll a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;

    static {
        ll llVar = new ll();
        a = llVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ll.class, llVar);
    }

    private ll() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
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
            return new ll();
        }
        if (i2 == 4) {
            return new lk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ll.class) {
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
