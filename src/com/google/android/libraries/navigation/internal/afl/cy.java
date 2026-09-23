package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cy extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cy a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public float b;
    public float c;
    public boolean h;
    private int k;
    public float d = 10.0f;
    public float e = 10.0f;
    public int f = 3000;
    public int g = 3000;
    public int i = 25000;

    static {
        cy cyVar = new cy();
        a = cyVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cy.class, cyVar);
    }

    private cy() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\u000b\b\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0006ခ\u0004\u0007ခ\u0005\bင\u0006\tင\u0007\nဇ\b\u000bင\t", new Object[]{"k", "b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new cy();
        }
        if (i2 == 4) {
            return new cx();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (cy.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
