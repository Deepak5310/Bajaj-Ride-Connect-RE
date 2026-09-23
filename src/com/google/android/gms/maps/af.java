package com.google.android.gms.maps;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class af extends com.google.android.libraries.navigation.internal.ly.ba {
    final /* synthetic */ OnMapReadyCallback a;

    public af(OnMapReadyCallback onMapReadyCallback) {
        this.a = onMapReadyCallback;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.bb
    public final void a(com.google.android.libraries.navigation.internal.ly.k kVar) {
        this.a.onMapReady(new GoogleMap(kVar));
    }
}
