package com.google.android.libraries.navigation.internal.uq;

import android.content.Context;
import androidx.work.WorkRequest;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.sv.bk;
import com.google.android.libraries.navigation.internal.tj.ae;
import com.google.android.libraries.navigation.internal.tj.ag;
import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.tj.y;
import com.google.android.libraries.navigation.internal.us.ac;
import com.google.android.libraries.navigation.internal.us.ad;
import com.google.android.libraries.navigation.internal.us.al;
import com.google.android.libraries.navigation.internal.us.am;
import java.util.Optional;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements l {
    private final am a;
    private final ad b;
    private final com.google.android.libraries.navigation.internal.us.c c;
    private final Optional d;

    public a(am amVar, ad adVar, com.google.android.libraries.navigation.internal.us.c cVar, Optional optional) {
        this.a = amVar;
        this.b = adVar;
        this.c = cVar;
        this.d = optional;
    }

    @Override // com.google.android.libraries.navigation.internal.uq.l
    public final com.google.android.libraries.navigation.internal.ut.d a(Context context, u uVar, com.google.android.libraries.navigation.internal.ut.d.a aVar, boolean z) {
        if (uVar instanceof ag) {
            ag agVar = (ag) uVar;
            am amVar = this.a;
            long j = true != z ? 6000L : WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
            context.getClass();
            com.google.android.libraries.navigation.internal.ia.e eVar = (com.google.android.libraries.navigation.internal.ia.e) amVar.a.a();
            eVar.getClass();
            com.google.android.libraries.navigation.internal.fz.d dVar = (com.google.android.libraries.navigation.internal.fz.d) amVar.b.a();
            dVar.getClass();
            com.google.android.libraries.navigation.internal.sl.d dVar2 = (com.google.android.libraries.navigation.internal.sl.d) amVar.c.a();
            dVar2.getClass();
            com.google.android.libraries.navigation.internal.sn.h hVar = (com.google.android.libraries.navigation.internal.sn.h) amVar.d.a();
            hVar.getClass();
            com.google.android.libraries.navigation.internal.mj.a aVar2 = (com.google.android.libraries.navigation.internal.mj.a) amVar.e.a();
            aVar2.getClass();
            af afVar = (af) amVar.f.a();
            afVar.getClass();
            t tVar = (t) amVar.g.a();
            tVar.getClass();
            com.google.android.libraries.navigation.internal.bn.d dVar3 = (com.google.android.libraries.navigation.internal.bn.d) amVar.h.a();
            dVar3.getClass();
            bn bnVar = (bn) amVar.i.a();
            bnVar.getClass();
            Executor executor = (Executor) amVar.j.a();
            executor.getClass();
            m mVar = (m) amVar.k.a();
            mVar.getClass();
            com.google.android.libraries.navigation.internal.sl.l lVar = (com.google.android.libraries.navigation.internal.sl.l) amVar.l.a();
            lVar.getClass();
            com.google.android.libraries.navigation.internal.ch.b bVar = (com.google.android.libraries.navigation.internal.ch.b) amVar.m.a();
            bVar.getClass();
            return new al(context, agVar, aVar, j, eVar, dVar, dVar2, hVar, aVar2, afVar, tVar, dVar3, bnVar, executor, mVar, lVar, bVar);
        }
        if (uVar instanceof y) {
            ad adVar = this.b;
            context.getClass();
            com.google.android.libraries.navigation.internal.ia.e eVar2 = (com.google.android.libraries.navigation.internal.ia.e) adVar.a.a();
            eVar2.getClass();
            com.google.android.libraries.navigation.internal.fz.d dVar4 = (com.google.android.libraries.navigation.internal.fz.d) adVar.b.a();
            dVar4.getClass();
            com.google.android.libraries.navigation.internal.sl.d dVar5 = (com.google.android.libraries.navigation.internal.sl.d) adVar.c.a();
            dVar5.getClass();
            com.google.android.libraries.navigation.internal.sn.h hVar2 = (com.google.android.libraries.navigation.internal.sn.h) adVar.d.a();
            hVar2.getClass();
            com.google.android.libraries.navigation.internal.mj.a aVar3 = (com.google.android.libraries.navigation.internal.mj.a) adVar.e.a();
            aVar3.getClass();
            af afVar2 = (af) adVar.f.a();
            afVar2.getClass();
            t tVar2 = (t) adVar.g.a();
            tVar2.getClass();
            bn bnVar2 = (bn) adVar.h.a();
            bnVar2.getClass();
            Executor executor2 = (Executor) adVar.i.a();
            executor2.getClass();
            m mVar2 = (m) adVar.j.a();
            mVar2.getClass();
            com.google.android.libraries.navigation.internal.ch.b bVar2 = (com.google.android.libraries.navigation.internal.ch.b) adVar.k.a();
            bVar2.getClass();
            bk bkVar = (bk) adVar.l.a();
            bkVar.getClass();
            ae aeVar = (ae) adVar.m.a();
            aeVar.getClass();
            return new ac(context, (y) uVar, eVar2, dVar4, dVar5, hVar2, aVar3, afVar2, tVar2, bnVar2, executor2, mVar2, bVar2, bkVar, aeVar);
        }
        if (!(uVar instanceof com.google.android.libraries.navigation.internal.tj.b)) {
            return null;
        }
        com.google.android.libraries.navigation.internal.us.c cVar = this.c;
        Optional optional = this.d;
        context.getClass();
        optional.getClass();
        com.google.android.libraries.navigation.internal.ia.e eVar3 = (com.google.android.libraries.navigation.internal.ia.e) cVar.a.a();
        eVar3.getClass();
        com.google.android.libraries.navigation.internal.sl.d dVar6 = (com.google.android.libraries.navigation.internal.sl.d) cVar.b.a();
        dVar6.getClass();
        com.google.android.libraries.navigation.internal.sn.h hVar3 = (com.google.android.libraries.navigation.internal.sn.h) cVar.c.a();
        hVar3.getClass();
        com.google.android.libraries.navigation.internal.mj.a aVar4 = (com.google.android.libraries.navigation.internal.mj.a) cVar.d.a();
        aVar4.getClass();
        com.google.android.libraries.navigation.internal.fz.d dVar7 = (com.google.android.libraries.navigation.internal.fz.d) cVar.e.a();
        dVar7.getClass();
        af afVar3 = (af) cVar.f.a();
        afVar3.getClass();
        t tVar3 = (t) cVar.g.a();
        tVar3.getClass();
        com.google.android.libraries.navigation.internal.aq.m mVar3 = (com.google.android.libraries.navigation.internal.aq.m) cVar.h.a();
        mVar3.getClass();
        bn bnVar3 = (bn) cVar.i.a();
        bnVar3.getClass();
        Executor executor3 = (Executor) cVar.j.a();
        executor3.getClass();
        m mVar4 = (m) cVar.k.a();
        mVar4.getClass();
        com.google.android.libraries.navigation.internal.bn.d dVar8 = (com.google.android.libraries.navigation.internal.bn.d) cVar.l.a();
        dVar8.getClass();
        com.google.android.libraries.navigation.internal.ch.b bVar3 = (com.google.android.libraries.navigation.internal.ch.b) cVar.m.a();
        bVar3.getClass();
        com.google.android.libraries.navigation.internal.iv.f fVar = (com.google.android.libraries.navigation.internal.iv.f) cVar.f623n.a();
        fVar.getClass();
        return new com.google.android.libraries.navigation.internal.us.b(context, (com.google.android.libraries.navigation.internal.tj.b) uVar, aVar, optional, eVar3, dVar6, hVar3, aVar4, dVar7, afVar3, tVar3, mVar3, bnVar3, executor3, mVar4, dVar8, bVar3, fVar);
    }
}
