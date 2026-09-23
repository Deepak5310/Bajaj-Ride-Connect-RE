package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yz.gs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae extends com.google.android.libraries.navigation.internal.ol.ar {
    final /* synthetic */ bg a;
    final /* synthetic */ boolean b;
    final /* synthetic */ am c;

    public ae(am amVar, bg bgVar, boolean z) {
        this.a = bgVar;
        this.b = z;
        this.c = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        final com.google.android.libraries.navigation.internal.ol.p pVar = (com.google.android.libraries.navigation.internal.ol.p) obj;
        final bg bgVar = this.a;
        final boolean z = this.b;
        this.c.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.ad
            @Override // java.lang.Runnable
            public final void run() {
                int iN;
                int iN2;
                com.google.android.libraries.navigation.internal.ol.p pVar2 = pVar;
                bi biVar = (bi) pVar2.n();
                if (biVar.H()) {
                    iN = biVar.n();
                } else {
                    int iN3 = biVar.ak;
                    if (iN3 == 0) {
                        iN3 = biVar.n();
                        biVar.ak = iN3;
                    }
                    iN = iN3;
                }
                ae aeVar = this.a;
                com.google.android.libraries.navigation.internal.jy.o oVar = (com.google.android.libraries.navigation.internal.jy.o) aeVar.c.S.get(Integer.valueOf(iN));
                if (oVar != null) {
                    boolean z2 = z;
                    bg bgVar2 = bgVar;
                    am amVar = aeVar.c;
                    com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
                    com.google.android.libraries.navigation.internal.jy.x xVarA = new com.google.android.libraries.navigation.internal.jy.x().a(bgVar2.G());
                    com.google.android.libraries.navigation.internal.afd.a aVar = z2 ? com.google.android.libraries.navigation.internal.afe.o.v : com.google.android.libraries.navigation.internal.afe.o.w;
                    com.google.android.libraries.navigation.internal.jy.af afVar = amVar.D;
                    xVarA.i = aVar;
                    afVar.c(oVar, xVarA.b());
                    am amVar2 = aeVar.c;
                    bi biVar2 = (bi) pVar2.n();
                    if (biVar2.H()) {
                        iN2 = biVar2.n();
                    } else {
                        int iN4 = biVar2.ak;
                        if (iN4 == 0) {
                            iN4 = biVar2.n();
                            biVar2.ak = iN4;
                        }
                        iN2 = iN4;
                    }
                    amVar2.S.remove(Integer.valueOf(iN2));
                }
            }
        });
        com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) gs.c(this.a.N(), null);
        com.google.android.libraries.navigation.internal.yx.ar.q(xVar);
        this.c.c.f(com.google.android.libraries.navigation.internal.pi.y.a(1, xVar, this.a));
    }
}
