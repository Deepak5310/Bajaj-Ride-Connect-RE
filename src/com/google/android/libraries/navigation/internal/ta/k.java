package com.google.android.libraries.navigation.internal.ta;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;

    public k(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.sp.b a() {
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.g) this.a).a();
        com.google.android.libraries.navigation.internal.hn.r rVar = (com.google.android.libraries.navigation.internal.hn.r) this.b.a();
        Set set = (Set) ((com.google.android.libraries.navigation.internal.afr.g) this.c).a;
        Object obj = ((com.google.android.libraries.navigation.internal.afr.g) this.e).a;
        ev evVarA = ((i) this.d).a();
        com.google.android.libraries.navigation.internal.st.a aVar = (com.google.android.libraries.navigation.internal.st.a) this.f.a();
        com.google.android.libraries.navigation.internal.tc.j jVar = (com.google.android.libraries.navigation.internal.tc.j) this.g.a();
        com.google.android.libraries.navigation.internal.te.a aVar2 = (com.google.android.libraries.navigation.internal.te.a) this.h.a();
        eq eqVar = new eq();
        eqVar.j(evVarA);
        eqVar.j(set);
        eqVar.h(aVar);
        return new ac(bnVarA, rVar, jVar, aVar2, ev.o((Set) obj), eqVar.g());
    }
}
