package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ch implements com.google.android.libraries.navigation.internal.ly.v {
    final /* synthetic */ cm a;
    private LatLngBounds b;
    private Float c;
    private Float d;

    public ch(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.v
    public final void a() {
        cm cmVar = this.a;
        this.b = cmVar.t;
        this.c = cmVar.r;
        this.d = cmVar.s;
        cmVar.t = null;
        cmVar.b.z(null);
        this.a.A();
        com.google.android.libraries.navigation.internal.ly.v vVar = this.a.u;
        if (vVar != null) {
            try {
                ((com.google.android.gms.maps.q) vVar).a.onCameraStartedFollowingLocation();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.v
    public final void b() {
        LatLngBounds latLngBounds = this.b;
        if (latLngBounds != null) {
            cm cmVar = this.a;
            cmVar.t = latLngBounds;
            cmVar.b.z(latLngBounds);
        }
        Float f = this.c;
        if (f != null) {
            this.a.aS(f.floatValue());
        }
        Float f2 = this.d;
        if (f2 != null) {
            this.a.aR(f2.floatValue());
        }
        com.google.android.libraries.navigation.internal.ly.v vVar = this.a.u;
        if (vVar != null) {
            try {
                ((com.google.android.gms.maps.q) vVar).a.onCameraStoppedFollowingLocation();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }
}
