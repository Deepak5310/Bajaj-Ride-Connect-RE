package com.google.android.libraries.navigation.internal.sv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.tj.r a;
    final /* synthetic */ g b;

    public f(g gVar, com.google.android.libraries.navigation.internal.tj.r rVar) {
        this.a = rVar;
        this.b = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        this.b.a.a(new com.google.android.libraries.navigation.internal.sr.m(this.a));
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.sx.as asVar = (com.google.android.libraries.navigation.internal.sx.as) obj;
        com.google.android.libraries.navigation.internal.bp.bh bhVarJ = asVar.b;
        if (!asVar.b() || bhVarJ.l()) {
            com.google.android.libraries.navigation.internal.tj.r.g(null);
        } else {
            if (!bhVarJ.k()) {
                bhVarJ = bhVarJ.j(0);
            }
            com.google.android.libraries.navigation.internal.tj.r.g(bhVarJ);
        }
        g gVar = this.b;
        gVar.a.a(new com.google.android.libraries.navigation.internal.sr.m(this.a));
    }
}
