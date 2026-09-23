package com.google.android.libraries.navigation.internal.nk;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends bi implements cz {
    public static final p a;
    private static volatile dg p;
    public int b;
    public int d;
    public com.google.android.libraries.navigation.internal.zr.u f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public bq c = bj.a;
    public bq e = bj.a;
    public int m = 10;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f490n = 20160;
    public int o = 60;

    static {
        p pVar = new p();
        a = pVar;
        bi.F(p.class, pVar);
    }

    private p() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0002\u0000\u0001'\u0002င\u0000\u0003'\u0004ဉ\u0001\u0005ဇ\u0002\u0006ဇ\u0003\u0007᠌\u0004\bဇ\u0005\tဇ\u0006\n᠌\u0007\u000bင\b\fင\t\rင\n", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, l.a, "j", "k", "l", n.a, "m", "n", "o"});
        }
        if (i2 == 3) {
            return new p();
        }
        if (i2 == 4) {
            return new k();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = p;
        if (bcVar == null) {
            synchronized (p.class) {
                bcVar = p;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    p = bcVar;
                }
            }
        }
        return bcVar;
    }
}
