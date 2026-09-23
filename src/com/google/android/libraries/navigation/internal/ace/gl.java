package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public String c = "";
    public String d;
    private int f;

    static {
        gl glVar = new gl();
        a = glVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gl.class, glVar);
    }

    private gl() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.d = "";
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0001\t\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0005ဈ\u0003\tဈ\u0006", new Object[]{"f", "b", gj.a, "c", "d"});
        }
        if (i2 == 3) {
            return new gl();
        }
        if (i2 == 4) {
            return new gi();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (gl.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
