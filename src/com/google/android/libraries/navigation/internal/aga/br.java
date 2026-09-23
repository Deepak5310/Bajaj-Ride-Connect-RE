package com.google.android.libraries.navigation.internal.aga;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class br implements dd {
    final u a;
    boolean b = false;
    final /* synthetic */ bt c;

    public br(bt btVar, u uVar) {
        this.c = btVar;
        this.a = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final com.google.android.libraries.navigation.internal.afx.c a(com.google.android.libraries.navigation.internal.afx.c cVar) {
        Iterator it2 = this.c.f.iterator();
        if (!it2.hasNext()) {
            return cVar;
        }
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void b(boolean z) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void c() {
        this.c.d.a(2, "READY");
        this.c.g.execute(new bo(this));
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void d(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        this.c.d.b(2, "{0} SHUTDOWN with {1}", this.a.b(), bt.j(clVar));
        this.b = true;
        this.c.g.execute(new bp(this, clVar));
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void e() {
        com.google.android.libraries.navigation.internal.yx.ar.l(this.b, "transportShutdown() must be called before transportTerminated().");
        this.c.d.b(2, "{0} Terminated", this.a.b());
        com.google.android.libraries.navigation.internal.afx.ag.b(this.c.c.d, this.a);
        bt btVar = this.c;
        btVar.g.execute(new bk(btVar, this.a, false));
        Iterator it2 = this.c.f.iterator();
        if (it2.hasNext()) {
            throw null;
        }
        bt btVar2 = this.c;
        btVar2.g.execute(new bq(this));
    }
}
