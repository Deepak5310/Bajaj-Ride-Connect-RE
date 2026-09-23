package com.google.android.libraries.navigation.internal.xe;

import android.content.res.Resources;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.google.android.libraries.navigation.internal.ub.k implements w {
    private final com.google.android.libraries.navigation.internal.pb.b v;
    private boolean w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(com.google.android.libraries.navigation.internal.uc.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.jy.t tVar, com.google.android.libraries.navigation.internal.ni.a aVar, Resources resources, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.og.b bVar, com.google.android.libraries.navigation.internal.p.a aVar2, com.google.android.libraries.navigation.internal.uh.p pVar, com.google.android.libraries.navigation.internal.dq.c cVar, Executor executor, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ue.c cVar2, com.google.android.libraries.navigation.internal.pb.b bVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.afo.a aVar4) {
        super(fVar, dVar, tVar, aVar, resources, kVar, bVar, aVar2, pVar, cVar, executor, sVar, cVar2, dVar.b().a.aU, com.google.android.libraries.navigation.internal.uc.t.a, aVar3, aVar4);
        ((com.google.android.libraries.navigation.internal.oo.b) aVar4.a()).h();
        this.v = bVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.ub.k
    protected final void A() {
    }

    @Override // com.google.android.libraries.navigation.internal.ub.k
    protected final boolean C(com.google.android.libraries.navigation.internal.oe.r rVar, boolean z) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.w
    public final void a(boolean z) {
        this.w = z;
    }

    @Override // com.google.android.libraries.navigation.internal.ub.k, com.google.android.libraries.navigation.internal.ub.c
    protected final com.google.android.libraries.navigation.internal.uc.n e(boolean z) {
        if (!this.w) {
            return com.google.android.libraries.navigation.internal.uc.n.b;
        }
        super.e(z);
        return com.google.android.libraries.navigation.internal.uc.n.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ub.c
    protected final void s(com.google.android.libraries.navigation.internal.ady.al alVar) {
        if (this.w) {
            super.s(alVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ub.c
    protected final void u(com.google.android.libraries.navigation.internal.pb.c cVar) {
        cVar.a(this.v);
    }
}
