package com.google.android.libraries.navigation.internal.tk;

import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public m(int i, Class cls, k kVar, ap apVar) {
        super(cls, kVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f == 0) {
            ((k) this.c).a((com.google.android.libraries.navigation.internal.sd.b) aVar);
            return;
        }
        k kVar = (k) this.c;
        com.google.android.libraries.navigation.internal.tl.b bVar = (com.google.android.libraries.navigation.internal.tl.b) aVar;
        l lVar = kVar.a;
        lVar.h = bVar.d;
        c cVar = lVar.d;
        boolean z = bVar.c;
        cVar.f = z;
        if (z) {
            cVar.i = 0L;
        }
        kVar.a.d.f();
        l lVar2 = kVar.a;
        if (lVar2.h) {
            q qVar = lVar2.c;
            qVar.k.post(qVar.q);
        }
    }
}
