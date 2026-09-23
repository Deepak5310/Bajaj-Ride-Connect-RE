package com.google.android.libraries.navigation.internal.rf;

import com.google.android.libraries.navigation.internal.ob.o;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oq.h;
import com.google.android.libraries.navigation.internal.oq.j;
import com.google.android.libraries.navigation.internal.pb.t;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.oq.d {
    private final t a;
    private final o b;
    private final h c;

    public c(t tVar, o oVar) {
        this.a = tVar;
        this.b = oVar;
        this.c = new f(tVar.b, new b(tVar));
    }

    @Override // com.google.android.libraries.navigation.internal.oq.d
    public final com.google.android.libraries.navigation.internal.oq.f a() {
        com.google.android.libraries.navigation.internal.pd.d dVarW = this.a.w();
        r rVar = dVarW.i;
        com.google.android.libraries.navigation.internal.oq.e eVarG = com.google.android.libraries.navigation.internal.oq.f.g();
        eVarG.e(rVar);
        eVarG.j(dVarW.l);
        eVarG.k(dVarW.k);
        eVarG.h(dVarW.m);
        com.google.android.libraries.navigation.internal.pd.e eVar = dVarW.f515n;
        eVarG.i(j.c(eVar.b, eVar.c));
        return eVarG.l();
    }

    @Override // com.google.android.libraries.navigation.internal.oq.d
    public final h b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.d
    public final g c() {
        return new g(this.a);
    }
}
