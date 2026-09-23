package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ki extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ki a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.aez.av d;
    private com.google.android.libraries.navigation.internal.adq.al e;
    private com.google.android.libraries.navigation.internal.acd.oz f;
    private byte g = 2;

    static {
        ki kiVar = new ki();
        a = kiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ki.class, kiVar);
    }

    private ki() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0003\u0000\u0001\u0002\u0011\u0003\u0000\u0000\u0002\u0002ᐉ\n\u0005ᐉ\u0000\u0011ဉ\r", new Object[]{"c", "e", "d", "f"});
        }
        if (i2 == 3) {
            return new ki();
        }
        if (i2 == 4) {
            return new kh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (ki.class) {
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
