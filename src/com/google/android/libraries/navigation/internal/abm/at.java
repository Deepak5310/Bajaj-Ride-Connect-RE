package com.google.android.libraries.navigation.internal.abm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import com.google.android.libraries.navigation.internal.abh.ee;
import com.google.android.libraries.navigation.internal.abh.ef;
import com.google.android.libraries.navigation.internal.po.gm;
import com.google.android.libraries.navigation.internal.po.gr;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at implements ef {
    private final com.google.android.libraries.navigation.internal.ow.j a;

    public at(com.google.android.libraries.navigation.internal.ow.j jVar) {
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.u.d a() {
        com.google.android.libraries.navigation.internal.u.d dVar = this.a.e;
        com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
        return dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.fq.f b() {
        com.google.android.libraries.navigation.internal.ow.k kVar = this.a.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
        return kVar.w();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.fu.a c() {
        com.google.android.libraries.navigation.internal.fu.a aVar = this.a.h;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        return aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.oa.k d() {
        com.google.android.libraries.navigation.internal.oa.k kVar = this.a.d;
        com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
        return kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.ob.f e() {
        return this.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.pi.s g() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final com.google.android.libraries.navigation.internal.qu.cf h() {
        com.google.android.libraries.navigation.internal.qu.cf cfVar = this.a.f;
        com.google.android.libraries.navigation.internal.yx.ar.q(cfVar);
        return cfVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ef
    public final ee i() {
        final com.google.android.libraries.navigation.internal.ow.j jVar = this.a;
        Objects.requireNonNull(jVar);
        return new ee() { // from class: com.google.android.libraries.navigation.internal.abm.as
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.ow.j jVar2 = jVar;
                String str = jVar2.i;
                Integer num = jVar2.j;
                boolean z = jVar2.k;
                com.google.android.libraries.navigation.internal.yx.ar.q(jVar2.a);
                final com.google.android.libraries.navigation.internal.ow.k kVar = jVar2.a;
                com.google.android.libraries.navigation.internal.iv.f fVarC = kVar.C();
                jVar2.h = kVar.x();
                Context contextT = kVar.t();
                Resources resourcesU = kVar.u();
                com.google.android.libraries.navigation.internal.fq.f fVarW = kVar.w();
                com.google.android.libraries.navigation.internal.kl.b bVarG = kVar.G();
                com.google.android.libraries.navigation.internal.mj.a aVarH = kVar.H();
                com.google.android.libraries.navigation.internal.ni.a aVarI = kVar.I();
                com.google.android.libraries.navigation.internal.kg.d dVarF = kVar.F();
                com.google.android.libraries.navigation.internal.ia.e eVarB = kVar.B();
                com.google.android.libraries.navigation.internal.di.b bVarV = kVar.v();
                com.google.android.libraries.navigation.internal.jy.af afVarE = kVar.E();
                com.google.android.libraries.navigation.internal.hp.e eVarA = kVar.A();
                com.google.android.libraries.navigation.internal.aac.bn bnVarS = kVar.S();
                com.google.android.libraries.navigation.internal.aac.bn bnVarW = kVar.W();
                com.google.android.libraries.navigation.internal.aac.bn bnVarV = kVar.V();
                Executor executorAf = kVar.af();
                com.google.android.libraries.navigation.internal.aac.bn bnVarT = kVar.T();
                final com.google.android.libraries.navigation.internal.oc.a aVarA = jVar2.a.a();
                com.google.android.libraries.navigation.internal.qf.d dVarK = aVarA.k();
                com.google.android.libraries.navigation.internal.pg.g gVarI = aVarA.i();
                com.google.android.libraries.geo.mapcore.internal.model.ct ctVarM = aVarA.m();
                com.google.android.libraries.navigation.internal.ra.c.b = kVar.P();
                com.google.android.libraries.navigation.internal.ra.c.c = kVar.M();
                com.google.android.libraries.navigation.internal.ra.c.d = kVar.R();
                com.google.android.libraries.navigation.internal.ra.c.e = kVar.N();
                com.google.android.libraries.navigation.internal.ra.c.f = kVar.Q();
                com.google.android.libraries.navigation.internal.ra.c.g = kVar.O();
                final com.google.android.libraries.navigation.internal.iz.n nVarD = kVar.D();
                com.google.android.libraries.navigation.internal.ob.l lVarG = com.google.android.libraries.navigation.internal.ob.n.g();
                if (jVar2.l) {
                    lVarG.d();
                }
                lVarG.c(new com.google.android.libraries.navigation.internal.po.bg());
                com.google.android.libraries.navigation.internal.ob.n nVarB = lVarG.b();
                com.google.android.libraries.navigation.internal.qs.a aVar = new com.google.android.libraries.navigation.internal.qs.a();
                com.google.android.libraries.navigation.internal.ni.a aVarI2 = kVar.I();
                final com.google.android.libraries.navigation.internal.om.p pVarJ = kVar.J();
                Objects.requireNonNull(pVarJ);
                com.google.android.libraries.geo.mapcore.renderer.ax axVar = new com.google.android.libraries.geo.mapcore.renderer.ax(contextT, bVarG, aVarI2, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.ow.a
                    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                    public final Object a() {
                        return pVarJ.b();
                    }
                }, resourcesU);
                com.google.android.libraries.navigation.internal.yx.br brVarR = aVarA.r();
                com.google.android.libraries.navigation.internal.qy.h hVarP = aVarA.p();
                com.google.android.libraries.geo.mapcore.internal.model.x xVarL = aVarA.l();
                com.google.android.libraries.navigation.internal.qu.cf cfVarO = aVarA.o();
                jVar2.f = cfVarO;
                com.google.android.libraries.navigation.internal.kg.c cVarA = dVarF.a(com.google.android.libraries.navigation.internal.kg.b.a);
                Cdo cdo = (Cdo) jVar2.a.bY().f();
                if (cdo != null) {
                    cVarA.a(new com.google.android.libraries.navigation.internal.ow.i(cdo));
                }
                Objects.requireNonNull(kVar);
                Objects.requireNonNull(kVar);
                com.google.android.libraries.navigation.internal.qq.al alVar = new com.google.android.libraries.navigation.internal.qq.al(resourcesU, contextT, aVarH, aVarI, axVar, ctVarM, cVarA, bnVarW, eVarB, bVarG, new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.ow.b
                    @Override // com.google.android.libraries.navigation.internal.afo.a
                    public final Object a() {
                        return kVar.Z();
                    }
                }, kVar.L());
                com.google.android.libraries.navigation.internal.ps.y yVar = new com.google.android.libraries.navigation.internal.ps.y(new com.google.android.libraries.navigation.internal.ps.k());
                gr grVar = new gr(com.google.android.libraries.navigation.internal.ih.a.c(axVar));
                com.google.android.libraries.navigation.internal.qd.k kVar2 = new com.google.android.libraries.navigation.internal.qd.k(bVarG, com.google.android.libraries.navigation.internal.kn.a.PRIMARY_MAP, null, jVar2.o);
                jVar2.g = new com.google.android.libraries.navigation.internal.oa.c(new com.google.android.libraries.navigation.internal.yx.bv(new com.google.android.libraries.navigation.internal.oe.r(47.6062d, -122.3321d)), new com.google.android.libraries.navigation.internal.pe.b(aVarH, kVar.x(), null, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.ow.c
                    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                    public final Object a() {
                        return kVar.ab();
                    }
                }, fVarC, afVarE, bnVarS), bVarG, com.google.android.libraries.navigation.internal.ih.a.c(kVar2), new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.ow.d
                    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                    public final Object a() {
                        return kVar.ac();
                    }
                }, kVar.x(), afVarE, bnVarS);
                jVar2.a.e();
                if (str == null) {
                    str = "";
                }
                com.google.android.libraries.navigation.internal.adi.an anVar = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_TRAFFIC_V2;
                com.google.android.libraries.navigation.internal.ih.a aVarC = com.google.android.libraries.navigation.internal.ih.a.c(axVar);
                com.google.android.libraries.navigation.internal.ih.a aVarC2 = com.google.android.libraries.navigation.internal.ih.a.c(alVar);
                com.google.android.libraries.navigation.internal.ih.a aVarC3 = com.google.android.libraries.navigation.internal.ih.a.c(jVar2.a());
                com.google.android.libraries.navigation.internal.om.p pVarJ2 = kVar.J();
                com.google.android.libraries.navigation.internal.ox.f fVarS = aVarA.s();
                com.google.android.libraries.navigation.internal.pm.d dVarJ = aVarA.j();
                com.google.android.libraries.navigation.internal.pi.s sVar = jVar2.c;
                com.google.android.libraries.navigation.internal.pm.a aVar2 = new com.google.android.libraries.navigation.internal.pm.a();
                com.google.android.libraries.navigation.internal.ra.a aVarQ = aVarA.q();
                com.google.android.libraries.navigation.internal.pn.g gVar = jVar2.b;
                Objects.requireNonNull(nVarD);
                com.google.android.libraries.navigation.internal.ob.t tVar = new com.google.android.libraries.navigation.internal.ob.t() { // from class: com.google.android.libraries.navigation.internal.ow.e
                    @Override // com.google.android.libraries.navigation.internal.ob.t
                    public final void a() {
                        nVarD.a();
                    }
                };
                com.google.android.libraries.navigation.internal.rc.e eVar = new com.google.android.libraries.navigation.internal.rc.e(afVarE);
                com.google.android.libraries.navigation.internal.oe.at atVarH = aVarA.h();
                resourcesU.getClass();
                xVarL.getClass();
                contextT.getClass();
                anVar.getClass();
                contextT.getClass();
                fVarW.getClass();
                bVarG.getClass();
                pVarJ2.getClass();
                fVarS.getClass();
                dVarJ.getClass();
                aVarH.getClass();
                eVarA.getClass();
                aVarI.getClass();
                eVarB.getClass();
                cVarA.getClass();
                dVarK.getClass();
                fVarC.getClass();
                bVarV.getClass();
                hVarP.getClass();
                aVarQ.getClass();
                nVarD.getClass();
                cfVarO.getClass();
                gVarI.getClass();
                ctVarM.getClass();
                brVarR.getClass();
                atVarH.getClass();
                com.google.android.libraries.navigation.internal.ih.a aVarC4 = com.google.android.libraries.navigation.internal.ih.a.c(new gm(str, num, resourcesU, xVarL, nVarB, contextT, yVar, anVar, aVarC, grVar, aVarC2, aVarC3, kVar2, contextT, fVarW, bVarG, pVarJ2, fVarS, dVarJ, aVarH, eVarA, aVarI, sVar, eVarB, cVarA, dVarK, fVarC, bVarV, hVarP, aVar2, aVarQ, nVarD, bnVarW, bnVarS, bnVarV, executorAf, bnVarT, cfVarO, gVarI, ctVarM, gVar, brVarR, tVar, aVar, eVar, atVarH, null, null, z, false));
                com.google.android.libraries.navigation.internal.ih.a aVarC5 = com.google.android.libraries.navigation.internal.ih.a.c(ctVarM);
                com.google.android.libraries.navigation.internal.ih.a aVarC6 = com.google.android.libraries.navigation.internal.ih.a.c(cfVarO);
                com.google.android.libraries.navigation.internal.pz.c cVar = com.google.android.libraries.navigation.internal.pz.c.PHONES_AND_TABLETS;
                com.google.android.libraries.navigation.internal.ih.a aVarC7 = com.google.android.libraries.navigation.internal.ih.a.c(axVar);
                com.google.android.libraries.navigation.internal.ih.a aVarC8 = com.google.android.libraries.navigation.internal.ih.a.c(jVar2.a());
                com.google.android.libraries.navigation.internal.pi.s sVar2 = jVar2.c;
                com.google.android.libraries.navigation.internal.qt.a aVarN = aVarA.n();
                com.google.android.libraries.navigation.internal.agl.a aVar3 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.ow.f
                    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                    public final Object a() {
                        return kVar.J().e();
                    }
                };
                com.google.android.libraries.navigation.internal.agl.a aVar4 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.ow.g
                    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                    public final Object a() {
                        return kVar.J().b();
                    }
                };
                Objects.requireNonNull(aVarA);
                jVar2.d = new com.google.android.libraries.navigation.internal.oa.k(aVarC4, nVarB, aVarC5, aVarC6, yVar, cVar, aVarC7, grVar, aVarC8, sVar2, kVar2, aVar, bVarG, aVarH, eVarA, aVarN, dVarK, bnVarS, bnVarV, aVar3, aVar4, new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.ow.h
                    @Override // com.google.android.libraries.navigation.internal.afo.a
                    public final Object a() {
                        return aVarA.j();
                    }
                }, aVarA.h(), new com.google.android.libraries.navigation.internal.ob.w(), resourcesU.getDisplayMetrics());
                jVar2.e = new com.google.android.libraries.navigation.internal.u.d(eVarB, jVar2.d, Optional.empty());
                jVar2.e.a();
                com.google.android.libraries.navigation.internal.yx.ar.q(jVar2.d);
                jVar2.d.l(new Point(0, 0));
            }
        };
    }
}
