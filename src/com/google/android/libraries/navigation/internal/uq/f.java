package com.google.android.libraries.navigation.internal.uq;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yz.fz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f {
    final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    public final void a(com.google.android.libraries.navigation.internal.tl.b bVar) {
        boolean z = bVar.d;
        g gVar = this.a;
        if (!z) {
            gVar.c();
            gVar.b(null);
        } else {
            if (gVar.d || !gVar.e) {
                return;
            }
            gVar.d = true;
            gVar.h.c(gVar.c, gVar.a);
            com.google.android.libraries.navigation.internal.ia.e eVar = gVar.b;
            d dVar = gVar.g;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.sr.m.class, new h(com.google.android.libraries.navigation.internal.sr.m.class, dVar, ap.UI_THREAD));
            eVar.c(dVar, fzVar.a());
        }
    }
}
