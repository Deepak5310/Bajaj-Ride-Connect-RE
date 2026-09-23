package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class df extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final df a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int c;
    public dh d;
    public am e;
    public dd f;
    public ae h;
    private byte j = 2;
    public com.google.android.libraries.navigation.internal.ael.bz g = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        df dfVar = new df();
        a = dfVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(df.class, dfVar);
    }

    private df() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0002\u0001င\u0000\u0002ᐉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006ᐉ\u0004", new Object[]{"b", "c", "d", "e", "f", "g", by.class, "h"});
        }
        if (i3 == 3) {
            return new df();
        }
        if (i3 == 4) {
            return new de();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (df.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
