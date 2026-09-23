package com.google.android.libraries.navigation.internal.sv;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.adr.dx;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.gs;
import com.google.android.libraries.navigation.internal.adr.ig;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.ij;
import com.google.android.libraries.navigation.internal.adr.ik;
import com.google.android.libraries.navigation.internal.adr.in;
import com.google.android.libraries.navigation.internal.adr.io;
import com.google.android.libraries.navigation.internal.adr.jb;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.adr.kn;
import com.google.android.libraries.navigation.internal.adr.kq;
import com.google.android.libraries.navigation.internal.adr.kt;
import com.google.android.libraries.navigation.internal.adr.ku;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.afl.gv;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import j$.time.Instant;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ak implements com.google.android.libraries.navigation.internal.sp.b {
    public static final /* synthetic */ int K = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j L = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sv.ak");
    static final long a = TimeUnit.SECONDS.toMillis(10);
    public long A;
    public long B;
    public com.google.android.libraries.navigation.internal.sd.b C;
    public com.google.android.libraries.navigation.internal.db.r D;
    public aj E;
    com.google.android.libraries.navigation.internal.bc.a F;
    public final Executor G;
    public final com.google.android.libraries.navigation.internal.tc.n H;
    public final Executor I;
    public final k J;
    private final com.google.android.libraries.navigation.internal.afo.a M;
    private final Context N;
    private final com.google.android.libraries.navigation.internal.cw.a O;
    private final g P;
    private final com.google.android.libraries.navigation.internal.jy.af Q;
    private com.google.android.libraries.navigation.internal.aac.bj R;
    private final long T;
    private long U;
    private final com.google.android.libraries.navigation.internal.wd.g V;
    private com.google.android.libraries.navigation.internal.ael.x W;
    private com.google.android.libraries.navigation.internal.bp.bg Y;
    private BroadcastReceiver Z;
    private BroadcastReceiver aa;
    private final com.google.android.libraries.navigation.internal.wj.a ab;
    private final com.google.android.libraries.navigation.internal.tj.d ac;
    private final cd ad;
    public final com.google.android.libraries.navigation.internal.kl.b b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public final com.google.android.libraries.navigation.internal.ia.e d;
    public final com.google.android.libraries.geo.navcore.guidance.impl.x e;
    public final o f;
    public final com.google.android.libraries.navigation.internal.hn.p g;
    public final hm h;
    public final com.google.android.libraries.navigation.internal.afo.a i;
    public final Handler j;
    public final Runnable k;
    public final com.google.android.libraries.navigation.internal.aq.m m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.tc.j f579n;
    public final com.google.android.libraries.navigation.internal.sx.bb o;
    public final aq p;
    public final ao q;
    public final com.google.android.libraries.navigation.internal.iv.f r;
    public final cg s;
    public final com.google.android.libraries.navigation.internal.km.ab t;
    public boolean u;
    public com.google.android.libraries.navigation.internal.aac.bj v;
    boolean w;
    private com.google.android.libraries.navigation.internal.aac.bj S = null;
    boolean x = true;
    long y = -1;
    public long z = -1;
    private boolean X = false;
    public final an l = null;

    public ak(Application application, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.geo.navcore.guidance.impl.x xVar, com.google.android.libraries.navigation.internal.cw.a aVar3, o oVar, com.google.android.libraries.navigation.internal.hn.p pVar, hm hmVar, an anVar, final com.google.android.libraries.navigation.internal.so.c cVar, com.google.android.libraries.navigation.internal.aq.m mVar, com.google.android.libraries.navigation.internal.tc.j jVar, com.google.android.libraries.navigation.internal.bw.b bVar2, com.google.android.libraries.navigation.internal.sx.bb bbVar, g gVar, aq aqVar, ao aoVar, com.google.android.libraries.navigation.internal.iv.f fVar, cd cdVar, com.google.android.libraries.navigation.internal.jy.af afVar, Executor executor, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.tc.n nVar, Executor executor2, cg cgVar, com.google.android.libraries.navigation.internal.wd.g gVar2, com.google.android.libraries.navigation.internal.wj.a aVar5, com.google.android.libraries.navigation.internal.tj.d dVar) {
        this.M = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.N = application;
        this.d = eVar;
        this.e = xVar;
        this.O = aVar3;
        this.f = oVar;
        this.g = pVar;
        this.h = hmVar;
        this.m = mVar;
        this.f579n = jVar;
        this.o = bbVar;
        this.P = gVar;
        this.p = aqVar;
        this.q = aoVar;
        this.r = fVar;
        this.ad = cdVar;
        this.Q = afVar;
        this.H = nVar;
        this.I = executor2;
        this.s = cgVar;
        this.A = e(fVar, pVar);
        this.G = executor;
        this.T = TimeUnit.SECONDS.toMillis(pVar.a.aE);
        TimeUnit.SECONDS.toMillis(pVar.a.aJ);
        this.i = aVar4;
        this.j = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: com.google.android.libraries.navigation.internal.sv.aa
            @Override // java.lang.Runnable
            public final void run() {
                int i = ak.K;
                cVar.b(true);
            }
        };
        this.J = new k(bVar, bVar2, pVar);
        this.V = gVar2;
        this.ab = aVar5;
        this.ac = dVar;
        this.t = (com.google.android.libraries.navigation.internal.km.ab) bVar.a(com.google.android.libraries.navigation.internal.km.ak.s);
    }

    public static /* synthetic */ com.google.android.libraries.navigation.internal.aac.bj D(ak akVar, com.google.android.libraries.navigation.internal.db.r rVar, com.google.android.libraries.navigation.internal.bp.bg bgVar, int i, com.google.android.libraries.navigation.internal.ael.x xVar, boolean z, boolean z2, EnumMap enumMap) {
        lt ltVarB = akVar.f579n.b(true);
        com.google.android.libraries.navigation.internal.ael.x xVar2 = akVar.W;
        int i2 = com.google.android.libraries.navigation.internal.sx.ay.c;
        com.google.android.libraries.navigation.internal.sx.bb bbVar = akVar.o;
        bbVar.b(rVar, i2);
        com.google.android.libraries.navigation.internal.sx.av avVar = bbVar.a;
        if (!avVar.a()) {
            com.google.android.libraries.navigation.internal.sx.at atVar = avVar.c;
            lz lzVarF = atVar.f(rVar, bgVar, xVar2, xVar, z, enumMap, ltVarB);
            com.google.android.libraries.navigation.internal.sx.ab abVarA = atVar.d.a(rVar, ((com.google.android.libraries.navigation.internal.kk.n) atVar.c.a(com.google.android.libraries.navigation.internal.km.af.f)).a(), ((com.google.android.libraries.navigation.internal.kk.n) atVar.c.a(com.google.android.libraries.navigation.internal.km.af.e)).a());
            abVarA.f(lzVarF, com.google.android.libraries.navigation.internal.sx.at.e(rVar), z2, false);
            return abVarA.a();
        }
        com.google.android.libraries.navigation.internal.sx.b bVar = new com.google.android.libraries.navigation.internal.sx.b();
        bVar.a = bgVar;
        bVar.b = xVar;
        bVar.l = xVar2;
        bVar.m = enumMap;
        bVar.c = rVar;
        bVar.j = com.google.android.libraries.navigation.internal.sx.be.a;
        bVar.c(z);
        bVar.d = ltVarB;
        bVar.f584n = Integer.valueOf(i);
        bVar.b(z2);
        bVar.o = Long.valueOf(com.google.android.libraries.navigation.internal.sx.av.a);
        return avVar.f.a(bVar.d());
    }

    public static final ev I(com.google.android.libraries.navigation.internal.bp.bh bhVar) {
        eq eqVar = new eq();
        Iterator it2 = bhVar.iterator();
        while (it2.hasNext()) {
            eqVar.h(((com.google.android.libraries.navigation.internal.bp.bg) it2.next()).Z);
        }
        return eqVar.g();
    }

    private final void M() {
        this.z = -1L;
        com.google.android.libraries.navigation.internal.aac.bj bjVar = this.S;
        if (bjVar == null || bjVar.isDone()) {
            return;
        }
        bjVar.cancel(false);
    }

    private static boolean O(com.google.android.libraries.navigation.internal.sx.as asVar) {
        return asVar.b.k() && asVar.b.f().Q == com.google.android.libraries.navigation.internal.bp.bf.OFFLINE;
    }

    public static int c(com.google.android.libraries.navigation.internal.bp.bh bhVar) {
        for (int i = 0; i < bhVar.d(); i++) {
            if (bhVar.e(i).W()) {
                return i;
            }
        }
        return -1;
    }

    public static long d(com.google.android.libraries.navigation.internal.iv.f fVar, int i) {
        String strI = fVar.i(com.google.android.libraries.navigation.internal.iv.ab.H, "0");
        if (!"0".equals(strI)) {
            try {
                return (long) Math.ceil(i / Float.parseFloat(strI));
            } catch (NullPointerException | NumberFormatException unused) {
            }
        }
        return i;
    }

    public static long e(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.hn.p pVar) {
        return TimeUnit.SECONDS.toMillis(d(fVar, pVar.g()));
    }

    public static com.google.android.libraries.navigation.internal.sx.as f(com.google.android.libraries.navigation.internal.sx.am amVar) {
        return com.google.android.libraries.navigation.internal.sx.as.c(amVar.a, amVar.b, null, amVar.c, amVar.d, amVar.f);
    }

    final boolean A() {
        com.google.android.libraries.navigation.internal.aac.bj bjVar = this.S;
        return (bjVar == null || bjVar.isDone()) ? false : true;
    }

    final boolean B(com.google.android.libraries.navigation.internal.bp.bg bgVar, ku kuVar) {
        int iA = kt.a(kuVar.c);
        if (iA == 0) {
            iA = kt.b;
        }
        if (iA != kt.c) {
            return false;
        }
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        com.google.android.libraries.navigation.internal.bp.bg bgVar2 = fVar == null ? null : fVar.e;
        if (bgVar2 == null) {
            return false;
        }
        kq kqVar = kuVar.d;
        if (kqVar == null) {
            kqVar = kq.a;
        }
        int i = bgVar2.V;
        if ((kqVar.b & 4) != 0) {
            com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) kqVar.aH(5, null);
            bbVar.x(kqVar);
            kn knVar = (kn) bbVar;
            jg jgVar = kqVar.e;
            if (jgVar == null) {
                jgVar = jg.a;
            }
            jg jgVarF = com.google.android.libraries.navigation.internal.bp.bg.F(jgVar, i);
            if (!knVar.b.H()) {
                knVar.v();
            }
            kq kqVar2 = (kq) knVar.b;
            jgVarF.getClass();
            kqVar2.e = jgVarF;
            kqVar2.b |= 4;
            kqVar = (kq) knVar.t();
        }
        jg jgVar2 = kqVar.e;
        if (jgVar2 == null) {
            jgVar2 = jg.a;
        }
        if (jgVar2.f.size() == 0) {
            return false;
        }
        this.E = new aj(bgVar, kqVar);
        com.google.android.libraries.navigation.internal.tj.o oVarG = g();
        com.google.android.libraries.navigation.internal.se.b bVarB = oVarG.b();
        if (bVarB == null) {
            return false;
        }
        this.d.a(new com.google.android.libraries.navigation.internal.sw.c(oVarG, bgVar));
        Instant instant = bgVar2.i;
        jg jgVar3 = kqVar.e;
        if (jgVar3 == null) {
            jgVar3 = jg.a;
        }
        jb jbVar = jgVar3.k;
        if (jbVar == null) {
            jbVar = jb.a;
        }
        com.google.android.libraries.navigation.internal.tj.b bVarA = this.ac.a(kqVar, oVarG.a, bVarB.b, instant.plusSeconds(jbVar.c));
        if (!this.h.f165n) {
            this.p.l(oVarG, this.C, null);
        }
        this.q.a(bVarA);
        return true;
    }

    public final boolean C(String str, com.google.android.libraries.navigation.internal.ady.ad adVar) {
        com.google.android.libraries.navigation.internal.sc.f fVar;
        k kVar = this.J;
        com.google.android.libraries.navigation.internal.sc.f fVar2 = kVar.f;
        Iterator it2 = kVar.e.iterator();
        do {
            if (!it2.hasNext()) {
                fVar = null;
                break;
            }
            fVar = (com.google.android.libraries.navigation.internal.sc.f) it2.next();
        } while (!fVar.e.Z.equals(str));
        if (fVar == null || fVar2 == null) {
            return false;
        }
        if (adVar != null) {
            this.Q.e(new com.google.android.libraries.navigation.internal.ke.e(this.c, com.google.android.libraries.navigation.internal.zw.b.b(fVar2.d(), RoundingMode.HALF_UP), com.google.android.libraries.navigation.internal.zw.b.b(fVar.d(), RoundingMode.HALF_UP), adVar));
        }
        this.d.a(new com.google.android.libraries.navigation.internal.tf.b(fVar.e, fVar2.d(), fVar.d(), adVar, this.c.a()));
        return L(fVar, false, adVar == null, com.google.android.libraries.navigation.internal.rw.z.b);
    }

    public final void H(com.google.android.libraries.navigation.internal.bc.a aVar, boolean z, boolean z2, boolean z3) {
        com.google.android.libraries.navigation.internal.aac.bj bjVarH;
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        if (fVar == null) {
            return;
        }
        if (this.D == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) L.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1652)).p("Attempted to reroute but current location was unavailable.");
            return;
        }
        com.google.android.libraries.navigation.internal.bp.bg bgVar = this.Y;
        com.google.android.libraries.navigation.internal.aac.bj bjVar = this.v;
        boolean z4 = (bjVar == null || bjVar.isDone()) ? false : true;
        boolean z5 = fVar.e.Q == com.google.android.libraries.navigation.internal.bp.bf.OFFLINE;
        long jA = this.c.a();
        long j = this.z;
        boolean z6 = (bgVar == null || this.w || A() || z5 || !((j > (-1L) ? 1 : (j == (-1L) ? 0 : -1)) == 0 || ((jA - j) > a ? 1 : ((jA - j) == a ? 0 : -1)) > 0)) ? false : true;
        boolean z7 = z5 || (z6 && (this.z > (-1L) ? 1 : (this.z == (-1L) ? 0 : -1)) != 0) || !(this.w || aVar == null);
        boolean z8 = aVar == null;
        if (aVar != null) {
            com.google.android.libraries.navigation.internal.bc.a aVar2 = this.F;
            if (aVar2 == null) {
                this.F = aVar;
            } else {
                aVar2.a.putAll(aVar.a);
                aVar2.b = false;
            }
        }
        boolean z9 = (z4 && !z6 && this.F == null) ? false : true;
        if (z6 || z9) {
            if (z() && z && (this.w || this.x)) {
                long j2 = this.y;
                if (j2 == -1 || jA - j2 > this.T) {
                    t(com.google.android.libraries.navigation.internal.vn.b.DRING_DRING, (this.g.a.aG && this.r.y(com.google.android.libraries.navigation.internal.iv.ab.cb, false) && i() == com.google.android.libraries.navigation.internal.ady.al.WALK) ? this.N.getString(com.google.android.libraries.navigation.internal.dw.h.T) : "");
                    this.y = jA;
                }
            }
            this.x = this.w;
            com.google.android.libraries.navigation.internal.tj.o oVarG = g();
            this.p.i(!z8);
            if (z3) {
                this.p.l(oVarG, this.C, null);
            }
            boolean z10 = z;
            int i = com.google.android.libraries.geo.navcore.guidance.impl.ao.a;
            if (z10) {
                i = com.google.android.libraries.geo.navcore.guidance.impl.ao.b;
            } else if (!z8) {
                i = com.google.android.libraries.geo.navcore.guidance.impl.ao.c;
            } else if (z2) {
                i = com.google.android.libraries.geo.navcore.guidance.impl.ao.d;
            }
            com.google.android.libraries.geo.navcore.guidance.impl.x xVar = this.e;
            com.google.android.libraries.geo.navcore.guidance.impl.h hVar = (com.google.android.libraries.geo.navcore.guidance.impl.h) com.google.android.libraries.geo.navcore.guidance.impl.j.a.q();
            com.google.android.libraries.geo.navcore.guidance.impl.am amVar = (com.google.android.libraries.geo.navcore.guidance.impl.am) com.google.android.libraries.geo.navcore.guidance.impl.ap.a.q();
            if (!amVar.b.H()) {
                amVar.v();
            }
            com.google.android.libraries.geo.navcore.guidance.impl.ap apVar = (com.google.android.libraries.geo.navcore.guidance.impl.ap) amVar.b;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            apVar.c = i2;
            apVar.b |= 1;
            com.google.android.libraries.geo.navcore.guidance.impl.ap apVar2 = (com.google.android.libraries.geo.navcore.guidance.impl.ap) amVar.t();
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.geo.navcore.guidance.impl.j jVar = (com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.b;
            apVar2.getClass();
            jVar.c = apVar2;
            jVar.b = 3;
            xVar.g((com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.t());
            if (z6) {
                com.google.android.libraries.navigation.internal.db.r rVar = this.D;
                com.google.android.libraries.navigation.internal.bp.bg bgVar2 = this.Y;
                com.google.android.libraries.navigation.internal.yx.ar.q(bgVar2);
                gv gvVar = this.g.a.y;
                if (gvVar == null) {
                    gvVar = gv.a;
                }
                gv gvVar2 = gvVar;
                com.google.android.libraries.navigation.internal.sx.bb bbVar = this.o;
                com.google.android.libraries.navigation.internal.ael.x xVar2 = this.W;
                com.google.android.libraries.navigation.internal.ael.x xVarJ = j();
                bbVar.b(rVar, com.google.android.libraries.navigation.internal.sx.ay.e);
                com.google.android.libraries.navigation.internal.sx.av avVar = bbVar.a;
                if (avVar.a()) {
                    com.google.android.libraries.navigation.internal.sx.b bVar = new com.google.android.libraries.navigation.internal.sx.b();
                    bVar.a = bgVar2;
                    bVar.b = xVarJ;
                    bVar.l = xVar2;
                    bVar.c = rVar;
                    bVar.j = com.google.android.libraries.navigation.internal.sx.be.a;
                    bVar.c(false);
                    bVar.f584n = -1;
                    bVar.p = gvVar2;
                    bVar.b(true);
                    bVar.o = Long.valueOf(com.google.android.libraries.navigation.internal.sx.av.a);
                    bjVarH = avVar.f.a(bVar.d());
                } else {
                    bjVarH = com.google.android.libraries.navigation.internal.aac.j.h(avVar.c.b(rVar, bgVar2, gvVar2, avVar.d, xVar2, xVarJ), new com.google.android.libraries.navigation.internal.sx.au(), avVar.e);
                }
                this.S = bjVarH;
                com.google.android.libraries.navigation.internal.aac.az.o(bjVarH, new ag(this), this.G);
            }
            com.google.android.libraries.navigation.internal.aac.bj bjVar2 = this.v;
            com.google.android.libraries.navigation.internal.aac.bj bjVar3 = this.R;
            if (bjVar2 != null && !bjVar2.isDone()) {
                bjVar2.cancel(false);
            } else if (bjVar3 != null && !bjVar3.isDone()) {
                bjVar3.cancel(false);
            }
            final com.google.android.libraries.navigation.internal.bp.bg bgVar3 = fVar.e;
            final int i3 = fVar.b.e;
            com.google.android.libraries.navigation.internal.bc.a aVar3 = this.F;
            final EnumMap enumMap = aVar3 != null ? aVar3.a : null;
            final com.google.android.libraries.navigation.internal.ael.x xVarJ2 = j();
            final boolean zA = this.m.a().a();
            final com.google.android.libraries.navigation.internal.db.r rVar2 = (com.google.android.libraries.navigation.internal.db.r) Objects.requireNonNull(this.D);
            Logger logger = com.google.android.libraries.navigation.internal.zo.q.a;
            com.google.android.libraries.navigation.internal.zo.o oVar = new com.google.android.libraries.navigation.internal.zo.o();
            oVar.b(this.G);
            final boolean z11 = z7;
            com.google.android.libraries.navigation.internal.zo.q qVarA = oVar.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.sv.u
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return ak.D(this.a, rVar2, bgVar3, i3, xVarJ2, zA, z11, enumMap);
                }
            }, new com.google.android.libraries.navigation.internal.zo.b(), new v(this));
            this.v = qVarA;
            s(qVarA, this.D);
        }
    }

    public final void J(int i, com.google.android.libraries.navigation.internal.sx.as asVar) {
        com.google.android.libraries.geo.navcore.guidance.impl.h hVar = (com.google.android.libraries.geo.navcore.guidance.impl.h) com.google.android.libraries.geo.navcore.guidance.impl.j.a.q();
        com.google.android.libraries.geo.navcore.guidance.impl.aq aqVar = (com.google.android.libraries.geo.navcore.guidance.impl.aq) com.google.android.libraries.geo.navcore.guidance.impl.at.a.q();
        if (!aqVar.b.H()) {
            aqVar.v();
        }
        com.google.android.libraries.geo.navcore.guidance.impl.at atVar = (com.google.android.libraries.geo.navcore.guidance.impl.at) aqVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        atVar.c = i2;
        atVar.b |= 1;
        if (!hVar.b.H()) {
            hVar.v();
        }
        com.google.android.libraries.geo.navcore.guidance.impl.x xVar = this.e;
        com.google.android.libraries.geo.navcore.guidance.impl.j jVar = (com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.b;
        com.google.android.libraries.geo.navcore.guidance.impl.at atVar2 = (com.google.android.libraries.geo.navcore.guidance.impl.at) aqVar.t();
        atVar2.getClass();
        jVar.c = atVar2;
        jVar.b = 4;
        xVar.g((com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.t());
        try {
            this.p.n(i, g(), this.C);
        } catch (IllegalArgumentException unused) {
        }
        if (asVar != null) {
            asVar.a.ordinal();
        }
    }

    final boolean K(com.google.android.libraries.navigation.internal.bp.bh bhVar, boolean z, boolean z2, int i, com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.sc.f fVar;
        com.google.android.libraries.navigation.internal.yx.ar.k(bhVar.k());
        if (bhVar.f().R) {
            k kVar = this.J;
            kVar.e.clear();
            com.google.android.libraries.navigation.internal.ady.al alVar = bhVar.f().j;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationInternal.guideNewRoutes.createRouteGuider");
            int size = 0;
            for (int i2 = 0; i2 < bhVar.d(); i2++) {
                try {
                    com.google.android.libraries.navigation.internal.bp.bg bgVarE = bhVar.e(i2);
                    if (bgVarE.R && bgVarE.j == alVar) {
                        if (i2 == bhVar.a()) {
                            size = kVar.e.size();
                        }
                        kVar.e.add(new com.google.android.libraries.navigation.internal.sc.f(bgVarE, kVar.d, rVar, kVar.b));
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
            if (dVarB != null) {
                Trace.endSection();
            }
            fVar = (com.google.android.libraries.navigation.internal.sc.f) kVar.e.get(size);
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) k.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1595)).p("Attempting to navigate on a non-navigable route.");
            fVar = null;
        }
        if (fVar == null) {
            return false;
        }
        int iOrdinal = fVar.e.Q.ordinal();
        if (iOrdinal == 0) {
            long jA = this.c.a() - (this.c.f().toEpochMilli() - fVar.e.i.toEpochMilli());
            this.B = jA;
            this.U = jA;
        } else if (iOrdinal == 2) {
            long jA2 = this.c.a() - this.A;
            this.B = jA2;
            this.U = jA2;
        }
        return L(fVar, z, z2, i);
    }

    public final boolean L(com.google.android.libraries.navigation.internal.sc.f fVar, boolean z, boolean z2, int i) {
        com.google.android.libraries.navigation.internal.db.r rVarB;
        k kVar = this.J;
        if (kVar.f == fVar && this.u) {
            return false;
        }
        com.google.android.libraries.navigation.internal.bp.bg bgVar = fVar.e;
        kVar.f = fVar;
        this.u = true;
        if (bgVar.Q == com.google.android.libraries.navigation.internal.bp.bf.ONLINE) {
            k();
        }
        if (bgVar.Q != com.google.android.libraries.navigation.internal.bp.bf.REROUTING) {
            if (bgVar.j == com.google.android.libraries.navigation.internal.ady.al.DRIVE) {
                this.Y = bgVar;
            } else {
                this.Y = null;
            }
        }
        String str = bgVar.r;
        this.E = null;
        this.C = null;
        if (z2 || this.X) {
            ki kiVar = bgVar.g.a;
            this.W = (kiVar.b & 4194304) != 0 ? kiVar.u : null;
        }
        com.google.android.libraries.navigation.internal.tj.o oVarG = g();
        this.e.h(oVarG, i, true);
        if (this.D == null && (rVarB = this.O.b()) != null) {
            this.D = rVarB;
        }
        if (this.h.f165n) {
            this.p.j(oVarG, this.D);
        } else {
            this.p.g(oVarG, this.D, this.C);
        }
        com.google.android.libraries.navigation.internal.db.r rVar = this.D;
        if (rVar != null) {
            if (z) {
                this.s.a(fVar.k(rVar));
            }
            this.s.a(fVar.g());
        }
        this.f.c();
        this.f.d(this.d, bgVar, fVar.a());
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        com.google.android.libraries.navigation.internal.so.e eVar = cVar.c;
        if (eVar != null) {
            this.X = eVar.d;
            this.q.b = false;
        }
        ad adVar = new ad(this);
        this.Z = adVar;
        this.N.registerReceiver(adVar, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        af afVar = new af(this);
        this.aa = afVar;
        this.N.registerReceiver(afVar, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
        com.google.android.libraries.navigation.internal.ia.e eVar2 = this.d;
        fd fdVarK = fd.k(com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, this.G);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sw.l.class, new am(0, com.google.android.libraries.navigation.internal.sw.l.class, this, com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, am.b(com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.ss.d.class, new am(1, com.google.android.libraries.navigation.internal.ss.d.class, this, apVar, am.b(apVar, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar2 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.ss.f.class, new am(2, com.google.android.libraries.navigation.internal.ss.f.class, this, apVar2, am.b(apVar2, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar3 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.j.class, new am(3, com.google.android.libraries.navigation.internal.sw.j.class, this, apVar3, am.b(apVar3, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar4 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.m.class, new am(4, com.google.android.libraries.navigation.internal.sw.m.class, this, apVar4, am.b(apVar4, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar5 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.kp.g.class, new am(5, com.google.android.libraries.navigation.internal.kp.g.class, this, apVar5, am.b(apVar5, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar6 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.k.class, new am(6, com.google.android.libraries.navigation.internal.sw.k.class, this, apVar6, am.b(apVar6, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar7 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.g.class, new am(7, com.google.android.libraries.navigation.internal.sr.g.class, this, apVar7, am.b(apVar7, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar8 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.fn.a.class, new am(8, com.google.android.libraries.navigation.internal.fn.a.class, this, apVar8, am.b(apVar8, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar9 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.n.class, new am(9, com.google.android.libraries.navigation.internal.sw.n.class, this, apVar9, am.b(apVar9, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar10 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.bc.b.class, new am(10, com.google.android.libraries.navigation.internal.bc.b.class, this, apVar10, am.b(apVar10, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar11 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.c.class, new am(11, com.google.android.libraries.navigation.internal.sr.c.class, this, apVar11, am.b(apVar11, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar12 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.a.class, new am(12, com.google.android.libraries.navigation.internal.sw.a.class, this, apVar12, am.b(apVar12, fdVarK)));
        eVar2.c(this, fzVar.a());
        if (this.s.b()) {
            cg cgVar = this.s;
            cgVar.d.c(cgVar.e, cgVar.f);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        this.d.e(this);
        BroadcastReceiver broadcastReceiver = this.Z;
        if (broadcastReceiver != null) {
            this.N.unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.aa;
        if (broadcastReceiver2 != null) {
            this.N.unregisterReceiver(broadcastReceiver2);
        }
        this.j.removeCallbacks(this.k);
        y();
        com.google.android.libraries.geo.navcore.guidance.impl.x xVar = this.e;
        int i = com.google.android.libraries.geo.navcore.guidance.impl.v.a;
        com.google.android.libraries.geo.navcore.guidance.impl.h hVar = (com.google.android.libraries.geo.navcore.guidance.impl.h) com.google.android.libraries.geo.navcore.guidance.impl.j.a.q();
        com.google.android.libraries.geo.navcore.guidance.impl.t tVar = (com.google.android.libraries.geo.navcore.guidance.impl.t) com.google.android.libraries.geo.navcore.guidance.impl.w.a.q();
        if (!tVar.b.H()) {
            tVar.v();
        }
        com.google.android.libraries.geo.navcore.guidance.impl.w wVar = (com.google.android.libraries.geo.navcore.guidance.impl.w) tVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        wVar.c = i2;
        wVar.b |= 1;
        if (!hVar.b.H()) {
            hVar.v();
        }
        com.google.android.libraries.geo.navcore.guidance.impl.j jVar = (com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.b;
        com.google.android.libraries.geo.navcore.guidance.impl.w wVar2 = (com.google.android.libraries.geo.navcore.guidance.impl.w) tVar.t();
        wVar2.getClass();
        jVar.c = wVar2;
        jVar.b = 2;
        xVar.g((com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.t());
        if (this.s.b()) {
            cg cgVar = this.s;
            cgVar.d.d(cgVar.e);
        }
    }

    public final com.google.android.libraries.navigation.internal.tj.o g() {
        int i;
        k kVar = this.J;
        com.google.android.libraries.navigation.internal.bp.bg[] bgVarArr = new com.google.android.libraries.navigation.internal.bp.bg[kVar.e.size()];
        com.google.android.libraries.navigation.internal.se.b[] bVarArr = new com.google.android.libraries.navigation.internal.se.b[kVar.e.size()];
        int i2 = 0;
        while (true) {
            i = -1;
            if (i2 >= kVar.e.size()) {
                i2 = -1;
                break;
            }
            if (kVar.e.get(i2) == kVar.f) {
                break;
            }
            i2++;
        }
        for (int i3 = 0; i3 < kVar.e.size(); i3++) {
            bgVarArr[i3] = ((com.google.android.libraries.navigation.internal.sc.f) kVar.e.get(i3)).e;
            com.google.android.libraries.navigation.internal.sc.f fVar = (com.google.android.libraries.navigation.internal.sc.f) kVar.e.get(i3);
            if (fVar.b == null) {
                fVar.b = fVar.h(fVar.d.b());
            }
            bVarArr[i3] = fVar.b;
        }
        com.google.android.libraries.navigation.internal.sc.f fVar2 = kVar.f;
        long jA = Long.MAX_VALUE;
        if (fVar2 != null) {
            double d = fVar2.b.h;
            if (d < 9.223372036854776E18d) {
                jA = this.c.a() + ((long) (d * 1000.0d));
            }
        }
        com.google.android.libraries.navigation.internal.tj.n nVar = new com.google.android.libraries.navigation.internal.tj.n();
        nVar.a = com.google.android.libraries.navigation.internal.bp.bh.i(i2, bgVarArr);
        nVar.b = bVarArr;
        nVar.d = jA;
        aj ajVar = this.E;
        if (ajVar != null) {
            k kVar2 = this.J;
            for (int i4 = 0; i4 < kVar2.e.size(); i4++) {
                if (((com.google.android.libraries.navigation.internal.sc.f) kVar2.e.get(i4)).e == ajVar.a) {
                    i = i4;
                    break;
                }
            }
            nVar.c = i;
            nVar.e = ajVar.b;
        }
        return new com.google.android.libraries.navigation.internal.tj.o(nVar);
    }

    public final /* synthetic */ com.google.android.libraries.navigation.internal.aac.bj h(boolean z, com.google.android.libraries.navigation.internal.bp.bg bgVar, double d, com.google.android.libraries.navigation.internal.db.r rVar, com.google.android.libraries.navigation.internal.ael.x xVar, boolean z2, mj mjVar, com.google.android.libraries.navigation.internal.ady.n nVar, com.google.android.libraries.navigation.internal.adu.s sVar, boolean z3, boolean z4) {
        lt ltVarB = this.f579n.b(z);
        com.google.android.libraries.navigation.internal.sx.bb bbVar = this.o;
        bbVar.b(rVar, com.google.android.libraries.navigation.internal.sx.ay.d);
        com.google.android.libraries.navigation.internal.sx.av avVar = bbVar.a;
        if (!avVar.a()) {
            com.google.android.libraries.navigation.internal.sx.at atVar = avVar.c;
            com.google.android.libraries.navigation.internal.bu.b bVarA = atVar.e.a(bgVar.P, bgVar.j);
            bVarA.a = xVar;
            bVarA.c(bgVar.U, d);
            bVarA.b = nVar;
            lz lzVarD = atVar.d(atVar.a(rVar, bgVar, bVarA.a(), null, z2, atVar.c(), atVar.f).a(), mjVar, ltVarB);
            com.google.android.libraries.navigation.internal.sx.ab abVarA = atVar.d.a(null, ((com.google.android.libraries.navigation.internal.kk.n) atVar.c.a(com.google.android.libraries.navigation.internal.km.af.g)).a(), ((com.google.android.libraries.navigation.internal.kk.n) atVar.c.a(com.google.android.libraries.navigation.internal.km.af.h)).a());
            abVarA.f(lzVarD, false, z3, true);
            return abVarA.a();
        }
        com.google.android.libraries.navigation.internal.sx.b bVar = new com.google.android.libraries.navigation.internal.sx.b();
        bVar.a = bgVar;
        bVar.b = xVar;
        bVar.h = Double.valueOf(d);
        bVar.i = nVar;
        bVar.c = rVar;
        bVar.c(z2);
        bVar.d = ltVarB;
        bVar.j = mjVar;
        bVar.k = null;
        bVar.b(z3);
        bVar.o = Long.valueOf(com.google.android.libraries.navigation.internal.sx.av.b);
        return avVar.f.a(bVar.d());
    }

    public final com.google.android.libraries.navigation.internal.ady.al i() {
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        if (fVar == null) {
            return null;
        }
        return fVar.e.j;
    }

    public final com.google.android.libraries.navigation.internal.ael.x j() {
        this.q.c();
        return this.ad.d();
    }

    public final void k() {
        l();
        M();
    }

    public final void l() {
        com.google.android.libraries.navigation.internal.aac.bj bjVar = this.v;
        if (bjVar != null && !bjVar.isDone()) {
            bjVar.cancel(false);
        }
        com.google.android.libraries.navigation.internal.aac.bj bjVar2 = this.R;
        if (bjVar2 == null || bjVar2.isDone()) {
            return;
        }
        bjVar2.cancel(false);
    }

    public final void m(String str, cy cyVar) {
        int i = x.a;
    }

    public final void n(com.google.android.libraries.navigation.internal.sc.f fVar, final com.google.android.libraries.navigation.internal.ady.n nVar, final boolean z) {
        if (this.D != null) {
            com.google.android.libraries.navigation.internal.aac.bj bjVar = this.v;
            if (bjVar == null || bjVar.isDone()) {
                com.google.android.libraries.navigation.internal.aac.bj bjVar2 = this.R;
                if ((bjVar2 == null || bjVar2.isDone()) && fVar.c && fVar.e.X()) {
                    final boolean z2 = fVar.e.Q == com.google.android.libraries.navigation.internal.bp.bf.OFFLINE;
                    final mj mjVar = z2 ? com.google.android.libraries.navigation.internal.sx.at.b : com.google.android.libraries.navigation.internal.sx.at.a;
                    com.google.android.libraries.navigation.internal.ady.al alVar = fVar.e.j;
                    com.google.android.libraries.navigation.internal.oe.ag agVarF = fVar.f();
                    if (agVarF != null) {
                        com.google.android.libraries.navigation.internal.db.q qVarJ = com.google.android.libraries.navigation.internal.db.r.j(this.D);
                        com.google.android.libraries.navigation.internal.oe.x xVar = agVarF.a;
                        qVarJ.s(xVar.b(), xVar.d());
                        qVarJ.g = (float) agVarF.b;
                        com.google.android.libraries.navigation.internal.db.r rVarA = qVarJ.a();
                        this.D = rVarA;
                        this.d.a(new com.google.android.libraries.navigation.internal.db.ah(new com.google.android.libraries.navigation.internal.db.ag(rVarA)));
                    } else {
                        this.d.a(new com.google.android.libraries.navigation.internal.db.ah(null));
                    }
                    final com.google.android.libraries.navigation.internal.bp.bg bgVar = fVar.e;
                    final double dA = fVar.f() == null ? -1.0d : fVar.a() - ((double) fVar.e.V);
                    final com.google.android.libraries.navigation.internal.ael.x xVarJ = j();
                    final boolean zA = this.m.a().a();
                    final com.google.android.libraries.navigation.internal.db.r rVar = (com.google.android.libraries.navigation.internal.db.r) Objects.requireNonNull(this.D);
                    Logger logger = com.google.android.libraries.navigation.internal.zo.q.a;
                    com.google.android.libraries.navigation.internal.zo.o oVar = new com.google.android.libraries.navigation.internal.zo.o();
                    oVar.b(this.G);
                    final com.google.android.libraries.navigation.internal.adu.s sVar = null;
                    final boolean z3 = false;
                    com.google.android.libraries.navigation.internal.zo.q qVarA = oVar.a(new com.google.android.libraries.navigation.internal.yx.br(z2, bgVar, dA, rVar, xVarJ, zA, mjVar, nVar, sVar, z, z3) { // from class: com.google.android.libraries.navigation.internal.sv.w
                        public final /* synthetic */ boolean b;
                        public final /* synthetic */ com.google.android.libraries.navigation.internal.bp.bg c;
                        public final /* synthetic */ double d;
                        public final /* synthetic */ com.google.android.libraries.navigation.internal.db.r e;
                        public final /* synthetic */ com.google.android.libraries.navigation.internal.ael.x f;
                        public final /* synthetic */ boolean g;
                        public final /* synthetic */ mj h;
                        public final /* synthetic */ com.google.android.libraries.navigation.internal.ady.n i;
                        public final /* synthetic */ boolean k;
                        public final /* synthetic */ com.google.android.libraries.navigation.internal.adu.s j = null;
                        public final /* synthetic */ boolean l = false;

                        {
                            this.k = z;
                        }

                        @Override // com.google.android.libraries.navigation.internal.yx.br
                        public final Object a() {
                            return this.a.h(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null, this.k, false);
                        }
                    }, new com.google.android.libraries.navigation.internal.zo.b(), new v(this));
                    this.R = qVarA;
                    com.google.android.libraries.navigation.internal.aac.az.o(qVarA, new ai(this, bgVar), this.G);
                    this.U = this.c.a();
                }
            }
        }
    }

    public final void o(com.google.android.libraries.navigation.internal.ady.n nVar) {
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        if (this.D == null || fVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.ady.m mVar = nVar.d;
        if (mVar == null) {
            mVar = com.google.android.libraries.navigation.internal.ady.m.a;
        }
        if (mVar.c || nVar.c.size() != 0) {
            n(fVar, nVar, false);
        }
    }

    public final void p() {
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        if (fVar == null || this.c.a() - this.U < this.A) {
            return;
        }
        n(fVar, null, false);
    }

    public final void q(jg jgVar, long j) {
        jg jgVarC = this.ad.c(jgVar, j);
        if (jgVarC != null) {
            g gVar = this.P;
            com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
            if (gVar.f.m()) {
                com.google.android.libraries.navigation.internal.tj.o oVarD = gVar.f.d();
                com.google.android.libraries.navigation.internal.yx.ar.q(oVarD);
                gVar.e.a(new com.google.android.libraries.navigation.internal.tj.ag(jgVarC, oVarD.a, j));
            }
        }
    }

    public final void r(com.google.android.libraries.navigation.internal.sx.as asVar, com.google.android.libraries.navigation.internal.fw.g gVar) {
        if (this.J.f == null || O(asVar) || gVar == com.google.android.libraries.navigation.internal.fw.g.SINGLE_REQUEST_FATAL_ERROR) {
            return;
        }
        this.w = true;
    }

    public final void s(com.google.android.libraries.navigation.internal.aac.bj bjVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.aac.az.o(bjVar, new ah(this, this.V.a(com.google.android.libraries.navigation.internal.abx.b.NAVIGATION_REROUTE_REQUEST), rVar), this.G);
    }

    public final void t(com.google.android.libraries.navigation.internal.vn.b bVar, String str) {
        ((com.google.android.libraries.navigation.internal.sl.d) this.M.a()).i(new com.google.android.libraries.navigation.internal.vn.d(com.google.android.libraries.navigation.internal.yx.aq.c(str) ? com.google.android.libraries.navigation.internal.vn.c.PREROLL_SOUND_ONLY : com.google.android.libraries.navigation.internal.vn.c.OTHER, null, str, null, null, com.google.android.libraries.navigation.internal.vn.d.a(bVar)), com.google.android.libraries.navigation.internal.sl.h.f, null);
    }

    public final void u(com.google.android.libraries.navigation.internal.sx.as asVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.db.r rVar2;
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        if (fVar == null) {
            return;
        }
        O(asVar);
        fVar.c();
        if (asVar.b()) {
            M();
            com.google.android.libraries.navigation.internal.bp.bh bhVarJ = asVar.b;
            Iterator it2 = bhVarJ.iterator();
            while (it2.hasNext()) {
                String str = ((com.google.android.libraries.navigation.internal.bp.bg) it2.next()).r;
            }
            boolean z = false;
            if (!bhVarJ.k()) {
                bhVarJ = bhVarJ.j(0);
            }
            com.google.android.libraries.navigation.internal.bp.bh bhVar = bhVarJ;
            com.google.android.libraries.navigation.internal.bp.bg bgVar = fVar.e;
            com.google.android.libraries.navigation.internal.bp.bg bgVarF = bhVar.f();
            if (bgVar.Q == com.google.android.libraries.navigation.internal.bp.bf.REROUTING && bgVarF.Q != com.google.android.libraries.navigation.internal.bp.bf.REROUTING) {
                z = true;
            }
            if (K(bhVar, z, false, com.google.android.libraries.navigation.internal.rw.z.a, rVar) && this.h.f165n && (rVar2 = this.D) != null) {
                w(rVar2);
            }
        } else {
            J(com.google.android.libraries.geo.navcore.guidance.impl.as.a, asVar);
        }
        com.google.android.libraries.navigation.internal.sc.f fVar2 = this.J.f;
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar2);
        fVar2.c();
        this.F = null;
    }

    /* JADX WARN: Code duplicated, block: B:194:0x0452  */
    public final void v(com.google.android.libraries.navigation.internal.sx.as asVar, com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        com.google.android.libraries.navigation.internal.db.r rVar;
        boolean zB;
        int i;
        com.google.android.libraries.navigation.internal.db.r rVar2;
        com.google.android.libraries.navigation.internal.sc.f fVar = this.J.f;
        if (fVar != null && fVar.e == bgVar && asVar.b() && this.D != null) {
            com.google.android.libraries.navigation.internal.bp.af afVar = asVar.c;
            com.google.android.libraries.navigation.internal.yx.ar.q(afVar);
            ku kuVar = afVar.b.j;
            if (kuVar == null) {
                kuVar = ku.a;
            }
            ku kuVar2 = kuVar;
            com.google.android.libraries.navigation.internal.yx.ar.q(kuVar2);
            com.google.android.libraries.navigation.internal.bp.bh bhVar = asVar.b;
            com.google.android.libraries.navigation.internal.bp.bg bgVar2 = fVar.e;
            com.google.android.libraries.navigation.internal.bp.bf bfVar = com.google.android.libraries.navigation.internal.bp.bf.OFFLINE;
            boolean z = false;
            boolean z2 = bhVar.k() && bhVar.f().Q == com.google.android.libraries.navigation.internal.bp.bf.OFFLINE;
            fVar.e.q.isEmpty();
            if (!z2 && bhVar.k() && !bhVar.f().W.equals(bgVar.W)) {
                com.google.android.libraries.navigation.internal.bp.bg bgVar3 = fVar.e;
                com.google.android.libraries.navigation.internal.bp.bg bgVarF = bhVar.f();
                bgVar3.W.clear();
                bgVar3.W.addAll(bgVarF.W);
            }
            if (bgVar2.Q == bfVar && !z2) {
                int iA = kt.a(kuVar2.c);
                if (iA == 0) {
                    iA = kt.b;
                }
                int iC = c(bhVar);
                if (iA == 0) {
                    throw null;
                }
                if (iA != 1) {
                    if (iA != 3) {
                        if (bhVar.e(0).E == null) {
                            this.P.d(true);
                        }
                    } else if (iC < 0 || iC >= bhVar.d()) {
                    }
                    iC = 0;
                } else {
                    if (iC < 0 || iC >= bhVar.d()) {
                        iC = 0;
                    }
                    if (bhVar.e(iC).E == null) {
                        this.P.d(false);
                    }
                }
                zB = K(bhVar.j(iC), true, false, com.google.android.libraries.navigation.internal.rw.z.a, null);
                i = 0;
            } else {
                if (z2) {
                    N(fVar, bhVar.f());
                    return;
                }
                int iA2 = kt.a(kuVar2.c);
                if (iA2 == 0) {
                    iA2 = kt.b;
                }
                if (iA2 == kt.b) {
                    H(null, false, true, true);
                } else {
                    int iC2 = c(bhVar);
                    if (iC2 == -1) {
                        ((com.google.android.libraries.navigation.internal.zb.h) L.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1664)).p("Server did not mark any routes as being reconstructed.");
                    } else {
                        com.google.android.libraries.navigation.internal.bp.bg bgVarE = bhVar.e(iC2);
                        if (kuVar2.e) {
                            com.google.android.libraries.navigation.internal.bp.bg bgVar4 = fVar.e;
                            bgVar4.i = bgVarE.i;
                            synchronized (bgVar4.S) {
                                int i2 = bgVar4.J - bgVarE.J;
                                if (i2 >= 0) {
                                    if (((lv) bgVarE.I).c != ((lv) bgVar4.I).c) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.bp.bg.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalStateException(String.format(Locale.US, "Reconstructed route has %d destinations, but current route has %d", Integer.valueOf(((lv) bgVarE.I).c), Integer.valueOf(((lv) bgVar4.I).c))))).F(72)).o();
                                    }
                                    bgVar4.I = bgVarE.I;
                                    ii iiVar = bgVarE.u;
                                    if (iiVar != null) {
                                        ig igVar = (ig) ii.a.r(iiVar);
                                        if (!igVar.b.H()) {
                                            igVar.v();
                                        }
                                        ((ii) igVar.b).c = dj.b;
                                        if (!igVar.b.H()) {
                                            igVar.v();
                                        }
                                        ((ii) igVar.b).f = dj.b;
                                        if (!igVar.b.H()) {
                                            igVar.v();
                                        }
                                        ((ii) igVar.b).g = dj.b;
                                        if (!igVar.b.H()) {
                                            igVar.v();
                                        }
                                        ii iiVar2 = (ii) igVar.b;
                                        iiVar2.j = null;
                                        iiVar2.b &= -17;
                                        for (com.google.android.libraries.navigation.internal.adr.gv gvVar : iiVar.c) {
                                            gs gsVar = (gs) com.google.android.libraries.navigation.internal.adr.gv.a.r(gvVar);
                                            int i3 = gvVar.c + i2;
                                            if (!gsVar.b.H()) {
                                                gsVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.adr.gv gvVar2 = (com.google.android.libraries.navigation.internal.adr.gv) gsVar.b;
                                            gvVar2.b |= 1;
                                            gvVar2.c = i3;
                                            igVar.d(gsVar);
                                        }
                                        io ioVar = iiVar.j;
                                        if (ioVar == null) {
                                            ioVar = io.a;
                                        }
                                        ij ijVar = (ij) io.a.q();
                                        for (in inVar : ioVar.b) {
                                            ik ikVar = (ik) in.a.r(inVar);
                                            int i4 = inVar.d + i2;
                                            if (!ikVar.b.H()) {
                                                ikVar.v();
                                            }
                                            in inVar2 = (in) ikVar.b;
                                            inVar2.b |= 2;
                                            inVar2.d = i4;
                                            if (!ijVar.b.H()) {
                                                ijVar.v();
                                            }
                                            io ioVar2 = (io) ijVar.b;
                                            in inVar3 = (in) ikVar.t();
                                            inVar3.getClass();
                                            com.google.android.libraries.navigation.internal.ael.bz bzVar = ioVar2.b;
                                            if (!bzVar.c()) {
                                                ioVar2.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                            }
                                            ioVar2.b.add(inVar3);
                                        }
                                        io ioVar3 = (io) ijVar.t();
                                        if (!igVar.b.H()) {
                                            igVar.v();
                                        }
                                        ii iiVar3 = (ii) igVar.b;
                                        ioVar3.getClass();
                                        iiVar3.j = ioVar3;
                                        iiVar3.b |= 16;
                                        Iterator it2 = iiVar.f.iterator();
                                        while (it2.hasNext()) {
                                            dx dxVarD = com.google.android.libraries.navigation.internal.bp.bg.D((el) it2.next(), i2);
                                            if (!igVar.b.H()) {
                                                igVar.v();
                                            }
                                            ii iiVar4 = (ii) igVar.b;
                                            el elVarT = dxVarD.t();
                                            elVarT.getClass();
                                            com.google.android.libraries.navigation.internal.ael.bz bzVar2 = iiVar4.f;
                                            if (!bzVar2.c()) {
                                                iiVar4.f = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                            }
                                            iiVar4.f.add(elVarT);
                                        }
                                        Iterator it3 = iiVar.g.iterator();
                                        while (it3.hasNext()) {
                                            dx dxVarD2 = com.google.android.libraries.navigation.internal.bp.bg.D((el) it3.next(), i2);
                                            if (!igVar.b.H()) {
                                                igVar.v();
                                            }
                                            ii iiVar5 = (ii) igVar.b;
                                            el elVarT2 = dxVarD2.t();
                                            elVarT2.getClass();
                                            com.google.android.libraries.navigation.internal.ael.bz bzVar3 = iiVar5.g;
                                            if (!bzVar3.c()) {
                                                iiVar5.g = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar3);
                                            }
                                            iiVar5.g.add(elVarT2);
                                        }
                                        bgVar4.R((ii) igVar.t(), i2);
                                    }
                                    ll llVar = bgVarE.d.c;
                                    if (llVar == null) {
                                        llVar = ll.a;
                                    }
                                    bgVar4.Q(llVar.e, bgVarE.f, bgVarE.g.h(), com.google.android.libraries.navigation.internal.bp.bg.o(bgVarE.d), true);
                                    jg jgVar = bgVarE.E;
                                    if (jgVar != null) {
                                        bgVar4.E = com.google.android.libraries.navigation.internal.bp.bg.F(jgVar, i2);
                                    } else {
                                        bgVar4.E = null;
                                    }
                                    bgVar4.U = bgVarE.U;
                                    bgVar4.V = i2;
                                }
                            }
                            bgVar4.h = bgVarE.h;
                            bgVar4.x = bgVarE.x;
                            bgVar4.y = bgVarE.y;
                            N(fVar, bgVarE);
                            ii iiVar6 = fVar.e.u;
                            if (iiVar6 == null) {
                                fVar.d.e(null, -1, -1);
                            } else {
                                fVar.d.e(iiVar6, fVar.e.m(), fVar.e.i());
                            }
                            fVar.b = fVar.h(fVar.d.b());
                            this.e.f(g());
                            z = true;
                        } else if (K(bhVar.j(iC2), true, false, com.google.android.libraries.navigation.internal.rw.z.d, null) && this.h.f165n && (rVar = this.D) != null) {
                            w(rVar);
                        }
                    }
                }
                k kVar = this.J;
                com.google.android.libraries.navigation.internal.db.r rVar3 = this.D;
                com.google.android.libraries.navigation.internal.sc.f fVar2 = kVar.f;
                com.google.android.libraries.navigation.internal.yx.ar.q(fVar2);
                if (!fVar2.c || fVar2.i() || bhVar.l()) {
                    zB = z;
                } else {
                    com.google.android.libraries.navigation.internal.bp.bg bgVar5 = fVar2.e;
                    kVar.e.clear();
                    kVar.e.add(fVar2);
                    String str = bgVar5.r;
                    com.google.android.libraries.navigation.internal.oe.x xVarN = rVar3.n();
                    int iA3 = kt.a(kuVar2.c);
                    if (iA3 == 0) {
                        iA3 = kt.b;
                    }
                    int i5 = kt.c;
                    int i6 = 0;
                    boolean z3 = false;
                    while (i6 < bhVar.d()) {
                        com.google.android.libraries.navigation.internal.bp.bg bgVarE2 = bhVar.e(i6);
                        if (bgVarE2.j() != 0) {
                            if (bgVarE2.W()) {
                                String str2 = bgVarE2.r;
                            } else {
                                if (iA3 == i5 && i6 == 0) {
                                    String str3 = bgVarE2.r;
                                    i6 = 0;
                                } else if (com.google.android.libraries.navigation.internal.bw.b.b(bgVar5, bgVarE2, xVarN)) {
                                    String str4 = bgVarE2.r;
                                } else {
                                    String str5 = bgVarE2.r;
                                }
                                kVar.e.add(new com.google.android.libraries.navigation.internal.sc.f(bgVarE2, kVar.d, null, kVar.b));
                                z3 = true;
                            }
                        }
                        i6++;
                    }
                    if (z3) {
                        com.google.android.libraries.navigation.internal.tj.o oVarG = g();
                        this.e.h(oVarG, com.google.android.libraries.navigation.internal.rw.z.e, false);
                        if (this.h.f165n) {
                            zB = true;
                        } else {
                            this.p.l(oVarG, this.C, null);
                            zB = z;
                        }
                    } else {
                        zB = z;
                    }
                }
                i = 0;
            }
            int iA4 = lq.a(bhVar.e(i).P.m);
            if (iA4 == 0) {
                iA4 = lq.b;
            }
            if (iA4 != lq.c) {
                int iA5 = lq.a(bhVar.e(i).P.m);
                if (iA5 == 0) {
                    iA5 = lq.b;
                }
                if (iA5 != lq.d) {
                    zB |= B(bhVar.e(i), kuVar2);
                }
            }
            if (zB && this.h.f165n && (rVar2 = this.D) != null) {
                w(rVar2);
            }
            long jA = this.c.a();
            this.B = jA;
            this.U = jA;
            this.A = e(this.r, this.g);
        }
    }

    public final void w(com.google.android.libraries.navigation.internal.db.r rVar) {
        cg cgVar = this.s;
        com.google.android.libraries.navigation.internal.sc.d dVarA = this.J.a(rVar);
        cgVar.a(dVarA);
        this.p.l(g(), dVarA.b(), dVarA.a());
    }

    public final void x(com.google.android.libraries.navigation.internal.bp.bh bhVar, com.google.android.libraries.navigation.internal.ael.x xVar, boolean z) {
        com.google.android.libraries.navigation.internal.db.r rVar;
        az azVar = (az) ba.a.q();
        ev evVarI = I(bhVar);
        if (!azVar.b.H()) {
            azVar.v();
        }
        ba baVar = (ba) azVar.b;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = baVar.b;
        if (!bzVar.c()) {
            baVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(evVarI, baVar.b);
        com.google.android.libraries.navigation.internal.ael.x xVar2 = com.google.android.libraries.navigation.internal.ael.x.b;
        if (!azVar.b.H()) {
            azVar.v();
        }
        ba baVar2 = (ba) azVar.b;
        xVar2.getClass();
        baVar2.c = xVar2;
        if (!azVar.b.H()) {
            azVar.v();
        }
        ((ba) azVar.b).d = z;
        m("com.google.android.libraries.geo.navcore.service.guider.StartNavigatingProto", azVar.t());
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationInternal.startNavigating");
        try {
            com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
            bhVar.f();
            this.ad.e();
            if (K(bhVar, false, z, com.google.android.libraries.navigation.internal.rw.z.a, null) && this.h.f165n && (rVar = this.D) != null) {
                w(rVar);
            }
            this.d.a(new com.google.android.libraries.navigation.internal.db.ah(null));
            com.google.android.libraries.geo.navcore.guidance.impl.x xVar3 = this.e;
            com.google.android.libraries.geo.navcore.guidance.impl.h hVar = (com.google.android.libraries.geo.navcore.guidance.impl.h) com.google.android.libraries.geo.navcore.guidance.impl.j.a.q();
            com.google.android.libraries.geo.navcore.guidance.impl.r rVar2 = (com.google.android.libraries.geo.navcore.guidance.impl.r) com.google.android.libraries.geo.navcore.guidance.impl.s.a.q();
            com.google.android.libraries.geo.navcore.guidance.impl.ak akVar = (com.google.android.libraries.geo.navcore.guidance.impl.ak) com.google.android.libraries.geo.navcore.guidance.impl.al.a.q();
            if (!rVar2.b.H()) {
                rVar2.v();
            }
            com.google.android.libraries.geo.navcore.guidance.impl.s sVar = (com.google.android.libraries.geo.navcore.guidance.impl.s) rVar2.b;
            com.google.android.libraries.geo.navcore.guidance.impl.al alVar = (com.google.android.libraries.geo.navcore.guidance.impl.al) akVar.t();
            alVar.getClass();
            sVar.c = alVar;
            sVar.b |= 1;
            if (!hVar.b.H()) {
                hVar.v();
            }
            com.google.android.libraries.geo.navcore.guidance.impl.j jVar = (com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.b;
            com.google.android.libraries.geo.navcore.guidance.impl.s sVar2 = (com.google.android.libraries.geo.navcore.guidance.impl.s) rVar2.t();
            sVar2.getClass();
            jVar.c = sVar2;
            jVar.b = 1;
            xVar3.g((com.google.android.libraries.geo.navcore.guidance.impl.j) hVar.t());
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

    public final void y() {
        bb bbVar = (bb) bc.a.q();
        boolean z = this.u;
        if (!bbVar.b.H()) {
            bbVar.v();
        }
        ((bc) bbVar.b).b = z;
        m("com.google.android.libraries.geo.navcore.service.guider.StopNavigatingProto", bbVar.t());
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        k();
        this.d.a(new com.google.android.libraries.navigation.internal.db.ah(null));
        if (this.u) {
            cg cgVar = this.s;
            cgVar.b = -1L;
            cgVar.a = -1;
            cgVar.c = Optional.empty();
            k kVar = this.J;
            kVar.f = null;
            kVar.e.clear();
            this.u = false;
        }
    }

    public final boolean z() {
        return this.r.y(com.google.android.libraries.navigation.internal.iv.ab.aM, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N(com.google.android.libraries.navigation.internal.sc.f fVar, com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        com.google.android.libraries.navigation.internal.bp.bg bgVar2 = fVar.e;
        if (bgVar2.g.b() == bgVar.g.b()) {
            for (int i = 0; i < bgVar.g.b(); i++) {
                bgVar2.g.c(i).c = bgVar.g.c(i).c;
            }
        }
        if (bgVar2.g.b() == bgVar.g.b()) {
            for (int i2 = 0; i2 < bgVar.g.b(); i2++) {
                bgVar2.g.c(i2).d = bgVar.g.c(i2).d;
            }
        }
        eq eqVar = new eq();
        if (bgVar2.p.size() == bgVar.p.size()) {
            for (int i3 = 0; i3 < bgVar2.p.size(); i3++) {
                if (com.google.android.libraries.navigation.internal.yx.am.a(((ck) bgVar2.p.get(i3)).S(), ((ck) bgVar.p.get(i3)).S())) {
                    eqVar.h((ck) bgVar2.p.get(i3));
                } else {
                    eqVar.h(((ck) bgVar2.p.get(i3)).c().x(((ck) bgVar.p.get(i3)).S()).y(((ck) bgVar.p.get(i3)).P()).B());
                }
            }
            bgVar2.p = eqVar.g();
        }
        this.c.a();
    }
}
