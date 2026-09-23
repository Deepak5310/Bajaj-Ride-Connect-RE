package com.google.android.libraries.navigation.internal.uh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ w a;

    public r(w wVar) {
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Boolean bool = (Boolean) mVar.c();
        if (bool != null) {
            this.a.b.a = bool.booleanValue();
            com.google.android.libraries.navigation.internal.ea.e eVar = this.a.c;
            if (eVar == null || !((com.google.android.libraries.navigation.internal.ui.a) eVar).c() || this.a.c.a == bool.booleanValue()) {
                return;
            }
            this.a.q();
        }
    }
}
