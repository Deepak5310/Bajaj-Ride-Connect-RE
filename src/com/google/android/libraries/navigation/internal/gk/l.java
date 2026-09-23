package com.google.android.libraries.navigation.internal.gk;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.ael.cy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements as {
    final /* synthetic */ cy a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gh.d b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.e c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.n d;
    final /* synthetic */ p e;

    public l(p pVar, cy cyVar, com.google.android.libraries.navigation.internal.gh.d dVar, com.google.android.libraries.navigation.internal.gg.e eVar, com.google.android.libraries.navigation.internal.gg.n nVar) {
        this.a = cyVar;
        this.b = dVar;
        this.c = eVar;
        this.d = nVar;
        this.e = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        if (this.e.g.isDone() || this.e.g(this.a)) {
            return;
        }
        p pVar = this.e;
        pVar.e(th, this.a, ((com.google.android.libraries.navigation.internal.gm.ao) pVar.c.a()).a(this.b), 1, this.c, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
