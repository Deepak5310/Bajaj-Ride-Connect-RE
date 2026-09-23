package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bb extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public bb(int i, Class cls, aw awVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, awVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f == 0) {
            throw null;
        }
        ba baVar = ((aw) this.c).a;
        boolean z = ((com.google.android.libraries.navigation.internal.ds.c) aVar).a;
        baVar.d = z;
        av avVar = baVar.c;
        if (z) {
            ((com.google.android.libraries.navigation.internal.kk.k) avVar.a.a(com.google.android.libraries.navigation.internal.km.c.a)).a(au.a(1));
        } else {
            ((com.google.android.libraries.navigation.internal.kk.k) avVar.a.a(com.google.android.libraries.navigation.internal.km.c.a)).a(au.a(2));
        }
    }
}
