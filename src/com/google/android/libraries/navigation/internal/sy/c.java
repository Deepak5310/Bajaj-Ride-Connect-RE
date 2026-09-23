package com.google.android.libraries.navigation.internal.sy;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.hh.i;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public c(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        i iVar = (i) this.a.a();
        Context context = (Context) ((g) this.b).a;
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.c).a();
        return new b(iVar, context, bnVarA);
    }
}
