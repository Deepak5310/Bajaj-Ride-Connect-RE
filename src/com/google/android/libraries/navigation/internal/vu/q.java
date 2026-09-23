package com.google.android.libraries.navigation.internal.vu;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ r a;

    public q(r rVar) {
        this.a = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.oi.a aVar = this.a.j;
        if (aVar != null) {
            Boolean bool = (Boolean) mVar.c();
            ar.q(bool);
            aVar.y(bool.booleanValue());
        }
    }
}
