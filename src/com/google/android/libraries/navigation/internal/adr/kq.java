package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final kq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg h;
    public int b;
    public jg e;
    private byte i = 2;
    public int c = 1;
    public int d = 1;
    public com.google.android.libraries.navigation.internal.ael.x f = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.x g = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        kq kqVar = new kq();
        a = kqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(kq.class, kqVar);
    }

    private kq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0001\u0001᠌\u0000\u0002᠌\u0001\u0005ᐉ\u0002\u0006ည\u0003\u0007ည\u0004", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.ady.ac.a, "d", ko.a, "e", "f", "g"});
        }
        if (i2 == 3) {
            return new kq();
        }
        if (i2 == 4) {
            return new kn();
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
            synchronized (kq.class) {
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
