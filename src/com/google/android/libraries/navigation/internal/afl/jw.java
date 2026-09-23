package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jw extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final jw a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public com.google.android.libraries.navigation.internal.ael.bz b = com.google.android.libraries.navigation.internal.ael.dj.b;
    public boolean c;
    public boolean d;
    private int f;

    static {
        jw jwVar = new jw();
        a = jwVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jw.class, jwVar);
    }

    private jw() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0002\u0018\u0003\u0000\u0001\u0000\u0002ဇ\u0000\u000bဇ\u0001\u0018\u001b", new Object[]{"f", "c", "d", "b", com.google.android.libraries.navigation.internal.aap.ag.class});
        }
        if (i2 == 3) {
            return new jw();
        }
        if (i2 == 4) {
            return new jv();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (jw.class) {
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
