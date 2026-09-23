package com.google.android.libraries.navigation.internal.cz;

import com.google.android.apps.gmm.location.navigation.bt;
import com.google.android.apps.gmm.location.navigation.bu;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.p;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.rw.q;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        r rVar = (r) this.a.a();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.b.a();
        Set<an> setA = ((p) this.c).a();
        com.google.android.libraries.navigation.internal.rw.f fVar = (com.google.android.libraries.navigation.internal.rw.f) this.d.a();
        q qVar = (q) this.e.a();
        bn bnVarA = ((com.google.android.libraries.navigation.internal.hy.r) this.f).a();
        float fMin = Math.min(1.0E-4f, ((fs) rVar.b()).O);
        float f = ((fs) rVar.b()).N;
        HashSet hashSet = new HashSet();
        for (an anVar : setA) {
            if (anVar.g()) {
                hashSet.add((bt) anVar.c());
            }
        }
        return (hashSet.isEmpty() || (f == 0.0f && fMin == 0.0f)) ? com.google.android.libraries.navigation.internal.yx.a.a : an.j(new bu(f, fMin, new a(hashSet), aVar.f().toEpochMilli(), aVar, fVar, qVar, bnVarA));
    }
}
