package com.google.android.libraries.navigation.internal.we;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au implements at {
    private final com.google.android.libraries.navigation.internal.kl.b a;

    public au(com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.we.at
    public final com.google.android.libraries.navigation.internal.wl.d a(bh bhVar, com.google.android.libraries.navigation.internal.ade.n nVar) {
        com.google.android.libraries.navigation.internal.add.av avVar = (com.google.android.libraries.navigation.internal.add.av) com.google.android.libraries.navigation.internal.add.aw.a.q();
        ez ezVar = new ez();
        for (int i = 0; i < bhVar.d(); i++) {
            com.google.android.libraries.navigation.internal.bp.bg bgVarE = bhVar.e(i);
            com.google.android.libraries.navigation.internal.ade.o oVar = (com.google.android.libraries.navigation.internal.ade.o) com.google.android.libraries.navigation.internal.ade.p.a.q();
            String str = bgVarE.Z;
            if (!oVar.b.H()) {
                oVar.v();
            }
            com.google.android.libraries.navigation.internal.ade.p pVar = (com.google.android.libraries.navigation.internal.ade.p) oVar.b;
            str.getClass();
            pVar.b = str;
            com.google.android.libraries.navigation.internal.ael.x xVar = bgVarE.U;
            if (xVar != null) {
                String strI = com.google.android.libraries.navigation.internal.zn.g.d.i(xVar.B());
                if (!oVar.b.H()) {
                    oVar.v();
                }
                ((com.google.android.libraries.navigation.internal.ade.p) oVar.b).c = strI;
            }
            if (bhVar.a() == i) {
                com.google.android.libraries.navigation.internal.ade.p pVar2 = (com.google.android.libraries.navigation.internal.ade.p) oVar.t();
                if (!avVar.b.H()) {
                    avVar.v();
                }
                com.google.android.libraries.navigation.internal.add.aw awVar = (com.google.android.libraries.navigation.internal.add.aw) avVar.b;
                pVar2.getClass();
                awVar.c = pVar2;
                awVar.b |= 1;
            } else {
                avVar.e((com.google.android.libraries.navigation.internal.ade.p) oVar.t());
            }
            ezVar.f(bgVarE.Z, new com.google.android.libraries.navigation.internal.wl.a(bgVarE, nVar));
        }
        try {
            fd fdVarD = ezVar.d();
            com.google.android.libraries.navigation.internal.add.aw awVar2 = (com.google.android.libraries.navigation.internal.add.aw) avVar.t();
            com.google.android.libraries.navigation.internal.wl.d dVar = com.google.android.libraries.navigation.internal.wl.d.c;
            return new com.google.android.libraries.navigation.internal.wl.b(awVar2, fdVarD);
        } catch (IllegalArgumentException e) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.a.a(com.google.android.libraries.navigation.internal.km.ak.b)).a();
            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, e.getMessage(), e.getCause()));
        }
    }
}
