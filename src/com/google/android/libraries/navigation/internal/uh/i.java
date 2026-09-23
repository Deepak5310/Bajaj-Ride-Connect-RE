package com.google.android.libraries.navigation.internal.uh;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.bh;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements br {
    final /* synthetic */ l a;

    public i(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bd a() {
        l lVar = this.a;
        com.google.android.libraries.navigation.internal.ui.a aVar = lVar.o;
        if (aVar == null) {
            return bd.SHOW_NONE;
        }
        com.google.android.libraries.navigation.internal.ea.g gVar = aVar.d;
        if (gVar != null) {
            return ((com.google.android.libraries.navigation.internal.ea.b) gVar).b;
        }
        bd bdVar = lVar.i;
        if (bdVar != null) {
            return bdVar;
        }
        if (aVar.e != com.google.android.libraries.navigation.internal.ea.d.NO_SEARCH) {
            return bd.SHOW_NONE;
        }
        if (aVar.b() == al.WALK && ((bh) lVar.p.a()).d) {
            return bd.SHOW_NONE;
        }
        return lVar.c.k.i() ? bd.SHOW_ALL : bd.SHOW_ALTERNATES_ONLY;
    }
}
