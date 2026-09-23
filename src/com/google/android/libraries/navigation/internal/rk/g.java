package com.google.android.libraries.navigation.internal.rk;

import com.google.android.libraries.geo.mapcore.internal.model.cf;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.adi.aj;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.oa.k;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.aq;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.qd.w;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.ou.c {
    private final com.google.android.libraries.navigation.internal.afo.a a;
    private final AtomicLong b = new AtomicLong(0);

    public g(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x018a  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f0  */
    @Override // com.google.android.libraries.navigation.internal.ou.c
    public final com.google.android.libraries.navigation.internal.ou.b a(com.google.android.libraries.navigation.internal.adn.b bVar, com.google.android.libraries.navigation.internal.adf.b bVar2) {
        w wVarB;
        int iN;
        w wVarA;
        f fVar = new f(this.a, new com.google.android.libraries.navigation.internal.ou.a(this.b.getAndIncrement()));
        an anVarB = an.b(bVar.c);
        ar.q(anVarB);
        fVar.c = anVarB;
        com.google.android.libraries.navigation.internal.ob.h hVarA = com.google.android.libraries.navigation.internal.ob.h.a(anVarB);
        if (hVarA != null) {
            ((k) fVar.a.a()).x(hVarA, true);
        } else if (f.c(anVarB)) {
            ((k) fVar.a.a()).b().j(anVarB, true);
            com.google.android.libraries.navigation.internal.oa.e eVarB = ((k) fVar.a.a()).b();
            cg cgVarB = f.b(bVar2);
            fk fkVar = (fk) eVarB;
            boolean zC = fkVar.al.c(anVarB);
            if (anVarB == an.GMM_BASEMAP_PHOTOS && fkVar.al.d(fkVar.W.get())) {
                zC = false;
            }
            synchronized (fkVar.O) {
                if (zC) {
                    if (((fk) eVarB).O.containsKey(anVarB)) {
                        cg cgVarZ = cgVarB.z(((fk) eVarB).b());
                        if (!((w) ((fk) eVarB).O.get(anVarB)).e.equals(cgVarZ)) {
                            if (((fk) eVarB).E == null) {
                                ((fk) eVarB).E = ((fk) eVarB).af.c();
                            }
                            ap apVarC = ((fk) eVarB).s.c(anVarB, ((fk) eVarB).E.c + cgVarB.hashCode());
                            synchronized (((fk) eVarB).P) {
                                wVarA = anVarB == an.EVCS ? ((fk) eVarB).r.a(apVarC, cgVarZ, ((com.google.android.libraries.navigation.internal.po.g) ((fk) eVarB).Q).a) : ((fk) eVarB).r.b(apVarC, cgVarZ, ((com.google.android.libraries.navigation.internal.po.g) ((fk) eVarB).Q).a, false);
                            }
                            ((fk) eVarB).U.p((com.google.android.libraries.navigation.internal.qd.d) ((fk) eVarB).O.get(anVarB), wVarA, true);
                            ((fk) eVarB).O.put(anVarB, wVarA);
                        }
                    }
                }
            }
        } else if (anVarB == an.GMM_INDOOR) {
            ((k) fVar.a.a()).b().f();
        } else {
            String str = bVar.e;
            String str2 = bVar.d;
            an anVarB2 = an.b(bVar.c);
            ar.q(anVarB2);
            ap apVar = new ap(str, str2, anVarB2);
            cg cgVarB2 = f.b(bVar2);
            an anVarB3 = an.b(bVar.c);
            ar.q(anVarB3);
            int iOrdinal = anVarB3.ordinal();
            if (iOrdinal != 11) {
                wVarB = null;
                if (iOrdinal == 24) {
                    aj ajVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) cgVarB2).k;
                    if (ajVar != null) {
                        k kVar = (k) fVar.a.a();
                        aq aqVar = kVar.b;
                        an anVar = an.GMM_MAJOR_EVENT;
                        if (ajVar.H()) {
                            iN = ajVar.n();
                        } else {
                            iN = ajVar.ak;
                            if (iN == 0) {
                                iN = ajVar.n();
                                ajVar.ak = iN;
                            }
                        }
                        ap apVarC2 = aqVar.c(anVar, String.valueOf(iN));
                        cf cfVarX = cg.x();
                        ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).j = ajVar;
                        wVarB = kVar.f().b(apVarC2, cfVarX.a().z(kVar.b().b()), kVar.g(), false);
                    }
                } else if (iOrdinal != 26) {
                    if (iOrdinal != 28 && iOrdinal != 46 && iOrdinal != 47) {
                        switch (iOrdinal) {
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                                wVarB = ((k) fVar.a.a()).e(apVar, cgVarB2, bVar.f, bVar.g);
                                break;
                        }
                    } else {
                        k kVar2 = (k) fVar.a.a();
                        wVarB = kVar2.f().b(apVar, cgVarB2.z(kVar2.b().b()), kVar2.g(), false);
                    }
                } else {
                    wVarB = ((k) fVar.a.a()).e(apVar, cgVarB2, bVar.f, bVar.g);
                }
            } else {
                k kVar3 = (k) fVar.a.a();
                wVarB = kVar3.f().b(apVar, cgVarB2.z(kVar3.b().b()), kVar3.g(), false);
            }
            if (wVarB != null) {
                ((k) fVar.a.a()).H("OverlayId:" + ((com.google.android.libraries.navigation.internal.ou.a) fVar.b).a, wVarB);
            }
        }
        return fVar;
    }
}
