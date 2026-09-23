package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements bf {
    CameraPosition a;
    final /* synthetic */ LatLngBounds b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ u e;

    public f(u uVar, LatLngBounds latLngBounds, int i, int i2) {
        this.b = latLngBounds;
        this.c = i;
        this.d = i2;
        this.e = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        this.a = new CameraPosition(this.e.d.c(this.b).a(), (float) this.e.d.b(this.b, this.c, this.d, awVar.b()), 0.0f, 0.0f);
    }
}
