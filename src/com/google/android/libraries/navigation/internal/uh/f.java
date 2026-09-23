package com.google.android.libraries.navigation.internal.uh;

import com.google.android.libraries.navigation.internal.ace.bk;
import com.google.android.libraries.navigation.internal.add.av;
import com.google.android.libraries.navigation.internal.add.aw;
import com.google.android.libraries.navigation.internal.add.bv;
import com.google.android.libraries.navigation.internal.add.bw;
import com.google.android.libraries.navigation.internal.add.by;
import com.google.android.libraries.navigation.internal.bm.ar;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.pi.ac;
import com.google.android.libraries.navigation.internal.pi.ad;
import com.google.android.libraries.navigation.internal.pi.ag;
import com.google.android.libraries.navigation.internal.pi.ah;
import com.google.android.libraries.navigation.internal.pi.z;
import com.google.android.libraries.navigation.internal.xe.bh;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.pi.q, com.google.android.libraries.navigation.internal.pi.p, com.google.android.libraries.navigation.internal.pi.n, com.google.android.libraries.navigation.internal.pi.o, com.google.android.libraries.navigation.internal.pj.a {
    public b a;
    public final com.google.android.libraries.navigation.internal.pi.s b;
    public final Executor c;
    public final e d;
    private final com.google.android.libraries.navigation.internal.oq.d e;
    private com.google.android.libraries.navigation.internal.oe.x f = null;
    private Float g = null;
    private Float h = null;

    public f(b bVar, com.google.android.libraries.navigation.internal.oq.d dVar, com.google.android.libraries.navigation.internal.pi.s sVar, Executor executor, e eVar) {
        this.a = bVar;
        this.e = dVar;
        this.b = sVar;
        this.c = executor;
        this.d = eVar;
    }

    public static boolean d(b bVar) {
        return bVar != null && ((bh) bVar).a;
    }

    @Override // com.google.android.libraries.navigation.internal.pi.p
    public final void aB(ac acVar) {
        if (d(this.a)) {
            com.google.android.libraries.navigation.internal.oq.d dVar = this.e;
            com.google.android.libraries.navigation.internal.pn.o oVar = acVar.a;
            com.google.android.libraries.navigation.internal.oq.f fVarA = dVar.a();
            if (oVar == com.google.android.libraries.navigation.internal.pn.o.FIRST_FINGER_DOWN) {
                this.f = com.google.android.libraries.navigation.internal.oe.x.z(fVarA.d());
                this.g = Float.valueOf(fVarA.a());
                this.h = Float.valueOf(fVarA.b());
                return;
            }
            if (acVar.a()) {
                com.google.android.libraries.navigation.internal.oe.x xVar = this.f;
                Float f = this.g;
                Float f2 = this.h;
                if (xVar != null && f != null) {
                    e eVar = this.d;
                    com.google.android.libraries.navigation.internal.oq.d dVar2 = this.e;
                    float fFloatValue = f.floatValue();
                    com.google.android.libraries.navigation.internal.oq.f fVarA2 = dVar2.a();
                    float fAbs = Math.abs(com.google.android.libraries.navigation.internal.nq.a.e(fVarA2.a() - fFloatValue));
                    float fH = xVar.h(com.google.android.libraries.navigation.internal.oe.x.z(fVarA2.d()));
                    com.google.android.libraries.navigation.internal.rf.g gVarC = dVar2.c();
                    float fS = (fH / com.google.android.libraries.navigation.internal.pb.j.s(gVarC)) / gVarC.b();
                    boolean z = false;
                    if (fS < 40.0f && fAbs < 25.0f) {
                        z = true;
                    }
                    l lVar = ((k) eVar).a;
                    com.google.android.libraries.navigation.internal.ui.a aVar = lVar.o;
                    if (aVar != null) {
                        com.google.android.libraries.navigation.internal.uc.g gVar = aVar.c.a;
                        com.google.android.libraries.navigation.internal.uc.g gVar2 = com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT;
                        if (gVar == gVar2 || gVar == com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE) {
                            if (gVar != gVar2) {
                                lVar.t.b();
                            }
                        } else if (z) {
                            lVar.a.p();
                        } else {
                            lVar.t.b();
                        }
                    }
                    this.f = null;
                    this.g = null;
                    this.h = null;
                }
                float fB = fVarA.b();
                if (f2 != null) {
                    Float fValueOf = Float.valueOf(fB);
                    if (f2.equals(fValueOf)) {
                        return;
                    }
                    l lVar2 = ((k) this.d).a;
                    if (lVar2.o != null) {
                        lVar2.t.e(fValueOf);
                        lVar2.a.x();
                        com.google.android.libraries.navigation.internal.uc.g gVar3 = lVar2.o.c.a;
                        if (gVar3 == com.google.android.libraries.navigation.internal.uc.g.FOLLOWING || gVar3 == com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE || gVar3 == com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT) {
                            return;
                        }
                        lVar2.t.b();
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pi.o
    public final void b(com.google.android.libraries.navigation.internal.pi.x xVar) {
        if (d(this.a)) {
            l lVar = ((k) this.d).a;
            if (lVar.c.k.i()) {
                return;
            }
            lVar.f.a(new com.google.android.libraries.navigation.internal.sr.p(((com.google.android.libraries.navigation.internal.pf.c) xVar.a).a));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pi.q
    public final void c(ad adVar) {
        ap.UI_THREAD.f();
        if (d(this.a)) {
            e eVar = this.d;
            float f = adVar.a;
            l lVar = ((k) eVar).a;
            com.google.android.libraries.navigation.internal.ui.a aVar = lVar.o;
            if (aVar != null) {
                com.google.android.libraries.navigation.internal.uc.g gVar = aVar.c.a;
                if (gVar != com.google.android.libraries.navigation.internal.uc.g.FOLLOWING && gVar != com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE && gVar != com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT) {
                    lVar.a.B();
                    lVar.t.b();
                }
                p pVar = lVar.t;
                Float fValueOf = Float.valueOf(f);
                pVar.m(fValueOf);
                lVar.a.o(fValueOf);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.google.android.libraries.navigation.internal.pi.n
    public final void i(com.google.android.libraries.navigation.internal.pi.w wVar) {
        com.google.android.libraries.navigation.internal.ui.a aVar;
        com.google.android.libraries.navigation.internal.ui.a aVar2;
        com.google.android.libraries.navigation.internal.tj.j jVar;
        com.google.android.libraries.navigation.internal.ob.r rVar;
        ck ckVar = null;
        if (wVar instanceof ah) {
            ah ahVar = (ah) wVar;
            if (d(this.a)) {
                l lVar = ((k) this.d).a;
                if (lVar.c.k.i() || (aVar2 = lVar.o) == null || (jVar = aVar2.h) == null || !jVar.d() || (rVar = (com.google.android.libraries.navigation.internal.ob.r) ahVar.a(com.google.android.libraries.navigation.internal.ob.r.class)) == null) {
                    return;
                }
                ev evVarB = jVar.c().b.B();
                int size = evVarB.size();
                int i = 0;
                while (i < size) {
                    ck ckVar2 = (ck) evVarB.get(i);
                    i++;
                    if (com.google.android.libraries.navigation.internal.oe.r.e(rVar.i(), ckVar2.n())) {
                        ckVar = ckVar2;
                        break;
                    }
                }
                if (ckVar != null) {
                    com.google.android.libraries.navigation.internal.az.b bVar = lVar.k;
                    ap.UI_THREAD.f();
                    com.google.android.libraries.navigation.internal.bm.o oVar = (com.google.android.libraries.navigation.internal.bm.o) bVar;
                    com.google.android.libraries.navigation.internal.bm.n nVar = new com.google.android.libraries.navigation.internal.bm.n(oVar, ckVar);
                    synchronized (oVar.f346n) {
                        ar arVar = ((com.google.android.libraries.navigation.internal.bm.o) bVar).o;
                        if (arVar != null) {
                            arVar.d(ckVar, nVar, ((com.google.android.libraries.navigation.internal.bm.o) bVar).i.c());
                        }
                    }
                    lVar.h.d().b(aa.k(com.google.android.libraries.navigation.internal.afe.i.g));
                    return;
                }
                return;
            }
            return;
        }
        if (wVar instanceof ag) {
            if (d(this.a)) {
                l lVar2 = ((k) this.d).a;
                if (((bk) lVar2.q.a()).m) {
                    ((com.google.android.libraries.navigation.internal.cw.a) lVar2.s.a()).b();
                    com.google.android.libraries.navigation.internal.ia.e eVar = lVar2.f;
                    com.google.android.libraries.navigation.internal.ax.a aVar3 = com.google.android.libraries.navigation.internal.ax.a.UNKNOWN;
                    eVar.a(new com.google.android.libraries.navigation.internal.sw.d());
                    return;
                }
                return;
            }
            return;
        }
        if (wVar instanceof z) {
            z zVar = (z) wVar;
            if (d(this.a)) {
                l lVar3 = ((k) this.d).a;
                if (lVar3.az().c() && (aVar = lVar3.o) != null && aVar.c()) {
                    com.google.android.libraries.navigation.internal.tj.u uVar = lVar3.o.b;
                    if (uVar == null || uVar.e()) {
                        com.google.android.libraries.navigation.internal.tj.j jVar2 = lVar3.o.h;
                        bg bgVar = jVar2 != null ? jVar2.c().b : null;
                        bg bgVar2 = (bg) zVar.a(bg.class);
                        if (bgVar2 == null || bgVar2.equals(bgVar)) {
                            return;
                        }
                        com.google.android.libraries.navigation.internal.so.c cVar = lVar3.e;
                        String str = bgVar2.Z;
                        com.google.android.libraries.geo.navcore.service.base.c cVar2 = (com.google.android.libraries.geo.navcore.service.base.c) cVar;
                        if (cVar2.d().booleanValue()) {
                            cVar2.c.c(str);
                            return;
                        }
                        com.google.android.libraries.navigation.internal.tj.j jVar3 = ((com.google.android.libraries.navigation.internal.rw.i) cVar2.e.a()).d;
                        if (jVar3 == null) {
                            throw new IllegalStateException("Guidance not running");
                        }
                        com.google.android.libraries.navigation.internal.bp.bh<bg> bhVarB = jVar3.b();
                        int i2 = ev.d;
                        eq eqVar = new eq();
                        for (bg bgVar3 : bhVarB) {
                            if (!bgVar3.Z.equals(str)) {
                                com.google.android.libraries.navigation.internal.ade.o oVar2 = (com.google.android.libraries.navigation.internal.ade.o) com.google.android.libraries.navigation.internal.ade.p.a.q();
                                String str2 = bgVar3.Z;
                                if (!oVar2.b.H()) {
                                    oVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.ade.p pVar = (com.google.android.libraries.navigation.internal.ade.p) oVar2.b;
                                str2.getClass();
                                pVar.b = str2;
                                eqVar.h((com.google.android.libraries.navigation.internal.ade.p) oVar2.t());
                            }
                        }
                        cVar2.d.b(bhVarB, com.google.android.libraries.navigation.internal.ade.n.a);
                        bv bvVar = (bv) bw.a.q();
                        av avVar = (av) aw.a.q();
                        com.google.android.libraries.navigation.internal.ade.o oVar3 = (com.google.android.libraries.navigation.internal.ade.o) com.google.android.libraries.navigation.internal.ade.p.a.q();
                        if (!oVar3.b.H()) {
                            oVar3.v();
                        }
                        com.google.android.libraries.navigation.internal.ade.p pVar2 = (com.google.android.libraries.navigation.internal.ade.p) oVar3.b;
                        str.getClass();
                        pVar2.b = str;
                        if (!avVar.b.H()) {
                            avVar.v();
                        }
                        aw awVar = (aw) avVar.b;
                        com.google.android.libraries.navigation.internal.ade.p pVar3 = (com.google.android.libraries.navigation.internal.ade.p) oVar3.t();
                        pVar3.getClass();
                        awVar.c = pVar3;
                        awVar.b |= 1;
                        avVar.c(eqVar.g());
                        if (!bvVar.b.H()) {
                            bvVar.v();
                        }
                        bw bwVar = (bw) bvVar.b;
                        aw awVar2 = (aw) avVar.t();
                        awVar2.getClass();
                        bwVar.c = awVar2;
                        bwVar.b |= 1;
                        com.google.android.libraries.navigation.internal.aac.j.h(cVar2.b.b((bw) bvVar.t()), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.navcore.service.base.a
                            @Override // com.google.android.libraries.navigation.internal.yx.aa
                            public final Object ak(Object obj) {
                                return Boolean.valueOf(((by) obj) != null);
                            }
                        }, cVar2.a);
                    }
                }
            }
        }
    }
}
