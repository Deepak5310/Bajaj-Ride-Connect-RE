package com.google.android.libraries.navigation.internal.aga;

import io.grpc.internal.GrpcUtil;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cr extends com.google.android.libraries.navigation.internal.afx.bd implements com.google.android.libraries.navigation.internal.afx.ai {
    static final Logger a = Logger.getLogger(cr.class.getName());
    static final com.google.android.libraries.navigation.internal.afx.cl b;
    static final com.google.android.libraries.navigation.internal.afx.cl c;
    public static final dc d;
    public static final com.google.android.libraries.navigation.internal.afx.ah e;
    public final cm A;
    public dc B;
    public final dc C;
    public boolean D;
    public final boolean E;
    final bb F;
    public final cc G;
    public int H;
    public final ao I;
    private final String J;
    private final URI K;
    private final com.google.android.libraries.navigation.internal.afx.bz L;
    private final com.google.android.libraries.navigation.internal.afx.br M;
    private final h N;
    private final Executor O;
    private final ce P;
    private final ce Q;
    private final long R;
    private final com.google.android.libraries.navigation.internal.afx.e S;
    private volatile com.google.android.libraries.navigation.internal.afx.ax T;
    private final Set U;
    private volatile boolean V;
    private final CountDownLatch W;
    private final boolean X;
    private final dd Y;
    private final ec Z;
    private final es aa;
    private final df ab;
    public final com.google.android.libraries.navigation.internal.afx.aj f;
    public final s g;
    public final cn h;
    public final et i;
    final com.google.android.libraries.navigation.internal.afx.cq j;
    public final com.google.android.libraries.navigation.internal.yx.br k;
    public final w l;
    public final List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.afx.by f334n;
    public boolean o;
    public cj p;
    public boolean q;
    public final Set r;
    public final Object s;
    public final ab t;
    public final AtomicBoolean u;
    public boolean v;
    public final m w;
    public final p x;
    public final com.google.android.libraries.navigation.internal.afx.g y;
    public final com.google.android.libraries.navigation.internal.afx.ag z;

    static {
        com.google.android.libraries.navigation.internal.afx.cl.f.b("Channel shutdownNow invoked");
        b = com.google.android.libraries.navigation.internal.afx.cl.f.b("Channel shutdown invoked");
        c = com.google.android.libraries.navigation.internal.afx.cl.f.b("Subchannel shutdown invoked");
        d = new dc(null, new HashMap(), new HashMap(), null, null, null);
        e = new bz();
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object, java.util.concurrent.Executor] */
    public cr(cx cxVar, s sVar, URI uri, com.google.android.libraries.navigation.internal.afx.bz bzVar, ao aoVar, es esVar, com.google.android.libraries.navigation.internal.yx.br brVar, List list, et etVar) {
        com.google.android.libraries.navigation.internal.afx.cq cqVar = new com.google.android.libraries.navigation.internal.afx.cq(new cb(this));
        this.j = cqVar;
        this.l = new w();
        this.r = new HashSet(16, 0.75f);
        this.s = new Object();
        this.U = new HashSet(1, 0.75f);
        new HashSet();
        this.u = new AtomicBoolean(false);
        this.W = new CountDownLatch(1);
        this.H = 1;
        this.B = d;
        this.D = false;
        new AtomicLong();
        int i = com.google.android.libraries.navigation.internal.afx.v.a;
        cd cdVar = new cd(this);
        this.Y = cdVar;
        this.F = new cf(this);
        this.G = new cc();
        String str = cxVar.i;
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "target");
        this.J = str;
        com.google.android.libraries.navigation.internal.afx.aj ajVarB = com.google.android.libraries.navigation.internal.afx.aj.b("Channel", str);
        this.f = ajVarB;
        com.google.android.libraries.navigation.internal.yx.ar.r(etVar, "timeProvider");
        this.i = etVar;
        es esVar2 = cxVar.C;
        com.google.android.libraries.navigation.internal.yx.ar.r(esVar2, "executorPool");
        this.aa = esVar2;
        ?? A = esVar2.a();
        com.google.android.libraries.navigation.internal.yx.ar.r(A, "executor");
        this.O = A;
        es esVar3 = cxVar.D;
        com.google.android.libraries.navigation.internal.yx.ar.r(esVar3, "offloadExecutorPool");
        ce ceVar = new ce(esVar3);
        this.Q = ceVar;
        l lVar = new l(sVar, ceVar);
        this.g = lVar;
        new l(sVar, ceVar);
        cn cnVar = new cn(lVar.c());
        this.h = cnVar;
        p pVar = new p(ajVarB, etVar.a(), "Channel for '" + str + "'");
        this.x = pVar;
        o oVar = new o(pVar, etVar);
        this.y = oVar;
        com.google.android.libraries.navigation.internal.afx.cd cdVar2 = az.a;
        boolean z = cxVar.t;
        this.X = z;
        h hVar = new h(com.google.android.libraries.navigation.internal.afx.bc.b(), cxVar.l);
        this.N = hVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(uri, "targetUri");
        this.K = uri;
        com.google.android.libraries.navigation.internal.yx.ar.r(bzVar, "nameResolverProvider");
        this.L = bzVar;
        ej ejVar = new ej(z, cxVar.p, cxVar.q, hVar);
        com.google.android.libraries.navigation.internal.afx.bp.a();
        df dfVar = new df();
        this.ab = dfVar;
        com.google.android.libraries.navigation.internal.afx.bq bqVar = new com.google.android.libraries.navigation.internal.afx.bq();
        bqVar.a = Integer.valueOf(GrpcUtil.DEFAULT_PORT_SSL);
        com.google.android.libraries.navigation.internal.yx.ar.q(cdVar2);
        bqVar.b = cdVar2;
        com.google.android.libraries.navigation.internal.yx.ar.q(cqVar);
        bqVar.c = cqVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(cnVar);
        bqVar.e = cnVar;
        bqVar.d = ejVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(oVar);
        bqVar.f = oVar;
        bqVar.g = ceVar;
        bqVar.h = dfVar;
        com.google.android.libraries.navigation.internal.afx.br brVar2 = new com.google.android.libraries.navigation.internal.afx.br(bqVar.a, bqVar.b, bqVar.c, bqVar.d, bqVar.e, bqVar.f, bqVar.g, bqVar.h);
        this.M = brVar2;
        this.f334n = i(uri, bzVar, brVar2);
        this.P = new ce(esVar);
        ab abVar = new ab(A, cqVar);
        this.t = abVar;
        abVar.a = new x(cdVar);
        abVar.b = new y(cdVar);
        this.I = aoVar;
        this.C = null;
        this.E = cxVar.v;
        cm cmVar = new cm(this, this.f334n.a());
        this.A = cmVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(cmVar, "channel");
        Iterator it2 = list.iterator();
        com.google.android.libraries.navigation.internal.afx.e hVar2 = cmVar;
        while (it2.hasNext()) {
            hVar2 = new com.google.android.libraries.navigation.internal.afx.h(hVar2, (cu) it2.next());
        }
        this.S = hVar2;
        this.m = new ArrayList(cxVar.h);
        com.google.android.libraries.navigation.internal.yx.ar.r(brVar, "stopwatchSupplier");
        this.k = brVar;
        long j = cxVar.o;
        if (j == -1) {
            this.R = -1L;
        } else {
            com.google.android.libraries.navigation.internal.yx.ar.e(j >= cx.c, "invalid idleTimeoutMillis %s", j);
            this.R = cxVar.o;
        }
        this.Z = new ec(new cg(this), this.j, this.g.c(), new com.google.android.libraries.navigation.internal.yx.bm());
        com.google.android.libraries.navigation.internal.yx.ar.r(cxVar.m, "decompressorRegistry");
        com.google.android.libraries.navigation.internal.yx.ar.r(cxVar.f335n, "compressorRegistry");
        ca caVar = new ca(etVar);
        this.w = caVar;
        caVar.a();
        com.google.android.libraries.navigation.internal.afx.ag agVar = cxVar.u;
        com.google.android.libraries.navigation.internal.yx.ar.q(agVar);
        this.z = agVar;
        com.google.android.libraries.navigation.internal.afx.ag.a(agVar.b, this);
        if (this.E) {
            return;
        }
        this.D = true;
    }

    static com.google.android.libraries.navigation.internal.afx.by i(URI uri, com.google.android.libraries.navigation.internal.afx.bz bzVar, com.google.android.libraries.navigation.internal.afx.br brVar) {
        com.google.android.libraries.navigation.internal.afx.by byVarA = bzVar.a(uri, brVar);
        if (byVarA == null) {
            throw new IllegalArgumentException("cannot create a NameResolver for ".concat(String.valueOf(String.valueOf(uri))));
        }
        ao aoVar = new ao();
        ScheduledExecutorService scheduledExecutorService = brVar.e;
        if (scheduledExecutorService == null) {
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }
        j jVar = new j(aoVar, scheduledExecutorService, brVar.c);
        com.google.android.libraries.navigation.internal.afx.cq cqVar = brVar.c;
        return new ei(byVarA, jVar);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.e
    public final String a() {
        return this.S.a();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.al
    public final com.google.android.libraries.navigation.internal.afx.aj b() {
        return this.f;
    }

    public final void c(boolean z) {
        ScheduledFuture scheduledFuture;
        ec ecVar = this.Z;
        ecVar.e = false;
        if (!z || (scheduledFuture = ecVar.f) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        ecVar.f = null;
    }

    final void d() {
        this.j.d();
        if (this.u.get() || this.q) {
            return;
        }
        if (this.F.a.isEmpty()) {
            f();
        } else {
            c(false);
        }
        if (this.p == null) {
            this.y.a(2, "Exiting idle mode");
            cj cjVar = new cj(this);
            cjVar.a = new c(this.N, cjVar);
            this.p = cjVar;
            this.l.a(com.google.android.libraries.navigation.internal.afx.r.CONNECTING);
            this.f334n.d(new cl(this, cjVar, this.f334n));
            this.o = true;
        }
    }

    public final void e() {
        if (!this.V && this.u.get() && this.r.isEmpty() && this.U.isEmpty()) {
            this.y.a(2, "Terminated");
            com.google.android.libraries.navigation.internal.afx.ag.b(this.z.b, this);
            this.aa.b(this.O);
            this.P.b();
            this.Q.b();
            this.g.close();
            this.V = true;
            this.W.countDown();
        }
    }

    public final void f() {
        long j = this.R;
        if (j == -1) {
            return;
        }
        ec ecVar = this.Z;
        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
        long jA = ecVar.a() + nanos;
        ecVar.e = true;
        if (jA - ecVar.d < 0 || ecVar.f == null) {
            ScheduledFuture scheduledFuture = ecVar.f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ecVar.f = ecVar.a.schedule(new eb(ecVar), nanos, TimeUnit.NANOSECONDS);
        }
        ecVar.d = jA;
    }

    public final void g(boolean z) {
        this.j.d();
        if (z) {
            com.google.android.libraries.navigation.internal.yx.ar.l(this.o, "nameResolver is not started");
            com.google.android.libraries.navigation.internal.yx.ar.l(this.p != null, "lbHelper is null");
        }
        com.google.android.libraries.navigation.internal.afx.by byVar = this.f334n;
        if (byVar != null) {
            byVar.c();
            this.o = false;
            if (z) {
                this.f334n = i(this.K, this.L, this.M);
            } else {
                this.f334n = null;
            }
        }
        cj cjVar = this.p;
        if (cjVar != null) {
            c cVar = cjVar.a;
            cVar.b.e();
            cVar.b = null;
            this.p = null;
        }
        this.T = null;
    }

    public final void h(com.google.android.libraries.navigation.internal.afx.ax axVar) {
        this.T = axVar;
        this.t.d(axVar);
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarD = com.google.android.libraries.navigation.internal.yx.al.b(this).d("logId", this.f.a);
        akVarD.g("target", this.J);
        return akVarD.toString();
    }
}
