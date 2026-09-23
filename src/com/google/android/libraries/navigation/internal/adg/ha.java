package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ha extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final ha a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int f;
    public int g;
    public fs h;
    private byte j = 2;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public int d = -1;
    public long e = -1;

    static {
        ha haVar = new ha();
        a = haVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ha.class, haVar);
    }

    private ha() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0001\u0001ည\u0000\u0003င\u0001\u0004င\u0003\u0005ဆ\u0004\u0006ဂ\u0002\u0007ᐉ\u0006", new Object[]{"b", "c", "d", "f", "g", "e", "h"});
        }
        if (i3 == 3) {
            return new ha();
        }
        if (i3 == 4) {
            return new gz();
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
            synchronized (ha.class) {
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
