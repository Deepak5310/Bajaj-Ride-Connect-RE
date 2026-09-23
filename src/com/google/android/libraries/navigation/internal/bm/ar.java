package com.google.android.libraries.navigation.internal.bm;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ee;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar {
    private com.google.android.libraries.navigation.internal.qk.ak a;
    private ck b;
    private final ax c;
    private final ay d;
    private final com.google.android.libraries.navigation.internal.oa.e e;
    private final com.google.android.libraries.navigation.internal.op.i f;
    private final com.google.android.libraries.navigation.internal.qk.w g;
    private final Context h;
    private final Boolean i;
    private final aq j = new aq();
    private n k;
    private final com.google.android.libraries.navigation.internal.cr.f l;

    public ar(com.google.android.libraries.navigation.internal.oa.e eVar, com.google.android.libraries.navigation.internal.op.i iVar, com.google.android.libraries.navigation.internal.qk.w wVar, com.google.android.libraries.navigation.internal.cr.f fVar, Context context, boolean z) {
        this.e = eVar;
        this.f = iVar;
        this.g = wVar;
        this.l = fVar;
        this.h = context;
        this.i = Boolean.valueOf(z);
        az azVar = new az(context, ((fk) eVar).I);
        ax axVar = null;
        if (z) {
            this.d = new ay(azVar);
        } else {
            this.d = null;
            axVar = new ax(azVar);
        }
        this.c = axVar;
    }

    private final synchronized dt e(com.google.android.libraries.navigation.internal.oj.c cVar, aw awVar, boolean z) {
        dq dqVarB;
        dqVarB = cVar.b(awVar.a(z));
        dp dpVar = (dp) cVar.a(awVar.c()).t();
        Cdo cdoA = cVar.a(awVar.e());
        if (!cdoA.b.H()) {
            cdoA.v();
        }
        dp dpVar2 = (dp) cdoA.b;
        dp dpVar3 = dp.a;
        dpVar2.b |= 1;
        dpVar2.c = "  ";
        dp dpVar4 = (dp) cdoA.t();
        if (com.google.android.libraries.navigation.internal.gz.i.a(this.h)) {
            dqVarB.e(dpVar4);
            dqVarB.e(dpVar);
        } else {
            dqVarB.e(dpVar);
            dqVarB.e(dpVar4);
        }
        return (dt) dqVarB.t();
    }

    private final synchronized dt f(com.google.android.libraries.navigation.internal.oj.c cVar, aw awVar, ck ckVar, boolean z) {
        dq dqVarB;
        dqVarB = cVar.b(awVar.b(z));
        ds dsVar = com.google.android.libraries.navigation.internal.gz.i.a(this.h) ? ds.RIGHT_JUSTIFY : ds.LEFT_JUSTIFY;
        if (!dqVarB.b.H()) {
            dqVarB.v();
        }
        dt dtVar = (dt) dqVarB.b;
        dt dtVar2 = dt.a;
        dtVar.f = dsVar.d;
        dtVar.b |= 4;
        Cdo cdoA = cVar.a(awVar.b(z));
        String strV = ckVar.V();
        if (!cdoA.b.H()) {
            cdoA.v();
        }
        dp dpVar = (dp) cdoA.b;
        dp dpVar2 = dp.a;
        strV.getClass();
        dpVar.b |= 1;
        dpVar.c = strV;
        dqVarB.d(cdoA);
        Cdo cdoA2 = cVar.a(awVar.d());
        if (!cdoA2.b.H()) {
            cdoA2.v();
        }
        dp dpVar3 = (dp) cdoA2.b;
        dpVar3.b |= 32;
        dpVar3.h = true;
        String upperCase = this.h.getString(com.google.android.libraries.navigation.internal.f.h.G).toUpperCase(Locale.getDefault());
        if (!cdoA2.b.H()) {
            cdoA2.v();
        }
        dp dpVar4 = (dp) cdoA2.b;
        upperCase.getClass();
        dpVar4.b |= 1;
        dpVar4.c = upperCase;
        dqVarB.d(cdoA2);
        return (dt) dqVarB.t();
    }

    private final synchronized void g(com.google.android.libraries.navigation.internal.oj.c cVar, aw awVar, ck ckVar, boolean z) {
        dy dyVarC = cVar.c();
        dt dtVarE = e(cVar, awVar, z);
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar = (ef) dyVarC.b;
        ef efVar2 = ef.a;
        dtVarE.getClass();
        efVar.c = dtVarE;
        efVar.b |= 1;
        dt dtVarF = f(cVar, awVar, ckVar, z);
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar3 = (ef) dyVarC.b;
        dtVarF.getClass();
        efVar3.d = dtVarF;
        efVar3.b |= 2;
        ee eeVar = com.google.android.libraries.navigation.internal.gz.i.a(this.h) ? ee.CENTER_RIGHT_TO_CENTER_LEFT : ee.CENTER_LEFT_TO_CENTER_RIGHT;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar4 = (ef) dyVarC.b;
        efVar4.g = eeVar.q;
        efVar4.b |= 32;
        com.google.android.libraries.navigation.internal.adg.c cVar2 = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.oe.r rVarN = ckVar.n();
        com.google.android.libraries.navigation.internal.yx.ar.q(rVarN);
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(com.google.android.libraries.navigation.internal.oe.x.z(rVarN));
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        com.google.android.libraries.navigation.internal.adg.b bVarA = az.a();
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        dVar2.d = bVarA.j;
        dVar2.b |= 2;
        com.google.android.libraries.navigation.internal.adg.d dVar3 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.t();
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar5 = (ef) dyVarC.b;
        dVar3.getClass();
        efVar5.e = dVar3;
        efVar5.b |= 8;
        fr frVar = (fr) fs.a.q();
        frVar.C(fu.w, cx.a);
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar6 = (ef) dyVarC.b;
        fs fsVar = (fs) frVar.t();
        fsVar.getClass();
        efVar6.u = fsVar;
        efVar6.b |= 65536;
    }

    private final synchronized boolean h() {
        this.b = null;
        this.k = null;
        com.google.android.libraries.navigation.internal.qk.ak akVar = this.a;
        if (akVar == null) {
            return false;
        }
        akVar.c();
        this.a = null;
        return true;
    }

    private final synchronized com.google.android.libraries.navigation.internal.qk.ak i(ck ckVar, n nVar, boolean z) {
        com.google.android.libraries.navigation.internal.qk.ak aiVar;
        if (this.i.booleanValue()) {
            com.google.android.libraries.navigation.internal.op.i iVar = this.f;
            ay ayVar = this.d;
            com.google.android.libraries.navigation.internal.yx.ar.q(ayVar);
            com.google.android.libraries.navigation.internal.oj.c cVarF = com.google.android.libraries.navigation.internal.oj.c.f(iVar, ayVar.a(z), new com.google.android.libraries.navigation.internal.op.b());
            ay ayVar2 = this.d;
            com.google.android.libraries.navigation.internal.yx.ar.q(ayVar2);
            g(cVarF, ayVar2, ckVar, z);
            com.google.android.libraries.navigation.internal.qk.u uVarJ = com.google.android.libraries.navigation.internal.qk.v.j();
            uVarJ.d(((com.google.android.libraries.navigation.internal.oj.b) cVarF).e());
            uVarJ.f(this.j);
            ((com.google.android.libraries.navigation.internal.qk.c) uVarJ).a = com.google.android.libraries.navigation.internal.oe.x.z(ckVar.n());
            uVarJ.i(com.google.android.libraries.navigation.internal.qk.t.REMOVE_WAYPOINT);
            uVarJ.g(0);
            uVarJ.e(az.a());
            uVarJ.h(az.a);
            aiVar = new com.google.android.libraries.navigation.internal.qk.aj(this.g, uVarJ.j(), this.l, nVar);
        } else {
            ax axVar = this.c;
            com.google.android.libraries.navigation.internal.yx.ar.q(axVar);
            com.google.android.libraries.navigation.internal.oj.c cVarG = com.google.android.libraries.navigation.internal.oj.c.g(axVar.a(z));
            ax axVar2 = this.c;
            com.google.android.libraries.navigation.internal.yx.ar.q(axVar2);
            g(cVarG, axVar2, ckVar, z);
            com.google.android.libraries.navigation.internal.oa.e eVar = this.e;
            com.google.android.libraries.navigation.internal.po.aa aaVarN = ((fk) eVar).H.n(((com.google.android.libraries.navigation.internal.oj.a) cVarG).e(), jr.WORLD_ENCODING_LAT_LNG_E7);
            aaVarN.k(nVar);
            com.google.android.libraries.navigation.internal.qk.g gVarG = com.google.android.libraries.navigation.internal.qk.h.g();
            gVarG.b(aaVarN);
            gVarG.c(this.j);
            gVarG.f(com.google.android.libraries.navigation.internal.qk.t.REMOVE_WAYPOINT);
            gVarG.d(0);
            gVarG.e(az.a);
            aiVar = new com.google.android.libraries.navigation.internal.qk.ai(((fk) this.e).K, gVarG.g());
        }
        this.b = ckVar;
        this.k = nVar;
        return aiVar;
    }

    public final synchronized void a() {
        h();
        ax axVar = this.c;
        if (axVar != null) {
            az azVar = axVar.a;
            at atVar = azVar.f;
            br brVar = (br) atVar.a.getAndSet(null);
            if (brVar != null) {
                atVar.b.b.j((com.google.android.libraries.navigation.internal.ol.aq) brVar.a());
            }
            azVar.g.d();
            azVar.h.d();
            azVar.i.d();
            azVar.j.d();
            azVar.d.d();
            azVar.e.d();
        }
    }

    public final synchronized void b(boolean z) {
        ck ckVar = this.b;
        n nVar = this.k;
        h();
        if (ckVar == null || nVar == null) {
            return;
        }
        d(ckVar, nVar, z);
    }

    public final synchronized boolean c() {
        return h();
    }

    public final synchronized void d(ck ckVar, n nVar, boolean z) {
        if (ckVar.equals(this.b)) {
            return;
        }
        h();
        com.google.android.libraries.navigation.internal.qk.ak akVarI = i(ckVar, nVar, z);
        this.a = akVarI;
        akVarI.f();
    }
}
