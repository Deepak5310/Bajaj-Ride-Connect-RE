package com.google.android.libraries.navigation.internal.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aq implements com.google.android.libraries.navigation.internal.qk.r {
    private final com.google.android.libraries.navigation.internal.oh.n a = new com.google.android.libraries.navigation.internal.oh.n();
    private final com.google.android.libraries.navigation.internal.oh.a b;

    public aq() {
        com.google.android.libraries.navigation.internal.oh.p.a aVar = new com.google.android.libraries.navigation.internal.oh.p.a();
        aVar.c(new com.google.android.libraries.navigation.internal.oh.l());
        aVar.c(new com.google.android.libraries.navigation.internal.oh.f());
        aVar.c(new com.google.android.libraries.navigation.internal.oh.b());
        this.b = aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.qk.p pVar) {
        com.google.android.libraries.navigation.internal.oe.x xVarA = qVar.a();
        com.google.android.libraries.navigation.internal.yx.ar.q(xVarA);
        return com.google.android.libraries.navigation.internal.oh.n.b(gVar, qVar, this.b, xVarA, pVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final /* synthetic */ boolean b(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.qk.p pVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        return a(gVar, qVar, pVar);
    }
}
