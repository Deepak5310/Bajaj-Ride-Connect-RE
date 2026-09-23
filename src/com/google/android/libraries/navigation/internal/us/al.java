package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.es;
import com.google.android.libraries.navigation.internal.adr.iw;
import com.google.android.libraries.navigation.internal.adr.jd;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Collections;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class al extends y<com.google.android.libraries.navigation.internal.tj.ag> {
    private final com.google.android.libraries.navigation.internal.ut.d.a x;
    private final jg y;
    private final com.google.android.libraries.navigation.internal.sl.l z;

    public al(Context context, com.google.android.libraries.navigation.internal.tj.ag agVar, com.google.android.libraries.navigation.internal.ut.d.a aVar, long j, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.sl.d dVar2, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, com.google.android.libraries.navigation.internal.bn.d dVar3, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, com.google.android.libraries.navigation.internal.sl.l lVar, com.google.android.libraries.navigation.internal.ch.b bVar) {
        super(agVar, context, eVar, dVar, dVar2, hVar, context.getResources(), aVar2, afVar, tVar, bnVar, executor, j, bVar);
        this.x = aVar;
        jg jgVar = agVar.a;
        ar.r(jgVar, "trafficReportPrompt");
        this.y = jgVar;
        this.z = lVar;
        m mVarY = Y();
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.b = jgVar.d;
        com.google.android.libraries.navigation.internal.jy.x xVarA = xVar.a(jgVar.c);
        xVarA.i = com.google.android.libraries.navigation.internal.afe.i.L;
        mVarY.f = xVarA.b();
        K(mVarY.a());
        com.google.android.libraries.navigation.internal.br.o oVar = new com.google.android.libraries.navigation.internal.br.o();
        oVar.a = context;
        int iA = aVar.a();
        if (iA != -1) {
            oVar.e = this.g.getString(com.google.android.libraries.navigation.internal.dw.h.bq, com.google.android.libraries.navigation.internal.hf.u.b(context, ((long) iA) + aVar2.f().getEpochSecond()));
        }
        com.google.android.libraries.navigation.internal.br.p pVar = new com.google.android.libraries.navigation.internal.br.p(oVar);
        oVar.a();
        com.google.android.libraries.navigation.internal.br.p pVar2 = new com.google.android.libraries.navigation.internal.br.p(oVar);
        el elVar = jgVar.i;
        elVar = elVar == null ? el.a : elVar;
        this.m = pVar.a(elVar.f221n);
        CharSequence charSequenceA = pVar.a(elVar.p);
        if (!(elVar.c == 23 ? (es) elVar.d : es.a).b) {
            CharSequence charSequenceA2 = pVar2.a(elVar.p);
            R(charSequenceA);
            S(charSequenceA2);
            TextUtils.isEmpty(pVar.a(elVar.q).toString());
        }
        this.o = charSequenceA;
        ak.c(jgVar, dVar3, this);
        com.google.android.libraries.navigation.internal.jy.x xVar2 = new com.google.android.libraries.navigation.internal.jy.x();
        xVar2.b = jgVar.d;
        com.google.android.libraries.navigation.internal.jy.x xVarA2 = xVar2.a(jgVar.c);
        xVarA2.d = hv.DIRECTIONS;
        xVarA2.i = com.google.android.libraries.navigation.internal.afe.i.I;
        this.q = xVarA2.b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final com.google.android.libraries.navigation.internal.vn.d a() {
        if (!e() || this.z.a() != com.google.android.libraries.navigation.internal.sl.m.MINIMAL) {
            jg jgVar = this.y;
            com.google.android.libraries.navigation.internal.ut.d.a aVar = this.x;
            return ak.b(jgVar, aVar.a(), null, this.f);
        }
        jg jgVar2 = this.y;
        com.google.android.libraries.navigation.internal.ut.d.a aVar2 = this.x;
        com.google.android.libraries.navigation.internal.sn.h hVar = this.f;
        int iA = aVar2.a();
        int i = ak.a;
        jd jdVarB = jd.b(jgVar2.e);
        if (jdVarB == null) {
            jdVarB = jd.DEFAULT_NONE;
        }
        return hVar.c(ak.a(jdVarB), Collections.emptyList(), iA, null);
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final void d() {
        com.google.android.libraries.navigation.internal.jy.r rVarD = this.j.d();
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        jg jgVar = this.y;
        xVar.b = jgVar.d;
        com.google.android.libraries.navigation.internal.jy.x xVarA = xVar.a(jgVar.c);
        xVarA.d = hv.DIRECTIONS;
        xVarA.i = com.google.android.libraries.navigation.internal.afe.i.R;
        rVarD.b(xVarA.b());
    }

    public boolean e() {
        int iA = iw.a(this.y.l);
        if (iA == 0) {
            iA = iw.a;
        }
        return iA == iw.c;
    }
}
