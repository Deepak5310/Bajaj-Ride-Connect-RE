package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t {
    final /* synthetic */ x a;

    public t(x xVar) {
        this.a = xVar;
    }

    public final void a() {
        final x xVar = this.a;
        xVar.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.h
            @Override // java.lang.Runnable
            public final void run() {
                x xVar2 = xVar;
                dp dpVar = xVar2.q;
                if (dpVar != null && xVar2.f.d(dpVar.k)) {
                    xVar2.m();
                }
                dp dpVar2 = xVar2.p;
                if (dpVar2 == null || !xVar2.f.d(dpVar2.k)) {
                    return;
                }
                xVar2.l();
            }
        });
    }
}
