package com.google.android.libraries.navigation.internal.abm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bv(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        String packageName = ((com.google.android.libraries.navigation.internal.abh.be) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a).a.getPackageName();
        com.google.android.libraries.navigation.internal.afr.j.d(packageName);
        return packageName;
    }
}
