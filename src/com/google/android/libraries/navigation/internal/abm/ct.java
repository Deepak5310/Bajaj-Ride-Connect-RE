package com.google.android.libraries.navigation.internal.abm;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ct implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public ct(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        return new com.google.android.libraries.navigation.internal.fw.z(com.google.android.libraries.navigation.internal.jb.b.b(), ((com.google.android.libraries.navigation.internal.jb.c) this.b.a()).d(), com.google.android.libraries.navigation.internal.yx.bw.a(new bp(context)));
    }
}
