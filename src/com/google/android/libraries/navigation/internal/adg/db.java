package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class db extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final db a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public int c;
    public ba d;
    public eo e;
    public fk f;
    public jp g;
    public he h;
    public gk i;
    private byte k = 2;

    static {
        db dbVar = new db();
        a = dbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(db.class, dbVar);
    }

    private db() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.k);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0000\u0001\u0001င\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0006ဉ\u0005\bဉ\u0006\tဉ\u0007", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new db();
        }
        if (i2 == 4) {
            return new da();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.k = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (db.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
