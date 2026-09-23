package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class is extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final is a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public com.google.android.libraries.navigation.internal.afm.v c;
    public com.google.android.libraries.navigation.internal.afm.x d;
    private com.google.android.libraries.navigation.internal.acd.oz g;
    private byte h = 2;
    public boolean e = true;

    static {
        is isVar = new is();
        a = isVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(is.class, isVar);
    }

    private is() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0002\u0001ᔉ\u0000\u0003ᐉ\u0002\u0004ဇ\u0003\u0006ဉ\u0004", new Object[]{"b", "c", "d", "e", "g"});
        }
        if (i2 == 3) {
            return new is();
        }
        if (i2 == 4) {
            return new ir();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.h = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (is.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
