package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements bf {
    final /* synthetic */ com.google.android.libraries.navigation.internal.abf.v a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ LatLngBounds e;
    final /* synthetic */ int f;
    final /* synthetic */ u g;

    public i(u uVar, com.google.android.libraries.navigation.internal.abf.v vVar, int i, int i2, int i3, LatLngBounds latLngBounds, int i4) {
        this.a = vVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = latLngBounds;
        this.f = i4;
        this.g = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        boolean z = true;
        com.google.android.libraries.navigation.internal.abf.t.b(!this.g.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.ak akVarF = awVar.f(this.a);
        if (com.google.android.libraries.navigation.internal.afu.d.a.a().y()) {
            int i = this.b;
            int i2 = this.c;
            int i3 = i2 + i2;
            com.google.android.libraries.navigation.internal.abf.t.b(((double) (i - i3)) > 0.0d && ((double) (this.d - i3)) > 0.0d, "Error using newLatLngBounds(LatLngBounds, int, int, int): View size is too small after padding is applied.");
        } else {
            int i4 = this.c;
            com.google.android.libraries.navigation.internal.abf.v vVar = (com.google.android.libraries.navigation.internal.abf.v) akVarF;
            int i5 = vVar.b;
            if (i4 >= i5 / 2 && i4 >= vVar.a / 2) {
                z = false;
            }
            com.google.android.libraries.navigation.internal.abf.t.a(z, "Additional camera padding must be less than half of the existing padded map view width or height: " + i4 + " vs " + vVar.a + "x" + i5);
        }
        com.google.android.libraries.navigation.internal.abf.v vVar2 = (com.google.android.libraries.navigation.internal.abf.v) akVarF;
        this.g.C(awVar, "CAMERA_UPDATE_NEW_LATLNG_BOUNDS_WITH_DIMENSIONS", this.g.z(this.e, vVar2.a, vVar2.b, this.c), this.f, 3);
    }
}
