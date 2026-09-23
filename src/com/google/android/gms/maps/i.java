package com.google.android.gms.maps;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class i extends com.google.android.libraries.navigation.internal.ly.aw {
    final /* synthetic */ GoogleMap.OnMapLoadedCallback a;

    public i(GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.a = onMapLoadedCallback;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.ax
    public final void a() {
        this.a.onMapLoaded();
    }
}
