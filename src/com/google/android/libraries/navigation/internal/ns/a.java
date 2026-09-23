package com.google.android.libraries.navigation.internal.ns;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aaf.d;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.nj.b;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public a(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Object obj = ((g) this.d).a;
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.g) this.a).a();
        bn bnVarA2 = ((b) this.b).a();
        com.google.android.libraries.navigation.internal.aaf.b bVar = new com.google.android.libraries.navigation.internal.aaf.b();
        bVar.b = bnVarA2;
        bVar.a = bnVarA;
        bVar.c = this.c;
        bVar.d.k((Set) obj);
        ar.r(bVar.a, "Must set a lightweightExecutor");
        ar.r(bVar.b, "Must set a backgroundExecutor");
        ar.r(bVar.c, "Must set a cronetEngineProvider");
        return new d(bVar);
    }
}
