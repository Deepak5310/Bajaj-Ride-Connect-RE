package com.google.android.gms.maps;

import com.google.android.libraries.navigation.internal.ly.cc;
import com.google.android.libraries.navigation.internal.ly.cj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class as extends cc {
    final /* synthetic */ OnStreetViewPanoramaReadyCallback a;

    public as(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.a = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cd
    public final void a(cj cjVar) {
        this.a.onStreetViewPanoramaReady(new StreetViewPanorama(cjVar));
    }
}
