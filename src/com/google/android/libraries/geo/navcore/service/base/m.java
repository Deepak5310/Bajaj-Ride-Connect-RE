package com.google.android.libraries.geo.navcore.service.base;

import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.au;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public m(int i, Class cls, k kVar, ap apVar, Executor executor) {
        super(cls, kVar, apVar, executor);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            k kVar = (k) this.c;
            com.google.android.libraries.navigation.internal.sr.q qVar = (com.google.android.libraries.navigation.internal.sr.q) aVar;
            ap.NAVIGATION_INTERNAL.f();
            if (kVar.i == com.google.android.libraries.navigation.internal.si.e.FREE_NAV) {
                jg jgVar = qVar.c;
                com.google.android.libraries.navigation.internal.st.a aVar2 = (com.google.android.libraries.navigation.internal.st.a) kVar.e.a();
                ck ckVar = qVar.a;
                au auVarE = aVar2.e();
                if (auVarE.isEmpty()) {
                    bh bhVar = qVar.b;
                    throw null;
                }
                com.google.android.libraries.navigation.internal.sc.f fVar = (com.google.android.libraries.navigation.internal.sc.f) auVarE.a();
                if (fVar == null) {
                    fVar = (com.google.android.libraries.navigation.internal.sc.f) auVarE.get(0);
                }
                kVar.e(fVar, auVarE, null, null);
                return;
            }
            return;
        }
        if (i != 1) {
            k kVar2 = (k) this.c;
            ap.NAVIGATION_INTERNAL.f();
            if (kVar2.i != com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV) {
                return;
            }
            if (kVar2.d.i() != null) {
                al alVarI = kVar2.d.i();
                ar.q(alVarI);
                kVar2.j = alVarI;
            }
            kVar2.d(kVar2.j);
            return;
        }
        k kVar3 = (k) this.c;
        ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.db.r rVarD = ((com.google.android.libraries.navigation.internal.db.s) aVar).d();
        if (rVarD != null) {
            kVar3.k = rVarD;
            if (kVar3.i != null) {
                com.google.android.libraries.navigation.internal.si.e eVar = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
                int iOrdinal = kVar3.i.ordinal();
                if (iOrdinal == 0) {
                    ((com.google.android.libraries.navigation.internal.st.a) kVar3.e.a()).c(rVarD);
                } else {
                    if (iOrdinal != 1) {
                        return;
                    }
                    kVar3.c.a(rVarD);
                }
            }
        }
    }
}
