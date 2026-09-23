package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bp a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public bo h;
    private int j;
    private int k;

    static {
        bp bpVar = new bp();
        a = bpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bp.class, bpVar);
    }

    private bp() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0002\\}\u0007\u0000\u0000\u0000\\ဇ\u0002`ဇ\u0005kဇ\u0017qဇ\u0018tဇ\u0011|ဉ)}ဇ\u0013", new Object[]{"j", "k", "b", "c", "f", "g", "d", "h", "e"});
        }
        if (i3 == 3) {
            return new bp();
        }
        if (i3 == 4) {
            return new bk();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (bp.class) {
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
