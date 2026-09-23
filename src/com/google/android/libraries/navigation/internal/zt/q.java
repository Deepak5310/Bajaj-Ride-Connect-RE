package com.google.android.libraries.navigation.internal.zt;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.zr.Cdo;
import com.google.android.libraries.navigation.internal.zr.ds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends bi implements cz {
    public static final q a;
    private static volatile dg o;
    public int b;
    public int c;
    public int d;
    public int e;
    public com.google.android.libraries.navigation.internal.zr.u f;
    public int g;
    public Cdo i;
    public long j;
    public ds k;
    public boolean l;
    public int m;
    private boolean p;
    public bq h = bj.a;
    private String q = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f681n = "";

    static {
        q qVar = new q();
        a = qVar;
        bi.F(q.class, qVar);
    }

    private q() {
    }

    public static /* synthetic */ void b(q qVar) {
        qVar.c |= 262144;
        qVar.p = true;
    }

    public static /* synthetic */ void c(q qVar) {
        qVar.c |= 16777216;
        qVar.q = "6.1.0";
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\f\u0000\u0003\u0003H\f\u0000\u0001\u0000\u0003᠌\u0005,ဇ2/ဉ51᠌73\u00164ဈ87ဉ;9ဂ<:ဉ=@ဇCBငEHဈL", new Object[]{"b", "c", "d", "e", j.a, ContextChain.TAG_PRODUCT, "f", "g", l.a, "h", "q", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n"});
        }
        if (i2 == 3) {
            return new q();
        }
        if (i2 == 4) {
            return new i();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = o;
        if (bcVar == null) {
            synchronized (q.class) {
                bcVar = o;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    o = bcVar;
                }
            }
        }
        return bcVar;
    }
}
