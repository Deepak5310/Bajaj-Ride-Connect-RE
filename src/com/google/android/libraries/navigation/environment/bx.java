package com.google.android.libraries.navigation.environment;

import android.app.Application;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bx implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public bx(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Application application = (Application) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        return new com.google.android.libraries.navigation.internal.xf.p(application, com.google.android.libraries.navigation.internal.zp.ax.c, ((com.google.android.libraries.navigation.internal.nh.h) this.b).a(), NavApiEnvironmentManager.getOrCreate(application).bz(), (com.google.android.libraries.navigation.internal.wx.c) this.c.a(), ((com.google.android.libraries.navigation.internal.nj.h) this.d).a());
    }
}
