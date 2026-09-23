package com.google.android.libraries.navigation.internal.gk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public t(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.yx.an a() {
        return !((com.google.android.libraries.navigation.internal.nr.f) this.a.a()).a.optBoolean("migrate_sessions_early_v2", false) ? com.google.android.libraries.navigation.internal.yx.a.a : com.google.android.libraries.navigation.internal.yx.an.j(((an) this.b).a());
    }
}
