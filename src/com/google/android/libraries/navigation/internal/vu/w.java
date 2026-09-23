package com.google.android.libraries.navigation.internal.vu;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        com.google.android.libraries.navigation.internal.rw.i iVar = (com.google.android.libraries.navigation.internal.rw.i) bVar;
        boolean z = iVar.c == com.google.android.libraries.navigation.internal.rw.p.GUIDING;
        if (z) {
            com.google.android.libraries.navigation.internal.tj.j jVar = iVar.d;
            ar.q(jVar);
            this.a.b = jVar.c().b;
            this.a.a = jVar.b();
        }
        if (this.a.j && !z) {
            this.a.a();
        }
        this.a.j = z;
    }
}
