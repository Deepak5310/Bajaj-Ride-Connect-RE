package com.google.android.libraries.navigation.internal.zr;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.acd.mk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final dg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    static {
        dg dgVar = new dg();
        a = dgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dg.class, dgVar);
    }

    private dg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\r\b\u0000\u0000\u0000\u0001᠌\u0000\u0007င\u0007\bင\b\tင\t\nင\n\u000bင\u000b\fင\f\rင\r", new Object[]{"b", "c", mk.a, "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new dg();
        }
        if (i2 == 4) {
            return new df();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (dg.class) {
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
