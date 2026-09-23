package com.google.android.libraries.navigation.internal.uh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ w a;

    public q(w wVar) {
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Boolean bool = (Boolean) mVar.c();
        if (bool == null) {
            return;
        }
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.a.b).j = bool.booleanValue();
        com.google.android.libraries.navigation.internal.ea.e eVar = this.a.c;
        if (eVar == null || !((com.google.android.libraries.navigation.internal.ui.a) eVar).c() || ((com.google.android.libraries.navigation.internal.ui.a) this.a.c).i == bool.booleanValue()) {
            return;
        }
        this.a.q();
    }
}
