package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public p(int i, Class cls, o oVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, oVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f == 0) {
            o oVar = (o) this.c;
            oVar.a.a();
            oVar.b = true;
            throw null;
        }
        o oVar2 = (o) this.c;
        com.google.android.libraries.navigation.internal.dh.ai aiVar = (com.google.android.libraries.navigation.internal.dh.ai) aVar;
        long jA = oVar2.a.a();
        oVar2.b = true;
        if (aiVar.f() && aiVar.c > 0.0f) {
            oVar2.c = true;
        }
        oVar2.e = jA;
        long j = oVar2.f;
        if (o.f(jA, -5000L)) {
            if (aiVar.f()) {
                oVar2.b(jA, aiVar.a, aiVar.c);
            } else {
                oVar2.c(jA, aiVar.a);
            }
        }
    }
}
