package com.google.android.libraries.navigation.internal.bm;

import android.content.Context;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.environment.ct;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ace.bm;
import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.adr.ib;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.ik;
import com.google.android.libraries.navigation.internal.adr.in;
import com.google.android.libraries.navigation.internal.adr.jk;
import com.google.android.libraries.navigation.internal.adr.kh;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.adr.kk;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.by;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bk;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bt;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.ck.be;
import com.google.android.libraries.navigation.internal.ck.bf;
import com.google.android.libraries.navigation.internal.ck.bi;
import com.google.android.libraries.navigation.internal.ck.cc;
import com.google.android.libraries.navigation.internal.ck.ce;
import com.google.android.libraries.navigation.internal.ck.cl;
import com.google.android.libraries.navigation.internal.ck.cm;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class am implements com.google.android.libraries.navigation.internal.rw.c, com.google.android.libraries.navigation.internal.rw.r, com.google.android.libraries.navigation.internal.cn.v, com.google.android.libraries.navigation.internal.rr.d, com.google.android.libraries.navigation.internal.rr.c {
    public static final /* synthetic */ int an = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j ao = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bm.am");
    private static final fy ap = fy.q(bm.ENABLED, bm.COUNTERFACTUAL);
    public final cl C;
    public final com.google.android.libraries.navigation.internal.jy.af D;
    public final com.google.android.libraries.navigation.internal.jy.t E;
    public final com.google.android.libraries.navigation.internal.ed.b F;
    public bk G;
    public Boolean H;
    public final boolean I;
    public final com.google.android.libraries.navigation.internal.afo.a J;
    public com.google.android.libraries.navigation.internal.db.s L;
    public com.google.android.libraries.navigation.internal.bq.a M;
    public com.google.android.libraries.navigation.internal.acg.l N;
    public int Q;
    public ak Y;
    public final com.google.android.libraries.navigation.internal.ni.a a;
    public final com.google.android.libraries.navigation.internal.rw.q aa;
    public final com.google.android.libraries.navigation.internal.hf.c ab;
    public final ev ac;
    public final com.google.android.libraries.navigation.internal.dx.i ad;
    public final com.google.android.libraries.navigation.internal.cn.o ae;
    public final com.google.android.libraries.navigation.internal.op.i af;
    public final com.google.android.libraries.navigation.internal.qk.w ag;
    public com.google.android.libraries.navigation.internal.rw.p ah;
    public final com.google.android.libraries.navigation.internal.ci.a ai;
    public final com.google.android.libraries.navigation.internal.cr.f aj;
    public final com.google.android.libraries.geo.navcore.decoration.impl.b ak;
    public final com.google.android.libraries.navigation.internal.ba.b al;
    public final ct am;
    private final com.google.android.libraries.navigation.internal.yx.an aq;
    private final com.google.android.libraries.navigation.internal.og.b ar;
    private final com.google.android.libraries.navigation.internal.oq.d as;
    private final com.google.android.libraries.navigation.internal.ck.ar at;
    private final com.google.android.libraries.navigation.internal.bf.d av;
    public final com.google.android.libraries.navigation.internal.bn.d b;
    public final com.google.android.libraries.navigation.internal.pi.s c;
    public final com.google.android.libraries.navigation.internal.rw.f d;
    public final com.google.android.libraries.navigation.internal.ia.e e;
    public final Executor f;
    public final bn g;
    public final com.google.android.libraries.navigation.internal.hx.ag h;
    public final com.google.android.libraries.navigation.internal.oa.k i;
    public final com.google.android.libraries.navigation.internal.oo.b j;
    public final com.google.android.libraries.navigation.internal.s.b k;
    public final Context l;
    public final com.google.android.libraries.navigation.internal.up.g m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.fz.d f345n;
    public final com.google.android.libraries.navigation.internal.hn.r o;
    public final com.google.android.libraries.navigation.internal.rr.a p;
    public final com.google.android.libraries.navigation.internal.afo.a q;
    public final com.google.android.libraries.navigation.internal.afo.a r;
    public final com.google.android.libraries.navigation.internal.iv.f s;
    public final boolean t;
    public final com.google.android.libraries.navigation.internal.afo.a u;
    public final com.google.android.libraries.navigation.internal.afo.a v;
    public final com.google.android.libraries.navigation.internal.afo.a w;
    public final com.google.android.libraries.navigation.internal.mj.a x;
    public final br z;
    public final List A = new ArrayList();
    public final List B = new ArrayList();
    public com.google.android.libraries.navigation.internal.sg.a K = com.google.android.libraries.navigation.internal.sg.a.a;
    public Map O = new HashMap();
    public ev P = lv.a;
    private com.google.android.libraries.navigation.internal.yx.an au = com.google.android.libraries.navigation.internal.yx.a.a;
    public final Map R = new HashMap();
    public final ConcurrentHashMap S = new ConcurrentHashMap();
    public final AtomicBoolean T = new AtomicBoolean(false);
    public final Object U = new Object();
    public final an V = new an();
    public final com.google.android.libraries.navigation.internal.nt.t W = new ab(this);
    public final Object X = new Object();
    public volatile boolean Z = false;
    public final boolean y = false;

    /* JADX INFO: compiled from: PG */
    final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public am(com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.bn.d dVar, com.google.android.libraries.navigation.internal.ci.a aVar2, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.ia.e eVar, Executor executor, bn bnVar, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.oo.b bVar, com.google.android.libraries.navigation.internal.qk.w wVar, com.google.android.libraries.navigation.internal.cr.f fVar2, com.google.android.libraries.navigation.internal.s.b bVar2, Context context, com.google.android.libraries.navigation.internal.up.g gVar, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.ck.ar arVar, cl clVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, com.google.android.libraries.navigation.internal.ed.b bVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.mj.a aVar5, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.geo.navcore.decoration.impl.b bVar4, com.google.android.libraries.navigation.internal.rr.a aVar6, com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.iv.f fVar3, com.google.android.libraries.navigation.internal.rw.q qVar, ct ctVar, com.google.android.libraries.navigation.internal.bf.d dVar3, com.google.android.libraries.navigation.internal.ba.b bVar5, com.google.android.libraries.navigation.internal.hf.c cVar, ev evVar, com.google.android.libraries.navigation.internal.dx.i iVar, com.google.android.libraries.navigation.internal.cn.o oVar, com.google.android.libraries.navigation.internal.og.b bVar6, com.google.android.libraries.navigation.internal.afo.a aVar7, com.google.android.libraries.navigation.internal.afo.a aVar8, com.google.android.libraries.navigation.internal.afo.a aVar9, com.google.android.libraries.navigation.internal.afo.a aVar10, br brVar) {
        this.ah = com.google.android.libraries.navigation.internal.rw.p.OFF;
        this.a = aVar;
        this.b = dVar;
        this.ai = aVar2;
        this.c = sVar;
        this.d = fVar;
        this.e = eVar;
        this.f = executor;
        this.g = bnVar;
        this.h = new com.google.android.libraries.navigation.internal.hx.ag(bnVar);
        this.i = kVar;
        this.j = bVar;
        this.ag = wVar;
        this.aj = fVar2;
        this.k = bVar2;
        this.l = context;
        this.m = gVar;
        this.v = aVar3;
        this.at = arVar;
        this.C = clVar;
        this.D = afVar;
        this.E = tVar;
        this.F = bVar3;
        this.as = bVar.h();
        this.o = rVar;
        this.w = aVar4;
        this.x = aVar5;
        this.f345n = dVar2;
        this.s = fVar3;
        this.aa = qVar;
        this.am = ctVar;
        this.av = dVar3;
        this.al = bVar5;
        this.ab = cVar;
        this.ac = evVar;
        this.ad = iVar;
        this.ae = oVar;
        this.af = bVar.g();
        this.ak = bVar4;
        this.p = aVar6;
        this.aq = anVar;
        this.z = brVar;
        kVar.k.i();
        this.I = false;
        this.ah = fVar.b();
        ap.contains(dVar2.j().a());
        this.t = kVar.k.i();
        this.ar = bVar6;
        this.q = null;
        this.r = aVar9;
        this.u = aVar10;
        this.J = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.google.android.libraries.navigation.internal.cq.ag c(long j, ev evVar) {
        int i = 0;
        while (i < ((lv) evVar).c) {
            com.google.android.libraries.navigation.internal.cq.ag agVar = (com.google.android.libraries.navigation.internal.cq.ag) evVar.get(i);
            i++;
            if (agVar.a() == j) {
                return agVar;
            }
        }
        return null;
    }

    public static ev d(bh bhVar, final bg bgVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.dx.i iVar) {
        if (!bhVar.k()) {
            int i = ev.d;
            return lv.a;
        }
        bg bgVarF = bhVar.f();
        ii iiVar = bgVarF.u;
        if (iiVar == null) {
            int i2 = ev.d;
            return lv.a;
        }
        if (bgVar != bgVarF) {
            if (bgVar.p() != 0) {
                return de.d(iiVar.h).c(new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.bm.q
                    @Override // com.google.android.libraries.navigation.internal.yx.as
                    public final boolean a(Object obj) {
                        el elVar = (el) obj;
                        int i3 = am.an;
                        fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
                        if (fgVar == null) {
                            fgVar = fg.a;
                        }
                        return (fgVar.c == 4 ? (ex) fgVar.d : ex.a).e == bgVar.p();
                    }
                }).f();
            }
            int i3 = ev.d;
            return lv.a;
        }
        int i4 = ev.d;
        eq eqVar = new eq();
        for (el elVar : iiVar.g) {
            Cdo cdoB = Cdo.b(elVar.u);
            if (cdoB == null) {
                cdoB = Cdo.INCIDENT_OTHER;
            }
            if (cdoB != Cdo.INCIDENT_POLICE_PRESENCE) {
                Cdo cdoB2 = Cdo.b(elVar.u);
                if (cdoB2 == null) {
                    cdoB2 = Cdo.INCIDENT_OTHER;
                }
                if (cdoB2 != Cdo.INCIDENT_MOBILE_SPEED_CAMERA) {
                    eqVar.h(elVar);
                }
            }
            com.google.android.libraries.navigation.internal.dx.a aVar = iVar.c;
        }
        if (dVar.D().b) {
            eqVar.j(iiVar.i);
        }
        return eqVar.g();
    }

    private final com.google.android.libraries.navigation.internal.ady.al s() {
        com.google.android.libraries.navigation.internal.bt.h hVarB = b();
        if (hVarB != null) {
            return ((com.google.android.libraries.navigation.internal.bt.b) hVarB).a.c();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.libraries.navigation.internal.pc.e, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void t() {
        if (this.au.g()) {
            com.google.android.libraries.navigation.internal.cl.aj ajVar = ((com.google.android.libraries.navigation.internal.cp.o) this.au.c()).b;
            if (ajVar != null) {
                ajVar.n();
            }
            ((com.google.android.libraries.navigation.internal.cp.o) this.au.c()).a = null;
            this.ar.b(this.au.c());
        }
    }

    private final void u(final Future future, final String str, final int i) {
        this.g.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.t
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.hx.ap.BACKGROUND_THREADPOOL.f();
                if (future.isDone()) {
                    return;
                }
                String str2 = String.format("[b/110101804] Future for '%s' did not complete after %s seconds", str, Integer.valueOf(i));
                com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
                new am.a(str2);
                ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(43)).o();
            }
        }, ((long) i) * 1000, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(List list, List list2) {
        com.google.android.libraries.navigation.internal.bt.h hVarB;
        ev evVar;
        ev evVar2;
        ev evVar3;
        com.google.android.libraries.navigation.internal.cn.aa aaVar;
        ev evVarO;
        ev evVar4;
        ev evVar5;
        ev evVar6;
        float f;
        com.google.android.libraries.navigation.internal.cn.i iVar;
        Iterator it2;
        com.google.android.libraries.navigation.internal.acg.c cVar;
        String str;
        com.google.android.libraries.navigation.internal.acg.c cVar2;
        com.google.android.libraries.navigation.internal.cn.aa aaVar2 = (com.google.android.libraries.navigation.internal.cn.aa) this.au.f();
        if (aaVar2 == null || (hVarB = b()) == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.bt.b bVar = (com.google.android.libraries.navigation.internal.bt.b) hVarB;
        if (bVar.a.c() != null) {
            float fC = this.as.a().c();
            aaVar2.a(this);
            com.google.android.libraries.navigation.internal.og.b bVar2 = this.ar;
            com.google.android.libraries.navigation.internal.og.d dVar = (com.google.android.libraries.navigation.internal.og.d) bVar2;
            if (dVar.e()) {
                synchronized (bVar2) {
                    ((com.google.android.libraries.navigation.internal.og.d) bVar2).b.add(aaVar2);
                }
            } else {
                ((com.google.android.libraries.navigation.internal.vu.a) dVar.a).a.i(aaVar2);
            }
            com.google.android.libraries.navigation.internal.cn.i iVar2 = new com.google.android.libraries.navigation.internal.cn.i();
            int i = ev.d;
            iVar2.c(lv.a);
            iVar2.a(lv.a);
            iVar2.b(lv.a);
            iVar2.d(-1);
            iVar2.e = null;
            iVar2.f = null;
            com.google.android.libraries.navigation.internal.fz.d dVar2 = this.f345n;
            bh bhVar = bVar.a;
            com.google.android.libraries.navigation.internal.dx.i iVar3 = this.ad;
            eq eqVar = new eq();
            Iterator it3 = bhVar.iterator();
            while (it3.hasNext()) {
                bg bgVar = (bg) it3.next();
                long j = bgVar.Y;
                eq eqVar2 = new eq();
                Iterator it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        aaVar = aaVar2;
                        evVarO = lv.a;
                        break;
                    }
                    com.google.android.libraries.navigation.internal.ach.j jVar = (com.google.android.libraries.navigation.internal.ach.j) it4.next();
                    aaVar = aaVar2;
                    if (jVar.c == j) {
                        evVarO = ev.o(jVar.e);
                        break;
                    }
                    aaVar2 = aaVar;
                }
                int size = evVarO.size();
                int i2 = 0;
                while (i2 < size) {
                    com.google.android.libraries.navigation.internal.ach.f fVar = (com.google.android.libraries.navigation.internal.ach.f) evVarO.get(i2);
                    int i3 = fVar.c;
                    ev evVar7 = evVarO;
                    eq eqVar3 = new eq();
                    Iterator it5 = fVar.e.iterator();
                    while (it5.hasNext()) {
                        int i4 = size;
                        com.google.android.libraries.navigation.internal.ach.d dVar3 = (com.google.android.libraries.navigation.internal.ach.d) it5.next();
                        Iterator it6 = it3;
                        String str2 = dVar3.e;
                        com.google.android.libraries.navigation.internal.acg.c cVar3 = com.google.android.libraries.navigation.internal.acg.c.DECORATION_RELEVANCE_STATE_UNSPECIFIED;
                        Iterator it7 = list2.iterator();
                        while (true) {
                            if (it7.hasNext()) {
                                it2 = it5;
                                com.google.android.libraries.navigation.internal.acg.h hVar = (com.google.android.libraries.navigation.internal.acg.h) it7.next();
                                f = fC;
                                iVar = iVar2;
                                if (hVar.b == j) {
                                    Iterator it8 = hVar.c.iterator();
                                    while (true) {
                                        if (it8.hasNext()) {
                                            com.google.android.libraries.navigation.internal.acg.f fVar2 = (com.google.android.libraries.navigation.internal.acg.f) it8.next();
                                            if (fVar2.b == i3) {
                                                cVar = (com.google.android.libraries.navigation.internal.acg.c) Collections.unmodifiableMap(new by(fVar2.c, com.google.android.libraries.navigation.internal.acg.f.d)).get(str2);
                                                if (cVar != null) {
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                                fC = f;
                                it5 = it2;
                                iVar2 = iVar;
                            } else {
                                f = fC;
                                iVar = iVar2;
                                it2 = it5;
                            }
                            cVar = cVar3;
                            break;
                        }
                        com.google.android.libraries.navigation.internal.cn.g gVar = new com.google.android.libraries.navigation.internal.cn.g();
                        String str3 = dVar3.e;
                        Objects.requireNonNull(str3);
                        gVar.a = str3;
                        gVar.b = (dVar3.c == 3 ? (com.google.android.libraries.navigation.internal.ach.c) dVar3.d : com.google.android.libraries.navigation.internal.ach.c.a).c;
                        gVar.f = (byte) (gVar.f | 1);
                        gVar.c = (dVar3.c == 3 ? (com.google.android.libraries.navigation.internal.ach.c) dVar3.d : com.google.android.libraries.navigation.internal.ach.c.a).d;
                        gVar.f = (byte) (gVar.f | 2);
                        Objects.requireNonNull(cVar);
                        gVar.e = cVar;
                        com.google.android.libraries.navigation.internal.aaq.an anVar = dVar3.f;
                        if (anVar == null) {
                            anVar = com.google.android.libraries.navigation.internal.aaq.an.a;
                        }
                        gVar.d = anVar;
                        if (gVar.f != 3 || (str = gVar.a) == null || (cVar2 = gVar.e) == null) {
                            throw new IllegalStateException();
                        }
                        eqVar3.h(new com.google.android.libraries.navigation.internal.cn.h(str, gVar.b, gVar.c, gVar.d, cVar2));
                        it3 = it6;
                        size = i4;
                        eqVar = eqVar;
                        fC = f;
                        it5 = it2;
                        iVar2 = iVar;
                    }
                    int i5 = size;
                    float f2 = fC;
                    com.google.android.libraries.navigation.internal.cn.i iVar4 = iVar2;
                    eq eqVar4 = eqVar;
                    Iterator it9 = it3;
                    com.google.android.libraries.navigation.internal.cn.e eVar = new com.google.android.libraries.navigation.internal.cn.e();
                    eVar.a = i3;
                    eVar.c = (byte) 1;
                    ev evVarG = eqVar3.g();
                    Objects.requireNonNull(evVarG);
                    eVar.b = evVarG;
                    if (eVar.c != 1 || (evVar6 = eVar.b) == null) {
                        throw new IllegalStateException();
                    }
                    eqVar2.h(new com.google.android.libraries.navigation.internal.cn.f(eVar.a, evVar6));
                    i2++;
                    evVarO = evVar7;
                    it3 = it9;
                    size = i5;
                    eqVar = eqVar4;
                    fC = f2;
                    iVar2 = iVar4;
                }
                float f3 = fC;
                com.google.android.libraries.navigation.internal.cn.i iVar5 = iVar2;
                eq eqVar5 = eqVar;
                Iterator it10 = it3;
                com.google.android.libraries.navigation.internal.cn.k kVar = new com.google.android.libraries.navigation.internal.cn.k();
                kVar.a(false);
                kVar.b(lv.a);
                kVar.a = j;
                kVar.e = (byte) (kVar.e | 1);
                kVar.a(bhVar.f() == bgVar);
                kVar.b(eqVar2.g());
                com.google.android.libraries.navigation.internal.cn.c cVar4 = new com.google.android.libraries.navigation.internal.cn.c();
                cVar4.b(lv.a);
                cVar4.a(lv.a);
                cVar4.b(cc.a(bgVar));
                cVar4.a(d(bhVar, bgVar, dVar2, iVar3));
                ev evVar8 = cVar4.a;
                if (evVar8 == null || (evVar4 = cVar4.b) == null) {
                    throw new IllegalStateException();
                }
                kVar.d = new com.google.android.libraries.navigation.internal.cn.d(evVar8, evVar4);
                if (kVar.e != 3 || (evVar5 = kVar.c) == null) {
                    throw new IllegalStateException();
                }
                eqVar5.h(new com.google.android.libraries.navigation.internal.cn.l(kVar.a, kVar.b, evVar5, kVar.d));
                eqVar = eqVar5;
                aaVar2 = aaVar;
                it3 = it10;
                fC = f3;
                iVar2 = iVar5;
            }
            com.google.android.libraries.navigation.internal.cn.aa aaVar3 = aaVar2;
            com.google.android.libraries.navigation.internal.cn.i iVar6 = iVar2;
            iVar6.c(eqVar.g());
            iVar6.a(list);
            iVar6.b(list2);
            iVar6.d((int) fC);
            com.google.android.libraries.navigation.internal.bt.h hVarB2 = b();
            iVar6.e = hVarB2 != null ? hVarB2.R() : null;
            com.google.android.libraries.navigation.internal.bt.h hVarB3 = b();
            iVar6.f = hVarB3 != null ? (String) ((com.google.android.libraries.navigation.internal.bt.b) hVarB3).B.f() : null;
            com.google.android.libraries.navigation.internal.bt.h hVarB4 = b();
            iVar6.g = hVarB4 != null ? ((com.google.android.libraries.navigation.internal.bt.b) hVarB4).a.f().O : null;
            if (iVar6.h != 1 || (evVar = iVar6.a) == null || (evVar2 = iVar6.b) == null || (evVar3 = iVar6.c) == null) {
                throw new IllegalStateException();
            }
            aaVar3.b(new com.google.android.libraries.navigation.internal.cn.j(evVar, evVar2, evVar3, iVar6.d, iVar6.e, iVar6.f, iVar6.g));
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a6 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:10:0x001f, B:43:0x009f, B:45:0x00ae, B:25:0x0043, B:27:0x004c, B:29:0x0054, B:30:0x005b, B:32:0x0064, B:34:0x006c, B:35:0x0073, B:36:0x007a, B:38:0x0082, B:39:0x0089, B:40:0x0090, B:42:0x0094, B:44:0x00a6), top: B:57:0x001f }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.google.android.libraries.navigation.internal.bm.am] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.google.android.libraries.navigation.internal.yx.br, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.google.android.libraries.navigation.internal.aac.bj] */
    private final bj w(final be beVar, final com.google.android.libraries.navigation.internal.ol.as asVar, final boolean z, final com.google.android.libraries.navigation.internal.bt.h hVar, final bg bgVar, final Map map, final int i, final com.google.android.libraries.navigation.internal.sg.a aVar) {
        ?? A;
        com.google.android.libraries.navigation.internal.bf.b bVar = this.av.a().c;
        if (bVar == null) {
            bVar = com.google.android.libraries.navigation.internal.bf.b.a;
        }
        if (bVar.d) {
            return com.google.android.libraries.navigation.internal.aac.az.f();
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsOverlayManager.createAndRenderLine()");
        try {
            com.google.android.libraries.navigation.internal.ck.ar arVar = this.at;
            com.google.android.libraries.navigation.internal.ady.al alVar = beVar.b;
            boolean z2 = beVar.c;
            boolean z3 = beVar.d;
            com.google.android.libraries.navigation.internal.ady.al alVar2 = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            int iOrdinal = alVar.ordinal();
            if (iOrdinal == 0) {
                boolean z4 = arVar.e;
                A = arVar.m.a();
            } else if (iOrdinal == 1) {
                A = arVar.d ? arVar.o.c().a() : arVar.l.a();
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    A = arVar.f366n.a();
                } else if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 9) {
                    boolean z5 = arVar.e;
                    A = arVar.m.a();
                }
            } else if (z2) {
                A = arVar.b.c() ? arVar.j.a() : arVar.h.a();
            } else if (z3) {
                A = arVar.b.c() ? arVar.k.a() : arVar.i.a();
            } else {
                A = arVar.b.c() ? arVar.g.a() : arVar.f.a();
            }
            ca caVar = new ca();
            com.google.android.libraries.navigation.internal.yu.c.d(A, new com.google.android.libraries.navigation.internal.ck.ap(arVar, caVar), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            u(caVar, "styledPolylineGenerator", 30);
            final ca caVar2 = new ca();
            u(caVar2, "polylinesShownOrCanceled", 60);
            bj bjVarB = com.google.android.libraries.navigation.internal.yu.c.b(caVar, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bm.x
                /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    double dE;
                    cm cmVar = (cm) obj;
                    be beVar2 = beVar;
                    boolean z6 = z;
                    List listF = cmVar.f(beVar2, z6, i);
                    bg bgVar2 = bgVar;
                    boolean zK = bgVar2.g.k(kk.b);
                    int i2 = 0;
                    while (true) {
                        am amVar = this.a;
                        if (i2 >= listF.size()) {
                            Map map2 = map;
                            cmVar.e((com.google.android.libraries.navigation.internal.ol.ax) amVar.w.a());
                            return new a(bgVar2.G(), cmVar, ev.o(listF), zK, !map2.isEmpty(), ev.o(beVar2.m), caVar2);
                        }
                        com.google.android.libraries.navigation.internal.ol.as asVar2 = asVar;
                        com.google.android.libraries.navigation.internal.ol.p pVar = (com.google.android.libraries.navigation.internal.ol.p) listF.get(i2);
                        if (asVar2 != null) {
                            pVar.k(asVar2);
                        }
                        if (beVar2.b != com.google.android.libraries.navigation.internal.ady.al.TRANSIT && z6 && ((((com.google.android.libraries.navigation.internal.bt.b) hVar).p || bgVar2.t().Z()) && beVar2.l.equals(com.google.android.libraries.navigation.internal.ck.j.NONE))) {
                            com.google.android.libraries.navigation.internal.sg.a aVar2 = aVar;
                            long j = bgVar2.Y;
                            aVar2.a();
                            com.google.android.libraries.navigation.internal.bp.ag agVar = new com.google.android.libraries.navigation.internal.bp.ag(bgVar2);
                            com.google.android.libraries.navigation.internal.ni.a aVar3 = amVar.a;
                            float f = beVar2.k;
                            com.google.android.libraries.navigation.internal.db.s sVar = amVar.L;
                            com.google.android.libraries.navigation.internal.db.r rVarD = sVar != null ? sVar.d() : null;
                            double dA = com.google.android.libraries.navigation.internal.p002do.s.a(rVarD, bgVar2, 0.0d);
                            if (rVarD == null || !rVarD.x()) {
                                dE = 0.0d;
                            } else {
                                float fMin = rVarD.y() ? Math.min(1.0f, rVarD.h()) : 1.0f;
                                float f2 = rVarD.f;
                                if (Math.abs(f2) > fMin) {
                                    dE = ((double) f2) * rVarD.n().e();
                                } else {
                                    dE = 0.0d;
                                }
                            }
                            boolean zIsNaN = Double.isNaN(dA);
                            double d = true != zIsNaN ? dE : 0.0d;
                            if (true == zIsNaN) {
                                dA = -3.4028234663852886E38d;
                            }
                            pVar.b(new com.google.android.libraries.navigation.internal.p002do.s(bgVar2, agVar, f, aVar3, dA, d));
                        }
                        i2++;
                        zK = zK;
                        z6 = z6;
                    }
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            if (dVarB != null) {
                Trace.endSection();
            }
            return bjVarB;
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

    public final int a(bg bgVar) {
        com.google.android.libraries.navigation.internal.db.s sVar;
        if (this.G == null || (sVar = this.L) == null || sVar.d() == null) {
            return 0;
        }
        com.google.android.libraries.navigation.internal.oe.x xVarN = this.L.d().n();
        com.google.android.libraries.navigation.internal.oe.ag agVarX = bgVar.x(xVarN, xVarN.e() * 100.0d);
        if (agVarX != null) {
            return (int) bgVar.b(agVarX);
        }
        return 0;
    }

    public final com.google.android.libraries.navigation.internal.bt.h b() {
        com.google.android.libraries.navigation.internal.bt.h hVar;
        synchronized (this.U) {
            hVar = this.V.a;
        }
        return hVar;
    }

    /* JADX WARN: Code duplicated, block: B:195:0x04b4 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:198:0x04be A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x04c8 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x04d0 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x04d3 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x04d9 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x04de A[Catch: all -> 0x096d, LOOP:10: B:204:0x04d7->B:208:0x04de, LOOP_END, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:212:0x04e6 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x04f0 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x04f8 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:217:0x04fb A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x0501 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0506 A[Catch: all -> 0x096d, LOOP:11: B:218:0x04ff->B:222:0x0506, LOOP_END, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x0520 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:232:0x0524  */
    /* JADX WARN: Code duplicated, block: B:233:0x0527 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0530 A[Catch: all -> 0x096d, LOOP:1: B:194:0x04b2->B:237:0x0530, LOOP_END, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x053c  */
    /* JADX WARN: Code duplicated, block: B:242:0x053d A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0549 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:248:0x0561 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x0572 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x05a5 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:263:0x05c6 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:267:0x05e0 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x0612 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:275:0x0651 A[Catch: all -> 0x096d, LOOP:5: B:273:0x0647->B:275:0x0651, LOOP_END, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:278:0x0692 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x06a7 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:281:0x06ad A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:283:0x06b7 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:285:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:286:0x06cc A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:288:0x06e0 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:290:0x0701 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:295:0x0736 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x074b A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:299:0x0762 A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:302:0x076c A[Catch: all -> 0x096d, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:305:0x077a A[Catch: all -> 0x096d, LOOP:8: B:303:0x0772->B:305:0x077a, LOOP_END, TryCatch #4 {all -> 0x096d, blocks: (B:146:0x0391, B:149:0x03ae, B:152:0x03b6, B:161:0x03e8, B:163:0x03f6, B:165:0x0404, B:167:0x0412, B:169:0x0422, B:171:0x0426, B:172:0x0428, B:174:0x042c, B:175:0x042e, B:176:0x0432, B:177:0x043a, B:179:0x0440, B:181:0x044a, B:186:0x0454, B:188:0x045e, B:189:0x0481, B:153:0x03be, B:155:0x03c6, B:156:0x03ce, B:158:0x03d3, B:160:0x03dd, B:346:0x0876, B:72:0x0162, B:87:0x0195, B:89:0x019f, B:92:0x01a4, B:97:0x01c2, B:99:0x01c5, B:104:0x01d0, B:105:0x01ee, B:106:0x01f1, B:108:0x01f5, B:109:0x020c, B:110:0x021a, B:112:0x0221, B:116:0x0231, B:118:0x024b, B:121:0x0261, B:125:0x026a, B:127:0x0299, B:129:0x029d, B:130:0x02b3, B:133:0x02e8, B:145:0x037a, B:119:0x0259, B:115:0x022d, B:131:0x02d6, B:86:0x0192, B:134:0x02f7, B:137:0x0318, B:139:0x0328, B:140:0x032c, B:143:0x0338, B:144:0x033d, B:193:0x048d, B:195:0x04b4, B:234:0x0529, B:239:0x0536, B:245:0x0553, B:246:0x055e, B:248:0x0561, B:250:0x0572, B:252:0x0581, B:254:0x058b, B:256:0x059a, B:259:0x05a9, B:258:0x05a5, B:260:0x05ac, B:261:0x05bf, B:263:0x05c6, B:265:0x05d6, B:268:0x05f1, B:267:0x05e0, B:269:0x05f5, B:270:0x060c, B:272:0x0612, B:273:0x0647, B:275:0x0651, B:276:0x0671, B:278:0x0692, B:280:0x06a7, B:283:0x06b7, B:293:0x072a, B:286:0x06cc, B:288:0x06e0, B:290:0x0701, B:291:0x0704, B:296:0x073f, B:298:0x074b, B:300:0x0766, B:302:0x076c, B:303:0x0772, B:305:0x077a, B:308:0x0793, B:310:0x07c7, B:312:0x07cd, B:315:0x07e3, B:317:0x0800, B:319:0x080e, B:320:0x0810, B:322:0x0816, B:324:0x081a, B:325:0x081c, B:327:0x0824, B:328:0x0826, B:330:0x082a, B:333:0x082f, B:335:0x0833, B:336:0x0835, B:338:0x0839, B:339:0x083b, B:341:0x0841, B:343:0x084b, B:345:0x0870, B:299:0x0762, B:281:0x06ad, B:295:0x0736, B:242:0x053d, B:244:0x0549, B:237:0x0530, B:233:0x0527, B:198:0x04be, B:200:0x04c8, B:202:0x04d0, B:203:0x04d3, B:205:0x04d9, B:212:0x04e6, B:214:0x04f0, B:216:0x04f8, B:217:0x04fb, B:219:0x0501, B:226:0x050e, B:228:0x0518, B:230:0x0520, B:222:0x0506, B:208:0x04de), top: B:467:0x0391 }] */
    /* JADX WARN: Code duplicated, block: B:307:0x0792  */
    /* JADX WARN: Code duplicated, block: B:344:0x086f  */
    /* JADX WARN: Code duplicated, block: B:459:0x0963 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:463:0x0a45 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:489:0x0534 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:490:0x052f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:509:0x0704 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:514:0x04e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:515:0x04dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:516:0x0509 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:517:0x0505 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:550:? A[Catch: all -> 0x0a3d, SYNTHETIC, TryCatch #11 {all -> 0x0a3d, blocks: (B:401:0x096c, B:400:0x0969, B:389:0x0954, B:390:0x0957, B:405:0x0979, B:75:0x016a, B:76:0x016f, B:78:0x0173, B:80:0x0179, B:83:0x0180, B:406:0x0982, B:407:0x0987, B:447:0x0a3c, B:396:0x0963, B:408:0x0988, B:410:0x098c, B:412:0x0990, B:413:0x099d, B:415:0x09a3, B:417:0x09af, B:419:0x09b6, B:421:0x09bc, B:423:0x09c0, B:425:0x09c7, B:427:0x09cb, B:428:0x09cd, B:430:0x09d2, B:432:0x09d9, B:433:0x09dd, B:435:0x0a04, B:431:0x09d7, B:424:0x09c5, B:418:0x09b4, B:436:0x0a10, B:437:0x0a20, B:439:0x0a26, B:440:0x0a32), top: B:481:0x0954, inners: #0, #9 }] */
    /* JADX WARN: Code duplicated, block: B:552:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    final List e(com.google.android.libraries.navigation.internal.bt.h hVar, Map map, com.google.android.libraries.navigation.internal.sg.a aVar) throws Throwable {
        com.google.android.libraries.navigation.internal.nw.d dVar;
        Throwable th;
        com.google.android.libraries.navigation.internal.bo.z zVar;
        ArrayList arrayList;
        bh bhVar;
        int i;
        boolean z;
        ev evVar;
        com.google.android.libraries.navigation.internal.ady.al alVarB;
        bh bhVar2;
        int i2;
        ev evVar2;
        bq[] bqVarArrAb;
        ev evVar3;
        int length;
        bg bgVar;
        ArrayList arrayList2;
        com.google.android.libraries.navigation.internal.oe.x xVar;
        boolean z2;
        com.google.android.libraries.navigation.internal.ck.bh<be> bhVar3;
        fd fdVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        Throwable th2;
        am amVar;
        ae aeVar;
        bg bgVar2;
        List listN;
        int i3;
        eq eqVar;
        bq[] bqVarArr;
        qj qjVarW;
        boolean zBooleanValue;
        int length2;
        int i4;
        String str;
        Map mapUnmodifiableMap;
        bf bfVarC;
        int i5;
        ev evVarG;
        ArrayList arrayList3;
        bf bfVar;
        int i6;
        int i7;
        int size;
        int i8;
        com.google.android.libraries.navigation.internal.yx.ao aoVar;
        ArrayList arrayList4;
        int i9;
        int iIntValue;
        ArrayList arrayList5;
        bf bfVar2;
        com.google.android.libraries.navigation.internal.ck.bg bgVar3;
        boolean zD;
        int size2;
        List listSubList;
        ArrayList arrayList6;
        int i10;
        int iA;
        int iIntValue2;
        int iIntValue3;
        ev evVarB;
        int i11;
        int i12;
        com.google.android.libraries.navigation.internal.ck.bg bgVar4;
        int i13;
        ik ikVar;
        bf bfVar3;
        bf bfVarC2;
        int i14;
        bi biVar;
        bq bqVar;
        bt btVar;
        bt btVar2;
        bq bqVar2;
        bt btVar3;
        bt btVar4;
        bq bqVar3;
        bt btVar5;
        jk jkVar;
        am amVar2 = this;
        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsOverlayManager.createClientLines()");
        try {
            ArrayList arrayList7 = new ArrayList();
            bh bhVar4 = ((com.google.android.libraries.navigation.internal.bt.b) hVar).a;
            int i15 = 0;
            while (i15 < bhVar4.d()) {
                boolean z3 = i15 == bhVar4.a();
                com.google.android.libraries.navigation.internal.bf.b bVar = amVar2.av.a().c;
                if (bVar == null) {
                    try {
                        bVar = com.google.android.libraries.navigation.internal.bf.b.a;
                    } catch (Throwable th3) {
                        th = th3;
                        dVar = dVarB2;
                        if (dVar == null) {
                            throw th;
                        }
                        try {
                            Trace.endSection();
                            throw th;
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                            throw th;
                        }
                    }
                }
                try {
                    if (!((com.google.android.libraries.navigation.internal.bt.b) hVar).c || bVar.c) {
                        if (z3) {
                            z = true;
                        } else {
                            dVar = dVarB2;
                            arrayList = arrayList7;
                            bhVar = bhVar4;
                            i = i15;
                        }
                        i15 = i + 1;
                        arrayList7 = arrayList;
                        bhVar4 = bhVar;
                        dVarB2 = dVar;
                    } else {
                        z = z3;
                    }
                    ArrayList arrayList8 = new ArrayList();
                    bg bgVar5 = bgVar;
                    boolean zK = bgVar5.g.k(kk.b);
                    for (be beVar : bhVar3) {
                        if (((com.google.android.libraries.navigation.internal.bt.b) hVar).e) {
                            try {
                                amVar = this;
                                try {
                                    aeVar = new ae(amVar, bgVar5, zK);
                                } catch (Throwable th5) {
                                    th = th5;
                                    th2 = th;
                                    if (dVarB != null) {
                                        throw th2;
                                    }
                                    try {
                                        Trace.endSection();
                                        throw th2;
                                    } catch (Throwable th6) {
                                        th2.addSuppressed(th6);
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                amVar = this;
                            }
                        } else {
                            amVar = this;
                            aeVar = null;
                        }
                        try {
                            if (beVar.l.equals(com.google.android.libraries.navigation.internal.ck.j.DIRECTIONS_ROUTE_POLYLINE_OVERLAY)) {
                                bg bgVar6 = bgVar5;
                                try {
                                    arrayList8.add(w(beVar, aeVar, z, hVar, bgVar5, fdVar, 2, aVar));
                                    bgVar5 = bgVar6;
                                } catch (Throwable th8) {
                                    th = th8;
                                    th2 = th;
                                    if (dVarB != null) {
                                        throw th2;
                                    }
                                    Trace.endSection();
                                    throw th2;
                                }
                            } else {
                                bg bgVar7 = bgVar5;
                                boolean z4 = zK;
                                arrayList8.add(w(beVar, aeVar, z, hVar, bgVar7, fdVar, 1, aVar));
                                if (amVar.f345n.W().o) {
                                    com.google.android.libraries.navigation.internal.ady.al alVar = beVar.b;
                                    ev evVar4 = com.google.android.libraries.navigation.internal.bw.e.a;
                                    int iOrdinal = alVar.ordinal();
                                    if ((iOrdinal == 0 || iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 9) && z && beVar.f) {
                                        arrayList8.add(w(beVar, aeVar, true, hVar, bgVar7, fdVar, 2, aVar));
                                    }
                                }
                                bgVar5 = bgVar7;
                                zK = z4;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    }
                    amVar2 = this;
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th10) {
                            th = th10;
                            th = th;
                            if (dVar == null) {
                                throw th;
                            }
                            Trace.endSection();
                            throw th;
                        }
                    }
                    arrayList = arrayList2;
                    arrayList.addAll(arrayList8);
                    i15 = i + 1;
                    arrayList7 = arrayList;
                    bhVar4 = bhVar;
                    dVarB2 = dVar;
                } catch (Throwable th11) {
                    th = th11;
                }
                bg bgVarE = bhVar4.e(i15);
                ev evVarD = d(bhVar4, bgVarE, amVar2.f345n, amVar2.ad);
                com.google.android.libraries.navigation.internal.ck.bg bgVar8 = new com.google.android.libraries.navigation.internal.ck.bg(bgVarE, amVar2.f345n);
                bgVar8.b = evVarD;
                bgVar8.a = ((com.google.android.libraries.navigation.internal.bt.b) hVar).u;
                bgVar8.h = amVar2.t;
                bgVar8.g = ((com.google.android.libraries.navigation.internal.bt.b) hVar).k;
                Map map2 = (Map) map.get(Long.valueOf(bgVarE.Y));
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        Integer num = (Integer) entry.getKey();
                        num.intValue();
                        bgVar8.c.put(num, (List) entry.getValue());
                    }
                }
                if (bgVar8.e.j != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                    try {
                        bg bgVar9 = bgVar8.e;
                        if (bgVar9.j == com.google.android.libraries.navigation.internal.ady.al.BIKESHARING) {
                            bgVar = bgVarE;
                            dVar = dVarB2;
                            arrayList2 = arrayList7;
                            bhVar = bhVar4;
                            i = i15;
                            bgVar2 = bgVar8.e;
                            listN = bgVar2.N();
                            i3 = bgVar8.a;
                            com.google.android.libraries.navigation.internal.fz.d dVar2 = bgVar8.d;
                            int i16 = ev.d;
                            eqVar = new eq();
                            bqVarArr = bgVar2.l;
                            qjVarW = dVar2.W();
                            zBooleanValue = qjVarW.p;
                            length2 = bqVarArr.length;
                            i4 = 0;
                            while (true) {
                                if (i4 >= length2) {
                                    str = "";
                                    break;
                                }
                                bqVar = bqVarArr[i4];
                                btVar = bqVar.b;
                                if (btVar != null) {
                                    jkVar = null;
                                } else if ((btVar.h().b & 2) != 0) {
                                    jkVar = btVar.h().c;
                                    if (jkVar == null) {
                                        jkVar = jk.a;
                                    }
                                } else {
                                    btVar2 = bqVar.b;
                                    bqVar2 = bqVar.N;
                                    while (true) {
                                        if (bqVar2 == null) {
                                            btVar3 = null;
                                            break;
                                        }
                                        btVar3 = bqVar2.b;
                                        if (btVar3 != btVar2) {
                                            break;
                                        }
                                        bqVar2 = bqVar2.N;
                                    }
                                    if (btVar3 != null) {
                                        if ((btVar3.h().b & 4) != 0) {
                                            jkVar = btVar3.h().d;
                                            if (jkVar == null) {
                                                jkVar = jk.a;
                                            }
                                        } else {
                                            btVar4 = bqVar.b;
                                            bqVar3 = bqVar.M;
                                            while (true) {
                                                if (bqVar3 == null) {
                                                    btVar5 = null;
                                                    break;
                                                }
                                                btVar5 = bqVar3.b;
                                                if (btVar5 != btVar4) {
                                                    break;
                                                }
                                                bqVar3 = bqVar3.M;
                                            }
                                            if (btVar5 != null && (btVar5.h().b & 2) != 0) {
                                                jkVar = btVar5.h().c;
                                                if (jkVar == null) {
                                                    jkVar = jk.a;
                                                }
                                            }
                                        }
                                    }
                                    jkVar = null;
                                }
                                if (jkVar == null) {
                                    str = "";
                                } else {
                                    str = jkVar.e;
                                }
                                if (!str.isEmpty()) {
                                    break;
                                }
                                i4++;
                            }
                            if (str.isEmpty()) {
                                mapUnmodifiableMap = Collections.unmodifiableMap(qjVarW.q);
                                if (mapUnmodifiableMap.containsKey(str)) {
                                    zBooleanValue = ((Boolean) mapUnmodifiableMap.get(str)).booleanValue();
                                }
                            }
                            bfVarC = com.google.android.libraries.navigation.internal.ck.bg.c(bqVarArr[0], i3, zBooleanValue);
                            eqVar.h(bfVarC);
                            for (i5 = 1; i5 < bqVarArr.length; i5++) {
                                bfVarC2 = com.google.android.libraries.navigation.internal.ck.bg.c(bqVarArr[i5], i3, zBooleanValue);
                                if (bfVarC2.c() == ((com.google.android.libraries.navigation.internal.ck.d) bfVarC).b) {
                                    i14 = bfVarC2.a().b;
                                    biVar = ((com.google.android.libraries.navigation.internal.ck.d) bfVarC).a;
                                    if (i14 == biVar.b || bfVarC2.a().c != biVar.c || !hx.i(bfVarC2.b(), ((com.google.android.libraries.navigation.internal.ck.d) bfVarC).c) || bfVarC2.d() != ((com.google.android.libraries.navigation.internal.ck.d) bfVarC).d) {
                                        eqVar.h(bfVarC2);
                                        bfVarC = bfVarC2;
                                    }
                                } else {
                                    eqVar.h(bfVarC2);
                                    bfVarC = bfVarC2;
                                }
                            }
                            evVarG = eqVar.g();
                            arrayList3 = new ArrayList();
                            bfVar = (bf) evVarG.get(0);
                            i6 = 0;
                            i7 = 1;
                            while (i7 < ((lv) evVarG).c) {
                                bfVar3 = (bf) evVarG.get(i7);
                                if (bfVar.c() == bfVar3.c() || bfVar.d() != bfVar3.d()) {
                                    arrayList3.add(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i6), Integer.valueOf(i7)));
                                    i6 = i7;
                                }
                                i7++;
                                bfVar = bfVar3;
                            }
                            arrayList3.add(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i6), -1));
                            size = arrayList3.size() - 1;
                            i8 = 0;
                            while (i8 < arrayList3.size()) {
                                aoVar = (com.google.android.libraries.navigation.internal.yx.ao) arrayList3.get(i8);
                                bf bfVar4 = (bf) evVarG.get(((Integer) aoVar.a).intValue());
                                arrayList4 = new ArrayList();
                                i9 = ((bf) evVarG.get(((Integer) aoVar.a).intValue())).a().a;
                                iIntValue = ((Integer) aoVar.a).intValue();
                                while (iIntValue < ((Integer) aoVar.b).intValue()) {
                                    bi biVarA = ((bf) evVarG.get(iIntValue)).a();
                                    arrayList4.add(new bi(biVarA.a - i9, biVarA.b, biVarA.c));
                                    iIntValue++;
                                    arrayList3 = arrayList3;
                                }
                                ArrayList arrayList9 = arrayList3;
                                arrayList5 = new ArrayList();
                                bfVar2 = (bf) evVarG.get(((Integer) aoVar.a).intValue());
                                if (bfVar2.c().equals(com.google.android.libraries.navigation.internal.ady.al.TRANSIT)) {
                                    iA = (int) bgVar2.a(bfVar2.a().a);
                                    iIntValue2 = ((Integer) aoVar.a).intValue();
                                    if (i8 == size) {
                                        iIntValue3 = ((lv) evVarG).c;
                                    } else {
                                        iIntValue3 = ((Integer) aoVar.b).intValue();
                                    }
                                    while (iIntValue2 < iIntValue3) {
                                        if (((bf) evVarG.get(iIntValue2)).a().c) {
                                            evVarB = ((bf) evVarG.get(iIntValue2)).b();
                                            i11 = ((lv) evVarB).c;
                                            i12 = 0;
                                            while (i12 < i11) {
                                                ev evVar5 = evVarB;
                                                in inVar = (in) evVarB.get(i12);
                                                int i17 = i11;
                                                ikVar = (ik) in.a.r(inVar);
                                                int i18 = inVar.d - iA;
                                                int i19 = iA;
                                                if (!ikVar.b.H()) {
                                                    ikVar.v();
                                                }
                                                in inVar2 = (in) ikVar.b;
                                                inVar2.b |= 2;
                                                inVar2.d = i18;
                                                arrayList5.add((in) ikVar.t());
                                                i12++;
                                                i11 = i17;
                                                evVarB = evVar5;
                                                iA = i19;
                                                bgVar8 = bgVar8;
                                            }
                                            bgVar4 = bgVar8;
                                            i13 = iA;
                                        } else {
                                            bgVar4 = bgVar8;
                                            i13 = iA;
                                        }
                                        iIntValue2++;
                                        iIntValue3 = iIntValue3;
                                        iA = i13;
                                        bgVar8 = bgVar4;
                                    }
                                    bgVar3 = bgVar8;
                                } else {
                                    bgVar3 = bgVar8;
                                    arrayList5.addAll(bfVar2.b());
                                }
                                zD = bfVar4.d();
                                int i20 = bfVar4.a().a;
                                if (i8 != size) {
                                    size2 = ((bf) evVarG.get(((Integer) aoVar.b).intValue())).a().a + 1;
                                } else {
                                    size2 = listN.size();
                                }
                                listSubList = listN.subList(i20, size2);
                                if (zD) {
                                    arrayList6 = new ArrayList();
                                    i10 = 0;
                                    while (i10 < listSubList.size() - 1) {
                                        com.google.android.libraries.navigation.internal.oe.x xVar2 = (com.google.android.libraries.navigation.internal.oe.x) listSubList.get(i10);
                                        i10++;
                                        arrayList6.addAll(com.google.android.libraries.navigation.internal.ck.bg.d(xVar2, (com.google.android.libraries.navigation.internal.oe.x) listSubList.get(i10)));
                                    }
                                    listSubList = arrayList6;
                                }
                                com.google.android.libraries.navigation.internal.ck.a aVarB = be.b(listSubList, bfVar4.c());
                                aVarB.d = arrayList4;
                                aVarB.f = (short) (aVarB.f | 16);
                                aVarB.d(zD);
                                aVarB.f(arrayList5);
                                aVarB.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar2));
                                bgVar8 = bgVar3;
                                aVarB.b(com.google.android.libraries.navigation.internal.ck.bg.a(bgVar8.i));
                                bgVar8.i.add(aVarB.a());
                                if (i8 != size && !listSubList.isEmpty()) {
                                    com.google.android.libraries.navigation.internal.oe.x xVar3 = (com.google.android.libraries.navigation.internal.oe.x) gs.d(listSubList);
                                    if (com.google.android.libraries.navigation.internal.ck.bg.e(bgVar8.h, bgVar8.d.m())) {
                                        com.google.android.libraries.navigation.internal.oe.x xVarZ = com.google.android.libraries.navigation.internal.oe.x.z(((ck) gs.d(bgVar2.p)).n());
                                        if (bgVar2.g.c(0).e()) {
                                            com.google.android.libraries.navigation.internal.adr.ar arVarC = bgVar2.g.c(0).c();
                                            com.google.android.libraries.navigation.internal.aap.n nVar = arVarC.f;
                                            if (nVar == null) {
                                                nVar = com.google.android.libraries.navigation.internal.aap.n.a;
                                            }
                                            if ((nVar.b & 1) != 0) {
                                                com.google.android.libraries.navigation.internal.aap.n nVar2 = arVarC.f;
                                                if (nVar2 == null) {
                                                    nVar2 = com.google.android.libraries.navigation.internal.aap.n.a;
                                                }
                                                int iA2 = com.google.android.libraries.navigation.internal.aap.h.a(nVar2.d);
                                                if (iA2 == 0) {
                                                    iA2 = com.google.android.libraries.navigation.internal.aap.h.a;
                                                }
                                                if (iA2 != com.google.android.libraries.navigation.internal.aap.h.b && iA2 != com.google.android.libraries.navigation.internal.aap.h.c) {
                                                    com.google.android.libraries.navigation.internal.aap.n nVar3 = arVarC.f;
                                                    if (nVar3 == null) {
                                                        nVar3 = com.google.android.libraries.navigation.internal.aap.n.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.aas.b bVar2 = nVar3.c;
                                                    if (bVar2 == null) {
                                                        bVar2 = com.google.android.libraries.navigation.internal.aas.b.a;
                                                    }
                                                    xVarZ = com.google.android.libraries.navigation.internal.oe.x.y(bVar2);
                                                }
                                            }
                                        }
                                        if (xVarZ != null) {
                                            ev evVarD2 = com.google.android.libraries.navigation.internal.ck.bg.d(xVar3, xVarZ);
                                            if (!evVarD2.isEmpty()) {
                                                com.google.android.libraries.navigation.internal.ck.a aVarB2 = be.b(evVarD2, com.google.android.libraries.navigation.internal.ady.al.WALK);
                                                aVarB2.d(true);
                                                aVarB2.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar2));
                                                aVarB2.b(com.google.android.libraries.navigation.internal.ck.bg.a(bgVar8.i));
                                                bgVar8.i.add(aVarB2.a());
                                            }
                                        }
                                    }
                                }
                                i8++;
                                arrayList3 = arrayList9;
                            }
                        } else {
                            ev evVarA = cc.a(bgVar9);
                            com.google.android.libraries.navigation.internal.bp.b bVar3 = bgVar9.w;
                            if (bVar3 == null || !bgVar8.g) {
                                int i21 = ev.d;
                                evVar = lv.a;
                            } else {
                                evVar = ((com.google.android.libraries.navigation.internal.bp.g) bVar3).b;
                            }
                            if (bgVar9.q() == null) {
                                com.google.android.libraries.navigation.internal.ck.a aVarA = be.a(bgVar9.m, bgVar9.j);
                                aVarA.g(cc.b(bgVar8.b));
                                aVarA.f(evVarA);
                                aVarA.e(evVar);
                                aVarA.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar9));
                                bgVar8.i.add(aVarA.a());
                            } else {
                                List listO = bgVar9.O();
                                com.google.android.libraries.navigation.internal.bp.av[] avVarArr = bgVar9.g.b;
                                int i22 = 0;
                                int i23 = 0;
                                while (i22 < avVarArr.length) {
                                    com.google.android.libraries.navigation.internal.bp.av avVar = avVarArr[i22];
                                    com.google.android.libraries.navigation.internal.bp.av[] avVarArr2 = avVarArr;
                                    com.google.android.libraries.navigation.internal.ady.al alVar2 = bgVar9.j;
                                    if (!avVar.f() || (avVar.d().b & 1) == 0) {
                                        alVarB = alVar2;
                                    } else {
                                        alVarB = com.google.android.libraries.navigation.internal.ady.al.b(avVar.d().c);
                                        if (alVarB == null) {
                                            alVarB = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
                                        }
                                    }
                                    com.google.android.libraries.navigation.internal.oe.ad adVarC = ((com.google.android.libraries.navigation.internal.oe.an) listO.get(i22)).c();
                                    boolean z5 = i22 == 0;
                                    if (alVarB == com.google.android.libraries.navigation.internal.ady.al.WALK) {
                                        bq[] bqVarArr2 = bgVar9.l;
                                        bhVar2 = bhVar4;
                                        int length3 = bqVarArr2.length;
                                        dVar = dVarB2;
                                        int i24 = 0;
                                        while (true) {
                                            if (i24 < length3) {
                                                int i25 = length3;
                                                if (bqVarArr2[i24].D != null) {
                                                    if (i22 == 0) {
                                                        bqVarArrAb = bgVar9.ab();
                                                    } else {
                                                        int i26 = i22 - 1;
                                                        bqVarArrAb = (i26 < i22 && bgVar9.T(i26) && bgVar9.T(i22)) ? (bq[]) Arrays.copyOfRange(bgVar9.l, bgVar9.k(i26), bgVar9.k(i22)) : new bq[0];
                                                    }
                                                    List listQ = adVarC.q();
                                                    if (bgVar9.j == com.google.android.libraries.navigation.internal.ady.al.WALK && bqVarArrAb.length > 0) {
                                                        int i27 = ev.d;
                                                        eq eqVar2 = new eq();
                                                        eq eqVar3 = new eq();
                                                        i2 = i15;
                                                        boolean z6 = bqVarArrAb[0].D != null;
                                                        arrayList7 = arrayList7;
                                                        int i28 = 1;
                                                        int i29 = 0;
                                                        int i30 = 0;
                                                        while (true) {
                                                            length = bqVarArrAb.length;
                                                            if (i28 >= length) {
                                                                break;
                                                            }
                                                            boolean z7 = bqVarArrAb[i28].D != null;
                                                            if (z6 != z7) {
                                                                eqVar2.h(Boolean.valueOf(z6));
                                                                eqVar3.h(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i30), Integer.valueOf(i28)));
                                                                i29 = i28;
                                                                i30 = i29;
                                                                z6 = z7;
                                                            }
                                                            i28++;
                                                        }
                                                        int i31 = length - 1;
                                                        if (i29 < i31) {
                                                            eqVar2.h(Boolean.valueOf(z6));
                                                            eqVar3.h(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i30), Integer.valueOf(i31)));
                                                        }
                                                        ev evVarG2 = eqVar2.g();
                                                        ev evVarG3 = eqVar3.g();
                                                        ArrayList arrayList10 = new ArrayList();
                                                        int i32 = 0;
                                                        while (true) {
                                                            if (i32 >= ((lv) evVarG3).c) {
                                                                evVar3 = evVar;
                                                                bgVarE = bgVarE;
                                                                bgVar8.i.addAll(arrayList10);
                                                                break;
                                                            }
                                                            com.google.android.libraries.navigation.internal.yx.ao aoVar2 = (com.google.android.libraries.navigation.internal.yx.ao) evVarG3.get(i32);
                                                            int i33 = i23 == 0 ? 0 : i23 - 1;
                                                            int i34 = bqVarArrAb[((Integer) aoVar2.a).intValue()].k - i33;
                                                            evVar3 = evVar;
                                                            int size3 = i32 != ((lv) evVarG3).c + (-1) ? bqVarArrAb[((Integer) aoVar2.b).intValue()].k - i33 : listQ.size() - 1;
                                                            if (i34 >= 0 && size3 < listQ.size() && i34 <= size3) {
                                                                com.google.android.libraries.navigation.internal.ck.a aVarB3 = be.b(listQ.subList(i34, size3 + 1), com.google.android.libraries.navigation.internal.ady.al.WALK);
                                                                aVarB3.c(z5);
                                                                aVarB3.b = ((Boolean) evVarG2.get(i32)).booleanValue();
                                                                aVarB3.f = (short) (aVarB3.f | 4);
                                                                aVarB3.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar9));
                                                                aVarB3.b(com.google.android.libraries.navigation.internal.ck.bg.a(arrayList10.isEmpty() ? bgVar8.i : arrayList10));
                                                                arrayList10.add(aVarB3.a());
                                                                i32++;
                                                                bgVarE = bgVarE;
                                                                evVar = evVar3;
                                                            }
                                                            com.google.android.libraries.navigation.internal.ck.a aVarB4 = be.b(listQ, com.google.android.libraries.navigation.internal.ady.al.WALK);
                                                            aVarB4.c(z5);
                                                            aVarB4.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar9));
                                                            aVarB4.b(com.google.android.libraries.navigation.internal.ck.bg.a(bgVar8.i));
                                                            bgVar8.i.add(aVarB4.a());
                                                            break;
                                                        }
                                                    }
                                                    evVar3 = evVar;
                                                    bgVarE = bgVarE;
                                                    arrayList7 = arrayList7;
                                                    i2 = i15;
                                                    i23 = bqVarArrAb[bqVarArrAb.length - 1].k + 1;
                                                    evVar2 = evVar3;
                                                } else {
                                                    i24++;
                                                    length3 = i25;
                                                }
                                            }
                                            i22++;
                                            evVar = evVar2;
                                            avVarArr = avVarArr2;
                                            listO = listO;
                                            bhVar4 = bhVar2;
                                            dVarB2 = dVar;
                                            i15 = i2;
                                            arrayList7 = arrayList7;
                                            bgVarE = bgVarE;
                                        }
                                    } else {
                                        dVar = dVarB2;
                                        bhVar2 = bhVar4;
                                    }
                                    i2 = i15;
                                    List list = (List) bgVar8.c.get(Integer.valueOf(i22));
                                    if (list == null) {
                                        int i35 = ev.d;
                                        list = lv.a;
                                    }
                                    if (bgVar9.j.equals(com.google.android.libraries.navigation.internal.ady.al.DRIVE) && i22 == 0) {
                                        bgVar8.f.f();
                                    }
                                    com.google.android.libraries.navigation.internal.ck.a aVarA2 = be.a(adVarC, alVarB);
                                    aVarA2.c(z5);
                                    aVarA2.g(cc.b(bgVar8.b));
                                    aVarA2.f(evVarA);
                                    evVar2 = evVar;
                                    aVarA2.e(evVar2);
                                    Objects.requireNonNull(list);
                                    aVarA2.e = list;
                                    aVarA2.f = (short) (aVarA2.f | 512);
                                    aVarA2.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar9));
                                    aVarA2.b(com.google.android.libraries.navigation.internal.ck.bg.a(bgVar8.i));
                                    bgVar8.i.add(aVarA2.a());
                                    i22++;
                                    evVar = evVar2;
                                    avVarArr = avVarArr2;
                                    listO = listO;
                                    bhVar4 = bhVar2;
                                    dVarB2 = dVar;
                                    i15 = i2;
                                    arrayList7 = arrayList7;
                                    bgVarE = bgVarE;
                                }
                            }
                            try {
                                bgVar = bgVarE;
                                dVar = dVarB2;
                                arrayList2 = arrayList7;
                                bhVar = bhVar4;
                                i = i15;
                                bg bgVar10 = bgVar8.e;
                                cf cfVar = bgVar10.g;
                                bq[] bqVarArrAa = bgVar10.aa();
                                List listN2 = bgVar10.N();
                                if (!listN2.isEmpty()) {
                                    for (int i36 = 0; i36 < bgVar10.m(); i36++) {
                                        if (i36 == 0) {
                                            xVar = (com.google.android.libraries.navigation.internal.oe.x) listN2.get(0);
                                        } else if (i36 == bgVar10.m() - 1) {
                                            xVar = (com.google.android.libraries.navigation.internal.oe.x) gs.d(listN2);
                                        } else {
                                            int i37 = i36 - 1;
                                            if (i37 < bqVarArrAa.length && bqVarArrAa[i37].k < listN2.size()) {
                                                xVar = (com.google.android.libraries.navigation.internal.oe.x) listN2.get(bqVarArrAa[i37].k);
                                            }
                                        }
                                        com.google.android.libraries.navigation.internal.oe.x xVarZ2 = com.google.android.libraries.navigation.internal.oe.x.z(bgVar10.v(i36).n());
                                        if (i36 > 0 && com.google.android.libraries.navigation.internal.ck.bg.e(bgVar8.h, bgVar8.d.m())) {
                                            int i38 = i36 - 1;
                                            if (bgVar10.g.c(i38).e()) {
                                                com.google.android.libraries.navigation.internal.adr.ar arVarC2 = bgVar10.g.c(i38).c();
                                                if ((arVarC2.b & 64) != 0) {
                                                    com.google.android.libraries.navigation.internal.aap.n nVar4 = arVarC2.f;
                                                    if (nVar4 == null) {
                                                        nVar4 = com.google.android.libraries.navigation.internal.aap.n.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.aas.b bVar4 = nVar4.c;
                                                    if (bVar4 == null) {
                                                        bVar4 = com.google.android.libraries.navigation.internal.aas.b.a;
                                                    }
                                                    xVarZ2 = com.google.android.libraries.navigation.internal.oe.x.y(bVar4);
                                                }
                                            }
                                        }
                                        Iterator it2 = cfVar.a.z.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                z2 = false;
                                                break;
                                            }
                                            kh khVar = (kh) it2.next();
                                            if (khVar.c == i36) {
                                                z2 = khVar.d;
                                                break;
                                            }
                                        }
                                        if (xVar != null && xVarZ2 != null && !z2) {
                                            ev evVarD3 = com.google.android.libraries.navigation.internal.ck.bg.d(xVar, xVarZ2);
                                            if (!evVarD3.isEmpty()) {
                                                com.google.android.libraries.navigation.internal.ck.a aVarB5 = be.b(evVarD3, com.google.android.libraries.navigation.internal.ady.al.WALK);
                                                aVarB5.d(true);
                                                aVarB5.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar10));
                                                aVarB5.b(com.google.android.libraries.navigation.internal.ck.bg.a(bgVar8.i));
                                                bgVar8.i.add(aVarB5.a());
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th12) {
                                th = th12;
                                th = th;
                                if (dVar == null) {
                                    throw th;
                                }
                                Trace.endSection();
                                throw th;
                            }
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        dVar = dVarB2;
                    }
                } else {
                    bgVar = bgVarE;
                    dVar = dVarB2;
                    arrayList2 = arrayList7;
                    bhVar = bhVar4;
                    i = i15;
                    bgVar2 = bgVar8.e;
                    listN = bgVar2.N();
                    i3 = bgVar8.a;
                    com.google.android.libraries.navigation.internal.fz.d dVar3 = bgVar8.d;
                    int i110 = ev.d;
                    eqVar = new eq();
                    bqVarArr = bgVar2.l;
                    qjVarW = dVar3.W();
                    zBooleanValue = qjVarW.p;
                    length2 = bqVarArr.length;
                    i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            str = "";
                            break;
                        }
                        bqVar = bqVarArr[i4];
                        btVar = bqVar.b;
                        if (btVar != null) {
                            jkVar = null;
                        } else if ((btVar.h().b & 2) != 0) {
                            jkVar = btVar.h().c;
                            if (jkVar == null) {
                                jkVar = jk.a;
                            }
                        } else {
                            btVar2 = bqVar.b;
                            bqVar2 = bqVar.N;
                            while (true) {
                                if (bqVar2 == null) {
                                    btVar3 = null;
                                    break;
                                }
                                btVar3 = bqVar2.b;
                                if (btVar3 != btVar2) {
                                    break;
                                    break;
                                }
                                bqVar2 = bqVar2.N;
                            }
                            if (btVar3 != null) {
                                if ((btVar3.h().b & 4) != 0) {
                                    jkVar = btVar3.h().d;
                                    if (jkVar == null) {
                                        jkVar = jk.a;
                                    }
                                } else {
                                    btVar4 = bqVar.b;
                                    bqVar3 = bqVar.M;
                                    while (true) {
                                        if (bqVar3 == null) {
                                            btVar5 = null;
                                            break;
                                        }
                                        btVar5 = bqVar3.b;
                                        if (btVar5 != btVar4) {
                                            break;
                                            break;
                                        }
                                        bqVar3 = bqVar3.M;
                                    }
                                    if (btVar5 != null) {
                                        jkVar = btVar5.h().c;
                                        if (jkVar == null) {
                                            jkVar = jk.a;
                                        }
                                    }
                                }
                            }
                            jkVar = null;
                        }
                        if (jkVar == null) {
                            str = "";
                        } else {
                            str = jkVar.e;
                        }
                        if (!str.isEmpty()) {
                            break;
                            break;
                        }
                        i4++;
                    }
                    if (str.isEmpty()) {
                        mapUnmodifiableMap = Collections.unmodifiableMap(qjVarW.q);
                        if (mapUnmodifiableMap.containsKey(str)) {
                            zBooleanValue = ((Boolean) mapUnmodifiableMap.get(str)).booleanValue();
                        }
                    }
                    bfVarC = com.google.android.libraries.navigation.internal.ck.bg.c(bqVarArr[0], i3, zBooleanValue);
                    eqVar.h(bfVarC);
                    while (i5 < bqVarArr.length) {
                        bfVarC2 = com.google.android.libraries.navigation.internal.ck.bg.c(bqVarArr[i5], i3, zBooleanValue);
                        if (bfVarC2.c() == ((com.google.android.libraries.navigation.internal.ck.d) bfVarC).b) {
                            i14 = bfVarC2.a().b;
                            biVar = ((com.google.android.libraries.navigation.internal.ck.d) bfVarC).a;
                            if (i14 == biVar.b) {
                                eqVar.h(bfVarC2);
                                bfVarC = bfVarC2;
                            } else {
                                eqVar.h(bfVarC2);
                                bfVarC = bfVarC2;
                            }
                        } else {
                            eqVar.h(bfVarC2);
                            bfVarC = bfVarC2;
                        }
                    }
                    evVarG = eqVar.g();
                    arrayList3 = new ArrayList();
                    bfVar = (bf) evVarG.get(0);
                    i6 = 0;
                    i7 = 1;
                    while (i7 < ((lv) evVarG).c) {
                        bfVar3 = (bf) evVarG.get(i7);
                        if (bfVar.c() == bfVar3.c()) {
                            arrayList3.add(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i6), Integer.valueOf(i7)));
                            i6 = i7;
                        } else {
                            arrayList3.add(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i6), Integer.valueOf(i7)));
                            i6 = i7;
                        }
                        i7++;
                        bfVar = bfVar3;
                    }
                    arrayList3.add(new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i6), -1));
                    size = arrayList3.size() - 1;
                    i8 = 0;
                    while (i8 < arrayList3.size()) {
                        aoVar = (com.google.android.libraries.navigation.internal.yx.ao) arrayList3.get(i8);
                        bf bfVar5 = (bf) evVarG.get(((Integer) aoVar.a).intValue());
                        arrayList4 = new ArrayList();
                        i9 = ((bf) evVarG.get(((Integer) aoVar.a).intValue())).a().a;
                        iIntValue = ((Integer) aoVar.a).intValue();
                        while (iIntValue < ((Integer) aoVar.b).intValue()) {
                            bi biVarA2 = ((bf) evVarG.get(iIntValue)).a();
                            arrayList4.add(new bi(biVarA2.a - i9, biVarA2.b, biVarA2.c));
                            iIntValue++;
                            arrayList3 = arrayList3;
                        }
                        ArrayList arrayList11 = arrayList3;
                        arrayList5 = new ArrayList();
                        bfVar2 = (bf) evVarG.get(((Integer) aoVar.a).intValue());
                        if (bfVar2.c().equals(com.google.android.libraries.navigation.internal.ady.al.TRANSIT)) {
                            iA = (int) bgVar2.a(bfVar2.a().a);
                            iIntValue2 = ((Integer) aoVar.a).intValue();
                            if (i8 == size) {
                                iIntValue3 = ((lv) evVarG).c;
                            } else {
                                iIntValue3 = ((Integer) aoVar.b).intValue();
                            }
                            while (iIntValue2 < iIntValue3) {
                                if (((bf) evVarG.get(iIntValue2)).a().c) {
                                    bgVar4 = bgVar8;
                                    i13 = iA;
                                } else {
                                    evVarB = ((bf) evVarG.get(iIntValue2)).b();
                                    i11 = ((lv) evVarB).c;
                                    i12 = 0;
                                    while (i12 < i11) {
                                        ev evVar6 = evVarB;
                                        in inVar3 = (in) evVarB.get(i12);
                                        int i111 = i11;
                                        ikVar = (ik) in.a.r(inVar3);
                                        int i112 = inVar3.d - iA;
                                        int i113 = iA;
                                        if (!ikVar.b.H()) {
                                            ikVar.v();
                                        }
                                        in inVar4 = (in) ikVar.b;
                                        inVar4.b |= 2;
                                        inVar4.d = i112;
                                        arrayList5.add((in) ikVar.t());
                                        i12++;
                                        i11 = i111;
                                        evVarB = evVar6;
                                        iA = i113;
                                        bgVar8 = bgVar8;
                                    }
                                    bgVar4 = bgVar8;
                                    i13 = iA;
                                }
                                iIntValue2++;
                                iIntValue3 = iIntValue3;
                                iA = i13;
                                bgVar8 = bgVar4;
                            }
                            bgVar3 = bgVar8;
                        } else {
                            bgVar3 = bgVar8;
                            arrayList5.addAll(bfVar2.b());
                        }
                        zD = bfVar5.d();
                        int i210 = bfVar5.a().a;
                        if (i8 != size) {
                            size2 = ((bf) evVarG.get(((Integer) aoVar.b).intValue())).a().a + 1;
                        } else {
                            size2 = listN.size();
                        }
                        listSubList = listN.subList(i210, size2);
                        if (zD) {
                            arrayList6 = new ArrayList();
                            i10 = 0;
                            while (i10 < listSubList.size() - 1) {
                                com.google.android.libraries.navigation.internal.oe.x xVar4 = (com.google.android.libraries.navigation.internal.oe.x) listSubList.get(i10);
                                i10++;
                                arrayList6.addAll(com.google.android.libraries.navigation.internal.ck.bg.d(xVar4, (com.google.android.libraries.navigation.internal.oe.x) listSubList.get(i10)));
                            }
                            listSubList = arrayList6;
                        }
                        com.google.android.libraries.navigation.internal.ck.a aVarB6 = be.b(listSubList, bfVar5.c());
                        aVarB6.d = arrayList4;
                        aVarB6.f = (short) (aVarB6.f | 16);
                        aVarB6.d(zD);
                        aVarB6.f(arrayList5);
                        aVarB6.h(com.google.android.libraries.navigation.internal.ck.bg.b(bgVar2));
                        bgVar8 = bgVar3;
                        aVarB6.b(com.google.android.libraries.navigation.internal.ck.bg.a(bgVar8.i));
                        bgVar8.i.add(aVarB6.a());
                        if (i8 != size) {
                        }
                        i8++;
                        arrayList3 = arrayList11;
                    }
                }
                bhVar3 = new com.google.android.libraries.navigation.internal.ck.bh(bgVar8.i);
                fdVar = ma.b;
                dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsOverlayManager.configPickHandlers()");
            }
            dVar = dVarB2;
            ArrayList arrayList12 = arrayList7;
            synchronized (amVar2.X) {
                ak akVar = amVar2.Y;
                if (akVar != null && (zVar = akVar.c) != null) {
                    List<el> list2 = zVar.m;
                    int i39 = ev.d;
                    eq eqVar4 = new eq();
                    for (el elVar : list2) {
                        if (((elVar.c == 22 ? (fh) elVar.d : fh.a).b & 512) != 0) {
                            fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
                            if (fgVar == null) {
                                fgVar = fg.a;
                            }
                            com.google.android.libraries.navigation.internal.oe.ad adVarM = com.google.android.libraries.navigation.internal.oe.ad.m(fgVar.c == 1 ? (com.google.android.libraries.navigation.internal.adr.ab) fgVar.d : com.google.android.libraries.navigation.internal.adr.ab.a);
                            try {
                                com.google.android.libraries.navigation.internal.on.h hVar2 = zVar.f350n;
                                com.google.android.libraries.navigation.internal.ol.ax axVar = zVar.i;
                                com.google.android.libraries.navigation.internal.ol.aq aqVar = com.google.android.libraries.navigation.internal.bq.e.b(fgVar, axVar).a;
                                int i40 = com.google.android.libraries.navigation.internal.bq.e.b(fgVar, axVar).d;
                                com.google.android.libraries.navigation.internal.ol.p pVarH = hVar2.h(adVarM.q(), aqVar, i40, i40, cz.a);
                                pVarH.k(new com.google.android.libraries.navigation.internal.bo.y(zVar, elVar));
                                eqVar4.h(pVarH);
                            } catch (IllegalArgumentException unused) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.bo.z.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(ClassUtils.PACKAGE_SEPARATOR_CHAR)).p("Invalid vertex encoding. Should not happen considering we hardcode a lat/lng e7 encoding.");
                            }
                        }
                    }
                    zVar.l = eqVar4.g();
                    Iterator it3 = hx.g(zVar.l).iterator();
                    while (it3.hasNext()) {
                        zVar.h.at((com.google.android.libraries.navigation.internal.ol.p) it3.next());
                    }
                }
            }
            if (dVar != null) {
                Trace.endSection();
            }
            return arrayList12;
        } catch (Throwable th14) {
            th = th14;
            dVar = dVarB2;
        }
    }

    public final void f() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        com.google.android.libraries.navigation.internal.po.Cdo cdo = ((fk) this.i.b()).G;
        for (com.google.android.libraries.navigation.internal.ol.p pVar : this.A) {
            cdo.e(pVar);
            cdo.c(pVar);
        }
        this.A.clear();
        Iterator it2 = this.B.iterator();
        while (it2.hasNext()) {
            ((al) it2.next()).a().e((com.google.android.libraries.navigation.internal.ol.ax) this.w.a());
        }
        this.B.clear();
    }

    public final void g() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        ak akVar = this.Y;
        if (akVar != null) {
            akVar.b();
            this.Y = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.libraries.navigation.internal.pc.e, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h() {
        if (this.T.getAndSet(false)) {
            this.p.b(this);
            if (this.au.g()) {
                ((com.google.android.libraries.navigation.internal.cp.o) this.au.c()).a = null;
                this.ar.b(this.au.c());
            }
            this.d.d(this);
            com.google.android.libraries.navigation.internal.ed.b bVar = this.F;
            bVar.a().h(this.W);
            this.e.e(this);
            this.aa.b(this);
            synchronized (this.X) {
                ak akVar = this.Y;
                if (akVar != null) {
                    akVar.b();
                }
            }
            com.google.android.libraries.navigation.internal.ck.ac acVar = ((ce) this.C).a;
            Iterator it2 = acVar.d.values().iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.ol.ax) acVar.a.a()).j((com.google.android.libraries.navigation.internal.ol.aq) ((com.google.android.libraries.navigation.internal.ck.aa) it2.next()).a.a());
            }
            Iterator it3 = acVar.c.values().iterator();
            while (it3.hasNext()) {
                ((com.google.android.libraries.navigation.internal.ol.ax) acVar.a.a()).j((com.google.android.libraries.navigation.internal.ol.aq) it3.next());
            }
            acVar.c.clear();
            acVar.d.clear();
            t();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.c
    public final void i(com.google.android.libraries.navigation.internal.rw.p pVar, com.google.android.libraries.navigation.internal.rw.p pVar2) {
        final com.google.android.libraries.navigation.internal.bo.t tVar;
        this.ah = pVar2;
        if (pVar == com.google.android.libraries.navigation.internal.rw.p.OFF || pVar2 == com.google.android.libraries.navigation.internal.rw.p.OFF) {
            synchronized (this.X) {
                ak akVar = this.Y;
                if (akVar != null && (tVar = akVar.a.c) != null) {
                    tVar.d = pVar2;
                    tVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            t tVar2 = tVar;
                            if (tVar2.e()) {
                                tVar2.c();
                                return;
                            }
                            Iterator it2 = tVar2.e.iterator();
                            while (it2.hasNext()) {
                                ((com.google.android.libraries.navigation.internal.cm.a) it2.next()).a.b();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.rw.r
    public final void j(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        synchronized (this.X) {
            com.google.android.libraries.navigation.internal.se.b bVarC = oVar.c();
            int i = bVarC.b.J;
            int i2 = bVarC.j;
            if (i2 == -1) {
                i2 = 0;
            } else if (i2 > i) {
                i2 = i;
            }
            com.google.android.libraries.navigation.internal.cn.aa aaVar = (com.google.android.libraries.navigation.internal.cn.aa) this.au.f();
            int i3 = i - i2;
            if (aaVar != null && aaVar.d()) {
                oVar.a();
                aaVar.e(i3);
            }
            ak akVar = this.Y;
            if (akVar != null) {
                no it2 = akVar.b.iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.bo.ao aoVar = (com.google.android.libraries.navigation.internal.bo.ao) it2.next();
                    boolean z = aoVar.d;
                    if (aoVar.b) {
                        com.google.android.libraries.navigation.internal.dx.a aVar = aoVar.y.c;
                    }
                }
            }
            this.Q = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cn.v
    public final void k(ev evVar) {
        this.P = evVar;
        com.google.android.libraries.navigation.internal.ady.al alVarS = s();
        if (alVarS != null && alVarS.ordinal() == 0) {
            synchronized (this.X) {
                ak akVar = this.Y;
                if (akVar != null && this.O != null) {
                    no it2 = akVar.b.iterator();
                    while (it2.hasNext()) {
                        com.google.android.libraries.navigation.internal.bo.ao aoVar = (com.google.android.libraries.navigation.internal.bo.ao) it2.next();
                        com.google.android.libraries.navigation.internal.cq.ag agVarC = c(aoVar.a(), evVar);
                        if (agVarC != null) {
                            aoVar.B = agVarC;
                            aoVar.e();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cn.v
    public final void l(Map map) {
        boolean zEquals = this.O.equals(map);
        this.O = map;
        com.google.android.libraries.navigation.internal.ady.al alVarS = s();
        if (alVarS == null || zEquals) {
            return;
        }
        int iOrdinal = alVarS.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 2) {
                this.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.libraries.navigation.internal.bq.a aVar;
                        am amVar = this.a;
                        synchronized (amVar.U) {
                            aj ajVar = amVar.V.b;
                            if (ajVar != null && (aVar = amVar.M) != null) {
                                ajVar.b(aVar);
                            }
                        }
                    }
                });
                return;
            } else if (iOrdinal != 5) {
                return;
            }
        }
        synchronized (this.X) {
            ak akVar = this.Y;
            if (akVar != null && this.O != null) {
                no it2 = akVar.b.iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.bo.ao aoVar = (com.google.android.libraries.navigation.internal.bo.ao) it2.next();
                    if (this.O.containsKey(Long.valueOf(aoVar.a()))) {
                        Map map2 = (Map) this.O.get(Long.valueOf(aoVar.a()));
                        com.google.android.libraries.navigation.internal.yx.ar.q(map2);
                        aoVar.A = map2;
                        aoVar.e();
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rr.c
    public final void m(com.google.android.libraries.navigation.internal.acg.j jVar) {
        com.google.android.libraries.navigation.internal.acg.l lVar;
        if (s() == com.google.android.libraries.navigation.internal.ady.al.BICYCLE || (lVar = this.N) == null) {
            return;
        }
        v(lVar.b, jVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.rr.d
    public final void n(com.google.android.libraries.navigation.internal.acg.l lVar) {
        this.N = lVar;
        v(lVar.b, lVar.c);
    }

    final void o(com.google.android.libraries.navigation.internal.cl.be beVar) {
        synchronized (this.X) {
            ak akVar = this.Y;
            if (akVar != null) {
                com.google.android.libraries.navigation.internal.bo.e eVar = akVar.a;
                if (eVar.a != beVar) {
                    eVar.a = beVar;
                    synchronized (eVar.d) {
                        eVar.c();
                        eVar.a();
                    }
                }
            }
        }
    }

    public final boolean p(com.google.android.libraries.navigation.internal.bt.h hVar) {
        if (this.t) {
            return this.ah == com.google.android.libraries.navigation.internal.rw.p.GUIDING;
        }
        return ((com.google.android.libraries.navigation.internal.bt.b) hVar).p;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x07a4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.libraries.navigation.internal.bm.am] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.libraries.navigation.internal.bm.am] */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.libraries.navigation.internal.nw.d] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(com.google.android.libraries.navigation.internal.bt.h hVar, boolean z, m mVar) {
        ?? r25;
        com.google.android.libraries.navigation.internal.ady.al alVar;
        final com.google.android.libraries.navigation.internal.bt.h hVar2;
        bh bhVar;
        ArrayList arrayList;
        int i;
        com.google.android.libraries.navigation.internal.acg.o oVar;
        long j;
        Optional optionalOf;
        int iN;
        ?? r1 = this;
        com.google.android.libraries.navigation.internal.nj.i.b();
        ?? B = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsOverlayManager.createOverlayInternal()");
        try {
            final ag agVar = new ag(r1, hVar, mVar);
            synchronized (r1.U) {
                try {
                    if (!z) {
                        try {
                            an anVar = r1.V;
                            if (!anVar.c && hVar.equals(anVar.a)) {
                                r25 = B;
                                r1 = r1;
                                B = B;
                            }
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                throw th;
                            }
                        }
                    }
                    an anVar2 = r1.V;
                    com.google.android.libraries.navigation.internal.bt.h hVar3 = anVar2.a;
                    anVar2.a = hVar;
                    anVar2.b = agVar;
                    anVar2.c = false;
                    if (r1.au.g()) {
                        t();
                        r1.au = com.google.android.libraries.navigation.internal.yx.a.a;
                    }
                    r1.aq.g();
                    com.google.android.libraries.navigation.internal.ady.al alVarC = ((com.google.android.libraries.navigation.internal.bt.b) hVar).a.c();
                    if (alVarC != null) {
                        boolean zP = p(hVar);
                        Object objC = r1.aq.c();
                        com.google.android.libraries.navigation.internal.cn.a aVar = new com.google.android.libraries.navigation.internal.cn.a();
                        aVar.b(false);
                        aVar.a(0);
                        Objects.requireNonNull(alVarC);
                        aVar.a = alVarC;
                        aVar.f = (com.google.android.libraries.navigation.internal.ol.ax) r1.w.a();
                        aVar.g = r1.x;
                        aVar.h = r1.f345n;
                        aVar.i = r1.s;
                        aVar.b = r1.t;
                        aVar.m = (byte) (aVar.m | 1);
                        aVar.b(r1.F.c());
                        aVar.c = zP;
                        aVar.m = (byte) (aVar.m | 2);
                        aVar.a(r1.Q);
                        aVar.j = r1.c;
                        aVar.k = r1.ae;
                        aVar.l = ((com.google.android.libraries.navigation.internal.bt.b) hVar).a.f();
                        if (aVar.m != 15 || (alVar = aVar.a) == null) {
                            throw new IllegalStateException();
                        }
                        r25 = B;
                        try {
                            r1.au = ((com.google.android.libraries.navigation.internal.cp.p) objC).a(new com.google.android.libraries.navigation.internal.cn.b(alVar, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h, aVar.i, aVar.j, aVar.k, aVar.l));
                            r25 = r25;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        Throwable th3 = th;
                        if (r25 == 0) {
                            throw th3;
                        }
                        try {
                            Trace.endSection();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                    r25 = B;
                    ArrayList arrayList2 = new ArrayList();
                    bh bhVar2 = ((com.google.android.libraries.navigation.internal.bt.b) hVar).a;
                    int i2 = 0;
                    r1 = r1;
                    while (i2 < bhVar2.d()) {
                        try {
                            bg bgVarE = bhVar2.e(i2);
                            int iA = r1.a(bgVarE);
                            com.google.android.libraries.navigation.internal.acg.u uVar = (com.google.android.libraries.navigation.internal.acg.u) com.google.android.libraries.navigation.internal.acg.v.a.q();
                            if (!uVar.b.H()) {
                                uVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.v vVar = (com.google.android.libraries.navigation.internal.acg.v) uVar.b;
                            vVar.b |= 1;
                            vVar.c = 0;
                            if (!uVar.b.H()) {
                                uVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.v vVar2 = (com.google.android.libraries.navigation.internal.acg.v) uVar.b;
                            vVar2.b |= 2;
                            vVar2.d = iA;
                            com.google.android.libraries.navigation.internal.acg.v vVar3 = (com.google.android.libraries.navigation.internal.acg.v) uVar.t();
                            ArrayList arrayList3 = new ArrayList();
                            int i3 = 0;
                            for (int i4 = 0; i4 < bgVarE.g.b(); i4++) {
                                arrayList3.add(Integer.valueOf(i3));
                                com.google.android.libraries.navigation.internal.adr.bm bmVar = bgVarE.g.c(i4).d().e;
                                if (bmVar == null) {
                                    bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
                                }
                                int i5 = bmVar.c;
                                i3 += i5;
                                if (iA >= 0 && i5 > iA) {
                                    com.google.android.libraries.navigation.internal.acg.u uVar2 = (com.google.android.libraries.navigation.internal.acg.u) com.google.android.libraries.navigation.internal.acg.v.a.q();
                                    if (!uVar2.b.H()) {
                                        uVar2.v();
                                    }
                                    com.google.android.libraries.navigation.internal.acg.v vVar4 = (com.google.android.libraries.navigation.internal.acg.v) uVar2.b;
                                    vVar4.b |= 1;
                                    vVar4.c = i4;
                                    if (!uVar2.b.H()) {
                                        uVar2.v();
                                    }
                                    com.google.android.libraries.navigation.internal.acg.v vVar5 = (com.google.android.libraries.navigation.internal.acg.v) uVar2.b;
                                    vVar5.b |= 2;
                                    vVar5.d = iA;
                                    vVar3 = (com.google.android.libraries.navigation.internal.acg.v) uVar2.t();
                                }
                                iA -= i5;
                            }
                            com.google.android.libraries.navigation.internal.acg.o oVar2 = (com.google.android.libraries.navigation.internal.acg.o) com.google.android.libraries.navigation.internal.acg.p.a.q();
                            long j2 = bgVarE.Y;
                            if (!oVar2.b.H()) {
                                oVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.p pVar = (com.google.android.libraries.navigation.internal.acg.p) oVar2.b;
                            pVar.b |= 1;
                            pVar.c = j2;
                            if (!oVar2.b.H()) {
                                oVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.p pVar2 = (com.google.android.libraries.navigation.internal.acg.p) oVar2.b;
                            vVar3.getClass();
                            pVar2.d = vVar3;
                            pVar2.b |= 2;
                            long j3 = bgVarE.Y;
                            ki kiVar = bgVarE.g.a;
                            ev evVarO = ev.o(arrayList3);
                            int i6 = bgVarE.J;
                            if (kiVar.h.size() != evVarO.size()) {
                                optionalOf = Optional.empty();
                                arrayList = arrayList2;
                                bhVar = bhVar2;
                                i = i2;
                                oVar = oVar2;
                                j = j3;
                            } else {
                                ArrayList arrayList4 = new ArrayList(evVarO.size());
                                int i7 = 0;
                                while (i7 < evVarO.size()) {
                                    com.google.android.libraries.navigation.internal.ach.e eVar = (com.google.android.libraries.navigation.internal.ach.e) com.google.android.libraries.navigation.internal.ach.f.a.q();
                                    if (!eVar.b.H()) {
                                        eVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.ach.f fVar = (com.google.android.libraries.navigation.internal.ach.f) eVar.b;
                                    bh bhVar3 = bhVar2;
                                    fVar.b |= 1;
                                    fVar.c = i7;
                                    arrayList4.add(eVar);
                                    i7++;
                                    bhVar2 = bhVar3;
                                }
                                bhVar = bhVar2;
                                com.google.android.libraries.navigation.internal.adz.f fVar2 = kiVar.j;
                                if (fVar2 == null) {
                                    fVar2 = com.google.android.libraries.navigation.internal.adz.f.a;
                                }
                                Iterator it2 = fVar2.d.iterator();
                                while (it2.hasNext()) {
                                    com.google.android.libraries.navigation.internal.adz.d dVar = (com.google.android.libraries.navigation.internal.adz.d) it2.next();
                                    int iA2 = com.google.android.libraries.navigation.internal.rs.a.a((dVar.c == 1 ? (com.google.android.libraries.navigation.internal.adz.c) dVar.d : com.google.android.libraries.navigation.internal.adz.c.a).c, evVarO);
                                    Iterator it3 = it2;
                                    int iA3 = com.google.android.libraries.navigation.internal.rs.a.a((dVar.c == 1 ? (com.google.android.libraries.navigation.internal.adz.c) dVar.d : com.google.android.libraries.navigation.internal.adz.c.a).c + (dVar.c == 1 ? (com.google.android.libraries.navigation.internal.adz.c) dVar.d : com.google.android.libraries.navigation.internal.adz.c.a).d, evVarO);
                                    int i8 = (dVar.c == 1 ? (com.google.android.libraries.navigation.internal.adz.c) dVar.d : com.google.android.libraries.navigation.internal.adz.c.a).c;
                                    int i9 = (dVar.c == 1 ? (com.google.android.libraries.navigation.internal.adz.c) dVar.d : com.google.android.libraries.navigation.internal.adz.c.a).d + i8;
                                    if (dVar.H()) {
                                        iN = dVar.n();
                                    } else {
                                        iN = dVar.ak;
                                        if (iN == 0) {
                                            iN = dVar.n();
                                            dVar.ak = iN;
                                        }
                                    }
                                    String string = Integer.toString(iN);
                                    int i10 = iA2;
                                    while (i10 <= iA3) {
                                        int i11 = iA3;
                                        com.google.android.libraries.navigation.internal.ach.a aVar2 = (com.google.android.libraries.navigation.internal.ach.a) com.google.android.libraries.navigation.internal.ach.d.a.q();
                                        int i12 = i2;
                                        ArrayList arrayList5 = arrayList2;
                                        if (dVar.c == 1) {
                                            com.google.android.libraries.navigation.internal.adz.c cVar = (com.google.android.libraries.navigation.internal.adz.c) dVar.d;
                                            com.google.android.libraries.navigation.internal.ach.b bVar = (com.google.android.libraries.navigation.internal.ach.b) com.google.android.libraries.navigation.internal.ach.c.a.q();
                                            if ((cVar.b & 1) != 0) {
                                                int i13 = cVar.c;
                                                if (!bVar.b.H()) {
                                                    bVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.ach.c cVar2 = (com.google.android.libraries.navigation.internal.ach.c) bVar.b;
                                                cVar2.b |= 1;
                                                cVar2.c = i13;
                                            }
                                            if ((cVar.b & 2) != 0) {
                                                int i14 = cVar.d;
                                                if (!bVar.b.H()) {
                                                    bVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.ach.c cVar3 = (com.google.android.libraries.navigation.internal.ach.c) bVar.b;
                                                cVar3.b |= 2;
                                                cVar3.d = i14;
                                            }
                                            com.google.android.libraries.navigation.internal.ach.c cVar4 = (com.google.android.libraries.navigation.internal.ach.c) bVar.t();
                                            if (!aVar2.b.H()) {
                                                aVar2.v();
                                            }
                                            com.google.android.libraries.navigation.internal.ach.d dVar2 = (com.google.android.libraries.navigation.internal.ach.d) aVar2.b;
                                            cVar4.getClass();
                                            dVar2.d = cVar4;
                                            dVar2.c = 3;
                                        } else {
                                            j3 = j3;
                                        }
                                        if (string != null && !string.isEmpty()) {
                                            if (!aVar2.b.H()) {
                                                aVar2.v();
                                            }
                                            com.google.android.libraries.navigation.internal.ach.d dVar3 = (com.google.android.libraries.navigation.internal.ach.d) aVar2.b;
                                            dVar3.b |= 1;
                                            dVar3.e = string;
                                        }
                                        if ((dVar.b & 2) != 0) {
                                            com.google.android.libraries.navigation.internal.aaq.an anVar3 = dVar.e;
                                            if (anVar3 == null) {
                                                anVar3 = com.google.android.libraries.navigation.internal.aaq.an.a;
                                            }
                                            if (!aVar2.b.H()) {
                                                aVar2.v();
                                            }
                                            com.google.android.libraries.navigation.internal.ach.d dVar4 = (com.google.android.libraries.navigation.internal.ach.d) aVar2.b;
                                            anVar3.getClass();
                                            dVar4.f = anVar3;
                                            dVar4.b |= 2;
                                        }
                                        com.google.android.libraries.navigation.internal.ach.d dVar5 = (com.google.android.libraries.navigation.internal.ach.d) aVar2.t();
                                        bb bbVar = (bb) dVar5.aH(5, null);
                                        bbVar.x(dVar5);
                                        com.google.android.libraries.navigation.internal.ach.a aVar3 = (com.google.android.libraries.navigation.internal.ach.a) bbVar;
                                        int iMax = Math.max(((Integer) evVarO.get(i10)).intValue(), i8);
                                        int iMin = Math.min(i9, Math.min(i6, i10 < evVarO.size() + (-1) ? ((Integer) evVarO.get(i10 + 1)).intValue() : i9)) - iMax;
                                        com.google.android.libraries.navigation.internal.ach.b bVar2 = (com.google.android.libraries.navigation.internal.ach.b) com.google.android.libraries.navigation.internal.ach.c.a.q();
                                        int iIntValue = iMax - ((Integer) evVarO.get(i10)).intValue();
                                        if (!bVar2.b.H()) {
                                            bVar2.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ach.c cVar5 = (com.google.android.libraries.navigation.internal.ach.c) bVar2.b;
                                        cVar5.b |= 1;
                                        cVar5.c = iIntValue;
                                        if (!bVar2.b.H()) {
                                            bVar2.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ach.c cVar6 = (com.google.android.libraries.navigation.internal.ach.c) bVar2.b;
                                        cVar6.b |= 2;
                                        cVar6.d = iMin;
                                        if (!aVar3.b.H()) {
                                            aVar3.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ach.d dVar6 = (com.google.android.libraries.navigation.internal.ach.d) aVar3.b;
                                        com.google.android.libraries.navigation.internal.ach.c cVar7 = (com.google.android.libraries.navigation.internal.ach.c) bVar2.t();
                                        cVar7.getClass();
                                        dVar6.d = cVar7;
                                        dVar6.c = 3;
                                        com.google.android.libraries.navigation.internal.ach.e eVar2 = (com.google.android.libraries.navigation.internal.ach.e) arrayList4.get(i10);
                                        if (!eVar2.b.H()) {
                                            eVar2.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ach.f fVar3 = (com.google.android.libraries.navigation.internal.ach.f) eVar2.b;
                                        com.google.android.libraries.navigation.internal.ach.d dVar7 = (com.google.android.libraries.navigation.internal.ach.d) aVar3.t();
                                        com.google.android.libraries.navigation.internal.ach.f fVar4 = com.google.android.libraries.navigation.internal.ach.f.a;
                                        dVar7.getClass();
                                        bz bzVar = fVar3.e;
                                        if (!bzVar.c()) {
                                            fVar3.e = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                        }
                                        fVar3.e.add(dVar7);
                                        i10++;
                                        i2 = i12;
                                        iA3 = i11;
                                        arrayList2 = arrayList5;
                                        oVar2 = oVar2;
                                        j3 = j3;
                                    }
                                    it2 = it3;
                                }
                                arrayList = arrayList2;
                                i = i2;
                                oVar = oVar2;
                                j = j3;
                                com.google.android.libraries.navigation.internal.ach.i iVar = (com.google.android.libraries.navigation.internal.ach.i) com.google.android.libraries.navigation.internal.ach.j.a.q();
                                com.google.android.libraries.navigation.internal.adz.f fVar5 = kiVar.j;
                                if (fVar5 == null) {
                                    fVar5 = com.google.android.libraries.navigation.internal.adz.f.a;
                                }
                                if ((fVar5.b & 1) != 0) {
                                    com.google.android.libraries.navigation.internal.adz.f fVar6 = kiVar.j;
                                    if (fVar6 == null) {
                                        fVar6 = com.google.android.libraries.navigation.internal.adz.f.a;
                                    }
                                    com.google.android.libraries.navigation.internal.aaq.ar arVar = fVar6.c;
                                    if (arVar == null) {
                                        arVar = com.google.android.libraries.navigation.internal.aaq.ar.a;
                                    }
                                    if (!iVar.b.H()) {
                                        iVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.ach.j jVar = (com.google.android.libraries.navigation.internal.ach.j) iVar.b;
                                    arVar.getClass();
                                    jVar.d = arVar;
                                    jVar.b |= 2;
                                }
                                for (int i15 = 0; i15 < kiVar.h.size(); i15++) {
                                    if ((((gj) kiVar.h.get(i15)).b & 2) != 0) {
                                        com.google.android.libraries.navigation.internal.ach.e eVar3 = (com.google.android.libraries.navigation.internal.ach.e) arrayList4.get(i15);
                                        com.google.android.libraries.navigation.internal.aaq.b bVar3 = ((gj) kiVar.h.get(i15)).d;
                                        if (bVar3 == null) {
                                            bVar3 = com.google.android.libraries.navigation.internal.aaq.b.a;
                                        }
                                        if (!eVar3.b.H()) {
                                            eVar3.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ach.f fVar7 = (com.google.android.libraries.navigation.internal.ach.f) eVar3.b;
                                        com.google.android.libraries.navigation.internal.ach.f fVar8 = com.google.android.libraries.navigation.internal.ach.f.a;
                                        bVar3.getClass();
                                        fVar7.d = bVar3;
                                        fVar7.b |= 2;
                                    }
                                    Iterator it4 = ((gj) kiVar.h.get(i15)).e.iterator();
                                    while (it4.hasNext()) {
                                        for (hv hvVar : ((ib) it4.next()).d) {
                                            com.google.android.libraries.navigation.internal.ach.e eVar4 = (com.google.android.libraries.navigation.internal.ach.e) arrayList4.get(i15);
                                            com.google.android.libraries.navigation.internal.ach.g gVar = (com.google.android.libraries.navigation.internal.ach.g) com.google.android.libraries.navigation.internal.ach.h.a.q();
                                            com.google.android.libraries.navigation.internal.aaq.ap apVar = hvVar.e;
                                            if (apVar == null) {
                                                apVar = com.google.android.libraries.navigation.internal.aaq.ap.a;
                                            }
                                            if (!gVar.b.H()) {
                                                gVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.ach.h hVar4 = (com.google.android.libraries.navigation.internal.ach.h) gVar.b;
                                            apVar.getClass();
                                            hVar4.c = apVar;
                                            hVar4.b |= 1;
                                            if (!eVar4.b.H()) {
                                                eVar4.v();
                                            }
                                            com.google.android.libraries.navigation.internal.ach.f fVar9 = (com.google.android.libraries.navigation.internal.ach.f) eVar4.b;
                                            com.google.android.libraries.navigation.internal.ach.h hVar5 = (com.google.android.libraries.navigation.internal.ach.h) gVar.t();
                                            com.google.android.libraries.navigation.internal.ach.f fVar10 = com.google.android.libraries.navigation.internal.ach.f.a;
                                            hVar5.getClass();
                                            bz bzVar2 = fVar9.f;
                                            if (!bzVar2.c()) {
                                                fVar9.f = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                            }
                                            fVar9.f.add(hVar5);
                                        }
                                    }
                                }
                                int size = arrayList4.size();
                                for (int i16 = 0; i16 < size; i16++) {
                                    com.google.android.libraries.navigation.internal.ach.f fVar11 = (com.google.android.libraries.navigation.internal.ach.f) ((com.google.android.libraries.navigation.internal.ach.e) arrayList4.get(i16)).t();
                                    if (!iVar.b.H()) {
                                        iVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.ach.j jVar2 = (com.google.android.libraries.navigation.internal.ach.j) iVar.b;
                                    fVar11.getClass();
                                    bz bzVar3 = jVar2.e;
                                    if (!bzVar3.c()) {
                                        jVar2.e = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar3);
                                    }
                                    jVar2.e.add(fVar11);
                                }
                                optionalOf = Optional.of((com.google.android.libraries.navigation.internal.ach.j) iVar.t());
                            }
                            com.google.android.libraries.navigation.internal.yx.an anVarH = com.google.android.libraries.navigation.internal.yx.an.h(optionalOf);
                            if (anVarH.g()) {
                                com.google.android.libraries.navigation.internal.ach.j jVar3 = (com.google.android.libraries.navigation.internal.ach.j) anVarH.c();
                                bb bbVar2 = (bb) jVar3.aH(5, null);
                                bbVar2.x(jVar3);
                                com.google.android.libraries.navigation.internal.ach.i iVar2 = (com.google.android.libraries.navigation.internal.ach.i) bbVar2;
                                if (!iVar2.b.H()) {
                                    iVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.ach.j jVar4 = (com.google.android.libraries.navigation.internal.ach.j) iVar2.b;
                                jVar4.b |= 1;
                                jVar4.c = j;
                                anVarH = com.google.android.libraries.navigation.internal.yx.an.j((com.google.android.libraries.navigation.internal.ach.j) iVar2.t());
                            }
                            com.google.android.libraries.navigation.internal.ach.j jVar5 = (com.google.android.libraries.navigation.internal.ach.j) anVarH.e(com.google.android.libraries.navigation.internal.ach.j.a);
                            com.google.android.libraries.navigation.internal.acg.o oVar3 = oVar;
                            if (!oVar3.b.H()) {
                                oVar3.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.p pVar3 = (com.google.android.libraries.navigation.internal.acg.p) oVar3.b;
                            pVar3.e = jVar5;
                            pVar3.b |= 4;
                            arrayList2 = arrayList;
                            arrayList2.add((com.google.android.libraries.navigation.internal.acg.p) oVar3.t());
                            i2 = i + 1;
                            r1 = this;
                            bhVar2 = bhVar;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    com.google.android.libraries.navigation.internal.acg.s sVar = (com.google.android.libraries.navigation.internal.acg.s) com.google.android.libraries.navigation.internal.acg.t.a.q();
                    if (!sVar.b.H()) {
                        sVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acg.t tVar = (com.google.android.libraries.navigation.internal.acg.t) sVar.b;
                    bz bzVar4 = tVar.b;
                    if (!bzVar4.c()) {
                        tVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar4);
                    }
                    com.google.android.libraries.navigation.internal.ael.b.m(arrayList2, tVar.b);
                    this.ak.b((com.google.android.libraries.navigation.internal.acg.t) sVar.t());
                    com.google.android.libraries.navigation.internal.sg.a aVar4 = this.K;
                    long j4 = 0;
                    j4 = 0;
                    j4 = 0;
                    j4 = 0;
                    j4 = 0;
                    if (hVar3 == 0 || aVar4.equals(com.google.android.libraries.navigation.internal.sg.a.a) || !((com.google.android.libraries.navigation.internal.bt.b) hVar3).p) {
                        hVar2 = hVar;
                    } else {
                        hVar2 = hVar;
                        if (((com.google.android.libraries.navigation.internal.bt.b) hVar2).p && ((com.google.android.libraries.navigation.internal.bt.b) hVar3).a.f().j == com.google.android.libraries.navigation.internal.ady.al.DRIVE && ((com.google.android.libraries.navigation.internal.bt.b) hVar3).a.f().Y != ((com.google.android.libraries.navigation.internal.bt.b) hVar2).a.f().Y) {
                            long j5 = ((com.google.android.libraries.navigation.internal.bt.b) hVar2).a.f().Y;
                            aVar4.a();
                            if (((com.google.android.libraries.navigation.internal.bt.b) hVar2).a.f().aa == com.google.android.libraries.navigation.internal.adq.be.g) {
                                j4 = this.f345n.p().r;
                            }
                        }
                    }
                    this.g.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.z
                        /* JADX WARN: Code duplicated, block: B:108:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:111:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:47:0x00e8 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:49:0x00ec A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:50:0x00ef A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:52:0x00f3 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:55:0x0102 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:56:0x010d  */
                        /* JADX WARN: Code duplicated, block: B:59:0x0116 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:62:0x0145 A[DONT_INVERT] */
                        /* JADX WARN: Code duplicated, block: B:63:0x0147 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:67:0x0152 A[Catch: all -> 0x0158, TryCatch #2 {, blocks: (B:65:0x014a, B:67:0x0152, B:68:0x0156), top: B:108:0x014a, outer: #3 }] */
                        /* JADX WARN: Code duplicated, block: B:73:0x015b A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:77:0x0166 A[Catch: all -> 0x016c, TryCatch #4 {, blocks: (B:75:0x015e, B:77:0x0166, B:78:0x016a), top: B:111:0x015e, outer: #3 }] */
                        /* JADX WARN: Code duplicated, block: B:83:0x016f A[DONT_INVERT] */
                        /* JADX WARN: Code duplicated, block: B:84:0x0171 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Code duplicated, block: B:85:0x0176 A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0014, B:7:0x0032, B:8:0x0040, B:10:0x0046, B:15:0x0078, B:23:0x008b, B:40:0x00c6, B:45:0x00e4, B:47:0x00e8, B:49:0x00ec, B:50:0x00ef, B:52:0x00f3, B:53:0x00f5, B:55:0x0102, B:57:0x0111, B:59:0x0116, B:60:0x011e, B:63:0x0147, B:64:0x0149, B:86:0x017a, B:72:0x015a, B:73:0x015b, B:74:0x015d, B:82:0x016e, B:84:0x0171, B:85:0x0176, B:43:0x00dc, B:24:0x00a3, B:25:0x00a8, B:26:0x00ad, B:27:0x00af, B:33:0x00b8, B:34:0x00b9, B:35:0x00bd, B:90:0x0190, B:91:0x0191, B:28:0x00b0, B:29:0x00b4, B:65:0x014a, B:67:0x0152, B:68:0x0156, B:75:0x015e, B:77:0x0166, B:78:0x016a, B:36:0x00be, B:37:0x00c2), top: B:110:0x0014, inners: #1, #2, #4, #5 }] */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            ev evVar;
                            com.google.android.libraries.navigation.internal.bp.ay ayVar;
                            com.google.android.libraries.navigation.internal.bp.ay ayVar2;
                            ii iiVar;
                            com.google.android.libraries.navigation.internal.afl.bh bhVarC;
                            int i17;
                            Integer numValueOf;
                            ArrayList arrayList6;
                            com.google.android.libraries.navigation.internal.bq.c cVar8;
                            am amVar = this.a;
                            com.google.android.libraries.navigation.internal.bn.d dVar8 = amVar.b;
                            com.google.android.libraries.navigation.internal.bt.h hVar6 = hVar2;
                            com.google.android.libraries.navigation.internal.ci.a aVar5 = amVar.ai;
                            com.google.android.libraries.navigation.internal.fz.d dVar9 = amVar.f345n;
                            com.google.android.libraries.navigation.internal.sg.a aVar6 = amVar.K;
                            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsOverlayManager.createDirectionsMapData()");
                            try {
                                bh bhVar4 = ((com.google.android.libraries.navigation.internal.bt.b) hVar6).a;
                                com.google.android.libraries.navigation.internal.yx.ar.r(bhVar4, "routes");
                                ev evVar2 = ((com.google.android.libraries.navigation.internal.bt.b) hVar6).b;
                                com.google.android.libraries.navigation.internal.yx.ar.b(bhVar4.d() == ((lv) evVar2).c, "# routes != # textureTypes");
                                ArrayList arrayListE = hx.e(bhVar4.d());
                                int i18 = 0;
                                while (i18 < bhVar4.d()) {
                                    bg bgVarE2 = bhVar4.e(i18);
                                    long j6 = bgVarE2.Y;
                                    aVar6.a();
                                    com.google.android.libraries.navigation.internal.bp.ag agVar2 = new com.google.android.libraries.navigation.internal.bp.ag(bgVarE2);
                                    com.google.android.libraries.navigation.internal.bn.e eVar5 = (com.google.android.libraries.navigation.internal.bn.e) evVar2.get(i18);
                                    boolean z2 = eVar5.e;
                                    boolean z3 = ((com.google.android.libraries.navigation.internal.bt.b) hVar6).c;
                                    if (z2 || z3) {
                                        int iOrdinal = eVar5.ordinal();
                                        if (iOrdinal != 0) {
                                            evVar = evVar2;
                                            if (iOrdinal != 1) {
                                                if (iOrdinal == 2) {
                                                    ayVar2 = bgVarE2.S.a;
                                                } else if (iOrdinal != 3) {
                                                    ((com.google.android.libraries.navigation.internal.zb.h) bg.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(62)).s("Unsupported TextureType: %s", eVar5);
                                                    ayVar2 = null;
                                                } else {
                                                    ayVar2 = bgVarE2.S.b;
                                                }
                                                if (ayVar2 == null && ((com.google.android.libraries.navigation.internal.bq.c) ayVar2).b.d().equals(agVar2.d())) {
                                                    arrayListE.add(ayVar2);
                                                } else {
                                                    iiVar = bgVarE2.u;
                                                    if (iiVar == null) {
                                                        if (eVar5 == com.google.android.libraries.navigation.internal.bn.e.SELECTED_WITH_TRAFFIC) {
                                                            eVar5 = com.google.android.libraries.navigation.internal.bn.e.SELECTED_UNIFORM;
                                                        } else if (eVar5 == com.google.android.libraries.navigation.internal.bn.e.UNSELECTED_WITH_TRAFFIC) {
                                                            eVar5 = com.google.android.libraries.navigation.internal.bn.e.UNSELECTED_UNIFORM;
                                                        }
                                                    }
                                                    com.google.android.libraries.navigation.internal.bn.e eVar6 = eVar5;
                                                    bhVarC = dVar9.C();
                                                    i17 = bhVarC.b;
                                                    if ((i17 & 33554432) != 0) {
                                                        numValueOf = Integer.valueOf(bhVarC.i);
                                                    } else {
                                                        numValueOf = null;
                                                    }
                                                    arrayList6 = arrayListE;
                                                    cVar8 = new com.google.android.libraries.navigation.internal.bq.c(new com.google.android.libraries.navigation.internal.bq.b(bgVarE2, agVar2, eVar6, iiVar, dVar8, aVar5, numValueOf, (i17 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? Integer.valueOf(bhVarC.j) : null));
                                                    if (iiVar != null) {
                                                        if (z2) {
                                                            synchronized (bgVarE2.S) {
                                                                if (iiVar.equals(bgVarE2.u)) {
                                                                    bgVarE2.S.c = cVar8;
                                                                }
                                                            }
                                                        } else {
                                                            synchronized (bgVarE2.S) {
                                                                if (iiVar.equals(bgVarE2.u)) {
                                                                    bgVarE2.S.d = cVar8;
                                                                }
                                                            }
                                                        }
                                                    } else if (z2 != 0) {
                                                        bgVarE2.S.a = cVar8;
                                                    } else {
                                                        bgVarE2.S.b = cVar8;
                                                    }
                                                    arrayList6.add(cVar8);
                                                    i18++;
                                                    arrayListE = arrayList6;
                                                    evVar2 = evVar;
                                                    bhVar4 = bhVar4;
                                                    dVar9 = dVar9;
                                                    aVar6 = aVar6;
                                                    dVar8 = dVar8;
                                                    aVar5 = aVar5;
                                                }
                                            } else {
                                                synchronized (bgVarE2.S) {
                                                    ayVar = bgVarE2.S.d;
                                                }
                                            }
                                        } else {
                                            evVar = evVar2;
                                            synchronized (bgVarE2.S) {
                                                ayVar = bgVarE2.S.c;
                                            }
                                        }
                                        ayVar2 = ayVar;
                                        if (ayVar2 == null) {
                                        }
                                        iiVar = bgVarE2.u;
                                        if (iiVar == null) {
                                            if (eVar5 == com.google.android.libraries.navigation.internal.bn.e.SELECTED_WITH_TRAFFIC) {
                                                eVar5 = com.google.android.libraries.navigation.internal.bn.e.SELECTED_UNIFORM;
                                            } else if (eVar5 == com.google.android.libraries.navigation.internal.bn.e.UNSELECTED_WITH_TRAFFIC) {
                                                eVar5 = com.google.android.libraries.navigation.internal.bn.e.UNSELECTED_UNIFORM;
                                            }
                                        }
                                        com.google.android.libraries.navigation.internal.bn.e eVar7 = eVar5;
                                        bhVarC = dVar9.C();
                                        i17 = bhVarC.b;
                                        if ((i17 & 33554432) != 0) {
                                            numValueOf = Integer.valueOf(bhVarC.i);
                                        } else {
                                            numValueOf = null;
                                        }
                                        arrayList6 = arrayListE;
                                        cVar8 = new com.google.android.libraries.navigation.internal.bq.c(new com.google.android.libraries.navigation.internal.bq.b(bgVarE2, agVar2, eVar7, iiVar, dVar8, aVar5, numValueOf, (i17 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? Integer.valueOf(bhVarC.j) : null));
                                        if (iiVar != null) {
                                            if (z2) {
                                                synchronized (bgVarE2.S) {
                                                    if (iiVar.equals(bgVarE2.u)) {
                                                        bgVarE2.S.c = cVar8;
                                                    }
                                                }
                                            } else {
                                                synchronized (bgVarE2.S) {
                                                    if (iiVar.equals(bgVarE2.u)) {
                                                        bgVarE2.S.d = cVar8;
                                                    }
                                                }
                                            }
                                        } else if (z2 != 0) {
                                            bgVarE2.S.a = cVar8;
                                        } else {
                                            bgVarE2.S.b = cVar8;
                                        }
                                        arrayList6.add(cVar8);
                                        i18++;
                                        arrayListE = arrayList6;
                                        evVar2 = evVar;
                                        bhVar4 = bhVar4;
                                        dVar9 = dVar9;
                                        aVar6 = aVar6;
                                        dVar8 = dVar8;
                                        aVar5 = aVar5;
                                    } else {
                                        evVar = evVar2;
                                    }
                                    arrayList6 = arrayListE;
                                    i18++;
                                    arrayListE = arrayList6;
                                    evVar2 = evVar;
                                    bhVar4 = bhVar4;
                                    dVar9 = dVar9;
                                    aVar6 = aVar6;
                                    dVar8 = dVar8;
                                    aVar5 = aVar5;
                                }
                                final com.google.android.libraries.navigation.internal.bq.a aVar7 = new com.google.android.libraries.navigation.internal.bq.a(ev.o(arrayListE), ((com.google.android.libraries.navigation.internal.bt.b) hVar6).h, ((com.google.android.libraries.navigation.internal.bt.b) hVar6).t);
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                final aj ajVar = agVar;
                                amVar.M = aVar7;
                                amVar.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i19 = am.an;
                                        ajVar.b(aVar7);
                                    }
                                });
                            } catch (Throwable th6) {
                                if (dVarB == null) {
                                    throw th6;
                                }
                                try {
                                    Trace.endSection();
                                    throw th6;
                                } catch (Throwable th7) {
                                    th6.addSuppressed(th7);
                                    throw th6;
                                }
                            }
                        }
                    }, j4, TimeUnit.MILLISECONDS);
                    boolean zBooleanValue = ((Boolean) this.au.b(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bm.aa
                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj) {
                            return Boolean.valueOf(((com.google.android.libraries.navigation.internal.cn.aa) obj).c());
                        }
                    }).e(false)).booleanValue();
                    r1 = zBooleanValue;
                    B = j4;
                    r25 = r25;
                    if (!zBooleanValue) {
                        final fd fdVar = ma.b;
                        final com.google.android.libraries.navigation.internal.sg.a aVar5 = this.K;
                        com.google.android.libraries.navigation.internal.aac.s sVar2 = new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.bm.p
                            @Override // com.google.android.libraries.navigation.internal.aac.s
                            public final bj a() {
                                am amVar = this.a;
                                return com.google.android.libraries.navigation.internal.yu.c.b(new com.google.android.libraries.navigation.internal.aac.v(ev.n(amVar.e(hVar2, fdVar, aVar5)), false), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bm.w
                                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                                    public final Object ak(Object obj) {
                                        int i17 = am.an;
                                        ArrayList arrayList6 = new ArrayList();
                                        for (al alVar2 : (List) obj) {
                                            if (alVar2 != null) {
                                                arrayList6.add(alVar2);
                                            }
                                        }
                                        return arrayList6;
                                    }
                                }, amVar.g);
                            }
                        };
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        bn bnVar = this.g;
                        bj bjVarJ = com.google.android.libraries.navigation.internal.yr.aw.d(com.google.android.libraries.navigation.internal.yr.ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? com.google.android.libraries.navigation.internal.aac.az.j(com.google.android.libraries.navigation.internal.yr.am.c(sVar2), j4, timeUnit, bnVar) : com.google.android.libraries.navigation.internal.aac.az.j(sVar2, j4, timeUnit, bnVar);
                        ac acVar = new ac(this, hVar2);
                        com.google.android.libraries.navigation.internal.yu.c.d(bjVarJ, acVar, this.f);
                        r1 = bjVarJ;
                        B = acVar;
                        r25 = r25;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (r25 != 0) {
                Trace.endSection();
            }
        } catch (Throwable th7) {
            th = th7;
            r25 = B;
        }
    }

    final void r(m mVar) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        com.google.android.libraries.navigation.internal.bt.h hVarB = b();
        if (hVarB != null) {
            com.google.android.libraries.navigation.internal.bt.d dVarF = hVarB.f();
            dVarF.x();
            q(dVarF.I(), true, mVar);
        }
    }
}
