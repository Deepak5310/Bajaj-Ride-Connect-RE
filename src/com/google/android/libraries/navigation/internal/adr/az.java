package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final az a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public ah c;
    public int e;
    private byte g = 2;
    public String d = "";

    static {
        az azVar = new az();
        a = azVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(az.class, azVar);
    }

    private az() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0001\u0002᠌\u0002\u0003ᐉ\u0000", new Object[]{"b", "d", "e", ax.a, "c"});
        }
        if (i2 == 3) {
            return new az();
        }
        if (i2 == 4) {
            return new aw();
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
            synchronized (az.class) {
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
