package com.google.android.libraries.navigation.internal.fw;

import android.app.Application;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.Random;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public s(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Application application = (Application) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        bn bnVarA = ((com.google.android.libraries.navigation.internal.hy.y) this.b).a();
        String packageName = application.getPackageName();
        int i = com.google.android.libraries.navigation.internal.fx.i.s;
        com.google.android.libraries.navigation.internal.mk.b bVar = new com.google.android.libraries.navigation.internal.mk.b();
        Random random = new Random();
        String strC = com.google.android.libraries.navigation.internal.fx.j.a.c(application, packageName);
        return an.j(new com.google.android.libraries.navigation.internal.fx.i(application, strC, bVar, random, bnVarA, new com.google.android.libraries.navigation.internal.fx.k(application), new com.google.android.libraries.navigation.internal.fx.e(application, strC, packageName, bnVarA)));
    }
}
