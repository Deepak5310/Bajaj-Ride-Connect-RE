package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final at a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private oz d;
    private com.google.android.libraries.navigation.internal.adq.al e;
    private byte f = 2;

    static {
        at atVar = new at();
        a = atVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(at.class, atVar);
    }

    private at() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0004\u0007\u0002\u0000\u0000\u0001\u0004ဉ\u0005\u0007ᐉ\u0006", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new at();
        }
        if (i2 == 4) {
            return new as();
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
            synchronized (at.class) {
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
