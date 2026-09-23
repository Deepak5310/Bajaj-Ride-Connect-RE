package com.google.android.libraries.navigation.environment;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private final com.google.android.libraries.navigation.internal.fq.f a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private int d = 0;

    public v(com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.a = fVar;
        this.b = aVar;
        this.c = aVar2;
    }

    private final synchronized void c() {
        if (this.d == 0) {
            com.google.android.libraries.navigation.internal.fq.f fVar = this.a;
            if (!fVar.e) {
                com.google.android.libraries.navigation.internal.kl.a aVar = fVar.c;
                com.google.android.libraries.navigation.internal.km.v vVar = com.google.android.libraries.navigation.internal.km.v.AUTO_PAN_MODE_ENABLED;
                aVar.l();
                fVar.e = true;
            }
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            com.google.android.libraries.navigation.internal.wz.c cVar = fVar.b;
            if (cVar != null) {
                cVar.a(fVar.f);
            }
            ((com.google.android.libraries.navigation.internal.jy.af) this.c.a()).k();
        }
    }

    private final synchronized void d() {
        if (this.d == 0) {
            ((com.google.android.libraries.navigation.internal.jy.af) this.c.a()).l();
            com.google.android.libraries.navigation.internal.fq.f fVar = this.a;
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            com.google.android.libraries.navigation.internal.wz.c cVar = fVar.b;
            if (cVar != null) {
                cVar.b(fVar.f);
            }
        }
    }

    public final synchronized void a() {
        c();
        if (this.d == 0) {
            ((com.google.android.libraries.navigation.internal.cw.a) this.b.a()).d();
        }
        this.d++;
    }

    public final synchronized void b() {
        this.d--;
        d();
        if (this.d == 0) {
            ((com.google.android.libraries.navigation.internal.cw.a) this.b.a()).e();
        }
    }
}
