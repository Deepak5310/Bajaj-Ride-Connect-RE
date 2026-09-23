package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bd a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public aq c;
    public ay d;
    public an e;
    public aw g;
    private byte i = 2;
    public com.google.android.libraries.navigation.internal.ael.bz f = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        bd bdVar = new bd();
        a = bdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bd.class, bdVar);
    }

    private bd() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001?\u0005\u0000\u0001\u0003\u0001ᔑ\u0000!ᔑ\u00011ᔑ\u0002:ထ\u0003?\u001b", new Object[]{"b", "c", "d", "e", "g", "f", au.class});
        }
        if (i2 == 3) {
            return new bd();
        }
        if (i2 == 4) {
            return new ao();
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
            synchronized (bd.class) {
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
