package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ar a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public String c;
    public String d;
    public z e;
    public com.google.android.libraries.navigation.internal.aap.n f;
    private byte h = 2;

    static {
        ar arVar = new ar();
        a = arVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ar.class, arVar);
    }

    private ar() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.c = "";
        this.d = "";
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဉ\u0005\bဉ\u0006", new Object[]{"b", "c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new ar();
        }
        if (i2 == 4) {
            return new aq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (ar.class) {
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
