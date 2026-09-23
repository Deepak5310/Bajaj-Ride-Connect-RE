package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.adi.af d;
    private byte e = 2;

    static {
        gl glVar = new gl();
        a = glVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gl.class, glVar);
    }

    private gl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001\u0004ᐉ\u0002", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new gl();
        }
        if (i2 == 4) {
            return new gk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (gl.class) {
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
