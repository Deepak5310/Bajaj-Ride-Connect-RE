package com.google.android.libraries.navigation.internal.gk;

import android.accounts.Account;
import androidx.core.util.Consumer;
import androidx.core.view.InputDeviceCompat;
import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ace.kx;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.afl.bd;
import com.google.android.libraries.navigation.internal.ho.bg;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.km.aq;
import com.google.android.libraries.navigation.internal.km.ar;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.common.base.Ascii;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements com.google.android.libraries.navigation.internal.gg.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f439n = 0;
    public final bn b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.kl.a d;
    public final ab e;
    public final com.google.android.libraries.navigation.internal.mj.a f;
    final bj g;
    public final com.google.android.libraries.navigation.internal.yx.an l;
    public final com.google.android.libraries.navigation.internal.ik.a m;
    private final com.google.android.libraries.navigation.internal.afo.a p;
    private final com.google.android.libraries.navigation.internal.fr.d q;
    private final com.google.android.libraries.navigation.internal.agl.a r;
    private final ev s;
    private final com.google.android.libraries.navigation.internal.ng.b t;
    private static final com.google.android.libraries.navigation.internal.xn.a o = com.google.android.libraries.navigation.internal.xn.a.d(StringUtils.SPACE);
    static final Duration a = Duration.ofSeconds(4);
    public final AtomicLong h = new AtomicLong(-1);
    public final AtomicLong i = new AtomicLong(-1);
    public com.google.android.libraries.navigation.internal.gh.d j = null;
    public cy k = null;
    private final AtomicInteger u = new AtomicInteger();

    public p(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.kl.a aVar3, com.google.android.libraries.navigation.internal.mj.a aVar4, com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.iz.n nVar, bn bnVar, com.google.android.libraries.navigation.internal.fr.d dVar, ev evVar, com.google.android.libraries.navigation.internal.ik.a aVar5, com.google.android.libraries.navigation.internal.ng.b bVar, com.google.android.libraries.navigation.internal.yx.an anVar2, com.google.android.libraries.navigation.internal.agl.a aVar6) {
        this.p = aVar;
        this.c = aVar2;
        this.d = aVar3;
        this.f = aVar4;
        this.e = (ab) anVar.f();
        this.b = bnVar;
        this.q = dVar;
        this.g = az.i(nVar.g.a);
        this.s = evVar;
        this.m = aVar5;
        this.t = bVar;
        this.l = anVar2;
        this.r = aVar6;
    }

    private static void h(bj bjVar, as asVar, Executor executor) {
        if (executor != null) {
            com.google.android.libraries.navigation.internal.yu.c.d(bjVar, asVar, executor);
        }
    }

    private static void i(Throwable th) {
        if (!(th instanceof RuntimeException) || (th instanceof CancellationException)) {
            if (th.getCause() != null) {
                i(th.getCause());
            }
        } else {
            if (!(th.getCause() instanceof SecurityException)) {
                throw ((RuntimeException) th);
            }
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 588)).p("SecurityException that may be caused by b/29868674 ");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gg.d
    public final com.google.android.libraries.navigation.internal.gg.b a(final cy cyVar, com.google.android.libraries.navigation.internal.gh.d dVar, final com.google.android.libraries.navigation.internal.gg.e eVar, final Executor executor) {
        com.google.android.libraries.navigation.internal.gh.c cVar = new com.google.android.libraries.navigation.internal.gh.c();
        cVar.a = dVar.b;
        cVar.a(dVar.c);
        cVar.b(dVar.d);
        cVar.d = dVar.e;
        cVar.e = dVar.f;
        cVar.g = dVar.h;
        cVar.h = dVar.i;
        cVar.i = dVar.j;
        cVar.l = dVar.m;
        cVar.j = dVar.k;
        cVar.k = dVar.l;
        if (((bg) this.r).a().f && com.google.android.libraries.navigation.internal.hj.d.a(this.t.a())) {
            com.google.android.libraries.navigation.internal.gd.i iVar = dVar.b;
            bb bbVar = (bb) iVar.aH(5, null);
            bbVar.x(iVar);
            com.google.android.libraries.navigation.internal.gd.f fVar = (com.google.android.libraries.navigation.internal.gd.f) bbVar;
            if (!fVar.b.H()) {
                fVar.v();
            }
            com.google.android.libraries.navigation.internal.gd.i iVar2 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
            iVar2.b |= 1;
            iVar2.c = true;
            cVar.a = (com.google.android.libraries.navigation.internal.gd.i) fVar.t();
        }
        cVar.j = ((bg) this.r).a().g;
        final com.google.android.libraries.navigation.internal.gh.d dVar2 = new com.google.android.libraries.navigation.internal.gh.d(cVar);
        if (!this.q.e() && dVar2.c.d == 1) {
            com.google.android.libraries.navigation.internal.gg.n nVar = new com.google.android.libraries.navigation.internal.gg.n(this.f);
            nVar.b();
            bj bjVarG = az.g(new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.k));
            h(bjVarG, new o(this, cyVar, dVar2, eVar, nVar), executor);
            return new b(bjVarG);
        }
        if (this.g.isDone() || g(cyVar)) {
            return new b(b(cyVar, dVar2, eVar, executor));
        }
        bj bjVarC = com.google.android.libraries.navigation.internal.yu.c.c(az.i(this.g), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gk.h
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                return this.a.b(cyVar, dVar2, eVar, executor);
            }
        }, this.b);
        com.google.android.libraries.navigation.internal.gg.n nVar2 = new com.google.android.libraries.navigation.internal.gg.n(this.f);
        nVar2.b();
        h(bjVarC, new l(this, cyVar, dVar2, eVar, nVar2), executor);
        return new b(bjVarC);
    }

    public final bj b(final cy cyVar, final com.google.android.libraries.navigation.internal.gh.d dVar, final com.google.android.libraries.navigation.internal.gg.e eVar, final Executor executor) {
        final com.google.android.libraries.navigation.internal.gm.an anVarA = ((com.google.android.libraries.navigation.internal.gm.ao) this.c.a()).a(dVar);
        final com.google.android.libraries.navigation.internal.gg.n nVar = new com.google.android.libraries.navigation.internal.gg.n(this.f);
        ab abVar = this.e;
        if (abVar == null || !abVar.a() || dVar.d.b <= 0) {
            return d(cyVar, anVarA, dVar, eVar, executor, nVar);
        }
        ca caVar = new ca();
        bj bjVarC = com.google.android.libraries.navigation.internal.yu.c.c(caVar, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gk.g
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                return this.a.d(cyVar, anVarA, dVar, eVar, executor, nVar);
            }
        }, this.b);
        h(caVar, new m(this, this.e.c(), cyVar, anVarA, eVar, nVar), executor);
        return bjVarC;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:31:0x0124  */
    /* JADX WARN: Code duplicated, block: B:37:0x0144  */
    /* JADX WARN: Code duplicated, block: B:39:0x0148  */
    /* JADX WARN: Code duplicated, block: B:44:0x0162  */
    /* JADX WARN: Code duplicated, block: B:47:0x016f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0180  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:82:0x0217  */
    /* JADX WARN: Code duplicated, block: B:83:0x0225  */
    /* JADX WARN: Code duplicated, block: B:85:0x0229  */
    /* JADX WARN: Code duplicated, block: B:91:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final /* synthetic */ bj c(final cy cyVar, final com.google.android.libraries.navigation.internal.gh.d dVar, final com.google.android.libraries.navigation.internal.gm.an anVar, com.google.android.libraries.navigation.internal.gg.n nVar) {
        com.google.android.libraries.navigation.internal.gn.m mVar;
        final com.google.android.libraries.navigation.internal.gg.k kVar;
        com.google.android.libraries.navigation.internal.gd.i iVar;
        ArrayList arrayList;
        final com.google.android.libraries.navigation.internal.gm.ab abVar;
        com.google.android.libraries.navigation.internal.gd.h hVarB;
        int iOrdinal;
        bj bjVarB;
        bj bjVarI;
        final com.google.android.libraries.navigation.internal.gp.g gVar;
        com.google.android.libraries.navigation.internal.gn.o oVar = (com.google.android.libraries.navigation.internal.gn.o) this.p.a();
        com.google.android.libraries.navigation.internal.gd.a aVar = dVar.j;
        if (aVar.equals(com.google.android.libraries.navigation.internal.gd.a.PAINT)) {
            mVar = oVar.d;
        } else if (aVar.equals(com.google.android.libraries.navigation.internal.gd.a.NAV_SDK_USAGE_SERVER)) {
            mVar = oVar.e;
        } else if (aVar.equals(com.google.android.libraries.navigation.internal.gd.a.HTTP)) {
            mVar = oVar.f;
        } else {
            if (!aVar.equals(com.google.android.libraries.navigation.internal.gd.a.MAPS_MOBILE_SDKS)) {
                oVar.h.get();
                if (((fd) oVar.a.a()).containsKey(aVar)) {
                    mVar = (com.google.android.libraries.navigation.internal.gn.m) ((fd) oVar.a.a()).get(aVar);
                } else {
                    com.google.android.libraries.navigation.internal.gn.j jVar = oVar.b;
                    oVar.i.get();
                    mVar = jVar;
                }
                final com.google.android.libraries.navigation.internal.gn.l lVarA = mVar.a(cyVar, anVar, dVar);
                synchronized (nVar) {
                    int size = nVar.a.size();
                    Duration duration = com.google.android.libraries.navigation.internal.gg.l.b;
                    kVar = new com.google.android.libraries.navigation.internal.gg.k(size);
                    nVar.a.add(kVar);
                }
                kVar.b = Duration.ofMillis(this.f.a());
                kVar.y = com.google.android.libraries.navigation.internal.gg.m.REQUIREMENT_START;
                iVar = dVar.b;
                long j = this.h.get();
                arrayList = new ArrayList();
                abVar = anVar.a;
                if (!abVar.e.getAndSet(true)) {
                    abVar.b.b();
                    gVar = abVar.d;
                    if (!gVar.c.getAndSet(true)) {
                        gVar.e.b();
                        com.google.android.libraries.navigation.internal.ia.e eVar = gVar.a;
                        fz fzVar = new fz();
                        fzVar.b(com.google.android.libraries.navigation.internal.hn.q.class, new com.google.android.libraries.navigation.internal.gp.h(com.google.android.libraries.navigation.internal.hn.q.class, gVar, ap.DANGEROUS_PUBLISHER_THREAD));
                        eVar.c(gVar, fzVar.a());
                        gVar.f.b().l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gp.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                gVar.b();
                            }
                        }), gVar.b);
                    }
                    az.i(abVar.d.d).l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gm.aa
                        @Override // java.lang.Runnable
                        public final void run() {
                            abVar.a.d(new com.google.android.libraries.navigation.internal.gh.a("NetworkStackReady", Boolean.toString(true)));
                        }
                    }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                }
                arrayList.add(az.i(abVar.a));
                arrayList.add(anVar.h.a());
                if (anVar.m == 0) {
                    arrayList.add(anVar.e.a());
                }
                anVar.c.c();
                if (!iVar.h && !anVar.c()) {
                    arrayList.add(anVar.e());
                } else if (iVar.i && anVar.c()) {
                    arrayList.add(anVar.e());
                }
                arrayList.add(anVar.b.a());
                if (iVar.c) {
                    arrayList.add(anVar.c.a());
                }
                if (iVar.g) {
                    arrayList.add(anVar.f.a());
                }
                hVarB = com.google.android.libraries.navigation.internal.gd.h.b(iVar.k);
                if (hVarB == null) {
                    hVarB = com.google.android.libraries.navigation.internal.gd.h.UNSPECIFIED;
                }
                iOrdinal = hVarB.ordinal();
                if (iOrdinal != 0 || iOrdinal == 1) {
                    anVar.i.a();
                } else if (iOrdinal == 2) {
                    if (kVar.A > 0 || anVar.j.a() - j <= ((kx) anVar.l.a()).x) {
                        anVar.i.a();
                    } else {
                        com.google.android.libraries.navigation.internal.gm.y yVar = anVar.i;
                        synchronized (yVar.c) {
                            if (yVar.f.isDone()) {
                                yVar.e = new ca();
                                bj bjVarM = az.m(yVar.e, com.google.android.libraries.navigation.internal.gm.y.a, TimeUnit.MILLISECONDS, yVar.d);
                                com.google.android.libraries.navigation.internal.yx.aa aaVar = new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.x
                                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                                    public final Object ak(Object obj) {
                                        return y.b;
                                    }
                                };
                                bn bnVar = yVar.d;
                                yVar.f = aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? com.google.android.libraries.navigation.internal.aac.c.h(bjVarM, TimeoutException.class, com.google.android.libraries.navigation.internal.yr.am.b(aaVar), bnVar) : com.google.android.libraries.navigation.internal.aac.c.h(bjVarM, TimeoutException.class, aaVar, bnVar);
                            }
                            bjVarI = az.i(yVar.f);
                        }
                        arrayList.add(bjVarI);
                    }
                }
                bjVarB = com.google.android.libraries.navigation.internal.yu.c.b(az.d(arrayList), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.ak
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        am amVar = new am();
                        for (com.google.android.libraries.navigation.internal.gh.b bVar : (List) obj) {
                            if (bVar != null) {
                                amVar.b(bVar);
                            }
                        }
                        return amVar;
                    }
                }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                if (iVar.e) {
                    final com.google.android.libraries.navigation.internal.gm.ag agVar = anVar.g;
                    bjVarB = com.google.android.libraries.navigation.internal.yu.c.c(bjVarB, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gm.al
                        @Override // com.google.android.libraries.navigation.internal.aac.t
                        public final bj a(Object obj) {
                            final am amVar = (am) obj;
                            final com.google.android.libraries.navigation.internal.gg.k kVar2 = kVar;
                            final an anVar2 = anVar;
                            kVar2.r = anVar2.a();
                            kVar2.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_START;
                            return com.google.android.libraries.navigation.internal.yu.c.b(agVar.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.aj
                                @Override // com.google.android.libraries.navigation.internal.yx.aa
                                public final Object ak(Object obj2) {
                                    am amVar2 = amVar;
                                    amVar2.a = (com.google.android.libraries.navigation.internal.gh.b) obj2;
                                    com.google.android.libraries.navigation.internal.gg.k kVar3 = kVar2;
                                    kVar3.s = anVar2.a();
                                    kVar3.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_SATISFIED;
                                    return amVar2;
                                }
                            }, anVar2.k);
                        }
                    }, anVar.k);
                } else if (iVar.d) {
                    final com.google.android.libraries.navigation.internal.gm.u uVar = anVar.d;
                    bjVarB = com.google.android.libraries.navigation.internal.yu.c.c(bjVarB, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gm.al
                        @Override // com.google.android.libraries.navigation.internal.aac.t
                        public final bj a(Object obj) {
                            final am amVar = (am) obj;
                            final com.google.android.libraries.navigation.internal.gg.k kVar2 = kVar;
                            final an anVar2 = anVar;
                            kVar2.r = anVar2.a();
                            kVar2.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_START;
                            return com.google.android.libraries.navigation.internal.yu.c.b(uVar.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.aj
                                @Override // com.google.android.libraries.navigation.internal.yx.aa
                                public final Object ak(Object obj2) {
                                    am amVar2 = amVar;
                                    amVar2.a = (com.google.android.libraries.navigation.internal.gh.b) obj2;
                                    com.google.android.libraries.navigation.internal.gg.k kVar3 = kVar2;
                                    kVar3.s = anVar2.a();
                                    kVar3.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_SATISFIED;
                                    return amVar2;
                                }
                            }, anVar2.k);
                        }
                    }, anVar.k);
                }
                anVar.m++;
                anVar.q.set(true);
                return az.m(com.google.android.libraries.navigation.internal.yu.c.c(bjVarB, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gk.k
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code duplicated, block: B:103:0x01b4  */
                    /* JADX WARN: Code duplicated, block: B:105:0x01bc  */
                    /* JADX WARN: Code duplicated, block: B:108:0x01c2 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:109:0x01c4 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:110:0x01c6 A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:111:0x01c8  */
                    /* JADX WARN: Code duplicated, block: B:112:0x01cb  */
                    /* JADX WARN: Code duplicated, block: B:113:0x01ce  */
                    /* JADX WARN: Code duplicated, block: B:114:0x01d1  */
                    /* JADX WARN: Code duplicated, block: B:128:0x01fa  */
                    /* JADX WARN: Code duplicated, block: B:156:0x01dd A[SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:157:0x01d9 A[SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:83:0x017f  */
                    /* JADX WARN: Code duplicated, block: B:85:0x0183  */
                    /* JADX WARN: Code duplicated, block: B:86:0x0186  */
                    /* JADX WARN: Code duplicated, block: B:87:0x0189  */
                    /* JADX WARN: Code duplicated, block: B:88:0x018c  */
                    /* JADX WARN: Code duplicated, block: B:89:0x018f  */
                    /* JADX WARN: Code duplicated, block: B:90:0x0192  */
                    /* JADX WARN: Code duplicated, block: B:91:0x0195  */
                    /* JADX WARN: Code duplicated, block: B:92:0x0198  */
                    /* JADX WARN: Code duplicated, block: B:93:0x019b  */
                    /* JADX WARN: Code duplicated, block: B:94:0x019e  */
                    /* JADX WARN: Code duplicated, block: B:95:0x01a1  */
                    /* JADX WARN: Code duplicated, block: B:96:0x01a4  */
                    /* JADX WARN: Code duplicated, block: B:97:0x01a7  */
                    /* JADX WARN: Code duplicated, block: B:98:0x01aa  */
                    /* JADX WARN: Code duplicated, block: B:99:0x01ad  */
                    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b4, code lost:
                    
                        r9 = com.google.android.libraries.navigation.internal.adi.w.a(r9.c);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:104:0x01ba, code lost:
                    
                        if (r9 == 0) goto L105;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:105:0x01bc, code lost:
                    
                        r9 = com.google.android.libraries.navigation.internal.adi.w.a;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:106:0x01be, code lost:
                    
                        r10 = r9 - 1;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:107:0x01c0, code lost:
                    
                        if (r9 == 0) goto L157;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:108:0x01c2, code lost:
                    
                        if (r10 == 1) goto L114;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:109:0x01c4, code lost:
                    
                        if (r10 == 5) goto L113;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:110:0x01c6, code lost:
                    
                        if (r10 != 7) goto L111;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:111:0x01c8, code lost:
                    
                        r9 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:112:0x01cb, code lost:
                    
                        r9 = com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:113:0x01ce, code lost:
                    
                        r9 = com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d1, code lost:
                    
                        r9 = com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:115:0x01d3, code lost:
                    
                        r10 = r9;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:119:0x01da, code lost:
                    
                        throw null;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fa, code lost:
                    
                        if (r10.equals("crisis2") == true) goto L46;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
                    
                        if (r10.equals("evcs") == true) goto L49;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:51:0x0111, code lost:
                    
                        if (r10.equals("bike") == true) goto L52;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:54:0x011d, code lost:
                    
                        if (r10.equals("area-busyness") == true) goto L55;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:57:0x0128, code lost:
                    
                        if (r10.equals("lore-p13n") == true) goto L58;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:60:0x0132, code lost:
                    
                        if (r10.equals("photopins") == true) goto L61;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:63:0x013c, code lost:
                    
                        if (r10.equals("transit") == true) goto L64;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
                    
                        if (r10.equals(com.mappls.sdk.services.api.predictive.distance.PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC) == true) goto L67;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:69:0x0151, code lost:
                    
                        if (r10.equals("busyness") == true) goto L70;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:72:0x015b, code lost:
                    
                        if (r10.equals("restrictions") == true) goto L73;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:75:0x0166, code lost:
                    
                        if (r10.equals("buildings") == true) goto L76;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:78:0x0170, code lost:
                    
                        if (r10.equals("lore-rec") == true) goto L79;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:81:0x017a, code lost:
                    
                        if (r10.equals("spotlit") == true) goto L82;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:86:0x0186, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIT;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:87:0x0189, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_RESTRICTIONS;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:88:0x018c, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.MAPS_WAYFINDING;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:89:0x018f, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.EVCS;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:90:0x0192, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_TRANSIT;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:91:0x0195, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BICYCLING_OVERLAY;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:92:0x0198, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:93:0x019b, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PERSONALIZATION;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:94:0x019e, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_AREA_BUSYNESS;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a1, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a4, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_TRAFFIC_V2;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a7, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BUILDING_3D;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:98:0x01aa, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BUSYNESS;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ad, code lost:
                    
                        r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS;
                     */
                    /* JADX WARN: Failed to clean up code after switch over string restore
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v6 int, still in use, count: 2, list:
                      (r9v6 int) from 0x01ba: IF  (r9v6 int) == (0 int)  -> B:105:0x01bc A[HIDDEN, REMOVE]
                      (r9v6 int) from 0x01be: PHI (r9v7 int) = (r9v6 int), (r9v14 int) binds: [B:104:0x01ba, B:105:0x01bc] A[DONT_GENERATE, DONT_INLINE]
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
                    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
                    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
                    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
                     */
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final bj a(Object obj) {
                        long jA;
                        long andSet;
                        long andSet2;
                        com.google.android.libraries.navigation.internal.gh.d dVar2;
                        cy cyVar2;
                        int i;
                        com.google.android.libraries.navigation.internal.adi.an anVar2;
                        byte b;
                        com.google.android.libraries.navigation.internal.gm.am amVar = (com.google.android.libraries.navigation.internal.gm.am) obj;
                        p pVar = this.a;
                        Duration durationOfMillis = Duration.ofMillis(pVar.f.a());
                        com.google.android.libraries.navigation.internal.gg.k kVar2 = kVar;
                        kVar2.c = durationOfMillis;
                        kVar2.y = com.google.android.libraries.navigation.internal.gg.m.REQUIREMENT_SATISFIED;
                        final com.google.android.libraries.navigation.internal.gh.d dVar3 = dVar;
                        final cy cyVar3 = cyVar;
                        synchronized (pVar) {
                            jA = pVar.f.a();
                            andSet = pVar.i.getAndSet(pVar.h.get());
                            andSet2 = pVar.h.getAndSet(jA);
                            dVar2 = pVar.j;
                            cyVar2 = pVar.k;
                            pVar.j = dVar3;
                            pVar.k = cyVar3;
                        }
                        if (andSet2 != -1) {
                            ((com.google.android.libraries.navigation.internal.kk.l) pVar.d.a(com.google.android.libraries.navigation.internal.km.an.x)).a(jA - andSet2);
                        }
                        if (Duration.ofMillis(jA - andSet2).compareTo(p.a) >= 0 && Duration.ofMillis(andSet2 - andSet).compareTo(p.a) >= 0 && dVar2 != null && cyVar2 != null) {
                            bd bdVar = dVar2.h;
                            if (bdVar != null) {
                                i = bdVar.jm;
                            } else if (cyVar2 instanceof com.google.android.libraries.navigation.internal.adi.aj) {
                                com.google.android.libraries.navigation.internal.adi.aj ajVar = (com.google.android.libraries.navigation.internal.adi.aj) cyVar2;
                                com.google.android.libraries.navigation.internal.kk.k kVar3 = (com.google.android.libraries.navigation.internal.kk.k) pVar.d.a(com.google.android.libraries.navigation.internal.km.an.z);
                                int i2 = 0;
                                if (ajVar.d.size() != 0 && ajVar.c.size() != 0 && (((com.google.android.libraries.navigation.internal.adi.bd) ajVar.c.get(0)).b & 1) != 0) {
                                    com.google.android.libraries.navigation.internal.aeg.d dVar4 = ((com.google.android.libraries.navigation.internal.adi.bd) ajVar.c.get(0)).c;
                                    if (dVar4 == null) {
                                        dVar4 = com.google.android.libraries.navigation.internal.aeg.d.a;
                                    }
                                    int i3 = dVar4.c;
                                    if (i3 >= 0 && i3 <= 25) {
                                        Iterator it2 = ajVar.d.iterator();
                                        do {
                                            if (it2.hasNext()) {
                                                String str = ((com.google.android.libraries.navigation.internal.adi.x) it2.next()).d;
                                                switch (str) {
                                                    case "spotlit":
                                                        b = Ascii.CR;
                                                    case "lore-rec":
                                                        b = 0;
                                                    case "buildings":
                                                        b = 2;
                                                    case "restrictions":
                                                        b = Ascii.FF;
                                                    case "busyness":
                                                        b = 1;
                                                    case "traffic":
                                                        b = 3;
                                                    case "transit":
                                                        b = 9;
                                                    case "photopins":
                                                        b = 4;
                                                    case "lore-p13n":
                                                        b = 6;
                                                    case "area-busyness":
                                                        b = 5;
                                                    case "bike":
                                                        b = 8;
                                                    case "evcs":
                                                        b = 10;
                                                    case "crisis2":
                                                        b = 7;
                                                    case "maps-wayfinding":
                                                        b = Ascii.VT;
                                                    default:
                                                        b = -1;
                                                }
                                            } else {
                                                anVar2 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                                            }
                                            i2 = (anVar2.ah * 26) + 1 + i3;
                                        } while (anVar2 == com.google.android.libraries.navigation.internal.adi.an.UNKNOWN);
                                        i2 = (anVar2.ah * 26) + 1 + i3;
                                    }
                                }
                                kVar3.a(i2);
                                i = 65543;
                            } else if (cyVar2 instanceof com.google.android.libraries.navigation.internal.gj.d) {
                                i = 65544;
                            } else if (dVar2.j != com.google.android.libraries.navigation.internal.gd.a.UNKNOWN) {
                                com.google.android.libraries.navigation.internal.gd.a aVar2 = dVar2.j;
                                if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.GMM_API) {
                                    i = 65537;
                                } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.PAINT) {
                                    i = 65538;
                                } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.CHIME) {
                                    i = 65539;
                                } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.NAV_SDK_USAGE_SERVER) {
                                    i = InputDeviceCompat.SOURCE_TRACKBALL;
                                } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.HTTP) {
                                    i = 65541;
                                } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.MAPS_MOBILE_SDKS) {
                                    i = 65542;
                                } else {
                                    i = 65536;
                                }
                            } else {
                                i = 65536;
                            }
                            ((com.google.android.libraries.navigation.internal.kk.k) pVar.d.a(com.google.android.libraries.navigation.internal.km.an.y)).a(i);
                        }
                        final bj bjVarA = lVarA.a(amVar, kVar2);
                        com.google.android.libraries.navigation.internal.gz.g.a(pVar.l, new Consumer() { // from class: com.google.android.libraries.navigation.internal.gk.f
                            @Override // androidx.core.util.Consumer
                            public final void accept(Object obj2) {
                                int i4 = p.f439n;
                                ((ae) obj2).a(cyVar3, bjVarA, dVar3);
                            }
                        });
                        return bjVarA;
                    }
                }, this.b), dVar.c.e, TimeUnit.MILLISECONDS, this.b);
            }
            mVar = oVar.g;
        }
        final com.google.android.libraries.navigation.internal.gn.l lVarA2 = mVar.a(cyVar, anVar, dVar);
        synchronized (nVar) {
            int size2 = nVar.a.size();
            Duration duration2 = com.google.android.libraries.navigation.internal.gg.l.b;
            kVar = new com.google.android.libraries.navigation.internal.gg.k(size2);
            nVar.a.add(kVar);
            kVar.b = Duration.ofMillis(this.f.a());
            kVar.y = com.google.android.libraries.navigation.internal.gg.m.REQUIREMENT_START;
            iVar = dVar.b;
            long j2 = this.h.get();
            arrayList = new ArrayList();
            abVar = anVar.a;
            if (!abVar.e.getAndSet(true)) {
                abVar.b.b();
                gVar = abVar.d;
                if (!gVar.c.getAndSet(true)) {
                    gVar.e.b();
                    com.google.android.libraries.navigation.internal.ia.e eVar2 = gVar.a;
                    fz fzVar2 = new fz();
                    fzVar2.b(com.google.android.libraries.navigation.internal.hn.q.class, new com.google.android.libraries.navigation.internal.gp.h(com.google.android.libraries.navigation.internal.hn.q.class, gVar, ap.DANGEROUS_PUBLISHER_THREAD));
                    eVar2.c(gVar, fzVar2.a());
                    gVar.f.b().l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gp.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            gVar.b();
                        }
                    }), gVar.b);
                }
                az.i(abVar.d.d).l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gm.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        abVar.a.d(new com.google.android.libraries.navigation.internal.gh.a("NetworkStackReady", Boolean.toString(true)));
                    }
                }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            }
            arrayList.add(az.i(abVar.a));
            arrayList.add(anVar.h.a());
            if (anVar.m == 0) {
                arrayList.add(anVar.e.a());
            }
            anVar.c.c();
            if (!iVar.h) {
                if (iVar.i) {
                    arrayList.add(anVar.e());
                }
            } else if (iVar.i) {
                arrayList.add(anVar.e());
            }
            arrayList.add(anVar.b.a());
            if (iVar.c) {
                arrayList.add(anVar.c.a());
            }
            if (iVar.g) {
                arrayList.add(anVar.f.a());
            }
            hVarB = com.google.android.libraries.navigation.internal.gd.h.b(iVar.k);
            if (hVarB == null) {
                hVarB = com.google.android.libraries.navigation.internal.gd.h.UNSPECIFIED;
            }
            iOrdinal = hVarB.ordinal();
            if (iOrdinal != 0) {
                anVar.i.a();
            } else {
                anVar.i.a();
            }
            bjVarB = com.google.android.libraries.navigation.internal.yu.c.b(az.d(arrayList), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.ak
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    am amVar = new am();
                    for (com.google.android.libraries.navigation.internal.gh.b bVar : (List) obj) {
                        if (bVar != null) {
                            amVar.b(bVar);
                        }
                    }
                    return amVar;
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            if (iVar.e) {
                final com.google.android.libraries.navigation.internal.gh.e agVar2 = anVar.g;
                bjVarB = com.google.android.libraries.navigation.internal.yu.c.c(bjVarB, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gm.al
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        final am amVar = (am) obj;
                        final com.google.android.libraries.navigation.internal.gg.k kVar2 = kVar;
                        final an anVar2 = anVar;
                        kVar2.r = anVar2.a();
                        kVar2.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_START;
                        return com.google.android.libraries.navigation.internal.yu.c.b(agVar2.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.aj
                            @Override // com.google.android.libraries.navigation.internal.yx.aa
                            public final Object ak(Object obj2) {
                                am amVar2 = amVar;
                                amVar2.a = (com.google.android.libraries.navigation.internal.gh.b) obj2;
                                com.google.android.libraries.navigation.internal.gg.k kVar3 = kVar2;
                                kVar3.s = anVar2.a();
                                kVar3.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_SATISFIED;
                                return amVar2;
                            }
                        }, anVar2.k);
                    }
                }, anVar.k);
            } else if (iVar.d) {
                final com.google.android.libraries.navigation.internal.gh.e uVar2 = anVar.d;
                bjVarB = com.google.android.libraries.navigation.internal.yu.c.c(bjVarB, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gm.al
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        final am amVar = (am) obj;
                        final com.google.android.libraries.navigation.internal.gg.k kVar2 = kVar;
                        final an anVar2 = anVar;
                        kVar2.r = anVar2.a();
                        kVar2.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_START;
                        return com.google.android.libraries.navigation.internal.yu.c.b(uVar2.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gm.aj
                            @Override // com.google.android.libraries.navigation.internal.yx.aa
                            public final Object ak(Object obj2) {
                                am amVar2 = amVar;
                                amVar2.a = (com.google.android.libraries.navigation.internal.gh.b) obj2;
                                com.google.android.libraries.navigation.internal.gg.k kVar3 = kVar2;
                                kVar3.s = anVar2.a();
                                kVar3.y = com.google.android.libraries.navigation.internal.gg.m.LOCATION_REQUIREMENT_SATISFIED;
                                return amVar2;
                            }
                        }, anVar2.k);
                    }
                }, anVar.k);
            }
            anVar.m++;
            anVar.q.set(true);
            return az.m(com.google.android.libraries.navigation.internal.yu.c.c(bjVarB, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.gk.k
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code duplicated, block: B:103:0x01b4  */
                /* JADX WARN: Code duplicated, block: B:105:0x01bc  */
                /* JADX WARN: Code duplicated, block: B:108:0x01c2 A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:109:0x01c4 A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:110:0x01c6 A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:111:0x01c8  */
                /* JADX WARN: Code duplicated, block: B:112:0x01cb  */
                /* JADX WARN: Code duplicated, block: B:113:0x01ce  */
                /* JADX WARN: Code duplicated, block: B:114:0x01d1  */
                /* JADX WARN: Code duplicated, block: B:128:0x01fa  */
                /* JADX WARN: Code duplicated, block: B:156:0x01dd A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:157:0x01d9 A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:83:0x017f  */
                /* JADX WARN: Code duplicated, block: B:85:0x0183  */
                /* JADX WARN: Code duplicated, block: B:86:0x0186  */
                /* JADX WARN: Code duplicated, block: B:87:0x0189  */
                /* JADX WARN: Code duplicated, block: B:88:0x018c  */
                /* JADX WARN: Code duplicated, block: B:89:0x018f  */
                /* JADX WARN: Code duplicated, block: B:90:0x0192  */
                /* JADX WARN: Code duplicated, block: B:91:0x0195  */
                /* JADX WARN: Code duplicated, block: B:92:0x0198  */
                /* JADX WARN: Code duplicated, block: B:93:0x019b  */
                /* JADX WARN: Code duplicated, block: B:94:0x019e  */
                /* JADX WARN: Code duplicated, block: B:95:0x01a1  */
                /* JADX WARN: Code duplicated, block: B:96:0x01a4  */
                /* JADX WARN: Code duplicated, block: B:97:0x01a7  */
                /* JADX WARN: Code duplicated, block: B:98:0x01aa  */
                /* JADX WARN: Code duplicated, block: B:99:0x01ad  */
                /* JADX WARN: Code restructure failed: missing block: B:103:0x01b4, code lost:
                
                    r9 = com.google.android.libraries.navigation.internal.adi.w.a(r9.c);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:104:0x01ba, code lost:
                
                    if (r9 == 0) goto L105;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:105:0x01bc, code lost:
                
                    r9 = com.google.android.libraries.navigation.internal.adi.w.a;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:106:0x01be, code lost:
                
                    r10 = r9 - 1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:107:0x01c0, code lost:
                
                    if (r9 == 0) goto L157;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:108:0x01c2, code lost:
                
                    if (r10 == 1) goto L114;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:109:0x01c4, code lost:
                
                    if (r10 == 5) goto L113;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:110:0x01c6, code lost:
                
                    if (r10 != 7) goto L111;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:111:0x01c8, code lost:
                
                    r9 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:112:0x01cb, code lost:
                
                    r9 = com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:113:0x01ce, code lost:
                
                    r9 = com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:114:0x01d1, code lost:
                
                    r9 = com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:115:0x01d3, code lost:
                
                    r10 = r9;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:119:0x01da, code lost:
                
                    throw null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x00fa, code lost:
                
                    if (r10.equals("crisis2") == true) goto L46;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
                
                    if (r10.equals("evcs") == true) goto L49;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x0111, code lost:
                
                    if (r10.equals("bike") == true) goto L52;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x011d, code lost:
                
                    if (r10.equals("area-busyness") == true) goto L55;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x0128, code lost:
                
                    if (r10.equals("lore-p13n") == true) goto L58;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x0132, code lost:
                
                    if (r10.equals("photopins") == true) goto L61;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x013c, code lost:
                
                    if (r10.equals("transit") == true) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
                
                    if (r10.equals(com.mappls.sdk.services.api.predictive.distance.PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC) == true) goto L67;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:69:0x0151, code lost:
                
                    if (r10.equals("busyness") == true) goto L70;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:72:0x015b, code lost:
                
                    if (r10.equals("restrictions") == true) goto L73;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:75:0x0166, code lost:
                
                    if (r10.equals("buildings") == true) goto L76;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:78:0x0170, code lost:
                
                    if (r10.equals("lore-rec") == true) goto L79;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:0x017a, code lost:
                
                    if (r10.equals("spotlit") == true) goto L82;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:86:0x0186, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIT;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:87:0x0189, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_RESTRICTIONS;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x018c, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.MAPS_WAYFINDING;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:89:0x018f, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.EVCS;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x0192, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_TRANSIT;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:91:0x0195, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BICYCLING_OVERLAY;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x0198, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:93:0x019b, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PERSONALIZATION;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:94:0x019e, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_AREA_BUSYNESS;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:95:0x01a1, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:96:0x01a4, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_TRAFFIC_V2;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:97:0x01a7, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BUILDING_3D;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01aa, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_BUSYNESS;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:99:0x01ad, code lost:
                
                    r10 = com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS;
                 */
                /* JADX WARN: Failed to clean up code after switch over string restore
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v6 int, still in use, count: 2, list:
                  (r9v6 int) from 0x01ba: IF  (r9v6 int) == (0 int)  -> B:105:0x01bc A[HIDDEN, REMOVE]
                  (r9v6 int) from 0x01be: PHI (r9v7 int) = (r9v6 int), (r9v14 int) binds: [B:104:0x01ba, B:105:0x01bc] A[DONT_GENERATE, DONT_INLINE]
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
                	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
                	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
                	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
                	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
                	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
                	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
                	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
                 */
                @Override // com.google.android.libraries.navigation.internal.aac.t
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final bj a(Object obj) {
                    long jA;
                    long andSet;
                    long andSet2;
                    com.google.android.libraries.navigation.internal.gh.d dVar2;
                    cy cyVar2;
                    int i;
                    com.google.android.libraries.navigation.internal.adi.an anVar2;
                    byte b;
                    com.google.android.libraries.navigation.internal.gm.am amVar = (com.google.android.libraries.navigation.internal.gm.am) obj;
                    p pVar = this.a;
                    Duration durationOfMillis = Duration.ofMillis(pVar.f.a());
                    com.google.android.libraries.navigation.internal.gg.k kVar2 = kVar;
                    kVar2.c = durationOfMillis;
                    kVar2.y = com.google.android.libraries.navigation.internal.gg.m.REQUIREMENT_SATISFIED;
                    final com.google.android.libraries.navigation.internal.gh.d dVar3 = dVar;
                    final cy cyVar3 = cyVar;
                    synchronized (pVar) {
                        jA = pVar.f.a();
                        andSet = pVar.i.getAndSet(pVar.h.get());
                        andSet2 = pVar.h.getAndSet(jA);
                        dVar2 = pVar.j;
                        cyVar2 = pVar.k;
                        pVar.j = dVar3;
                        pVar.k = cyVar3;
                    }
                    if (andSet2 != -1) {
                        ((com.google.android.libraries.navigation.internal.kk.l) pVar.d.a(com.google.android.libraries.navigation.internal.km.an.x)).a(jA - andSet2);
                    }
                    if (Duration.ofMillis(jA - andSet2).compareTo(p.a) >= 0 && Duration.ofMillis(andSet2 - andSet).compareTo(p.a) >= 0 && dVar2 != null && cyVar2 != null) {
                        bd bdVar = dVar2.h;
                        if (bdVar != null) {
                            i = bdVar.jm;
                        } else if (cyVar2 instanceof com.google.android.libraries.navigation.internal.adi.aj) {
                            com.google.android.libraries.navigation.internal.adi.aj ajVar = (com.google.android.libraries.navigation.internal.adi.aj) cyVar2;
                            com.google.android.libraries.navigation.internal.kk.k kVar3 = (com.google.android.libraries.navigation.internal.kk.k) pVar.d.a(com.google.android.libraries.navigation.internal.km.an.z);
                            int i2 = 0;
                            if (ajVar.d.size() != 0 && ajVar.c.size() != 0 && (((com.google.android.libraries.navigation.internal.adi.bd) ajVar.c.get(0)).b & 1) != 0) {
                                com.google.android.libraries.navigation.internal.aeg.d dVar4 = ((com.google.android.libraries.navigation.internal.adi.bd) ajVar.c.get(0)).c;
                                if (dVar4 == null) {
                                    dVar4 = com.google.android.libraries.navigation.internal.aeg.d.a;
                                }
                                int i3 = dVar4.c;
                                if (i3 >= 0 && i3 <= 25) {
                                    Iterator it2 = ajVar.d.iterator();
                                    do {
                                        if (it2.hasNext()) {
                                            String str = ((com.google.android.libraries.navigation.internal.adi.x) it2.next()).d;
                                            switch (str) {
                                                case "spotlit":
                                                    b = Ascii.CR;
                                                case "lore-rec":
                                                    b = 0;
                                                case "buildings":
                                                    b = 2;
                                                case "restrictions":
                                                    b = Ascii.FF;
                                                case "busyness":
                                                    b = 1;
                                                case "traffic":
                                                    b = 3;
                                                case "transit":
                                                    b = 9;
                                                case "photopins":
                                                    b = 4;
                                                case "lore-p13n":
                                                    b = 6;
                                                case "area-busyness":
                                                    b = 5;
                                                case "bike":
                                                    b = 8;
                                                case "evcs":
                                                    b = 10;
                                                case "crisis2":
                                                    b = 7;
                                                case "maps-wayfinding":
                                                    b = Ascii.VT;
                                                default:
                                                    b = -1;
                                            }
                                        } else {
                                            anVar2 = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                                        }
                                        i2 = (anVar2.ah * 26) + 1 + i3;
                                    } while (anVar2 == com.google.android.libraries.navigation.internal.adi.an.UNKNOWN);
                                    i2 = (anVar2.ah * 26) + 1 + i3;
                                }
                            }
                            kVar3.a(i2);
                            i = 65543;
                        } else if (cyVar2 instanceof com.google.android.libraries.navigation.internal.gj.d) {
                            i = 65544;
                        } else if (dVar2.j != com.google.android.libraries.navigation.internal.gd.a.UNKNOWN) {
                            com.google.android.libraries.navigation.internal.gd.a aVar2 = dVar2.j;
                            if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.GMM_API) {
                                i = 65537;
                            } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.PAINT) {
                                i = 65538;
                            } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.CHIME) {
                                i = 65539;
                            } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.NAV_SDK_USAGE_SERVER) {
                                i = InputDeviceCompat.SOURCE_TRACKBALL;
                            } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.HTTP) {
                                i = 65541;
                            } else if (aVar2 == com.google.android.libraries.navigation.internal.gd.a.MAPS_MOBILE_SDKS) {
                                i = 65542;
                            } else {
                                i = 65536;
                            }
                        } else {
                            i = 65536;
                        }
                        ((com.google.android.libraries.navigation.internal.kk.k) pVar.d.a(com.google.android.libraries.navigation.internal.km.an.y)).a(i);
                    }
                    final bj bjVarA = lVarA2.a(amVar, kVar2);
                    com.google.android.libraries.navigation.internal.gz.g.a(pVar.l, new Consumer() { // from class: com.google.android.libraries.navigation.internal.gk.f
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj2) {
                            int i4 = p.f439n;
                            ((ae) obj2).a(cyVar3, bjVarA, dVar3);
                        }
                    });
                    return bjVarA;
                }
            }, this.b), dVar.c.e, TimeUnit.MILLISECONDS, this.b);
        }
    }

    public final bj d(final cy cyVar, final com.google.android.libraries.navigation.internal.gm.an anVar, final com.google.android.libraries.navigation.internal.gh.d dVar, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor, final com.google.android.libraries.navigation.internal.gg.n nVar) {
        com.google.android.libraries.navigation.internal.xn.a aVar;
        int andIncrement = this.u.getAndIncrement();
        Class<?> cls = cyVar.getClass();
        com.google.android.libraries.navigation.internal.xn.a aVarB = (com.google.android.libraries.navigation.internal.xn.a) com.google.android.libraries.navigation.internal.gy.a.a.get(cls);
        if (aVarB == null) {
            aVarB = com.google.android.libraries.navigation.internal.xn.a.b(cls);
        }
        com.google.android.libraries.navigation.internal.xn.a aVar2 = dVar.l;
        if (aVar2 == null || aVar2.a.isEmpty()) {
            aVar = aVarB;
        } else {
            com.google.android.libraries.navigation.internal.xn.a[] aVarArr = {o, aVar2};
            StringBuilder sb = new StringBuilder(aVarB.a);
            for (int i = 0; i < 2; i++) {
                sb.append(aVarArr[i].a);
            }
            aVar = new com.google.android.libraries.navigation.internal.xn.a(sb.toString());
        }
        com.google.android.libraries.navigation.internal.nw.e.e(aVar, andIncrement);
        com.google.android.libraries.navigation.internal.yt.a aVarB2 = com.google.android.libraries.navigation.internal.yt.d.b("GmmNetworkImpl.send ", aVar);
        try {
            nVar.b();
            final br supplier = new br() { // from class: com.google.android.libraries.navigation.internal.gk.j
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return this.a.c(cyVar, dVar, anVar, nVar);
                }
            };
            if (aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
                int i2 = com.google.android.libraries.navigation.internal.yr.am.a;
                Intrinsics.checkNotNullParameter(supplier, "supplier");
                final com.google.android.libraries.navigation.internal.yr.ag agVarC = com.google.android.libraries.navigation.internal.yr.i.c();
                supplier = new br() { // from class: com.google.android.libraries.navigation.internal.yr.al
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        int i3 = am.a;
                        ag agVar = agVarC;
                        Intrinsics.checkNotNull(agVar);
                        ae aeVarA = i.a();
                        ag agVarE = i.e(aeVarA, agVar);
                        try {
                            Object objA = supplier.a();
                            i.e(aeVarA, agVarE);
                            return objA;
                        } catch (Throwable th) {
                            try {
                                f.a(th);
                                throw th;
                            } catch (Throwable th2) {
                                i.e(aeVarA, agVarE);
                                throw th2;
                            }
                        }
                    }
                };
            }
            com.google.android.libraries.navigation.internal.gd.k kVar = dVar.c;
            com.google.android.libraries.navigation.internal.zo.f fVar = new com.google.android.libraries.navigation.internal.zo.f(new com.google.android.libraries.navigation.internal.zo.c(kVar.c, kVar.d));
            final Account account = anVar.f441n;
            final String str = anVar.o;
            com.google.android.libraries.navigation.internal.yx.as asVar = new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.gk.i
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    Exception exc = (Exception) obj;
                    if (exc == null) {
                        return false;
                    }
                    if (!(exc instanceof com.google.android.libraries.navigation.internal.gg.p)) {
                        return true;
                    }
                    com.google.android.libraries.navigation.internal.gg.o oVar = ((com.google.android.libraries.navigation.internal.gg.p) exc).a;
                    com.google.android.libraries.navigation.internal.fw.g gVar = com.google.android.libraries.navigation.internal.fw.g.PROTOCOL_ERROR_INVALID_CONTENT_TYPE;
                    int iOrdinal = oVar.p.ordinal();
                    return (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 12 || iOrdinal == 15) ? false : true;
                }
            };
            bn bnVar = this.b;
            Logger logger = com.google.android.libraries.navigation.internal.zo.q.a;
            com.google.android.libraries.navigation.internal.zo.o oVar = new com.google.android.libraries.navigation.internal.zo.o();
            oVar.a = com.google.android.libraries.navigation.internal.yx.an.j(bnVar);
            com.google.android.libraries.navigation.internal.zo.q qVarA = oVar.a(supplier, fVar, asVar);
            h(qVarA, new n(this, aVar, andIncrement, nVar, anVar, cyVar, qVarA, eVar), executor);
            bj bjVarA = aVarB2.a(qVarA);
            aVarB2.close();
            return bjVarA;
        } catch (Throwable th) {
            try {
                aVarB2.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public final void e(Throwable th, cy cyVar, com.google.android.libraries.navigation.internal.gm.an anVar, int i, com.google.android.libraries.navigation.internal.gg.e eVar, com.google.android.libraries.navigation.internal.gg.n nVar) {
        com.google.android.libraries.navigation.internal.gg.m mVar;
        i(th);
        nVar.a(this.b);
        anVar.b();
        com.google.android.libraries.navigation.internal.gg.o oVarB = com.google.android.libraries.navigation.internal.gg.o.b(th);
        if (oVarB.q == null) {
            synchronized (nVar) {
                mVar = !nVar.a.isEmpty() ? ((com.google.android.libraries.navigation.internal.gg.a) com.google.android.libraries.navigation.internal.gg.l.y((com.google.android.libraries.navigation.internal.gg.k) gs.d(nVar.a))).a : null;
            }
            oVarB = oVarB.d("last attempt state: ".concat(String.valueOf(String.valueOf(mVar))));
        }
        com.google.android.libraries.navigation.internal.gg.o oVar = oVarB;
        oVar.p.equals(com.google.android.libraries.navigation.internal.fw.g.INVALID_GAIA_AUTH_TOKEN);
        cyVar.getClass();
        f(cyVar, nVar.c.toMillis() - nVar.b.toMillis(), oVar.e(), i);
        if (eVar != null) {
            com.google.android.libraries.navigation.internal.gg.h hVar = new com.google.android.libraries.navigation.internal.gg.h();
            hVar.a = cyVar;
            hVar.a(i);
            hVar.b = anVar.o;
            hVar.c = anVar.f441n;
            hVar.d = anVar.p;
            hVar.e = nVar;
            eVar.a(new com.google.android.libraries.navigation.internal.gg.i(hVar), oVar);
        }
    }

    public final void f(cy cyVar, long j, aq aqVar, int i) {
        com.google.android.libraries.navigation.internal.km.y yVar;
        com.google.android.libraries.navigation.internal.km.y yVar2 = ar.b(cyVar.getClass()).c;
        if (yVar2 != null) {
            ((com.google.android.libraries.navigation.internal.kk.l) this.d.a(yVar2)).a(j);
        }
        if (aqVar.equals(aq.SUCCESS) && (yVar = ar.b(cyVar.getClass()).d) != null) {
            ((com.google.android.libraries.navigation.internal.kk.l) this.d.a(yVar)).a(j);
        }
        com.google.android.libraries.navigation.internal.km.x xVar = ar.b(cyVar.getClass()).h;
        if (xVar != null) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.d.a(xVar)).a(aqVar.y);
        }
        com.google.android.libraries.navigation.internal.km.x xVar2 = ar.b(cyVar.getClass()).a;
        if (xVar2 != null) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.d.a(xVar2)).a(i);
        }
        if (xVar == null || xVar2 == null || yVar2 == null) {
            cyVar.getClass();
        }
    }

    public final boolean g(cy cyVar) {
        return this.s.contains(cyVar.getClass());
    }
}
