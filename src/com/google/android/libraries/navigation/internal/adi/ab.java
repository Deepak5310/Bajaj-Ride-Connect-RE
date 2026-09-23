package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final ab a;
    private static volatile dg t;
    public int b;
    public float l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f207n;
    public bh o;
    public int p;
    public int s;
    private boolean u;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public com.google.android.libraries.navigation.internal.ael.bq m = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz q = dj.b;
    public String r = "";

    static {
        ab abVar = new ab();
        a = abVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ab.class, abVar);
    }

    private ab() {
    }

    public static /* synthetic */ void d(ab abVar) {
        abVar.b |= 1048576;
        abVar.u = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0012\u0000\u0001\u0001\u0018\u0012\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0004ဈ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\bဈ\t\tခ\n\n\u0016\u000bဇ\u000b\fဈ\u0006\rဈ\u0007\u000eဉ\f\u000f᠌\r\u0010ဈ\b\u0012\u001a\u0013ဈ\u0011\u0016ဇ\u0014\u0018င\u0015", new Object[]{"b", "c", "d", "e", "f", "g", "k", "l", "m", "n", "h", ContextChain.TAG_INFRA, "o", ContextChain.TAG_PRODUCT, b.a, "j", "q", "r", "u", "s"});
        }
        if (i2 == 3) {
            return new ab();
        }
        if (i2 == 4) {
            return new aa();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = t;
        if (bcVar == null) {
            synchronized (ab.class) {
                bcVar = t;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    t = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bq bqVar = this.m;
        if (bqVar.c()) {
            return;
        }
        this.m = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
    }
}
