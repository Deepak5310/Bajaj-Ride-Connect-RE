package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.pi.ac;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa implements com.google.android.libraries.navigation.internal.pi.p {
    final /* synthetic */ ab a;

    public aa(ab abVar) {
        this.a = abVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pi.p
    public final void aB(ac acVar) {
        if (this.a.d == null || !acVar.a()) {
            return;
        }
        ab abVar = this.a;
        ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        if (true != abVar.h.a.g.s(xVar)) {
            xVar = null;
        }
        if (xVar != null) {
            if ((((double) com.google.android.libraries.navigation.internal.oe.h.c(abVar.c.a().d()).h(xVar)) / ((double) com.google.android.libraries.navigation.internal.pb.j.s(abVar.c.c()))) / ((double) abVar.c.c().b()) < 20.0d) {
                com.google.android.libraries.navigation.internal.ql.a aVar = this.a.d;
                ar.q(aVar);
                if (aVar == com.google.android.libraries.navigation.internal.ql.a.COMPASS) {
                    ab abVar2 = this.a;
                    ap.UI_THREAD.f();
                    com.google.android.libraries.navigation.internal.dq.i iVar = abVar2.h.a.g;
                    com.google.android.libraries.navigation.internal.oq.d dVar = abVar2.c;
                    if (Math.abs(com.google.android.libraries.navigation.internal.nq.a.e(dVar.a().a() - iVar.a())) > 10.0f) {
                        aVar = com.google.android.libraries.navigation.internal.ql.a.TRACKING;
                    }
                }
                ab abVar3 = this.a;
                ap.UI_THREAD.f();
                if (aVar == com.google.android.libraries.navigation.internal.ql.a.OFF) {
                    ((com.google.android.libraries.navigation.internal.zb.h) g.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 406)).p("Attempted to snap back to AutoPanMode.OFF");
                } else {
                    f fVar = abVar3.h;
                    com.google.android.libraries.navigation.internal.oq.d dVar2 = fVar.a.s;
                    if (dVar2 != null) {
                        com.google.android.libraries.navigation.internal.oq.f fVarA = dVar2.a();
                        com.google.android.libraries.navigation.internal.pd.e eVar = new com.google.android.libraries.navigation.internal.pd.e(((com.google.android.libraries.navigation.internal.oq.c) fVarA.f()).a, ((com.google.android.libraries.navigation.internal.oq.c) fVarA.f()).a);
                        com.google.android.libraries.navigation.internal.pd.f fVar2 = new com.google.android.libraries.navigation.internal.pd.f();
                        fVar2.e = eVar;
                        fVar2.c = fVarA.b();
                        fVar2.b = fVarA.c();
                        if (aVar == com.google.android.libraries.navigation.internal.ql.a.TRACKING) {
                            fVar2.d = fVarA.a();
                            fVar2.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY;
                        } else {
                            fVar2.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_AND_BEARING;
                        }
                        fVar.a.f(fVar2.a(), false);
                    }
                }
                this.a.d = null;
                return;
            }
        }
        this.a.d = null;
    }
}
