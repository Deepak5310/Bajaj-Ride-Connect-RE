package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ac a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int c;
    public s d;
    public dg e;
    public be f;
    public bs g;
    public com.google.android.libraries.navigation.internal.zp.d h;

    static {
        ac acVar = new ac();
        a = acVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ac.class, acVar);
    }

    private ac() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0006\u0000\u0001\u0001\f\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0007ဉ\u0006\bဉ\u0007\fဉ\u000b", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.afl.k.a, "d", "e", "f", "g", "h"});
        }
        if (i3 == 3) {
            return new ac();
        }
        if (i3 == 4) {
            return new ab();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (ac.class) {
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
