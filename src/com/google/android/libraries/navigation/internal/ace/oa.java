package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class oa extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final oa a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int c;
    public String d = "";
    public String e = "";
    public String f = "";
    public int g;
    public int h;

    static {
        oa oaVar = new oa();
        a = oaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(oa.class, oaVar);
    }

    private oa() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0003᠌\u0006\u0004ဈ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007᠌\u0005", new Object[]{"b", "c", ny.a, "h", nu.a, "d", "e", "f", "g", nw.a});
        }
        if (i3 == 3) {
            return new oa();
        }
        if (i3 == 4) {
            return new nt();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (oa.class) {
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
