package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ev extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ev a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private et d;
    private com.google.android.libraries.navigation.internal.ael.cs e = com.google.android.libraries.navigation.internal.ael.cs.a;

    static {
        ev evVar = new ev();
        a = evVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ev.class, evVar);
    }

    private ev() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0002\u0000\u0001\u0003\u0011\u0002\u0001\u0000\u0000\u0003ဉ\u0002\u00112", new Object[]{"c", "d", "e", eu.a});
        }
        if (i2 == 3) {
            return new ev();
        }
        if (i2 == 4) {
            return new el();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ev.class) {
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
