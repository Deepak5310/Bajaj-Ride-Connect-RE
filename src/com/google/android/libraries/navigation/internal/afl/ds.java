package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ds extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ds a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg l;
    public int b;
    public boolean c;
    public boolean d;
    public dr e;
    public Cdo f;
    public int g = 12;
    public int h = 15;
    public int i;
    public boolean j;
    public boolean k;

    static {
        ds dsVar = new ds();
        a = dsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ds.class, dsVar);
    }

    private ds() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\t\u0000\u0001\u0004\u0015\t\u0000\u0000\u0000\u0004ဇ\u0001\bဉ\n\tင\u000b\nင\r\u000bဇ\u000e\rဇ\u000f\u000eဉ\b\u0014င\f\u0015ဇ\u0002", new Object[]{"b", "c", "f", "g", ContextChain.TAG_INFRA, "j", "k", "e", "h", "d"});
        }
        if (i2 == 3) {
            return new ds();
        }
        if (i2 == 4) {
            return new dp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = l;
        if (bcVar == null) {
            synchronized (ds.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
