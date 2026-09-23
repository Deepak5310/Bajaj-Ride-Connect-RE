package com.google.android.libraries.navigation.environment;

import android.content.Context;
import com.google.android.libraries.navigation.internal.abh.id;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bj implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public bj(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        com.google.android.libraries.navigation.internal.wd.g gVar = (com.google.android.libraries.navigation.internal.wd.g) this.b.a();
        com.google.android.libraries.navigation.internal.wx.c cVar = (com.google.android.libraries.navigation.internal.wx.c) this.c.a();
        id idVar = new id(0);
        com.google.android.libraries.navigation.internal.abh.i iVar = com.google.android.libraries.navigation.internal.abh.i.a;
        ExecutorService executorService = com.google.android.libraries.navigation.internal.abf.ah.a;
        return com.google.android.libraries.navigation.internal.abh.m.c(context, idVar, null, iVar, gVar, cVar);
    }
}
