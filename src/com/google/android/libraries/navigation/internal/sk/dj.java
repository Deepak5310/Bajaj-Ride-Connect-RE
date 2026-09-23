package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dj implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ dp a;

    public dj(dp dpVar) {
        this.a = dpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        c cVar = (c) obj;
        if (cVar == null) {
            this.a.c();
            return;
        }
        if (!this.a.t.get()) {
            this.a.t.set(true);
            if (!cVar.d()) {
                cVar.e();
                this.a.c();
                return;
            }
        }
        dp dpVar = this.a;
        com.google.android.libraries.navigation.internal.aac.az.o(com.google.android.libraries.navigation.internal.aac.j.i(dpVar.b(), new dh(dpVar, dpVar.k), dpVar.b), new di(this, cVar), this.a.a);
    }
}
