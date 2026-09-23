package com.google.android.libraries.navigation.internal.sk;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ dp a;

    public dc(dp dpVar) {
        this.a = dpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.d();
            return;
        }
        final dp dpVar = this.a;
        dpVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.cz
            @Override // java.lang.Runnable
            public final void run() {
                final dp dpVar2 = dpVar;
                dpVar2.s = new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.cw
                    @Override // java.lang.Runnable
                    public final void run() {
                        dp dpVar3 = dpVar2;
                        if (dpVar3.s != null) {
                            dpVar3.s = null;
                            dpVar3.e();
                        }
                    }
                };
                dpVar2.b.schedule(dpVar2.s, ((com.google.android.libraries.navigation.internal.sl.k) dpVar2.k.l).f, TimeUnit.MILLISECONDS);
            }
        });
    }
}
