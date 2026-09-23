package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fi extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fi a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public long e;
    public com.google.android.libraries.navigation.internal.zp.bi g;
    private byte i = 2;
    public String c = "";
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int f = -1;

    static {
        fi fiVar = new fi();
        a = fiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fi.class, fiVar);
    }

    private fi() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ဂ\u0001\u0004င\u0002\u0005ᐉ\u0003", new Object[]{"b", "c", "d", ff.class, "e", "f", "g"});
        }
        if (i2 == 3) {
            return new fi();
        }
        if (i2 == 4) {
            return new fh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = h;
        if (bcVar == null) {
            synchronized (fi.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}
