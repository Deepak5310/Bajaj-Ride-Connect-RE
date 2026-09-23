package com.google.android.libraries.navigation.internal.rj;

import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.ot.q;
import com.google.android.libraries.navigation.internal.rh.p;
import com.google.android.libraries.navigation.internal.rl.u;
import com.google.android.libraries.navigation.internal.rl.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.ot.h {
    public final p a;
    private final u b;

    public g(p pVar, u uVar) {
        this.a = pVar;
        this.b = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.h
    public final q a(ef efVar, com.google.android.libraries.navigation.internal.ot.g gVar) {
        return new i(efVar, gVar, null, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ot.h
    public final b b(final com.google.android.libraries.navigation.internal.ot.g gVar) {
        d dVar = new d() { // from class: com.google.android.libraries.navigation.internal.rj.e
            @Override // com.google.android.libraries.navigation.internal.rj.d
            public final Object a(ef efVar, com.google.android.libraries.navigation.internal.rl.d dVar2) {
                return new i(efVar, gVar, dVar2, this.a.a);
            }
        };
        return new b((dy) ef.a.q(), new w(this.b), dVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ot.h
    public final b c(com.google.android.libraries.navigation.internal.oo.f fVar, final com.google.android.libraries.navigation.internal.ot.g gVar) {
        d dVar = new d() { // from class: com.google.android.libraries.navigation.internal.rj.f
            @Override // com.google.android.libraries.navigation.internal.rj.d
            public final Object a(ef efVar, com.google.android.libraries.navigation.internal.rl.d dVar2) {
                return new i(efVar, gVar, dVar2, this.a.a);
            }
        };
        w wVar = new w(this.b);
        return new b(wVar.a(fVar).c(), wVar, dVar);
    }
}
