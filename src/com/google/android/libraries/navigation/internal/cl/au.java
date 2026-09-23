package com.google.android.libraries.navigation.internal.cl;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends al {
    public final boolean d;
    public final an e;
    private static final fy f = fy.u(com.google.android.libraries.navigation.internal.aap.l.TURN, com.google.android.libraries.navigation.internal.aap.l.NAME_CHANGE, com.google.android.libraries.navigation.internal.aap.l.UTURN, com.google.android.libraries.navigation.internal.aap.l.ON_RAMP, com.google.android.libraries.navigation.internal.aap.l.OFF_RAMP, com.google.android.libraries.navigation.internal.aap.l.FORK, com.google.android.libraries.navigation.internal.aap.l.FERRY, com.google.android.libraries.navigation.internal.aap.l.FERRY_TRAIN, com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_EXIT, com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER_AND_EXIT);
    public static final fy c = fy.q(com.google.android.libraries.navigation.internal.ady.al.DRIVE, com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER);

    public au(com.google.android.libraries.navigation.internal.bp.bg bgVar, com.google.android.libraries.navigation.internal.bp.bj bjVar, bq bqVar, Rect rect, String str, boolean z, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.op.i iVar) {
        super(bgVar, bqVar, str, iVar);
        this.d = z;
        com.google.android.libraries.navigation.internal.oh.n nVar = new com.google.android.libraries.navigation.internal.oh.n();
        com.google.android.libraries.navigation.internal.oh.c cVar = new com.google.android.libraries.navigation.internal.oh.c(com.google.android.libraries.navigation.internal.qk.t.NAVIGATION_SEARCH_RESULT);
        am amVar = z ? null : new am();
        com.google.android.libraries.navigation.internal.oh.f fVar = new com.google.android.libraries.navigation.internal.oh.f();
        aq aqVar = new aq(rect, ev.o(bgVar.B()));
        ap apVar = new ap(ev.p(bgVar.l), bqVar);
        com.google.android.libraries.navigation.internal.oe.ad adVar = bgVar.m;
        com.google.android.libraries.navigation.internal.oh.g gVar = new com.google.android.libraries.navigation.internal.oh.g(adVar, ev.q(adVar), 0.0f, 0.0f);
        ao aoVar = new ao(bqVar, bgVar.m);
        com.google.android.libraries.navigation.internal.oh.b bVar = new com.google.android.libraries.navigation.internal.oh.b();
        com.google.android.libraries.navigation.internal.oh.e eVar = new com.google.android.libraries.navigation.internal.oh.e();
        com.google.android.libraries.navigation.internal.oh.j jVar = new com.google.android.libraries.navigation.internal.oh.j();
        com.google.android.libraries.navigation.internal.oh.p.a aVar = new com.google.android.libraries.navigation.internal.oh.p.a();
        aVar.c(cVar);
        if (amVar != null) {
            aVar.c(amVar);
        }
        aVar.c(fVar);
        aVar.c(aqVar);
        aVar.b(0, jVar, 0.5f);
        aVar.d(100, apVar);
        aVar.d(500, gVar);
        aVar.d(10, aoVar);
        aVar.d(10, bVar);
        aVar.e(1, eVar);
        com.google.android.libraries.navigation.internal.oe.x xVarB = bjVar.b(bqVar);
        this.e = new an(xVarB == null ? bqVar.c : xVarB, nVar, aVar.a());
    }

    public static boolean c(bq bqVar) {
        return f.contains(bqVar.d);
    }

    public final ef b(at atVar) {
        com.google.android.libraries.navigation.internal.ol.aq aqVarB = atVar.b();
        com.google.android.libraries.navigation.internal.ol.aq aqVarD = atVar.d();
        com.google.android.libraries.navigation.internal.ol.aq aqVarC = atVar.c(this.a);
        com.google.android.libraries.navigation.internal.oj.c cVarG = com.google.android.libraries.navigation.internal.oj.c.g(aqVarB);
        super.a(cVarG, aqVarB, aqVarD, aqVarC, atVar.c);
        ef efVarE = ((com.google.android.libraries.navigation.internal.oj.a) cVarG).e();
        if (efVarE == null) {
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) efVarE.aH(5, null);
        bbVar.x(efVarE);
        return (ef) ((dy) bbVar).t();
    }
}
