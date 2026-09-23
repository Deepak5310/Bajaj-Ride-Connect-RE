package com.google.android.libraries.navigation.internal.yy;

import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;
import com.google.android.libraries.navigation.internal.yx.bz;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    static final br a = new bv(new c());
    static final bz b;
    aq h;
    aq i;
    com.google.android.libraries.navigation.internal.yx.y m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    com.google.android.libraries.navigation.internal.yx.y f659n;
    bz o;
    g q;
    f r;
    boolean c = true;
    final int d = -1;
    int e = -1;
    long f = -1;
    long g = -1;
    long j = -1;
    long k = -1;
    final long l = -1;
    final br p = a;

    static {
        new k();
        b = new d();
    }

    private final void h() {
        if (this.q == null) {
            com.google.android.libraries.navigation.internal.yx.ar.l(this.g == -1, "maximumWeight requires weigher");
        } else if (this.c) {
            com.google.android.libraries.navigation.internal.yx.ar.l(this.g != -1, "weigher requires maximumWeight");
        } else if (this.g == -1) {
            e.a.logp(Level.WARNING, "com.google.common.cache.CacheBuilder", "checkWeightWithWeigher", "ignoring weigher specified without maximumWeight");
        }
    }

    public final b a() {
        h();
        com.google.android.libraries.navigation.internal.yx.ar.l(true, "refreshAfterWrite requires a LoadingCache");
        return new al(new bi(this, null));
    }

    public final h b() {
        g(aq.WEAK);
        return this;
    }

    public final m c(j jVar) {
        h();
        return new aj(this, jVar);
    }

    final aq d() {
        return (aq) com.google.android.libraries.navigation.internal.yx.al.c(this.h, aq.STRONG);
    }

    final aq e() {
        return (aq) com.google.android.libraries.navigation.internal.yx.al.c(this.i, aq.STRONG);
    }

    public final void f(long j) {
        long j2 = this.f;
        com.google.android.libraries.navigation.internal.yx.ar.n(j2 == -1, "maximum size was already set to %s", j2);
        long j3 = this.g;
        com.google.android.libraries.navigation.internal.yx.ar.n(j3 == -1, "maximum weight was already set to %s", j3);
        com.google.android.libraries.navigation.internal.yx.ar.l(this.q == null, "maximum size can not be combined with weigher");
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "maximum size must not be negative");
        this.f = j;
    }

    final void g(aq aqVar) {
        aq aqVar2 = this.h;
        com.google.android.libraries.navigation.internal.yx.ar.o(aqVar2 == null, "Key strength was already set to %s", aqVar2);
        com.google.android.libraries.navigation.internal.yx.ar.q(aqVar);
        this.h = aqVar;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        int i = this.e;
        if (i != -1) {
            akVarB.c("concurrencyLevel", i);
        }
        long j = this.f;
        if (j != -1) {
            akVarB.d("maximumSize", j);
        }
        long j2 = this.g;
        if (j2 != -1) {
            akVarB.d("maximumWeight", j2);
        }
        long j3 = this.j;
        if (j3 != -1) {
            akVarB.g("expireAfterWrite", j3 + "ns");
        }
        long j4 = this.k;
        if (j4 != -1) {
            akVarB.g("expireAfterAccess", j4 + "ns");
        }
        aq aqVar = this.h;
        if (aqVar != null) {
            akVarB.g("keyStrength", com.google.android.libraries.navigation.internal.yx.c.a(aqVar.toString()));
        }
        aq aqVar2 = this.i;
        if (aqVar2 != null) {
            akVarB.g("valueStrength", com.google.android.libraries.navigation.internal.yx.c.a(aqVar2.toString()));
        }
        if (this.m != null) {
            akVarB.f("keyEquivalence");
        }
        if (this.f659n != null) {
            akVarB.f("valueEquivalence");
        }
        if (this.r != null) {
            akVarB.f("removalListener");
        }
        return akVarB.toString();
    }
}
