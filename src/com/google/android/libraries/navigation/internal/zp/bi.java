package com.google.android.libraries.navigation.internal.zp;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bi a;
    public static final com.google.android.libraries.navigation.internal.ael.bh b;
    private static volatile dg i;
    public int c;
    public int d;
    public int e;
    public long f;
    public com.google.android.libraries.navigation.internal.zq.b g;
    public com.google.android.libraries.navigation.internal.zq.l h;
    private x j;
    private j k;
    private com.google.android.libraries.navigation.internal.zq.f l;
    private bm m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.zr.b f665n;
    private com.google.android.libraries.navigation.internal.zt.u o;
    private com.google.android.libraries.navigation.internal.zr.ay p;
    private byte q = 2;

    static {
        bi biVar = new bi();
        a = biVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bi.class, biVar);
        b = com.google.android.libraries.navigation.internal.ael.bi.t(cb.a, biVar, biVar, null, 363, es.MESSAGE, bi.class);
    }

    private bi() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.q);
        }
        if (i3 == 2) {
            return new dk(a, "\u0004\n\u0000\u0003\u0001H\n\u0000\u0000\u0005\u0001ᐉ\u0000\u0007ᐉ\u0006\u000bᐉ\n\u000eဂ\r\u0012ᐉ\u0011%ဉ$+ဉ*7ᐉ6=ဉ<HဉG", new Object[]{"c", "d", "e", "j", "k", "l", "f", "m", "g", "n", "o", ContextChain.TAG_PRODUCT, "h"});
        }
        if (i3 == 3) {
            return new bi();
        }
        if (i3 == 4) {
            return new bh();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            this.q = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = i;
        if (bcVar == null) {
            synchronized (bi.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}
