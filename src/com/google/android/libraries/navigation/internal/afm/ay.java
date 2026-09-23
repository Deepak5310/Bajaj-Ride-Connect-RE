package com.google.android.libraries.navigation.internal.afm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ay a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g = 3;
    public int h = 80000000;
    public int i = -90000000;
    public int j = 90000000;

    static {
        ay ayVar = new ay();
        a = ayVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ay.class, ayVar);
    }

    private ay() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\b\u0000\u0001\")\b\u0000\u0000\u0000\"င\u0000#င\u0001$င\u0002%င\u0003&᠌\u0004'င\u0005(င\u0006)င\u0007", new Object[]{"b", "c", "d", "e", "f", "g", az.a, "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new ay();
        }
        if (i2 == 4) {
            return new ax();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (ay.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
