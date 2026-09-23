package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class qd extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final qd a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    private com.google.android.libraries.navigation.internal.adq.al g;
    private oz h;
    private byte i = 2;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public String d = "";
    public String e = "";

    static {
        qd qdVar = new qd();
        a = qdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(qd.class, qdVar);
    }

    private qd() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ည\u0000\u0002ᐉ\u0003\u0003ဉ\u0004\u0004ဈ\u0001\u0005ဈ\u0002", new Object[]{"b", "c", "g", "h", "d", "e"});
        }
        if (i2 == 3) {
            return new qd();
        }
        if (i2 == 4) {
            return new qc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (qd.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
