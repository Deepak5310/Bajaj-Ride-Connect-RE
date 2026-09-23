package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cl extends com.google.android.libraries.navigation.internal.ly.t {
    private final Cif a;
    private final ac b;

    public cl(ac acVar, Cif cif) {
        this.a = cif;
        this.b = acVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.u
    public final void a(CameraPosition cameraPosition) {
        this.a.a.setEnabled(cameraPosition.zoom < this.b.a(cameraPosition.target));
        this.a.b.setEnabled(cameraPosition.zoom > this.b.b());
    }
}
