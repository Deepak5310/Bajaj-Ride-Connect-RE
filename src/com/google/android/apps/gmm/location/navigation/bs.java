package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class bs implements com.google.android.libraries.navigation.internal.rw.w, com.google.android.libraries.navigation.internal.rw.c, com.google.android.libraries.navigation.internal.rw.aa {
    final /* synthetic */ bu a;

    public bs(bu buVar) {
        this.a = buVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        SnappingTracerJni snappingTracerJni;
        if (z && (snappingTracerJni = this.a.i) != null) {
            snappingTracerJni.b(oVar.a.f().j, this.a.d.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.w
    public final void b(int i) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        SnappingTracerJni snappingTracerJni = this.a.i;
        if (snappingTracerJni != null) {
            boolean z = i == 2;
            long jA = this.a.d.a();
            if (snappingTracerJni.c()) {
                snappingTracerJni.nativeOnRerouteRequested(snappingTracerJni.c, z, jA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 298)).p("SnappingTracerJni called onRerouteRequested() when stopped");
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.c
    public final void i(com.google.android.libraries.navigation.internal.rw.p pVar, com.google.android.libraries.navigation.internal.rw.p pVar2) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        SnappingTracerJni snappingTracerJni = this.a.i;
        if (snappingTracerJni != null) {
            boolean z = !pVar2.equals(com.google.android.libraries.navigation.internal.rw.p.OFF);
            long jA = this.a.d.a();
            if (snappingTracerJni.c()) {
                snappingTracerJni.nativeOnIsNavigatingChanged(snappingTracerJni.c, z, jA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 295)).p("SnappingTracerJni called onIsNavigatingChanged() when stopped");
            }
        }
    }
}
