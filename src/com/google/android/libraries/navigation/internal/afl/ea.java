package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ea extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ea a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg x;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.zr.u f309n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public int f = 20160;
    public int g = 10;
    public com.google.android.libraries.navigation.internal.ael.bq h = com.google.android.libraries.navigation.internal.ael.bj.a;
    private String y = "";
    private com.google.android.libraries.navigation.internal.ael.x z = com.google.android.libraries.navigation.internal.ael.x.b;
    public int i = 1;
    public com.google.android.libraries.navigation.internal.ael.bq j = com.google.android.libraries.navigation.internal.ael.bj.a;
    public int k = 60;

    static {
        ea eaVar = new ea();
        a = eaVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ea.class, eaVar);
    }

    private ea() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0014\u0000\u0004\u0004\u0085\u0014\u0000\u0002\u0000\u0004င\u0002\u0005င\u0003\n\u0016\u000b᠌\u0012\u0019\u0016/ဇ15င/:င6Dဉ?FဇAMဇHYဇSmဇTuဇmvဇnw᠌o\u0081ဇz\u0082ဈ\u0010\u0083ည\u0011\u0085ဇ|", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, dy.a, "j", "l", "k", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", dw.a, "v", "y", "z", "w"});
        }
        if (i2 == 3) {
            return new ea();
        }
        if (i2 == 4) {
            return new dv();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = x;
        if (bcVar == null) {
            synchronized (ea.class) {
                bcVar = x;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    x = bcVar;
                }
            }
        }
        return bcVar;
    }
}
