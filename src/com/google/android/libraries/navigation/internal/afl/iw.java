package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class iw extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final iw a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg d;
    public int b;
    private int e;
    private com.google.android.libraries.navigation.internal.acd.pb f;
    private byte g = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        iw iwVar = new iw();
        a = iwVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(iw.class, iwVar);
    }

    private iw() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0002\u0001ᴌ\u0000\u0002Л\u0004ဉ\u0002", new Object[]{"e", "b", iu.a, "c", iy.class, "f"});
        }
        if (i2 == 3) {
            return new iw();
        }
        if (i2 == 4) {
            return new it();
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
            synchronized (iw.class) {
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
