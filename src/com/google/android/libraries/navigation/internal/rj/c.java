package com.google.android.libraries.navigation.internal.rj;

import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.rl.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c implements com.google.android.libraries.navigation.internal.ot.e {
    public final dy a;
    public final w b;
    protected final d c;

    public c(dy dyVar, w wVar, d dVar) {
        this.a = dyVar;
        this.b = wVar;
        this.c = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.e
    public final Cdo b(com.google.android.libraries.navigation.internal.oo.f fVar) {
        return this.b.a(fVar).a();
    }

    @Override // com.google.android.libraries.navigation.internal.ot.e
    public final Object c() {
        ef efVar = (ef) this.a.t();
        w wVar = this.b;
        return this.c.a(efVar, wVar.b ? wVar.a : null);
    }
}
