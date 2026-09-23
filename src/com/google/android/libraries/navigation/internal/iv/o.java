package com.google.android.libraries.navigation.internal.iv;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public o(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        f fVarA = context instanceof com.google.android.libraries.navigation.internal.iw.a ? ((com.google.android.libraries.navigation.internal.iw.a) context).a() : n.B(context);
        com.google.android.libraries.navigation.internal.afr.j.d(fVarA);
        return fVarA;
    }
}
