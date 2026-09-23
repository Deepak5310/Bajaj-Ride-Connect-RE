package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fi extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final fi a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    private byte d = 2;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        fi fiVar = new fi();
        a = fiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fi.class, fiVar);
    }

    private fi() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.d);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"b", fg.class});
        }
        if (i2 == 3) {
            return new fi();
        }
        if (i2 == 4) {
            return new fh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.d = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (fi.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.b;
        if (bzVar.c()) {
            return;
        }
        this.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
