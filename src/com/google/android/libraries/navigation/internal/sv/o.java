package com.google.android.libraries.navigation.internal.sv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements com.google.android.libraries.navigation.internal.sp.a {
    private final com.google.android.libraries.navigation.internal.iv.f a;
    private final com.google.android.libraries.navigation.internal.fj.a b;
    private boolean c;
    private int d = 0;

    public o(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fj.a aVar) {
        this.a = fVar;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.a
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.sp.a
    public final void b() {
        c();
    }

    public final void c() {
        if (this.c) {
            this.b.g();
            this.c = false;
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.bp.bg bgVar, double d) {
        this.c = false;
        String strI = this.a.i(com.google.android.libraries.navigation.internal.iv.ab.H, "0");
        if ("0".equals(strI)) {
            return;
        }
        float f = Float.parseFloat(strI);
        eVar.a(new com.google.android.libraries.navigation.internal.gz.d("Starting simulated drive.", com.google.android.libraries.navigation.internal.gz.c.PARTNERS));
        this.b.d(bgVar, f, d);
        this.c = true;
        this.d++;
    }
}
