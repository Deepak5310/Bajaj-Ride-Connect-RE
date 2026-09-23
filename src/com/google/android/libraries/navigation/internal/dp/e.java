package com.google.android.libraries.navigation.internal.dp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements l {
    final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    private final void h(com.google.android.libraries.navigation.internal.ql.a aVar) {
        this.a.c.execute(new d(this, aVar));
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final float a() {
        return this.a.g.a();
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final void c(boolean z) {
        if (z) {
            synchronized (this.a.b) {
                g gVar = this.a;
                ab abVar = gVar.f403n;
                if (abVar != null) {
                    com.google.android.libraries.navigation.internal.ql.a aVar = gVar.m;
                    if (abVar.f && aVar != com.google.android.libraries.navigation.internal.ql.a.OFF) {
                        abVar.d = aVar;
                    }
                }
            }
        }
        h(com.google.android.libraries.navigation.internal.ql.a.OFF);
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final void d() {
        h(com.google.android.libraries.navigation.internal.ql.a.OFF);
        synchronized (this.a.b) {
            g gVar = this.a;
            gVar.q = false;
            gVar.r = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final void e() {
        h(com.google.android.libraries.navigation.internal.ql.a.TRACKING);
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final boolean f(com.google.android.libraries.navigation.internal.oe.x xVar) {
        return this.a.g.s(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final int g() {
        return this.a.g.t();
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final com.google.android.libraries.navigation.internal.ql.a j() {
        return this.a.a();
    }
}
