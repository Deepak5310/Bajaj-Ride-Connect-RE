package com.mappls.sdk.navigation.routing;

import com.mappls.sdk.navigation.s;

/* JADX INFO: loaded from: classes4.dex */
final class f implements Runnable {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.a.x;
        this.a.x.I0.get();
        sVar.getClass();
        this.a.x.I0.set((com.mappls.sdk.navigation.d) ((s.j) this.a.x.A0).get());
    }
}
