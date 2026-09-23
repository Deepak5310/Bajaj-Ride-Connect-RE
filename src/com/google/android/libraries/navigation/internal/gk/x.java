package com.google.android.libraries.navigation.internal.gk;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public x(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        com.google.android.libraries.navigation.internal.agl.a aVar = this.c;
        Object objA = this.b.a();
        com.google.android.libraries.navigation.internal.mj.a aVar2 = (com.google.android.libraries.navigation.internal.mj.a) aVar.a();
        return new e((ConnectivityManager) context.getSystemService("connectivity"), (s) objA, aVar2);
    }
}
