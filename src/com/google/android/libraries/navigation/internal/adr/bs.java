package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bs a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public r c;
    public fv d;
    private com.google.android.libraries.navigation.internal.ady.z f;
    private byte g = 2;

    static {
        bs bsVar = new bs();
        a = bsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bs.class, bsVar);
    }

    private bs() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0005\u0003\u0000\u0000\u0002\u0001ဉ\u0000\u0002ᐉ\u0001\u0005ᐉ\u0003", new Object[]{"b", "f", "c", "d"});
        }
        if (i2 == 3) {
            return new bs();
        }
        if (i2 == 4) {
            return new br();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (bs.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
