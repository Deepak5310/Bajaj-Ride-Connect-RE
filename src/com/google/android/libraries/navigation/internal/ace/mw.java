package com.google.android.libraries.navigation.internal.ace;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mw extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mw a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public boolean b;
    public boolean c;
    public ml d;
    public ml e;
    public mn f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    private int l;

    static {
        mw mwVar = new mw();
        a = mwVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mw.class, mwVar);
    }

    private mw() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\u0011\b\u0000\u0000\u0000\u0001ဇ\u0000\u0004ဇ\u0003\u0005ဉ\u0006\u0006ဉ\u0007\tဇ\f\nင\r\u000bင\u000e\u0011ဇ\u0012", new Object[]{"l", "b", "c", "d", "e", "g", "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new mw();
        }
        if (i2 == 4) {
            return new mh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (mw.class) {
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
