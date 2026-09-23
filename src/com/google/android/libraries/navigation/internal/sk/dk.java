package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dk implements a {
    final /* synthetic */ dp a;

    public dk(dp dpVar) {
        this.a = dpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.a
    public final void a(c cVar) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        this.a.q.n();
        dp dpVar = this.a;
        if (dpVar.j != null) {
            if (dpVar.r.get()) {
                this.a.j.b(com.google.android.libraries.navigation.internal.sl.b.b);
                return;
            }
            int iE = cVar.e();
            int i = iE - 1;
            if (iE == 0) {
                throw null;
            }
            if (i != 3) {
                this.a.j.b(com.google.android.libraries.navigation.internal.sl.b.c);
            } else {
                this.a.j.b(com.google.android.libraries.navigation.internal.sl.b.d);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.a
    public final void b(c cVar) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.sl.c cVar2 = this.a.j;
        if (cVar2 != null) {
            cVar2.a(cVar.a());
        }
        dp dpVar = this.a;
        dpVar.e.b(dpVar.k.a());
    }
}
