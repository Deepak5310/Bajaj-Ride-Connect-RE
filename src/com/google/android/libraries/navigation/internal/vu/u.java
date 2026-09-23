package com.google.android.libraries.navigation.internal.vu;

import com.google.android.libraries.navigation.internal.bp.bh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ x a;

    public u(x xVar) {
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.vv.a aVar;
        com.google.android.libraries.navigation.internal.vs.a aVar2 = (com.google.android.libraries.navigation.internal.vs.a) mVar.c();
        x xVar = this.a;
        if (aVar2 == null || (aVar = aVar2.a) == com.google.android.libraries.navigation.internal.vv.a.a) {
            xVar.b = null;
            xVar.a = bh.b;
        } else {
            xVar.b = aVar.e;
            xVar.a = aVar.b;
            xVar.c = aVar2.b;
        }
        if (xVar.j) {
            return;
        }
        xVar.a();
    }
}
