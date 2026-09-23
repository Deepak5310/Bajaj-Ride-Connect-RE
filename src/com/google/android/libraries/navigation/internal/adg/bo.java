package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bo extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bo a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    static {
        bo boVar = new bo();
        a = boVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bo.class, boVar);
    }

    private bo() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0006င\u0005\u0007င\u0006", new Object[]{"b", "c", "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new bo();
        }
        if (i3 == 4) {
            return new bn();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (bo.class) {
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
