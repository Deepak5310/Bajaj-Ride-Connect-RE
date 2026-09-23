package com.google.android.libraries.navigation.internal.zp;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.acd.mk;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ay a;
    private static volatile dg y;
    public int b;
    public int e;
    public int g;
    public int h;
    public int i;
    public int k;
    public boolean l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f664n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public bc u;
    public long w;
    public com.google.android.libraries.navigation.internal.aeu.b x;
    public int c = 1;
    public String d = "";
    public String f = "";
    public String j = "";
    public String t = "";
    public com.google.android.libraries.navigation.internal.ael.bz v = dj.b;

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
            return new dk(a, "\u0001\u0016\u0000\u0001\u0001 \u0016\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003᠌\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\tဈ\b\n᠌\t\fဇ\u000b\r᠌\r\u000fင\u000f\u0010င\u0010\u0011င\u0011\u0012᠌\u0012\u0014᠌\u0013\u0015᠌\u0014\u0017ဈ\u0016\u0018ဉ\u0017\u001d\u001b\u001fဂ\u001d ဉ\u001e", new Object[]{"b", "c", "d", "e", au.a, "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", as.a, "l", "m", com.google.android.libraries.navigation.internal.abx.a.a, "n", "o", ContextChain.TAG_PRODUCT, "q", aw.a, "r", mk.a, "s", com.google.android.libraries.navigation.internal.acd.u.a, "t", "u", "v", ao.class, "w", "x"});
        }
        if (i2 == 3) {
            return new ay();
        }
        if (i2 == 4) {
            return new ar();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = y;
        if (bcVar == null) {
            synchronized (ay.class) {
                bcVar = y;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    y = bcVar;
                }
            }
        }
        return bcVar;
    }
}
