package com.google.android.libraries.navigation.internal.cx;

import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public o(int i, Class cls, m mVar, ap apVar, Executor executor) {
        super(cls, mVar, apVar, executor);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            m mVar = (m) this.c;
            com.google.android.libraries.navigation.internal.cw.f fVar = (com.google.android.libraries.navigation.internal.cw.f) aVar;
            com.google.android.libraries.navigation.internal.cw.c cVar = fVar.a;
            com.google.android.libraries.navigation.internal.cw.c cVar2 = mVar.z;
            mVar.z = new com.google.android.libraries.navigation.internal.cw.c(fVar.a);
            if (mVar.A || !mVar.z.equals(cVar2)) {
                ((com.google.android.libraries.navigation.internal.fr.e) mVar.f.a()).e(com.google.android.libraries.navigation.internal.afl.l.NETWORK_TYPE_CHANGED, mVar.z.a());
                com.google.android.libraries.navigation.internal.ia.e eVar = mVar.d;
                com.google.android.libraries.navigation.internal.cw.c cVar3 = mVar.z;
                eVar.a(new com.google.android.libraries.navigation.internal.cw.e());
                mVar.A = false;
            }
            mVar.j();
            return;
        }
        if (i == 1) {
            throw null;
        }
        if (i == 2) {
            throw null;
        }
        if (i != 3) {
            throw null;
        }
        m mVar2 = (m) this.c;
        mVar2.u = ((com.google.android.libraries.navigation.internal.sq.a) aVar).a.a();
        mVar2.j();
    }
}
