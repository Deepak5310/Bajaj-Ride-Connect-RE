package com.google.android.libraries.navigation.internal.px;

import android.os.SystemClock;
import android.util.Log;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bt implements Callable {
    public final com.google.android.libraries.navigation.internal.aac.bm d;
    public final com.google.android.libraries.navigation.internal.aac.ca e;
    private final bp h;
    private final cs i;
    public volatile boolean a = false;
    volatile boolean b = false;
    volatile boolean c = false;
    private final Semaphore g = new Semaphore(1);
    volatile com.google.android.libraries.navigation.internal.aac.ca f = null;

    public bt(bp bpVar, cs csVar, com.google.android.libraries.navigation.internal.aac.bm bmVar, Executor executor) {
        this.h = bpVar;
        this.i = csVar;
        this.d = bmVar;
        com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
        this.e = caVar;
        com.google.android.libraries.navigation.internal.hx.n.a(caVar, executor);
    }

    final synchronized void a() {
        this.c = true;
        notifyAll();
    }

    final synchronized void b() {
        this.b = true;
        notifyAll();
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        boolean z;
        ev evVarO;
        boolean zC;
        while (true) {
            List<bo> list = null;
            if (this.b) {
                break;
            }
            long jC = Long.MAX_VALUE;
            while (!this.b) {
                long jA = this.h.v.a();
                if (this.c) {
                    bp bpVar = this.h;
                    synchronized (bpVar.b) {
                        ArrayList arrayList = bpVar.d;
                        bpVar.d = bpVar.c;
                        bpVar.c = arrayList;
                        bpVar.c.clear();
                    }
                    int size = bpVar.d.size();
                    for (int i = 0; i < size; i++) {
                        bpVar.m = true;
                        bq bqVar = (bq) bpVar.d.get(i);
                        int i2 = bqVar.b;
                        int i3 = i2 - 1;
                        if (i2 == 0) {
                            throw null;
                        }
                        if (i3 != 0) {
                            if (i3 == 1) {
                                if (bpVar.k.remove(bqVar.a)) {
                                    bqVar.a.d(bpVar);
                                } else {
                                    ((com.google.android.libraries.navigation.internal.zb.h) bp.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(939)).s("Failed to remove LabelSource: %s", bqVar.a);
                                }
                            }
                        } else if (bpVar.k.contains(bqVar.a)) {
                            ((com.google.android.libraries.navigation.internal.zb.h) bp.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(938)).s("LabelSource is already added: %s", bqVar.a);
                        } else {
                            bpVar.k.add(bqVar.a);
                            bqVar.a.ac(bpVar);
                        }
                        bqVar.a();
                        bpVar.j.g(bqVar);
                    }
                    bpVar.d.clear();
                    int size2 = bpVar.k.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            jC = jA;
                            break;
                        }
                        cr crVar = (cr) bpVar.k.get(i4);
                        if (crVar instanceof er) {
                            er erVar = (er) crVar;
                            if (erVar.ab() != com.google.android.libraries.navigation.internal.adi.an.GMM_INDOOR && erVar.f()) {
                                if (jC != Long.MAX_VALUE) {
                                    break;
                                }
                                jC = ((long) this.h.u.c()) + jA;
                                break;
                            }
                        }
                        i4++;
                    }
                    this.c = false;
                }
                long jB = com.google.android.libraries.navigation.internal.zy.k.b(jC - jA, 0L, 2147483647L);
                if (jB == 0) {
                    break;
                }
                synchronized (this) {
                    if (!this.c && !this.b) {
                        try {
                            wait(jB);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            if (this.b) {
                break;
            }
            try {
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelControllerImpl.runLabelPlacement");
                try {
                    this.g.acquireUninterruptibly();
                    bp bpVar2 = this.h;
                    cs csVar = this.i;
                    com.google.android.libraries.navigation.internal.ra.c.e.f();
                    bpVar2.o.b();
                    synchronized (bpVar2) {
                        bs bsVar = bpVar2.g;
                        z = bsVar.h;
                        bsVar.h = false;
                        com.google.android.libraries.navigation.internal.qc.g gVar = bpVar2.p;
                        ((com.google.android.libraries.navigation.internal.po.cp) gVar).b = ((com.google.android.libraries.navigation.internal.po.cp) gVar).a.p();
                        com.google.android.libraries.geo.mapcore.internal.model.v vVar = ((com.google.android.libraries.navigation.internal.po.cp) gVar).b;
                        if (vVar != null) {
                            bpVar2.g.g = vVar.b;
                        }
                        bs bsVar2 = bpVar2.h;
                        bs bsVar3 = bpVar2.g;
                        bsVar2.a = bsVar3.a;
                        bsVar2.b = bsVar3.b;
                        bsVar2.c = bsVar3.c;
                        bsVar2.d = bsVar3.d;
                        bsVar2.e = bsVar3.e;
                        bsVar2.f = bsVar3.f;
                        bsVar2.g = bsVar3.g;
                        bsVar2.l = null;
                        bsVar2.i = bsVar3.i;
                        bsVar2.j = bsVar3.j;
                        bsVar2.k = bsVar3.k;
                        bsVar3.k = bpVar2.e.a();
                    }
                    bu buVar = (bu) bpVar2.f540n.get();
                    com.google.android.libraries.navigation.internal.yx.ar.q(buVar);
                    com.google.android.libraries.navigation.internal.pb.t tVar = buVar.a;
                    if (bpVar2.l) {
                        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelControllerImpl.runLabelPlacement - gatherOps");
                        try {
                            if (bpVar2.m) {
                                cq cqVar = bpVar2.i;
                                cqVar.a.a.clear();
                                cqVar.d.clear();
                                cqVar.e.clear();
                                cqVar.b.clear();
                                cqVar.c.clear();
                                cqVar.f.clear();
                                Iterator it2 = bpVar2.k.iterator();
                                while (it2.hasNext()) {
                                    ((cr) it2.next()).aa(bpVar2.i);
                                }
                                bpVar2.m = false;
                            }
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                            com.google.android.libraries.navigation.internal.pd.d dVar = bpVar2.h.a;
                            com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
                            tVar.B(dVar);
                            bs bsVar4 = bpVar2.h;
                            tVar.C(bsVar4.c, bsVar4.d);
                            tVar.d(bpVar2.h.b);
                            com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("LabelControllerImpl.runLabelPlacement - onLabelingBegin");
                            try {
                                com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = bpVar2.h.g;
                                synchronized (bpVar2.r) {
                                    evVarO = ev.o(bpVar2.r);
                                }
                                int size3 = evVarO.size();
                                for (int i5 = 0; i5 < size3; i5++) {
                                    ((com.google.android.libraries.navigation.internal.ol.ad) evVarO.get(i5)).a(tVar, aqVar);
                                }
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                cq cqVar2 = bpVar2.i;
                                bs bsVar5 = bpVar2.h;
                                csVar.b(tVar, cqVar2, bsVar5.f, bsVar5.g, z, null, bsVar5.i);
                                bpVar2.f.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                                bp.a aVar = bpVar2.o;
                                synchronized (aVar) {
                                    cz czVar = ((ed) csVar).d;
                                    czVar.d.c(false);
                                    czVar.e.c(false);
                                    aVar.c = false;
                                    aVar.b = false;
                                    aVar.f.c(Boolean.valueOf(aVar.c()));
                                    if (!aVar.d.isEmpty()) {
                                        list = aVar.d;
                                        aVar.d = new ArrayList();
                                    }
                                    zC = aVar.c();
                                }
                                if (list != null) {
                                    for (bo boVar : list) {
                                        boVar.b.execute(boVar.a);
                                    }
                                }
                                if (zC) {
                                    synchronized (bpVar2.q) {
                                        Iterator it3 = bpVar2.q.iterator();
                                        while (it3.hasNext()) {
                                            ((com.google.android.libraries.navigation.internal.ol.ac) it3.next()).Y();
                                        }
                                    }
                                    com.google.android.libraries.navigation.internal.kk.m mVar = bpVar2.h.k;
                                    com.google.android.libraries.navigation.internal.yx.ar.q(mVar);
                                    mVar.a();
                                    if (Log.isLoggable("LabelingMetrics", 2)) {
                                        SystemClock.elapsedRealtime();
                                    }
                                    ((ed) csVar).f = false;
                                }
                                ((ed) csVar).d.e();
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
                    } else {
                        csVar.a();
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    this.g.release();
                } catch (Throwable th5) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                this.g.release();
                throw th7;
            }
        }
        return null;
    }
}
