package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.aac.ac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements n, com.google.android.libraries.navigation.internal.nt.t {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    final /* synthetic */ o b;
    private long c = 0;
    private long d = 0;

    public i(o oVar, com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.b = oVar;
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        synchronized (this.b.i) {
            this.c++;
            com.google.android.libraries.navigation.internal.act.b bVar = (com.google.android.libraries.navigation.internal.act.b) mVar.c();
            if (bVar == null) {
                return;
            }
            long j = bVar.b;
            o oVar = this.b;
            boolean z = oVar.o < j;
            if (j != 0) {
                ((com.google.android.libraries.navigation.internal.kl.a) oVar.b.a()).b(com.google.android.libraries.navigation.internal.hw.a.s, z);
            }
            if (z) {
                this.d++;
                this.b.c(0L, com.google.android.libraries.navigation.internal.ir.a.SERVER_RESET_SIGNAL);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hr.n
    public final void b() {
        ((com.google.android.libraries.navigation.internal.iz.n) this.b.c.a()).d(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hr.h
            @Override // java.lang.Runnable
            public final void run() {
                i iVar = this.a;
                ((com.google.android.libraries.navigation.internal.nt.m) iVar.a.a()).e(iVar, ac.INSTANCE);
            }
        }, ac.INSTANCE, com.google.android.libraries.navigation.internal.iz.m.ON_STARTUP_FULLY_COMPLETE);
    }

    @Override // com.google.android.libraries.navigation.internal.hr.n
    public final void c() {
        ((com.google.android.libraries.navigation.internal.nt.m) this.a.a()).h(this);
    }
}
