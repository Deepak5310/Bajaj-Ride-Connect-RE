package com.google.android.libraries.navigation.internal.ip;

import android.content.Context;
import com.google.android.libraries.navigation.internal.afr.e;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.iv.ac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public d(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        return new c(context, context.getResources().getDisplayMetrics(), e.c(this.b), e.c(this.c), e.c(this.d), new ac(new com.google.android.libraries.navigation.internal.iv.a(context)));
    }
}
