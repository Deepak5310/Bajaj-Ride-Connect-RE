package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lx extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final lx a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    public lv c;
    private com.google.android.libraries.navigation.internal.adg.bg f;
    private com.google.android.libraries.navigation.internal.adi.aj g;
    private byte h = 2;
    private String e = "";

    static {
        lx lxVar = new lx();
        a = lxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lx.class, lxVar);
    }

    private lx() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u00015\u0004\u0000\u0000\u0002\u0001ဈ\u0000\u0002ဉ\u00024ᐉ\u00035ᐉ\u0004", new Object[]{"b", "e", "c", "f", "g"});
        }
        if (i2 == 3) {
            return new lx();
        }
        if (i2 == 4) {
            return new lw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (lx.class) {
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
