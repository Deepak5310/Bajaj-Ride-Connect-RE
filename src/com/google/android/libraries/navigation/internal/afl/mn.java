package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mn extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mn a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.adq.al d;
    private com.google.android.libraries.navigation.internal.acd.oz e;
    private byte f = 2;

    static {
        mn mnVar = new mn();
        a = mnVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mn.class, mnVar);
    }

    private mn() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0011\u0012\u0002\u0000\u0000\u0001\u0011ဉ\u000e\u0012ᐉ\r", new Object[]{"c", "e", "d"});
        }
        if (i2 == 3) {
            return new mn();
        }
        if (i2 == 4) {
            return new mm();
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
            synchronized (mn.class) {
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
