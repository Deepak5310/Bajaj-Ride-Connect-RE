package com.google.android.apps.gmm.offline.tilefetcher;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public i(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.apps.gmm.offline.routing.a aVar = (com.google.android.apps.gmm.offline.routing.a) this.a.a();
        EndTileWorkScheduler endTileWorkSchedulerA = ((b) this.b).a();
        int i = h.b;
        return new SnaptileTileSourceFactory(new g(aVar), endTileWorkSchedulerA, h.a);
    }
}
