package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    bg h;
    public boolean b = false;
    public boolean c = false;
    public long d = -5000;
    public long e = -5000;
    public final long f = -5000;
    public long g = -5000;
    private long i = -900;

    public o(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = aVar;
    }

    public static boolean e(long j, long j2) {
        return j - j2 >= 2000;
    }

    public static boolean f(long j, long j2) {
        return j - j2 >= 5000;
    }

    public final void a(long j, int i, double d) {
        bg bgVar;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        if (j - this.i >= 900 && e(j, this.g) && this.b && (bgVar = this.h) != null) {
            this.i = j;
            com.google.android.libraries.navigation.internal.acu.u uVar = (com.google.android.libraries.navigation.internal.acu.u) com.google.android.libraries.navigation.internal.acu.v.a.q();
            if (!uVar.b.H()) {
                uVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.v vVar = (com.google.android.libraries.navigation.internal.acu.v) uVar.b;
            vVar.b |= 1;
            vVar.c = i;
            if (!Double.isNaN(d)) {
                if (!uVar.b.H()) {
                    uVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.v vVar2 = (com.google.android.libraries.navigation.internal.acu.v) uVar.b;
                vVar2.b |= 2;
                vVar2.d = d;
            }
            com.google.android.libraries.navigation.internal.acu.av avVar = (com.google.android.libraries.navigation.internal.acu.av) com.google.android.libraries.navigation.internal.acu.aw.a.q();
            if (!avVar.b.H()) {
                avVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.aw awVar = (com.google.android.libraries.navigation.internal.acu.aw) avVar.b;
            awVar.b |= 1;
            awVar.e = j;
            if (!avVar.b.H()) {
                avVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.aw awVar2 = (com.google.android.libraries.navigation.internal.acu.aw) avVar.b;
            com.google.android.libraries.navigation.internal.acu.v vVar3 = (com.google.android.libraries.navigation.internal.acu.v) uVar.t();
            vVar3.getClass();
            awVar2.d = vVar3;
            awVar2.c = 6;
            bgVar.c((com.google.android.libraries.navigation.internal.acu.aw) avVar.t());
        }
    }

    public final void b(long j, int i, float f) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        a(j, i, this.c ? f : Double.NaN);
    }

    public final void c(long j, int i) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        a(j, i, Double.NaN);
    }

    public final void d(bg bgVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.h = bgVar;
    }
}
