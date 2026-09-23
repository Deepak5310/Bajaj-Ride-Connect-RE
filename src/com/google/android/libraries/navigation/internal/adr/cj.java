package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public int c;
    public cg e;
    private byte g = 2;
    public String d = "";

    static {
        cj cjVar = new cj();
        a = cjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cj.class, cjVar);
    }

    private cj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001᠌\u0000\u0002ဈ\u0001\u0003ᐉ\u0002", new Object[]{"b", "c", ch.a, "d", "e"});
        }
        if (i2 == 3) {
            return new cj();
        }
        if (i2 == 4) {
            return new cc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (cj.class) {
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
