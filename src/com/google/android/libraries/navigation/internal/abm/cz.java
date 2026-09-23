package com.google.android.libraries.navigation.internal.abm;

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cz implements com.google.android.libraries.navigation.internal.abn.at {
    private static final String f = "cz";
    public final com.google.android.libraries.navigation.internal.abn.be a;
    public final com.google.android.libraries.navigation.internal.abf.z b;
    public final com.google.android.libraries.navigation.internal.abn.bl c;
    public es d;
    public boolean e;

    public cz(com.google.android.libraries.navigation.internal.abn.be beVar) {
        com.google.android.libraries.navigation.internal.abf.z zVar = com.google.android.libraries.navigation.internal.abf.z.a;
        this.e = false;
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "uiThreadWorldModelState");
        this.a = beVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "uiThreadChecker");
        this.b = zVar;
        this.c = null;
        this.d = null;
    }

    public static final LatLng e(com.google.android.libraries.navigation.internal.abn.aw awVar, double d, double d2) {
        com.google.android.libraries.navigation.internal.abf.ak akVarG = awVar.g();
        LatLng latLngE = awVar.e(((float) d) - (akVarG.getWidth() / 2.0f), (((float) d2) - (akVarG.getHeight() / 2.0f)) - 70.0f, false);
        if (latLngE != null || !com.google.android.libraries.navigation.internal.abf.p.f(f, 3)) {
            return latLngE;
        }
        awVar.toString();
        return null;
    }

    private final void f(es esVar, double d, double d2) {
        cx cxVar = new cx(this, d, d2);
        this.c.d(cxVar);
        LatLng latLng = cxVar.a;
        if (latLng != null) {
            esVar.U(latLng);
        }
    }

    public final void a(es esVar, double d, double d2) {
        com.google.android.libraries.navigation.internal.abn.be beVar = this.a;
        if (beVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.abf.ak akVarK = beVar.k();
        LatLng latLngH = beVar.h(((float) d) - (akVarK.getWidth() / 2.0f), (((float) d2) - (akVarK.getHeight() / 2.0f)) - 70.0f, false);
        if (latLngH != null) {
            esVar.U(latLngH);
        } else if (com.google.android.libraries.navigation.internal.abf.p.f(f, 3)) {
            String.valueOf(this.a);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abn.at
    public final boolean b(double d, double d2) {
        this.b.a();
        if (this.d == null) {
            return false;
        }
        if (this.e) {
            if (com.google.android.libraries.navigation.internal.afu.d.j()) {
                f(this.d, d, d2);
            } else {
                a(this.d, d, d2);
            }
        }
        es esVar = this.d;
        esVar.b.e(esVar);
        this.d = null;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.at
    public final boolean c(double d, double d2) {
        this.b.a();
        if (this.d == null) {
            return false;
        }
        this.e = true;
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            f(this.d, d, d2);
        } else {
            a(this.d, d, d2);
        }
        es esVar = this.d;
        com.google.android.libraries.navigation.internal.ly.bf bfVar = esVar.b.f;
        if (bfVar != null) {
            try {
                ((com.google.android.gms.maps.a) bfVar).a.onMarkerDrag(new Marker(esVar));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.at
    public final void d() {
        this.b.a();
        es esVar = this.d;
        if (esVar == null) {
            return;
        }
        esVar.b.e(esVar);
        this.d = null;
    }

    public cz(com.google.android.libraries.navigation.internal.abn.bl blVar) {
        this.e = false;
        this.c = blVar;
        this.a = null;
        this.b = com.google.android.libraries.navigation.internal.abf.z.a;
        this.d = null;
    }
}
