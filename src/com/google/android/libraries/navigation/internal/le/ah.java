package com.google.android.libraries.navigation.internal.le;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah implements com.google.android.libraries.navigation.internal.lh.e {
    public final com.google.android.libraries.navigation.internal.ld.i a;
    public final i b;
    public com.google.android.libraries.navigation.internal.lh.al c = null;
    public Set d = null;
    public boolean e = false;
    final /* synthetic */ ai f;

    public ah(ai aiVar, com.google.android.libraries.navigation.internal.ld.i iVar, i iVar2) {
        this.f = aiVar;
        this.a = iVar;
        this.b = iVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.e
    public final void a(com.google.android.libraries.navigation.internal.lc.a aVar) {
        this.f.p.post(new ag(this, aVar));
    }

    public final void b(com.google.android.libraries.navigation.internal.lc.a aVar) {
        ae aeVar = (ae) this.f.m.get(this.b);
        if (aeVar != null) {
            aeVar.l(aVar);
        }
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.lh.al alVar;
        if (!this.e || (alVar = this.c) == null) {
            return;
        }
        this.a.k(alVar, this.d);
    }
}
