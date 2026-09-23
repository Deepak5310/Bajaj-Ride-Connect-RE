package com.google.android.libraries.navigation.internal.ly;

import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.maps.model.MapColorScheme;
import com.google.android.libraries.navigation.internal.abh.cy;
import com.google.android.libraries.navigation.internal.abh.dv;
import com.google.android.libraries.navigation.internal.abh.dz;
import com.google.android.libraries.navigation.internal.abh.ec;
import com.google.android.libraries.navigation.internal.abh.ed;
import com.google.android.libraries.navigation.internal.abh.ef;
import com.google.android.libraries.navigation.internal.abh.fg;
import com.google.android.libraries.navigation.internal.abh.fv;
import com.google.android.libraries.navigation.internal.abh.gh;
import com.google.android.libraries.navigation.internal.abh.ht;
import com.google.android.libraries.navigation.internal.abm.cz;
import com.google.android.libraries.navigation.internal.abm.dl;
import com.google.android.libraries.navigation.internal.abm.dn;
import com.google.android.libraries.navigation.internal.abm.eb;
import com.google.android.libraries.navigation.internal.po.fk;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ct implements gh {
    public static final String a = "ct";
    public static final ct b = new ct(cs.a);
    public static final String c = null;
    public final cs d;
    private final com.google.android.libraries.navigation.internal.abm.bk e;

    public ct() {
        this(cs.a);
    }

    public ct(cs csVar, com.google.android.libraries.navigation.internal.abm.bk bkVar) {
        this.d = csVar;
        this.e = bkVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
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
    @Override // com.google.android.libraries.navigation.internal.abh.gh
    public final ed a(String str, com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.m mVar, final String str2, Integer num, @MapColorScheme int i, View view, com.google.android.libraries.navigation.internal.abh.aa aaVar, boolean z, TextView textView, ec ecVar, com.google.android.libraries.navigation.internal.abh.by byVar, final ht htVar, fv fvVar, boolean z2, com.google.android.libraries.navigation.internal.abh.d dVar, com.google.android.libraries.navigation.internal.abh.af afVar, boolean z3, cy cyVar, com.google.android.libraries.navigation.internal.abh.bl blVar, boolean z4) {
        byte b2;
        View viewA;
        com.google.android.libraries.navigation.internal.abn.bl blVar2;
        final com.google.android.libraries.navigation.internal.oo.b bVar;
        int iHashCode = str.hashCode();
        if (iHashCode != 76) {
            if (iHashCode == 80 && str.equals("P")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str.equals("L")) {
            b2 = 0;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            com.google.android.libraries.navigation.internal.abl.l lVar = new com.google.android.libraries.navigation.internal.abl.l(beVar, mVar.a, view, aaVar, byVar, ecVar, textView, mVar.b, mVar.f, dVar);
            com.google.android.libraries.navigation.internal.abl.s sVar = new com.google.android.libraries.navigation.internal.abl.s(lVar);
            lVar.i.f("");
            lVar.b = sVar;
            com.google.android.libraries.navigation.internal.abl.p pVar = new com.google.android.libraries.navigation.internal.abl.p(lVar, lVar.b, lVar.a);
            lVar.e = new com.google.android.libraries.navigation.internal.abi.d();
            lVar.e.a(lVar.g.a, pVar, z3);
            lVar.setFocusable(true);
            lVar.setClickable(true);
            lVar.h = new com.google.android.libraries.navigation.internal.abh.cp(lVar, lVar.b, lVar.g);
            ViewCompat.setAccessibilityDelegate(lVar, lVar.h);
            return lVar;
        }
        if (b2 != 1) {
            throw new IllegalArgumentException("Cannot create unsupported map renderer: ".concat(String.valueOf(str)));
        }
        com.google.android.libraries.navigation.internal.abm.bk bkVar = this.e;
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.ow.k kVarA = bkVar.a(beVar, mVar, fvVar);
        com.google.android.libraries.navigation.internal.abn.c cVar = new com.google.android.libraries.navigation.internal.abn.c();
        com.google.android.libraries.navigation.internal.abn.z zVar = new com.google.android.libraries.navigation.internal.abn.z(afVar, cVar);
        com.google.android.libraries.navigation.internal.abn.as asVar = new com.google.android.libraries.navigation.internal.abn.as(zVar, cVar);
        boolean z5 = i == 1 || (i == 2 && (beVar.a.getResources().getConfiguration().uiMode & 48) == 32);
        ef efVarE = bkVar.e(kVarA, asVar, str2, num, z5, z, mVar.l, beVar);
        StrictMode.ThreadPolicy threadPolicyB = com.google.android.libraries.navigation.internal.abf.w.a.b();
        efVarE.i().run();
        efVarE.c().d();
        final com.google.android.libraries.navigation.internal.om.q qVar = (com.google.android.libraries.navigation.internal.om.q) kVarA.d().f();
        com.google.android.libraries.navigation.internal.oo.b bVarF = efVarE instanceof com.google.android.libraries.navigation.internal.abm.ar ? ((com.google.android.libraries.navigation.internal.abm.ar) efVarE).f() : null;
        final com.google.android.libraries.navigation.internal.oa.k kVarD = efVarE.d();
        if (qVar != null) {
            qVar.f(kVarD.hashCode(), new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.bg
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.google.android.libraries.navigation.internal.afu.d.d()) {
                        String str3 = str2;
                        com.google.android.libraries.navigation.internal.om.q qVar2 = qVar;
                        ht htVar2 = htVar;
                        if (qVar2.g(str3)) {
                            if (qVar2.h(str3)) {
                                htVar2.f(com.google.android.libraries.navigation.internal.zp.bb.d);
                            } else {
                                htVar2.f(com.google.android.libraries.navigation.internal.zp.bb.c);
                            }
                            htVar2.c(com.google.android.libraries.navigation.internal.abx.b.MAP_USE_CLOUD_STYLING);
                        } else {
                            htVar2.f(com.google.android.libraries.navigation.internal.zp.bb.b);
                        }
                    }
                    kVarD.o();
                }
            });
        }
        if (!com.google.android.libraries.navigation.internal.afu.m.c() || bVarF == null) {
            kVarD.q();
            viewA = kVarD.a();
        } else {
            bVarF.n();
            viewA = bVarF.f();
        }
        View view2 = viewA;
        fk fkVar = (fk) kVarD.b();
        if (fkVar.V) {
            fkVar.U.q(textView);
        }
        if (kVarA.d().g()) {
            com.google.android.libraries.navigation.internal.om.q qVar2 = (com.google.android.libraries.navigation.internal.om.q) kVarA.d().c();
            int iHashCode2 = kVarD.hashCode();
            Objects.requireNonNull(kVarD);
            qVar2.e(iHashCode2, new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.bh
                @Override // java.lang.Runnable
                public final void run() {
                    kVarD.p();
                }
            });
        }
        com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyB);
        com.google.android.libraries.navigation.internal.abm.aa aaVar2 = new com.google.android.libraries.navigation.internal.abm.aa(ecVar);
        ((fk) kVarD.b()).J.f(aaVar2);
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            blVar2 = new com.google.android.libraries.navigation.internal.abn.bl(kVarD, zVar, new com.google.android.libraries.navigation.internal.abn.be(kVarD.c(), beVar.g(), beVar.f(), beVar.b()));
        } else {
            com.google.android.libraries.navigation.internal.pb.t tVarC = kVarD.c();
            blVar2 = new com.google.android.libraries.navigation.internal.abn.bl(kVarD, zVar, new com.google.android.libraries.navigation.internal.abn.be(new com.google.android.libraries.navigation.internal.pb.t(tVarC), beVar.g(), beVar.f(), beVar.b()), new com.google.android.libraries.navigation.internal.abn.be(tVarC, beVar.g(), beVar.f(), beVar.b()));
        }
        kVarD.c().c = blVar2;
        asVar.d = blVar2;
        cz czVar = com.google.android.libraries.navigation.internal.afu.d.j() ? new cz(blVar2) : new cz(blVar2.c());
        asVar.F(czVar);
        com.google.android.libraries.navigation.internal.abn.u uVar = new com.google.android.libraries.navigation.internal.abn.u(blVar2, view2, cVar);
        com.google.android.libraries.navigation.internal.oo.b bVar2 = bVarF;
        com.google.android.libraries.navigation.internal.abh.bq bqVarB = bkVar.b(beVar.a, kVarA.I(), kVarA.B(), uVar, kVarD, qVar != null ? ((com.google.android.libraries.navigation.internal.om.b) qVar.a().a()).a : 65.0f);
        aaVar2.f(kVarD, zVar, blVar2);
        blVar2.g.a();
        blVar2.j = uVar;
        kVarD.G();
        eb ebVar = new eb(view2, view, aaVar.f, executorA, mVar.b, kVarD);
        com.google.android.libraries.navigation.internal.po.bw bwVar = ((fk) kVarD.b()).J;
        if (mVar.f126n) {
            mVar.f126n = false;
            com.google.android.libraries.navigation.internal.qu.cf cfVarH = efVarE.h();
            for (com.google.android.libraries.navigation.internal.oe.ap apVar : cfVarH.a.keySet()) {
                synchronized (cfVarH.e(apVar)) {
                    com.google.android.libraries.navigation.internal.qv.k kVar = (com.google.android.libraries.navigation.internal.qv.k) cfVarH.a.get(apVar);
                    if (kVar != null) {
                        kVar.F();
                    }
                }
            }
            cfVarH.c.d();
        }
        bwVar.h(true != z2 ? 60 : 30);
        com.google.android.libraries.navigation.internal.on.h hVar = new com.google.android.libraries.navigation.internal.on.h(bwVar);
        dl dlVar = new dl(beVar.b(), view2, bwVar, hVar, uVar, czVar);
        com.google.android.libraries.navigation.internal.abh.cp cpVar = new com.google.android.libraries.navigation.internal.abh.cp(view2, dlVar, beVar);
        asVar.e = cpVar;
        ViewCompat.setAccessibilityDelegate(view2, cpVar);
        ((fk) kVarD.b()).L.a.f(dlVar);
        com.google.android.libraries.navigation.internal.abm.ap apVar2 = new com.google.android.libraries.navigation.internal.abm.ap(dlVar, aaVar.j, com.google.android.libraries.navigation.internal.abf.z.a, com.google.android.libraries.navigation.internal.abm.f.a);
        apVar2.a.a();
        com.google.android.libraries.navigation.internal.abf.s.k(bwVar, "MapEventManagerPhoenix.phoenixGoogleMap");
        apVar2.j = bwVar;
        bwVar.k(com.google.android.libraries.navigation.internal.abm.ac.a);
        bwVar.i(apVar2.d);
        bwVar.j(new com.google.android.libraries.navigation.internal.abm.ao(apVar2));
        fg fgVarG = bkVar.g(bwVar, beVar, apVar2, hVar, uVar, efVarE.e(), efVarE.g());
        com.google.android.libraries.navigation.internal.pq.b bVar3 = kVarD.l;
        com.google.android.libraries.navigation.internal.abm.aj ajVar = new com.google.android.libraries.navigation.internal.abm.aj(bVar3);
        cyVar.a(ajVar);
        dn dnVar = new dn(cyVar);
        bVar3.d(dnVar);
        dv dvVarA = dz.a(mVar, beVar, com.google.android.libraries.navigation.internal.abf.x.a(str2) ? com.google.android.libraries.navigation.internal.afm.d.BASE_MAP_CREATE_DYNAMIC : com.google.android.libraries.navigation.internal.afm.d.PREMIUM_MAP_LOAD, htVar);
        if (qVar != null) {
            bVar = bVar2;
            com.google.android.libraries.navigation.internal.afo.a aVar = bVar == null ? null : new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.abm.bi
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return bVar;
                }
            };
            com.google.android.libraries.navigation.internal.afo.a aVar2 = new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.abm.bj
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return kVarD;
                }
            };
            com.google.android.libraries.navigation.internal.om.p pVarA = qVar.a();
            Objects.requireNonNull(pVarA);
            com.google.android.libraries.navigation.internal.abm.bf bfVar = new com.google.android.libraries.navigation.internal.abm.bf(pVarA);
            boolean zI = kVarD.k.i();
            qVar.a().b();
            qVar.a().b();
            new com.google.android.libraries.navigation.internal.oi.e(aVar, aVar2, bfVar, z5, zI, false, null);
        } else {
            bVar = bVar2;
        }
        if (qVar != null) {
            qVar.a().b();
        }
        com.google.android.libraries.navigation.internal.abm.bl blVar3 = new com.google.android.libraries.navigation.internal.abm.bl(efVarE, str2, qVar, kVarD, bVar, uVar, cVar, asVar, fgVarG, dlVar, ebVar, apVar2, aaVar2, ajVar, dnVar, dVar, dvVarA, bqVarB, blVar, beVar, z5);
        com.google.android.libraries.navigation.internal.afu.v.c();
        dvVarA.d.add(blVar3);
        dvVarA.d(blVar3);
        return blVar3;
    }

    public ct(cs csVar) {
        this(csVar, com.google.android.libraries.navigation.internal.abm.bk.c);
    }
}
