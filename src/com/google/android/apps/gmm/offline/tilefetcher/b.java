package com.google.android.apps.gmm.offline.tilefetcher;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final EndTileWorkScheduler a() {
        return new EndTileWorkScheduler(((com.google.android.libraries.navigation.internal.nj.b) this.a).a());
    }
}
