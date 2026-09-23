package com.google.android.libraries.navigation.internal.abm;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bu implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bu(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context baseContext = ((com.google.android.libraries.navigation.internal.abh.be) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a).a;
        while (baseContext instanceof ContextWrapper) {
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        Context applicationContext = baseContext.getApplicationContext();
        com.google.android.libraries.navigation.internal.afr.j.d(applicationContext);
        return applicationContext;
    }
}
