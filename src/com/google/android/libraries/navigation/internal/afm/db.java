package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class db extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final db a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private int d;
    private int e;
    private int f;
    private com.google.android.libraries.navigation.internal.ado.n g;
    private int h;
    private byte i = 2;

    static {
        db dbVar = new db();
        a = dbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(db.class, dbVar);
    }

    private db() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0005\u0000\u0001\u0001\u001b\u0005\u0000\u0000\u0005\u0001ᴌ\u0016\u0002ᔄ\u0000\u0003ᔄ\u0001\u0004ᔄ\u0002\u001bᐉ\u000f", new Object[]{"c", "h", cz.a, "d", "e", "f", "g"});
        }
        if (i2 == 3) {
            return new db();
        }
        if (i2 == 4) {
            return new cy();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (db.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
