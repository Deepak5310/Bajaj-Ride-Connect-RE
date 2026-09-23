package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ga extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final ga a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public long b;
    public ii e;
    private int g;
    private byte h = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        ga gaVar = new ga();
        a = gaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ga.class, gaVar);
    }

    private ga() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.h);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0002\u0002\u0001စ\u0000\u0002Л\u0005Л\u0006ဉ\u0003", new Object[]{"g", "b", "c", db.class, "d", fz.class, "e"});
        }
        if (i2 == 3) {
            return new ga();
        }
        if (i2 == 4) {
            return new fx();
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
            synchronized (ga.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
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
