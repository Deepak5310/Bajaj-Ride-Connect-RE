package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hi extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final hi a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public Object c;
    public int f;
    private int h;
    public int b = 0;
    public String d = "";
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        hi hiVar = new hi();
        a = hiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(hi.class, hiVar);
    }

    private hi() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0001\u0001\u0002\u0006\u0004\u0000\u0001\u0000\u0002ဈ\u0001\u0003\u001b\u0004င\u0003\u0006<\u0000", new Object[]{"c", "b", "h", "d", "e", n.class, "f", hh.class});
        }
        if (i2 == 3) {
            return new hi();
        }
        if (i2 == 4) {
            return new hf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (hi.class) {
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
