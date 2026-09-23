package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fb extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final fb a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private fs d;
    private byte e = 2;

    static {
        fb fbVar = new fb();
        a = fbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fb.class, fbVar);
    }

    private fb() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
        com.google.android.libraries.navigation.internal.ael.cm cmVar = com.google.android.libraries.navigation.internal.ael.cm.a;
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0001\u000fᐉ\u000b", new Object[]{"c", "d"});
        }
        if (i2 == 3) {
            return new fb();
        }
        if (i2 == 4) {
            return new fa();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (fb.class) {
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
