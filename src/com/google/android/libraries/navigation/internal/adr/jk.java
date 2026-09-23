package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final jk a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public com.google.android.libraries.navigation.internal.adq.z d;
    private byte g = 2;
    public String c = "";
    public String e = "";

    static {
        jk jkVar = new jk();
        a = jkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jk.class, jkVar);
    }

    private jk() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.g);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\u000e\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0005ဉ\u0007\u000eဈ\b", new Object[]{"b", "c", "d", "e"});
        }
        if (i2 == 3) {
            return new jk();
        }
        if (i2 == 4) {
            return new jj();
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
            synchronized (jk.class) {
                bcVar = f;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f = bcVar;
                }
            }
        }
        return bcVar;
    }
}
