package com.google.android.libraries.navigation.internal.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements com.google.android.libraries.navigation.internal.qz.g {
    final /* synthetic */ com.google.android.libraries.navigation.internal.gw.x a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.bn.b b;
    final /* synthetic */ h c;

    public g(h hVar, com.google.android.libraries.navigation.internal.gw.x xVar, com.google.android.libraries.navigation.internal.bn.b bVar) {
        this.a = xVar;
        this.b = bVar;
        this.c = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final synchronized void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        final com.google.android.libraries.navigation.internal.nc.ah ahVarG;
        if (!kVar.p() || (ahVarG = kVar.g(this.a)) == null) {
            return;
        }
        h hVar = this.c;
        final com.google.android.libraries.navigation.internal.bn.b bVar = this.b;
        hVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.f
            @Override // java.lang.Runnable
            public final void run() {
                bVar.a(ahVarG);
            }
        });
    }
}
