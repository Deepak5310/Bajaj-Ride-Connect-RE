package com.google.android.libraries.navigation.internal.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.ca a;
    final /* synthetic */ ar b;

    public ap(ar arVar, com.google.android.libraries.navigation.internal.aac.ca caVar) {
        this.a = caVar;
        this.b = arVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F('q')).p("A problem occurred while waiting for the PolylineStyles to become ready:");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.ol.ax axVar = (com.google.android.libraries.navigation.internal.ol.ax) this.b.c.a();
        ar arVar = this.b;
        this.a.d(((as) obj).b(new aq(arVar.p, (com.google.android.libraries.navigation.internal.on.h) arVar.a.a(), this.b.q, axVar)));
    }
}
