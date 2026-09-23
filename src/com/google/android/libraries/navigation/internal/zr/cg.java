package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public Object d;
    public ce f;
    public int c = 0;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        cg cgVar = new cg();
        a = cgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cg.class, cgVar);
    }

    private cg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002ဉ\u0000\u0003:\u0000", new Object[]{"d", "c", "b", "e", "f"});
        }
        if (i2 == 3) {
            return new cg();
        }
        if (i2 == 4) {
            return new cf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (cg.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
