package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cx extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cx a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg q;
    public int b;
    public long f;
    public long g;
    public com.google.android.libraries.navigation.internal.aeb.b h;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f184n;
    public int o;
    public int p;
    private com.google.android.libraries.navigation.internal.aau.b r;
    public String c = "";
    public String d = "";
    public String e = "";
    public String i = "";
    public String j = "";

    static {
        cx cxVar = new cx();
        a = cxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cx.class, cxVar);
    }

    private cx() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000f\u0000\u0001\u0001\u0014\u000f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003စ\u0004\u0004စ\u0005\u0005ဈ\t\u0006ဇ\u000b\bဇ\u000e\tဈ\u0003\nဇ\u000f\rဈ\n\u000eင\u0010\u000fင\u0012\u0010ဇ\f\u0011ဉ\u0002\u0014ဉ\u0007", new Object[]{"b", "c", "d", "f", "g", ContextChain.TAG_INFRA, "k", "m", "e", "n", "j", "o", ContextChain.TAG_PRODUCT, "l", "r", "h"});
        }
        if (i2 == 3) {
            return new cx();
        }
        if (i2 == 4) {
            return new cw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = q;
        if (bcVar == null) {
            synchronized (cx.class) {
                bcVar = q;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    q = bcVar;
                }
            }
        }
        return bcVar;
    }
}
