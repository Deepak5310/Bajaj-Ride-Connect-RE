package com.google.android.libraries.navigation.internal.abm;

import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao implements com.google.android.libraries.navigation.internal.ol.y {
    private final ap a;

    public ao(ap apVar) {
        this.a = apVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.y
    public final void a(com.google.android.libraries.navigation.internal.ol.at atVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(atVar, "pickObject");
        com.google.android.libraries.navigation.internal.abf.s.k(xVar, "pickLocation");
        com.google.android.libraries.navigation.internal.ael.cy cyVarN = atVar.b().n();
        if (cyVarN instanceof ef) {
            ef efVar = (ef) cyVarN;
            com.google.android.libraries.navigation.internal.afu.d.a.a().P();
            ap apVar = this.a;
            apVar.a.a();
            try {
                if (apVar.h != null) {
                    com.google.android.libraries.navigation.internal.abf.s.k(efVar, "labelRenderOp");
                    com.google.android.libraries.navigation.internal.abf.s.k(xVar, FirebaseAnalytics.Param.LOCATION);
                    com.google.android.libraries.navigation.internal.adg.cx cxVarA = com.google.android.libraries.navigation.internal.rp.c.a(efVar);
                    PointOfInterest pointOfInterest = null;
                    if (!cxVarA.equals(com.google.android.libraries.navigation.internal.adg.bj.V.b)) {
                        int i = cxVarA.b;
                        if ((i & 16) != 0 && (i & 32) != 0) {
                            com.google.android.libraries.navigation.internal.aew.e eVar = (com.google.android.libraries.navigation.internal.aew.e) com.google.android.libraries.navigation.internal.aew.f.a.q();
                            com.google.android.libraries.navigation.internal.aax.a aVar = (com.google.android.libraries.navigation.internal.aax.a) com.google.android.libraries.navigation.internal.aax.b.a.q();
                            long j = cxVarA.f;
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aax.b bVar = (com.google.android.libraries.navigation.internal.aax.b) aVar.b;
                            bVar.b |= 1;
                            bVar.c = j;
                            long j2 = cxVarA.g;
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aax.b bVar2 = (com.google.android.libraries.navigation.internal.aax.b) aVar.b;
                            bVar2.b |= 2;
                            bVar2.d = j2;
                            com.google.android.libraries.navigation.internal.aax.b bVar3 = (com.google.android.libraries.navigation.internal.aax.b) aVar.t();
                            if (!eVar.b.H()) {
                                eVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aew.f fVar = (com.google.android.libraries.navigation.internal.aew.f) eVar.b;
                            bVar3.getClass();
                            fVar.c = bVar3;
                            fVar.b |= 1;
                            com.google.android.libraries.navigation.internal.aew.f fVar2 = (com.google.android.libraries.navigation.internal.aew.f) eVar.t();
                            byte[] bArrM = fVar2.m();
                            com.google.android.libraries.navigation.internal.aew.e eVar2 = (com.google.android.libraries.navigation.internal.aew.e) com.google.android.libraries.navigation.internal.aew.f.a.q();
                            if ((fVar2.b & 1) != 0) {
                                com.google.android.libraries.navigation.internal.aax.b bVar4 = fVar2.c;
                                if (bVar4 == null) {
                                    bVar4 = com.google.android.libraries.navigation.internal.aax.b.a;
                                }
                                if (!eVar2.b.H()) {
                                    eVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.aew.f fVar3 = (com.google.android.libraries.navigation.internal.aew.f) eVar2.b;
                                bVar4.getClass();
                                fVar3.c = bVar4;
                                fVar3.b |= 1;
                            }
                            String str = fVar2.d;
                            if (!str.isEmpty()) {
                                if (!eVar2.b.H()) {
                                    eVar2.v();
                                }
                                com.google.android.libraries.navigation.internal.aew.f fVar4 = (com.google.android.libraries.navigation.internal.aew.f) eVar2.b;
                                str.getClass();
                                fVar4.b |= 2;
                                fVar4.d = str;
                            }
                            if (!Arrays.equals(((com.google.android.libraries.navigation.internal.aew.f) eVar2.t()).m(), bArrM)) {
                                throw new IllegalArgumentException("The place id is not normalized");
                            }
                            pointOfInterest = new PointOfInterest(f.d(xVar.t()), Base64.encodeToString(bArrM, 11), com.google.android.libraries.navigation.internal.rp.c.c(efVar));
                        }
                    }
                    if (pointOfInterest != null) {
                        try {
                            ((com.google.android.gms.maps.p) apVar.h).a.onPoiClick(pointOfInterest);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                }
                apVar.c.c();
            } catch (Throwable th) {
                apVar.c.c();
                throw th;
            }
        }
        this.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.y
    public final void b(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a.a(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.y
    public final void c(com.google.android.libraries.navigation.internal.oe.x xVar) {
        ap apVar = this.a;
        apVar.a.a();
        com.google.android.libraries.navigation.internal.abf.s.k(xVar, "point");
        LatLng latLngD = f.d(xVar.t());
        apVar.b.k();
        try {
            com.google.android.libraries.navigation.internal.ly.av avVar = apVar.f;
            if (avVar != null) {
                try {
                    avVar.a(latLngD);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            apVar.c.c();
            this.a.b();
        } catch (Throwable th) {
            apVar.c.c();
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.y
    public final void d(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a.a(xVar);
    }
}
