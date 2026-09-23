package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final dl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public ev c;
    public int e;
    private byte g = 2;
    public com.google.android.libraries.navigation.internal.ael.bz d = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        dl dlVar = new dl();
        a = dlVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dl.class, dlVar);
    }

    private dl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003င\u0001", new Object[]{"b", "c", "d", de.class, "e"});
        }
        if (i2 == 3) {
            return new dl();
        }
        if (i2 == 4) {
            return new cw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.g = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (dl.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.d;
        if (bzVar.c()) {
            return;
        }
        this.d = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
