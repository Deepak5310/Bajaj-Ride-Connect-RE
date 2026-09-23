package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jo extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final jo a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public jk c;
    public jk d;
    public de f;
    private byte j = 2;
    public String e = "";
    public com.google.android.libraries.navigation.internal.ael.bz g = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        jo joVar = new jo();
        a = joVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jo.class, joVar);
    }

    private jo() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\r\u0006\u0000\u0002\u0004\u0001ᐉ\u0001\u0002ᐉ\u0002\u0004ဈ\u0004\u0006ဉ\u0006\bЛ\rЛ", new Object[]{"b", "c", "d", "e", "f", "g", jk.class, "h", t.class});
        }
        if (i3 == 3) {
            return new jo();
        }
        if (i3 == 4) {
            return new jn();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (jo.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
