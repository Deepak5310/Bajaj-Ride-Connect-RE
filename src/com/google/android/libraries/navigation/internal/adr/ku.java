package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ku extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ku a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public kq d;
    public boolean e;
    private byte g = 2;
    public int c = 2;

    static {
        ku kuVar = new ku();
        a = kuVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ku.class, kuVar);
    }

    private ku() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001᠌\u0000\u0002ᐉ\u0001\u0003ဇ\u0002", new Object[]{"b", "c", ks.a, "d", "e"});
        }
        if (i2 == 3) {
            return new ku();
        }
        if (i2 == 4) {
            return new kr();
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
            synchronized (ku.class) {
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
