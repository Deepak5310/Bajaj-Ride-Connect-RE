package com.google.android.libraries.navigation.internal.bm;

import android.app.Application;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public i(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        return new h((Application) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a, ((com.google.android.libraries.navigation.internal.nj.h) this.b).a(), (com.google.android.libraries.navigation.internal.qy.h) this.c.a());
    }
}
