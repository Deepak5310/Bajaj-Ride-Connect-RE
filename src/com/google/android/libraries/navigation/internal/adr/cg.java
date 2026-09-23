package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public int d;
    public ah e;
    private byte g = 2;
    public String c = "";

    static {
        cg cgVar = new cg();
        a = cgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cg.class, cgVar);
    }

    private cg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002᠌\u0001\u0003ᐉ\u0002", new Object[]{"b", "c", "d", ce.a, "e"});
        }
        if (i2 == 3) {
            return new cg();
        }
        if (i2 == 4) {
            return new cd();
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
            synchronized (cg.class) {
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
