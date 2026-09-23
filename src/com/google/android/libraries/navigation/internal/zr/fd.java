package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fd extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fd a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public int c;
    public com.google.android.libraries.navigation.internal.zt.ap d;
    public ff f;
    public com.google.android.libraries.navigation.internal.zp.cb g;
    public long h;
    public boolean i;
    public com.google.android.libraries.navigation.internal.zp.bk j;
    private byte l = 2;
    public String e = "";

    static {
        fd fdVar = new fd();
        a = fdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fd.class, fdVar);
    }

    private fd() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0002\u0010\u0006\u0000\u0000\u0003\u0002ᐉ\u0006\u0003ဈ\u0004\u0004ᐉ\u0005\u0006᠌\u0001\bဉ\u0003\u0010ᐉ\t", new Object[]{"b", "g", "e", "f", "c", com.google.android.libraries.navigation.internal.zt.ar.a, "d", "j"});
        }
        if (i2 == 3) {
            return new fd();
        }
        if (i2 == 4) {
            return new fc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (fd.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
