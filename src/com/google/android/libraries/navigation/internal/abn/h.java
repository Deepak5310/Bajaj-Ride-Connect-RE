package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements bf {
    final /* synthetic */ com.google.android.libraries.navigation.internal.abf.ak a;
    final /* synthetic */ int b;
    final /* synthetic */ LatLngBounds c;
    final /* synthetic */ int d;
    final /* synthetic */ u e;

    public h(u uVar, com.google.android.libraries.navigation.internal.abf.ak akVar, int i, LatLngBounds latLngBounds, int i2) {
        this.a = akVar;
        this.b = i;
        this.c = latLngBounds;
        this.d = i2;
        this.e = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        boolean z = true;
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.v vVar = (com.google.android.libraries.navigation.internal.abf.v) awVar.f(this.a);
        int i = vVar.b;
        int i2 = this.b;
        if (i2 >= i / 2 && i2 >= vVar.a / 2) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.abf.t.a(z, "Additional padding must be less than half the existing padded map view width or height: " + i2 + " vs " + vVar.a + "x" + i);
        this.e.C(awVar, "CAMERA_UPDATE_NEW_LATLNG_BOUNDS", this.e.z(this.c, vVar.a, vVar.b, this.b), this.d, 3);
    }
}
