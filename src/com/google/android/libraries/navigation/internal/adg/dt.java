package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dt extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final dt a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    private byte h = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public int d = -1;
    public long e = -1;
    public int f = 1;

    static {
        dt dtVar = new dt();
        a = dtVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dt.class, dtVar);
    }

    private dt() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001Л\u0002င\u0000\u0003ဂ\u0001\u0004᠌\u0002", new Object[]{"b", "c", dp.class, "d", "e", "f", dr.a});
        }
        if (i2 == 3) {
            return new dt();
        }
        if (i2 == 4) {
            return new dq();
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
            synchronized (dt.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.c;
        if (bzVar.c()) {
            return;
        }
        this.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
