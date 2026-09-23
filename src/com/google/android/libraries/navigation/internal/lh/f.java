package com.google.android.libraries.navigation.internal.lh;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends ap {
    private k a;
    private final int b;

    public f(k kVar, int i) {
        this.a = kVar;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.aq
    public final void b(int i, IBinder iBinder, Bundle bundle) {
        be.k(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.w(i, iBinder, bundle, this.b);
        this.a = null;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.aq
    public final void c(int i, IBinder iBinder, r rVar) {
        k kVar = this.a;
        be.k(kVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        be.j(rVar);
        kVar.o = rVar;
        if (kVar.B()) {
            t tVar = rVar.d;
            bk.a().b(tVar == null ? null : tVar.a);
        }
        b(i, iBinder, rVar.a);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.aq
    public final void d() {
        new Exception();
    }
}
