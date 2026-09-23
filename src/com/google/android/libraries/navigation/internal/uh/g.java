package com.google.android.libraries.navigation.internal.uh;

import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public g(int i, Class cls, f fVar, ap apVar) {
        super(cls, fVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f != 0) {
            f fVar = (f) this.c;
            if (f.d(fVar.a)) {
                e eVar = fVar.d;
                return;
            }
            return;
        }
        f fVar2 = (f) this.c;
        com.google.android.libraries.navigation.internal.sr.e eVar2 = (com.google.android.libraries.navigation.internal.sr.e) aVar;
        if (f.d(fVar2.a)) {
            l lVar = ((k) fVar2.d).a;
            com.google.android.libraries.navigation.internal.sr.f fVar3 = eVar2.a;
            if (lVar.c.k.i()) {
                return;
            }
            lVar.d.b(((com.google.android.libraries.navigation.internal.sr.n) eVar2.a).a);
            lVar.k.d();
        }
    }
}
