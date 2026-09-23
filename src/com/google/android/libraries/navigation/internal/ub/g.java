package com.google.android.libraries.navigation.internal.ub;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;

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
            if (fVar.u) {
                fVar.p();
                return;
            }
            return;
        }
        f fVar2 = (f) this.c;
        if (((com.google.android.libraries.navigation.internal.ds.a) aVar) != com.google.android.libraries.navigation.internal.ds.a.CANCEL || fVar2.q()) {
            return;
        }
        com.google.android.libraries.navigation.internal.dq.c cVar = fVar2.g;
        ar.q(cVar);
        cVar.e(com.google.android.libraries.navigation.internal.ql.a.OFF);
    }
}
