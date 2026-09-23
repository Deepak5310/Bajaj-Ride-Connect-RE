package com.google.android.libraries.navigation.internal.abm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;

    public az(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8) {
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
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.oo.e eVar = (com.google.android.libraries.navigation.internal.oo.e) this.a.a();
        com.google.android.libraries.navigation.internal.abh.be beVar = (com.google.android.libraries.navigation.internal.abh.be) ((com.google.android.libraries.navigation.internal.afr.g) this.b).a;
        com.google.android.libraries.navigation.internal.pn.j jVar = (com.google.android.libraries.navigation.internal.pn.j) ((com.google.android.libraries.navigation.internal.afr.g) this.c).a;
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) ((com.google.android.libraries.navigation.internal.afr.g) this.d).a;
        String str = (String) ((com.google.android.libraries.navigation.internal.afr.g) this.e).a;
        Integer num = (Integer) ((com.google.android.libraries.navigation.internal.afr.g) this.f).a;
        boolean zBooleanValue = ((Boolean) ((com.google.android.libraries.navigation.internal.afr.g) this.g).a).booleanValue();
        boolean zBooleanValue2 = ((Boolean) ((com.google.android.libraries.navigation.internal.afr.g) this.h).a).booleanValue();
        com.google.android.libraries.navigation.internal.ob.l lVarG = com.google.android.libraries.navigation.internal.ob.n.g();
        if (zBooleanValue2) {
            lVarG.d();
        }
        com.google.android.libraries.navigation.internal.pu.m mVarC = eVar.c();
        mVarC.a = beVar.i();
        mVarC.b = lVarG.b();
        mVarC.c = com.google.android.libraries.navigation.internal.pz.c.PHONES_AND_TABLETS;
        mVarC.e = jVar;
        mVarC.h = str;
        mVarC.f = zBooleanValue;
        if (num != null) {
            mVarC.i = num;
        }
        final com.google.android.libraries.navigation.internal.vu.t tVar = (com.google.android.libraries.navigation.internal.vu.t) anVar.f();
        if (tVar != null) {
            mVarC.d = new com.google.android.libraries.navigation.internal.oo.c() { // from class: com.google.android.libraries.navigation.internal.abm.au
                @Override // com.google.android.libraries.navigation.internal.oo.c
                public final com.google.android.libraries.navigation.internal.pn.l a(com.google.android.libraries.navigation.internal.pi.s sVar) {
                    return com.google.android.libraries.navigation.internal.vu.t.a(sVar);
                }
            };
        }
        com.google.android.libraries.navigation.internal.oo.b bVarA = mVarC.a();
        com.google.android.libraries.navigation.internal.afr.j.d(bVarA);
        return bVarA;
    }
}
