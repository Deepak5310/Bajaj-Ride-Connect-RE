package com.google.android.libraries.navigation.internal.ta;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.sv.ak;
import com.google.android.libraries.navigation.internal.sv.aq;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;
    private final com.google.android.libraries.navigation.internal.agl.a k;
    private final com.google.android.libraries.navigation.internal.agl.a l;

    public l(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
        this.k = aVar11;
        this.l = aVar12;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.sp.b a() {
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.g) this.a).a();
        com.google.android.libraries.navigation.internal.hn.r rVar = (com.google.android.libraries.navigation.internal.hn.r) this.b.a();
        Set set = (Set) ((com.google.android.libraries.navigation.internal.afr.g) this.c).a;
        Set set2 = (Set) ((com.google.android.libraries.navigation.internal.afr.g) this.d).a;
        Object obj = ((com.google.android.libraries.navigation.internal.afr.g) this.f).a;
        ev evVarA = ((i) this.e).a();
        ak akVar = (ak) this.g.a();
        aq aqVar = (aq) this.h.a();
        com.google.android.libraries.navigation.internal.sv.g gVar = (com.google.android.libraries.navigation.internal.sv.g) this.i.a();
        com.google.android.libraries.navigation.internal.tr.a aVarA = ((com.google.android.libraries.navigation.internal.tr.b) this.j).a();
        com.google.android.libraries.navigation.internal.tc.j jVar = (com.google.android.libraries.navigation.internal.tc.j) this.k.a();
        com.google.android.libraries.navigation.internal.te.a aVar = (com.google.android.libraries.navigation.internal.te.a) this.l.a();
        eq eqVar = new eq();
        eqVar.h(gVar);
        eqVar.j(evVarA);
        eqVar.j(set);
        eqVar.h(akVar);
        eqVar.h(aqVar);
        eqVar.h(aVarA);
        eqVar.j(set2);
        return new ac(bnVarA, rVar, jVar, aVar, ev.o((Set) obj), eqVar.g());
    }
}
