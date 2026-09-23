package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ls extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ls a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg v;
    public int b;
    public int c;
    public com.google.android.libraries.navigation.internal.adq.z f;
    public boolean h;
    public int i;
    public com.google.android.libraries.navigation.internal.adq.h l;
    public boolean o;
    public ln p;
    public co q;
    public int r;
    public int s;
    public cs t;
    public lr u;
    public String d = "";
    public String e = "";
    public String g = "";
    public String j = "";
    public int k = 4;
    public String m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f230n = "";

    static {
        ls lsVar = new ls();
        a = lsVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ls.class, lsVar);
    }

    private ls() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0013\u0000\u0001\u0001\u001d\u0013\u0000\u0000\u0000\u0001ဈ\u0001\u0002ဈ\u0002\u0003ဉ\u0003\u0004ဈ\b\u0005᠌\t\u0006᠌\u0000\u0007ဉ\n\rဈ\f\u000eဈ\u000e\u0012ဇ\u0010\u0013ဈ\u0004\u0015ဇ\u0006\u0016င\u0007\u0017ဉ\u0011\u0018ဉ\u0012\u0019᠌\u0013\u001bင\u0014\u001cဉ\u0015\u001dဉ\u0016", new Object[]{"b", "d", "e", "f", "j", "k", li.a, "c", lo.a, "l", "m", "n", "o", "g", "h", ContextChain.TAG_INFRA, ContextChain.TAG_PRODUCT, "q", "r", lk.a, "s", "t", "u"});
        }
        if (i2 == 3) {
            return new ls();
        }
        if (i2 == 4) {
            return new lh();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = v;
        if (bcVar == null) {
            synchronized (ls.class) {
                bcVar = v;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    v = bcVar;
                }
            }
        }
        return bcVar;
    }
}
