package com.google.android.gms.maps;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class s extends com.google.android.libraries.navigation.internal.ly.t {
    final /* synthetic */ GoogleMap.OnCameraChangeListener a;

    public s(GoogleMap.OnCameraChangeListener onCameraChangeListener) {
        this.a = onCameraChangeListener;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.u
    public final void a(CameraPosition cameraPosition) {
        this.a.onCameraChange(cameraPosition);
    }
}
