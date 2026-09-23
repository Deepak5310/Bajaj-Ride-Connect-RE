package com.google.android.libraries.navigation.internal.vi;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.us.y;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b extends y<com.google.android.libraries.navigation.internal.tj.l> {
    private final com.google.android.libraries.navigation.internal.bn.d x;
    private final com.google.android.libraries.navigation.internal.dx.o y;

    public b(Context context, com.google.android.libraries.navigation.internal.bn.d dVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.sl.d dVar3, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar, af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, at atVar, com.google.android.libraries.navigation.internal.ch.b bVar, com.google.android.libraries.navigation.internal.dx.o oVar, com.google.android.libraries.navigation.internal.tj.l lVar) {
        super(lVar, context, eVar, dVar2, dVar3, hVar, context.getResources(), aVar, afVar, tVar, bnVar, executor, mVar, bVar);
        this.x = dVar;
        this.y = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public List<com.google.android.libraries.navigation.internal.ut.d.b> G() {
        int i = ev.d;
        return lv.a;
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public void b() {
        this.m = ((com.google.android.libraries.navigation.internal.tj.l) this.a).a;
        this.f626n = this.g.getString(com.google.android.libraries.navigation.internal.dw.h.U);
        K(Y().a());
        com.google.android.libraries.navigation.internal.vg.b bVar = ((com.google.android.libraries.navigation.internal.tj.l) this.a).b;
        ar.q(bVar);
        ah ahVarA = com.google.android.libraries.navigation.internal.ca.d.a(bVar.b(), bVar.a(), this.x, new com.google.android.libraries.navigation.internal.bn.b() { // from class: com.google.android.libraries.navigation.internal.vi.a
            @Override // com.google.android.libraries.navigation.internal.bn.b
            public final void a(ah ahVar) {
                this.a.N(ahVar);
            }
        });
        if (ahVarA == null) {
            ahVarA = aj.c();
        }
        N(ahVarA);
        super.b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.c f() {
        return com.google.android.libraries.navigation.internal.ut.d.c.DEFAULT;
    }
}
