package com.google.android.libraries.navigation.internal.ta;

import android.app.Application;
import android.content.Intent;
import com.google.android.libraries.geo.navcore.service.base.NavigationService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public s(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Intent intentPutExtra = new Intent((Application) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a, (Class<?>) NavigationService.class).putExtra("abortcurrentsession", true);
        com.google.android.libraries.navigation.internal.afr.j.d(intentPutExtra);
        return intentPutExtra;
    }
}
