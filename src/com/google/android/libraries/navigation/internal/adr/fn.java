package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fn extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fn a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public double e;
    public com.google.android.libraries.navigation.internal.aap.r f;
    public fm g;
    private byte i = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String d = "";

    static {
        fn fnVar = new fn();
        a = fnVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fn.class, fnVar);
    }

    private fn() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001Л\u0002ဈ\u0000\u0004က\u0002\u0005ဉ\u0003\u0006ဉ\u0004", new Object[]{"b", "c", gn.class, "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new fn();
        }
        if (i2 == 4) {
            return new fk();
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
            synchronized (fn.class) {
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
