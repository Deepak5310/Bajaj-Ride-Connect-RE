package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class de extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final de a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public Object c;
    public int b = 0;
    private byte e = 2;

    static {
        de deVar = new de();
        a = deVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(de.class, deVar);
    }

    private de() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0001\u0001<\u0000\u0002<\u0000\u0003м\u0000\u0004<\u0000", new Object[]{"c", "b", dg.class, db.class, dk.class, di.class});
        }
        if (i2 == 3) {
            return new de();
        }
        if (i2 == 4) {
            return new dc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (de.class) {
                bcVar = d;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    d = bcVar;
                }
            }
        }
        return bcVar;
    }
}
