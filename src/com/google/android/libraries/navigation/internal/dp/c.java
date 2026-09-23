package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements com.google.android.libraries.navigation.internal.dq.f {
    final /* synthetic */ g a;

    public c(g gVar) {
        this.a = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.f
    public final void a() {
        synchronized (this.a.b) {
            g gVar = this.a;
            if (!gVar.r) {
                gVar.r = true;
                if (gVar.q) {
                    gVar.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dp.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            final c cVar = this.a;
                            g gVar2 = cVar.a;
                            com.google.android.libraries.navigation.internal.oa.k kVar = gVar2.k;
                            if (kVar == null) {
                                return;
                            }
                            gVar2.t = com.google.android.libraries.navigation.internal.hx.u.a(kVar.d, new com.google.android.libraries.navigation.internal.hx.q() { // from class: com.google.android.libraries.navigation.internal.dp.a
                                @Override // com.google.android.libraries.navigation.internal.hx.q
                                public final void a(Object obj) {
                                    float fA;
                                    c cVar2 = cVar;
                                    if (cVar2.a.h.f() == 2) {
                                        fA = 13.0f;
                                        if (cVar2.a.g.s(new com.google.android.libraries.navigation.internal.oe.x())) {
                                            com.google.android.libraries.navigation.internal.oe.x xVarB = cVar2.a.g.b();
                                            ar.q(xVarB);
                                            double dE = xVarB.e() * 2000.0d;
                                            com.google.android.libraries.navigation.internal.oq.d dVar = cVar2.a.s;
                                            if (dVar != null) {
                                                com.google.android.libraries.navigation.internal.rf.g gVarC = dVar.c();
                                                float fFloor = (float) Math.floor(com.google.android.libraries.navigation.internal.pb.j.g(gVarC.b(), (float) (dE + dE), Math.min(gVarC.d(), gVarC.c())));
                                                if (fFloor >= 2.0f && fFloor <= 21.0f) {
                                                    fA = fFloor;
                                                }
                                            }
                                        }
                                    } else {
                                        fA = cVar2.a.i.a();
                                    }
                                    ap.UI_THREAD.f();
                                    com.google.android.libraries.navigation.internal.oq.d dVar2 = cVar2.a.s;
                                    if (dVar2 != null) {
                                        g gVar3 = cVar2.a;
                                        com.google.android.libraries.navigation.internal.oq.f fVarA = dVar2.a();
                                        com.google.android.libraries.navigation.internal.pd.f fVar = new com.google.android.libraries.navigation.internal.pd.f();
                                        fVar.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY;
                                        fVar.b = fA;
                                        fVar.c = fVarA.b();
                                        fVar.d = fVarA.a();
                                        fVar.e = com.google.android.libraries.navigation.internal.pd.e.a;
                                        gVar3.f(fVar.a(), false);
                                    }
                                }
                            }, ac.INSTANCE);
                        }
                    });
                }
            }
        }
    }
}
