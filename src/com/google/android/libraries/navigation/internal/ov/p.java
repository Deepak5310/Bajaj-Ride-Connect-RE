package com.google.android.libraries.navigation.internal.ov;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public p(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        return new com.google.android.libraries.navigation.internal.fw.z(com.google.android.libraries.navigation.internal.jb.b.b(), ((com.google.android.libraries.navigation.internal.jb.c) this.b.a()).d(), bw.a(new m(context)));
    }
}
