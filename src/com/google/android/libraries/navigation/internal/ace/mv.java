package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mv extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mv a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public mq c;
    public ms d;
    public int f;
    public int h;
    public String e = "";
    public String g = "";

    static {
        mv mvVar = new mv();
        a = mvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mv.class, mvVar);
    }

    private mv() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0000", null);
        }
        if (i3 == 3) {
            return new mv();
        }
        if (i3 == 4) {
            return new mo();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (mv.class) {
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
