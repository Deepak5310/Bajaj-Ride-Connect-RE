package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dp extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final dp a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int f;
    public int g;
    public boolean h;
    private byte j = 2;
    public String c = "";
    public int d = -1;
    public long e = -1;

    static {
        dp dpVar = new dp();
        a = dpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dp.class, dpVar);
    }

    private dp() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001ߐ\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဇ\u0005\u0004ဂ\u0002\u0005င\u0004ߐင\u0003", new Object[]{"b", "c", "d", "h", "e", "g", "f"});
        }
        if (i3 == 3) {
            return new dp();
        }
        if (i3 == 4) {
            return new Cdo();
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
            synchronized (dp.class) {
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
