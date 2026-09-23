package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ai a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public int d;
    public long e;
    private byte i = 2;
    public String c = "";
    public com.google.android.libraries.navigation.internal.ael.x f = com.google.android.libraries.navigation.internal.ael.x.b;
    public String g = "";

    static {
        ai aiVar = new ai();
        a = aiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ai.class, aiVar);
    }

    private ai() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0002\u0007\u0005\u0000\u0000\u0004\u0002ᔈ\u0000\u0003ᔄ\u0001\u0004ᔅ\u0002\u0006ည\u0003\u0007ᔈ\u0004", new Object[]{"b", "c", "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new ai();
        }
        if (i2 == 4) {
            return new ah();
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
            synchronized (ai.class) {
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
