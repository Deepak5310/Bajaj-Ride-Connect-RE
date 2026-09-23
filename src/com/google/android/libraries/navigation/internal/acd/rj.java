package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class rj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final rj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.adq.ay d;
    private oz e;
    private com.google.android.libraries.navigation.internal.adq.al f;
    private byte g = 2;

    static {
        rj rjVar = new rj();
        a = rjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(rj.class, rjVar);
    }

    private rj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0007\u0003\u0000\u0000\u0002\u0001ᐉ\u0000\u0005ဉ\u0004\u0007ᐉ\u0006", new Object[]{"c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new rj();
        }
        if (i2 == 4) {
            return new ri();
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
            synchronized (rj.class) {
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
