package com.google.android.libraries.navigation.internal.qk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj extends ak {
    private final w a;
    private v b;
    private final com.google.android.libraries.navigation.internal.cs.a c;
    private boolean d = false;
    private final com.google.android.libraries.navigation.internal.cr.f e;

    public aj(w wVar, v vVar, com.google.android.libraries.navigation.internal.cr.f fVar, com.google.android.libraries.navigation.internal.cs.a aVar) {
        this.a = wVar;
        this.b = vVar;
        this.e = fVar;
        this.c = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final com.google.android.libraries.navigation.internal.op.g a() {
        return ((d) this.b).a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final r b() {
        return ((d) this.b).b;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final void c() {
        boolean z;
        synchronized (this) {
            d();
            z = this.d;
            this.d = true;
        }
        if (z) {
            return;
        }
        ((d) this.b).a.c();
        com.google.android.libraries.navigation.internal.cr.f fVar = this.e;
        if (fVar != null) {
            fVar.a(((d) this.b).a);
        }
    }

    public final synchronized void d() {
        if (!this.d) {
            this.a.a(((d) this.b).a.a());
            com.google.android.libraries.navigation.internal.cr.f fVar = this.e;
            if (fVar != null) {
                fVar.a(((d) this.b).a);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final synchronized void e(r rVar) {
        d();
        c cVar = new c(this.b);
        cVar.f(rVar);
        this.b = cVar.j();
        f();
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final synchronized void f() {
        com.google.android.libraries.navigation.internal.cs.a aVar;
        if (this.d) {
            return;
        }
        com.google.android.libraries.navigation.internal.cr.f fVar = this.e;
        if (fVar != null && (aVar = this.c) != null) {
            fVar.c(((d) this.b).a, aVar);
        }
        this.a.b(this.b);
    }
}
