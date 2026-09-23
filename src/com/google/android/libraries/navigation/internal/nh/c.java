package com.google.android.libraries.navigation.internal.nh;

import android.content.Context;
import com.google.android.libraries.navigation.internal.afk.w;
import com.google.android.libraries.navigation.internal.ky.l;
import com.google.android.libraries.navigation.internal.ky.r;
import com.google.android.libraries.navigation.internal.xd.j;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.afr.f {
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
        Context context = (Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        com.google.android.libraries.navigation.internal.kz.b bVar = (com.google.android.libraries.navigation.internal.kz.b) this.b.a();
        Object obj = ((com.google.android.libraries.navigation.internal.afr.g) this.d).a;
        w wVarB = j.b();
        r rVar = b.a;
        if (((Boolean) ((an) obj).e(false)).booleanValue()) {
            l lVarB = bVar.b(context, wVarB.o);
            lVarB.f = b.a;
            return lVarB.d();
        }
        l lVarA = bVar.a(context, wVarB.o);
        lVarA.f = b.a;
        return lVarA.d();
    }
}
