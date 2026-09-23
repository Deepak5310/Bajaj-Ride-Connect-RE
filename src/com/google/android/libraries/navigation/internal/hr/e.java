package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.yx.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements n, com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ o a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public e(o oVar, com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = oVar;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.hj.i iVar = (com.google.android.libraries.navigation.internal.hj.i) mVar.c();
        synchronized (this.a.i) {
            if (am.a(this.a.l, iVar)) {
                return;
            }
            o oVar = this.a;
            oVar.l = iVar;
            oVar.l.d();
            this.a.c(0L, com.google.android.libraries.navigation.internal.ir.a.ACCOUNT_CHANGE);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hr.n
    public final void b() {
        ((com.google.android.libraries.navigation.internal.di.b) this.b.a()).e().e(this, ac.INSTANCE);
    }

    @Override // com.google.android.libraries.navigation.internal.hr.n
    public final void c() {
        ((com.google.android.libraries.navigation.internal.di.b) this.b.a()).e().h(this);
    }
}
