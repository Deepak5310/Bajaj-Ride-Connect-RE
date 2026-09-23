package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.zr.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class Cdo extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final Cdo a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f;
    public int b;
    public int c;
    public int d;
    public aa e;

    static {
        Cdo cdo = new Cdo();
        a = cdo;
        com.google.android.libraries.navigation.internal.ael.bi.F(Cdo.class, cdo);
    }

    private Cdo() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"b", "c", dm.a, "d", dk.a, "e"});
        }
        if (i2 == 3) {
            return new Cdo();
        }
        if (i2 == 4) {
            return new dj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f;
        if (bcVar == null) {
            synchronized (Cdo.class) {
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
