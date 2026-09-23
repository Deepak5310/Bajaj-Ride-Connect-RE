package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class on extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final on a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public mh c;
    public com.google.android.libraries.navigation.internal.zs.dl d;
    public com.google.android.libraries.navigation.internal.acl.d e;
    private oz g;
    private byte h = 2;

    static {
        on onVar = new on();
        a = onVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(on.class, onVar);
    }

    private on() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0002\u0001ဉ\u0000\u0002ᐉ\u0001\u0003ဉ\u0003\u0004ᐉ\u0002", new Object[]{"b", "c", "d", "g", "e"});
        }
        if (i2 == 3) {
            return new on();
        }
        if (i2 == 4) {
            return new om();
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
            synchronized (on.class) {
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
