package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mx extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mx a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.adr.bj d;
    private com.google.android.libraries.navigation.internal.adr.gh e;
    private com.google.android.libraries.navigation.internal.adq.al f;
    private com.google.android.libraries.navigation.internal.acd.oz g;
    private byte h = 2;

    static {
        mx mxVar = new mx();
        a = mxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mx.class, mxVar);
    }

    private mx() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0004\u0013\u0004\u0000\u0000\u0001\u0004ဉ\u0004\u0005ဉ\u0005\tᐉ\t\u0013ဉ\u0011", new Object[]{"c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new mx();
        }
        if (i2 == 4) {
            return new mw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (mx.class) {
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
