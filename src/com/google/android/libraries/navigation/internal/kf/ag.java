package com.google.android.libraries.navigation.internal.kf;

import android.accounts.Account;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yx.bx;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.zp.bk;
import com.google.android.libraries.navigation.internal.zp.cd;
import com.google.android.libraries.navigation.internal.zr.cg;
import com.google.android.libraries.navigation.internal.zr.eh;
import com.google.android.libraries.navigation.internal.zr.ei;
import com.google.android.libraries.navigation.internal.zr.ej;
import com.google.android.libraries.navigation.internal.zr.ek;
import com.google.android.libraries.navigation.internal.zr.fa;
import com.google.android.libraries.navigation.internal.zt.as;
import j$.time.Duration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements com.google.android.libraries.navigation.internal.jy.af, com.google.android.libraries.navigation.internal.hp.e {
    private static final com.google.android.libraries.navigation.internal.zb.j i = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.kf.ag");
    private int B;
    private final com.google.android.libraries.navigation.internal.fq.k C;
    private final g G;
    private final com.google.android.libraries.navigation.internal.afo.a H;
    private final com.google.android.libraries.navigation.internal.afo.a I;
    private final com.google.android.libraries.navigation.internal.jw.f J;
    private final com.google.android.libraries.navigation.internal.au.c K;
    private com.google.android.libraries.navigation.internal.afd.a L;
    public final br a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final f e;
    private final com.google.android.libraries.navigation.internal.ia.e j;
    private final com.google.android.libraries.navigation.internal.iu.b k;
    private final bn l;
    private final com.google.android.libraries.navigation.internal.kq.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.jw.b f461n;
    private final com.google.android.libraries.navigation.internal.afo.a o;
    private final com.google.android.libraries.navigation.internal.agl.a p;
    private final com.google.android.libraries.navigation.internal.kh.z q;
    private final Executor r;
    private final Executor s;
    private String z;
    private final af t = new af(this);
    private final List u = new ArrayList();
    private final List v = new ArrayList();
    public final List f = new ArrayList();
    public final List g = new ArrayList();
    private final h w = new h();
    private final Object x = new Object();
    private final Set y = new LinkedHashSet();
    private int A = -1;
    public volatile com.google.android.libraries.navigation.internal.hj.i h = com.google.android.libraries.navigation.internal.hj.c.b;
    private final com.google.android.libraries.navigation.internal.nt.t D = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.kf.ab
        @Override // com.google.android.libraries.navigation.internal.nt.t
        public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
            com.google.android.libraries.navigation.internal.hj.i iVarA = com.google.android.libraries.navigation.internal.hj.j.a((Account) mVar.c());
            ag agVar = this.a;
            if (iVarA.equals(agVar.h)) {
                return;
            }
            ar.k(!iVarA.an());
            com.google.android.libraries.navigation.internal.hj.i iVar = agVar.h;
            agVar.h = iVarA;
            boolean zB = iVarA.b();
            boolean zAn = iVar.an();
            boolean zB2 = iVar.b();
            if (!zAn && !zB2) {
                if (zB) {
                    agVar.q(iVar, iVar, true, true, com.google.android.libraries.navigation.internal.zp.n.CS, com.google.android.libraries.navigation.internal.yx.a.a);
                    return;
                } else {
                    agVar.q(iVar, iVar, true, true, com.google.android.libraries.navigation.internal.zp.n.CT, com.google.android.libraries.navigation.internal.yx.a.a);
                    return;
                }
            }
            if (zB2) {
                agVar.q(com.google.android.libraries.navigation.internal.hj.c.a, iVarA, true, true, com.google.android.libraries.navigation.internal.zp.n.CR, com.google.android.libraries.navigation.internal.yx.a.a);
                return;
            }
            ar.k(zAn);
            if (zB) {
                agVar.q(com.google.android.libraries.navigation.internal.hj.c.a, com.google.android.libraries.navigation.internal.hj.c.b, true, false, null, com.google.android.libraries.navigation.internal.yx.a.a);
            } else if (iVarA.f()) {
                agVar.q(iVarA, com.google.android.libraries.navigation.internal.hj.c.b, false, false, null, com.google.android.libraries.navigation.internal.yx.a.a);
            } else {
                ((com.google.android.libraries.navigation.internal.di.b) agVar.d.a()).g();
                agVar.q(com.google.android.libraries.navigation.internal.hj.c.a, iVarA, true, true, com.google.android.libraries.navigation.internal.zp.n.CQ, an.j(fa.SIGNED_OUT_AS_UNKNOWN));
            }
        }
    };
    private final ConcurrentLinkedQueue E = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue F = new ConcurrentLinkedQueue();

    public ag(com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, final com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, bn bnVar, an anVar, com.google.android.libraries.navigation.internal.iu.b bVar, com.google.android.libraries.navigation.internal.jw.b bVar2, com.google.android.libraries.navigation.internal.afo.a aVar5, final com.google.android.libraries.navigation.internal.gv.d dVar, com.google.android.libraries.navigation.internal.jw.f fVar2, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.kh.z zVar, com.google.android.libraries.navigation.internal.afo.a aVar7, com.google.android.libraries.navigation.internal.au.c cVar, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.afo.a aVar8) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapEnvironmentImpl - createUserEvent3Reporter");
        try {
            this.l = bnVar;
            this.d = aVar3;
            this.b = aVar;
            this.j = eVar;
            this.c = aVar4;
            this.k = bVar;
            this.m = (com.google.android.libraries.navigation.internal.kq.a) anVar.f();
            this.f461n = bVar2;
            this.o = aVar5;
            this.J = fVar2;
            this.p = aVar6;
            this.q = zVar;
            this.G = new g();
            this.H = aVar7;
            this.e = new f();
            this.K = cVar;
            this.r = executor;
            this.s = executor2;
            this.I = aVar8;
            this.C = new com.google.android.libraries.navigation.internal.fq.k(20, com.google.android.libraries.navigation.internal.fq.h.PREFETCH_UPGRADES, fVar);
            this.a = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.kf.ac
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    v vVar = new v(((com.google.android.libraries.navigation.internal.iv.f) aVar2.a()).c(), dVar, this.a.e);
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl() - read shared preferences");
                    try {
                        vVar.d.set(vVar.a.getInt("activationId", 1));
                        vVar.e.set(vVar.a.getInt("sequenceId", (int) (Math.random() * 1.073741824E9d)));
                        vVar.g = vVar.a.getString("previousClientEventId", null);
                        vVar.h = vVar.a.getString("baseEventId", v.a());
                        if (com.google.android.libraries.navigation.internal.kb.a.b(vVar.h) == null) {
                            vVar.h = v.a();
                        }
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl() - debug setup");
                        try {
                            vVar.f.clear();
                            com.google.android.libraries.navigation.internal.gv.d dVar2 = vVar.b;
                            if (dVar2 != null) {
                                String name = vVar.getClass().getName();
                                Objects.requireNonNull(vVar.c);
                                dVar2.a.put(name, new com.google.android.libraries.navigation.internal.gv.a());
                            }
                            if (dVarB3 != null) {
                                Trace.endSection();
                            }
                            return vVar;
                        } catch (Throwable th) {
                            if (dVarB3 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (dVarB2 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                }
            });
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB == null) {
                throw th;
            }
            try {
                Trace.endSection();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d A[Catch: all -> 0x008a, TryCatch #2 {all -> 0x008a, blocks: (B:4:0x0008, B:6:0x0012, B:7:0x0016, B:9:0x0026, B:11:0x0044, B:12:0x004d, B:18:0x0065, B:24:0x0089, B:10:0x002d, B:13:0x004e, B:14:0x0054, B:16:0x005a, B:17:0x0064), top: B:36:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x005a A[Catch: all -> 0x0087, LOOP:0: B:14:0x0054->B:16:0x005a, LOOP_END, TryCatch #1 {, blocks: (B:13:0x004e, B:14:0x0054, B:16:0x005a, B:17:0x0064), top: B:34:0x004e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016 A[Catch: all -> 0x008a, TryCatch #2 {all -> 0x008a, blocks: (B:4:0x0008, B:6:0x0012, B:7:0x0016, B:9:0x0026, B:11:0x0044, B:12:0x004d, B:18:0x0065, B:24:0x0089, B:10:0x002d, B:13:0x004e, B:14:0x0054, B:16:0x005a, B:17:0x0064), top: B:36:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0026 A[Catch: all -> 0x008a, TryCatch #2 {all -> 0x008a, blocks: (B:4:0x0008, B:6:0x0012, B:7:0x0016, B:9:0x0026, B:11:0x0044, B:12:0x004d, B:18:0x0065, B:24:0x0089, B:10:0x002d, B:13:0x004e, B:14:0x0054, B:16:0x005a, B:17:0x0064), top: B:36:0x0008, inners: #1 }] */
    private final com.google.android.libraries.navigation.internal.jy.p s(final com.google.android.libraries.navigation.internal.jy.o oVar, final com.google.android.libraries.navigation.internal.jy.v vVar, final com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        com.google.android.libraries.navigation.internal.jy.p pVarB;
        com.google.android.libraries.navigation.internal.afd.a aVar;
        Iterator it2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.logUiInteractionInternal");
        if (oVar == null) {
            try {
                if (as.AUTOMATED.equals(vVar.a)) {
                    ar.q(aaVar);
                    ar.o(aaVar.j(), "Invalid UE3 params: %s", aaVar);
                    aVar = aaVar.k;
                    if (aVar != null) {
                        ar.o(true, "logUiInteraction is called with Request Type: %s. Use logRequest instead.", aVar);
                    } else {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(765)).p("Attempted to log interaction without VE type.");
                    }
                    final w wVarX = x(this.h, null);
                    synchronized (this.v) {
                        it2 = this.v.iterator();
                        while (it2.hasNext()) {
                            ((com.google.android.libraries.navigation.internal.jy.ad) it2.next()).a();
                        }
                    }
                    this.r.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.aa
                        @Override // java.lang.Runnable
                        public final void run() {
                            ag agVar = this.a;
                            com.google.android.libraries.navigation.internal.jy.v vVar2 = vVar;
                            com.google.android.libraries.navigation.internal.jy.aa aaVar2 = aaVar;
                            w wVar = wVarX;
                            try {
                                if (!as.AUTOMATED.equals(vVar2.a)) {
                                    ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.b) agVar.c.a()).a(com.google.android.libraries.navigation.internal.km.e.a)).a();
                                }
                                com.google.android.libraries.navigation.internal.afd.a aVar2 = aaVar2.k;
                                if (aVar2 != null) {
                                    f fVar = agVar.e;
                                    int iA = aVar2.a();
                                    long epochMilli = agVar.b.f().toEpochMilli();
                                    synchronized (fVar.a) {
                                        fVar.a.add(new a(iA, epochMilli));
                                    }
                                }
                                com.google.android.libraries.navigation.internal.jy.o oVar2 = oVar;
                                com.google.android.libraries.navigation.internal.jy.m mVar = oVar2 != null ? oVar2.b : null;
                                com.google.android.libraries.navigation.internal.ke.q qVar = new com.google.android.libraries.navigation.internal.ke.q();
                                qVar.a = vVar2;
                                qVar.h = ((b) wVar).f;
                                qVar.b = aaVar2.i();
                                com.google.android.libraries.navigation.internal.zy.n nVar = aaVar2.h;
                                qVar.f = null;
                                boolean z = aaVar2.i;
                                qVar.g = false;
                                qVar.b(aaVar2.e());
                                if (mVar != null) {
                                    com.google.android.libraries.navigation.internal.zt.a aVar3 = (com.google.android.libraries.navigation.internal.zt.a) com.google.android.libraries.navigation.internal.zt.b.a.q();
                                    com.google.android.libraries.navigation.internal.zt.d dVarC = mVar.b().c();
                                    if (dVarC != null) {
                                        if (!aVar3.b.H()) {
                                            aVar3.v();
                                        }
                                        com.google.android.libraries.navigation.internal.zt.b bVar = (com.google.android.libraries.navigation.internal.zt.b) aVar3.b;
                                        bVar.j = dVarC;
                                        bVar.b |= 2048;
                                    }
                                    cd cdVarB = mVar.a().b();
                                    if (!aVar3.b.H()) {
                                        aVar3.v();
                                    }
                                    com.google.android.libraries.navigation.internal.zt.b bVar2 = (com.google.android.libraries.navigation.internal.zt.b) aVar3.b;
                                    cdVarB.getClass();
                                    bVar2.d = cdVarB;
                                    bVar2.b |= 4;
                                    if (mVar.c().g()) {
                                        int iIntValue = ((Integer) mVar.c().c()).intValue();
                                        if (!aVar3.b.H()) {
                                            aVar3.v();
                                        }
                                        com.google.android.libraries.navigation.internal.zt.b bVar3 = (com.google.android.libraries.navigation.internal.zt.b) aVar3.b;
                                        bVar3.b |= 8;
                                        bVar3.e = iIntValue;
                                    }
                                    com.google.android.libraries.navigation.internal.zt.b bVar4 = (com.google.android.libraries.navigation.internal.zt.b) aVar3.t();
                                    int i2 = bVar4.b & 4;
                                    String str = ExifInterface.GPS_MEASUREMENT_2D;
                                    if (i2 == 0) {
                                        str = "0";
                                    }
                                    qVar.d = str.concat(String.valueOf(com.google.android.libraries.navigation.internal.zn.g.e.f().i(bVar4.m())));
                                } else {
                                    qVar.d = aaVar2.d;
                                    qVar.e = aaVar2.k;
                                    if (!aaVar2.e) {
                                        qVar.c = aaVar2.f;
                                    }
                                }
                                agVar.p(qVar.a(), wVar);
                                synchronized (agVar.f) {
                                    Iterator it3 = agVar.f.iterator();
                                    while (it3.hasNext()) {
                                        ((com.google.android.libraries.navigation.internal.jy.ac) it3.next()).a();
                                    }
                                }
                            } catch (Throwable th) {
                                agVar.r(th, "Failed to log interaction");
                            }
                        }
                    });
                    pVarB = com.google.android.libraries.navigation.internal.jy.p.b(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, ((b) wVarX).c, aaVar.k);
                } else {
                    pVarB = com.google.android.libraries.navigation.internal.jy.p.a;
                }
            } catch (Throwable th) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            ar.q(aaVar);
            ar.o(aaVar.j(), "Invalid UE3 params: %s", aaVar);
            aVar = aaVar.k;
            if (aVar != null) {
                ar.o(true, "logUiInteraction is called with Request Type: %s. Use logRequest instead.", aVar);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(765)).p("Attempted to log interaction without VE type.");
            }
            final w wVarX2 = x(this.h, null);
            synchronized (this.v) {
                it2 = this.v.iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.jy.ad) it2.next()).a();
                }
                this.r.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        ag agVar = this.a;
                        com.google.android.libraries.navigation.internal.jy.v vVar2 = vVar;
                        com.google.android.libraries.navigation.internal.jy.aa aaVar2 = aaVar;
                        w wVar = wVarX2;
                        try {
                            if (!as.AUTOMATED.equals(vVar2.a)) {
                                ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.b) agVar.c.a()).a(com.google.android.libraries.navigation.internal.km.e.a)).a();
                            }
                            com.google.android.libraries.navigation.internal.afd.a aVar2 = aaVar2.k;
                            if (aVar2 != null) {
                                f fVar = agVar.e;
                                int iA = aVar2.a();
                                long epochMilli = agVar.b.f().toEpochMilli();
                                synchronized (fVar.a) {
                                    fVar.a.add(new a(iA, epochMilli));
                                }
                            }
                            com.google.android.libraries.navigation.internal.jy.o oVar2 = oVar;
                            com.google.android.libraries.navigation.internal.jy.m mVar = oVar2 != null ? oVar2.b : null;
                            com.google.android.libraries.navigation.internal.ke.q qVar = new com.google.android.libraries.navigation.internal.ke.q();
                            qVar.a = vVar2;
                            qVar.h = ((b) wVar).f;
                            qVar.b = aaVar2.i();
                            com.google.android.libraries.navigation.internal.zy.n nVar = aaVar2.h;
                            qVar.f = null;
                            boolean z = aaVar2.i;
                            qVar.g = false;
                            qVar.b(aaVar2.e());
                            if (mVar != null) {
                                com.google.android.libraries.navigation.internal.zt.a aVar3 = (com.google.android.libraries.navigation.internal.zt.a) com.google.android.libraries.navigation.internal.zt.b.a.q();
                                com.google.android.libraries.navigation.internal.zt.d dVarC = mVar.b().c();
                                if (dVarC != null) {
                                    if (!aVar3.b.H()) {
                                        aVar3.v();
                                    }
                                    com.google.android.libraries.navigation.internal.zt.b bVar = (com.google.android.libraries.navigation.internal.zt.b) aVar3.b;
                                    bVar.j = dVarC;
                                    bVar.b |= 2048;
                                }
                                cd cdVarB = mVar.a().b();
                                if (!aVar3.b.H()) {
                                    aVar3.v();
                                }
                                com.google.android.libraries.navigation.internal.zt.b bVar2 = (com.google.android.libraries.navigation.internal.zt.b) aVar3.b;
                                cdVarB.getClass();
                                bVar2.d = cdVarB;
                                bVar2.b |= 4;
                                if (mVar.c().g()) {
                                    int iIntValue = ((Integer) mVar.c().c()).intValue();
                                    if (!aVar3.b.H()) {
                                        aVar3.v();
                                    }
                                    com.google.android.libraries.navigation.internal.zt.b bVar3 = (com.google.android.libraries.navigation.internal.zt.b) aVar3.b;
                                    bVar3.b |= 8;
                                    bVar3.e = iIntValue;
                                }
                                com.google.android.libraries.navigation.internal.zt.b bVar4 = (com.google.android.libraries.navigation.internal.zt.b) aVar3.t();
                                int i2 = bVar4.b & 4;
                                String str = ExifInterface.GPS_MEASUREMENT_2D;
                                if (i2 == 0) {
                                    str = "0";
                                }
                                qVar.d = str.concat(String.valueOf(com.google.android.libraries.navigation.internal.zn.g.e.f().i(bVar4.m())));
                            } else {
                                qVar.d = aaVar2.d;
                                qVar.e = aaVar2.k;
                                if (!aaVar2.e) {
                                    qVar.c = aaVar2.f;
                                }
                            }
                            agVar.p(qVar.a(), wVar);
                            synchronized (agVar.f) {
                                Iterator it3 = agVar.f.iterator();
                                while (it3.hasNext()) {
                                    ((com.google.android.libraries.navigation.internal.jy.ac) it3.next()).a();
                                }
                            }
                        } catch (Throwable th3) {
                            agVar.r(th3, "Failed to log interaction");
                        }
                    }
                });
                pVarB = com.google.android.libraries.navigation.internal.jy.p.b(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, ((b) wVarX2).c, aaVar.k);
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
        return pVarB;
    }

    private final void t(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.zp.n nVar) {
        com.google.android.libraries.navigation.internal.kd.d dVar = new com.google.android.libraries.navigation.internal.kd.d();
        dVar.b(nVar);
        y(iVar, dVar.a());
    }

    private final void u(boolean z) {
        w();
        if (z) {
            com.google.android.libraries.navigation.internal.nk.p pVar = ((com.google.android.libraries.navigation.internal.nk.s) this.o.a()).a().e;
            if (pVar == null) {
                pVar = com.google.android.libraries.navigation.internal.nk.p.a;
            }
            com.google.android.libraries.navigation.internal.nk.m mVarB = com.google.android.libraries.navigation.internal.nk.m.b(pVar.i);
            if (mVarB == null) {
                mVarB = com.google.android.libraries.navigation.internal.nk.m.UNKNOWN_UE3_REPORTER_FLUSH_STRATEGY;
            }
            if (mVarB.ordinal() == 3) {
                Executor executor = this.r;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(2500L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 773)).p("Waiting for logging queue interrupted");
                }
            }
        }
        this.q.d();
    }

    private final void v(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar) {
        this.q.a(iVar, cVar);
    }

    private final void w() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.flushImpressionsInternal");
        try {
            synchronized (this.x) {
                com.google.android.libraries.navigation.internal.nk.p pVar = ((com.google.android.libraries.navigation.internal.nk.s) this.o.a()).a().e;
                if (pVar == null) {
                    pVar = com.google.android.libraries.navigation.internal.nk.p.a;
                }
                boolean z = pVar.j;
                com.google.android.libraries.navigation.internal.afd.a aVar = this.L;
                if (aVar != null) {
                    com.google.android.libraries.navigation.internal.jy.aa.k(aVar);
                }
                this.z = null;
                this.A = -1;
            }
            Iterator it2 = this.E.iterator();
            while (it2.hasNext()) {
                if (((p) ((WeakReference) it2.next()).get()) != null) {
                    p.a();
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:3:0x0006, B:5:0x0011, B:7:0x0017, B:9:0x001b, B:11:0x0024, B:12:0x0029, B:14:0x0039, B:15:0x0045, B:16:0x0054, B:19:0x0058, B:21:0x005e, B:23:0x0063, B:24:0x0065, B:25:0x006f, B:36:0x009c, B:41:0x00aa, B:27:0x0072, B:32:0x0085, B:34:0x008c, B:35:0x009b), top: B:51:0x0006, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0039 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:3:0x0006, B:5:0x0011, B:7:0x0017, B:9:0x001b, B:11:0x0024, B:12:0x0029, B:14:0x0039, B:15:0x0045, B:16:0x0054, B:19:0x0058, B:21:0x005e, B:23:0x0063, B:24:0x0065, B:25:0x006f, B:36:0x009c, B:41:0x00aa, B:27:0x0072, B:32:0x0085, B:34:0x008c, B:35:0x009b), top: B:51:0x0006, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0045 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:3:0x0006, B:5:0x0011, B:7:0x0017, B:9:0x001b, B:11:0x0024, B:12:0x0029, B:14:0x0039, B:15:0x0045, B:16:0x0054, B:19:0x0058, B:21:0x005e, B:23:0x0063, B:24:0x0065, B:25:0x006f, B:36:0x009c, B:41:0x00aa, B:27:0x0072, B:32:0x0085, B:34:0x008c, B:35:0x009b), top: B:51:0x0006, inners: #2 }] */
    private final w x(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar) {
        String strC;
        String str;
        int i2;
        String str2;
        com.google.android.libraries.navigation.internal.jy.j jVar;
        al alVarD;
        List listI;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.issueUe3EventBaseParams");
        try {
            Integer numA = this.w.a();
            int andIncrement = 0;
            String str3 = null;
            if (cVar != null) {
                strC = cVar.f();
                if (strC != null) {
                    if (cVar instanceof com.google.android.libraries.navigation.internal.ke.g) {
                        com.google.android.libraries.navigation.internal.ke.g gVar = (com.google.android.libraries.navigation.internal.ke.g) cVar;
                        if (gVar.o()) {
                            andIncrement = gVar.n();
                        } else {
                            listI = bj.b(':').i(strC);
                            if (listI.size() <= 2) {
                                throw new IllegalArgumentException(String.format("%s is incorrectly formatted. It should be formatted as \"message:id\", where \"message\" is a server-generated event ID and \"id\" is the decimal expression of the sequenceId.", strC));
                            }
                            andIncrement = Integer.parseInt((String) listI.get(1));
                        }
                    } else {
                        listI = bj.b(':').i(strC);
                        if (listI.size() <= 2) {
                            throw new IllegalArgumentException(String.format("%s is incorrectly formatted. It should be formatted as \"message:id\", where \"message\" is a server-generated event ID and \"id\" is the decimal expression of the sequenceId.", strC));
                        }
                        andIncrement = Integer.parseInt((String) listI.get(1));
                    }
                }
            } else {
                strC = null;
            }
            if (cVar != null && (alVarD = cVar.d()) != null && (2 & alVarD.b) != 0) {
                str3 = alVarD.d;
            }
            v vVar = (v) this.a.a();
            synchronized (this.a) {
                if (strC == null) {
                    try {
                        andIncrement = vVar.e.getAndIncrement();
                        strC = com.google.android.libraries.navigation.internal.kb.a.c(vVar.h, andIncrement);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                str = strC;
                i2 = andIncrement;
                if (str3 == null) {
                    String str4 = vVar.g;
                    vVar.g = str;
                    str2 = str4;
                } else {
                    str2 = str3;
                }
                jVar = new com.google.android.libraries.navigation.internal.jy.j(Duration.ofMillis(this.b.a()));
            }
            b bVar = new b(iVar, i2, str, str2, numA, jVar);
            if (dVarB != null) {
                Trace.endSection();
            }
            return bVar;
        } catch (Throwable th2) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    private final com.google.android.libraries.navigation.internal.jy.q y(com.google.android.libraries.navigation.internal.hj.i iVar, final com.google.android.libraries.navigation.internal.kd.l lVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.logRequestInternal");
        try {
            final w wVarX = x(iVar, null);
            this.r.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ag agVar = this.a;
                    w wVar = wVarX;
                    com.google.android.libraries.navigation.internal.kd.l lVar2 = lVar;
                    try {
                        com.google.android.libraries.navigation.internal.ke.q qVar = new com.google.android.libraries.navigation.internal.ke.q();
                        qVar.a = new com.google.android.libraries.navigation.internal.jy.v(as.AUTOMATED);
                        qVar.h = ((b) wVar).f;
                        qVar.e = ((com.google.android.libraries.navigation.internal.kd.e) lVar2).a;
                        com.google.android.libraries.navigation.internal.zp.bj bjVar = (com.google.android.libraries.navigation.internal.zp.bj) bk.a.q();
                        cg cgVar = ((com.google.android.libraries.navigation.internal.kd.e) lVar2).b;
                        if (cgVar != null) {
                            if (!bjVar.b.H()) {
                                bjVar.v();
                            }
                            bk bkVar = (bk) bjVar.b;
                            bkVar.e = cgVar;
                            bkVar.b |= 1024;
                            qVar.b((bk) bjVar.t());
                        }
                        com.google.android.libraries.navigation.internal.ke.r rVarA = qVar.a();
                        com.google.android.libraries.navigation.internal.adq.ak akVar = (com.google.android.libraries.navigation.internal.adq.ak) al.a.q();
                        int i2 = ((com.google.android.libraries.navigation.internal.zp.n) ((com.google.android.libraries.navigation.internal.kd.e) lVar2).a).a;
                        if (!akVar.b.H()) {
                            akVar.v();
                        }
                        al alVar = (al) akVar.b;
                        alVar.b |= 64;
                        alVar.e = i2;
                        rVarA.i((al) akVar.t());
                        agVar.p(rVarA, wVar);
                        synchronized (agVar.g) {
                            Iterator it2 = agVar.g.iterator();
                            while (it2.hasNext()) {
                                ((com.google.android.libraries.navigation.internal.jy.ae) it2.next()).a();
                            }
                        }
                    } catch (Throwable th) {
                        agVar.r(th, "Failed to log request");
                    }
                }
            });
            com.google.android.libraries.navigation.internal.jy.q qVarB = com.google.android.libraries.navigation.internal.jy.q.b(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, ((b) wVarX).c);
            if (dVarB != null) {
                Trace.endSection();
            }
            return qVarB;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hp.e
    public final void a(com.google.android.libraries.navigation.internal.zy.e eVar) {
        g gVar = this.G;
        synchronized (gVar) {
            for (int i2 = 0; i2 < eVar.b(); i2++) {
                gVar.a.add(Integer.valueOf(eVar.a(i2)));
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final int b(com.google.android.libraries.navigation.internal.jx.a aVar) {
        ar.q(aVar);
        return ((v) this.a.a()).e.getAndIncrement();
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final com.google.android.libraries.navigation.internal.jy.p c(com.google.android.libraries.navigation.internal.jy.o oVar, com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        return s(oVar, new com.google.android.libraries.navigation.internal.jy.v(as.TAP), aaVar);
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final com.google.android.libraries.navigation.internal.jy.p d(com.google.android.libraries.navigation.internal.jy.o oVar, com.google.android.libraries.navigation.internal.jy.v vVar, com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        return s(oVar, vVar, aaVar);
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final com.google.android.libraries.navigation.internal.kb.c e(final com.google.android.libraries.navigation.internal.ke.c cVar) {
        com.google.android.libraries.navigation.internal.hj.i iVar = this.h;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.logInternal");
        try {
            final w wVarX = x(iVar, cVar);
            this.r.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.y
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.a.p(cVar, wVarX);
                    } catch (Throwable unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 766)).p("Failed to log event");
                    }
                }
            });
            com.google.android.libraries.navigation.internal.kb.c cVar2 = (com.google.android.libraries.navigation.internal.kb.c) com.google.android.libraries.navigation.internal.kb.c.b(((b) wVarX).c).c();
            if (dVarB != null) {
                Trace.endSection();
            }
            return cVar2;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final com.google.android.libraries.navigation.internal.kb.c f(com.google.android.libraries.navigation.internal.jy.w wVar) {
        com.google.android.libraries.navigation.internal.afd.a aVarA = wVar.a();
        ar.q(aVarA);
        com.google.android.libraries.navigation.internal.kd.a aVar = (com.google.android.libraries.navigation.internal.kd.a) wVar;
        if (aVar.c == null) {
            int andIncrement = ((v) this.a.a()).d.getAndIncrement();
            Integer.valueOf(andIncrement).getClass();
            aVar.c = Integer.valueOf(andIncrement);
        }
        com.google.android.libraries.navigation.internal.kb.c cVarE = e(new com.google.android.libraries.navigation.internal.ke.m(wVar, this.b));
        com.google.android.libraries.navigation.internal.kq.a aVar2 = this.m;
        if (aVar2 != null) {
            aVarA.a();
            aVar2.a();
        }
        if (!com.google.android.libraries.navigation.internal.jy.w.a.contains(wVar.a())) {
            synchronized (this.x) {
                if (!am.a(this.L, aVarA)) {
                    if (this.L != null) {
                        this.y.clear();
                    }
                    this.L = aVarA;
                }
                if (this.z == null) {
                    v vVar = (v) this.a.a();
                    int andIncrement2 = vVar.e.getAndIncrement();
                    this.A = andIncrement2;
                    this.z = com.google.android.libraries.navigation.internal.kb.a.c(vVar.h, andIncrement2);
                    this.b.a();
                }
            }
            f fVar = this.e;
            int iA = aVarA.a();
            long epochMilli = this.b.f().toEpochMilli();
            synchronized (fVar.b) {
                fVar.b.add(new a(iA, epochMilli));
            }
        }
        return cVarE;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final String g() {
        v vVar = (v) this.a.a();
        return com.google.android.libraries.navigation.internal.kb.a.c(vVar.h, vVar.e.getAndIncrement());
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void h(com.google.android.libraries.navigation.internal.jx.a aVar, com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        ar.q(aVar);
        synchronized (this.x) {
            this.y.add(aaVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void i(com.google.android.libraries.navigation.internal.jx.a aVar, com.google.android.libraries.navigation.internal.jy.aa aaVar, int i2) {
        ar.q(aVar);
        synchronized (this.u) {
            Iterator it2 = this.u.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.jy.ab) it2.next()).a();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void j(com.google.android.libraries.navigation.internal.kd.i iVar) {
        String str = e(new com.google.android.libraries.navigation.internal.ke.k(this.b, iVar)).a;
        ar.k(iVar.c == null);
        iVar.c = str;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void k() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        if (this.B == 0) {
            com.google.android.libraries.navigation.internal.ia.e eVar = this.j;
            af afVar = this.t;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.jy.u.class, new ah(com.google.android.libraries.navigation.internal.jy.u.class, afVar, ap.DANGEROUS_PUBLISHER_THREAD));
            eVar.c(afVar, fzVar.a());
            ((com.google.android.libraries.navigation.internal.di.b) this.d.a()).e().e(this.D, this.l);
            this.q.c();
        }
        this.B++;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void l() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        int i2 = this.B;
        if (i2 <= 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) i.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalStateException(String.format("startCount value is %s, and it should not be negative. Make sure you have started the UE3 reporter first before stopping it.", Integer.valueOf(i2))))).F((char) 771)).o();
            return;
        }
        int i3 = i2 - 1;
        this.B = i3;
        if (i3 == 0) {
            com.google.android.libraries.navigation.internal.ke.g gVar = new com.google.android.libraries.navigation.internal.ke.g(this.b.a());
            p(gVar, x(this.h, gVar));
            this.j.e(this.t);
            ((com.google.android.libraries.navigation.internal.di.b) this.d.a()).e().h(this.D);
            u(true);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void m(hv hvVar, String str) {
        if (this.C.e(str) != null) {
            return;
        }
        this.C.m(str, hvVar);
        com.google.android.libraries.navigation.internal.ke.n nVar = new com.google.android.libraries.navigation.internal.ke.n(hvVar, str, this.b);
        nVar.i(null);
        e(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void n(com.google.android.libraries.navigation.internal.kd.l lVar) {
        y(this.h, lVar);
    }

    @Override // com.google.android.libraries.navigation.internal.jy.af
    public final void o(Throwable th) {
        com.google.android.libraries.navigation.internal.zr.f fVar = (com.google.android.libraries.navigation.internal.zr.f) com.google.android.libraries.navigation.internal.zr.g.a.q();
        String name = th.getClass().getName();
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.g gVar = (com.google.android.libraries.navigation.internal.zr.g) fVar.b;
        name.getClass();
        gVar.b |= 1;
        gVar.c = name;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.g gVar2 = (com.google.android.libraries.navigation.internal.zr.g) fVar.b;
        gVar2.b |= 4;
        gVar2.e = true;
        com.google.android.libraries.navigation.internal.nk.v vVar = ((com.google.android.libraries.navigation.internal.nk.s) this.o.a()).a().f;
        if (vVar == null) {
            vVar = com.google.android.libraries.navigation.internal.nk.v.a;
        }
        if (vVar.k) {
            ej ejVar = (ej) ek.a.q();
            eh ehVarA = com.google.android.libraries.navigation.internal.kk.p.a(th);
            if (!ejVar.b.H()) {
                ejVar.v();
            }
            ek ekVar = (ek) ejVar.b;
            ei eiVar = (ei) ehVarA.t();
            eiVar.getClass();
            ekVar.c = eiVar;
            ekVar.b |= 1;
            while (th != null) {
                th = th.getCause();
                if (th != null) {
                    eh ehVarA2 = com.google.android.libraries.navigation.internal.kk.p.a(th);
                    if (!ejVar.b.H()) {
                        ejVar.v();
                    }
                    ek ekVar2 = (ek) ejVar.b;
                    ei eiVar2 = (ei) ehVarA2.t();
                    eiVar2.getClass();
                    bz bzVar = ekVar2.d;
                    if (!bzVar.c()) {
                        ekVar2.d = bi.A(bzVar);
                    }
                    ekVar2.d.add(eiVar2);
                }
            }
            if (!fVar.b.H()) {
                fVar.v();
            }
            com.google.android.libraries.navigation.internal.zr.g gVar3 = (com.google.android.libraries.navigation.internal.zr.g) fVar.b;
            ek ekVar3 = (ek) ejVar.t();
            ekVar3.getClass();
            gVar3.f = ekVar3;
            gVar3.b |= 8;
        }
        try {
            boolean zA = this.k.a();
            if (!fVar.b.H()) {
                fVar.v();
            }
            com.google.android.libraries.navigation.internal.zr.g gVar4 = (com.google.android.libraries.navigation.internal.zr.g) fVar.b;
            gVar4.b |= 2;
            gVar4.d = zA;
        } catch (com.google.android.libraries.navigation.internal.iu.a unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 770)).p("Unable to determine if app is in foreground");
        }
        com.google.android.libraries.navigation.internal.zr.e eVar = (com.google.android.libraries.navigation.internal.zr.e) com.google.android.libraries.navigation.internal.zr.i.a.q();
        com.google.android.libraries.navigation.internal.afl.l lVar = com.google.android.libraries.navigation.internal.afl.l.APP_CRASHED;
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.i iVar = (com.google.android.libraries.navigation.internal.zr.i) eVar.b;
        iVar.c = lVar.M;
        iVar.b |= 1;
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.i iVar2 = (com.google.android.libraries.navigation.internal.zr.i) eVar.b;
        com.google.android.libraries.navigation.internal.zr.g gVar5 = (com.google.android.libraries.navigation.internal.zr.g) fVar.t();
        gVar5.getClass();
        iVar2.d = gVar5;
        iVar2.b |= 128;
        com.google.android.libraries.navigation.internal.ke.a aVar = new com.google.android.libraries.navigation.internal.ke.a(this.b, (com.google.android.libraries.navigation.internal.zr.i) eVar.t());
        p(aVar, x(this.h, aVar));
        u(false);
    }

    public final void p(com.google.android.libraries.navigation.internal.ke.c cVar, w wVar) {
        String str;
        com.google.android.libraries.navigation.internal.zy.e eVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.logImmediately");
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("UserEvent3ReporterAsyncImpl.processEventForSending");
            try {
                if (((b) wVar).a.f()) {
                    cVar.g();
                }
                Integer num = ((b) wVar).e;
                if (num != null) {
                    cVar.m(num.intValue());
                }
                cVar.h(((b) wVar).c);
                al alVarD = cVar.d();
                if (alVarD == null) {
                    alVarD = al.a;
                }
                int i2 = alVarD.b;
                if ((i2 & 1) == 0 || ((i2 & 2) == 0 && ((b) wVar).d != null)) {
                    bb bbVar = (bb) alVarD.aH(5, null);
                    bbVar.x(alVarD);
                    com.google.android.libraries.navigation.internal.adq.ak akVar = (com.google.android.libraries.navigation.internal.adq.ak) bbVar;
                    if ((alVarD.b & 1) == 0) {
                        String str2 = ((b) wVar).c;
                        if (!akVar.b.H()) {
                            akVar.v();
                        }
                        al alVar = (al) akVar.b;
                        alVar.b |= 1;
                        alVar.c = str2;
                    }
                    if ((alVarD.b & 2) == 0 && (str = ((b) wVar).d) != null) {
                        if (!akVar.b.H()) {
                            akVar.v();
                        }
                        al alVar2 = (al) akVar.b;
                        alVar2.b |= 2;
                        alVar2.d = str;
                    }
                    alVarD = (al) akVar.t();
                }
                if (cVar instanceof com.google.android.libraries.navigation.internal.ke.g) {
                    final com.google.android.libraries.navigation.internal.ke.g gVar = (com.google.android.libraries.navigation.internal.ke.g) cVar;
                    gVar.u(((b) wVar).b);
                    gVar.p((com.google.android.libraries.navigation.internal.zp.d) this.p.a());
                    an anVarA = com.google.android.libraries.navigation.internal.au.c.a();
                    Objects.requireNonNull(gVar);
                    com.google.android.libraries.navigation.internal.gz.g.a(anVarA, new Consumer() { // from class: com.google.android.libraries.navigation.internal.kf.z
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            gVar.q((com.google.android.libraries.navigation.internal.zr.q) obj);
                        }
                    });
                    com.google.android.libraries.navigation.internal.jy.g gVar2 = (com.google.android.libraries.navigation.internal.jy.g) this.H.a();
                    gVar2.b();
                    gVar.r(gVar2.a());
                    g gVar3 = this.G;
                    synchronized (gVar3) {
                        if (gVar3.a.isEmpty()) {
                            eVar = com.google.android.libraries.navigation.internal.zy.e.a;
                        } else {
                            int size = gVar3.a.size();
                            int[] iArr = new int[size];
                            Iterator it2 = gVar3.a.iterator();
                            int i3 = 0;
                            while (it2.hasNext()) {
                                iArr[i3] = ((Integer) it2.next()).intValue();
                                i3++;
                            }
                            gVar3.a.clear();
                            Arrays.sort(iArr);
                            eVar = size == 0 ? com.google.android.libraries.navigation.internal.zy.e.a : new com.google.android.libraries.navigation.internal.zy.e(Arrays.copyOf(iArr, size));
                        }
                    }
                    gVar.t(eVar.e());
                }
                cVar.i(alVarD);
                cVar.j(((com.google.android.libraries.navigation.internal.in.b) this.I.a()).a);
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                com.google.android.libraries.navigation.internal.hj.i iVar = ((b) wVar).a;
                ((v) this.a.a()).b();
                if (iVar.an()) {
                    this.F.add(cVar);
                } else {
                    v(iVar, cVar);
                }
                this.f461n.a();
                if (dVarB != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (dVarB2 != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public final void q(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.hj.i iVar2, boolean z, boolean z2, com.google.android.libraries.navigation.internal.zp.n nVar, an anVar) {
        ar.k(!iVar.an());
        com.google.android.libraries.navigation.internal.ke.c cVar = (com.google.android.libraries.navigation.internal.ke.c) this.F.poll();
        while (cVar != null) {
            fa faVar = (fa) anVar.f();
            if (faVar != null && (cVar instanceof com.google.android.libraries.navigation.internal.ke.g)) {
                ((com.google.android.libraries.navigation.internal.ke.g) cVar).v(faVar);
            }
            v(iVar, cVar);
            cVar = (com.google.android.libraries.navigation.internal.ke.c) this.F.poll();
        }
        if (z) {
            w();
        }
        if (nVar != null && !iVar2.an() && iVar2.equals(iVar)) {
            t(iVar2, nVar);
        }
        if (z2) {
            this.w.b(Integer.valueOf(((v) this.a.a()).e.getAndIncrement()));
        }
        if (nVar == null || iVar2.an() || iVar2.equals(iVar)) {
            return;
        }
        t(iVar2, nVar);
    }

    public final void r(final Throwable th, final String str) {
        this.s.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.x
            @Override // java.lang.Runnable
            public final void run() {
                bx.c(th);
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(769)).p(str);
            }
        });
    }
}
