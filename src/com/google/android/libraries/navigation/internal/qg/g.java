package com.google.android.libraries.navigation.internal.qg;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.v;
import com.google.android.libraries.geo.mapcore.internal.model.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements w {
    final /* synthetic */ cd a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qi.f b;
    final /* synthetic */ cc c;
    final /* synthetic */ boolean d;
    final /* synthetic */ j e;

    public g(j jVar, cd cdVar, com.google.android.libraries.navigation.internal.qi.f fVar, cc ccVar, boolean z) {
        this.a = cdVar;
        this.b = fVar;
        this.c = ccVar;
        this.d = z;
        this.e = jVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.w
    public final void x(v vVar) {
        if (vVar == null) {
            this.e.m(this.a, this.d);
            return;
        }
        j jVar = this.e;
        jVar.h.execute(new i(jVar, jVar.k.l, jVar.d, this.a, this.b, vVar, this.c, this.d));
    }
}
