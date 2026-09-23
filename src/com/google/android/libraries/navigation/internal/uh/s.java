package com.google.android.libraries.navigation.internal.uh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ w a;

    public s(w wVar) {
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.ea.e eVar;
        Boolean bool = (Boolean) mVar.c();
        if (bool == null || (eVar = this.a.c) == null) {
            return;
        }
        if (eVar.g == bool.booleanValue()) {
            return;
        }
        if (bool.booleanValue()) {
            this.a.p();
        }
        this.a.b.h = bool.booleanValue();
        this.a.q();
    }
}
