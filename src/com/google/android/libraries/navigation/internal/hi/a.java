package com.google.android.libraries.navigation.internal.hi;

import android.app.Application;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.hh.d;
import com.google.android.libraries.navigation.internal.hh.i;
import com.google.android.libraries.navigation.internal.hh.j;
import com.google.android.libraries.navigation.internal.hy.o;
import com.google.android.libraries.navigation.internal.nj.h;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public a(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Application application = (Application) ((g) this.a).a;
        j jVar = (j) this.b.a();
        bn bnVarA = ((o) this.c).a();
        ((h) this.d).a();
        return new i(jVar, bnVarA, Long.toString(com.google.android.libraries.navigation.internal.je.a.a(application)), ((d) this.e).a());
    }
}
