package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final lg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg m;
    public int b;
    public ls c;
    public b d;
    public le e;
    public boolean g;
    public int h;
    public com.google.android.libraries.navigation.internal.ady.ab i;
    public boolean k;
    public com.google.android.libraries.navigation.internal.adq.t l;
    public com.google.android.libraries.navigation.internal.ael.bz f = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String j = "";

    static {
        lg lgVar = new lg();
        a = lgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lg.class, lgVar);
    }

    private lg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0001\u0017\n\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u000bဉ\b\u000e᠌\u000b\u0010ဈ\u000f\u0012ဇ\u0010\u0013ဉ\u0011\u0015\u001b\u0016ဉ\r\u0017ဇ\n", new Object[]{"b", "c", "d", "e", "h", com.google.android.libraries.navigation.internal.adq.aq.a, "j", "k", "l", "f", le.class, ContextChain.TAG_INFRA, "g"});
        }
        if (i2 == 3) {
            return new lg();
        }
        if (i2 == 4) {
            return new lf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = m;
        if (bcVar == null) {
            synchronized (lg.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
