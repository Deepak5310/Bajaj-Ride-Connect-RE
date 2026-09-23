package com.google.android.libraries.navigation.environment;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class be implements com.google.android.libraries.navigation.internal.oo.d {
    final /* synthetic */ com.google.android.libraries.navigation.internal.yx.an a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.fz.d b;

    public be(com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.fz.d dVar) {
        this.a = anVar;
        this.b = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oo.d
    public final com.google.android.libraries.navigation.internal.adi.af a() {
        return this.a.g() ? ((com.google.android.libraries.navigation.internal.om.p) this.a.c()).f() : this.b.A();
    }
}
