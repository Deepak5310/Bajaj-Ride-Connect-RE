package com.google.android.libraries.navigation.internal.zt;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;
import com.google.android.libraries.navigation.internal.zp.bo;
import com.google.android.libraries.navigation.internal.zp.bt;
import com.google.android.libraries.navigation.internal.zp.cb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag extends bi implements cz {
    public static final ag a;
    public static final bh b;
    private static volatile dg l;
    public int c;
    public int d;
    public bz e;
    public com.google.android.libraries.navigation.internal.zq.h f;
    public ai g;
    public h h;
    public al i;
    public s j;
    public bo k;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ae f679n;
    private com.google.android.libraries.navigation.internal.zp.x o;
    private com.google.android.libraries.navigation.internal.zp.z p;
    private com.google.android.libraries.navigation.internal.zp.f q;
    private com.google.android.libraries.navigation.internal.zq.f r;
    private u s;
    private bt t;
    private byte u = 2;

    static {
        ag agVar = new ag();
        a = agVar;
        bi.F(ag.class, agVar);
        b = bi.t(cb.a, agVar, agVar, null, 67, es.MESSAGE, ag.class);
    }

    private ag() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        this.e = dj.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.u);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u000e\u0000\u0003\u0001X\u000e\u0000\u0001\u0006\u0001ᐉ\u0000\u0014\u001b\u001cဉ\u0018\u001eᐉ\u001a\u001fဉ\u001d ဉ\u001f!ဉ #ဉ\"$ဉ#9ᐉ\u001b<ᐉ;>ᐉ=OᐉHXဉP", new Object[]{"c", "d", "m", "n", "e", com.google.android.libraries.navigation.internal.zv.b.class, "f", "o", "g", "h", ContextChain.TAG_INFRA, "j", "k", ContextChain.TAG_PRODUCT, "q", "r", "s", "t"});
        }
        if (i2 == 3) {
            return new ag();
        }
        if (i2 == 4) {
            return new af();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.u = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = l;
        if (bcVar == null) {
            synchronized (ag.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
