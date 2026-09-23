package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final h a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    private bs e;
    private bs f;
    private byte g = 2;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        h hVar = new h();
        a = hVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(h.class, hVar);
    }

    private h() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001ϩ\u0003\u0000\u0000\u0002\u0001ည\u0000Ϩᐉ\u0002ϩᐉ\u0003", new Object[]{"b", "c", "e", "f"});
        }
        if (i2 == 3) {
            return new h();
        }
        if (i2 == 4) {
            return new g();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = d;
        if (bcVar == null) {
            synchronized (h.class) {
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
