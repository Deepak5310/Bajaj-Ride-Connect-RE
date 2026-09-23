package com.google.android.libraries.navigation.internal.gk;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.km.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.xn.a a;
    final /* synthetic */ int b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.n c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gm.an d;
    final /* synthetic */ cy e;
    final /* synthetic */ com.google.android.libraries.navigation.internal.zo.q f;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.e g;
    final /* synthetic */ p h;

    public n(p pVar, com.google.android.libraries.navigation.internal.xn.a aVar, int i, com.google.android.libraries.navigation.internal.gg.n nVar, com.google.android.libraries.navigation.internal.gm.an anVar, cy cyVar, com.google.android.libraries.navigation.internal.zo.q qVar, com.google.android.libraries.navigation.internal.gg.e eVar) {
        this.a = aVar;
        this.b = i;
        this.c = nVar;
        this.d = anVar;
        this.e = cyVar;
        this.f = qVar;
        this.g = eVar;
        this.h = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        com.google.android.libraries.navigation.internal.nw.e.f(this.a, this.b);
        com.google.android.libraries.navigation.internal.yt.a aVarB = com.google.android.libraries.navigation.internal.yt.d.b("GmmNetworkImpl.onFailure ", this.a);
        try {
            this.h.e(th, this.e, this.d, this.f.h, this.g, this.c);
            aVarB.close();
        } catch (Throwable th2) {
            try {
                aVarB.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        cy cyVar = (cy) obj;
        com.google.android.libraries.navigation.internal.nw.e.f(this.a, this.b);
        com.google.android.libraries.navigation.internal.yt.a aVarB = com.google.android.libraries.navigation.internal.yt.d.b("GmmNetworkImpl.onSuccess ", this.a);
        try {
            this.c.a(this.h.b);
            this.d.b();
            this.h.f(this.e, this.c.c.toMillis() - this.c.b.toMillis(), aq.SUCCESS, this.f.h);
            com.google.android.libraries.navigation.internal.gg.e eVar = this.g;
            if (eVar != null) {
                com.google.android.libraries.navigation.internal.gg.h hVar = new com.google.android.libraries.navigation.internal.gg.h();
                hVar.a = this.e;
                hVar.a(this.f.h);
                com.google.android.libraries.navigation.internal.gm.an anVar = this.d;
                hVar.b = anVar.o;
                hVar.c = anVar.f441n;
                hVar.d = anVar.p;
                hVar.e = this.c;
                eVar.b(new com.google.android.libraries.navigation.internal.gg.i(hVar), cyVar);
            }
            aVarB.close();
        } catch (Throwable th) {
            try {
                aVarB.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
