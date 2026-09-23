package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends com.google.android.libraries.navigation.internal.ael.bi implements an {
    public static final am a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public long e;
    private com.google.android.libraries.navigation.internal.acd.pb g;
    private byte h = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.x d = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        am amVar = new am();
        a = amVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(am.class, amVar);
    }

    private am() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001Л\u0002ဉ\u0000\u0003ည\u0001\u0004ဂ\u0002", new Object[]{"b", "c", hb.class, "g", "d", "e"});
        }
        if (i2 == 3) {
            return new am();
        }
        if (i2 == 4) {
            return new al();
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
            synchronized (am.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void e() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.c;
        if (bzVar.c()) {
            return;
        }
        this.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
