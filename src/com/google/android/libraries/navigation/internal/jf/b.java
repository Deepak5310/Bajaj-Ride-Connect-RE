package com.google.android.libraries.navigation.internal.jf;

import com.google.android.libraries.navigation.internal.aba.f;
import com.google.android.libraries.navigation.internal.aba.h;
import com.google.android.libraries.navigation.internal.ael.ac;
import com.google.android.libraries.navigation.internal.ael.ad;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.ael.dr;
import com.google.android.libraries.navigation.internal.ael.ee;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.aeq.d;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.an;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {
    final AtomicReference a = new AtomicReference("Needs to be loaded from perstistent storage.");
    private final com.google.android.libraries.navigation.internal.hk.a b;

    public b(com.google.android.libraries.navigation.internal.hk.a aVar) {
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.hj.b
    public final /* synthetic */ void b(Object obj, Object obj2) {
        d dVarC;
        com.google.android.libraries.navigation.internal.aeq.c cVar;
        synchronized (this) {
            String strA = a();
            boolean zA = am.a(strA, obj);
            boolean zA2 = am.a(strA, obj2);
            if (!zA && zA2) {
                this.a.set(obj);
                do {
                    dVarC = this.b.c();
                    com.google.android.libraries.navigation.internal.aeq.b bVar = dVarC.c;
                    if (bVar == null) {
                        bVar = com.google.android.libraries.navigation.internal.aeq.b.a;
                    }
                    String str = bVar.d;
                    if (!str.equals(obj2) && (!str.isEmpty() || obj2 != null)) {
                        break;
                    }
                    com.google.android.libraries.navigation.internal.aeq.b bVar2 = dVarC.c;
                    if (bVar2 == null) {
                        bVar2 = com.google.android.libraries.navigation.internal.aeq.b.a;
                    }
                    bb bbVar = (bb) bVar2.aH(5, null);
                    bbVar.x(bVar2);
                    com.google.android.libraries.navigation.internal.aeq.a aVar = (com.google.android.libraries.navigation.internal.aeq.a) bbVar;
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aeq.b bVar3 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.b;
                    bVar3.e = null;
                    bVar3.b &= -17;
                    if (obj == null) {
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        com.google.android.libraries.navigation.internal.aeq.b bVar4 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.b;
                        bVar4.b &= -3;
                        bVar4.d = com.google.android.libraries.navigation.internal.aeq.b.a.d;
                    } else {
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        com.google.android.libraries.navigation.internal.aeq.b bVar5 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.b;
                        bVar5.b |= 2;
                        bVar5.d = (String) obj;
                    }
                    bb bbVar2 = (bb) dVarC.aH(5, null);
                    bbVar2.x(dVarC);
                    cVar = (com.google.android.libraries.navigation.internal.aeq.c) bbVar2;
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    d dVar = (d) cVar.b;
                    com.google.android.libraries.navigation.internal.aeq.b bVar6 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.t();
                    bVar6.getClass();
                    dVar.c = bVar6;
                    dVar.b |= 1;
                } while (!this.b.d(an.j(dVarC), (d) cVar.t()));
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hj.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String a() throws cc {
        f fVar;
        String str = (String) this.a.get();
        if (am.a(str, "Needs to be loaded from perstistent storage.")) {
            com.google.android.libraries.navigation.internal.aeq.b bVar = this.b.c().c;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.aeq.b.a;
            }
            if ((bVar.b & 2) != 0) {
                str = bVar.d;
            } else {
                h hVar = bVar.e;
                if (hVar == null) {
                    hVar = h.a;
                }
                com.google.android.libraries.navigation.internal.aba.d dVar = hVar.b;
                if (dVar == null) {
                    dVar = com.google.android.libraries.navigation.internal.aba.d.a;
                }
                if (dVar.b.A()) {
                    fVar = f.a;
                } else {
                    try {
                        x xVar = dVar.b;
                        ar arVar = ar.a;
                        di diVar = di.a;
                        ar arVar2 = ar.a;
                        f fVar2 = f.a;
                        ac acVarK = xVar.k();
                        bi biVarU = fVar2.u();
                        try {
                            try {
                                try {
                                    dr drVarB = di.a.b(biVarU);
                                    drVarB.h(biVarU, ad.p(acVarK), arVar2);
                                    drVarB.f(biVarU);
                                    try {
                                        acVarK.z(0);
                                        bi.I(biVarU);
                                        fVar = (f) biVarU;
                                    } catch (cc e) {
                                        throw e;
                                    }
                                } catch (ee e2) {
                                    throw e2.a();
                                }
                            } catch (IOException e3) {
                                if (e3.getCause() instanceof cc) {
                                    throw ((cc) e3.getCause());
                                }
                                throw new cc(e3);
                            }
                        } catch (cc e4) {
                            if (e4.a) {
                                throw new cc(e4);
                            }
                            throw e4;
                        } catch (RuntimeException e5) {
                            if (e5.getCause() instanceof cc) {
                                throw ((cc) e5.getCause());
                            }
                            throw e5;
                        }
                    } catch (cc unused) {
                        fVar = f.a;
                    }
                }
                str = new com.google.android.libraries.navigation.internal.wv.a(fVar, hVar).a().c;
            }
            if (true == str.isEmpty()) {
                str = null;
            }
            this.a.set(str);
        }
        return str;
    }
}
