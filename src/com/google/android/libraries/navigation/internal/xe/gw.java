package com.google.android.libraries.navigation.internal.xe;

import android.os.Bundle;
import com.google.android.libraries.navigation.internal.adr.ii;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gw implements gv {
    private com.google.android.libraries.navigation.internal.ms.at a;
    private Boolean c = false;
    private final gl b = new gl();

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public gl a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public Boolean b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public void c(Bundle bundle) {
        f(Boolean.valueOf(bundle.getBoolean("TripProgressBarViewModelImpl.hasArrived")));
        gl glVar = this.b;
        if (bundle.containsKey("TripProgressBar.trafficData")) {
            try {
                byte[] byteArray = bundle.getByteArray("TripProgressBar.trafficData");
                com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(ii.a, byteArray, 0, byteArray.length, com.google.android.libraries.navigation.internal.ael.ar.b());
                com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
                glVar.a = (ii) biVarV;
            } catch (com.google.android.libraries.navigation.internal.ael.cc unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2007)).p("Could not parse stored traffic data.");
            }
        }
        glVar.b = bundle.getInt("TripProgressBar.totalDistance");
        glVar.c = bundle.getInt("TripProgressBar.currentRemainingDistance");
        glVar.d = bundle.getInt("TripProgressBar.distanceToNextDest");
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public void d(com.google.android.libraries.navigation.internal.ms.at atVar) {
        this.a = atVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public void e(Bundle bundle) {
        bundle.putBoolean("TripProgressBarViewModelImpl.hasArrived", this.c.booleanValue());
        gl glVar = this.b;
        bundle.putInt("TripProgressBar.totalDistance", glVar.b);
        bundle.putInt("TripProgressBar.currentRemainingDistance", glVar.c);
        bundle.putInt("TripProgressBar.distanceToNextDest", glVar.d);
        ii iiVar = glVar.a;
        if (iiVar != null) {
            bundle.putByteArray("TripProgressBar.trafficData", iiVar.m());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public void f(Boolean bool) {
        this.c = bool;
        com.google.android.libraries.navigation.internal.ms.at atVar = this.a;
        if (atVar != null) {
            atVar.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public void g(int i) {
        this.b.c = i;
        com.google.android.libraries.navigation.internal.ms.at atVar = this.a;
        if (atVar != null) {
            atVar.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xe.gv
    public void h(com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        if (bgVar != null) {
            gl glVar = this.b;
            glVar.a = bgVar.u;
            glVar.b = bgVar.J;
            glVar.d = bgVar.i();
        }
        com.google.android.libraries.navigation.internal.ms.at atVar = this.a;
        if (atVar != null) {
            atVar.a(this);
        }
    }
}
