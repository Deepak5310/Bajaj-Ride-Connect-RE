package com.google.android.libraries.navigation.internal.pu;

import android.content.Context;
import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public y(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        com.google.android.libraries.navigation.internal.kl.b bVar = (com.google.android.libraries.navigation.internal.kl.b) this.b.a();
        com.google.android.libraries.navigation.internal.ni.a aVar = (com.google.android.libraries.navigation.internal.ni.a) this.c.a();
        com.google.android.libraries.navigation.internal.om.p pVar = (com.google.android.libraries.navigation.internal.om.p) this.d.a();
        Resources resources = (Resources) this.e.a();
        Objects.requireNonNull(pVar);
        return new com.google.android.libraries.geo.mapcore.renderer.ax(context, bVar, aVar, new r(pVar), resources);
    }
}
