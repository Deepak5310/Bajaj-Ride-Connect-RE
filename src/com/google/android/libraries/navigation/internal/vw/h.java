package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.rw.aa;
import com.google.android.libraries.navigation.internal.rw.w;
import com.google.android.libraries.navigation.internal.rw.y;
import com.google.android.libraries.navigation.internal.xe.ff;
import com.google.android.libraries.navigation.internal.xe.fh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements w, aa, y {
    final /* synthetic */ j a;

    public h(j jVar) {
        this.a = jVar;
    }

    private final void c(com.google.android.libraries.navigation.internal.tj.o oVar) {
        synchronized (this.a) {
            j jVar = this.a;
            bg bgVar = jVar.k.e;
            jVar.s(oVar.a);
            j jVar2 = this.a;
            jVar2.q(jVar2.k, bgVar, jVar2.m);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        ff ffVar;
        c(oVar);
        if (!z || (ffVar = this.a.u) == null) {
            return;
        }
        ffVar.a(oVar.a.f());
    }

    @Override // com.google.android.libraries.navigation.internal.rw.w
    public final void b(int i) {
    }

    @Override // com.google.android.libraries.navigation.internal.rw.y
    public final void d(com.google.android.libraries.navigation.internal.tj.o oVar) {
        c(oVar);
        fh fhVar = this.a.v;
        if (fhVar != null) {
            fhVar.a();
        }
    }
}
