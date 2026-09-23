package com.google.android.apps.gmm.offline.tilefetcher;

import com.google.android.libraries.navigation.internal.yz.ez;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public f(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final TileSourcesProvider a() {
        SnaptileTileSourceFactory snaptileTileSourceFactory = (SnaptileTileSourceFactory) this.a.a();
        ez ezVar = new ez();
        ezVar.f(h.a, snaptileTileSourceFactory);
        return new TileSourcesProvider(ezVar.d());
    }
}
