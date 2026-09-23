package com.google.android.libraries.navigation.internal.abm;

import android.os.RemoteException;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dn implements com.google.android.libraries.navigation.internal.pq.a {
    private final com.google.android.libraries.navigation.internal.abh.cy a;
    private final dm b;

    public dn(com.google.android.libraries.navigation.internal.abh.cy cyVar) {
        dm dmVar = dm.a;
        this.a = cyVar;
        this.b = dmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void f() {
        final com.google.android.libraries.navigation.internal.abh.cy cyVar = this.a;
        synchronized (cyVar) {
            if (cyVar.e != null) {
                cyVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.cw
                    @Override // java.lang.Runnable
                    public final void run() {
                        cy cyVar2 = cyVar;
                        com.google.android.libraries.navigation.internal.ly.aj ajVar = cyVar2.d;
                        if (ajVar != null) {
                            try {
                                ((com.google.android.gms.maps.k) ajVar).a.onIndoorBuildingFocused();
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                        dn dnVar = cyVar2.c;
                        if (dnVar != null) {
                            dnVar.a();
                        }
                    }
                });
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void g(com.google.android.libraries.navigation.internal.pt.a aVar) {
        final ag agVar = new ag(aVar);
        final com.google.android.libraries.navigation.internal.abh.cy cyVar = this.a;
        synchronized (cyVar) {
            if (cyVar.e != null) {
                cyVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.cv
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.libraries.navigation.internal.abm.aj ajVar;
                        final com.google.android.libraries.navigation.internal.abm.ag agVar2 = agVar;
                        cy cyVar2 = cyVar;
                        if (cyVar2.d != null) {
                            synchronized (cyVar2) {
                                ajVar = cyVar2.e;
                            }
                            try {
                                ((com.google.android.gms.maps.k) cyVar2.d).a.onIndoorLevelActivated(new IndoorBuilding(new ct(ajVar, agVar2, cyVar2.b)));
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                        final dn dnVar = cyVar2.c;
                        if (dnVar != null) {
                            dnVar.post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.dg
                                @Override // java.lang.Runnable
                                public final void run() {
                                    dn dnVar2 = dnVar;
                                    com.google.android.libraries.navigation.internal.abm.aj ajVar2 = dnVar2.c;
                                    if (ajVar2 != null) {
                                        com.google.android.libraries.navigation.internal.abm.ag agVar3 = agVar2;
                                        int iB = ajVar2.b(agVar3);
                                        com.google.android.libraries.navigation.internal.abf.p.f("INDOOR", 3);
                                        if (dn.f(dnVar2.b, agVar3)) {
                                            dnVar2.e(dnVar2.b, iB);
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void h() {
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void i() {
    }
}
