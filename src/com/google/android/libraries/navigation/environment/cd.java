package com.google.android.libraries.navigation.environment;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cd implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public cd(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Resources resources = ((Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a).getResources();
        com.google.android.libraries.navigation.internal.afr.j.d(resources);
        return resources;
    }
}
